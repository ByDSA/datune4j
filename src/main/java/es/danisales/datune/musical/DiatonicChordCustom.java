package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.AddedException;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.pitch.AbsoluteDegree;
import es.danisales.datune.pitch.Chord;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import es.danisales.datune.tonality.Tonality;

import java.util.*;
import java.util.function.BiFunction;

class DiatonicChordCustom extends Chord<Diatonic> implements DiatonicChordInterface, ChordMutableInterface<Diatonic> {
	public static DiatonicChordCustom from(Collection<Diatonic> diatonics) {
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

	@Override
	public List<DiatonicChordCustom> getAllInversions(){
		return super.getAllInversions();
	}

	@Override
	public Boolean updateWhatIsIt(BiFunction<List<ChromaticChord>, ChordCommon<?>, ChromaticChord> fSelectChord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateWhatIsItIfNeeded() {
		// TODO Auto-generated method stub
		return null;
	}

	public DiatonicChordCustom add(Diatonic... cs) throws AddedException {
		this.addAll(Arrays.asList(cs));
		return this;
	}

	@Override
	public DiatonicChordCustom removeHigherDuplicates() {
		return (DiatonicChordCustom)super.removeHigherDuplicates();
	}

	@Override
	public DiatonicChordCustom duplicate() {
		return DiatonicChordCustom.from(this);
	}

	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	@Override
	public boolean equals(Object o) {
		return DiatonicChordAdapter.equals(this, o);
	}
}
