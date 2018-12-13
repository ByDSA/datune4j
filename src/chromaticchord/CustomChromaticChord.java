package chromaticchord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

import arrays.ArrayUtils;
import arrays.ArrayWrapperInteger;
import diatonic.ChordNotation;
import diatonic.ChromaticFunction;
import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.HarmonicFunction;
import diatonic.IntervalChromatic;
import diatonic.IntervalDiatonic;
import diatonic.Quality;
import midi.Settings;
import pitch.Chord;
import pitch.Chromatic;
import pitch.ChromaticChordMidi;
import pitch.ChromaticMidi;
import pitch.CustomDiatonicChord;
import pitch.DiatonicChordMidi;
import pitch.DiatonicMidi;
import pitch.PitchChord;
import pitch.PitchChordMutable;
import pitch.PitchChromaticChord;
import pitch.PitchChromaticableSingle;
import tonality.ScaleEnum;
import tonality.Tonality;
import tonality.TonalityException;

public class CustomChromaticChord extends Chord<Chromatic, Integer> implements PitchChromaticChord<Chromatic>, PitchChordMutable<Chromatic, Integer> {
	public ChromaticChordMeta meta = new ChromaticChordMeta(); // TODO: protected
	public static final HashMap<ArrayWrapperInteger, ArrayList<CustomChromaticChord>> sameOrderChromatics = new HashMap();

	static {
		for ( ChromaticChordEnum[] group : ArrayUtils.concat( ChromaticChordEnum.COMMON_CHORDS_GROUP, ChromaticChordEnum.UNUSUAL_CHORDS_GROUPS ) )
			for ( ChromaticChordEnum c : group ) {
				//m.updated = true;
				for ( int i = 0; i < c.size(); i++ ) {
					CustomChromaticChord c2 = new CustomChromaticChord( c );
					if ( i > 0 )
						c2.inv( i );
					ArrayWrapperInteger array = new ArrayWrapperInteger( c2.toIntegerChromatics() );
					// System.out.println(Arrays.toString(array) + c2);
					ArrayList<CustomChromaticChord> arrayListChords = sameOrderChromatics.get( array );
					if ( arrayListChords == null )
						arrayListChords = new ArrayList<>();

					//assert c2.meta.str != null : c2.notesToString();
					arrayListChords.add( c2 );
					sameOrderChromatics.put( array, arrayListChords );
				}
			}
	}

	public CustomChromaticChord(PitchChromaticableSingle... cs) {
		assert cs != null;
		for ( int i = 0; i < cs.length; i++ ) {
			assert cs[i] != null;
			Chromatic c = cs[i].getChromatic();
			add( c );
		}
	}

	public CustomChromaticChord(List<? extends PitchChromaticableSingle> cs) {
		assert cs != null;
		for ( int i = 0; i < cs.size(); i++ ) {
			assert cs.get( i ) != null;
			Chromatic c = cs.get( i ).getChromatic();
			add( c );
		}
	}

