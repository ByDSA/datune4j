package es.danisales.datune.musical;

import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.pitch.ChordMutable;
import es.danisales.datune.pitch.PitchMutable;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

final class DiatonicChordCustom extends ChordMutable<Diatonic, IntervalDiatonic> implements DiatonicChordInterface, PitchMutable<IntervalDiatonic> {
	DiatonicChordCustom() {
		super(new ArrayList<>());
	}

	public static @NonNull DiatonicChordCustom from(@NonNull Collection<Diatonic> diatonics) {
		DiatonicChordCustom customDiatonicChord = new DiatonicChordCustom();
		customDiatonicChord.addAll(diatonics);
		if (diatonics instanceof DiatonicChordCommon) {
			DiatonicChordCommon diatonicsCasted = (DiatonicChordCommon)diatonics;
			if (diatonicsCasted.getRootIndex() != 0)
				customDiatonicChord.setRootIndex(diatonicsCasted.getRootIndex());
		}
		return customDiatonicChord;
	}

    @Override
    public void sort(Comparator<? super Diatonic> comparator) {
        throw new UnsupportedOperationException();
    }

	public void shift(IntervalDiatonic intervalDiatonic) {
		for ( int i = 0; i < size(); i++ ) {
			set( i, get( i ).getShifted( intervalDiatonic ) );
		}
	}

	public void shiftNegative(IntervalDiatonic intervalDiatonic) {
		for ( int i = 0; i < size(); i++ ) {
			set( i, get( i ).getShiftedNegative( intervalDiatonic ) );
		}
	}

	@Override
	public DiatonicChordCustom clone() {
		return DiatonicChordCustom.from(this);
	}

	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	@Override
	public boolean equals(Object o) {
		return DiatonicChordInterfaceAdapter.equals(this, o);
	}
}
