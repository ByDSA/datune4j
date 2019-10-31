package es.danisales.datune.musical;

import es.danisales.arrays.ArrayWrapperInteger;
import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.Settings;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.*;
import es.danisales.datune.tonality.ScaleEnum;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

public class CustomChromaticChord extends Chord<Chromatic> implements PitchChromaticChord<Chromatic>, ChordMutableInterface<Chromatic> {
	protected ChromaticChordMeta meta = new ChromaticChordMeta();
	public static final HashMap<ArrayWrapperInteger, ArrayList<CustomChromaticChord>> sameOrderChromatics = new HashMap<>();

	static {
		for ( ChromaticChordEnum c : ChromaticChordEnum.values() ) {
			//m.updated = true;
			for ( int i = 0; i < c.size(); i++ ) {
				CustomChromaticChord c2 = new CustomChromaticChord();
				c2.add( c );
				if ( i > 0 )
					c2.inv( i );
				ArrayWrapperInteger array = new ArrayWrapperInteger( c2.toIntegerChromatics() );
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
	public <T extends PitchChromaticSingle> void add(@NonNull T... cs) {
		for (T t : cs) {
			Chromatic chromatic = ChromaticAdapter.from(t);
			add(chromatic);
		}
	}

	public CustomChromaticChord(ChromaticFunction f, Tonality t) {
		if ( f == ChromaticFunction.I || f == ChromaticFunction.II || f == ChromaticFunction.III
				|| f == ChromaticFunction.IV || f == ChromaticFunction.V
				|| f == ChromaticFunction.VI || f == ChromaticFunction.VII ) {
			Chromatic r = t.get( f.getDegree() );
			add( ChromaticChordEnum.whichRootIs( r, ChromaticChordEnum.CHORDS_MAJOR ) );
		} else if ( f == ChromaticFunction.i || f == ChromaticFunction.ii
				|| f == ChromaticFunction.iii
				|| f == ChromaticFunction.iv || f == ChromaticFunction.v
				|| f == ChromaticFunction.vi || f == ChromaticFunction.vii ) {
			Chromatic r = t.get( f.getDegree() );
			add( ChromaticChordEnum.whichRootIs( r, ChromaticChordEnum.CHORDS_MINOR ) );
		} else if ( f == ChromaticFunction.I0 || f == ChromaticFunction.I0
				|| f == ChromaticFunction.II0 || f == ChromaticFunction.III0
				|| f == ChromaticFunction.IV0 || f == ChromaticFunction.V0
				|| f == ChromaticFunction.VI0 || f == ChromaticFunction.VII0 ) {
			Chromatic r = t.get( f.getDegree() );
			add( ChromaticChordEnum.whichRootIs( r, ChromaticChordEnum.CHORDS_DIMINISHED ) );
		} else if ( f == ChromaticFunction.N6 ) {
			Chromatic base = t.get( 0 );

			Chromatic n1 = base.addSemi( 1 );
			Chromatic n2 = base.addSemi( 5 );
			Chromatic n3 = base.addSemi( 8 );

			add( n2, n3, n1 ); // Primera inversi�n
		} else if ( f == ChromaticFunction.I5 || f == ChromaticFunction.II5
				|| f == ChromaticFunction.III5 || f == ChromaticFunction.IV5
				|| f == ChromaticFunction.V5 || f == ChromaticFunction.VI5
				|| f == ChromaticFunction.VII5 ) {
			DiatonicDegree d = f.getDegree();

			Chromatic n = t.get( d );
			add( n );
			Chromatic n2 = n.addSemi( IntervalChromatic.PERFECT_FIFTH.getSemitones() );
			add( n2 );
		} else {
			DiatonicMidi n = null;
			switch ( f ) {
				case V_II:
					t = Tonality.createFromChord(
							new DiatonicChordMidi(
									DiatonicFunction.V, t
									.getRelativeScaleDiatonic( DiatonicDegree.II )
							), t
					);
					break;
				case V7_II:
					t = Tonality.createFromChord(
							new DiatonicChordMidi(
									DiatonicFunction.V7, t
									.getRelativeScaleDiatonic( DiatonicDegree.II )
							), t
					);
					break;
				case V_III:
					t = Tonality.createFromChord(
							new DiatonicChordMidi(
									DiatonicFunction.V, t
									.getRelativeScaleDiatonic( DiatonicDegree.III )
							), t
					);
					break;
				case V7_III:
					t = Tonality.createFromChord(
							new DiatonicChordMidi(
									DiatonicFunction.V7, t
									.getRelativeScaleDiatonic( DiatonicDegree.III )
							), t
					);
					break;
				case V_IV:
					t = Tonality.createFromChord(
							new DiatonicChordMidi(
									DiatonicFunction.V, t
									.getRelativeScaleDiatonic( DiatonicDegree.IV )
							), t
					);
					break;
				case V7_IV:
					t = Tonality.createFromChord(
							new DiatonicChordMidi(
									DiatonicFunction.V7, t
									.getRelativeScaleDiatonic( DiatonicDegree.IV )
							), t
					);
					break;
				case V_V:
					t = Tonality.createFromChord(
							new DiatonicChordMidi(
									DiatonicFunction.V, t
									.getRelativeScaleDiatonic( DiatonicDegree.V )
							), t
					);
					break;
				case V7_V:
					t = Tonality.createFromChord(
							new DiatonicChordMidi(
									DiatonicFunction.V7, t
									.getRelativeScaleDiatonic( DiatonicDegree.V )
							), t
					);
					break;
				case V_VI:
					t = Tonality.createFromChord(
							new DiatonicChordMidi(
									DiatonicFunction.V, t
									.getRelativeScaleDiatonic( DiatonicDegree.VI )
							), t
					);
					break;
				case V7_VI:
					t = Tonality.createFromChord(
							new DiatonicChordMidi(
									DiatonicFunction.V7, t
									.getRelativeScaleDiatonic( DiatonicDegree.VI )
							), t
					);
					break;
				case SUBV7:
					DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.V7, t );
					Chromatic chromatic = ChromaticAdapter.from(c.get( 0 ));
					t = Tonality.of(
							chromatic.addSemi( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case SUBV7_II:
					DiatonicChordMidi c2 = new DiatonicChordMidi(
							ChromaticFunction.V7_II, t
					);
					Chromatic chromatic2 = ChromaticAdapter.from(c2.get( 0 ));
					t = Tonality.of(
							chromatic2.addSemi( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case SUBV7_III:
					DiatonicChordMidi c3 = new DiatonicChordMidi(
							ChromaticFunction.V7_III, t
					);
					Chromatic chromatic3 = ChromaticAdapter.from(c3.get( 0 ));
					t = Tonality.of(
							chromatic3.addSemi( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case SUBV7_IV:
					DiatonicChordMidi c4 = new DiatonicChordMidi(
							ChromaticFunction.V7_IV, t
					);
					Chromatic chromatic4 = ChromaticAdapter.from(c4.get( 0 ));
					t = Tonality.of(
							chromatic4.addSemi( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case SUBV7_V:
					DiatonicChordMidi c5 = new DiatonicChordMidi(
							ChromaticFunction.V7_V, t
					);
					Chromatic chromatic5 = ChromaticAdapter.from(c5.get( 0 ));
					t = Tonality.of(
							chromatic5.addSemi( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case SUBV7_VI:
					DiatonicChordMidi c6 = new DiatonicChordMidi(
							ChromaticFunction.V7_VI, t
					);
					Chromatic chromatic6 = ChromaticAdapter.from(c6.get( 0 ));
					t = Tonality.of(
							chromatic6.addSemi( 6 ), ScaleEnum.LYDIAN_b7
					);
					break;
				case V7ALT:
					DiatonicChordMidi calt = new DiatonicChordMidi(
							DiatonicFunction.V7, t
					);
					Chromatic chromaticAlt = ChromaticAdapter.from(calt.get( 0 ));
					t = Tonality.of(
							chromaticAlt, ScaleEnum.SUPERLOCRIAN
					);
					break;
			}

			DiatonicFunction f2 = null;
			switch ( f ) {
				case V_II:
				case V_III:
				case V_IV:
				case V_V:
				case V_VI:
					f2 = DiatonicFunction.I;
					break;
				case V7_II:
				case V7_III:
				case V7_IV:
				case V7_V:
				case V7_VI:
				case SUBV7:
				case SUBV7_II:
				case SUBV7_III:
				case SUBV7_IV:
				case SUBV7_V:
				case SUBV7_VI:
				case V7ALT:
					f2 = DiatonicFunction.I7;
					break; // Ya se ha corregido la escala
			}

			DiatonicChord dc = DiatonicChord.of( f2 );
			PitchChromaticChord<Chromatic> cc = dc.toChromaticChord( t );
			add( cc );
		}
	}

	public CustomChromaticChord clone(boolean b) {
		CustomChromaticChord ca = new CustomChromaticChord();
		ca.add( this );
		ca.assignMeta( this );
		return ca;
	}

	public Integer[] toIntegerChromatics() {
		Integer[] out = new Integer[size()];
		for ( int i = 0; i < size(); i++ ) {
			out[i] = get( i ).intValue();
		}

		return out;
	}

	public CustomChromaticChord assignMeta(CustomChromaticChord c) {
		setRootPos( c.getRootPos() );
		this.meta = new ChromaticChordMeta( c.meta.quality, c.meta.str );
		this.meta.updated = c.meta.updated;

		return this;
	}

	@Override
	public Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, ChordCommon<?>, CustomChromaticChord> fSelectChord) {
		ArrayWrapperInteger a = new ArrayWrapperInteger( this.toIntegerChromatics() );
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

		assert meta.str != null : foundChord.notesToString();

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
	public String toString() {
		if ( size() == 0 )
			return ChordNotation.EMPTY_CHORD;

		if (true)
			return notesToString();
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
			if ( get( i ).intValue() != notes.get( i ).intValue() )
				return false;
		}

		return true;
	}

	public boolean has(Chromatic n) {
		for ( Chromatic n2 : this ) {
			if ( n2.equals( n ) )
				return true;
		}

		return false;
	}

	public Quality getQuality() {
		return meta.quality;
	}

	public CustomChromaticChord[] getModalChords(Tonality t) {
		HarmonicFunction f = t.getFunction( this );
		if ( f == null || f instanceof ChromaticFunction )
			return null;

		DiatonicFunction fCasted = (DiatonicFunction) f;
		List<Tonality> ts = t.getModesSameRoot();

		int i = 0;
		CustomChromaticChord[] ret = new CustomChromaticChord[t.length()];
		for ( Tonality t2 : ts ) {
			CustomChromaticChord c = new CustomChromaticChord( );
			c.add( t2.get( fCasted ) );
			ret[i++] = c;
		}

		return ret;
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
	public ChromaticChordMidi toMidi(int octave, int length, int velocity) {
		resetRootIfNeeded();
		ChromaticChordMidi ccm = ChromaticChordMidi.from(this, octave, length, velocity);

		return ccm;
	}

	public ChromaticChordMidi toMidi(int octave, int length) {
		return toMidi( octave, length, Settings.DefaultValues.VELOCITY );
	}

	public ChromaticChordMidi toMidi(int octave) {
		return toMidi( octave, Settings.DefaultValues.DURATION_CHORD );
	}

	public ChromaticChordMidi toMidi() {
		return toMidi( Settings.DefaultValues.OCTAVE );
	}

	public CustomChromaticChord rename(Tonality ton) {
		assert ton != null;
		int rp = getRootPos();
		for ( int i = 0; i < size(); i++ ) {
			Chromatic c = get( i );
			assert c != null : i + " " + this.notesToString();
			Chromatic c2 = c.rename( ton );
			assert c2 != null;
			set( i, c2 );
		}

		setRootPos( rp );

		return this;
	}

	public CustomChromaticChord over(Chromatic c) throws ImpossibleChord {
		CustomChromaticChord dup = clone();
		for(int i = 0; i < size(); i++) {
			if ( get(0).intValue() == c.intValue() )
				return dup;
			if (i < size()-1)
				dup.inv();
		}

		throw new ImpossibleChord();
	}

	@Override
	public CustomChromaticChord clone() {
		return (CustomChromaticChord)super.clone();
	}

	public static class ImpossibleChord extends RuntimeException {
		public ImpossibleChord() {
			super("Acorde imposible");
		}
	}

	@Override
	public CustomChromaticChord setRootPos(int n) {
		return (CustomChromaticChord)super.setRootPos( n );
	}

	@Override
	public CustomChromaticChord inv(int n) {
		return (CustomChromaticChord)super.inv(n);
	}

	@Override
	public CustomChromaticChord resetRoot() {
		return super.resetRoot();
	}

	public String javaNotes() {
		StringBuilder sb = new StringBuilder();
		if (this instanceof CustomChromaticChord)
			sb.append( "new ChromaticChord(" );
		boolean first = true;
		for ( Chromatic n : this ) {
			if ( first ) {
				first = false;
			} else
				sb.append( ", " );
			if (this instanceof CustomChromaticChord)
				sb.append( "Chromatic." + n );
		}
		sb.append( " );" );

		return sb.toString();
	}

	@Override
	public int getInversionNumber() {
		// TODO Auto-generated method stub
		return -1;
	}

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

	public static <T extends PitchChromaticSingle> CustomChromaticChord copyOf(Iterable<T> chord) {
		CustomChromaticChord c = new CustomChromaticChord();
		for (T t : chord)
			c.add( t );
		return c;
	}

	public static <T extends PitchChromaticSingle> CustomChromaticChord copyOf(T... cc) {
		CustomChromaticChord c = new CustomChromaticChord();
		c.add( cc );
		return c;
	}

	@Override
	public <T extends ChordCommon<Chromatic>> T removeHigherDuplicates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasSameNotes(PitchChromaticChord<Chromatic> chord) {
		EnumSet<Chromatic> e = EnumSet.noneOf( Chromatic.class );
		for (Chromatic c : this)
			e.add( c );

		EnumSet<Chromatic> ee = EnumSet.noneOf( Chromatic.class );
		for (Chromatic c :chord)
			ee.add( c );

		return e.equals( ee );
	}

	@Override
	public List integerNotationFromRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	public static CustomChromaticChord noneOf() {
		return new CustomChromaticChord();
	}
}
