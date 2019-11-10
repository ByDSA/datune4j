package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchDiatonicSingle;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface DiatonicChord extends DiatonicChordCommon<Diatonic> {
	static @NonNull DiatonicChord from(@NonNull PitchDiatonicSingle... pitchDiatonicSingles) {
		Objects.requireNonNull(pitchDiatonicSingles);
		CustomDiatonicChord customDiatonicChord = new CustomDiatonicChord();
		for (PitchDiatonicSingle pitchDiatonicSingle : pitchDiatonicSingles) {
			Diatonic c = pitchDiatonicSingle.getDiatonic();
			customDiatonicChord.add(c);
		}

		return customDiatonicChord;
	}

	static @NonNull DiatonicChord from(@NonNull DiatonicChord diatonicChord) {
		Objects.requireNonNull(diatonicChord);
		CustomDiatonicChord customDiatonicChord = new CustomDiatonicChord();
		for (Diatonic diatonic : diatonicChord) {
			assert diatonic != null;
			Diatonic c = diatonic.getDiatonic();
			customDiatonicChord.add(c);
		}

		return customDiatonicChord;
	}
	
	static DiatonicChord from(DiatonicFunction f) {
		assert f != null;
		switch ( f ) {
			case I:
				return DiatonicChordEnum.TRIAD;
			case II:
				return DiatonicChordEnum.TRIAD.getShifted( IntervalDiatonic.SECOND );
			case III:
				return DiatonicChordEnum.TRIAD.getShifted( IntervalDiatonic.THIRD );
			case IV:
				return DiatonicChordEnum.TRIAD.getShifted( IntervalDiatonic.FOURTH );
			case V:
				return DiatonicChordEnum.TRIAD.getShifted( IntervalDiatonic.FIFTH);
			case VI:
				return DiatonicChordEnum.TRIAD.getShifted( IntervalDiatonic.SIXTH);
			case VII:
				return DiatonicChordEnum.TRIAD.getShifted( IntervalDiatonic.SEVENTH );

			case I7:
				return DiatonicChordEnum.SEVENTH;
			case II7:
				return DiatonicChordEnum.SEVENTH.getShifted( IntervalDiatonic.SECOND );
			case III7:
				return DiatonicChordEnum.SEVENTH.getShifted( IntervalDiatonic.THIRD );
			case IV7:
				return DiatonicChordEnum.SEVENTH.getShifted( IntervalDiatonic.FOURTH );
			case V7:
				return DiatonicChordEnum.SEVENTH.getShifted( IntervalDiatonic.FIFTH );
			case VI7:
				return DiatonicChordEnum.SEVENTH.getShifted( IntervalDiatonic.SIXTH );
			case VII7:
				return DiatonicChordEnum.SEVENTH.getShifted( IntervalDiatonic.SEVENTH );

			case I2:
				return DiatonicChordEnum.SUS2;
			case II2:
				return DiatonicChordEnum.SUS2.getShifted( IntervalDiatonic.SECOND );
			case III2:
				return DiatonicChordEnum.SUS2.getShifted( IntervalDiatonic.THIRD );
			case IV2:
				return DiatonicChordEnum.SUS2.getShifted( IntervalDiatonic.FOURTH );
			case V2:
				return DiatonicChordEnum.SUS2.getShifted( IntervalDiatonic.FIFTH );
			case VI2:
				return DiatonicChordEnum.SUS2.getShifted( IntervalDiatonic.SIXTH );
			case VII2:
				return DiatonicChordEnum.SUS2.getShifted( IntervalDiatonic.SEVENTH );

			case I4:
				return DiatonicChordEnum.SUS4;
			case II4:
				return DiatonicChordEnum.SUS4.getShifted( IntervalDiatonic.SECOND );
			case III4:
				return DiatonicChordEnum.SUS4.getShifted( IntervalDiatonic.THIRD );
			case IV4:
				return DiatonicChordEnum.SUS4.getShifted( IntervalDiatonic.FOURTH );
			case V4:
				return DiatonicChordEnum.SUS4.getShifted( IntervalDiatonic.FIFTH );
			case VI4:
				return DiatonicChordEnum.SUS4.getShifted( IntervalDiatonic.SIXTH );
			case VII4:
				return DiatonicChordEnum.SUS4.getShifted( IntervalDiatonic.SEVENTH );

			case I6:
				return DiatonicChordEnum.SIXTH;
			case II6:
				return DiatonicChordEnum.SIXTH.getShifted( IntervalDiatonic.SECOND );
			case III6:
				return DiatonicChordEnum.SIXTH.getShifted( IntervalDiatonic.THIRD );
			case IV6:
				return DiatonicChordEnum.SIXTH.getShifted( IntervalDiatonic.FOURTH );
			case V6:
				return DiatonicChordEnum.SIXTH.getShifted( IntervalDiatonic.FIFTH );
			case VI6:
				return DiatonicChordEnum.SIXTH.getShifted( IntervalDiatonic.SIXTH );
			case VII6:
				return DiatonicChordEnum.SIXTH.getShifted( IntervalDiatonic.SEVENTH );
			case I9:
				return DiatonicChordEnum.NINTH;
			case II9:
				return DiatonicChordEnum.NINTH.getShifted( IntervalDiatonic.SECOND );
			case III9:
				return DiatonicChordEnum.NINTH.getShifted( IntervalDiatonic.THIRD );
			case IV9:
				return DiatonicChordEnum.NINTH.getShifted( IntervalDiatonic.FOURTH );
			case V9:
				return DiatonicChordEnum.NINTH.getShifted( IntervalDiatonic.FIFTH );
			case VI9:
				return DiatonicChordEnum.NINTH.getShifted( IntervalDiatonic.SIXTH );
			case VII9:
				return DiatonicChordEnum.NINTH.getShifted( IntervalDiatonic.SEVENTH );

			case I11:
				return DiatonicChordEnum.ELEVENTH;
			case II11:
				return DiatonicChordEnum.ELEVENTH.getShifted( IntervalDiatonic.SECOND );
			case III11:
				return DiatonicChordEnum.ELEVENTH.getShifted( IntervalDiatonic.THIRD );
			case IV11:
				return DiatonicChordEnum.ELEVENTH.getShifted( IntervalDiatonic.FOURTH );
			case V11:
				return DiatonicChordEnum.ELEVENTH.getShifted( IntervalDiatonic.FIFTH );
			case VI11:
				return DiatonicChordEnum.ELEVENTH.getShifted( IntervalDiatonic.SIXTH );
			case VII11:
				return DiatonicChordEnum.ELEVENTH.getShifted( IntervalDiatonic.SEVENTH );

			case I13:
				return DiatonicChordEnum.THIRTEENTH;
			case II13:
				return DiatonicChordEnum.THIRTEENTH.getShifted( IntervalDiatonic.SECOND );
			case III13:
				return DiatonicChordEnum.THIRTEENTH.getShifted( IntervalDiatonic.THIRD );
			case IV13:
				return DiatonicChordEnum.THIRTEENTH.getShifted( IntervalDiatonic.FOURTH );
			case V13:
				return DiatonicChordEnum.THIRTEENTH.getShifted( IntervalDiatonic.FIFTH );
			case VI13:
				return DiatonicChordEnum.THIRTEENTH.getShifted( IntervalDiatonic.SIXTH );
			case VII13:
				return DiatonicChordEnum.THIRTEENTH.getShifted( IntervalDiatonic.SEVENTH );
			case I_SECOND:
				return DiatonicChordEnum.SUS2_O5;
			case I_FOURTH:
				return DiatonicChordEnum.SUS4_O5;
			case I6_O5:
				return DiatonicChordEnum.SIXTH_O5;
			case I7_O3:
				return DiatonicChordEnum.SEVENTH_O3;
			case I7_O5:
				return DiatonicChordEnum.SEVENTH_O5;
			case I9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7;
			case I9_O7:
				return DiatonicChordEnum.NINTH_O7;
			case II_SECOND:
				return DiatonicChordEnum.SUS2_O5.getShifted( IntervalDiatonic.SECOND );
			case II_FOURTH:
				return DiatonicChordEnum.SUS4_O5.getShifted( IntervalDiatonic.SECOND );
			case II6_O5:
				return DiatonicChordEnum.SIXTH_O5.getShifted( IntervalDiatonic.SECOND );
			case II7_O3:
				return DiatonicChordEnum.SEVENTH_O3.getShifted( IntervalDiatonic.SECOND );
			case II7_O5:
				return DiatonicChordEnum.SEVENTH_O5.getShifted( IntervalDiatonic.SECOND );
			case II9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.getShifted( IntervalDiatonic.SECOND );
			case II9_O7:
				return DiatonicChordEnum.NINTH_O7.getShifted( IntervalDiatonic.SECOND );
			case III_SECOND:
				return DiatonicChordEnum.SUS2_O5.getShifted( IntervalDiatonic.THIRD );
			case III_FOURTH:
				return DiatonicChordEnum.SUS4_O5.getShifted( IntervalDiatonic.THIRD );
			case III6_O5:
				return DiatonicChordEnum.SIXTH_O5.getShifted( IntervalDiatonic.THIRD );
			case III7_O3:
				return DiatonicChordEnum.SEVENTH_O3.getShifted( IntervalDiatonic.THIRD );
			case III7_O5:
				return DiatonicChordEnum.SEVENTH_O5.getShifted( IntervalDiatonic.THIRD );
			case III9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.getShifted( IntervalDiatonic.THIRD );
			case III9_O7:
				return DiatonicChordEnum.NINTH_O7.getShifted( IntervalDiatonic.THIRD );
			case IV_SECOND:
				return DiatonicChordEnum.SUS2_O5.getShifted( IntervalDiatonic.FOURTH );
			case IV_FOURTH:
				return DiatonicChordEnum.SUS4_O5.getShifted( IntervalDiatonic.FOURTH );
			case IV6_O5:
				return DiatonicChordEnum.SIXTH_O5.getShifted( IntervalDiatonic.FOURTH );
			case IV7_O3:
				return DiatonicChordEnum.SEVENTH_O3.getShifted( IntervalDiatonic.FOURTH );
			case IV7_O5:
				return DiatonicChordEnum.SEVENTH_O5.getShifted( IntervalDiatonic.FOURTH );
			case IV9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.getShifted( IntervalDiatonic.FOURTH );
			case IV9_O7:
				return DiatonicChordEnum.NINTH_O7.getShifted( IntervalDiatonic.FOURTH );
			case V_SECOND:
				return DiatonicChordEnum.SUS2_O5.getShifted( IntervalDiatonic.FIFTH );
			case V_FOURTH:
				return DiatonicChordEnum.SUS4_O5.getShifted( IntervalDiatonic.FIFTH );
			case V6_O5:
				return DiatonicChordEnum.SIXTH_O5.getShifted( IntervalDiatonic.FIFTH );
			case V7_O3:
				return DiatonicChordEnum.SEVENTH_O3.getShifted( IntervalDiatonic.FIFTH );
			case V7_O5:
				return DiatonicChordEnum.SEVENTH_O5.getShifted( IntervalDiatonic.FIFTH );
			case V9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.getShifted( IntervalDiatonic.FIFTH );
			case V9_O7:
				return DiatonicChordEnum.NINTH_O7.getShifted( IntervalDiatonic.FIFTH );
			case VI_SECOND:
				return DiatonicChordEnum.SUS2_O5.getShifted( IntervalDiatonic.SIXTH );
			case VI_FOURTH:
				return DiatonicChordEnum.SUS4_O5.getShifted( IntervalDiatonic.SIXTH );
			case VI6_O5:
				return DiatonicChordEnum.SIXTH_O5.getShifted( IntervalDiatonic.SIXTH );
			case VI7_O3:
				return DiatonicChordEnum.SEVENTH_O3.getShifted( IntervalDiatonic.SIXTH );
			case VI7_O5:
				return DiatonicChordEnum.SEVENTH_O5.getShifted( IntervalDiatonic.SIXTH );
			case VI9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.getShifted( IntervalDiatonic.SIXTH );
			case VI9_O7:
				return DiatonicChordEnum.NINTH_O7.getShifted( IntervalDiatonic.SIXTH );
			case VII_SECOND:
				return DiatonicChordEnum.SUS2_O5.getShifted( IntervalDiatonic.SEVENTH );
			case VII_FOURTH:
				return DiatonicChordEnum.SUS4_O5.getShifted( IntervalDiatonic.SEVENTH );
			case VII6_O5:
				return DiatonicChordEnum.SIXTH_O5.getShifted( IntervalDiatonic.SEVENTH );
			case VII7_O3:
				return DiatonicChordEnum.SEVENTH_O3.getShifted( IntervalDiatonic.SEVENTH );
			case VII7_O5:
				return DiatonicChordEnum.SEVENTH_O5.getShifted( IntervalDiatonic.SEVENTH );
			case VII9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.getShifted( IntervalDiatonic.SEVENTH );
			case VII9_O7:
				return DiatonicChordEnum.NINTH_O7.getShifted( IntervalDiatonic.SEVENTH );
			case III_THIRD:
				return DiatonicChordEnum.THIRD.getShifted( IntervalDiatonic.THIRD );
			case II_THIRD:
				return DiatonicChordEnum.THIRD.getShifted( IntervalDiatonic.SECOND );
			case IV_THIRD:
				return DiatonicChordEnum.THIRD.getShifted( IntervalDiatonic.FOURTH );
			case I_THIRD:
				return DiatonicChordEnum.THIRD;
			case VII_THIRD:
				return DiatonicChordEnum.THIRD.getShifted( IntervalDiatonic.SEVENTH );
			case VI_THIRD:
				return DiatonicChordEnum.THIRD.getShifted( IntervalDiatonic.SIXTH );
			case V_THIRD:
				return DiatonicChordEnum.THIRD.getShifted( IntervalDiatonic.FIFTH );
		}
		throw new RuntimeException( " " + f + " " );

		// return null;
	}
	
	default boolean hasSameNotesOrder(DiatonicChord notes) {
        if (size() != notes.size())
            return false;
         
        for (int i = 0; i < size(); i++) {
            if (get(i).getDiatonic().intValue() != notes.get(i).getDiatonic().intValue())
                return false;
        }
 
        return true;
    }
	
	DiatonicChord getShifted(IntervalDiatonic i);
}
