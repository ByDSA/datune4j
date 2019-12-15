package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.tonality.Tonality;
import es.danisales.io.binary.BinData;
import es.danisales.io.binary.BinSize;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public interface EventComplex extends Event {
	EventSequence getEvents();
	default EventSequence getBasicEvents() {
		EventSequence seq = new EventSequence();
		
		getEvents().getMap().forEach( ( Long key, ArrayList<Event> value ) -> {
			for(Event e : value) {
				if (e instanceof EventComplex) {
					EventSequence evs = ((EventComplex) e).getBasicEvents();

					evs.getMap().forEach( (Long key2, ArrayList<Event> value2 ) -> {
						for(Event e2 : value2) {
							seq.add(key+key2, e2);
						}
					});
				}
				else
					seq.add(key, e);
			}
		});

		return seq;
	}

	default int sizeBytes() {
		EventSequence e = getBasicEvents();
		AtomicInteger s = new AtomicInteger(0);
		e.getMap().forEach( (Long key, ArrayList<Event> value) -> {
			for (Event ev : value) {
				s.addAndGet(BinSize.getBinarySizeOf(ev));
			}
				
		});
		
		return s.get();
	}

	default void writeInto(DataOutputStream dataOutputStream, ByteArrayOutputStream byteArrayOutputStream) {
		EventSequence e = getBasicEvents();

        AtomicReference<Tonality> tonalityAtomicReference = new AtomicReference<>(null);
		AtomicLong last = new AtomicLong(0);

		e.getMap().forEach( (Long key, ArrayList<Event> value) -> {
			int size = value.size();
			if (size == 0)
				return; // continue

			for(Event ev : value) {
				int delta = (int)(key-last.get());

				Event me = null;
				if (ev instanceof ChannelEvent) {
                    me = ev;
					((ChannelEvent)me).setChannel(0); // TODO
				} else if (ev instanceof KeySignatureEvent) {
					KeySignatureEvent ks = ((KeySignatureEvent)ev);
                    if (tonalityAtomicReference.get() != null
                            && !ks.getTonality().equals(tonalityAtomicReference.get())) {
						me = ks;
					} else
                        tonalityAtomicReference.set(ks.getTonality());
                } else if (ev != null)
                    me = ev;

				if (me != null) {
					last.set( key );
					if (ev instanceof ChunkData)
						((ChunkData) me).setDelta(delta);

					BinData.encoder()
							.from(me)
							.toStream(dataOutputStream, byteArrayOutputStream)
							.putIntoStream();
				}
			}
		});
	}
}