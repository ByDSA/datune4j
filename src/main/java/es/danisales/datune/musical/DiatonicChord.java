package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.pitch.ChordCommon;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;
import java.util.Collections;

public interface DiatonicChord extends DiatonicChordCommon<Diatonic> {
	static @NonNull DiatonicChord from(@NonNull Collection<Diatonic> diatonicChord) {
		return DiatonicChordAdapter.from(diatonicChord);
	}
	
	static @NonNull DiatonicChord from(@NonNull DiatonicFunction f) {
		return DiatonicChordAdapter.from(f);
	}

	@Override
	DiatonicChord getShifted(IntervalDiatonic i);

	@Override
	default DiatonicChord getInv(int n) {
		CustomDiatonicChord ret = CustomDiatonicChord.from(this);
		if ( n == 0 )
			return ret;
		Collections.rotate(ret, -n);
		ret.setRootPos(getRootPos()-n);

		if (ret.getRootPos() != 0) {
			DiatonicChordEnum diatonicChordEnum = DiatonicChordEnum.from(ret);
			if (diatonicChordEnum != null)
				return diatonicChordEnum;
		}

		return ret;
	}
}
