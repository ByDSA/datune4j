package es.danisales.datune.tonality;

import java.util.stream.IntStream;

import es.danisales.datune.diatonic.IntervalChromatic;

public class ScaleException extends RuntimeException {
	public ScaleException(Scale s) {
		super( "La escala no suma " + IntervalChromatic.PERFECT_OCTAVE.getSemitones() + " semitonos, sino " + s.getValue().stream().mapToInt(Integer::intValue).sum() + ": " + ScaleNamer.distOf(s) );
	}
}