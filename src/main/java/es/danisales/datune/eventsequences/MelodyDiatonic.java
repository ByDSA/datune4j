package es.danisales.datune.eventsequences;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.Events.Event;
import es.danisales.datune.midi.PitchDiatonicMidi;
import es.danisales.datune.midi.Settings.DefaultValues;
import es.danisales.datune.tonality.Tonality;

import java.util.ArrayList;
import java.util.function.Consumer;

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

	public DiatonicMidi add(DiatonicDegree degree, int length, int octaveShift, int velocity) {
		PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(degree, tonality, octave + octaveShift);
		DiatonicMidi nd = DiatonicMidi.builder()
				.pitch(pitchDiatonicMidi)
				.length(length)
				.velocity(velocity)
				.build();

		return add(nd);
	}

	public void show() {
		notesDiatonic.forEach((Consumer<Event>) System.out::println);
	}

	public DiatonicMidi add(DiatonicDegree degree, int duration, int vel) {
		return add(degree, duration, 0, vel);
	}
	
	public DiatonicMidi add(DiatonicDegree degree, int duration) {
		return add(degree, duration, 0, DefaultValues.VELOCITY);
	}

	public DiatonicMidi add(DiatonicDegree degree) {
		return add(degree, DefaultValues.LENGTH_NOTE, DefaultValues.VELOCITY);
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
				notes.addSemi(duration, new KeySignatureEvent(s));

			notes.addSemi(duration, n);
			duration += n.getDuration();
		}*/

		return notes;
	}

	@Override
	public MelodyDiatonic clone() {
		MelodyDiatonic md = new MelodyDiatonic(octave, tonality.clone());
		
		int d = 0;
		for (DiatonicMidi nd : notesDiatonic) {
			DiatonicMidi nd2 = nd.clone();
			//md.addSemi(d, nd);
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
	public void setLength(int d) {
		// TODO Auto-generated method stub
	}
}
