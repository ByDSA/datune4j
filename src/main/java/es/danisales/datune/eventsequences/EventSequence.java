package es.danisales.datune.eventsequences;

import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.midi.Durable;
import es.danisales.datune.midi.DurationMidi;
import es.danisales.datune.midi.binaries.Midi;
import es.danisales.datune.midi.binaries.events.*;
import es.danisales.datune.midi.pitch.PitchChromaticMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.io.binary.BinData;
import es.danisales.io.binary.BinEncoder;
import es.danisales.io.binary.BinSize;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Function;

public class EventSequence implements Durable, EventComplex {
	static {
		BinEncoder.register(EventSequence.class, (EventSequence self, BinEncoder.EncoderSettings settings) -> {
			EventSequence e = self.getBasicEvents();

			AtomicReference<Tonality> tonalityAtomicReference = new AtomicReference<>(null);
			AtomicLong last = new AtomicLong(0);

			e.getMap().forEach((Long key, ArrayList<Event> value) -> {
				int size = value.size();
				if (size == 0)
					return; // continue

				for (Event ev : value) {
					int delta = (int) (key - last.get());

					Event me = null;
					if (ev instanceof ChannelEvent) {
						me = ev;
						((ChannelEvent) me).setChannel(0); // TODO
					} else if (ev instanceof KeySignatureEvent) {
						KeySignatureEvent ks = ((KeySignatureEvent) ev);
						if (tonalityAtomicReference.get() != null
								&& !ks.getTonality().equals(tonalityAtomicReference.get())) {
							me = ks;
						} else
							tonalityAtomicReference.set(ks.getTonality());
					} else if (ev != null)
						me = ev;

					if (me != null) {
						last.set(key);
						if (ev instanceof ChunkData)
							((ChunkData) me).setDelta(delta);

						BinData.encoder()
								.from(me)
								.toStream(settings.getDataOutputStream(), settings.getByteArrayOutputStream())
								.putIntoStream();
					}
				}
			});
		});
		BinSize.register(EventSequence.class, (EventSequence self, BinEncoder.EncoderSettings settings) -> {
			return BinData.encoder().from(self).getBytes().length;
		});
	}

	protected TreeMap<Long, ArrayList<Event>>	map;
	protected int								duration;

	public EventSequence() {
		map = new TreeMap<>();
	}

	public void add(long time, Event event) {
		map.computeIfAbsent(time, k -> new ArrayList<>());
		map.get(time).add(event);
	}
	/*
	 * public void addFunction(long t, Class cl, Function f, long size) {
	 * Constructor con; try { con = cl.getConstructor(Integer.TYPE, Integer.TYPE);
	 * int step = Note.V64; for(int i = 0; i < size; i += step) { getWithSemiAdded(t+i,
	 * (Event)con.newInstance((int)(t+i), (int)( f.getAllFrom(((double)i)/size) ) ) ); }
	 * } catch (NoSuchMethodException | SecurityException | InstantiationException |
	 * IllegalAccessException | IllegalArgumentException | InvocationTargetException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */

	public TreeMap<Long, ArrayList<Event>> getMap() {
		return map;
	}

	public void forEach(Function<Event, Boolean> f) {
		for ( Iterator<Map.Entry<Long, ArrayList<Event>>> it = getMap().entrySet().iterator(); it
				.hasNext(); ) {
			Map.Entry<Long, ArrayList<Event>> entry = it.next();
			Long key = entry.getKey();
			ArrayList<Event> value = entry.getValue();
			for ( Event e : value )
				if ( !f.apply( e ) )
					return;
		}
	}

	public void forEach(BiFunction<Long, Event, Boolean> f) {
		for ( Iterator<Map.Entry<Long, ArrayList<Event>>> it = getMap().entrySet().iterator(); it
				.hasNext(); ) {
			Map.Entry<Long, ArrayList<Event>> entry = it.next();
			Long key = entry.getKey();
			ArrayList<Event> value = entry.getValue();
			for ( int i = 0; i < value.size(); i++ ) {
				Event e = value.get( i );
				if ( !f.apply( key, e ) )
					return;
			}
		}
	}

	public int size() {
		int n = 0;

		for ( Iterator<Map.Entry<Long, ArrayList<Event>>> it = getMap().entrySet().iterator(); it
				.hasNext(); ) {
			Map.Entry<Long, ArrayList<Event>> entry = it.next();
			Long key = entry.getKey();
			List<Event> value = entry.getValue();

			n += value.size();
		}
		return n;
	}

	public void remove(Long t) {
		map.remove( t );
	}

	public void show(long scale) {
		for ( Iterator<Map.Entry<Long, ArrayList<Event>>> it = getMap().entrySet().iterator(); it
				.hasNext(); ) {
			Map.Entry<Long, ArrayList<Event>> entry = it.next();
			Long key = entry.getKey();
			ArrayList<Event> value = entry.getValue();

			for ( Event e : value )
				System.out.println( ( ( (float) key ) / scale ) + ":\t" + e );
		}
	}

	public static ChromaticChordMidi whatNotesArePlaying(EventSequence es, long time) {
		assert time < es.getLength();
		ChromaticChordMidi notes = ChromaticChordMidi.builder().build();

		es.forEach( (Long t, Event ev) -> {
			if ( t > time )
				return false;

			if ( ev instanceof ChromaticMidi) {
				ChromaticMidi nc = (ChromaticMidi) ev;

				if ( t <= time && t + nc.getLength() > time ) {
					notes.add( nc );
				}
			}

			return true;
		} );

		return notes;
	}

