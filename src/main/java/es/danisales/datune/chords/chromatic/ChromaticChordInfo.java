package es.danisales.datune.chords.chromatic;

import es.danisales.datune.chords.Quality;
import es.danisales.datune.lang.ChordNotation;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

final class ChromaticChordInfo implements Cloneable {
	private static final Map<ChromaticChordPattern, ChromaticChordInfo> metaMap = new HashMap<>();

	static final ChromaticChordInfo POWER_CHORD = new ChromaticChordInfo(Quality.INDETERMINATED, ChordNotation.POWER_CHORD, ChromaticChordPattern.POWER_CHORD);
	static final ChromaticChordInfo TRIAD_MAJOR = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR, ChromaticChordPattern.TRIAD_MAJOR);
	static final ChromaticChordInfo TRIAD_MINOR = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR, ChromaticChordPattern.TRIAD_MINOR);
	static final ChromaticChordInfo TRIAD_DIMINISHED = new ChromaticChordInfo(Quality.DIMINISHED, ChordNotation.DIMINISHED, ChromaticChordPattern.TRIAD_DIMINISHED);
	static final ChromaticChordInfo TRIAD_AUGMENTED = new ChromaticChordInfo(Quality.AUGMENTED, ChordNotation.AUGMENTED, ChromaticChordPattern.TRIAD_AUGMENTED);
	static final ChromaticChordInfo SUS4 = new ChromaticChordInfo(Quality.INDETERMINATED, ChordNotation.SUS4, ChromaticChordPattern.SUS4);
	static final ChromaticChordInfo SEVENTH = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.SEVENTH, ChromaticChordPattern.SEVENTH);
	static final ChromaticChordInfo SEVENTH_MAJ7 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.SEVENTH, ChromaticChordPattern.SEVENTH_MAJ7);
	static final ChromaticChordInfo SEVENTH_MINOR = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SEVENTH, ChromaticChordPattern.SEVENTH_MINOR);
	static final ChromaticChordInfo SEVENTH_b5 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.b5, ChromaticChordPattern.SEVENTH_b5);
	static final ChromaticChordInfo SEVENTH_MINOR_MAJ7 = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.SEVENTH, ChromaticChordPattern.SEVENTH_MINOR_MAJ7);
	static final ChromaticChordInfo SEVENTH_a5 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.a5, ChromaticChordPattern.SEVENTH_a5);
	static final ChromaticChordInfo SEVENTH_MINOR_a5 = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.a5, ChromaticChordPattern.SEVENTH_MINOR_a5);
	static final ChromaticChordInfo SEVENTH_SUS4 = new ChromaticChordInfo(Quality.INDETERMINATED, ChordNotation.SEVENTH + ChordNotation.SUS4, ChromaticChordPattern.SEVENTH_SUS4);
	static final ChromaticChordInfo SEVENTH_MINOR_b5 = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.b5, ChromaticChordPattern.SEVENTH_MINOR_b5);
	static final ChromaticChordInfo SEVENTH_ADD11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.ADD_ELEVENTH, ChromaticChordPattern.SEVENTH_ADD11);
	static final ChromaticChordInfo SEVENTH_ADD13 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.ADD_THIRTEEN, ChromaticChordPattern.SEVENTH_ADD13);
	static final ChromaticChordInfo SUS4a4 = new ChromaticChordInfo(Quality.INDETERMINATED, ChordNotation.SUSa4, ChromaticChordPattern.SUS4a4);
	static final ChromaticChordInfo SUS2b2 = new ChromaticChordInfo(Quality.INDETERMINATED, ChordNotation.SUSb2, ChromaticChordPattern.SUS2b2);
	static final ChromaticChordInfo SUS2b2b5 = new ChromaticChordInfo(Quality.INDETERMINATED, ChordNotation.SUSb2b5, ChromaticChordPattern.SUS2b2b5);
	static final ChromaticChordInfo SEVENTH_b9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.b9, ChromaticChordPattern.SEVENTH_b9);
	static final ChromaticChordInfo SEVENTH_a9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.SEVENTH + ChordNotation.a9, ChromaticChordPattern.SEVENTH_a9);
	static final ChromaticChordInfo SEVENTH_MINOR_b9 = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SEVENTH + ChordNotation.b9, ChromaticChordPattern.SEVENTH_MINOR_b9);
	static final ChromaticChordInfo NINTH = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.NINTH, ChromaticChordPattern.NINTH);
	static final ChromaticChordInfo NINTH_MINOR = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.NINTH, ChromaticChordPattern.NINTH_MINOR);
	static final ChromaticChordInfo NINTH_b5 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.NINTH + ChordNotation.b5, ChromaticChordPattern.NINTH_b5);
	static final ChromaticChordInfo NINTH_a5 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.NINTH + ChordNotation.a5, ChromaticChordPattern.NINTH_a5);
	static final ChromaticChordInfo NINTH_SUS4 = new ChromaticChordInfo(Quality.INDETERMINATED, ChordNotation.NINTH + ChordNotation.SUS4, ChromaticChordPattern.NINTH_SUS4);
	static final ChromaticChordInfo NINTH_MAJ9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.NINTH, ChromaticChordPattern.NINTH_MAJ9);
	static final ChromaticChordInfo NINTH_MINOR_MAJ9 = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.NINTH, ChromaticChordPattern.NINTH_MINOR_MAJ9);
	static final ChromaticChordInfo NINTH_ADD6 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.NINTH + ChordNotation.ADD_SIXTH, ChromaticChordPattern.NINTH_ADD6);
	static final ChromaticChordInfo NINTH_a11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.NINTH + ChordNotation.a11, ChromaticChordPattern.NINTH_a11);
	static final ChromaticChordInfo NINTH_MAJ9_a11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.NINTH + ChordNotation.a11, ChromaticChordPattern.NINTH_MAJ9_a11);
	static final ChromaticChordInfo SIXTH = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.SIXTH, ChromaticChordPattern.SIXTH);
	static final ChromaticChordInfo SIXTH_MINOR = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SIXTH, ChromaticChordPattern.SIXTH_MINOR);
	static final ChromaticChordInfo SIXTH_SUS4 = new ChromaticChordInfo(Quality.INDETERMINATED, ChordNotation.SIXTH + ChordNotation.SUS4, ChromaticChordPattern.SIXTH_SUS4);
	static final ChromaticChordInfo SIXTH_ADD9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.SIXTH + ChordNotation.ADD_NINTH, ChromaticChordPattern.SIXTH_ADD9);
	static final ChromaticChordInfo SIXTH_MINOR_ADD9 = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.SIXTH + ChordNotation.ADD_NINTH, ChromaticChordPattern.SIXTH_MINOR_ADD9);
	static final ChromaticChordInfo ELEVENTH = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.ELEVENTH, ChromaticChordPattern.ELEVENTH);
	static final ChromaticChordInfo ELEVENTH_MINOR = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.ELEVENTH, ChromaticChordPattern.ELEVENTH_MINOR);
	static final ChromaticChordInfo ELEVENTH_b9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.ELEVENTH + ChordNotation.b9, ChromaticChordPattern.ELEVENTH_b9);
	static final ChromaticChordInfo ELEVENTH_a9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.ELEVENTH + ChordNotation.a9, ChromaticChordPattern.ELEVENTH_a9);
	static final ChromaticChordInfo ELEVENTH_MAJ11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.ELEVENTH, ChromaticChordPattern.ELEVENTH_MAJ11);
	static final ChromaticChordInfo ELEVENTH_MINOR_MAJ11 = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.ELEVENTH, ChromaticChordPattern.ELEVENTH_MINOR_MAJ11);
	static final ChromaticChordInfo THIRTEENTH_MINOR = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.THIRTEEN, ChromaticChordPattern.THIRTEENTH_MINOR);
	static final ChromaticChordInfo THIRTEENTH_SUS4 = new ChromaticChordInfo(Quality.INDETERMINATED, ChordNotation.THIRTEEN + ChordNotation.SUS4, ChromaticChordPattern.THIRTEENTH_SUS4);
	static final ChromaticChordInfo THIRTEENTH_b5 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b5, ChromaticChordPattern.THIRTEENTH_b5);
	static final ChromaticChordInfo THIRTEENTH_a5 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a5, ChromaticChordPattern.THIRTEENTH_a5);
	static final ChromaticChordInfo THIRTEENTH_b9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_b9);
	static final ChromaticChordInfo THIRTEENTH_a9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_a9);
	static final ChromaticChordInfo THIRTEENTH_b5b9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_b5b9);
	static final ChromaticChordInfo THIRTEENTH_b5a9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_b5a9);
	static final ChromaticChordInfo THIRTEENTH_a5b9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_a5b9);
	static final ChromaticChordInfo THIRTEENTH_a5a9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_a5a9);
	static final ChromaticChordInfo THIRTEENTH_MAJ13 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN, ChromaticChordPattern.THIRTEENTH_MAJ13);
	static final ChromaticChordInfo THIRTEENTH_MINOR_MAJ13 = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.THIRTEEN, ChromaticChordPattern.THIRTEENTH_MINOR_MAJ13);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_b5 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5, ChromaticChordPattern.THIRTEENTH_MAJ13_b5);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_a5 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5, ChromaticChordPattern.THIRTEENTH_MAJ13_a5);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_b9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_MAJ13_b9);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_a9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_MAJ13_a9);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_b5b9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_MAJ13_b5b9);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_b5a9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_MAJ13_b5a9);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_a5b9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9, ChromaticChordPattern.THIRTEENTH_MAJ13_a5b9);

	static final ChromaticChordInfo THIRTEENTH_MAJ13_a5a9 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9, ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9);

	static final ChromaticChordInfo THIRTEENTH_MINOR_OMIT11 = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.THIRTEEN + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_MINOR_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_SUS4_OMIT11 = new ChromaticChordInfo(Quality.INDETERMINATED, ChordNotation.THIRTEEN + ChordNotation.SUS4 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_SUS4_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_b5_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_b5_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_a5_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_a5_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_b9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_b9_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_a9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_a9_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_b5b9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_b5b9_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_b5a9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_b5a9_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_a5b9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_a5b9_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_a5a9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_a5a9_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_MAJ13_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_MINOR_MAJ13_OMIT11 = new ChromaticChordInfo(Quality.MINOR, ChordNotation.MINOR2 + ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_MINOR_MAJ13_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_b5_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_MAJ13_b5_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_a5_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_MAJ13_a5_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_b9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_MAJ13_b9_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_a9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_MAJ13_a9_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_b5b9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.b9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_MAJ13_b5b9_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_b5a9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.b5 + ChordNotation.a9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_MAJ13_b5a9_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_a5b9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.b9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_MAJ13_a5b9_OMIT11);
	static final ChromaticChordInfo THIRTEENTH_MAJ13_a5a9_OMIT11 = new ChromaticChordInfo(Quality.MAJOR, ChordNotation.MAJOR2 + ChordNotation.THIRTEEN + ChordNotation.a5 + ChordNotation.a9 + ChordNotation.OMIT11, ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9_OMIT11);

	static {
		putMap(POWER_CHORD);
		putMap(TRIAD_MAJOR);
		putMap(TRIAD_MINOR);
		putMap(TRIAD_DIMINISHED);
		putMap(TRIAD_AUGMENTED);
		putMap(SUS4);
		putMap(SEVENTH);
		putMap(SEVENTH_MAJ7);
		putMap(SEVENTH_MINOR);
		putMap(SEVENTH_b5);
		putMap(SEVENTH_MINOR_MAJ7);
		putMap(SEVENTH_a5);
		putMap(SEVENTH_MINOR_a5);
		putMap(SEVENTH_SUS4);
		putMap(SEVENTH_MINOR_b5);
		putMap(SEVENTH_ADD11);
		putMap(SEVENTH_ADD13);
		putMap(SUS4a4);
		putMap(SUS2b2);
		putMap(SUS2b2b5);
		putMap(SEVENTH_b9);
		putMap(SEVENTH_a9);
		putMap(SEVENTH_MINOR_b9);
		putMap(NINTH);
		putMap(NINTH_MINOR);
		putMap(NINTH_b5);
		putMap(NINTH_a5);
		putMap(NINTH_SUS4);
		putMap(NINTH_MAJ9);
		putMap(NINTH_MINOR_MAJ9);
		putMap(NINTH_ADD6);
		putMap(NINTH_a11);
		putMap(NINTH_MAJ9_a11);
		putMap(SIXTH);
		putMap(SIXTH_MINOR);
		putMap(SIXTH_SUS4);
		putMap(SIXTH_ADD9);
		putMap(SIXTH_MINOR_ADD9);
		putMap(ELEVENTH);
		putMap(ELEVENTH_MINOR);
		putMap(ELEVENTH_b9);
		putMap(ELEVENTH_a9);
		putMap(ELEVENTH_MAJ11);
		putMap(ELEVENTH_MINOR_MAJ11);
		putMap(THIRTEENTH_MINOR);
		putMap(THIRTEENTH_SUS4);
		putMap(THIRTEENTH_b5);
		putMap(THIRTEENTH_a5);
		putMap(THIRTEENTH_b9);
		putMap(THIRTEENTH_a9);
		putMap(THIRTEENTH_b5b9);
		putMap(THIRTEENTH_b5a9);
		putMap(THIRTEENTH_a5b9);
		putMap(THIRTEENTH_a5a9);
		putMap(THIRTEENTH_MAJ13);
		putMap(THIRTEENTH_MINOR_MAJ13);
		putMap(THIRTEENTH_MAJ13_b5);
		putMap(THIRTEENTH_MAJ13_a5);
		putMap(THIRTEENTH_MAJ13_b9);
		putMap(THIRTEENTH_MAJ13_a9);
		putMap(THIRTEENTH_MAJ13_b5b9);
		putMap(THIRTEENTH_MAJ13_b5a9);
		putMap(THIRTEENTH_MAJ13_a5b9);
		putMap(THIRTEENTH_MAJ13_a5a9);
		putMap(THIRTEENTH_MINOR_OMIT11);
		putMap(THIRTEENTH_SUS4_OMIT11);
		putMap(THIRTEENTH_b5_OMIT11);
		putMap(THIRTEENTH_a5_OMIT11);
		putMap(THIRTEENTH_b9_OMIT11);
		putMap(THIRTEENTH_a9_OMIT11);
		putMap(THIRTEENTH_b5b9_OMIT11);
		putMap(THIRTEENTH_b5a9_OMIT11);
		putMap(THIRTEENTH_a5b9_OMIT11);
		putMap(THIRTEENTH_a5a9_OMIT11);
		putMap(THIRTEENTH_MAJ13_OMIT11);
		putMap(THIRTEENTH_MINOR_MAJ13_OMIT11);
		putMap(THIRTEENTH_MAJ13_b5_OMIT11);
		putMap(THIRTEENTH_MAJ13_a5_OMIT11);
		putMap(THIRTEENTH_MAJ13_b9_OMIT11);
		putMap(THIRTEENTH_MAJ13_a9_OMIT11);
		putMap(THIRTEENTH_MAJ13_b5b9_OMIT11);
		putMap(THIRTEENTH_MAJ13_b5a9_OMIT11);
		putMap(THIRTEENTH_MAJ13_a5b9_OMIT11);
		putMap(THIRTEENTH_MAJ13_a5a9_OMIT11);
	}

	private static void putMap(ChromaticChordInfo chromaticChordMeta) {
		metaMap.put(chromaticChordMeta.pattern, chromaticChordMeta);
	}

	private final Quality quality;
	private final String str;
	private final ChromaticChordPattern pattern;

	private ChromaticChordInfo(@NonNull Quality q, @NonNull String str, @NonNull ChromaticChordPattern pattern) {
		quality = q;
		this.str = str;
		this.pattern = ChromaticChordPattern.immutableOf(pattern);
	}

	private static ChromaticChord getFundamentalChordOf(ChromaticChord chromaticChord) {
		ChromaticChord chromaticChordTmp;
		if (chromaticChord.getRootIndex() > 0) {
			chromaticChordTmp = chromaticChord.clone();
			chromaticChordTmp.toFundamental();
		} else
			chromaticChordTmp = chromaticChord;

		return chromaticChordTmp;
	}

	public static @Nullable ChromaticChordInfo from(@NonNull ChromaticChord chromaticChord) {
		chromaticChord = getFundamentalChordOf(Objects.requireNonNull(chromaticChord));

		ChromaticChordPattern chromaticChordPattern = ChromaticChordPattern.from(chromaticChord);
		return metaMap.get(chromaticChordPattern);
	}

	@SuppressWarnings("WeakerAccess")
	public Quality getQuality() {
		return quality;
	}

	@SuppressWarnings("WeakerAccess")
	public ChromaticChordPattern getPattern() {
		return ChromaticChordPattern.immutableOf(pattern);
	}

	@SuppressWarnings("WeakerAccess")
	public String getSuffix() {
		return str;
	}
}
