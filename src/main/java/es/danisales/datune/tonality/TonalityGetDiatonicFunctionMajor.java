package es.danisales.datune.tonality;

import es.danisales.datune.chords.DiatonicDegreePattern;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.chords.chromatic.ChromaticChord;
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
				case I6: return ChromaticChord.C6;
				case II6: return ChromaticChord.Dm6;
                case III6:
                    ChromaticChord ret = ChromaticChord.builder().addAll(ChromaticChord.CMaj7).build();
                    ret.over(Chromatic.E);
                    ret.resetRoot();
                    return ret;
				case IV6: return ChromaticChord.F6;
				case V6: return ChromaticChord.G6;
                case VI6:
                    ret = ChromaticChord.builder().addAll(ChromaticChord.FMaj7).build();
                    ret.over(Chromatic.A);
                    ret.resetRoot();
                    return ret;
                case VII6:
                    ret = ChromaticChord.builder().addAll(ChromaticChord.G7).build();
                    ret.over(Chromatic.B);
                    ret.resetRoot();
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
                    ret = ChromaticChord.builder().addAll(ChromaticChord.G7add13).build();
                    ret.over(Chromatic.E);
                    ret.resetRoot();
                    return ret;
				case IV9: return ChromaticChord.FMaj9;
				case V9: return ChromaticChord.G9;
				case VI9: return ChromaticChord.Am9;
                case VII9:
                    return ChromaticChord.builder().diatonicDegreePattern(DiatonicDegreePattern.VII9).tonality(t).build();
				case I11: return ChromaticChord.CMaj11;
				case II11: return ChromaticChord.Dm11;
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A)).build(); // E7b911
				case IV11: return ChromaticChord.FMaj9a11;
				case V11: return ChromaticChord.G11;
				case VI11: return ChromaticChord.Am11;
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E)).build(); // B7b911
                case I13:
                    ret = ChromaticChord.builder().addAll(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.C);
                    ret.resetRoot();
                    return ret;
				case II13: return ChromaticChord.Dm13;
                case III13:
                    ret = ChromaticChord.builder().addAll(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.E);
                    ret.resetRoot();
                    return ret;
                case IV13:
                    ret = ChromaticChord.builder().addAll(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.F);
                    ret.resetRoot();
                    return ret;
                case V13:
                    ret = ChromaticChord.builder().addAll(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.G);
                    ret.resetRoot();
                    return ret;
                case VI13:
                    ret = ChromaticChord.builder().addAll(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.A);
                    ret.resetRoot();
                    return ret;
                case VII13:
                    ret = ChromaticChord.builder().addAll(ChromaticChord.Dm13).build();
                    ret.over(Chromatic.B);
                    ret.resetRoot();
                    return ret;
			}
		} else if ( t.equals( Tonality.Db) ) {
			switch(diatonicFunction) {
                case I:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case II:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case III:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case IV:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case V:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case VI:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case VII:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF)).build();
                case I6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA)).build();
                case II6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.C)).build();
                case III6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.CC)).build();
                case IV6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD)).build();
                case V6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F)).build();
                case VI6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.FF)).build();
                case VII6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.GG)).build();
                case I7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case II7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case III7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case IV7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case V7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF)).build();
                case VI7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case VII7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case I9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case II9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case III9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF)).build();
                case IV9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case V9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case VI9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case VII9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case I11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF)).build();
                case II11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case IV11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case V11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case VI11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case I13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case II13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case III13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case IV13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case V13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case VI13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.FF)).build();
                case VII13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
			}
		} else if ( t.equals( Tonality.D ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.D;
				case II: return ChromaticChord.Em;
                case III:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
				case IV: return ChromaticChord.G;
				case V: return ChromaticChord.A;
				case VI: return ChromaticChord.Bm;
                case VII:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G)).build();
				case I6: return ChromaticChord.D6;
				case II6: return ChromaticChord.Em6;
                case III6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.D)).build();
				case IV6: return ChromaticChord.G6;
				case V6: return ChromaticChord.A6;
                case VI6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.G)).build();
                case VII6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.A)).build();
				case I7: return ChromaticChord.DMaj7;
				case II7: return ChromaticChord.Em7;
                case III7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
				case IV7: return ChromaticChord.GMaj7;
				case V7: return ChromaticChord.A7;
				case VI7: return ChromaticChord.Bm7;
                case VII7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B)).build();
				case I9: return ChromaticChord.DMaj9;
				case II9: return ChromaticChord.Em9;
                case III9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G)).build();
				case IV9: return ChromaticChord.GMaj9;
				case V9: return ChromaticChord.A9;
				case VI9: return ChromaticChord.Bm9;
                case VII9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D)).build();
				case I11: return ChromaticChord.DMaj11;
				case II11: return ChromaticChord.Em11;
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B)).build();
                case IV11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
				case V11: return ChromaticChord.A11;
				case VI11: return ChromaticChord.Bm11;
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
                case I13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B)).build();
				case II13: return ChromaticChord.Em13;
                case III13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D)).build();
                case IV13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
                case V13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
                case VI13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.G)).build();
                case VII13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A)).build();
			}
		} else if ( t.equals( Tonality.Eb ) ) {
			switch(diatonicFunction) {
                case I:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case II:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case III:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case IV:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case V:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case VI:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case VII:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG)).build();
                case I6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C)).build();
                case II6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.D)).build();
                case III6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.DD)).build();
                case IV6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F)).build();
                case V6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G)).build();
                case VI6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.GG)).build();
                case VII6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.AA)).build();
                case I7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case II7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case III7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case IV7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case V7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG)).build();
                case VI7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case VII7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case I9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case II9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case III9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG)).build();
                case IV9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case V9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case VI9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case VII9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case I11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG)).build();
                case II11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case IV11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case V11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case VI11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case I13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case II13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case III13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case IV13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case V13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case VI13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.GG)).build();
                case VII13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
			}
		} else if ( t.equals( Tonality.E ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.E;
                case II:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case III:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
				case IV: return ChromaticChord.A;
				case V: return ChromaticChord.B;
                case VI:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case VII:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A)).build();
				case I6: return ChromaticChord.E6;
                case II6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.DD)).build();
                case III6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.E)).build();
				case IV6: return ChromaticChord.A6;
				case V6: return ChromaticChord.B6;
                case VI6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.A)).build();
                case VII6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.B)).build();
				case I7: return ChromaticChord.EMaj7;
                case II7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
                case III7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
				case IV7: return ChromaticChord.AMaj7;
				case V7: return ChromaticChord.B7;
                case VI7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case VII7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
				case I9: return ChromaticChord.EMaj9;
                case II9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case III9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A)).build();
				case IV9: return ChromaticChord.AMaj9;
				case V9: return ChromaticChord.B9;
                case VI9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case VII9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
				case I11: return ChromaticChord.EMaj11;
                case II11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case IV11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
				case V11: return ChromaticChord.B11;
                case VI11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case I13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case II13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case III13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
                case IV13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case V13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case VI13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.A)).build();
                case VII13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
			}
		} else if ( t.equals( Tonality.F ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.F;
				case II: return ChromaticChord.Gm;
				case III: return ChromaticChord.Am;
                case IV:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F)).build();
				case V: return ChromaticChord.C;
				case VI: return ChromaticChord.Dm;
				case VII: return ChromaticChord.Edim;
				case I6: return ChromaticChord.F6;
				case II6: return ChromaticChord.Gm6;
                case III6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.F)).build();
                case IV6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G)).build();
				case V6: return ChromaticChord.C6;
                case VI6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA)).build();
                case VII6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.C)).build();
				case I7: return ChromaticChord.FMaj7;
				case II7: return ChromaticChord.Gm7;
				case III7: return ChromaticChord.Am7;
                case IV7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
				case V7: return ChromaticChord.C7;
				case VI7: return ChromaticChord.Dm7;
				case VII7: return ChromaticChord.Em7b5;
				case I9: return ChromaticChord.FMaj9;
				case II9: return ChromaticChord.Gm9;
                case III9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA)).build();
                case IV9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
				case V9: return ChromaticChord.C9;
				case VI9: return ChromaticChord.Dm9;
                case VII9:
                    ChromaticChord.builder().diatonicDegreePattern(DiatonicDegreePattern.VII9).tonality(t).build();
				case I11: return ChromaticChord.FMaj11;
				case II11: return ChromaticChord.Gm11;
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case IV11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E)).build();
				case V11: return ChromaticChord.C11;
				case VI11: return ChromaticChord.Dm11;
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case I13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
				case II13: return ChromaticChord.Gm13;
                case III13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case IV13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G)).build();
                case V13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case VI13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.AA)).build();
                case VII13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
			}
		} else if ( t.equals( Tonality.FF ) || t.equals( Tonality.Gb ) ) {
			switch(diatonicFunction) {
                case I:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case II:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case III:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
				case IV: return ChromaticChord.B;
                case V:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case VI:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case VII:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B)).build();
                case I6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD)).build();
                case II6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.F)).build();
                case III6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.FF)).build();
				case IV6: return ChromaticChord.B6;
                case V6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA)).build();
                case VI6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.B)).build();
                case VII6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.CC)).build();
                case I7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case II7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case III7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
				case IV7: return ChromaticChord.BMaj7;
                case V7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B)).build();
                case VI7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case VII7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case I9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case II9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case III9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B)).build();
				case IV9: return ChromaticChord.BMaj9;
                case V9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case VI9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case VII9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case I11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B)).build();
                case II11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case IV11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case V11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case VI11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case I13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case II13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case III13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case IV13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case V13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case VI13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.B)).build();
                case VII13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
			}
		} else if ( t.equals( Tonality.G ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.G;
				case II: return ChromaticChord.Am;
				case III: return ChromaticChord.Bm;
				case IV: return ChromaticChord.C;
				case V: return ChromaticChord.D;
				case VI: return ChromaticChord.Em;
				case I6: return ChromaticChord.G6;
				case II6: return ChromaticChord.Am6;
                case III6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.G)).build();
				case IV6: return ChromaticChord.C6;
				case V6: return ChromaticChord.D6;
                case VI6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.C)).build();
                case VII6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.D)).build();
				case I7: return ChromaticChord.GMaj7;
				case II7: return ChromaticChord.Am7;
				case III7: return ChromaticChord.Bm7;
				case IV7: return ChromaticChord.CMaj7;
				case V7: return ChromaticChord.D7;
				case VI7: return ChromaticChord.Em7;
                case VII7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E)).build();
				case I9: return ChromaticChord.GMaj9;
				case II9: return ChromaticChord.Am9;
                case III9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C)).build();
				case IV9: return ChromaticChord.CMaj9;
				case V9: return ChromaticChord.D9;
				case VI9: return ChromaticChord.Em9;
                case VII9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G)).build();
				case I11: return ChromaticChord.GMaj11;
				case II11: return ChromaticChord.Am11;
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E)).build();
                case IV11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
				case V11: return ChromaticChord.D11;
				case VI11: return ChromaticChord.Em11;
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B)).build();
                case I13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E)).build();
				case II13: return ChromaticChord.Am13;
                case III13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G)).build();
                case IV13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A)).build();
                case V13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B)).build();
                case VI13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.C)).build();
                case VII13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.C, Chromatic.E, Chromatic.G, Chromatic.B, Chromatic.D)).build();
			}
		} else if ( t.equals( Tonality.Ab ) ) {
			switch(diatonicFunction) {
                case I:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case II:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case III:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case IV:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case V:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case VI:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case VII:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC)).build();
                case I6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.F)).build();
                case II6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.G)).build();
                case III6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.GG)).build();
                case IV6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.AA)).build();
                case V6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C)).build();
                case VI6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.CC)).build();
                case VII6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.DD)).build();
                case I7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case II7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case III7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case IV7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case V7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC)).build();
                case VI7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case VII7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case I9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case II9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case III9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC)).build();
                case IV9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case V9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case VI9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case VII9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case I11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC)).build();
                case II11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case IV11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case V11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case VI11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case I13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F)).build();
                case II13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case III13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG)).build();
                case IV13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case V13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C)).build();
                case VI13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.CC)).build();
                case VII13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.CC, Chromatic.F, Chromatic.GG, Chromatic.C, Chromatic.DD)).build();
			}
		} else if ( t.equals( Tonality.A ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.A;
				case II: return ChromaticChord.Bm;
                case III:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
				case IV: return ChromaticChord.D;
				case V: return ChromaticChord.E;
                case VI:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case VII:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D)).build();
				case I6: return ChromaticChord.A6;
				case II6: return ChromaticChord.Bm6;
                case III6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.A)).build();
				case IV6: return ChromaticChord.D6;
				case V6: return ChromaticChord.E6;
                case VI6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.D)).build();
                case VII6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.E)).build();
				case I7: return ChromaticChord.AMaj7;
				case II7: return ChromaticChord.Bm7;
                case III7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
				case IV7: return ChromaticChord.DMaj7;
				case V7: return ChromaticChord.E7;
                case VI7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
                case VII7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
				case I9: return ChromaticChord.AMaj9;
				case II9: return ChromaticChord.Bm9;
                case III9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D)).build();
				case IV9: return ChromaticChord.DMaj9;
				case V9: return ChromaticChord.E9;
                case VI9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case VII9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A)).build();
				case I11: return ChromaticChord.AMaj11;
				case II11: return ChromaticChord.Bm11;
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
                case IV11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
				case V11: return ChromaticChord.E11;
                case VI11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case I13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF)).build();
				case II13: return ChromaticChord.Bm13;
                case III13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A)).build();
                case IV13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case V13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC)).build();
                case VI13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.D)).build();
                case VII13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.D, Chromatic.FF, Chromatic.A, Chromatic.CC, Chromatic.E)).build();
			}
		} else if ( t.equals( Tonality.Bb ) ) {
			switch(diatonicFunction) {
                case I:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case II:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case III:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case IV:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case V:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C)).build();
                case VI:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case VII:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD)).build();
                case I6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.G)).build();
                case II6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.A)).build();
                case III6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.AA)).build();
                case IV6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.C)).build();
                case V6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.D)).build();
                case VI6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.DD)).build();
                case VII6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.F)).build();
                case I7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case II7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case III7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
                case IV7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case V7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD)).build();
                case VI7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case VII7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case I9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
                case II9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case III9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD)).build();
                case IV9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case V9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case VI9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case VII9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case I11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD)).build();
                case II11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case IV11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case V11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case VI11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case I13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G)).build();
                case II13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A)).build();
                case III13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA)).build();
                case IV13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C)).build();
                case V13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D)).build();
                case VI13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F, Chromatic.A, Chromatic.C, Chromatic.DD)).build();
                case VII13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.A, Chromatic.C, Chromatic.DD, Chromatic.G, Chromatic.AA, Chromatic.D, Chromatic.F)).build();
			}
		} else if ( t.equals( Tonality.B ) ) {
			switch(diatonicFunction) {
				case I: return ChromaticChord.B;
                case II:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case III:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
				case IV: return ChromaticChord.E;
                case V:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case VI:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case VII:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E)).build();
				case I6: return ChromaticChord.B6;
                case II6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.AA)).build();
                case III6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.B)).build();
				case IV6: return ChromaticChord.E6;
                case V6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.DD)).build();
                case VI6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.E)).build();
                case VII6:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.FF)).build();
				case I7: return ChromaticChord.BMaj7;
                case II7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case III7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
				case IV7: return ChromaticChord.EMaj7;
                case V7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E)).build();
                case VI7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case VII7:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
				case I9: return ChromaticChord.BMaj9;
                case II9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case III9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E)).build();
				case IV9: return ChromaticChord.EMaj9;
                case V9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case VI9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case VII9:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
				case I11: return ChromaticChord.BMaj11;
                case II11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
                case III11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case IV11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case V11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case VI11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case VII11:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case I13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG)).build();
                case II13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA)).build();
                case III13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B)).build();
                case IV13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC)).build();
                case V13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD)).build();
                case VI13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF, Chromatic.AA, Chromatic.CC, Chromatic.E)).build();
                case VII13:
                    return ChromaticChord.builder().addAll(Arrays.asList(Chromatic.AA, Chromatic.CC, Chromatic.E, Chromatic.GG, Chromatic.B, Chromatic.DD, Chromatic.FF)).build();
			}
		}

		return null;
	}
}
