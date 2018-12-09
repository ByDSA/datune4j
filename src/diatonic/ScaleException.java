package diatonic;

import java.util.stream.IntStream;

public class ScaleException extends RuntimeException {
	public ScaleException(Scale s) {
		super( "La escala no suma " + IntervalChromatic.PERFECT_OCTAVE.val() + " semitonos, sino " + IntStream.of( s.val() ).sum() + ": " + s.dist() );
	}
}