package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.AddedException;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.pitch.Chord;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import es.danisales.datune.tonality.Tonality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

class CustomDiatonicChord extends Chord<Diatonic> implements DiatonicChord, ChordMutableInterface<Diatonic> {
    public static CustomDiatonicChord from(DiatonicChord diatonics) {
    	CustomDiatonicChord customDiatonicChord = new CustomDiatonicChord();
		customDiatonicChord.addAll(diatonics);
    	return customDiatonicChord;
    }

	@Override
	public DiatonicChord getInv(int n) {
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

    public void shift(IntervalDiatonic intervalDiatonic) {
		for ( int i = 0; i < size(); i++ ) {
			set( i, get( i ).getShifted( intervalDiatonic ) );
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

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof DiatonicChord))
			return false;

		DiatonicChord notes = (DiatonicChord)o;

		if (size() != notes.size())
			return false;

		for (int i = 0; i < size(); i++) {
			if (get(i).getDiatonic().intValue() != notes.get(i).getDiatonic().intValue())
				return false;
		}

		return true;
	}
}
