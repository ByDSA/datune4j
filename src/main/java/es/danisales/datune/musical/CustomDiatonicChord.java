package es.danisales.datune.musical;

import es.danisales.datastructures.SetUtils;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.AddedException;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.*;
import es.danisales.datune.tonality.Tonality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

class CustomDiatonicChord extends Chord<Diatonic> implements DiatonicChord, ChordMutableInterface<Diatonic> {
	public void shift(IntervalDiatonic intervalDiatonic) {
		for ( int i = 0; i < size(); i++ ) {
			set( i, get( i ).shift( intervalDiatonic ) );
		}
	}

	@Override
	public DiatonicChord getShifted(IntervalDiatonic intervalDiatonic) {
		DiatonicChord diatonicChord = DiatonicChord.from(this);
		diatonicChord = diatonicChord.getShifted(intervalDiatonic);
		return diatonicChord;
	}

	@Override
	public CustomDiatonicChord clone() { // TODO
		return (CustomDiatonicChord) null;
	}

	@Override
	public Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, ChordCommon<?>, CustomChromaticChord> fSelectChord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateWhatIsItIfNeeded() {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomDiatonicChord add(Diatonic... cs) throws AddedException {
		this.addAll(Arrays.asList(cs));
		return this;
	}

	@Override
	public CustomDiatonicChord removeHigherDuplicates() {
		return (CustomDiatonicChord)super.removeHigherDuplicates();
	}

	public ChromaticMidi getDiatonicMidi(Tonality tonality, int octave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiatonicDegree getDegree() {
		return getRoot().getDegree();
	}

	@Override
	public DiatonicChord getInv(int n) {
		DiatonicChord copy = DiatonicChord.from(this);
		return copy.getInv(n);
	}

	@Override
	public List<DiatonicChord> getAllInversions() {
		List<DiatonicChord> ret = new ArrayList<>();

		ret.add( this.clone() );

		DiatonicChord last = this;
		for ( int i = 0; i < size(); i++ ) {
			ret.add( last );
			last = last.getInv();
		}

		return ret;
	}
}
