package pitch;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import arrays.ArrayUtils;
import chromaticchord.ChromaticChordEnum;
import chromaticchord.CustomChromaticChord;
import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.IntervalDiatonic;
import midi.Utils;
import tonality.Tonality;

public class DiatonicChord extends Chord<Diatonic, DiatonicChord, IntervalDiatonic>
		implements PitchDiatonicChord<Diatonic, DiatonicChord>,
		PitchMidiableChord<DiatonicChordMidi> {
	private static final DiatonicChord TRIAD = new DiatonicChord(
		Diatonic.I, Diatonic.III, Diatonic.V
	);

	private static final DiatonicChord THIRD = new DiatonicChord(
		Diatonic.I, Diatonic.III
	);

	private static final DiatonicChord SUS2 = new DiatonicChord(
		Diatonic.I, Diatonic.II, Diatonic.V
	);

	private static final DiatonicChord SUS2_O5 = new DiatonicChord(
		Diatonic.I, Diatonic.II
	);

	private static final DiatonicChord SUS4 = new DiatonicChord(
		Diatonic.I, Diatonic.IV, Diatonic.V
	);

	private static final DiatonicChord SUS4_O5 = new DiatonicChord(
		Diatonic.I, Diatonic.IV
	);

	private static final DiatonicChord SIXTH = new DiatonicChord(
		Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.VI
	);

	private static final DiatonicChord SIXTH_O5 = new DiatonicChord(
		Diatonic.I, Diatonic.III, Diatonic.VI
	);

	private static final DiatonicChord SEVENTH = new DiatonicChord(
		Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.VII
	);

	private static final DiatonicChord SEVENTH_O3 = new DiatonicChord(
		Diatonic.I, Diatonic.V, Diatonic.VII
	);

	private static final DiatonicChord SEVENTH_O5 = new DiatonicChord(
		Diatonic.I, Diatonic.III, Diatonic.VII
	);

	private static final DiatonicChord NINTH = new DiatonicChord(
		Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.VII, Diatonic.II
	);

	private static final DiatonicChord NINTH_O7 = new DiatonicChord(
		Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.II
	);

	private static final DiatonicChord NINTH_O3_O7 = new DiatonicChord(
		Diatonic.I, Diatonic.V, Diatonic.II
	);

	private static final DiatonicChord ELEVENTH = new DiatonicChord(
		Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.VII, Diatonic.II, Diatonic.IV
	);

	private static final DiatonicChord THIRTEENTH = new DiatonicChord(
		Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.VII, Diatonic.II, Diatonic.IV, Diatonic.VI
	);

	public DiatonicChord(DiatonicFunction f) {
		add( get( f ) );
	}

	public boolean add(DiatonicChord dc) {
		for ( Diatonic d : dc )
			add( d );

		return true;
	}

	private static DiatonicChord get(DiatonicFunction f) {
		assert f != null;
		switch ( f ) {
			case I:
				return TRIAD.clone();
			case II:
				return TRIAD.clone().shift( 1 );
			case III:
				return TRIAD.clone().shift( 2 );
			case IV:
				return TRIAD.clone().shift( 3 );
			case V:
				return TRIAD.clone().shift( 4 );
			case VI:
				return TRIAD.clone().shift( 5 );
			case VII:
				return TRIAD.clone().shift( 6 );

			case I7:
				return SEVENTH.clone();
			case II7:
				return SEVENTH.clone().shift( 1 );
			case III7:
				return SEVENTH.clone().shift( 2 );
			case IV7:
				return SEVENTH.clone().shift( 3 );
			case V7:
				return SEVENTH.clone().shift( 4 );
			case VI7:
				return SEVENTH.clone().shift( 5 );
			case VII7:
				return SEVENTH.clone().shift( 6 );

			case I2:
				return SUS2.clone();
			case II2:
				return SUS2.clone().shift( 1 );
			case III2:
				return SUS2.clone().shift( 2 );
			case IV2:
				return SUS2.clone().shift( 3 );
			case V2:
				return SUS2.clone().shift( 4 );
			case VI2:
				return SUS2.clone().shift( 5 );
			case VII2:
				return SUS2.clone().shift( 6 );

			case I4:
				return SUS4.clone();
			case II4:
				return SUS4.clone().shift( 1 );
			case III4:
				return SUS4.clone().shift( 2 );
			case IV4:
				return SUS4.clone().shift( 3 );
			case V4:
				return SUS4.clone().shift( 4 );
			case VI4:
				return SUS4.clone().shift( 5 );
			case VII4:
				return SUS4.clone().shift( 6 );

			case I6:
				return SIXTH.clone();
			case II6:
				return SIXTH.clone().shift( 1 );
			case III6:
				return SIXTH.clone().shift( 2 );
			case IV6:
				return SIXTH.clone().shift( 3 );
			case V6:
				return SIXTH.clone().shift( 4 );
			case VI6:
				return SIXTH.clone().shift( 5 );
			case VII6:
				return SIXTH.clone().shift( 6 );

			case I9:
				return NINTH.clone();
			case II9:
				return NINTH.clone().shift( 1 );
			case III9:
				return NINTH.clone().shift( 2 );
			case IV9:
				return NINTH.clone().shift( 3 );
			case V9:
				return NINTH.clone().shift( 4 );
			case VI9:
				return NINTH.clone().shift( 5 );
			case VII9:
				return NINTH.clone().shift( 6 );

			case I11:
				return ELEVENTH.clone();
			case II11:
				return ELEVENTH.clone().shift( 1 );
			case III11:
				return ELEVENTH.clone().shift( 2 );
			case IV11:
				return ELEVENTH.clone().shift( 3 );
			case V11:
				return ELEVENTH.clone().shift( 4 );
			case VI11:
				return ELEVENTH.clone().shift( 5 );
			case VII11:
				return ELEVENTH.clone().shift( 6 );

			case I13:
				return THIRTEENTH.clone();
			case II13:
				return THIRTEENTH.clone().shift( 1 );
			case III13:
				return THIRTEENTH.clone().shift( 2 );
			case IV13:
				return THIRTEENTH.clone().shift( 3 );
			case V13:
				return THIRTEENTH.clone().shift( 4 );
			case VI13:
				return THIRTEENTH.clone().shift( 5 );
			case VII13:
				return THIRTEENTH.clone().shift( 6 );
			case I_SECOND:
				return SUS2_O5.clone();
			case I_FOURTH:
				return SUS4_O5.clone();
			case I6_O5:
				return SIXTH_O5.clone();
			case I7_O3:
				return SEVENTH_O3.clone();
			case I7_O5:
				return SEVENTH_O5.clone();
			case I9_O3_O7:
				return NINTH_O3_O7.clone();
			case I9_O7:
				return NINTH_O7.clone();
			case II_SECOND:
				return SUS2_O5.clone().shift( 1 );
			case II_FOURTH:
				return SUS4_O5.clone().shift( 1 );
			case II6_O5:
				return SIXTH_O5.clone().shift( 1 );
			case II7_O3:
				return SEVENTH_O3.clone().shift( 1 );
			case II7_O5:
				return SEVENTH_O5.clone().shift( 1 );
			case II9_O3_O7:
				return NINTH_O3_O7.clone().shift( 1 );
			case II9_O7:
				return NINTH_O7.clone().shift( 1 );
			case III_SECOND:
				return SUS2_O5.clone().shift( 2 );
			case III_FOURTH:
				return SUS4_O5.clone().shift( 2 );
			case III6_O5:
				return SIXTH_O5.clone().shift( 2 );
			case III7_O3:
				return SEVENTH_O3.clone().shift( 2 );
			case III7_O5:
				return SEVENTH_O5.clone().shift( 2 );
			case III9_O3_O7:
				return NINTH_O3_O7.clone().shift( 2 );
			case III9_O7:
				return NINTH_O7.clone().shift( 2 );
			case IV_SECOND:
				return SUS2_O5.clone().shift( 3 );
			case IV_FOURTH:
				return SUS4_O5.clone().shift( 3 );
			case IV6_O5:
				return SIXTH_O5.clone().shift( 3 );
			case IV7_O3:
				return SEVENTH_O3.clone().shift( 3 );
			case IV7_O5:
				return SEVENTH_O5.clone().shift( 3 );
			case IV9_O3_O7:
				return NINTH_O3_O7.clone().shift( 3 );
			case IV9_O7:
				return NINTH_O7.clone().shift( 3 );
			case V_SECOND:
				return SUS2_O5.clone().shift( 4 );
			case V_FOURTH:
				return SUS4_O5.clone().shift( 4 );
			case V6_O5:
				return SIXTH_O5.clone().shift( 4 );
			case V7_O3:
				return SEVENTH_O3.clone().shift( 4 );
			case V7_O5:
				return SEVENTH_O5.clone().shift( 4 );
			case V9_O3_O7:
				return NINTH_O3_O7.clone().shift( 4 );
			case V9_O7:
				return NINTH_O7.clone().shift( 4 );
			case VI_SECOND:
				return SUS2_O5.clone().shift( 5 );
			case VI_FOURTH:
				return SUS4_O5.clone().shift( 5 );
			case VI6_O5:
				return SIXTH_O5.clone().shift( 5 );
			case VI7_O3:
				return SEVENTH_O3.clone().shift( 5 );
			case VI7_O5:
				return SEVENTH_O5.clone().shift( 5 );
			case VI9_O3_O7:
				return NINTH_O3_O7.clone().shift( 5 );
			case VI9_O7:
				return NINTH_O7.clone().shift( 5 );
			case VII_SECOND:
				return SUS2_O5.clone().shift( 6 );
			case VII_FOURTH:
				return SUS4_O5.clone().shift( 6 );
			case VII6_O5:
				return SIXTH_O5.clone().shift( 6 );
			case VII7_O3:
				return SEVENTH_O3.clone().shift( 6 );
			case VII7_O5:
				return SEVENTH_O5.clone().shift( 6 );
			case VII9_O3_O7:
				return NINTH_O3_O7.clone().shift( 6 );
			case VII9_O7:
				return NINTH_O7.clone().shift( 6 );
			case III_THIRD:
				return THIRD.clone().shift( 2 );
			case II_THIRD:
				return THIRD.clone().shift( 1 );
			case IV_THIRD:
				return THIRD.clone().shift( 3 );
			case I_THIRD:
				return THIRD.clone();
			case VII_THIRD:
				return THIRD.clone().shift( 6 );
			case VI_THIRD:
				return THIRD.clone().shift( 5 );
			case V_THIRD:
				return THIRD.clone().shift( 4 );
		}
		throw new RuntimeException( " " + f + " " );

		// return null;
	}

	public DiatonicChord(PitchDiatonicableSingle... cs) {
		assert cs != null;
		for ( int i = 0; i < cs.length; i++ ) {
			assert cs[i] != null;
			Diatonic c = cs[i].getDiatonic();
			add( c );
		}
	}

	public DiatonicChord(PitchDiatonicableChord<?, ?, ?> cs) {
		assert cs != null;
		for ( int i = 0; i < cs.size(); i++ ) {
			assert cs.get( i ) != null;
			Diatonic c = cs.get( i ).getDiatonic();
			add( c );
		}
	}

	public DiatonicChord shift(int n) {
		for ( int i = 0; i < size(); i++ ) {
			set( i, get( i ).add( n ) );
		}

		return this;
	}

	public DiatonicChord shift(Degree d) {
		return shift( d.val() );
	}

	@Override
	public DiatonicChord newArray() {
		return new DiatonicChord();
	}

	@Override
	public void removeHigherDuplicates() {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomChromaticChord toChromatic(Tonality t) {
		return toChromatic( t, null );
	}

	public CustomChromaticChord toChromatic(Tonality t, DiatonicFunction df) {
		CustomChromaticChord cc = new CustomChromaticChord();
		for ( Diatonic d : this )
			cc.add( d.toChromatic( t ) );

		CustomChromaticChord foundChord = null;
		if ( df != null )
			switch ( df ) {
				case I2:
				case II2:
				case III2:
				case IV2:
				case V2:
				case VI2:
				case VII2:
					for ( ChromaticChordEnum c : ArrayUtils.concat(
						ChromaticChordEnum.CHORDS_SUS2, ChromaticChordEnum.CHORDS_SUSb2, ChromaticChordEnum.CHORDS_SUSb2b5
					) )
						if ( cc.equalsEnharmonic( c ) ) {
							return new CustomChromaticChord( c );
						}
					break;
				case I4:
				case II4:
				case III4:
				case IV4:
				case V4:
				case VI4:
				case VII4:
					for ( ChromaticChordEnum c : ArrayUtils
							.concat( ChromaticChordEnum.CHORDS_SUS4, ChromaticChordEnum.CHORDS_SUSa4 ) )
						if ( cc.equalsEnharmonic( c ) ) {
							return new CustomChromaticChord( c );
						}
					break;
				case I6:
				case II6:
				case III6:
				case IV6:
				case V6:
				case VI6:
				case VII6:
					for ( ChromaticChordEnum c : ArrayUtils
							.concat( ChromaticChordEnum.CHORDS_6, ChromaticChordEnum.CHORDS_m6 ) )
						if ( cc.equalsEnharmonic( c ) ) {
							return new CustomChromaticChord( c );
						}
					break;
			}

		cc.updateWhatIsIt();
		//assert cc.meta.str != null : "meta.str es null: " + cc.notesToString() + " [" + t + "] [" + df + "] " + t.notesToString();

		return cc;
	}

	@Override
	public DiatonicChordMidi toMidi(Tonality t, int octave, int length, int velocity) {
		resetRootIfNeeded();
		DiatonicChordMidi dcm = new DiatonicChordMidi( t );
		for ( Diatonic d : this ) {
			if ( dcm.size() > 0
					&& dcm.get( dcm.size() - 1 ).getDegree().val() >= d.getDegree().val() )
				octave++;
			dcm.addNoReset( d.toMidi( t, octave, length, velocity ) );
			if ( d == root )
				dcm.setRoot( dcm.size() - 1 );
		}
		return dcm;
	}

	@Override
	public boolean addAll(Collection<? extends Diatonic> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Diatonic> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Diatonic get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Diatonic> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Diatonic> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Diatonic> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Diatonic set(int index, Diatonic element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Diatonic> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
