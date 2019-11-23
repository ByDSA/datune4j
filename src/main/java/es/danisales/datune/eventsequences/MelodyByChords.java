package es.danisales.datune.eventsequences;

import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.Duration;

import java.util.ArrayList;

public class MelodyByChords extends Melody {
	protected ArrayList<DiatonicChordMidi> chords;

	public MelodyByChords(ArrayList<DiatonicChordMidi> c) {
		chords = c;
	}

	public DiatonicChordMidi getChord(int t) throws OutOfTimeException {
		int count = 0;
		for (DiatonicChordMidi c : chords) {
			count += c.getLength();
			if (count > t)
				return c;
		}

		throw new OutOfTimeException(t);
	}
	
	public class OutOfTimeException extends RuntimeException {
		public OutOfTimeException(int t) {
			super("No se pudo acceder al " + (t/Duration.V1+1) + ":" + ((t % Duration.V1) / (float)Duration.V4+1));
		}
	}

	public DiatonicMidi add(int t, int p, int d) {
		DiatonicChordMidi c = getChord(t);
		DiatonicMidi n = c.getFromBase(p).clone();
		n.setLength(d);

		notes.add(t, n);

		return n;
	}

	public Melody shiftOctave(int o) {
		for (DiatonicChordMidi c : chords) {
			c.shiftOctave(o);
		}
		
		return this;
	}

	public EventSequence getEvents() {
		/*EventSequence es = new EventSequence();
		int duration = 0;
		for(Chord n : chords) {
			Tonality s = n.getTonality();
			if (duration % Duration.V1 == 0)
				es.addSemi(duration, new KeySignatureEvent(s));

			es.addSemi(duration, n);
			duration += n.getDuration();
		}
		
		return es;*/
		
		return notes;
	}

	@Override
	public MelodyByChords clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLength(int d) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}
}
