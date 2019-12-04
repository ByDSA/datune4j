package es.danisales.datune.tonality;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.DiatonicChordPattern;

public class TonalityGetDiatonicFunctionDefault {
    public static ChromaticChord get(Tonality tonality, DiatonicFunction diatonicFunction) throws ScaleDegreeException {
        DiatonicAlt noteBase = getNoteBaseFrom(tonality, diatonicFunction);
        DiatonicChordPattern diatonicChordPattern = getDiatonicChordPatternFrom(diatonicFunction);

        if (noteBase == null || diatonicChordPattern == null)
            throw new RuntimeException(tonality + " " +diatonicFunction.toString());

        Chromatic noteBaseChromatic = Chromatic.from(noteBase);
        return ChromaticChord.builder()
                .chromaticBase(noteBaseChromatic)
                .diatonicChordPattern(diatonicChordPattern)
                .tonality(tonality)
                .build();
    }

    private static DiatonicAlt getNoteBaseFrom(Tonality tonality, DiatonicFunction diatonicFunction) throws ScaleDegreeException {
        switch (diatonicFunction) {
            case I:
            case I2:
            case I4:
            case I6:
            case I7:
            case I9:
            case I11:
            case I13:
            case I_SECOND:
            case I_THIRD:
            case I_FOURTH:
            case I6_O5:
            case I7_O3:
            case I7_O5:
            case I9_O7:
            case I9_O3_O7:
                return tonality.getNote(DiatonicDegree.I);
            case II:
            case II2:
            case II4:
            case II6:
            case II7:
            case II9:
            case II11:
            case II13:
            case II_SECOND:
            case II_THIRD:
            case II_FOURTH:
            case II6_O5:
            case II7_O3:
            case II7_O5:
            case II9_O7:
            case II9_O3_O7:
                return tonality.getNote(DiatonicDegree.II);
            case III:
            case III2:
            case III4:
            case III6:
            case III7:
            case III9:
            case III11:
            case III13:
            case III_SECOND:
            case III_THIRD:
            case III_FOURTH:
            case III6_O5:
            case III7_O3:
            case III7_O5:
            case III9_O7:
            case III9_O3_O7:
                return tonality.getNote(DiatonicDegree.III);
            case IV:
            case IV2:
            case IV4:
            case IV6:
            case IV7:
            case IV9:
            case IV11:
            case IV13:
            case IV_SECOND:
            case IV_THIRD:
            case IV_FOURTH:
            case IV6_O5:
            case IV7_O3:
            case IV7_O5:
            case IV9_O7:
            case IV9_O3_O7:
                return tonality.getNote(DiatonicDegree.IV);
            case V:
            case V2:
            case V4:
            case V6:
            case V7:
            case V9:
            case V11:
            case V13:
            case V_SECOND:
            case V_THIRD:
            case V_FOURTH:
            case V6_O5:
            case V7_O3:
            case V7_O5:
            case V9_O7:
            case V9_O3_O7:
                return tonality.getNote(DiatonicDegree.V);
            case VI:
            case VI2:
            case VI4:
            case VI6:
            case VI7:
            case VI9:
            case VI11:
            case VI13:
            case VI_SECOND:
            case VI_THIRD:
            case VI_FOURTH:
            case VI6_O5:
            case VI7_O3:
            case VI7_O5:
            case VI9_O7:
            case VI9_O3_O7:
                return tonality.getNote(DiatonicDegree.VI);
            case VII:
            case VII2:
            case VII4:
            case VII6:
            case VII7:
            case VII9:
            case VII11:
            case VII13:
            case VII_SECOND:
            case VII_THIRD:
            case VII_FOURTH:
            case VII6_O5:
            case VII7_O3:
            case VII7_O5:
            case VII9_O7:
            case VII9_O3_O7:
                return tonality.getNote(DiatonicDegree.VII);
        }

        return null;
    }

    private static DiatonicChordPattern getDiatonicChordPatternFrom(DiatonicFunction diatonicFunction) {
        switch (diatonicFunction) {
            case I:
            case II:
            case III:
            case IV:
            case V:
            case VI:
            case VII:
                return DiatonicChordPattern.TRIAD;
            case I2:
            case II2:
            case III2:
            case IV2:
            case V2:
            case VI2:
            case VII2:
                return DiatonicChordPattern.SUS2;
            case I4:
            case II4:
            case III4:
            case IV4:
            case V4:
            case VI4:
            case VII4:
                return DiatonicChordPattern.SUS4;
            case I6:
            case II6:
            case III6:
            case IV6:
            case V6:
            case VI6:
            case VII6:
            case I7:
            case II7:
            case III7:
            case IV7:
            case V7:
            case VI7:
            case VII7:
                return DiatonicChordPattern.SEVENTH;
            case I9:
            case II9:
            case III9:
            case IV9:
            case V9:
            case VI9:
            case VII9:
                return DiatonicChordPattern.NINTH;
            case I11:
            case II11:
            case III11:
            case IV11:
            case V11:
            case VI11:
            case VII11:
                return DiatonicChordPattern.ELEVENTH;
            case I13:
            case II13:
            case III13:
            case IV13:
            case V13:
            case VI13:
            case VII13:
                return DiatonicChordPattern.THIRTEENTH;
            case I_SECOND:
            case II_SECOND:
            case III_SECOND:
            case IV_SECOND:
            case V_SECOND:
            case VI_SECOND:
            case VII_SECOND:
                return DiatonicChordPattern.from(0, IntervalDiatonic.SECOND.ordinal());
            case I_THIRD:
            case II_THIRD:
            case III_THIRD:
            case IV_THIRD:
            case V_THIRD:
            case VI_THIRD:
            case VII_THIRD:
                return DiatonicChordPattern.from(0, IntervalDiatonic.THIRD.ordinal());
            case I_FOURTH:
            case II_FOURTH:
            case III_FOURTH:
            case IV_FOURTH:
            case V_FOURTH:
            case VI_FOURTH:
            case VII_FOURTH:
                return DiatonicChordPattern.from(0, IntervalDiatonic.FOURTH.ordinal());
            case I6_O5:
            case II6_O5:
            case III6_O5:
            case IV6_O5:
            case V6_O5:
            case VI6_O5:
            case VII6_O5:
                return DiatonicChordPattern.SIXTH_O5;
            case I7_O5:
            case II7_O5:
            case III7_O5:
            case IV7_O5:
            case V7_O5:
            case VI7_O5:
            case VII7_O5:
                return DiatonicChordPattern.SEVENTH_O5;
            case I7_O3:
            case II7_O3:
            case III7_O3:
            case IV7_O3:
            case V7_O3:
            case VI7_O3:
            case VII7_O3:
                return DiatonicChordPattern.SEVENTH_O3;
            case I9_O7:
            case II9_O7:
            case III9_O7:
            case IV9_O7:
            case V9_O7:
            case VI9_O7:
            case VII9_O7:
                return DiatonicChordPattern.NINTH_O7;
            case I9_O3_O7:
            case II9_O3_O7:
            case III9_O3_O7:
            case IV9_O3_O7:
            case V9_O3_O7:
            case VI9_O3_O7:
            case VII9_O3_O7:
                return DiatonicChordPattern.NINTH_O3_O7;
        }

        return null;
    }
}
