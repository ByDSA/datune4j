package es.danisales.datune.midi.Events;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.tonality.Tonality;

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
	
	@Override
	default int sizeBytes() {
		EventSequence e = getBasicEvents();
		AtomicInteger s = new AtomicInteger(0);
		e.getMap().forEach( (Long key, ArrayList<Event> value) -> {
			for (Event ev : value) {
				s.addAndGet( ev.sizeBytes() );
			}
				
		});
		
		return s.get();
	}
	
	@Override
	default void read(ByteBuffer buff) {
		// TODO
	}

	@Override
	default void write(ByteBuffer buff) {
		EventSequence e = getBasicEvents();

		AtomicReference<Tonality> scale = new AtomicReference<Tonality>( null );
		AtomicLong last = new AtomicLong(0);

		e.getMap().forEach( (Long key, ArrayList<Event> value) -> {
			int size = value.size();
			if (size == 0)
				return; // continue

			for(Event ev : value) {
				int delta = (int)(key-last.get());

				Event me = null;
				if (ev instanceof ChannelEvent) {
					me = ((ChannelEvent) ev);
					((ChannelEvent)me).setChannel(0); // TODO
				} else if (ev instanceof KeySignatureEvent) {
					KeySignatureEvent ks = ((KeySignatureEvent)ev);
					if (scale != null && !ks.getScale().equals(scale)) {
						me = ks;
					} else
						scale.set( ks.getScale() );
				} else if (ev instanceof Event)
					me = (Event) ev;

				if (me != null) {
					last.set( key );
					if (ev instanceof ChunkData)
						((ChunkData) me).setDelta(delta);

					buff.put( me.getBytes() );
				}
			}
		});
	}
}