package eventsequences;

import java.util.ArrayList;

import diatonic.DiatonicFunction;
import diatonic.DiatonicDegree;
import midi.Duration;
import midi.FigureLength;
import midi.Events.Event;
import midi.Events.KeySignatureEvent;
import midi.Settings.DefaultValues;
import musical.ChromaticChordEnum;
import pitch.DiatonicMidi;
import pitch.PitchChromaticChord;
import tonality.Tonality;
import pitch.DiatonicChordMidi;

public class MelodyDiatonic extends Melody {
	protected ArrayList<DiatonicMidi> notesDiatonic;
	protected Tonality tonality;
	protected int octave;

	public MelodyDiatonic() {
		this(DefaultValues.OCTAVE, null);
	}

	public MelodyDiatonic(int o, Tonality t) {
		super();
		
		notesDiatonic = new ArrayList<DiatonicMidi>();
		
		octave = o;
		if (t != null)
			setTonality(t);
	}
	
	public DiatonicMidi add(DiatonicMidi note) {
		notes.add(seek, note);
		notesDiatonic.add(note);
		seek += note.getLength();
		
		return note;
	}

	public DiatonicMidi add(DiatonicDegree degree, int duration, int octaveShift, int vel) {
		DiatonicMidi nd = DiatonicMidi.of(degree, tonality, octave + octaveShift, duration, vel);
		return add(nd);
	}

	public void show() {
		notesDiatonic.forEach((Event e) -> {System.out.println(e);});
	}

	public DiatonicMidi add(DiatonicDegree degree, int duration, int vel) {
		return add(degree, duration, 0, vel);
	}
	
	public DiatonicMidi add(DiatonicDegree degree, int duration) {
		return add(degree, duration, 0, DefaultValues.VELOCITY);
	}

	public DiatonicMidi add(DiatonicDegree degree) {
		return add(degree, DefaultValues.DURATION_NOTE, DefaultValues.VELOCITY);
	}

	public Melody setTonality(Tonality t) {
		assert t != null;
		tonality = t;

		for(DiatonicMidi nd : notesDiatonic)
			nd.setTonality(t);

		return this;
	}

	public Melody shiftOctave(int o) {
		for (DiatonicMidi c : notesDiatonic) {
			c.shiftOctave(o);
		}

		return this;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for(DiatonicMidi nd : notesDiatonic) {
			if (first)
				first = false;
			else
				sb.append("\n");
			sb.append(nd);
		}

		return sb.toString();
	}

	public EventSequence getEvents() {
		/*int duration = 0;
		for(NoteDiatonic n : notesDiatonic) {
			Tonality s = n.getTonality();
			if (duration % Duration.V1 == 0)
				notes.add(duration, new KeySignatureEvent(s));

			notes.add(duration, n);
			duration += n.getDuration();
		}*/

		return notes;
	}

	@Override
	public MelodyDiatonic clone() {
		MelodyDiatonic md = new MelodyDiatonic(octave, Tonality.of( tonality ));
		
		int d = 0;
		for (DiatonicMidi nd : notesDiatonic) {
			DiatonicMidi nd2 = (DiatonicMidi)nd.clone();
			//md.add(d, nd);
			md.notesDiatonic.add(nd2);
			d += nd2.getLength();
		}

		return md;
	}

	@Override
	public int getLength() {
		int d = 0;
		for (DiatonicMidi nd : notesDiatonic)
			d += nd.getLength();

		return d;
	}

	@Override
	public FigureLength setLength(int d) {
		// TODO Auto-generated method stub
		return null;
	}
}
