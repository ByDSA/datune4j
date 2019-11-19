package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicChordPattern;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.Objects;

class TonalityGetChromaticFunctionMinor {
	public static @Nullable ChromaticChord get(@NonNull TonalityEnum tonalityEnum, @NonNull ChromaticFunction chromaticFunction) {
		Objects.requireNonNull(tonalityEnum);
		Objects.requireNonNull(chromaticFunction);

		switch (tonalityEnum) {
			case C:
				switch (chromaticFunction) {

				}

		}

		return null;
	}
}
