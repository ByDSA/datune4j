package pitch;

import midi.FigureLength;
import midi.FigureVelocity;
import midi.Events.EventComplex;
import others.Codeable;

public interface NoteMidi extends PitchChromaticableSingle, PitchOctave, FigureLength, FigureVelocity, EventComplex, PitchMidiSingle {	
	public default <T extends NoteMidi> T set(int d, int v) {
		setVelocity(v);
		
		return setLength(d);
	}
	
	public default NoteMidi clone() {
		return this.clone();
	}
	

	@Override
	public default float getPitchMean() {
		return getCode();
	}
}
