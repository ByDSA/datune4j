package pitch;

import diatonic.Tonality;

public interface PitchDiatonicableChord<N extends PitchDiatonicableSingle<N>,
This extends PitchDiatonicableChord<N, This, DistType>,
DistType> extends PitchChord<N, This, DistType>, PitchDiatonicable<This> {
    public default <Array extends PitchDiatonicableChord<N, Array, DistType>> boolean hasSameNotesOrder(Array notes) {
        if (size() != notes.size())
            return false;
         
        for (int i = 0; i < size(); i++) {
            if (get(i).getDiatonic().val() != notes.get(i).getDiatonic().val())
                return false;
        }
 
        return true;
    }
    
	public default void removeHigherDuplicates() {
		This out = this.newArray();
		for(N n : this) {
			boolean found = false;

			if (!found)
				out.add(n);
		}

		this.clear();
		for(N n : out)
			add(n);
	}
	
	public ChromaticChord toChromatic(Tonality t);
}