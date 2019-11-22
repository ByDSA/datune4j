package es.danisales.datune.musical;

import es.danisales.datune.diatonic.ChordNotation;
import es.danisales.datune.diatonic.ChromaticDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.pitch.*;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

class ChromaticChordCustom extends Chord<Chromatic, ChromaticDegree, IntervalChromatic> implements PitchChromaticChord<Chromatic>, ChromaticChordInterface {
	ChromaticChordMeta meta = new ChromaticChordMeta();

	public static <T extends PitchChromaticSingle> @NonNull ChromaticChordCustom from(@NonNull Iterable<T> chord) {
		ChromaticChordCustom c = new ChromaticChordCustom();

		for (T t : chord) {
			Chromatic chromatic = Chromatic.from(t);
			c.add(chromatic);
		}

		return c;
	}

	ChromaticChordCustom() {
		super(new ArrayList<>());
	}

	void assignMeta(@NonNull ChromaticChordCustom c) {
		setRootPos( c.getRootPos() );
		this.meta = new ChromaticChordMeta( c.meta.quality, c.meta.str, c.meta.getPattern() );
		this.meta.updated = c.meta.updated;
	}

	@Override
	public ChromaticChordCustom duplicate() {
		ChromaticChordCustom customChromaticChord = ChromaticChordInterface.super.duplicate();
		customChromaticChord.assignMeta( this );
		return customChromaticChord;
	}

	@Override
	public @NonNull ChromaticChordCustom getInv(int i) {
		ChromaticChordCustom chromaticChordCustom = duplicate();
		chromaticChordCustom.inv(i);
		return chromaticChordCustom;
	}

	@Override
	public @NonNull ChordCommon<Chromatic, ChromaticDegree, IntervalChromatic> getWithRootPos(int i) {
		ChromaticChordCustom chromaticChordCustom = duplicate();
		chromaticChordCustom.setRootPos(i);
		return chromaticChordCustom;
	}

	public void autoName() {
		ChromaticChordPattern array = ChromaticChordPattern.from(this);

		meta.str = "";
		if ( array.size() >= 3 )
			if (array.get(1) == IntervalChromatic.DIMINISHED_THIRD.getSemitones()
					&&array.get(2) == IntervalChromatic.DIMINISHED_FIFTH.getSemitones() )
				meta.str += ChordNotation.DIMINISHED;
			else if (array.get(1) == IntervalChromatic.DIMINISHED_THIRD.getSemitones()
					&&array.get(2) == IntervalChromatic.PERFECT_FIFTH.getSemitones() )
				meta.str += ChordNotation.MINOR;
			else {
				if (array.get(1) == IntervalChromatic.MINOR_SECOND.getSemitones() )
					meta.str += ChordNotation.SUSb2;
				else if (array.get(1) == IntervalChromatic.MAJOR_SECOND.getSemitones() )
					meta.str += ChordNotation.SUS2;

				if (array.get(1) == IntervalChromatic.DIMINISHED_FOURTH.getSemitones() )
					meta.str += ChordNotation.SUSb4;
				else if (array.get(1) == IntervalChromatic.AUGMENTED_FOURTH.getSemitones() )
					meta.str += ChordNotation.SUSa4;

				if (array.get(1) == IntervalChromatic.DIMINISHED_FIFTH.getSemitones() )
					meta.str += ChordNotation.b5;
			}

		if ( array.size() >= 4 )
			if (array.get(3) == IntervalChromatic.MINOR_SEVENTH.getSemitones() )
				meta.str += ChordNotation.SEVENTH;
			else if (array.get(3) == IntervalChromatic.MAJOR_SEVENTH.getSemitones() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.SEVENTH;
			else if (array.get(3) == IntervalChromatic.DIMINISHED_SEVENTH.getSemitones() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.SEVENTH;

		if ( array.size() >= 5 )
			if ( array.get(4) == IntervalChromatic.MAJOR_NINTH.getSemitones() )
				meta.str += ChordNotation.NINTH;
			else if ( array.get(4) == IntervalChromatic.AUGMENTED_NINTH.getSemitones() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.NINTH;
			else if ( array.get(4) == IntervalChromatic.MINOR_NINTH.getSemitones() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.NINTH;

		if ( array.size() >= 6 )
			if ( array.get(5) == IntervalChromatic.PERFECT_ELEVENTH.getSemitones() )
				meta.str += ChordNotation.ELEVENTH;
			else if ( array.get(5) == IntervalChromatic.AUGMENTED_ELEVENTH.getSemitones() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.ELEVENTH;
			else if ( array.get(5) == IntervalChromatic.DIMINISHED_ELEVENTH.getSemitones() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.ELEVENTH;

		if ( array.size() >= 7 )
			if ( array.get(5) == IntervalChromatic.MINOR_THIRTEENTH.getSemitones() )
				meta.str += ChordNotation.THIRTEEN;
			else if ( array.get(5) == IntervalChromatic.MAJOR_THIRTEENTH.getSemitones() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.THIRTEEN;
			else if ( array.get(5) == IntervalChromatic.DIMINISHED_THIRTEENTH.getSemitones() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.THIRTEEN;

		if ( meta.str.equals( "" ) )
			meta.str = null;
	}

	public @NonNull Quality getQuality() {
		return meta.quality;
	}

	@Override
	public void shift(IntervalChromatic interval) {

	}

	@Override
	public void shiftNegative(IntervalChromatic interval) {

	}
}