	public EventSequence toNotes() {
		EventSequence es = new EventSequence();
		HashMap<Integer, Queue<Long>> notesOn = new HashMap<>();
		HashMap<Integer, Queue<NoteOn>> notesOnEvent = new HashMap<>();

		this.forEach( (time, ev) -> {
			float tf = time / (float) DurationMidi.L1;
			if ( ev instanceof NoteOn ) {
				int nc = ((NoteOn) ev).getMidiCode();
				assert nc >= 0;
				if ( notesOn.get( nc ) == null ) {
					Queue<Long> q1 = new LinkedList<Long>();
					q1.add( time );
					notesOn.put( nc, q1 );
					Queue<NoteOn> q2 = new LinkedList<NoteOn>();
					q2.add( (NoteOn) ev );
					notesOnEvent.put( nc, q2 );
				} else {
					notesOn.get( nc ).add( time );
					notesOnEvent.get( nc ).add( (NoteOn) ev );
				}

				assert notesOn.get( nc ) != null;
			} else if ( ev instanceof NoteOff ) {
				int nc = ((NoteOff) ev).getMidiCode();
				assert nc >= 0;

				Queue<NoteOn> evOnQueue = notesOnEvent.get( nc );
				Queue<Long> onTimeQueue = notesOn.get( nc );

				if ( evOnQueue != null && onTimeQueue != null ) {
                    PitchChromaticMidi pitchChromaticMidi;
                    try {
                        pitchChromaticMidi = PitchChromaticMidi.from(nc);
                    } catch (PitchMidiException e) {
                        e.printStackTrace();
                        throw new RuntimeException();
                    }
					NoteOn evOn = evOnQueue.poll();
					Long onTime = onTimeQueue.poll();
					ChromaticMidi n = ChromaticMidi.builder()
                            .pitch(pitchChromaticMidi)
							.length( (int) ( time - onTime ) )
							.velocity(evOn.getVelocity())
							.build();
					es.add( onTime, n );

					if ( evOnQueue.size() == 0 )
						notesOnEvent.remove( nc );
					if ( onTimeQueue.size() == 0 )
						notesOn.remove( nc );
				}
			}

			return true;
		} );

		assert notesOn.size() == 0 : notesOn.size();
		assert notesOnEvent.size() == 0 : notesOnEvent.size();

		return es;
	}

	@Override
	public int getLength() {
		int d = duration;
		for ( Iterator<Map.Entry<Long, ArrayList<Event>>> it = getMap().entrySet().iterator(); it
				.hasNext(); ) {
			Map.Entry<Long, ArrayList<Event>> entry = it.next();
			Long key = entry.getKey();
			ArrayList<Event> value = entry.getValue();

			for ( Event e : value )
				if ( e instanceof Durable ) {
					d = (int) Math.max( d, key + ( (Durable) e ).getLength() );
				}
		}

		return d;
	}

	@Override
	public void setLength(int d) {
		duration = d;
	}

	@Override
	public EventSequence getBasicEvents() {
		EventSequence events = new EventSequence();

		for ( Map.Entry<Long, ArrayList<Event>> entry : getMap().entrySet() ) {
			Long key = entry.getKey();
			ArrayList<Event> value = entry.getValue();

			for ( Event ev : value ) {
				if ( ev instanceof EventComplex || ev instanceof EventSequence ) {
					EventSequence e2;
					if ( ev instanceof EventComplex )
						e2 = ( (EventComplex) ev ).getBasicEvents();
					else
						e2 = ( (EventSequence) ev ).getBasicEvents();
					for ( Map.Entry<Long, ArrayList<Event>> entry2 : e2.getMap().entrySet() ) {
						Long key2 = entry2.getKey();
						ArrayList<Event> value2 = entry2.getValue();

						for ( Event ev2 : value2 ) {
							events.add( key + key2, ev2 );
						}
					}
				} else
					events.add( key, ev );
			}
		}

		return events;
	}

	public void add(EventSequence es) {
		for ( Map.Entry<Long, ArrayList<Event>> entry : es.getMap().entrySet() ) {
			Long key = entry.getKey();
			ArrayList<Event> value = entry.getValue();

			for ( Event e : value )
				add( key, e );
		}
	}

	@Override
	public EventSequence clone() {
		EventSequence es = new EventSequence();
		this.forEach( (time, ev) -> {
			es.add( time, ev.clone() );
			return true;
		} );
		return es;
	}

	@Override
	public EventSequence getEvents() {
		return this;
	}

	public void play() {
        Thread r = new Thread(() -> {
            AtomicLong lastTime = new AtomicLong(0);
            EventSequence s2 = getBasicEvents();
            s2.forEach((Long time, Event ev) -> {
                long diff = time - lastTime.get();
                if (diff > 0)
                    try {
                        Thread.sleep(diff);
                    } catch (InterruptedException e) {
                    }
                lastTime.set(time);
                if (ev instanceof NoteOn) {
                    NoteOn n = (NoteOn) ev;
					Midi.mChannels[0].noteOn(n.getMidiCode(), n.getVelocity());
                } else if (ev instanceof NoteOff) {
                    NoteOff n = (NoteOff) ev;
					Midi.mChannels[0].noteOff(n.getMidiCode());
                }

                return true;
            });
        });
		r.start();
	}
}
