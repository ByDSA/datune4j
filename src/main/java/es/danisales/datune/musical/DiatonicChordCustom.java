package es.danisales.datune.musical;

import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.pitch.Chord;
import es.danisales.datune.pitch.PitchDiatonic;
import es.danisales.datune.pitch.PitchMutable;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class DiatonicChordCustom extends Chord<Diatonic, IntervalDiatonic> implements DiatonicChordInterface, PitchMutable<IntervalDiatonic> {
	protected DiatonicChordCustom() {
		super(new ArrayList<>());
	}

	public static @NonNull DiatonicChordCustom from(@NonNull Collection<Diatonic> diatonics) {
		DiatonicChordCustom customDiatonicChord = new DiatonicChordCustom();
		customDiatonicChord.addAll(diatonics);
		if (diatonics instanceof DiatonicChordCommon) {
			DiatonicChordCommon diatonicsCasted = (DiatonicChordCommon)diatonics;
			if (diatonicsCasted.getRootPos() != 0)
				customDiatonicChord.setRootPos(diatonicsCasted.getRootPos());
		}
		return customDiatonicChord;
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
	public List<DiatonicChordCustom> getAllInversions(){
		return super.getAllInversions();
	}

	@Override
	public DiatonicChordCustom removeHigherDuplicates() {
		return (DiatonicChordCustom)super.removeHigherDuplicates();
	}

	@Override
	public DiatonicChordCustom clone() {
		return DiatonicChordCustom.from(this);
	}

	@Override
	public @NonNull DiatonicChordCustom getInv(int i) {
		DiatonicChordCustom diatonicChordCustom = clone();
		diatonicChordCustom.inv(i);
		return diatonicChordCustom;
	}

	@Override
	public @NonNull DiatonicChordCustom getWithRootPos(int i) {
		DiatonicChordCustom diatonicChordCustom = clone();
		diatonicChordCustom.setRootPos(i);
		return diatonicChordCustom;
	}

	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	@Override
	public boolean equals(Object o) {
		return DiatonicChordInterfaceAdapter.equals(this, o);
	}

	@Override
	public DiatonicChordCustom getShifted(IntervalDiatonic intervalDiatonic) {
		DiatonicChordCustom diatonicChordCustom = new DiatonicChordCustom();
		for (int i = 0; i < size(); i++)
			diatonicChordCustom.add( get(i).getShifted(intervalDiatonic) );

		return diatonicChordCustom;
	}

	@Override
	public PitchDiatonic getShiftedNegative(IntervalDiatonic intervalDiatonic) {
		DiatonicChordCustom diatonicChordCustom = new DiatonicChordCustom();
		for (int i = 0; i < size(); i++)
			diatonicChordCustom.add( get(i).getShiftedNegative(intervalDiatonic) );

		return diatonicChordCustom;
	}
}
