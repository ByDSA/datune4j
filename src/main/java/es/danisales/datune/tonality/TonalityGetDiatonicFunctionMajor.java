package es.danisales.datune.tonality;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicChordPattern;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.Objects;

class TonalityGetDiatonicFunctionMajor {
	public static @Nullable ChromaticChord get(@NonNull Tonality t, @NonNull DiatonicFunction diatonicFunction) {
		Objects.requireNonNull(t);
		Objects.requireNonNull(diatonicFunction);

		if ( t.equals( Tonality.C ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.C;
				case II: return ChromaticChord.Dm;
				case III: return ChromaticChord.Em;
				case IV: return ChromaticChord.F;
				case V: return ChromaticChord.G;
				case VI: return ChromaticChord.Am;
				case VII: return ChromaticChord.Bdim;
				case I2: return ChromaticChord.Csus2;
				case II2: return ChromaticChord.Dsus2;
				case III2: return ChromaticChord.Esusb2;
				case IV2: return ChromaticChord.Fsus2;
				case V2: return ChromaticChord.Gsus2;
				case VI2: return ChromaticChord.Asus2;
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.C, Chromatic.F)).build(); // Fsus(#4)/B
				case I4: return ChromaticChord.Csus4;
				case II4: return ChromaticChord.Dsus4;
				case III4: return ChromaticChord.Esus4;
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.B, Chromatic.C)).build(); // Fsus(#4)
				case V4: return ChromaticChord.Gsus4;
				case VI4: return ChromaticChord.Asus4;
                case VII4:
                    ChromaticChord ret = ChromaticChord.builder().fromChromatic(ChromaticChord.Esusb2).build();
                    ret.over(Chromatic.B);
                    return ret;
				case I6: return ChromaticChord.C6;
				case II6: return ChromaticChord.Dm6;
                case III6:
                    ret = ChromaticChord.builder().fromChromatic(ChromaticChord.CMaj7).build();
                    ret.over(Chromatic.E);
                    return ret;
				case IV6: return ChromaticChord.F6;
				case V6: return ChromaticChord.G6;
                case VI6:
                    ret = ChromaticChord.builder().fromChromatic(ChromaticChord.FMaj7).build();
                    ret.over(Chromatic.A);
                    return ret;
                case VII6:
                    ret = ChromaticChord.builder().fromChromatic(ChromaticChord.G7).build();
                    ret.over(Chromatic.B);
                    return ret;
				case I7: return ChromaticChord.CMaj7;
				case II7: return ChromaticChord.Dm7;
				case III7: return ChromaticChord.Em7;
				case IV7: return ChromaticChord.FMaj7;
				case V7: return ChromaticChord.G7;
				case VI7: return ChromaticChord.Am7;
				case VII7: return ChromaticChord.Bm7b5;
				case I9: return ChromaticChord.CMaj9;
				case II9: return ChromaticChord.Dm9;
                case III9:
                    ret = ChromaticChord.builder().fromChromatic(ChromaticChord.G7add13).build();
                    ret.over(Chromatic.E);
                    return ret;
				case IV9: return ChromaticChord.FMaj9;
				case V9: return ChromaticChord.G9;
				case VI9: return ChromaticChord.Am9;
                case VII9:
                    return ChromaticChord.builder().chromaticBase(Chromatic.B).diatonicChordPattern(DiatonicChordPattern.NINTH).tonality(t).build();
				case I11: return ChromaticChord.CMaj11;
				case II11: return ChromaticChord.Dm11;
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A)).build(); // E7b911
				case IV11: return ChromaticChord.FMaj9a11;
				case V11: return ChromaticChord.G11;
				case VI11: return ChromaticChord.Am11;
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E)).build(); // B7b911
                case I13:
                    ret = ChromaticChord.builder().fromChromatic(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.C);
                    return ret;
				case II13: return ChromaticChord.Dm13;
                case III13:
                    ret = ChromaticChord.builder().fromChromatic(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.E);
                    return ret;
                case IV13:
                    ret = ChromaticChord.builder().fromChromatic(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.F);
                    return ret;
                case V13:
                    ret = ChromaticChord.builder().fromChromatic(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.G);
                    return ret;
                case VI13:
                    ret = ChromaticChord.builder().fromChromatic(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.A);
                    return ret;
                case VII13:
                    ret = ChromaticChord.builder().fromChromatic(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.B);
                    return ret;
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.D)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.E)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.F)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.G)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.A)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.B)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.C)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.F)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.G)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.A)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.B)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.C)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.D)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.E)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.A)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.B)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.D)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.E)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.F)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.G)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.B)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.E)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.F)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.B)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.E)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.F, Chromatic.A)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.D)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.E)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.F)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.G)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.A)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.B)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.C)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.F)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.F, Chromatic.C)).build();
			}
		} else if ( t.equals( Tonality.Db) ) {
			switch(diatonicFunction) {
                case I:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case II:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case III:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case IV:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case V:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case VI:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case VII:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF)).build();
                case I2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.DD, Chromatic.GG)).build();
                case II2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.F, Chromatic.AA)).build();
                case III2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.FF, Chromatic.C)).build();
                case IV2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.GG, Chromatic.CC)).build();
                case V2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.AA, Chromatic.DD)).build();
                case VI2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.C, Chromatic.F)).build();
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.CC, Chromatic.FF)).build();
                case I4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.GG)).build();
                case II4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.AA)).build();
                case III4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.AA, Chromatic.C)).build();
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.C, Chromatic.CC)).build();
                case V4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.DD)).build();
                case VI4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.F)).build();
                case VII4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.F, Chromatic.FF)).build();
                case I6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA)).build();
                case II6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C)).build();
                case III6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.CC)).build();
                case IV6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD)).build();
                case V6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F)).build();
                case VI6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.FF)).build();
                case VII6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.GG)).build();
                case I7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case II7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case III7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case IV7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case V7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF)).build();
                case VI7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case VII7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case I9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case II9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case III9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF)).build();
                case IV9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case V9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case VI9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case VII9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case I11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF)).build();
                case II11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case IV11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case V11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case VI11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case I13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case II13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case III13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case IV13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case V13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case VI13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF)).build();
                case VII13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.DD)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.F)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.FF)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.GG)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.AA)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.C)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.CC)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.AA)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.C)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.F)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.AA)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.C)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.CC)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.DD)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.F)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.FF)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.GG)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.C)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.F)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.FF)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.C)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.F)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.FF, Chromatic.AA)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.DD)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.F)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.FF)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.GG)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.AA)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.C)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.CC)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.FF)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.FF, Chromatic.CC)).build();
			}
		} else if ( t.equals( Tonality.D ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.D;
				case II: return ChromaticChord.Em;
                case III:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
				case IV: return ChromaticChord.G;
				case V: return ChromaticChord.A;
				case VI: return ChromaticChord.Bm;
                case VII:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G)).build();
				case I2: return ChromaticChord.Dsus2;
				case II2: return ChromaticChord.Esus2;
                case III2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.G, Chromatic.CC)).build();
				case IV2: return ChromaticChord.Gsus2;
				case V2: return ChromaticChord.Asus2;
				case VI2: return ChromaticChord.Bsus2;
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.D, Chromatic.G)).build();
				case I4: return ChromaticChord.Dsus4;
				case II4: return ChromaticChord.Esus4;
                case III4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.CC)).build();
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.CC, Chromatic.D)).build();
				case V4: return ChromaticChord.Asus4;
				case VI4: return ChromaticChord.Bsus4;
                case VII4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.G)).build();
				case I6: return ChromaticChord.D6;
				case II6: return ChromaticChord.Em6;
                case III6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.D)).build();
				case IV6: return ChromaticChord.G6;
				case V6: return ChromaticChord.A6;
                case VI6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.G)).build();
                case VII6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.A)).build();
				case I7: return ChromaticChord.DMaj7;
				case II7: return ChromaticChord.Em7;
                case III7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
				case IV7: return ChromaticChord.GMaj7;
				case V7: return ChromaticChord.A7;
				case VI7: return ChromaticChord.Bm7;
                case VII7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B)).build();
				case I9: return ChromaticChord.DMaj9;
				case II9: return ChromaticChord.Em9;
                case III9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G)).build();
				case IV9: return ChromaticChord.GMaj9;
				case V9: return ChromaticChord.A9;
				case VI9: return ChromaticChord.Bm9;
                case VII9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D)).build();
				case I11: return ChromaticChord.DMaj11;
				case II11: return ChromaticChord.Em11;
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B)).build();
                case IV11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
				case V11: return ChromaticChord.A11;
				case VI11: return ChromaticChord.Bm11;
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
                case I13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B)).build();
				case II13: return ChromaticChord.Em13;
                case III13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D)).build();
                case IV13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
                case V13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
                case VI13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G)).build();
                case VII13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A)).build();
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.E)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.FF)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.G)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.A)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.B)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.CC)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.D)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.G)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.A)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.CC)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.D)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.E)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.B)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.CC)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.D)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.E)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.FF)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.G)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.A)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.CC)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.FF)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.G)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.CC)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.FF)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.G, Chromatic.B)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.E)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.FF)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.G)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.A)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.B)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.CC)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.D)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.G)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.G, Chromatic.D)).build();
			}
		} else if ( t.equals( Tonality.Eb ) ) {
			switch(diatonicFunction) {
                case I:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case II:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case III:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case IV:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case V:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case VI:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case VII:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG)).build();
                case I2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.F, Chromatic.AA)).build();
                case II2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.G, Chromatic.C)).build();
                case III2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.GG, Chromatic.D)).build();
                case IV2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.AA, Chromatic.DD)).build();
                case V2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.C, Chromatic.F)).build();
                case VI2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.G)).build();
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.DD, Chromatic.GG)).build();
                case I4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.AA)).build();
                case II4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.AA, Chromatic.C)).build();
                case III4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.D)).build();
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.D, Chromatic.DD)).build();
                case V4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.F)).build();
                case VI4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.F, Chromatic.G)).build();
                case VII4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.G, Chromatic.GG)).build();
                case I6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C)).build();
                case II6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D)).build();
                case III6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.DD)).build();
                case IV6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F)).build();
                case V6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G)).build();
                case VI6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.GG)).build();
                case VII6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.AA)).build();
                case I7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case II7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case III7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case IV7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case V7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG)).build();
                case VI7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case VII7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case I9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case II9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case III9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG)).build();
                case IV9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case V9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case VI9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case VII9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case I11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG)).build();
                case II11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case IV11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case V11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case VI11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case I13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case II13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case III13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case IV13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case V13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case VI13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG)).build();
                case VII13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.F)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.G)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.GG)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.AA)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.C)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.D)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.DD)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.AA)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.C)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.D)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.F)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.G)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.C)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.D)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.DD)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.F)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.G)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.GG)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.AA)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.D)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.G)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.GG)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.D)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.G)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.GG, Chromatic.C)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.F)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.G)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.GG)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.AA)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.C)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.D)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.DD)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.GG)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.GG, Chromatic.DD)).build();
			}
		} else if ( t.equals( Tonality.E ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.E;
                case II:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case III:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
				case IV: return ChromaticChord.A;
				case V: return ChromaticChord.B;
                case VI:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case VII:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A)).build();
				case I2: return ChromaticChord.Esus2;
                case II2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.GG, Chromatic.CC)).build();
                case III2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.A, Chromatic.DD)).build();
				case IV2: return ChromaticChord.Asus2;
				case V2: return ChromaticChord.Bsus2;
                case VI2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.DD, Chromatic.GG)).build();
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.E, Chromatic.A)).build();
				case I4: return ChromaticChord.Esus4;
                case II4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.CC)).build();
                case III4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.DD)).build();
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.DD, Chromatic.E)).build();
				case V4: return ChromaticChord.Bsus4;
                case VI4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.GG)).build();
                case VII4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.A)).build();
				case I6: return ChromaticChord.E6;
                case II6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD)).build();
                case III6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.E)).build();
				case IV6: return ChromaticChord.A6;
				case V6: return ChromaticChord.B6;
                case VI6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.A)).build();
                case VII6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.B)).build();
				case I7: return ChromaticChord.EMaj7;
                case II7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
                case III7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
				case IV7: return ChromaticChord.AMaj7;
				case V7: return ChromaticChord.B7;
                case VI7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case VII7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
				case I9: return ChromaticChord.EMaj9;
                case II9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case III9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A)).build();
				case IV9: return ChromaticChord.AMaj9;
				case V9: return ChromaticChord.B9;
                case VI9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case VII9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
				case I11: return ChromaticChord.EMaj11;
                case II11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case IV11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
				case V11: return ChromaticChord.B11;
                case VI11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case I13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case II13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case III13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
                case IV13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case V13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case VI13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A)).build();
                case VII13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.FF)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.GG)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.A)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.B)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.CC)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.DD)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.E)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.A)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.DD)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.E)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.CC)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.DD)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.E)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.FF)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.GG)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.A)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.B)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.DD)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.GG)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.A)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.DD)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.GG)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.A, Chromatic.CC)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.FF)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.GG)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.A)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.B)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.CC)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.DD)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.E)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.A)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.A, Chromatic.E)).build();
			}
		} else if ( t.equals( Tonality.F ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.F;
				case II: return ChromaticChord.Gm;
				case III: return ChromaticChord.Am;
                case IV:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F)).build();
				case V: return ChromaticChord.C;
				case VI: return ChromaticChord.Dm;
				case VII: return ChromaticChord.Edim;
				case I2: return ChromaticChord.Fsus2;
				case II2: return ChromaticChord.Gsus2;
                case III2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.AA, Chromatic.E)).build();
                case IV2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.C, Chromatic.F)).build();
				case V2: return ChromaticChord.Csus2;
				case VI2: return ChromaticChord.Dsus2;
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.F, Chromatic.AA)).build();
				case I4: return ChromaticChord.Fsus4;
				case II4: return ChromaticChord.Gsus4;
				case III4: return ChromaticChord.Asus4;
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.E, Chromatic.F)).build();
				case V4: return ChromaticChord.Csus4;
				case VI4: return ChromaticChord.Dsus4;
                case VII4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.A, Chromatic.AA)).build();
				case I6: return ChromaticChord.F6;
				case II6: return ChromaticChord.Gm6;
                case III6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.F)).build();
                case IV6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G)).build();
				case V6: return ChromaticChord.C6;
                case VI6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA)).build();
                case VII6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.C)).build();
				case I7: return ChromaticChord.FMaj7;
				case II7: return ChromaticChord.Gm7;
				case III7: return ChromaticChord.Am7;
                case IV7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
				case V7: return ChromaticChord.C7;
				case VI7: return ChromaticChord.Dm7;
				case VII7: return ChromaticChord.Em7b5;
				case I9: return ChromaticChord.FMaj9;
				case II9: return ChromaticChord.Gm9;
                case III9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA)).build();
                case IV9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
				case V9: return ChromaticChord.C9;
				case VI9: return ChromaticChord.Dm9;
                case VII9:
                    ChromaticChord.builder().chromaticBase(Chromatic.E).diatonicChordPattern(DiatonicChordPattern.NINTH).tonality(t).build();
				case I11: return ChromaticChord.FMaj11;
				case II11: return ChromaticChord.Gm11;
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case IV11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E)).build();
				case V11: return ChromaticChord.C11;
				case VI11: return ChromaticChord.Dm11;
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case I13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
				case II13: return ChromaticChord.Gm13;
                case III13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case IV13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G)).build();
                case V13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case VI13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA)).build();
                case VII13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.G)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.A)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.AA)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.C)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.D)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.E)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.F)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.AA)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.C)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.D)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.E)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.F)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.G)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.A)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.D)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.E)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.F)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.G)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.A)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.AA)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.E)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.A)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.AA)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.E)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.A)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.AA, Chromatic.D)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.G)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.A)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.AA)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.C)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.D)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.E)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.F)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.AA)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.AA, Chromatic.F)).build();
			}
		} else if ( t.equals( Tonality.FF ) || t.equals( Tonality.Gb ) ) {
			switch(diatonicFunction) {
                case I:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case II:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case III:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
				case IV: return ChromaticChord.B;
                case V:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case VI:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case VII:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B)).build();
                case I2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.GG, Chromatic.CC)).build();
                case II2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.AA, Chromatic.DD)).build();
                case III2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.B, Chromatic.F)).build();
				case IV2: return ChromaticChord.Bsus2;
                case V2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.DD, Chromatic.GG)).build();
                case VI2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.F, Chromatic.AA)).build();
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.FF, Chromatic.B)).build();
                case I4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.CC)).build();
                case II4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.DD)).build();
                case III4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.F)).build();
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.F, Chromatic.FF)).build();
                case V4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.GG)).build();
                case VI4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.AA)).build();
                case VII4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.AA, Chromatic.B)).build();
                case I6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD)).build();
                case II6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F)).build();
                case III6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.FF)).build();
				case IV6: return ChromaticChord.B6;
                case V6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA)).build();
                case VI6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.B)).build();
                case VII6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.CC)).build();
                case I7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case II7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case III7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
				case IV7: return ChromaticChord.BMaj7;
                case V7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B)).build();
                case VI7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case VII7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case I9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case II9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case III9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B)).build();
				case IV9: return ChromaticChord.BMaj9;
                case V9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case VI9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case VII9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case I11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B)).build();
                case II11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case IV11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case V11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case VI11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case I13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case II13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case III13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case IV13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case V13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case VI13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B)).build();
                case VII13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.GG)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.AA)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.B)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.CC)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.DD)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.F)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.FF)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.F)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.AA)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.DD)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.F)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.FF)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.GG)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.AA)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.B)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.CC)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.F)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.AA)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.B)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.F)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.AA)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.B, Chromatic.DD)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.GG)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.AA)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.B)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.CC)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.DD)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.F)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.FF)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.B)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.B, Chromatic.FF)).build();
			}
		} else if ( t.equals( Tonality.G ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.G;
				case II: return ChromaticChord.Am;
				case III: return ChromaticChord.Bm;
				case IV: return ChromaticChord.C;
				case V: return ChromaticChord.D;
				case VI: return ChromaticChord.Em;
                case VII:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C)).build();
				case I2: return ChromaticChord.Gsus2;
				case II2: return ChromaticChord.Asus2;
                case III2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.C, Chromatic.FF)).build();
				case IV2: return ChromaticChord.Csus2;
				case V2: return ChromaticChord.Dsus2;
				case VI2: return ChromaticChord.Esus2;
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.G, Chromatic.C)).build();
				case I4: return ChromaticChord.Gsus4;
				case II4: return ChromaticChord.Asus4;
				case III4: return ChromaticChord.Bsus4;
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.FF, Chromatic.G)).build();
				case V4: return ChromaticChord.Dsus4;
				case VI4: return ChromaticChord.Esus4;
                case VII4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.C)).build();
				case I6: return ChromaticChord.G6;
				case II6: return ChromaticChord.Am6;
                case III6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.G)).build();
				case IV6: return ChromaticChord.C6;
				case V6: return ChromaticChord.D6;
                case VI6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.C)).build();
                case VII6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.D)).build();
				case I7: return ChromaticChord.GMaj7;
				case II7: return ChromaticChord.Am7;
				case III7: return ChromaticChord.Bm7;
				case IV7: return ChromaticChord.CMaj7;
				case V7: return ChromaticChord.D7;
				case VI7: return ChromaticChord.Em7;
                case VII7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E)).build();
				case I9: return ChromaticChord.GMaj9;
				case II9: return ChromaticChord.Am9;
                case III9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C)).build();
				case IV9: return ChromaticChord.CMaj9;
				case V9: return ChromaticChord.D9;
				case VI9: return ChromaticChord.Em9;
                case VII9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G)).build();
				case I11: return ChromaticChord.GMaj11;
				case II11: return ChromaticChord.Am11;
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E)).build();
                case IV11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
				case V11: return ChromaticChord.D11;
				case VI11: return ChromaticChord.Em11;
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B)).build();
                case I13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E)).build();
				case II13: return ChromaticChord.Am13;
                case III13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G)).build();
                case IV13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A)).build();
                case V13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B)).build();
                case VI13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C)).build();
                case VII13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D)).build();
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.A)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.B)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.C)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.D)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.E)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.FF)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.G)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.C)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.D)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.E)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.FF)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.G)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.A)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.E)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.FF)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.G)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.A)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.B)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.C)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.D)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.FF)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.B)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.C)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.D)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.FF)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.G)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.B)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.C, Chromatic.E)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.A)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.B)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.C)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.D)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.E)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.FF)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.G)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.C)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.C, Chromatic.G)).build();
			}
		} else if ( t.equals( Tonality.Ab ) ) {
			switch(diatonicFunction) {
                case I:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case II:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case III:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case IV:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case V:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case VI:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case VII:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC)).build();
                case I2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.AA, Chromatic.DD)).build();
                case II2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.C, Chromatic.F)).build();
                case III2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.CC, Chromatic.G)).build();
                case IV2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.DD, Chromatic.GG)).build();
                case V2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.F, Chromatic.AA)).build();
                case VI2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.G, Chromatic.C)).build();
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.GG, Chromatic.CC)).build();
                case I4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.DD)).build();
                case II4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.F)).build();
                case III4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.F, Chromatic.G)).build();
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.G, Chromatic.GG)).build();
                case V4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.AA)).build();
                case VI4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.AA, Chromatic.C)).build();
                case VII4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.CC)).build();
                case I6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F)).build();
                case II6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G)).build();
                case III6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.GG)).build();
                case IV6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA)).build();
                case V6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C)).build();
                case VI6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.CC)).build();
                case VII6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.DD)).build();
                case I7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case II7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case III7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case IV7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case V7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC)).build();
                case VI7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case VII7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case I9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case II9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case III9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC)).build();
                case IV9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case V9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case VI9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case VII9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case I11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC)).build();
                case II11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case IV11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case V11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case VI11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case I13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case II13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case III13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case IV13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case V13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case VI13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC)).build();
                case VII13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.AA)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.C)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.CC)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.DD)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.F)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.G)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.GG)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.F)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.G)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.AA)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.C)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.F)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.G)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.GG)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.AA)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.C)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.CC)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.DD)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.G)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.C)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.CC)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.DD)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.G)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.GG)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.C)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.CC, Chromatic.F)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.AA)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.C)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.CC)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.DD)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.F)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.G)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.GG)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.CC)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.CC, Chromatic.GG)).build();
			}
		} else if ( t.equals( Tonality.A ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.A;
				case II: return ChromaticChord.Bm;
                case III:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
				case IV: return ChromaticChord.D;
				case V: return ChromaticChord.E;
                case VI:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case VII:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D)).build();
				case I2: return ChromaticChord.Asus2;
				case II2: return ChromaticChord.Bsus2;
                case III2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.D, Chromatic.GG)).build();
				case IV2: return ChromaticChord.Dsus2;
				case V2: return ChromaticChord.Esus2;
                case VI2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.GG, Chromatic.CC)).build();
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.A, Chromatic.D)).build();
				case I4: return ChromaticChord.Asus4;
				case II4: return ChromaticChord.Bsus4;
                case III4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.GG)).build();
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.GG, Chromatic.A)).build();
				case V4: return ChromaticChord.Esus4;
                case VI4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.CC)).build();
                case VII4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.D)).build();
				case I6: return ChromaticChord.A6;
				case II6: return ChromaticChord.Bm6;
                case III6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.A)).build();
				case IV6: return ChromaticChord.D6;
				case V6: return ChromaticChord.E6;
                case VI6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.D)).build();
                case VII6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.E)).build();
				case I7: return ChromaticChord.AMaj7;
				case II7: return ChromaticChord.Bm7;
                case III7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
				case IV7: return ChromaticChord.DMaj7;
				case V7: return ChromaticChord.E7;
                case VI7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
                case VII7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
				case I9: return ChromaticChord.AMaj9;
				case II9: return ChromaticChord.Bm9;
                case III9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D)).build();
				case IV9: return ChromaticChord.DMaj9;
				case V9: return ChromaticChord.E9;
                case VI9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case VII9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A)).build();
				case I11: return ChromaticChord.AMaj11;
				case II11: return ChromaticChord.Bm11;
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
                case IV11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
				case V11: return ChromaticChord.E11;
                case VI11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case I13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
				case II13: return ChromaticChord.Bm13;
                case III13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A)).build();
                case IV13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case V13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case VI13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D)).build();
                case VII13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.B)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.CC)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.D)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.E)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.FF)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.GG)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.A)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.D)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.E)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.GG)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.A)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.FF)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.GG)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.A)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.B)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.CC)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.D)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.E)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.GG)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.A)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.CC)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.D)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.E)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.GG)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.A)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.CC)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.D)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.D, Chromatic.FF)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.B)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.CC)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.D)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.E)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.FF)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.GG)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.A)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.E, Chromatic.B)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.D)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.E)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.D, Chromatic.A)).build();
			}
		} else if ( t.equals( Tonality.Bb ) ) {
			switch(diatonicFunction) {
                case I:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case II:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case III:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case IV:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case V:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C)).build();
                case VI:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case VII:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD)).build();
                case I2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.C, Chromatic.F)).build();
                case II2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.D, Chromatic.G)).build();
                case III2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.DD, Chromatic.A)).build();
                case IV2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.F, Chromatic.AA)).build();
                case V2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.G, Chromatic.C)).build();
                case VI2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.A, Chromatic.D)).build();
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.AA, Chromatic.DD)).build();
                case I4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.F)).build();
                case II4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.F, Chromatic.G)).build();
                case III4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.G, Chromatic.A)).build();
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.A, Chromatic.AA)).build();
                case V4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.AA, Chromatic.C)).build();
                case VI4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.C, Chromatic.D)).build();
                case VII4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.D, Chromatic.DD)).build();
                case I6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G)).build();
                case II6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A)).build();
                case III6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA)).build();
                case IV6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C)).build();
                case V6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D)).build();
                case VI6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.DD)).build();
                case VII6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.F)).build();
                case I7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case II7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case III7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
                case IV7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case V7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD)).build();
                case VI7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case VII7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case I9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
                case II9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case III9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD)).build();
                case IV9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case V9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case VI9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case VII9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case I11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD)).build();
                case II11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case IV11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case V11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case VI11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case I13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case II13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case III13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case IV13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
                case V13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case VI13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD)).build();
                case VII13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.C)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.D)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.DD)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.F)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.G)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.A)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.AA)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.F)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.G)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.A)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.AA)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.C)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.D)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.G)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.A)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.AA)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.C)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.D)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.DD)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.F)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.A)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.AA)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.C)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.D)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.DD)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.F)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.G)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.A)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.AA)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.C)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.D)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.DD)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.F)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.DD, Chromatic.G)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.C)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.D)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.DD)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.F)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.G)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.A)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.AA)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.F, Chromatic.C)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.C, Chromatic.G, Chromatic.D)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.D, Chromatic.A, Chromatic.DD)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.F)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.F, Chromatic.C, Chromatic.G)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.G, Chromatic.D, Chromatic.A)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.A, Chromatic.DD, Chromatic.AA)).build();
			}
		} else if ( t.equals( Tonality.B ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.B;
                case II:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case III:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
				case IV: return ChromaticChord.E;
                case V:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case VI:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case VII:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E)).build();
				case I2: return ChromaticChord.Bsus2;
                case II2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.DD, Chromatic.GG)).build();
                case III2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.E, Chromatic.AA)).build();
				case IV2: return ChromaticChord.Esus2;
                case V2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.GG, Chromatic.CC)).build();
                case VI2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.AA, Chromatic.DD)).build();
                case VII2:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.B, Chromatic.E)).build();
				case I4: return ChromaticChord.Bsus4;
                case II4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF, Chromatic.GG)).build();
                case III4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG, Chromatic.AA)).build();
                case IV4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.AA, Chromatic.B)).build();
                case V4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B, Chromatic.CC)).build();
                case VI4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC, Chromatic.DD)).build();
                case VII4:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD, Chromatic.E)).build();
				case I6: return ChromaticChord.B6;
                case II6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA)).build();
                case III6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.B)).build();
				case IV6: return ChromaticChord.E6;
                case V6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD)).build();
                case VI6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.E)).build();
                case VII6:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.FF)).build();
				case I7: return ChromaticChord.BMaj7;
                case II7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case III7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
				case IV7: return ChromaticChord.EMaj7;
                case V7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E)).build();
                case VI7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case VII7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
				case I9: return ChromaticChord.BMaj9;
                case II9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case III9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E)).build();
				case IV9: return ChromaticChord.EMaj9;
                case V9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case VI9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case VII9:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
				case I11: return ChromaticChord.BMaj11;
                case II11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case III11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case IV11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case V11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case VI11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case VII11:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case I13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case II13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case III13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case IV13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case V13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case VI13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E)).build();
                case VII13:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case I_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.CC)).build();
                case II_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.DD)).build();
                case III_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.E)).build();
                case IV_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.FF)).build();
                case V_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.GG)).build();
                case VI_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.AA)).build();
                case VII_SECOND:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.B)).build();
                case I_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD)).build();
                case II_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E)).build();
                case III_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF)).build();
                case IV_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG)).build();
                case V_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA)).build();
                case VI_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B)).build();
                case VII_THIRD:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC)).build();
                case I_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.E)).build();
                case II_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.FF)).build();
                case III_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.GG)).build();
                case IV_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.AA)).build();
                case V_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.B)).build();
                case VI_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.CC)).build();
                case VII_FOURTH:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.DD)).build();
                case I6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.GG)).build();
                case II6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.AA)).build();
                case III6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.B)).build();
                case IV6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.CC)).build();
                case V6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.DD)).build();
                case VI6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.E)).build();
                case VII6_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.FF)).build();
                case I7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.AA)).build();
                case II7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.B)).build();
                case III7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.CC)).build();
                case IV7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.DD)).build();
                case V7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.E)).build();
                case VI7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.FF)).build();
                case VII7_O5:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.GG)).build();
                case I7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.AA)).build();
                case II7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.B)).build();
                case III7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.CC)).build();
                case IV7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.DD)).build();
                case V7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.E)).build();
                case VI7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.FF)).build();
                case VII7_O3:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.E, Chromatic.GG)).build();
                case I9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.CC)).build();
                case II9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.DD)).build();
                case III9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.E)).build();
                case IV9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.FF)).build();
                case V9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.GG)).build();
                case VI9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.AA)).build();
                case VII9_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.B)).build();
                case I9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.B, Chromatic.FF, Chromatic.CC)).build();
                case II9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.CC, Chromatic.GG, Chromatic.DD)).build();
                case III9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.DD, Chromatic.AA, Chromatic.E)).build();
                case IV9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.E, Chromatic.B, Chromatic.FF)).build();
                case V9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.FF, Chromatic.CC, Chromatic.GG)).build();
                case VI9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.GG, Chromatic.DD, Chromatic.AA)).build();
                case VII9_O3_O7:
                    return ChromaticChord.builder().fromChromatic(Arrays.asList(Chromatic.AA, Chromatic.E, Chromatic.B)).build();
			}
		}

		return null;
	}
}
