package pitch;

import midi.FigureLength;
import midi.FigureVelocity;
import midi.Events.EventComplex;

public interface NoteMidi<This extends NoteMidi<This, DistType>, DistType> extends
PitchChromaticableSingle<This>, PitchOctave<This>, PitchCode<This, DistType>, FigureLength<This>, FigureVelocity<This>, EventComplex<This> {
	public static final int NOTES_PER_OCTAVE = 12;
	
	public default This set(int d, int v) {
		setVelocity(v);
		
		return setLength(d);
	}
	
	@Override
	public default float getPitchMean() {
		return getPitchCode().val();
	}
}
