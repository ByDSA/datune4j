package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.tonality.Tonality;

import java.util.ArrayList;
import java.util.List;

public interface DiatonicChord extends DiatonicChordCommon<Diatonic> {
	default List<IntervalDiatonic> integerNotationFromRoot() {
		assert size() > 0;

		List<IntervalDiatonic> distancesAbsolute = new ArrayList<>();
		distancesAbsolute.add( IntervalDiatonic.UNISON );

		for ( int i = 1; i < size(); i++ ) {
			Diatonic n1 = get( 0 ).getDiatonic();
			Diatonic n2 = get( i ).getDiatonic();
			distancesAbsolute.add( n1.dist( n2 ) );
		}

		return distancesAbsolute;
	}
	
	static DiatonicChord of(DiatonicFunction f) {
		assert f != null;
		switch ( f ) {
			case I:
				return DiatonicChordEnum.TRIAD;
			case II:
				return DiatonicChordEnum.TRIAD.shift( 1 );
			case III:
				return DiatonicChordEnum.TRIAD.shift( 2 );
			case IV:
				return DiatonicChordEnum.TRIAD.shift( 3 );
			case V:
				return DiatonicChordEnum.TRIAD.shift( 4 );
			case VI:
				return DiatonicChordEnum.TRIAD.shift( 5 );
			case VII:
				return DiatonicChordEnum.TRIAD.shift( 6 );

			case I7:
				return DiatonicChordEnum.SEVENTH;
			case II7:
				return DiatonicChordEnum.SEVENTH.shift( 1 );
			case III7:
				return DiatonicChordEnum.SEVENTH.shift( 2 );
			case IV7:
				return DiatonicChordEnum.SEVENTH.shift( 3 );
			case V7:
				return DiatonicChordEnum.SEVENTH.shift( 4 );
			case VI7:
				return DiatonicChordEnum.SEVENTH.shift( 5 );
			case VII7:
				return DiatonicChordEnum.SEVENTH.shift( 6 );

			case I2:
				return DiatonicChordEnum.SUS2;
			case II2:
				return DiatonicChordEnum.SUS2.shift( 1 );
			case III2:
				return DiatonicChordEnum.SUS2.shift( 2 );
			case IV2:
				return DiatonicChordEnum.SUS2.shift( 3 );
			case V2:
				return DiatonicChordEnum.SUS2.shift( 4 );
			case VI2:
				return DiatonicChordEnum.SUS2.shift( 5 );
			case VII2:
				return DiatonicChordEnum.SUS2.shift( 6 );

			case I4:
				return DiatonicChordEnum.SUS4;
			case II4:
				return DiatonicChordEnum.SUS4.shift( 1 );
			case III4:
				return DiatonicChordEnum.SUS4.shift( 2 );
			case IV4:
				return DiatonicChordEnum.SUS4.shift( 3 );
			case V4:
				return DiatonicChordEnum.SUS4.shift( 4 );
			case VI4:
				return DiatonicChordEnum.SUS4.shift( 5 );
			case VII4:
				return DiatonicChordEnum.SUS4.shift( 6 );

			case I6:
				return DiatonicChordEnum.SIXTH;
			case II6:
				return DiatonicChordEnum.SIXTH.shift( 1 );
			case III6:
				return DiatonicChordEnum.SIXTH.shift( 2 );
			case IV6:
				return DiatonicChordEnum.SIXTH.shift( 3 );
			case V6:
				return DiatonicChordEnum.SIXTH.shift( 4 );
			case VI6:
				return DiatonicChordEnum.SIXTH.shift( 5 );
			case VII6:
				return DiatonicChordEnum.SIXTH.shift( 6 );
			case I9:
				return DiatonicChordEnum.NINTH;
			case II9:
				return DiatonicChordEnum.NINTH.shift( 1 );
			case III9:
				return DiatonicChordEnum.NINTH.shift( 2 );
			case IV9:
				return DiatonicChordEnum.NINTH.shift( 3 );
			case V9:
				return DiatonicChordEnum.NINTH.shift( 4 );
			case VI9:
				return DiatonicChordEnum.NINTH.shift( 5 );
			case VII9:
				return DiatonicChordEnum.NINTH.shift( 6 );

			case I11:
				return DiatonicChordEnum.ELEVENTH;
			case II11:
				return DiatonicChordEnum.ELEVENTH.shift( 1 );
			case III11:
				return DiatonicChordEnum.ELEVENTH.shift( 2 );
			case IV11:
				return DiatonicChordEnum.ELEVENTH.shift( 3 );
			case V11:
				return DiatonicChordEnum.ELEVENTH.shift( 4 );
			case VI11:
				return DiatonicChordEnum.ELEVENTH.shift( 5 );
			case VII11:
				return DiatonicChordEnum.ELEVENTH.shift( 6 );

			case I13:
				return DiatonicChordEnum.THIRTEENTH;
			case II13:
				return DiatonicChordEnum.THIRTEENTH.shift( 1 );
			case III13:
				return DiatonicChordEnum.THIRTEENTH.shift( 2 );
			case IV13:
				return DiatonicChordEnum.THIRTEENTH.shift( 3 );
			case V13:
				return DiatonicChordEnum.THIRTEENTH.shift( 4 );
			case VI13:
				return DiatonicChordEnum.THIRTEENTH.shift( 5 );
			case VII13:
				return DiatonicChordEnum.THIRTEENTH.shift( 6 );
			case I_SECOND:
				return DiatonicChordEnum.SUS2_O5;
			case I_FOURTH:
				return DiatonicChordEnum.SUS4_O5;
			case I6_O5:
				return DiatonicChordEnum.SIXTH_O5;
			case I7_O3:
				return DiatonicChordEnum.SEVENTH_O3;
			case I7_O5:
				return DiatonicChordEnum.SEVENTH_O5;
			case I9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7;
			case I9_O7:
				return DiatonicChordEnum.NINTH_O7;
			case II_SECOND:
				return DiatonicChordEnum.SUS2_O5.shift( 1 );
			case II_FOURTH:
				return DiatonicChordEnum.SUS4_O5.shift( 1 );
			case II6_O5:
				return DiatonicChordEnum.SIXTH_O5.shift( 1 );
			case II7_O3:
				return DiatonicChordEnum.SEVENTH_O3.shift( 1 );
			case II7_O5:
				return DiatonicChordEnum.SEVENTH_O5.shift( 1 );
			case II9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.shift( 1 );
			case II9_O7:
				return DiatonicChordEnum.NINTH_O7.shift( 1 );
			case III_SECOND:
				return DiatonicChordEnum.SUS2_O5.shift( 2 );
			case III_FOURTH:
				return DiatonicChordEnum.SUS4_O5.shift( 2 );
			case III6_O5:
				return DiatonicChordEnum.SIXTH_O5.shift( 2 );
			case III7_O3:
				return DiatonicChordEnum.SEVENTH_O3.shift( 2 );
			case III7_O5:
				return DiatonicChordEnum.SEVENTH_O5.shift( 2 );
			case III9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.shift( 2 );
			case III9_O7:
				return DiatonicChordEnum.NINTH_O7.shift( 2 );
			case IV_SECOND:
				return DiatonicChordEnum.SUS2_O5.shift( 3 );
			case IV_FOURTH:
				return DiatonicChordEnum.SUS4_O5.shift( 3 );
			case IV6_O5:
				return DiatonicChordEnum.SIXTH_O5.shift( 3 );
			case IV7_O3:
				return DiatonicChordEnum.SEVENTH_O3.shift( 3 );
			case IV7_O5:
				return DiatonicChordEnum.SEVENTH_O5.shift( 3 );
			case IV9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.shift( 3 );
			case IV9_O7:
				return DiatonicChordEnum.NINTH_O7.shift( 3 );
			case V_SECOND:
				return DiatonicChordEnum.SUS2_O5.shift( 4 );
			case V_FOURTH:
				return DiatonicChordEnum.SUS4_O5.shift( 4 );
			case V6_O5:
				return DiatonicChordEnum.SIXTH_O5.shift( 4 );
			case V7_O3:
				return DiatonicChordEnum.SEVENTH_O3.shift( 4 );
			case V7_O5:
				return DiatonicChordEnum.SEVENTH_O5.shift( 4 );
			case V9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.shift( 4 );
			case V9_O7:
				return DiatonicChordEnum.NINTH_O7.shift( 4 );
			case VI_SECOND:
				return DiatonicChordEnum.SUS2_O5.shift( 5 );
			case VI_FOURTH:
				return DiatonicChordEnum.SUS4_O5.shift( 5 );
			case VI6_O5:
				return DiatonicChordEnum.SIXTH_O5.shift( 5 );
			case VI7_O3:
				return DiatonicChordEnum.SEVENTH_O3.shift( 5 );
			case VI7_O5:
				return DiatonicChordEnum.SEVENTH_O5.shift( 5 );
			case VI9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.shift( 5 );
			case VI9_O7:
				return DiatonicChordEnum.NINTH_O7.shift( 5 );
			case VII_SECOND:
				return DiatonicChordEnum.SUS2_O5.shift( 6 );
			case VII_FOURTH:
				return DiatonicChordEnum.SUS4_O5.shift( 6 );
			case VII6_O5:
				return DiatonicChordEnum.SIXTH_O5.shift( 6 );
			case VII7_O3:
				return DiatonicChordEnum.SEVENTH_O3.shift( 6 );
			case VII7_O5:
				return DiatonicChordEnum.SEVENTH_O5.shift( 6 );
			case VII9_O3_O7:
				return DiatonicChordEnum.NINTH_O3_O7.shift( 6 );
			case VII9_O7:
				return DiatonicChordEnum.NINTH_O7.shift( 6 );
			case III_THIRD:
				return DiatonicChordEnum.THIRD.shift( 2 );
			case II_THIRD:
				return DiatonicChordEnum.THIRD.shift( 1 );
			case IV_THIRD:
				return DiatonicChordEnum.THIRD.shift( 3 );
			case I_THIRD:
				return DiatonicChordEnum.THIRD;
			case VII_THIRD:
				return DiatonicChordEnum.THIRD.shift( 6 );
			case VI_THIRD:
				return DiatonicChordEnum.THIRD.shift( 5 );
			case V_THIRD:
				return DiatonicChordEnum.THIRD.shift( 4 );
		}
		throw new RuntimeException( " " + f + " " );

		// return null;
	}
	
