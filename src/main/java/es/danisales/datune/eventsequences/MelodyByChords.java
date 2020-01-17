package es.danisales.datune.eventsequences;

import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicChordMidiChecker;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.DurationMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;

import java.util.List;

public class MelodyByChords extends Melody {
    protected List<DiatonicChordMidi> chords;

    public MelodyByChords(List<DiatonicChordMidi> c) {
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
			super("No se pudo acceder al " + (t/ DurationMidi.L1 +1) + ":" + ((t % DurationMidi.L1) / (float) DurationMidi.L4 +1));
		}
	}

	public DiatonicMidi add(int t, int p, int d) {
		DiatonicChordMidi c = getChord(t);
        DiatonicMidi n = DiatonicChordMidiChecker.getFromBase(c, p).clone();
		n.setLength(d);

		notes.add(t, n);

		return n;
	}

	public Melody shiftOctave(int o) throws PitchMidiException {
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
			if (duration % DurationMidi.V1 == 0)
				es.getWithSemiAdded(duration, new KeySignatureEvent(s));

			es.getWithSemiAdded(duration, n);
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
