package eventsequences;

import java.util.ArrayList;

import diatonic.DiatonicFunction;
import diatonic.Degree;
import diatonic.Tonality;
import midi.Duration;
import midi.FigureLength;
import midi.Events.Event;
import midi.Events.KeySignatureEvent;
import midi.Settings.DefaultValues;
import pitch.DiatonicMidi;
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

	public DiatonicMidi add(Degree degree, int duration, int octaveShift) {
		DiatonicMidi nd = new DiatonicMidi(degree, tonality, octave + octaveShift);
		nd.setLength(duration);
		return add(nd);
	}

	public void show() {
		notesDiatonic.forEach((Event e) -> {System.out.println(e);});
	}

	public DiatonicMidi add(Degree degree, int duration) {
		return add(degree, duration, 0);
	}

	public DiatonicMidi add(Degree degree) {
		return add(degree, DefaultValues.OCTAVE);
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
	public Event duplicate(boolean b) {
		MelodyDiatonic md = new MelodyDiatonic(octave, tonality.duplicate());
		int d = 0;
		for (DiatonicMidi nd : notesDiatonic) {
			DiatonicMidi nd2 = (DiatonicMidi)nd.duplicate();
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
