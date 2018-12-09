package pitch;

import arrays.ArrayUtils;
import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.IntervalDiatonic;
import diatonic.Tonality;
import midi.Utils;

public class DiatonicChord extends Chord<Diatonic, DiatonicChord, IntervalDiatonic>
		implements PitchDiatonicChord<Diatonic, DiatonicChord>,
		PitchMidiableChord<DiatonicChord, DiatonicChordMidi> {
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
				return TRIAD.duplicate();
			case II:
				return TRIAD.duplicate().shift( 1 );
			case III:
				return TRIAD.duplicate().shift( 2 );
			case IV:
				return TRIAD.duplicate().shift( 3 );
			case V:
				return TRIAD.duplicate().shift( 4 );
			case VI:
				return TRIAD.duplicate().shift( 5 );
			case VII:
				return TRIAD.duplicate().shift( 6 );

			case I7:
				return SEVENTH.duplicate();
			case II7:
				return SEVENTH.duplicate().shift( 1 );
			case III7:
				return SEVENTH.duplicate().shift( 2 );
			case IV7:
				return SEVENTH.duplicate().shift( 3 );
			case V7:
				return SEVENTH.duplicate().shift( 4 );
			case VI7:
				return SEVENTH.duplicate().shift( 5 );
			case VII7:
				return SEVENTH.duplicate().shift( 6 );

			case I2:
				return SUS2.duplicate();
			case II2:
				return SUS2.duplicate().shift( 1 );
			case III2:
				return SUS2.duplicate().shift( 2 );
			case IV2:
				return SUS2.duplicate().shift( 3 );
			case V2:
				return SUS2.duplicate().shift( 4 );
			case VI2:
				return SUS2.duplicate().shift( 5 );
			case VII2:
				return SUS2.duplicate().shift( 6 );

			case I4:
				return SUS4.duplicate();
			case II4:
				return SUS4.duplicate().shift( 1 );
			case III4:
				return SUS4.duplicate().shift( 2 );
			case IV4:
				return SUS4.duplicate().shift( 3 );
			case V4:
				return SUS4.duplicate().shift( 4 );
			case VI4:
				return SUS4.duplicate().shift( 5 );
			case VII4:
				return SUS4.duplicate().shift( 6 );

			case I6:
				return SIXTH.duplicate();
			case II6:
				return SIXTH.duplicate().shift( 1 );
			case III6:
				return SIXTH.duplicate().shift( 2 );
			case IV6:
				return SIXTH.duplicate().shift( 3 );
			case V6:
				return SIXTH.duplicate().shift( 4 );
			case VI6:
				return SIXTH.duplicate().shift( 5 );
			case VII6:
				return SIXTH.duplicate().shift( 6 );

			case I9:
				return NINTH.duplicate();
			case II9:
				return NINTH.duplicate().shift( 1 );
			case III9:
				return NINTH.duplicate().shift( 2 );
			case IV9:
				return NINTH.duplicate().shift( 3 );
			case V9:
				return NINTH.duplicate().shift( 4 );
			case VI9:
				return NINTH.duplicate().shift( 5 );
			case VII9:
				return NINTH.duplicate().shift( 6 );

			case I11:
				return ELEVENTH.duplicate();
			case II11:
				return ELEVENTH.duplicate().shift( 1 );
			case III11:
				return ELEVENTH.duplicate().shift( 2 );
			case IV11:
				return ELEVENTH.duplicate().shift( 3 );
			case V11:
				return ELEVENTH.duplicate().shift( 4 );
			case VI11:
				return ELEVENTH.duplicate().shift( 5 );
			case VII11:
				return ELEVENTH.duplicate().shift( 6 );

			case I13:
				return THIRTEENTH.duplicate();
			case II13:
				return THIRTEENTH.duplicate().shift( 1 );
			case III13:
				return THIRTEENTH.duplicate().shift( 2 );
			case IV13:
				return THIRTEENTH.duplicate().shift( 3 );
			case V13:
				return THIRTEENTH.duplicate().shift( 4 );
			case VI13:
				return THIRTEENTH.duplicate().shift( 5 );
			case VII13:
				return THIRTEENTH.duplicate().shift( 6 );
			case I_SECOND:
				return SUS2_O5.duplicate();
			case I_FOURTH:
				return SUS4_O5.duplicate();
			case I6_O5:
				return SIXTH_O5.duplicate();
			case I7_O3:
				return SEVENTH_O3.duplicate();
			case I7_O5:
				return SEVENTH_O5.duplicate();
			case I9_O3_O7:
				return NINTH_O3_O7.duplicate();
			case I9_O7:
				return NINTH_O7.duplicate();
			case II_SECOND:
				return SUS2_O5.duplicate().shift( 1 );
			case II_FOURTH:
				return SUS4_O5.duplicate().shift( 1 );
			case II6_O5:
				return SIXTH_O5.duplicate().shift( 1 );
			case II7_O3:
				return SEVENTH_O3.duplicate().shift( 1 );
			case II7_O5:
				return SEVENTH_O5.duplicate().shift( 1 );
			case II9_O3_O7:
				return NINTH_O3_O7.duplicate().shift( 1 );
			case II9_O7:
				return NINTH_O7.duplicate().shift( 1 );
			case III_SECOND:
				return SUS2_O5.duplicate().shift( 2 );
			case III_FOURTH:
				return SUS4_O5.duplicate().shift( 2 );
			case III6_O5:
				return SIXTH_O5.duplicate().shift( 2 );
			case III7_O3:
				return SEVENTH_O3.duplicate().shift( 2 );
			case III7_O5:
				return SEVENTH_O5.duplicate().shift( 2 );
			case III9_O3_O7:
				return NINTH_O3_O7.duplicate().shift( 2 );
			case III9_O7:
				return NINTH_O7.duplicate().shift( 2 );
			case IV_SECOND:
				return SUS2_O5.duplicate().shift( 3 );
			case IV_FOURTH:
				return SUS4_O5.duplicate().shift( 3 );
			case IV6_O5:
				return SIXTH_O5.duplicate().shift( 3 );
			case IV7_O3:
				return SEVENTH_O3.duplicate().shift( 3 );
			case IV7_O5:
				return SEVENTH_O5.duplicate().shift( 3 );
			case IV9_O3_O7:
				return NINTH_O3_O7.duplicate().shift( 3 );
			case IV9_O7:
				return NINTH_O7.duplicate().shift( 3 );
			case V_SECOND:
				return SUS2_O5.duplicate().shift( 4 );
			case V_FOURTH:
				return SUS4_O5.duplicate().shift( 4 );
			case V6_O5:
				return SIXTH_O5.duplicate().shift( 4 );
			case V7_O3:
				return SEVENTH_O3.duplicate().shift( 4 );
			case V7_O5:
				return SEVENTH_O5.duplicate().shift( 4 );
			case V9_O3_O7:
				return NINTH_O3_O7.duplicate().shift( 4 );
			case V9_O7:
				return NINTH_O7.duplicate().shift( 4 );
			case VI_SECOND:
				return SUS2_O5.duplicate().shift( 5 );
			case VI_FOURTH:
				return SUS4_O5.duplicate().shift( 5 );
			case VI6_O5:
				return SIXTH_O5.duplicate().shift( 5 );
			case VI7_O3:
				return SEVENTH_O3.duplicate().shift( 5 );
			case VI7_O5:
				return SEVENTH_O5.duplicate().shift( 5 );
			case VI9_O3_O7:
				return NINTH_O3_O7.duplicate().shift( 5 );
			case VI9_O7:
				return NINTH_O7.duplicate().shift( 5 );
			case VII_SECOND:
				return SUS2_O5.duplicate().shift( 6 );
			case VII_FOURTH:
				return SUS4_O5.duplicate().shift( 6 );
			case VII6_O5:
				return SIXTH_O5.duplicate().shift( 6 );
			case VII7_O3:
				return SEVENTH_O3.duplicate().shift( 6 );
			case VII7_O5:
				return SEVENTH_O5.duplicate().shift( 6 );
			case VII9_O3_O7:
				return NINTH_O3_O7.duplicate().shift( 6 );
			case VII9_O7:
				return NINTH_O7.duplicate().shift( 6 );
			case III_THIRD:
				return THIRD.duplicate().shift( 2 );
			case II_THIRD:
				return THIRD.duplicate().shift( 1 );
			case IV_THIRD:
				return THIRD.duplicate().shift( 3 );
			case I_THIRD:
				return THIRD.duplicate();
			case VII_THIRD:
				return THIRD.duplicate().shift( 6 );
			case VI_THIRD:
				return THIRD.duplicate().shift( 5 );
			case V_THIRD:
				return THIRD.duplicate().shift( 4 );
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

	public DiatonicChord duplicate(boolean b) {
		DiatonicChord ca;
		if ( b ) {
			ca = new DiatonicChord();
			for ( Diatonic d : this )
				ca.add( d.duplicate() );
		} else {
			Diatonic[] a = new Diatonic[size()];
			a = this.toArray( a );

			ca = new DiatonicChord( a );
		}
		return ca;
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
	public ChromaticChord toChromatic(Tonality t) {
		return toChromatic( t, null );
	}

	public ChromaticChord toChromatic(Tonality t, DiatonicFunction df) {
		ChromaticChord cc = new ChromaticChord();
		for ( Diatonic d : this )
			cc.add( d.toChromatic( t ) );

		ChromaticChord foundChord = null;
		if ( df != null )
			switch ( df ) {
				case I2:
				case II2:
				case III2:
				case IV2:
				case V2:
				case VI2:
				case VII2:
					for ( ChromaticChord c : ArrayUtils.concat(
						ChromaticChord.CHORDS_SUS2, ChromaticChord.CHORDS_SUSb2, ChromaticChord.CHORDS_SUSb2b5
					) )
						if ( cc.equalsEnharmonic( c ) ) {
							return c.duplicate();
						}
					break;
				case I4:
				case II4:
				case III4:
				case IV4:
				case V4:
				case VI4:
				case VII4:
					for ( ChromaticChord c : ArrayUtils
							.concat( ChromaticChord.CHORDS_SUS4, ChromaticChord.CHORDS_SUSa4 ) )
						if ( cc.equalsEnharmonic( c ) ) {
							return c.duplicate();
						}
					break;
				case I6:
				case II6:
				case III6:
				case IV6:
				case V6:
				case VI6:
				case VII6:
					for ( ChromaticChord c : ArrayUtils
							.concat( ChromaticChord.CHORDS_6, ChromaticChord.CHORDS_m6 ) )
						if ( cc.equalsEnharmonic( c ) ) {
							return c.duplicate();
						}
					break;
			}

		cc.updateWhatIsIt();
		assert cc.meta.str != null : "meta.str es null: " + cc.notesToString() + " " + t + " " + df + " " + t.notesToString();

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
}
