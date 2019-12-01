package es.danisales.datune.midi.others;

import es.danisales.datune.eventsequences.Instrument;
import es.danisales.datune.eventsequences.Melody;
import es.danisales.datune.eventsequences.Track;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.Progressions.Progression;
import es.danisales.datune.midi.Settings;
import es.danisales.datune.midi.binaries.Song;
import es.danisales.datune.tonality.Tonality;

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
	public ChordFunc getWithSemiAdded(Degree degree, IntervalDiatonic i) {
		return progression.getWithSemiAdded(degree, i);
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
