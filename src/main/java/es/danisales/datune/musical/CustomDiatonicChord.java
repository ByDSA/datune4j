package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.AddedException;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.pitch.Chord;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import es.danisales.datune.tonality.Tonality;

import java.util.*;
import java.util.function.BiFunction;

class CustomDiatonicChord extends Chord<Diatonic> implements DiatonicChordInterface, ChordMutableInterface<Diatonic> {
    public static CustomDiatonicChord from(Collection<Diatonic> diatonics) {
    	CustomDiatonicChord customDiatonicChord = new CustomDiatonicChord();
		customDiatonicChord.addAll(diatonics);
    	return customDiatonicChord;
    }

    public void shift(IntervalDiatonic intervalDiatonic) {
		for ( int i = 0; i < size(); i++ ) {
			set( i, get( i ).getShifted( intervalDiatonic ) );
		}
	}

	@Override
	public DiatonicChordInterface getShifted(IntervalDiatonic intervalDiatonic) {
		DiatonicChordInterface diatonicChord = DiatonicChordInterface.from(this);
		diatonicChord = diatonicChord.getShifted(intervalDiatonic);
		return diatonicChord;
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
	public List<DiatonicChordInterface> getAllInversions() {
		List<DiatonicChordInterface> ret = new ArrayList<>();

		ret.add( this.duplicate() );

		DiatonicChordInterface last = this;
		for ( int i = 0; i < size(); i++ ) {
			ret.add( last );
			inv();
		}

		return ret;
	}

	@Override
	public CustomDiatonicChord duplicate() {
		return CustomDiatonicChord.from(this);
	}

	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	@Override
	public boolean equals(Object o) {
		return DiatonicChordAdapter.equals(this, o);
	}
}