	default boolean hasSameNotesOrder(DiatonicChord notes) {
        if (size() != notes.size())
            return false;
         
        for (int i = 0; i < size(); i++) {
            if (get(i).getDiatonic().intValue() != notes.get(i).getDiatonic().intValue())
                return false;
        }
 
        return true;
    }
	
	DiatonicChord shift(int i);
    
    // TODO
	default DiatonicChord removeHigherDuplicates() {
		DiatonicChord out = this;
		for(Diatonic n : this) {
			boolean found = false;

			if (!found)
				out.add(n);
		}

		this.clear();
		this.addAll(out);
		
		return out;
	}
	
	PitchChromaticChord toChromaticChord(Tonality t);
/*
	default ChromaticMidi toMidi(Tonality tonality, int octave) {
			assert tonality != null;
			DiatonicDegree pos = tonality.getDegree( getChromatic() );
			if ( pos == null )
				throw new TonalityException( this, tonality );
			else {
				int octaveNote = getOctave();
				DiatonicMidi ns = DiatonicMidi.from( pos, tonality, pitch.getOctave(), length, velocity );
				int octaveNoteScaleNote = ns.getPitch().getOctave();
				ns.shiftOctave( octaveNote - octaveNoteScaleNote );

				return ns;
			}
	}*/
}
