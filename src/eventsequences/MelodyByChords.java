package eventsequences;

import java.util.ArrayList;

import midi.Duration;
import midi.FigureLength;
import midi.Events.Event;
import midi.Events.KeySignatureEvent;
import pitch.ChromaticMidi;
import pitch.DiatonicMidi;
import tonality.Tonality;
import pitch.DiatonicChordMidi;

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
		DiatonicMidi n = (DiatonicMidi)c.getFromBase(p).clone();
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
				es.add(duration, new KeySignatureEvent(s));

			es.add(duration, n);
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
	public FigureLength setLength(int d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}
}
