package es.danisales.datune.midi.binaries.events;

import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.io.binary.BinSize;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

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
}