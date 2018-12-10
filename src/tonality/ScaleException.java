package tonality;

import java.util.stream.IntStream;

import diatonic.IntervalChromatic;

public class ScaleException extends RuntimeException {
	public ScaleException(Scale s) {
		super( "La escala no suma " + IntervalChromatic.PERFECT_OCTAVE.val() + " semitonos, sino " + IntStream.of( s.val() ).sum() + ": " + s.dist() );
	}
}