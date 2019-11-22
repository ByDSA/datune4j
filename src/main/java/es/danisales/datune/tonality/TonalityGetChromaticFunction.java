package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.musical.*;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

class TonalityGetChromaticFunction {
	private static @Nullable ChromaticChordPattern getChromaticChordPatternFromChromaticFunction(@NonNull ChromaticFunction chromaticFunction) {
		switch (chromaticFunction) {
			case I:
			case II:
			case III:
			case IV:
			case V:
			case VI:
			case VII:
				return ChromaticChordPattern.TRIAD_MAJOR;
			case i:
			case ii:
			case iii:
			case iv:
			case v:
			case vi:
			case vii:
				return ChromaticChordPattern.TRIAD_MINOR;
			case I0:
			case II0:
			case III0:
			case IV0:
			case V0:
			case VI0:
			case VII0:
				return ChromaticChordPattern.TRIAD_DIMINISHED;
			case I5:
			case II5:
			case III5:
			case IV5:
			case V5:
			case VI5:
			case VII5:
				return ChromaticChordPattern.POWER_CHORD;
			case N6:
				return ChromaticChordPattern.N6;
			default:
				return null;
		}
	}

	private static @NonNull DiatonicFunction getDiatonicFunctionFromChromaticFunction(@NonNull ChromaticFunction chromaticFunction) {
		switch (chromaticFunction) {
			case V_II:
			case V_III:
			case V_IV:
			case V_V:
			case V_VI:
				return DiatonicFunction.V;
			case V7_II:
			case V7_III:
			case V7_IV:
			case V7_V:
			case V7_VI:
				return DiatonicFunction.V7;
			case SUBV7:
			case SUBV7_II:
			case SUBV7_III:
			case SUBV7_IV:
			case SUBV7_V:
			case SUBV7_VI:
			case V7ALT:
				return DiatonicFunction.I7;
			default:
				throw new RuntimeException();
		}
	}

	public static @NonNull ChromaticChord get(@NonNull Tonality tonality, @NonNull ChromaticFunction chromaticFunction) {
		Objects.requireNonNull(tonality);
		Objects.requireNonNull(chromaticFunction);

		switch (chromaticFunction) {
			case I:
			case II:
			case III:
			case IV:
			case V:
			case VI:
			case VII:
			case i:
			case ii:
			case iii:
			case iv:
			case v:
			case vi:
			case vii:
			case I0:
			case II0:
			case III0:
			case IV0:
			case V0:
			case VI0:
			case VII0:
			case I5:
			case II5:
			case III5:
			case IV5:
			case V5:
			case VI5:
			case VII5:
			case N6:
				DiatonicAlt noteBase = null;
				ChromaticChordPattern chromaticChordPattern = getChromaticChordPatternFromChromaticFunction(chromaticFunction);
				if (tonality.size() == Diatonic.NUMBER)
					noteBase = getNoteBaseFromChromaticFunctionAndTonality(tonality, chromaticFunction);

				Objects.requireNonNull(noteBase);
				Objects.requireNonNull(chromaticChordPattern);

				Chromatic noteBaseChromatic = Chromatic.from(noteBase);
				ChromaticChord ret = ChromaticChord.from(noteBaseChromatic, chromaticChordPattern);

				if (chromaticFunction == ChromaticFunction.N6)
					ret.setRootPos(2);

				return ret;
			case V_II:
			case V_III:
			case V_IV:
			case V_V:
			case V_VI:
			case V7_II:
			case V7_III:
			case V7_IV:
			case V7_V:
			case V7_VI:
			case SUBV7:
			case SUBV7_II:
			case SUBV7_III:
			case SUBV7_IV:
			case SUBV7_V:
			case SUBV7_VI:
			case V7ALT:
				DiatonicFunction diatonicFunction = getDiatonicFunctionFromChromaticFunction(chromaticFunction);
				tonality = getTonalityFromChromaticFunction(tonality, chromaticFunction);

				return ChromaticChord.from(tonality, diatonicFunction);
		}

		return null;
	}

	private static @NonNull Tonality getTonalityFromChromaticFunction(Tonality tonality, ChromaticFunction chromaticFunction) {
		switch (chromaticFunction) {
			case V_II:
			case V7_II:
				DiatonicAlt newRoot = tonality.getNote(DiatonicDegree.II);
				return Tonality.from(newRoot, tonality.getScale());
			case V_III:
			case V7_III:
				newRoot = tonality.getNote(DiatonicDegree.III);
				return Tonality.from(newRoot, tonality.getScale());
			case V_IV:
			case V7_IV:
				newRoot = tonality.getNote(DiatonicDegree.IV);
				return Tonality.from(newRoot, tonality.getScale());
			case V_V:
			case V7_V:
				newRoot = tonality.getNote(DiatonicDegree.V);
				return Tonality.from(newRoot, tonality.getScale());
			case V_VI:
			case V7_VI:
				newRoot = tonality.getNote(DiatonicDegree.VI);
				return Tonality.from(newRoot, tonality.getScale());
			case SUBV7:
				newRoot = tonality.getNote(DiatonicDegree.V);
				Chromatic newRootChromatic = Chromatic.from(newRoot).addSemi(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_II:
				ChromaticChord chromaticChord = ChromaticChord.from(tonality, ChromaticFunction.V7_II);
				newRootChromatic = chromaticChord.get(0).addSemi(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_III:
				chromaticChord = ChromaticChord.from(tonality, ChromaticFunction.V7_III);
				newRootChromatic = chromaticChord.get(0).addSemi(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_IV:
				chromaticChord = ChromaticChord.from(tonality, ChromaticFunction.V7_IV);
				newRootChromatic = chromaticChord.get(0).addSemi(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_V:
				chromaticChord = ChromaticChord.from(tonality, ChromaticFunction.V7_V);
				newRootChromatic = chromaticChord.get(0).addSemi(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case SUBV7_VI:
				chromaticChord = ChromaticChord.from(tonality, ChromaticFunction.V7_VI);
				newRootChromatic = chromaticChord.get(0).addSemi(6);
				return Tonality.from(newRootChromatic, Scale.LYDIAN_b7);
			case V7ALT:
				newRoot = tonality.getNote(DiatonicDegree.V);
				return Tonality.from(newRoot, Scale.SUPERLOCRIAN);
		}

		throw new RuntimeException();
	}

	private static @NonNull DiatonicAlt getNoteBaseFromChromaticFunctionAndTonality(Tonality tonality, @NonNull ChromaticFunction chromaticFunction) {
		switch (chromaticFunction) {
			case I:
			case i:
			case I0:
			case I5:
				return tonality.getNote(DiatonicDegree.I);
			case II:
			case ii:
			case II0:
			case II5:
				return tonality.getNote(DiatonicDegree.II);
			case III:
			case iii:
			case III0:
			case III5:
				return tonality.getNote(DiatonicDegree.III);
			case IV:
			case iv:
			case IV0:
			case IV5:
				return tonality.getNote(DiatonicDegree.IV);
			case V:
			case v:
			case V0:
			case V5:
				return tonality.getNote(DiatonicDegree.V);
			case VI:
			case vi:
			case VI0:
			case VI5:
				return tonality.getNote(DiatonicDegree.VI);
			case VII:
			case vii:
			case VII0:
			case VII5:
				return tonality.getNote(DiatonicDegree.VII);
			case N6:
				return tonality.getNote(DiatonicDegree.I);
		}

		throw new RuntimeException();
	}
}