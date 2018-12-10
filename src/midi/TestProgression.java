package midi;

import diatonic.DiatonicFunction;
import eventsequences.Instrument;
import eventsequences.Melody;
import eventsequences.Track;
import midi.Progressions.Progression;
import pitch.DiatonicChordMidi;
import tonality.Tonality;

public class TestProgression extends Song {
	public Progression progression;
	public Track track;
	
	public TestProgression(Tonality s, int oct, int t) {
		this(s, oct, t, Instrument.PAD7_HALO);
	}
	
	public TestProgression(Tonality s, int oct) {
		this(s, oct, 120);
	}
	
	public TestProgression(Tonality s) {
		this(s, 5);
	}
	
	public TestProgression() {
		this(Settings.DefaultValues.TONALITY);
	}
	
	public TestProgression(Tonality s, int oct, int t, Instrument ins) {
		super("test_progression", t);
		tonality = s;

		track = createTrack(0, ins);
		
		progression = new Progression(tonality, oct);
		
		track.add(0, progression);
	}
	/*
	public ChordFunc add(Degree degree, IntervalDiatonic i) {
		return progression.add(degree, i);
	}
	*/
	public Melody add(Melody m) {
		track.add(m);
		return m;
	}
	
	public DiatonicChordMidi add(DiatonicFunction f, int o) {
		return progression.add(f, o);
	}
	
	public DiatonicChordMidi add(DiatonicFunction f) {
		return progression.add(f);
	}
}
