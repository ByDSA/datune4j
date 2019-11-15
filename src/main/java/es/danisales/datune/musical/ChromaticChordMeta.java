package es.danisales.datune.musical;

import es.danisales.datune.diatonic.ChordNotation;
import es.danisales.datune.diatonic.Quality;

public class ChromaticChordMeta {
	public Quality	quality;
	String	str;
	boolean	updated;
	private ChromaticChordPattern pattern;
	
	public ChromaticChordMeta(Quality q, String str, ChromaticChordPattern pattern) {
		quality = q;
		this.str = str;
		updated = true;
		this.pattern = pattern;
	}

	public ChromaticChordPattern getPattern() {
		return pattern;
	}


	
	public ChromaticChordMeta() {
		updated = false;
	}
	
	public static final ChromaticChordMeta POWER_CHORD = new ChromaticChordMeta(Quality.INDETERMINATED, ChordNotation.POWER_CHORD, ChromaticChordPattern.POWER_CHORD);
	public static final ChromaticChordMeta TRIAD_MAJOR = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR, ChromaticChordPattern.TRIAD_MAJOR);
	public static final ChromaticChordMeta TRIAD_MINOR = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR, ChromaticChordPattern.TRIAD_MINOR);
	public static final ChromaticChordMeta TRIAD_DIMINISHED = new ChromaticChordMeta(Quality.DIMINISHED, ChordNotation.DIMINISHED, ChromaticChordPattern.TRIAD_DIMINISHED);
	public static final ChromaticChordMeta TRIAD_AUGMENTED = new ChromaticChordMeta(Quality.AUGMENTED, ChordNotation.AUGMENTED, ChromaticChordPattern.TRIAD_AUGMENTED);
	public static final ChromaticChordMeta SUS4 = new ChromaticChordMeta(Quality.INDETERMINATED, ChordNotation.SUS4, ChromaticChordPattern.SUS4);
	public static final ChromaticChordMeta SUS2 = new ChromaticChordMeta(Quality.INDETERMINATED, ChordNotation.SUS2, ChromaticChordPattern.SUS2);
	public static final ChromaticChordMeta SEVENTH = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.SEVENTH, ChromaticChordPattern.SEVENTH);
	public static final ChromaticChordMeta SEVENTH_MAJ7 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.SEVENTH, ChromaticChordPattern.SEVENTH_MAJ7);
	public static final ChromaticChordMeta SEVENTH_MINOR = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SEVENTH, ChromaticChordPattern.SEVENTH_MINOR);
	public static final ChromaticChordMeta SEVENTH_b5 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.b5, ChromaticChordPattern.SEVENTH_b5);
	public static final ChromaticChordMeta SEVENTH_MINOR_MAJ7 = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.SEVENTH, ChromaticChordPattern.SEVENTH_MINOR_MAJ7);
	public static final ChromaticChordMeta SEVENTH_a5 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.a5, ChromaticChordPattern.SEVENTH_a5);
	public static final ChromaticChordMeta SEVENTH_MINOR_a5 = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.a5, ChromaticChordPattern.SEVENTH_MINOR_a5);
	public static final ChromaticChordMeta SEVENTH_SUS4 = new ChromaticChordMeta(Quality.INDETERMINATED, ChordNotation.SEVENTH + ChordNotation.SUS4, ChromaticChordPattern.SEVENTH_SUS4);
	public static final ChromaticChordMeta SEVENTH_MINOR_b5 = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.b5, ChromaticChordPattern.SEVENTH_MINOR_b5);
	public static final ChromaticChordMeta SEVENTH_ADD11 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.ADD_ELEVENTH, ChromaticChordPattern.SEVENTH_ADD11);
	public static final ChromaticChordMeta SEVENTH_ADD13 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.ADD_THIRTEEN, ChromaticChordPattern.SEVENTH_ADD13);
	public static final ChromaticChordMeta SUS4a4 = new ChromaticChordMeta(Quality.INDETERMINATED, ChordNotation.SUSa4, ChromaticChordPattern.SUS4a4);
	public static final ChromaticChordMeta SUS2b2 = new ChromaticChordMeta(Quality.INDETERMINATED, ChordNotation.SUSb2, ChromaticChordPattern.SUS2b2);
	public static final ChromaticChordMeta SUS2b2b5 = new ChromaticChordMeta(Quality.INDETERMINATED, ChordNotation.SUSb2b5, ChromaticChordPattern.SUS2b2b5);
	public static final ChromaticChordMeta SEVENTH_b9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.b9, ChromaticChordPattern.SEVENTH_b9);
	public static final ChromaticChordMeta SEVENTH_a9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.a9, ChromaticChordPattern.SEVENTH_a9);
	public static final ChromaticChordMeta SEVENTH_MINOR_b9 = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.b9, ChromaticChordPattern.SEVENTH_MINOR_b9);
	public static final ChromaticChordMeta NINTH = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.NINTH, ChromaticChordPattern.NINTH);
	public static final ChromaticChordMeta NINTH_MINOR = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.NINTH, ChromaticChordPattern.NINTH_MINOR);
	public static final ChromaticChordMeta NINTH_b5 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.NINTH + ChordNotation.b5, ChromaticChordPattern.NINTH_b5);
	public static final ChromaticChordMeta NINTH_a5 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.NINTH + ChordNotation.a5, ChromaticChordPattern.NINTH_a5);
	public static final ChromaticChordMeta NINTH_SUS4 = new ChromaticChordMeta(Quality.INDETERMINATED, ChordNotation.NINTH + ChordNotation.SUS4, ChromaticChordPattern.NINTH_SUS4);
	public static final ChromaticChordMeta NINTH_MAJ9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.NINTH, ChromaticChordPattern.NINTH_MAJ9);
	public static final ChromaticChordMeta NINTH_MINOR_MAJ9 = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.NINTH, ChromaticChordPattern.NINTH_MINOR_MAJ9);
	public static final ChromaticChordMeta NINTH_ADD6 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.NINTH + ChordNotation.ADD_SIXTH, ChromaticChordPattern.NINTH_ADD6);
	public static final ChromaticChordMeta NINTH_a11 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.NINTH + ChordNotation.a11, ChromaticChordPattern.NINTH_a11);
	public static final ChromaticChordMeta NINTH_MAJ9_a11 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.NINTH + ChordNotation.a11, ChromaticChordPattern.NINTH_MAJ9_a11);
	public static final ChromaticChordMeta SIXTH = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.SIXTH, ChromaticChordPattern.SIXTH);
	public static final ChromaticChordMeta SIXTH_MINOR = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SIXTH, ChromaticChordPattern.SIXTH_MINOR);
	public static final ChromaticChordMeta SIXTH_SUS4 = new ChromaticChordMeta(Quality.INDETERMINATED, ChordNotation.SIXTH + ChordNotation.SUS4, ChromaticChordPattern.SIXTH_SUS4);
	public static final ChromaticChordMeta SIXTH_ADD9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.SIXTH + ChordNotation.ADD_NINTH, ChromaticChordPattern.SIXTH_ADD9);
	public static final ChromaticChordMeta SIXTH_MINOR_ADD9 = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SIXTH + ChordNotation.ADD_NINTH, ChromaticChordPattern.SIXTH_MINOR_ADD9);
	public static final ChromaticChordMeta ELEVENTH = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.ELEVENTH, ChromaticChordPattern.ELEVENTH);
	public static final ChromaticChordMeta ELEVENTH_MINOR = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.ELEVENTH, ChromaticChordPattern.ELEVENTH_MINOR);
	public static final ChromaticChordMeta ELEVENTH_b9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.ELEVENTH + ChordNotation.b9, ChromaticChordPattern.ELEVENTH_b9);
	public static final ChromaticChordMeta ELEVENTH_a9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.ELEVENTH + ChordNotation.a9, ChromaticChordPattern.ELEVENTH_a9);
	public static final ChromaticChordMeta ELEVENTH_MAJ11 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.ELEVENTH, ChromaticChordPattern.ELEVENTH_MAJ11);
	public static final ChromaticChordMeta ELEVENTH_MINOR_MAJ11 = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.ELEVENTH, ChromaticChordPattern.ELEVENTH_MINOR_MAJ11);
	public static final ChromaticChordMeta THIRTEENTH_MINOR = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.THIRTEEN, ChromaticChordPattern.THIRTEENTH_MINOR);
	public static final ChromaticChordMeta THIRTEENTH_SUS4 = new ChromaticChordMeta(Quality.INDETERMINATED, ChordNotation.THIRTEEN + ChordNotation.SUS4, ChromaticChordPattern.THIRTEENTH_SUS4);
	public static final ChromaticChordMeta THIRTEENTH_b5 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b5, ChromaticChordPattern.THIRTEENTH_b5);
	public static final ChromaticChordMeta THIRTEENTH_a5 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a5, ChromaticChordPattern.THIRTEENTH_a5);
	public static final ChromaticChordMeta THIRTEENTH_b9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_b9);
	public static final ChromaticChordMeta THIRTEENTH_a9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_a9);
	public static final ChromaticChordMeta THIRTEENTH_b5b9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_b5b9);
	public static final ChromaticChordMeta THIRTEENTH_b5a9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_b5a9);
	public static final ChromaticChordMeta THIRTEENTH_a5b9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_a5b9);
	public static final ChromaticChordMeta THIRTEENTH_a5a9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_a5a9);
	public static final ChromaticChordMeta THIRTEENTH_MAJ13 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN, ChromaticChordPattern.THIRTEENTH_MAJ13);
	public static final ChromaticChordMeta THIRTEENTH_MINOR_MAJ13 = new ChromaticChordMeta(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.THIRTEEN, ChromaticChordPattern.THIRTEENTH_MINOR_MAJ13);
	public static final ChromaticChordMeta THIRTEENTH_MAJ13_b5 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5, ChromaticChordPattern.THIRTEENTH_MAJ13_b5);
	public static final ChromaticChordMeta THIRTEENTH_MAJ13_a5 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5, ChromaticChordPattern.THIRTEENTH_MAJ13_a5);
	public static final ChromaticChordMeta THIRTEENTH_MAJ13_b9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_MAJ13_b9);
	public static final ChromaticChordMeta THIRTEENTH_MAJ13_a9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_MAJ13_a9);
	public static final ChromaticChordMeta THIRTEENTH_MAJ13_b5b9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_MAJ13_b5b9);
	public static final ChromaticChordMeta THIRTEENTH_MAJ13_b5a9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_MAJ13_b5a9);
	public static final ChromaticChordMeta THIRTEENTH_MAJ13_a5b9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_MAJ13_a5b9);
	public static final ChromaticChordMeta THIRTEENTH_MAJ13_a5a9 = new ChromaticChordMeta(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9);

	
}
