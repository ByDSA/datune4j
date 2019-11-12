package es.danisales.datune.musical;

import com.google.common.collect.ImmutableList;
import es.danisales.datune.diatonic.ChordNotation;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.midi.ChordMidi;
import es.danisales.datune.midi.PitchSingleMidi;
import es.danisales.datune.pitch.*;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;
import java.util.function.BiFunction;

public class CustomChromaticChord extends Chord<Chromatic> implements PitchChromaticChord<Chromatic>, ChordMutableInterface<Chromatic>, ChromaticChordInterface {
	private ChromaticChordMeta meta = new ChromaticChordMeta();
	private static final HashMap<List<Integer>, ArrayList<CustomChromaticChord>> sameOrderChromatics = new HashMap<>();

	static {
		for ( ChromaticChordEnum c : ChromaticChordEnum.values() ) {
			//m.updated = true;
			for ( int i = 0; i < c.size(); i++ ) {
				CustomChromaticChord c2 = new CustomChromaticChord();
				c2.addAll( c );
				if ( i > 0 )
					c2.inv( i );
				List<Integer> array = c2.toIntegerChromatics();
				// System.out.println(Arrays.toString(listOf) + c2);
				ArrayList<CustomChromaticChord> arrayListChords = sameOrderChromatics.get( array );
				if ( arrayListChords == null )
					arrayListChords = new ArrayList<>();

				//assert c2.meta.str != null : c2.notesToString();
				arrayListChords.add( c2 );
				sameOrderChromatics.put( array, arrayListChords );
			}
		}
	}

	protected CustomChromaticChord() { }
	/*
        public <T extends PitchChromaticSingle> void addSemi(Iterable<T> cs) {
            assert cs != null;
            for ( T cc : cs ) {
                assert cc != null;
                Chromatic c = cc.getChromatic();
                addSemi( c );
            }
        }
    */

	public CustomChromaticChord clone(boolean b) {
		CustomChromaticChord ca = new CustomChromaticChord();
		ca.addAll( this );
		ca.assignMeta( this );
		return ca;
	}

	public List<Integer> toIntegerChromatics() {
		Integer[] out = new Integer[size()];
		for ( int i = 0; i < size(); i++ ) {
			out[i] = get( i ).ordinal();
		}

		return ImmutableList.copyOf(out);
	}

	public CustomChromaticChord assignMeta(CustomChromaticChord c) {
		setRootPos( c.getRootPos() );
		this.meta = new ChromaticChordMeta( c.meta.quality, c.meta.str );
		this.meta.updated = c.meta.updated;

		return this;
	}

