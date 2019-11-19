package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicChordPattern;
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
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA));
                case IV:
                    return ChromaticChord.Fm;
                case V:
                    return ChromaticChord.Gm;
                case VI:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD));
                case VII:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F));
                case I2:
                    return ChromaticChord.Csus2;
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.DD, Chromatic.GG));
                case III2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.F, Chromatic.AA));
                case IV2:
                    return ChromaticChord.Fsus2;
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.GG, Chromatic.D));
                case VI2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.AA, Chromatic.DD));
                case VII2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.C, Chromatic.F));
                case I4:
                    return ChromaticChord.Csus4;
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.G, Chromatic.GG));
                case III4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.AA));
                case IV4:
                    return ChromaticChord.Fsus4;
                case V4:
                    return ChromaticChord.Gsus4;
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.D, Chromatic.DD));
                case VII4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.F));
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.GG));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.AA));
                case III6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C));
                case IV6:
                    return ChromaticChord.Fm6;
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.DD));
                case VI6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F));
                case VII6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G));
                case I7:
                    return ChromaticChord.Cm7;
                case II7:
                    return ChromaticChord.Dm7b5;
                case III7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D));
                case IV7:
                    return ChromaticChord.Fm7;
                case V7:
                    return ChromaticChord.Gm7;
                case VI7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G));
                case VII7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG));
                case I9:
                    return ChromaticChord.Cm9;
                case II9:
                    return ChromaticChord.from(Chromatic.D, DiatonicChordPattern.NINTH, t);
                case III9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F));
                case IV9:
                    return ChromaticChord.Fm9;
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG));
                case VI9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA));
                case VII9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C));
                case I11:
                    return ChromaticChord.Cm11;
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G));
                case III11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG));
                case IV11:
                    return ChromaticChord.Fm11;
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D));
                case VII11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD));
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C));
                case IV13:
                    return ChromaticChord.Fm13;
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.D));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.DD));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.F));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.G));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.GG));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.AA));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.C));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.F));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.G));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.AA));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.C));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.D));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.GG));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.AA));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.C));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.D));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.DD));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.F));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.G));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.D));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.G));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.GG));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.GG, Chromatic.C));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.D));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.G));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.D));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.DD));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.F));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.G));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.GG));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.AA));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.C));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.GG, Chromatic.DD));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.GG));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C));
            }
        } else if (t.equals(Tonality.CCm)) {
            switch (f) {
                case I:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG));
                case II:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A));
                case III:
                    return ChromaticChord.E;
                case IV:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC));
                case V:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD));
                case VI:
                    return ChromaticChord.A;
                case VII:
                    return ChromaticChord.B;
                case I2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.DD, Chromatic.GG));
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.E, Chromatic.A));
                case III2:
                    return ChromaticChord.Esus2;
                case IV2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.GG, Chromatic.CC));
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.A, Chromatic.DD));
                case VI2:
                    return ChromaticChord.Asus2;
                case VII2:
                    return ChromaticChord.Bsus2;
                case I4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.GG));
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.A));
                case III4:
                    return ChromaticChord.Esus4;
                case IV4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.CC));
                case V4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.DD));
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.DD, Chromatic.E));
                case VII4:
                    return ChromaticChord.Bsus4;
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.A));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.B));
                case III6:
                    return ChromaticChord.E6;
                case IV6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD));
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.E));
                case VI6:
                    return ChromaticChord.A6;
                case VII6:
                    return ChromaticChord.B6;
                case I7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B));
                case II7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC));
                case III7:
                    return ChromaticChord.EMaj7;
                case IV7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E));
                case V7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF));
                case VI7:
                    return ChromaticChord.AMaj7;
                case VII7:
                    return ChromaticChord.B7;
                case I9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD));
                case II9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E));
                case III9:
                    return ChromaticChord.EMaj9;
                case IV9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG));
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A));
                case VI9:
                    return ChromaticChord.AMaj9;
                case VII9:
                    return ChromaticChord.B9;
                case I11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF));
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG));
                case III11:
                    return ChromaticChord.EMaj11;
                case IV11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B));
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD));
                case VII11:
                    return ChromaticChord.B11;
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC));
                case IV13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD));
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.DD));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.E));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.FF));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.GG));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.A));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.B));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.CC));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.A));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.DD));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.E));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.A));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.B));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.CC));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.DD));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.E));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.FF));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.GG));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.DD));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.GG));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.A));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.A, Chromatic.CC));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.DD));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.GG));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.DD));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.E));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.FF));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.GG));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.A));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.B));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.CC));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.A, Chromatic.E));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.A));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC));
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
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F));
                case VII:
                    return ChromaticChord.C;
                case I2:
                    return ChromaticChord.Dsus2;
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.F, Chromatic.AA));
                case III2:
                    return ChromaticChord.Fsus2;
                case IV2:
                    return ChromaticChord.Gsus2;
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.AA, Chromatic.E));
                case VI2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.C, Chromatic.F));
                case VII2:
                    return ChromaticChord.Csus2;
                case I4:
                    return ChromaticChord.Dsus4;
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.A, Chromatic.AA));
                case III4:
                    return ChromaticChord.Fsus4;
                case IV4:
                    return ChromaticChord.Gsus4;
                case V4:
                    return ChromaticChord.Asus4;
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.E, Chromatic.F));
                case VII4:
                    return ChromaticChord.Csus4;
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.C));
                case III6:
                    return ChromaticChord.F6;
                case IV6:
                    return ChromaticChord.Gm6;
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.F));
                case VI6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G));
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
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A));
                case VII7:
                    return ChromaticChord.C7;
                case I9:
                    return ChromaticChord.Dm9;
                case II9:
                    return ChromaticChord.from(Chromatic.E, DiatonicChordPattern.NINTH, t);
                case III9:
                    return ChromaticChord.FMaj9;
                case IV9:
                    return ChromaticChord.Gm9;
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA));
                case VI9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C));
                case VII9:
                    return ChromaticChord.C9;
                case I11:
                    return ChromaticChord.Dm11;
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A));
                case III11:
                    return ChromaticChord.FMaj11;
                case IV11:
                    return ChromaticChord.Gm11;
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E));
                case VII11:
                    return ChromaticChord.C11;
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D));
                case IV13:
                    return ChromaticChord.Gm13;
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.E));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.F));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.G));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.A));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.AA));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.C));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.D));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.G));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.A));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.AA));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.C));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.D));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.E));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.F));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.AA));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.D));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.E));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.F));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.G));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.A));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.E));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.A));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.AA));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.AA, Chromatic.D));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.E));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.A));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.E));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.F));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.G));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.A));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.AA));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.C));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.D));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.AA, Chromatic.F));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.AA));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D));
            }
        } else if (t.equals(Tonality.Ebm) || t.equals(Tonality.DDm)) {
            switch (f) {
                case I:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case II:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B));
                case III:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case IV:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD));
                case V:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F));
                case VI:
                    return ChromaticChord.B;
                case VII:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG));
                case I2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.F, Chromatic.AA));
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.FF, Chromatic.B));
                case III2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.GG, Chromatic.CC));
                case IV2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.AA, Chromatic.DD));
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.B, Chromatic.F));
                case VI2:
                    return ChromaticChord.Bsus2;
                case VII2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.DD, Chromatic.GG));
                case I4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.AA));
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.AA, Chromatic.B));
                case III4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.CC));
                case IV4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.DD));
                case V4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.F));
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.F, Chromatic.FF));
                case VII4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.GG));
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.B));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.CC));
                case III6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD));
                case IV6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F));
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.FF));
                case VI6:
                    return ChromaticChord.B6;
                case VII6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA));
                case I7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case II7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD));
                case III7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F));
                case IV7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF));
                case V7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG));
                case VI7:
                    return ChromaticChord.BMaj7;
                case VII7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B));
                case I9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F));
                case II9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF));
                case III9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG));
                case IV9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B));
                case VI9:
                    return ChromaticChord.BMaj9;
                case VII9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD));
                case I11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG));
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case III11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B));
                case IV11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F));
                case VII11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF));
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD));
                case IV13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F));
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.F));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.FF));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.GG));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.AA));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.B));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.CC));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.DD));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.AA));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.F));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.B));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.CC));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.DD));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.F));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.FF));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.GG));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.AA));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.F));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.AA));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.B));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.B, Chromatic.DD));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.F));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.AA));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.F));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.FF));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.GG));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.AA));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.B));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.CC));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.DD));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.B, Chromatic.FF));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.B));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD));
            }
        } else if (t.equals(Tonality.Em)) {
            switch (f) {
                case I:
                    return ChromaticChord.Em;
                case II:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C));
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
                case I2:
                    return ChromaticChord.Esus2;
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.G, Chromatic.C));
                case III2:
                    return ChromaticChord.Gsus2;
                case IV2:
                    return ChromaticChord.Asus2;
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.C, Chromatic.FF));
                case VI2:
                    return ChromaticChord.Csus2;
                case VII2:
                    return ChromaticChord.Dsus2;
                case I4:
                    return ChromaticChord.Esus4;
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.C));
                case III4:
                    return ChromaticChord.Gsus4;
                case IV4:
                    return ChromaticChord.Asus4;
                case V4:
                    return ChromaticChord.Bsus4;
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.FF, Chromatic.G));
                case VII4:
                    return ChromaticChord.Dsus4;
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.C));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.D));
                case III6:
                    return ChromaticChord.G6;
                case IV6:
                    return ChromaticChord.Am6;
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.G));
                case VI6:
                    return ChromaticChord.C6;
                case VII6:
                    return ChromaticChord.D6;
                case I7:
                    return ChromaticChord.Em7;
                case II7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E));
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
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G));
                case III9:
                    return ChromaticChord.GMaj9;
                case IV9:
                    return ChromaticChord.Am9;
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C));
                case VI9:
                    return ChromaticChord.CMaj9;
                case VII9:
                    return ChromaticChord.D9;
                case I11:
                    return ChromaticChord.Em11;
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B));
                case III11:
                    return ChromaticChord.GMaj11;
                case IV11:
                    return ChromaticChord.Am11;
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF));
                case VII11:
                    return ChromaticChord.D11;
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E));
                case IV13:
                    return ChromaticChord.Am13;
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.FF));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.G));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.A));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.B));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.C));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.D));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.E));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.A));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.C));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.D));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.E));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.FF));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.G));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.D));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.E));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.FF));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.G));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.A));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.B));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.FF));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.B));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.C));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.C, Chromatic.E));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.FF));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.B));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.FF));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.G));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.A));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.B));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.C));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.D));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.E));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.C, Chromatic.G));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.C));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E));
            }
        } else if (t.equals(Tonality.Fm)) {
            switch (f) {
                case I:
                    return ChromaticChord.Fm;
                case II:
                    return ChromaticChord.Gdim;
                case III:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD));
                case IV:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F));
                case V:
                    return ChromaticChord.Cm;
                case VI:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG));
                case VII:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA));
                case I2:
                    return ChromaticChord.Fsus2;
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.GG, Chromatic.CC));
                case III2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.AA, Chromatic.DD));
                case IV2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.C, Chromatic.F));
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.CC, Chromatic.G));
                case VI2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.DD, Chromatic.GG));
                case VII2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.F, Chromatic.AA));
                case I4:
                    return ChromaticChord.Fsus4;
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.CC));
                case III4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.DD));
                case IV4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.F));
                case V4:
                    return ChromaticChord.Csus4;
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.G, Chromatic.GG));
                case VII4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.AA));
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.CC));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.DD));
                case III6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F));
                case IV6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G));
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.GG));
                case VI6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA));
                case VII6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C));
                case I7:
                    return ChromaticChord.Fm7;
                case II7:
                    return ChromaticChord.Gm7b5;
                case III7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G));
                case IV7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG));
                case V7:
                    return ChromaticChord.Cm7;
                case VI7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C));
                case VII7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC));
                case I9:
                    return ChromaticChord.Fm9;
                case II9:
                    return ChromaticChord.from(Chromatic.G, DiatonicChordPattern.NINTH, t);
                case III9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA));
                case IV9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C));
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC));
                case VI9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD));
                case VII9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F));
                case I11:
                    return ChromaticChord.Fm11;
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C));
                case III11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC));
                case IV11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD));
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G));
                case VII11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG));
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F));
                case IV13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G));
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.G));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.GG));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.AA));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.C));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.CC));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.DD));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.F));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.AA));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.C));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.F));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.G));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.CC));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.DD));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.F));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.G));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.GG));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.AA));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.C));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.G));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.C));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.CC));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.CC, Chromatic.F));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.G));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.C));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.G));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.GG));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.AA));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.C));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.CC));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.DD));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.F));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.CC, Chromatic.GG));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.CC));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F));
            }
        } else if (t.equals(Tonality.FFm)) {
            switch (f) {
                case I:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC));
                case II:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D));
                case III:
                    return ChromaticChord.A;
                case IV:
                    return ChromaticChord.Bm;
                case V:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG));
                case VI:
                    return ChromaticChord.D;
                case VII:
                    return ChromaticChord.E;
                case I2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.GG, Chromatic.CC));
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.A, Chromatic.D));
                case III2:
                    return ChromaticChord.Asus2;
                case IV2:
                    return ChromaticChord.Bsus2;
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.D, Chromatic.GG));
                case VI2:
                    return ChromaticChord.Dsus2;
                case VII2:
                    return ChromaticChord.Esus2;
                case I4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.CC));
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.D));
                case III4:
                    return ChromaticChord.Asus4;
                case IV4:
                    return ChromaticChord.Bsus4;
                case V4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.GG));
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.GG, Chromatic.A));
                case VII4:
                    return ChromaticChord.Esus4;
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.D));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.E));
                case III6:
                    return ChromaticChord.A6;
                case IV6:
                    return ChromaticChord.Bm6;
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.A));
                case VI6:
                    return ChromaticChord.D6;
                case VII6:
                    return ChromaticChord.E6;
                case I7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E));
                case II7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF));
                case III7:
                    return ChromaticChord.AMaj7;
                case IV7:
                    return ChromaticChord.Bm7;
                case V7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B));
                case VI7:
                    return ChromaticChord.DMaj7;
                case VII7:
                    return ChromaticChord.E7;
                case I9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG));
                case II9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A));
                case III9:
                    return ChromaticChord.AMaj9;
                case IV9:
                    return ChromaticChord.Bm9;
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D));
                case VI9:
                    return ChromaticChord.DMaj9;
                case VII9:
                    return ChromaticChord.E9;
                case I11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B));
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC));
                case III11:
                    return ChromaticChord.AMaj11;
                case IV11:
                    return ChromaticChord.Bm11;
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG));
                case VII11:
                    return ChromaticChord.E11;
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF));
                case IV13:
                    return ChromaticChord.Bm13;
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.GG));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.A));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.B));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.CC));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.D));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.E));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.FF));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.D));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.E));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.GG));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.A));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.D));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.E));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.FF));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.GG));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.A));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.B));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.CC));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.GG));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.CC));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.D));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.D, Chromatic.FF));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.GG));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.CC));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.GG));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.A));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.B));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.CC));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.D));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.E));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.FF));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.D, Chromatic.A));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.D));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF));
            }
        } else if (t.equals(Tonality.Gm)) {
            switch (f) {
                case I:
                    return ChromaticChord.Gm;
                case II:
                    return ChromaticChord.Adim;
                case III:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F));
                case IV:
                    return ChromaticChord.Cm;
                case V:
                    return ChromaticChord.Dm;
                case VI:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA));
                case VII:
                    return ChromaticChord.F;
                case I2:
                    return ChromaticChord.Gsus2;
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.AA, Chromatic.DD));
                case III2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.C, Chromatic.F));
                case IV2:
                    return ChromaticChord.Csus2;
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.DD, Chromatic.A));
                case VI2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.F, Chromatic.AA));
                case VII2:
                    return ChromaticChord.Fsus2;
                case I4:
                    return ChromaticChord.Gsus4;
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.D, Chromatic.DD));
                case III4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.F));
                case IV4:
                    return ChromaticChord.Csus4;
                case V4:
                    return ChromaticChord.Dsus4;
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.A, Chromatic.AA));
                case VII4:
                    return ChromaticChord.Fsus4;
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.DD));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.F));
                case III6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G));
                case IV6:
                    return ChromaticChord.Cm6;
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA));
                case VI6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C));
                case VII6:
                    return ChromaticChord.F6;
                case I7:
                    return ChromaticChord.Gm7;
                case II7:
                    return ChromaticChord.Am7b5;
                case III7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A));
                case IV7:
                    return ChromaticChord.Cm7;
                case V7:
                    return ChromaticChord.Dm7;
                case VI7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D));
                case VII7:
                    return ChromaticChord.F7;
                case I9:
                    return ChromaticChord.Gm9;
                case II9:
                    return ChromaticChord.from(Chromatic.A, DiatonicChordPattern.NINTH, t);
                case III9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C));
                case IV9:
                    return ChromaticChord.Cm9;
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD));
                case VI9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F));
                case VII9:
                    return ChromaticChord.F9;
                case I11:
                    return ChromaticChord.Gm11;
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D));
                case III11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD));
                case IV11:
                    return ChromaticChord.Cm11;
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A));
                case VII11:
                    return ChromaticChord.F11;
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G));
                case IV13:
                    return ChromaticChord.Cm13;
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.A));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.AA));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.C));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.D));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.DD));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.F));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.G));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.C));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.D));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.F));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.G));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.A));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.AA));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.DD));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.F));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.G));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.A));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.AA));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.C));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.D));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.A));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.D));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.DD));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.DD, Chromatic.G));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.A));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.D));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.A));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.AA));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.C));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.D));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.DD));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.F));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.G));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.DD, Chromatic.AA));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.DD));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G));
            }
        } else if (t.equals(Tonality.GGm)) {
            switch (f) {
                case I:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD));
                case II:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E));
                case III:
                    return ChromaticChord.B;
                case IV:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG));
                case V:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case VI:
                    return ChromaticChord.E;
                case VII:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case I2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.AA, Chromatic.DD));
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.B, Chromatic.E));
                case III2:
                    return ChromaticChord.Bsus2;
                case IV2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.DD, Chromatic.GG));
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.E, Chromatic.AA));
                case VI2:
                    return ChromaticChord.Esus2;
                case VII2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.GG, Chromatic.CC));
                case I4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.DD));
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.E));
                case III4:
                    return ChromaticChord.Bsus4;
                case IV4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.GG));
                case V4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.AA));
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.AA, Chromatic.B));
                case VII4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.CC));
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.E));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.FF));
                case III6:
                    return ChromaticChord.B6;
                case IV6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA));
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.B));
                case VI6:
                    return ChromaticChord.E6;
                case VII6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD));
                case I7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF));
                case II7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG));
                case III7:
                    return ChromaticChord.BMaj7;
                case IV7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B));
                case V7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case VI7:
                    return ChromaticChord.EMaj7;
                case VII7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E));
                case I9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case II9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B));
                case III9:
                    return ChromaticChord.BMaj9;
                case IV9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD));
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E));
                case VI9:
                    return ChromaticChord.EMaj9;
                case VII9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG));
                case I11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD));
                case III11:
                    return ChromaticChord.BMaj11;
                case IV11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF));
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case VII11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B));
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG));
                case IV13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.AA));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.B));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.CC));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.DD));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.E));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.FF));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.GG));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.E));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.AA));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.E));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.FF));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.GG));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.AA));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.B));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.CC));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.DD));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.AA));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.DD));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.E));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.E, Chromatic.GG));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.AA));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.DD));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.AA));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.B));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.CC));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.DD));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.E));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.FF));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.GG));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.E, Chromatic.B));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.E));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG));
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
                case I2:
                    return ChromaticChord.Asus2;
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.C, Chromatic.F));
                case III2:
                    return ChromaticChord.Csus2;
                case IV2:
                    return ChromaticChord.Dsus2;
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.F, Chromatic.B));
                case VI2:
                    return ChromaticChord.Fsus2;
                case VII2:
                    return ChromaticChord.Gsus2;
                case I4:
                    return ChromaticChord.Asus4;
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.E, Chromatic.F));
                case III4:
                    return ChromaticChord.Csus4;
                case IV4:
                    return ChromaticChord.Dsus4;
                case V4:
                    return ChromaticChord.Esus4;
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.B, Chromatic.C));
                case VII4:
                    return ChromaticChord.Gsus4;
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.F));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.G));
                case III6:
                    return ChromaticChord.C6;
                case IV6:
                    return ChromaticChord.Dm6;
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.C));
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
                    return ChromaticChord.from(Chromatic.B, DiatonicChordPattern.NINTH, t);
                case III9:
                    return ChromaticChord.CMaj9;
                case IV9:
                    return ChromaticChord.Dm9;
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F));
                case VI9:
                    return ChromaticChord.FMaj9;
                case VII9:
                    return ChromaticChord.G9;
                case I11:
                    return ChromaticChord.Am11;
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E));
                case III11:
                    return ChromaticChord.CMaj11;
                case IV11:
                    return ChromaticChord.Dm11;
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B));
                case VII11:
                    return ChromaticChord.G11;
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A));
                case IV13:
                    return ChromaticChord.Dm13;
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.B));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.C));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.D));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.E));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.F));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.G));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.A));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.D));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.E));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.F));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.G));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.A));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.B));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.C));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.F));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.G));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.A));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.B));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.D));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.E));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.B));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.E));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.F));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.F, Chromatic.A));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.B));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.E));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.B));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.C));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.D));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.E));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.F));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.G));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.A));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.F, Chromatic.C));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.F));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A));
            }
        } else if (t.equals(Tonality.Bbm)) {
            switch (f) {
                case I:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F));
                case II:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF));
                case III:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG));
                case IV:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case V:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C));
                case VI:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case VII:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD));
                case I2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.C, Chromatic.F));
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.CC, Chromatic.FF));
                case III2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.DD, Chromatic.GG));
                case IV2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.F, Chromatic.AA));
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.FF, Chromatic.C));
                case VI2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.GG, Chromatic.CC));
                case VII2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.AA, Chromatic.DD));
                case I4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.F));
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.F, Chromatic.FF));
                case III4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.GG));
                case IV4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.AA));
                case V4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.AA, Chromatic.C));
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.C, Chromatic.CC));
                case VII4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.DD));
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.FF));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.GG));
                case III6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA));
                case IV6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C));
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.CC));
                case VI6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD));
                case VII6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F));
                case I7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG));
                case II7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case III7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C));
                case IV7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case V7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD));
                case VI7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F));
                case VII7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF));
                case I9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C));
                case II9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case III9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD));
                case IV9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F));
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF));
                case VI9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG));
                case VII9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case I11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD));
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F));
                case III11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF));
                case IV11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG));
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C));
                case VII11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA));
                case IV13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C));
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.C));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.CC));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.DD));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.F));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.FF));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.GG));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.AA));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.DD));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.F));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.GG));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.AA));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.C));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.CC));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.FF));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.GG));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.AA));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.C));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.CC));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.DD));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.F));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.C));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.F));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.FF));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.FF, Chromatic.AA));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.C));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.F));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.C));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.CC));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.DD));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.F));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.FF));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.GG));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.AA));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.C, Chromatic.FF, Chromatic.CC));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.FF));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA));
            }
        } else if (t.equals(Tonality.Bm)) {
            switch (f) {
                case I:
                    return ChromaticChord.Bm;
                case II:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G));
                case III:
                    return ChromaticChord.D;
                case IV:
                    return ChromaticChord.Em;
                case V:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC));
                case VI:
                    return ChromaticChord.G;
                case VII:
                    return ChromaticChord.A;
                case I2:
                    return ChromaticChord.Bsus2;
                case II2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.D, Chromatic.G));
                case III2:
                    return ChromaticChord.Dsus2;
                case IV2:
                    return ChromaticChord.Esus2;
                case V2:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.G, Chromatic.CC));
                case VI2:
                    return ChromaticChord.Gsus2;
                case VII2:
                    return ChromaticChord.Asus2;
                case I4:
                    return ChromaticChord.Bsus4;
                case II4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.G));
                case III4:
                    return ChromaticChord.Dsus4;
                case IV4:
                    return ChromaticChord.Esus4;
                case V4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.CC));
                case VI4:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.CC, Chromatic.D));
                case VII4:
                    return ChromaticChord.Asus4;
                case I6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.G));
                case II6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.A));
                case III6:
                    return ChromaticChord.D6;
                case IV6:
                    return ChromaticChord.Em6;
                case V6:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.D));
                case VI6:
                    return ChromaticChord.G6;
                case VII6:
                    return ChromaticChord.A6;
                case I7:
                    return ChromaticChord.Bm7;
                case II7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B));
                case III7:
                    return ChromaticChord.DMaj7;
                case IV7:
                    return ChromaticChord.Em7;
                case V7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E));
                case VI7:
                    return ChromaticChord.GMaj7;
                case VII7:
                    return ChromaticChord.A7;
                case I9:
                    return ChromaticChord.Bm9;
                case II9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D));
                case III9:
                    return ChromaticChord.DMaj9;
                case IV9:
                    return ChromaticChord.Em9;
                case V9:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G));
                case VI9:
                    return ChromaticChord.GMaj9;
                case VII9:
                    return ChromaticChord.A9;
                case I11:
                    return ChromaticChord.Bm11;
                case II11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF));
                case III11:
                    return ChromaticChord.DMaj11;
                case IV11:
                    return ChromaticChord.Em11;
                case V11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B));
                case VI11:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC));
                case VII11:
                    return ChromaticChord.A11;
                case I13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G));
                case II13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A));
                case III13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B));
                case IV13:
                    return ChromaticChord.Em13;
                case V13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D));
                case VI13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E));
                case VII13:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF));
                case I_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.CC));
                case II_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.D));
                case III_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.E));
                case IV_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.FF));
                case V_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.G));
                case VI_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.A));
                case VII_SECOND:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.B));
                case I_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D));
                case II_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E));
                case III_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF));
                case IV_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G));
                case V_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A));
                case VI_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B));
                case VII_THIRD:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC));
                case I_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.E));
                case II_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.FF));
                case III_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.G));
                case IV_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.A));
                case V_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.B));
                case VI_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.CC));
                case VII_FOURTH:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.D));
                case I6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.G));
                case II6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.A));
                case III6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.B));
                case IV6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.CC));
                case V6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.D));
                case VI6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.E));
                case VII6_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.FF));
                case I7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A));
                case II7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B));
                case III7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.CC));
                case IV7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D));
                case V7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E));
                case VI7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.FF));
                case VII7_O5:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.G));
                case I7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A));
                case II7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.G, Chromatic.B));
                case III7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.CC));
                case IV7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D));
                case V7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E));
                case VI7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.FF));
                case VII7_O3:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G));
                case I9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.CC));
                case II9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.D));
                case III9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.E));
                case IV9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.FF));
                case V9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.G));
                case VI9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.A));
                case VII9_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.B));
                case I9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC));
                case II9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.CC, Chromatic.G, Chromatic.D));
                case III9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E));
                case IV9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF));
                case V9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.G));
                case VI9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A));
                case VII9_O3_O7:
                    return ChromaticChord.from(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B));
            }
        }

        return null;
    }
}