	public CustomChromaticChord(ChromaticFunction f, Tonality t) {
		if ( f == ChromaticFunction.I || f == ChromaticFunction.II || f == ChromaticFunction.III
				|| f == ChromaticFunction.IV || f == ChromaticFunction.V
				|| f == ChromaticFunction.VI || f == ChromaticFunction.VII ) {
			int index = t.get( f.getDegree() ).val();
			add( ChromaticChordEnum.CHORDS_MAJOR[index] );
		} else if ( f == ChromaticFunction.i || f == ChromaticFunction.ii
				|| f == ChromaticFunction.iii
				|| f == ChromaticFunction.iv || f == ChromaticFunction.v
				|| f == ChromaticFunction.vi || f == ChromaticFunction.vii ) {
			int index = t.get( f.getDegree() ).val();
			add( ChromaticChordEnum.CHORDS_MINOR[index] );
		} else if ( f == ChromaticFunction.I0 || f == ChromaticFunction.I0
				|| f == ChromaticFunction.II0 || f == ChromaticFunction.III0
				|| f == ChromaticFunction.IV0 || f == ChromaticFunction.V0
				|| f == ChromaticFunction.VI0 || f == ChromaticFunction.VII0 ) {
			int index = t.get( f.getDegree() ).val();
			add( ChromaticChordEnum.CHORDS_DIMINISHED[index] );
		} else if ( f == ChromaticFunction.N6 ) {
			Chromatic base = t.get( 0 );

			Chromatic n1 = base.add( 1 );
			Chromatic n2 = base.add( 5 );
			Chromatic n3 = base.add( 8 );

			add( n2, n3, n1 ); // Primera inversión
		} else if ( f == ChromaticFunction.I5 || f == ChromaticFunction.II5
				|| f == ChromaticFunction.III5 || f == ChromaticFunction.IV5
				|| f == ChromaticFunction.V5 || f == ChromaticFunction.VI5
				|| f == ChromaticFunction.VII5 ) {
			Degree d = f.getDegree();

			Chromatic n = t.get( d );
			add( n );
			Chromatic n2 = n.add( IntervalChromatic.PERFECT_FIFTH.val() );
			add( n2 );
		} else {
			DiatonicMidi n = null;
			switch ( f ) {
				case V_II:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, t
							.getRelativeScaleDiatonic( IntervalDiatonic.SECOND )
								), t
							);
					break;
				case V7_II:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, t
							.getRelativeScaleDiatonic( IntervalDiatonic.SECOND )
								), t
							);
					break;
				case V_III:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, t
							.getRelativeScaleDiatonic( IntervalDiatonic.THIRD )
								), t
							);
					break;
				case V7_III:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, t
							.getRelativeScaleDiatonic( IntervalDiatonic.THIRD )
								), t
							);
					break;
				case V_IV:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, t
							.getRelativeScaleDiatonic( IntervalDiatonic.FOURTH )
								), t
							);
					break;
				case V7_IV:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, t
							.getRelativeScaleDiatonic( IntervalDiatonic.FOURTH )
								), t
							);
					break;
				case V_V:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, t
							.getRelativeScaleDiatonic( IntervalDiatonic.FIFTH )
								), t
							);
					break;
				case V7_V:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, t
							.getRelativeScaleDiatonic( IntervalDiatonic.FIFTH )
								), t
							);
					break;
				case V_VI:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V, t
							.getRelativeScaleDiatonic( IntervalDiatonic.SIXTH )
								), t
							);
					break;
				case V7_VI:
					t = Tonality.createFromChord(
						new DiatonicChordMidi(
							DiatonicFunction.V7, t
							.getRelativeScaleDiatonic( IntervalDiatonic.SIXTH )
								), t
							);
					break;
				case SUBV7:
					DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.V7, t );
					t = Tonality.of(
						c.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case SUBV7_II:
					DiatonicChordMidi c2 = new DiatonicChordMidi(
						ChromaticFunction.V7_II, t
							);
					t = Tonality.of(
						c2.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case SUBV7_III:
					DiatonicChordMidi c3 = new DiatonicChordMidi(
						ChromaticFunction.V7_III, t
							);
					t = Tonality.of(
						c3.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case SUBV7_IV:
					DiatonicChordMidi c4 = new DiatonicChordMidi(
						ChromaticFunction.V7_IV, t
							);
					t = Tonality.of(
						c4.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case SUBV7_V:
					DiatonicChordMidi c5 = new DiatonicChordMidi(
						ChromaticFunction.V7_V, t
							);
					t = Tonality.of(
						c5.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case SUBV7_VI:
					DiatonicChordMidi c6 = new DiatonicChordMidi(
						ChromaticFunction.V7_VI, t
							);
					t = Tonality.of(
						c6.get( 0 ).toChromaticMidi().getChromatic().add( 6 ), ScaleEnum.LYDIAN_b7
							);
					break;
				case V7ALT:
					DiatonicChordMidi calt = new DiatonicChordMidi(
						DiatonicFunction.V7, t
							);
					t = Tonality.of(
						calt.get( 0 ).toChromaticMidi().getChromatic(), ScaleEnum.SUPERLOCRIAN
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

			CustomDiatonicChord dc = new CustomDiatonicChord( f2 );
			CustomChromaticChord cc = dc.toChromatic( t );
			add( cc );
		}

	}

	public CustomChromaticChord clone(boolean b) {
		Chromatic[] a = new Chromatic[size()];
		a = this.toArray( a );

		CustomChromaticChord ca = new CustomChromaticChord( a );
		ca.assignMeta( this );
		return ca;
	}

	public Integer[] toIntegerChromatics() {
		Integer[] out = new Integer[size()];
		for ( int i = 0; i < size(); i++ ) {
			out[i] = get( i ).val();
		}

		return out;
	}

	public CustomChromaticChord assignMeta(CustomChromaticChord c) {
		setRoot( c.getRootPos() );
		this.meta.quality = c.meta.quality;
		this.meta.str = c.meta.str;
		this.meta.updated = c.meta.updated;

		return this;
	}

	@Override
	public Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, PitchChord<?, ?>, CustomChromaticChord> fSelectChord) {
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
			(List<CustomChromaticChord> chords, PitchChord<?, ?> self) -> {
				return chords.get( 0 );
			}
				);
	}

	public Boolean updateWhatIsItIfNeeded() {
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

		updateWhatIsItIfNeeded();

		//assert meta.str != null : "meta.str es null: " + notesToString();

		return root + meta.str + invPartString();
	}

	public void autoName() {
		Integer[] array = this.integerNotationFromRoot();

		meta.str = "";
		if ( array.length >= 3 )
			if ( array[1] == IntervalChromatic.DIMINISHED_THIRD.val()
			&& array[2] == IntervalChromatic.DIMINISHED_FIFTH.val() )
				meta.str += ChordNotation.DIMINISHED;
			else if ( array[1] == IntervalChromatic.DIMINISHED_THIRD.val()
					&& array[2] == IntervalChromatic.PERFECT_FIFTH.val() )
				meta.str += ChordNotation.MINOR;
			else {
				if ( array[1] == IntervalChromatic.MINOR_SECOND.val() )
					meta.str += ChordNotation.SUSb2;
				else if ( array[1] == IntervalChromatic.MAJOR_SECOND.val() )
					meta.str += ChordNotation.SUS2;

				if ( array[1] == IntervalChromatic.DIMINISHED_FOURTH.val() )
					meta.str += ChordNotation.SUSb4;
				else if ( array[1] == IntervalChromatic.AUGMENTED_FOURTH.val() )
					meta.str += ChordNotation.SUSa4;

				if ( array[1] == IntervalChromatic.DIMINISHED_FIFTH.val() )
					meta.str += ChordNotation.b5;
			}

		if ( array.length >= 4 )
			if ( array[3] == IntervalChromatic.MINOR_SEVENTH.val() )
				meta.str += ChordNotation.SEVENTH;
			else if ( array[3] == IntervalChromatic.MAJOR_SEVENTH.val() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.SEVENTH;
			else if ( array[3] == IntervalChromatic.DIMINISHED_SEVENTH.val() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.SEVENTH;

		if ( array.length >= 5 )
			if ( array[4] == IntervalChromatic.MAJOR_NINTH.val() )
				meta.str += ChordNotation.NINTH;
			else if ( array[4] == IntervalChromatic.AUGMENTED_NINTH.val() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.NINTH;
			else if ( array[4] == IntervalChromatic.MINOR_NINTH.val() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.NINTH;

		if ( array.length >= 6 )
			if ( array[5] == IntervalChromatic.PERFECT_ELEVENTH.val() )
				meta.str += ChordNotation.ELEVENTH;
			else if ( array[5] == IntervalChromatic.AUGMENTED_ELEVENTH.val() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.ELEVENTH;
			else if ( array[5] == IntervalChromatic.DIMINISHED_ELEVENTH.val() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.ELEVENTH;

		if ( array.length >= 7 )
			if ( array[5] == IntervalChromatic.MINOR_THIRTEENTH.val() )
				meta.str += ChordNotation.THIRTEEN;
			else if ( array[5] == IntervalChromatic.MAJOR_THIRTEENTH.val() )
				meta.str += ChordNotation.MAJOR2 + ChordNotation.THIRTEEN;
			else if ( array[5] == IntervalChromatic.DIMINISHED_THIRTEENTH.val() )
				meta.str += ChordNotation.DIMINISHED2 + ChordNotation.THIRTEEN;

		if ( meta.str.equals( "" ) )
			meta.str = null;
	}

	public <A extends Chord<Chromatic, ?>> boolean hasSameNotesOrder(A notes) {
		if ( size() != notes.size() || size() == 0 )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			if ( get( i ).val() != notes.get( i ).val() )
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
		for ( Tonality t2 : ts )
			ret[i++] = new CustomChromaticChord( t2.get( fCasted ) );

		return ret;
	}

	@Override
	public CustomChromaticChord newArray() {
		return new CustomChromaticChord();
	}

	@Override
	public float getPitchMean() {
		int sum = 0, oct = 0;
		Chromatic last = null;
		for ( Chromatic c : this ) {
			if ( last != null && c.val() <= last.val() )
				oct++;
			sum += oct * ChromaticMidi.NOTES_PER_OCTAVE + c.val();
		}
		return ( (float) sum ) / size();
	}

	@Override
	public DiatonicChordMidi toDiatonicChordMidi(Tonality ton) throws TonalityException {
		return this.toMidi().toDiatonicChordMidi( ton );
	}

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

	@Override
	public void removeHigherDuplicates() {
		// TODO Auto-generated method stub

	}

	public ChromaticChordMidi toMidi(int octave, int length, int velocity) {
		resetRootIfNeeded();
		ChromaticChordMidi ccm = new ChromaticChordMidi(this, octave, length, velocity);

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

		setRoot( rp );

		return this;
	}

	public CustomChromaticChord over(Chromatic c) throws ImpossibleChord {
		CustomChromaticChord dup = clone();
		for(int i = 0; i < size(); i++) {
			if ( get(0).val() == c.val() )
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
	public CustomChromaticChord getChromatic() {
		return this;
	}

	@Override
	public CustomChromaticChord setRoot(int n) {
		return (CustomChromaticChord)super.setRoot( n );
	}

	@Override
	public CustomChromaticChord inv() {
		return super.inv();
	}

	@Override
	public CustomChromaticChord inv(int n) {
		return super.inv(n);
	}

	@Override
	public CustomChromaticChord resetRoot() {
		return super.resetRoot();
	}
}
