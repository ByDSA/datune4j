package es.danisales.datune.tonality;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.chords.DiatonicChordPattern;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;

class TonalityGetDiatonicFunctionMinor {
    public static @Nullable ChromaticChord get(Tonality t, DiatonicFunction f) {
        if (t.equals(Tonality.Cm)) {
            switch (f) {
                case I:
                    return ChromaticChord.Cm;
                case II:
                    return ChromaticChord.Ddim;
                case III:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA))
                            .build();
                case IV:
                    return ChromaticChord.Fm;
                case V:
                    return ChromaticChord.Gm;
                case VI:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case VII:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F))
                            .build();
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.GG))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.AA))
                            .build();
                case III6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C))
                            .build();
                case IV6:
                    return ChromaticChord.Fm6;
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.DD))
                            .build();
                case VI6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F))
                            .build();
                case VII6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G))
                            .build();
                case I7:
                    return ChromaticChord.Cm7;
                case II7:
                    return ChromaticChord.Dm7b5;
                case III7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D))
                            .build();
                case IV7:
                    return ChromaticChord.Fm7;
                case V7:
                    return ChromaticChord.Gm7;
                case VI7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G))
                            .build();
                case VII7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG))
                            .build();
                case I9:
                    return ChromaticChord.Cm9;
                case II9:
                    return ChromaticChord.builder().chromaticBase(Chromatic.D)
                            .diatonicChordPattern(DiatonicChordPattern.NINTH)
                            .tonality(t)
                            .build();
                case III9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F))
                            .build();
                case IV9:
                    return ChromaticChord.Fm9;
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG))
                            .build();
                case VI9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA))
                            .build();
                case VII9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case I11:
                    return ChromaticChord.Cm11;
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G))
                            .build();
                case III11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG))
                            .build();
                case IV11:
                    return ChromaticChord.Fm11;
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D))
                            .build();
                case VII11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case IV13:
                    return ChromaticChord.Fm13;
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.D))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.DD))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.F))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.G))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.GG))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.AA))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.C))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.F))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.G))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.GG))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.AA))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.C))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.D))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.DD))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.GG))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.AA))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.C))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.D))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.DD))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.F))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.G))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.D))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.G))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.GG))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.GG, Chromatic.C))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.D))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.G))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.D))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.DD))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.F))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.G))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.GG))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.AA))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.C))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.GG, Chromatic.DD))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.GG))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C))
                            .build();
            }
        } else if (t.equals(Tonality.CCm)) {
            switch (f) {
                case I:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case II:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A))
                            .build();
                case III:
                    return ChromaticChord.E;
                case IV:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC))
                            .build();
                case V:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case VI:
                    return ChromaticChord.A;
                case VII:
                    return ChromaticChord.B;
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.A))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.B))
                            .build();
                case III6:
                    return ChromaticChord.E6;
                case IV6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD))
                            .build();
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.E))
                            .build();
                case VI6:
                    return ChromaticChord.A6;
                case VII6:
                    return ChromaticChord.B6;
                case I7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B))
                            .build();
                case II7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC))
                            .build();
                case III7:
                    return ChromaticChord.EMaj7;
                case IV7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E))
                            .build();
                case V7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF))
                            .build();
                case VI7:
                    return ChromaticChord.AMaj7;
                case VII7:
                    return ChromaticChord.B7;
                case I9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case II9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E))
                            .build();
                case III9:
                    return ChromaticChord.EMaj9;
                case IV9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A))
                            .build();
                case VI9:
                    return ChromaticChord.AMaj9;
                case VII9:
                    return ChromaticChord.B9;
                case I11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF))
                            .build();
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case III11:
                    return ChromaticChord.EMaj11;
                case IV11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B))
                            .build();
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case VII11:
                    return ChromaticChord.B11;
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC))
                            .build();
                case IV13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.DD))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.E))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.FF))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.GG))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.A))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.B))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.CC))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.FF))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.GG))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.A))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.B))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.CC))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.DD))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.E))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.A))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.B))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.CC))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.DD))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.E))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.FF))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.GG))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.DD))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.GG))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.A))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.A, Chromatic.CC))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.DD))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.GG))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.DD))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.E))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.FF))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.GG))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.A))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.B))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.CC))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.A, Chromatic.E))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.A))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC))
                            .build();
            }
        } else if (t.equals(Tonality.Dm)) {
            switch (f) {
                case I:
                    return ChromaticChord.Dm;
                case II:
                    return ChromaticChord.Edim;
                case III:
                    return ChromaticChord.F;
                case IV:
                    return ChromaticChord.Gm;
                case V:
                    return ChromaticChord.Am;
                case VI:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F))
                            .build();
                case VII:
                    return ChromaticChord.C;
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.C))
                            .build();
                case III6:
                    return ChromaticChord.F6;
                case IV6:
                    return ChromaticChord.Gm6;
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.F))
                            .build();
                case VI6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G))
                            .build();
                case VII6:
                    return ChromaticChord.C6;
                case I7:
                    return ChromaticChord.Dm7;
                case II7:
                    return ChromaticChord.Em7b5;
                case III7:
                    return ChromaticChord.FMaj7;
                case IV7:
                    return ChromaticChord.Gm7;
                case V7:
                    return ChromaticChord.Am7;
                case VI7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A))
                            .build();
                case VII7:
                    return ChromaticChord.C7;
                case I9:
                    return ChromaticChord.Dm9;
                case II9:
                    return ChromaticChord.builder()
                            .chromaticBase(Chromatic.E)
                            .diatonicChordPattern(DiatonicChordPattern.NINTH)
                            .tonality(t)
                            .build();
                case III9:
                    return ChromaticChord.FMaj9;
                case IV9:
                    return ChromaticChord.Gm9;
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA))
                            .build();
                case VI9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C))
                            .build();
                case VII9:
                    return ChromaticChord.C9;
                case I11:
                    return ChromaticChord.Dm11;
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A))
                            .build();
                case III11:
                    return ChromaticChord.FMaj11;
                case IV11:
                    return ChromaticChord.Gm11;
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E))
                            .build();
                case VII11:
                    return ChromaticChord.C11;
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D))
                            .build();
                case IV13:
                    return ChromaticChord.Gm13;
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.E))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.F))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.G))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.A))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.AA))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.C))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.D))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.G))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.A))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.AA))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.C))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.D))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.E))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.F))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.AA))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.D))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.E))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.F))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.G))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.A))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.E))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.A))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.AA))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.AA, Chromatic.D))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.E))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.A))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.E))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.F))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.G))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.A))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.AA))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.C))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.D))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.AA, Chromatic.F))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.AA))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D))
                            .build();
            }
        } else if (t.equals(Tonality.Ebm) || t.equals(Tonality.DDm)) {
            switch (f) {
                case I:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case II:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B))
                            .build();
                case III:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case IV:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case V:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case VI:
                    return ChromaticChord.B;
                case VII:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.B))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.CC))
                            .build();
                case III6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD))
                            .build();
                case IV6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F))
                            .build();
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.FF))
                            .build();
                case VI6:
                    return ChromaticChord.B6;
                case VII6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA))
                            .build();
                case I7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case II7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case III7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case IV7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF))
                            .build();
                case V7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case VI7:
                    return ChromaticChord.BMaj7;
                case VII7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B))
                            .build();
                case I9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case II9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF))
                            .build();
                case III9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case IV9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B))
                            .build();
                case VI9:
                    return ChromaticChord.BMaj9;
                case VII9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case I11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case III11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B))
                            .build();
                case IV11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case VII11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF))
                            .build();
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case IV13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.F))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.FF))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.GG))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.AA))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.B))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.CC))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.DD))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.GG))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.AA))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.B))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.CC))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.DD))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.F))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.FF))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.B))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.CC))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.DD))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.F))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.FF))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.GG))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.AA))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.F))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.AA))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.B))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.B, Chromatic.DD))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.F))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.AA))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.F))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.FF))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.GG))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.AA))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.B))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.CC))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.DD))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.B, Chromatic.FF))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.B))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD))
                            .build();
            }
        } else if (t.equals(Tonality.Em)) {
            switch (f) {
                case I:
                    return ChromaticChord.Em;
                case II:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C))
                            .build();
                case III:
                    return ChromaticChord.G;
                case IV:
                    return ChromaticChord.Am;
                case V:
                    return ChromaticChord.Bm;
                case VI:
                    return ChromaticChord.C;
                case VII:
                    return ChromaticChord.D;
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.C))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.D))
                            .build();
                case III6:
                    return ChromaticChord.G6;
                case IV6:
                    return ChromaticChord.Am6;
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.G))
                            .build();
                case VI6:
                    return ChromaticChord.C6;
                case VII6:
                    return ChromaticChord.D6;
                case I7:
                    return ChromaticChord.Em7;
                case II7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E))
                            .build();
                case III7:
                    return ChromaticChord.GMaj7;
                case IV7:
                    return ChromaticChord.Am7;
                case V7:
                    return ChromaticChord.Bm7;
                case VI7:
                    return ChromaticChord.CMaj7;
                case VII7:
                    return ChromaticChord.D7;
                case I9:
                    return ChromaticChord.Em9;
                case II9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G))
                            .build();
                case III9:
                    return ChromaticChord.GMaj9;
                case IV9:
                    return ChromaticChord.Am9;
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C))
                            .build();
                case VI9:
                    return ChromaticChord.CMaj9;
                case VII9:
                    return ChromaticChord.D9;
                case I11:
                    return ChromaticChord.Em11;
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B))
                            .build();
                case III11:
                    return ChromaticChord.GMaj11;
                case IV11:
                    return ChromaticChord.Am11;
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF))
                            .build();
                case VII11:
                    return ChromaticChord.D11;
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E))
                            .build();
                case IV13:
                    return ChromaticChord.Am13;
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.FF))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.G))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.A))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.B))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.C))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.D))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.E))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.A))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.B))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.C))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.D))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.E))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.FF))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.G))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.D))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.E))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.FF))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.G))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.A))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.B))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.FF))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.B))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.C))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.C, Chromatic.E))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.FF))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.B))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.FF))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.G))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.A))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.B))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.C))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.D))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.E))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.C, Chromatic.G))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.C))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E))
                            .build();
            }
        } else if (t.equals(Tonality.Fm)) {
            switch (f) {
                case I:
                    return ChromaticChord.Fm;
                case II:
                    return ChromaticChord.Gdim;
                case III:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case IV:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case V:
                    return ChromaticChord.Cm;
                case VI:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case VII:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA))
                            .build();
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.CC))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.DD))
                            .build();
                case III6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F))
                            .build();
                case IV6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G))
                            .build();
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.GG))
                            .build();
                case VI6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA))
                            .build();
                case VII6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C))
                            .build();
                case I7:
                    return ChromaticChord.Fm7;
                case II7:
                    return ChromaticChord.Gm7b5;
                case III7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G))
                            .build();
                case IV7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case V7:
                    return ChromaticChord.Cm7;
                case VI7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case VII7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC))
                            .build();
                case I9:
                    return ChromaticChord.Fm9;
                case II9:
                    return ChromaticChord.builder()
                            .chromaticBase(Chromatic.G)
                            .diatonicChordPattern(DiatonicChordPattern.NINTH)
                            .tonality(t)
                            .build();
                case III9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA))
                            .build();
                case IV9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC))
                            .build();
                case VI9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case VII9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case I11:
                    return ChromaticChord.Fm11;
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case III11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC))
                            .build();
                case IV11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G))
                            .build();
                case VII11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case IV13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G))
                            .build();
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.G))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.GG))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.AA))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.C))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.CC))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.DD))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.F))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.AA))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.C))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.CC))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.DD))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.F))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.G))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.GG))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.CC))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.DD))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.F))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.G))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.GG))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.AA))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.C))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.G))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.C))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.CC))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.CC, Chromatic.F))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.G))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.C))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.G))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.GG))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.AA))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.C))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.CC))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.DD))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.F))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.CC, Chromatic.GG))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.CC))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F))
                            .build();
            }
        } else if (t.equals(Tonality.FFm)) {
            switch (f) {
                case I:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC))
                            .build();
                case II:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D))
                            .build();
                case III:
                    return ChromaticChord.A;
                case IV:
                    return ChromaticChord.Bm;
                case V:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case VI:
                    return ChromaticChord.D;
                case VII:
                    return ChromaticChord.E;
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.D))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.E))
                            .build();
                case III6:
                    return ChromaticChord.A6;
                case IV6:
                    return ChromaticChord.Bm6;
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.A))
                            .build();
                case VI6:
                    return ChromaticChord.D6;
                case VII6:
                    return ChromaticChord.E6;
                case I7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E))
                            .build();
                case II7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF))
                            .build();
                case III7:
                    return ChromaticChord.AMaj7;
                case IV7:
                    return ChromaticChord.Bm7;
                case V7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B))
                            .build();
                case VI7:
                    return ChromaticChord.DMaj7;
                case VII7:
                    return ChromaticChord.E7;
                case I9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case II9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A))
                            .build();
                case III9:
                    return ChromaticChord.AMaj9;
                case IV9:
                    return ChromaticChord.Bm9;
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D))
                            .build();
                case VI9:
                    return ChromaticChord.DMaj9;
                case VII9:
                    return ChromaticChord.E9;
                case I11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B))
                            .build();
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC))
                            .build();
                case III11:
                    return ChromaticChord.AMaj11;
                case IV11:
                    return ChromaticChord.Bm11;
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case VII11:
                    return ChromaticChord.E11;
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF))
                            .build();
                case IV13:
                    return ChromaticChord.Bm13;
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.GG))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.A))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.B))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.CC))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.D))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.E))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.FF))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.B))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.CC))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.D))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.E))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.FF))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.GG))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.A))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.D))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.E))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.FF))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.GG))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.A))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.B))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.CC))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.GG))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.CC))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.D))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.D, Chromatic.FF))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.GG))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.CC))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.GG))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.A))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.B))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.CC))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.D))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.E))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.FF))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.D, Chromatic.A))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.D))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF))
                            .build();
            }
        } else if (t.equals(Tonality.Gm)) {
            switch (f) {
                case I:
                    return ChromaticChord.Gm;
                case II:
                    return ChromaticChord.Adim;
                case III:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F))
                            .build();
                case IV:
                    return ChromaticChord.Cm;
                case V:
                    return ChromaticChord.Dm;
                case VI:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA))
                            .build();
                case VII:
                    return ChromaticChord.F;
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.DD))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.F))
                            .build();
                case III6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G))
                            .build();
                case IV6:
                    return ChromaticChord.Cm6;
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA))
                            .build();
                case VI6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C))
                            .build();
                case VII6:
                    return ChromaticChord.F6;
                case I7:
                    return ChromaticChord.Gm7;
                case II7:
                    return ChromaticChord.Am7b5;
                case III7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A))
                            .build();
                case IV7:
                    return ChromaticChord.Cm7;
                case V7:
                    return ChromaticChord.Dm7;
                case VI7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D))
                            .build();
                case VII7:
                    return ChromaticChord.F7;
                case I9:
                    return ChromaticChord.Gm9;
                case II9:
                    return ChromaticChord.builder()
                            .chromaticBase(Chromatic.A)
                            .diatonicChordPattern(DiatonicChordPattern.NINTH)
                            .tonality(t)
                            .build();
                case III9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C))
                            .build();
                case IV9:
                    return ChromaticChord.Cm9;
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD))
                            .build();
                case VI9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F))
                            .build();
                case VII9:
                    return ChromaticChord.F9;
                case I11:
                    return ChromaticChord.Gm11;
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D))
                            .build();
                case III11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD))
                            .build();
                case IV11:
                    return ChromaticChord.Cm11;
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A))
                            .build();
                case VII11:
                    return ChromaticChord.F11;
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G))
                            .build();
                case IV13:
                    return ChromaticChord.Cm13;
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.A))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.AA))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.C))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.D))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.DD))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.F))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.G))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.C))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.D))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.DD))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.F))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.G))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.A))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.AA))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.DD))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.F))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.G))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.A))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.AA))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.C))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.D))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.A))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.D))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.DD))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.DD, Chromatic.G))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.A))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.D))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.A))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.AA))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.C))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.D))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.DD))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.F))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.G))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.DD, Chromatic.AA))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.DD))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G))
                            .build();
            }
        } else if (t.equals(Tonality.GGm)) {
            switch (f) {
                case I:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case II:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E))
                            .build();
                case III:
                    return ChromaticChord.B;
                case IV:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case V:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case VI:
                    return ChromaticChord.E;
                case VII:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.E))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.FF))
                            .build();
                case III6:
                    return ChromaticChord.B6;
                case IV6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA))
                            .build();
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.B))
                            .build();
                case VI6:
                    return ChromaticChord.E6;
                case VII6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD))
                            .build();
                case I7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF))
                            .build();
                case II7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case III7:
                    return ChromaticChord.BMaj7;
                case IV7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B))
                            .build();
                case V7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case VI7:
                    return ChromaticChord.EMaj7;
                case VII7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E))
                            .build();
                case I9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case II9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B))
                            .build();
                case III9:
                    return ChromaticChord.BMaj9;
                case IV9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E))
                            .build();
                case VI9:
                    return ChromaticChord.EMaj9;
                case VII9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case I11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case III11:
                    return ChromaticChord.BMaj11;
                case IV11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF))
                            .build();
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case VII11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B))
                            .build();
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG))
                            .build();
                case IV13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.AA))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.B))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.CC))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.DD))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.E))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.FF))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.GG))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.CC))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.DD))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.E))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.FF))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.GG))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.AA))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.B))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.E))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.FF))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.GG))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.AA))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.B))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.CC))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.DD))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.AA))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.DD))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.E))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.E, Chromatic.GG))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.AA))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.DD))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.AA))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.B))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.CC))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.DD))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.E))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.FF))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.GG))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.E, Chromatic.B))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.E))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG))
                            .build();
            }
        } else if (t.equals(Tonality.Am)) {
            switch (f) {
                case I:
                    return ChromaticChord.Am;
                case II:
                    return ChromaticChord.Bdim;
                case III:
                    return ChromaticChord.C;
                case IV:
                    return ChromaticChord.Dm;
                case V:
                    return ChromaticChord.Em;
                case VI:
                    return ChromaticChord.F;
                case VII:
                    return ChromaticChord.G;
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.F))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.G))
                            .build();
                case III6:
                    return ChromaticChord.C6;
                case IV6:
                    return ChromaticChord.Dm6;
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.C))
                            .build();
                case VI6:
                    return ChromaticChord.F6;
                case VII6:
                    return ChromaticChord.G6;
                case I7:
                    return ChromaticChord.Am7;
                case II7:
                    return ChromaticChord.Bm7b5;
                case III7:
                    return ChromaticChord.CMaj7;
                case IV7:
                    return ChromaticChord.Dm7;
                case V7:
                    return ChromaticChord.Em7;
                case VI7:
                    return ChromaticChord.FMaj7;
                case VII7:
                    return ChromaticChord.G7;
                case I9:
                    return ChromaticChord.Am9;
                case II9:
                    return ChromaticChord.builder()
                            .chromaticBase(Chromatic.B)
                            .diatonicChordPattern(DiatonicChordPattern.NINTH)
                            .tonality(t)
                            .build();
                case III9:
                    return ChromaticChord.CMaj9;
                case IV9:
                    return ChromaticChord.Dm9;
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F))
                            .build();
                case VI9:
                    return ChromaticChord.FMaj9;
                case VII9:
                    return ChromaticChord.G9;
                case I11:
                    return ChromaticChord.Am11;
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E))
                            .build();
                case III11:
                    return ChromaticChord.CMaj11;
                case IV11:
                    return ChromaticChord.Dm11;
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B))
                            .build();
                case VII11:
                    return ChromaticChord.G11;
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A))
                            .build();
                case IV13:
                    return ChromaticChord.Dm13;
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.B))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.C))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.D))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.E))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.F))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.G))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.A))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.D))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.E))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.F))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.G))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.A))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.B))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.C))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.F))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.G))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.A))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.B))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.D))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.E))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.B))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.E))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.F))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.F, Chromatic.A))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.B))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.E))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.B))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.C))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.D))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.E))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.F))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.G))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.A))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.F, Chromatic.C))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.F))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A))
                            .build();
            }
        } else if (t.equals(Tonality.Bbm)) {
            switch (f) {
                case I:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case II:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF))
                            .build();
                case III:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case IV:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case V:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case VI:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case VII:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.FF))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.GG))
                            .build();
                case III6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA))
                            .build();
                case IV6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C))
                            .build();
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.CC))
                            .build();
                case VI6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD))
                            .build();
                case VII6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F))
                            .build();
                case I7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case II7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case III7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case IV7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case V7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case VI7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case VII7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF))
                            .build();
                case I9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case II9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case III9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case IV9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF))
                            .build();
                case VI9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case VII9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case I11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case III11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF))
                            .build();
                case IV11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case VII11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA))
                            .build();
                case IV13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C))
                            .build();
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.C))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.CC))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.DD))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.F))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.FF))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.GG))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.AA))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.DD))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.F))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.FF))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.GG))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.AA))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.C))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.CC))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.FF))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.GG))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.AA))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.C))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.CC))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.DD))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.F))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.C))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.F))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.FF))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.FF, Chromatic.AA))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.C))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.F))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.C))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.CC))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.DD))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.F))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.FF))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.GG))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.AA))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.C, Chromatic.FF, Chromatic.CC))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.FF))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA))
                            .build();
            }
        } else if (t.equals(Tonality.Bm)) {
            switch (f) {
                case I:
                    return ChromaticChord.Bm;
                case II:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G))
                            .build();
                case III:
                    return ChromaticChord.D;
                case IV:
                    return ChromaticChord.Em;
                case V:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC))
                            .build();
                case VI:
                    return ChromaticChord.G;
                case VII:
                    return ChromaticChord.A;
                case I6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.G))
                            .build();
                case II6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.A))
                            .build();
                case III6:
                    return ChromaticChord.D6;
                case IV6:
                    return ChromaticChord.Em6;
                case V6:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.D))
                            .build();
                case VI6:
                    return ChromaticChord.G6;
                case VII6:
                    return ChromaticChord.A6;
                case I7:
                    return ChromaticChord.Bm7;
                case II7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B))
                            .build();
                case III7:
                    return ChromaticChord.DMaj7;
                case IV7:
                    return ChromaticChord.Em7;
                case V7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E))
                            .build();
                case VI7:
                    return ChromaticChord.GMaj7;
                case VII7:
                    return ChromaticChord.A7;
                case I9:
                    return ChromaticChord.Bm9;
                case II9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D))
                            .build();
                case III9:
                    return ChromaticChord.DMaj9;
                case IV9:
                    return ChromaticChord.Em9;
                case V9:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G))
                            .build();
                case VI9:
                    return ChromaticChord.GMaj9;
                case VII9:
                    return ChromaticChord.A9;
                case I11:
                    return ChromaticChord.Bm11;
                case II11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF))
                            .build();
                case III11:
                    return ChromaticChord.DMaj11;
                case IV11:
                    return ChromaticChord.Em11;
                case V11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B))
                            .build();
                case VI11:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC))
                            .build();
                case VII11:
                    return ChromaticChord.A11;
                case I13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G))
                            .build();
                case II13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A))
                            .build();
                case III13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B))
                            .build();
                case IV13:
                    return ChromaticChord.Em13;
                case V13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D))
                            .build();
                case VI13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E))
                            .build();
                case VII13:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF))
                            .build();
                case I_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.CC))
                            .build();
                case II_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.D))
                            .build();
                case III_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.E))
                            .build();
                case IV_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.FF))
                            .build();
                case V_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.G))
                            .build();
                case VI_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.A))
                            .build();
                case VII_SECOND:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.B))
                            .build();
                case I_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D))
                            .build();
                case II_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E))
                            .build();
                case III_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF))
                            .build();
                case IV_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G))
                            .build();
                case V_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A))
                            .build();
                case VI_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B))
                            .build();
                case VII_THIRD:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC))
                            .build();
                case I_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.E))
                            .build();
                case II_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.FF))
                            .build();
                case III_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.G))
                            .build();
                case IV_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.A))
                            .build();
                case V_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.B))
                            .build();
                case VI_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.CC))
                            .build();
                case VII_FOURTH:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.D))
                            .build();
                case I6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.G))
                            .build();
                case II6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.A))
                            .build();
                case III6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.B))
                            .build();
                case IV6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.CC))
                            .build();
                case V6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.D))
                            .build();
                case VI6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.E))
                            .build();
                case VII6_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.FF))
                            .build();
                case I7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A))
                            .build();
                case II7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B))
                            .build();
                case III7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.CC))
                            .build();
                case IV7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D))
                            .build();
                case V7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E))
                            .build();
                case VI7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.FF))
                            .build();
                case VII7_O5:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.G))
                            .build();
                case I7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A))
                            .build();
                case II7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.G, Chromatic.B))
                            .build();
                case III7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.CC))
                            .build();
                case IV7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D))
                            .build();
                case V7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E))
                            .build();
                case VI7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.FF))
                            .build();
                case VII7_O3:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G))
                            .build();
                case I9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.CC))
                            .build();
                case II9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.D))
                            .build();
                case III9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.E))
                            .build();
                case IV9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.FF))
                            .build();
                case V9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.G))
                            .build();
                case VI9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.A))
                            .build();
                case VII9_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.B))
                            .build();
                case I9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC))
                            .build();
                case II9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.CC, Chromatic.G, Chromatic.D))
                            .build();
                case III9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E))
                            .build();
                case IV9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF))
                            .build();
                case V9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.G))
                            .build();
                case VI9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A))
                            .build();
                case VII9_O3_O7:
                    return ChromaticChord.builder()
                            .addAll(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B))
                            .build();
            }
        }

        return null;
    }
}