	@Override
	public Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, ChordCommon<?>, CustomChromaticChord> fSelectChord) {
		List<Integer> a = this.toIntegerChromatics();
		assert CustomChromaticChord.sameOrderChromatics != null;
		List<CustomChromaticChord> foundChords = CustomChromaticChord.sameOrderChromatics.get( a );

		if ( foundChords == null ) {
			assert meta != null;
			autoName();
			meta.updated = true;
			return null;
		}

		assert fSelectChord != null;

		CustomChromaticChord foundChord = fSelectChord.apply( foundChords, this );

		assert foundChord != null;

		this.assignMeta( foundChord );

		assert meta.str != null : ChordNamer.from(foundChord);

		meta.updated = true;

		return true;
	}

	public Boolean updateWhatIsIt() {
		return updateWhatIsIt(
				(List<CustomChromaticChord> chords, ChordCommon<?> self) -> {
					return chords.get( 0 );
				}
		);
	}

	public Boolean updateWhatIsItIfNeeded() {
		assert meta != null;
		if ( !meta.updated )
			return updateWhatIsIt();

		return false;
	}

	public String invPartString() {
		if ( getInversionNumber() > 0 )
			return "/" + get( 0 ).toString();
		else
			return "";
	}

	@Override
	public CustomChromaticChord duplicate() {
		return ChromaticChordInterface.super.duplicate();
	}

	@Override
	public String toString() {
		if ( size() == 0 )
			return ChordNotation.EMPTY_CHORD;

		if (true)
			return ChordNamer.from(this);
		updateWhatIsItIfNeeded();

		//assert meta.str != null : "meta.str es null: " + notesToString();

		return root + meta.str + invPartString();
	}

	public void autoName() {
		List<Integer> array = this.integerNotationFromRoot();

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

	public <A extends Chord<Chromatic>> boolean hasSameNotesOrder(A notes) {
		if ( size() != notes.size() || size() == 0 )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			if ( get( i ) != notes.get( i ) )
				return false;
		}

		return true;
	}

	public Quality getQuality() {
		return meta.quality;
	}

	public @Nullable CustomChromaticChord rename(@NonNull Tonality ton) {
		Objects.requireNonNull(ton);

		int rp = getRootPos();
		for ( int i = 0; i < size(); i++ ) {
			Chromatic c = get( i );
			DiatonicAlt diatonicAlt = c.rename( ton );
			if (diatonicAlt == null)
				return null;
			Chromatic c2 = Chromatic.from( diatonicAlt );

			set( i, c2 );
		}

		setRootPos( rp );

		return this;
	}

	@Override
	public List<CustomChromaticChord> getAllInversions() {
		CustomChromaticChord customChromaticChord = CustomChromaticChord.from(this);
		return customChromaticChord.getAllInversions();
	}

	public @NonNull CustomChromaticChord getOver(@NonNull Chromatic c) throws ImpossibleChordException {
		CustomChromaticChord dup = duplicate();
		for(int i = 0; i < size(); i++) {
			if ( get(0) == c )
				return dup;
			if (i < size()-1)
				dup.inv();
		}

		throw new ImpossibleChordException();
	}

	/*
    @Override
    public boolean isSus4() {
        return this.equalsEnharmonicInvArray( ChromaticChordEnum.CHORDS_SUS4 )
                || this.equalsEnharmonicInvArray( ChromaticChordEnum.CHORDS_SUSa4 );
    }

    @Override
    public boolean isSus2() {
        return this.equalsEnharmonicInvArray( ChromaticChordEnum.CHORDS_SUS2 ) || this.equalsEnharmonicInvArray(
            ChromaticChordEnum.CHORDS_SUSb2
                ) || this.equalsEnharmonicInvArray( ChromaticChordEnum.CHORDS_SUSb2b5 );
    }
     */

	@Override
	public boolean isSus4() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSus2() {
		// TODO Auto-generated method stub
		return false;
	}

	public static <T extends PitchChromaticSingle> CustomChromaticChord from(Iterable<T> chord) {
		CustomChromaticChord c = new CustomChromaticChord();
		for (T t : chord) {
			Chromatic chromatic = Chromatic.from(t);
			c.add(chromatic);
		}
		return c;
	}

	public static <N extends PitchSingleMidi> CustomChromaticChord from(ChordMidi<N> chord) {
		CustomChromaticChord c = new CustomChromaticChord();
		for (N t : chord) {
			Chromatic chromatic = Chromatic.from(t);
			c.add(chromatic);
		}
		return c;
	}

	public static <T extends PitchChromaticSingle> CustomChromaticChord from(T... cc) {
		return from( Arrays.asList(cc) );
	}

	@Override
	public <T extends ChordCommon<Chromatic>> T removeHigherDuplicates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasSameNotes(PitchChromaticChord<Chromatic> chord) {
		EnumSet<Chromatic> e = EnumSet.noneOf( Chromatic.class );
		e.addAll(this);

		EnumSet<Chromatic> ee = EnumSet.noneOf( Chromatic.class );
		ee.addAll(chord);

		return e.equals( ee );
	}

	public static CustomChromaticChord noneOf() {
		return new CustomChromaticChord();
	}
}
