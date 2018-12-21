package pitch;

import java.util.ArrayList;
import java.util.List;

import diatonic.IntervalDiatonic;
import musical.Diatonic;
import tonality.Tonality;

public interface PitchDiatonicChord<N extends PitchDiatonicSingle> extends ChordInterface<N> {
	public default List<IntervalDiatonic> integerNotationFromRoot() {
		assert size() > 0;

		List<IntervalDiatonic> distancesAbsolute = new ArrayList();
		distancesAbsolute.add( IntervalDiatonic.UNISON );

		for ( int i = 1; i < size(); i++ ) {
			Diatonic n1 = get( 0 ).getDiatonic();
			Diatonic n2 = get( i ).getDiatonic();
			distancesAbsolute.add( n1.dist( n2 ) );
		}

		return distancesAbsolute;
	}
	
	public default <Array extends PitchDiatonicChord<N>> boolean hasSameNotesOrder(Array notes) {
        if (size() != notes.size())
            return false;
         
        for (int i = 0; i < size(); i++) {
            if (get(i).getDiatonic().val() != notes.get(i).getDiatonic().val())
                return false;
        }
 
        return true;
    }
    
    // TODO
	public default PitchDiatonicChord<N> removeHigherDuplicates() {
		PitchDiatonicChord<N> out = this;
		for(N n : this) {
			boolean found = false;

			if (!found)
				out.add(n);
		}

		this.clear();
		for(N n : out)
			add(n);
		
		return out;
	}
	
	public PitchChromaticChord toChromaticChord(Tonality t);
}
