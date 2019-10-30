package es.danisales.datune.musical;

import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchDiatonic;
import es.danisales.datune.pitch.PitchDiatonicSingle;
import es.danisales.datune.tonality.Tonality;

import java.util.ArrayList;
import java.util.List;

public interface DiatonicChordCommon<N extends PitchDiatonicSingle> extends ChordCommon<N>, PitchDiatonic {
	default List<IntervalDiatonic> integerNotationFromRoot() {
		assert size() > 0;

		List<IntervalDiatonic> distancesAbsolute = new ArrayList<>();
		distancesAbsolute.add( IntervalDiatonic.UNISON );

		for ( int i = 1; i < size(); i++ ) {
			Diatonic n1 = get( 0 ).getDiatonic();
			Diatonic n2 = get( i ).getDiatonic();
			distancesAbsolute.add( n1.dist( n2 ) );
		}

		return distancesAbsolute;
	}
	
	default <Array extends DiatonicChordCommon<N>> boolean hasSameNotesOrder(Array notes) {
        if (size() != notes.size())
            return false;
         
        for (int i = 0; i < size(); i++) {
            if (get(i).getDiatonic() != notes.get(i).getDiatonic())
                return false;
        }
 
        return true;
    }
	
	DiatonicChordCommon shift(int i);
    
    // TODO
	public default DiatonicChordCommon<N> removeHigherDuplicates() {
		DiatonicChordCommon<N> out = this;
		for(N n : this) {
			boolean found = false;

			if (!found)
				out.add(n);
		}

		this.clear();
		this.addAll(out);
		
		return out;
	}
	
	public PitchChromaticChord toChromaticChord(Tonality t);
}
