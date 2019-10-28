package es.danisales.datune.musical;

import java.util.List;
import java.util.function.BiFunction;

import es.danisales.datastructures.SetUtils;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.midi.AddedException;
import es.danisales.datune.midi.ChromaticMidi;
import es.danisales.datune.pitch.Chord;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchDiatonicSingle;
import es.danisales.datune.tonality.Tonality;

public class CustomDiatonicChord extends Chord<Diatonic>
		implements DiatonicChord,
		ChordMutableInterface<Diatonic> {

	public CustomDiatonicChord(PitchDiatonicSingle... cs) {
		assert cs != null;
		for ( int i = 0; i < cs.length; i++ ) {
			assert cs[i] != null;
			Diatonic c = cs[i].getDiatonic();
			add( c );
		}
	}

	public CustomDiatonicChord(DiatonicChord cs) {
		assert cs != null;
		for ( int i = 0; i < cs.size(); i++ ) {
			assert cs.get( i ) != null;
			Diatonic c = cs.get( i ).getDiatonic();
			add( c );
		}
	}
	
	public CustomDiatonicChord setRoot(int n) {
		return (CustomDiatonicChord) super.setRootPos( n );
	}

	public CustomDiatonicChord shift(int n) {
		for ( int i = 0; i < size(); i++ ) {
			set( i, get( i ).shift( n ) );
		}

		return this;
	}
	
	public CustomDiatonicChord inv(int n) {
		return (CustomDiatonicChord) super.inv( n );
	}
	
	public CustomDiatonicChord inv() {
		return (CustomDiatonicChord) super.inv();
	}

	public CustomDiatonicChord shift(DiatonicDegree d) {
		return shift( d.val() );
	}

	@Override
	public PitchChromaticChord<Chromatic> toChromaticChord(Tonality t) {
		return toChromatic( t, null );
	}

	public PitchChromaticChord<Chromatic> toChromatic(Tonality t, DiatonicFunction df) {
		CustomChromaticChord cc = new CustomChromaticChord();
		for ( Diatonic d : this )
			cc.add( d.toChromatic( t ) );

		if ( df != null )
			switch ( df ) {
				case I2:
				case II2:
				case III2:
				case IV2:
				case V2:
				case VI2:
				case VII2:
					for ( ChromaticChordEnum c : SetUtils.concat( ChromaticChordEnum.CHORDS_SUS2, ChromaticChordEnum.CHORDS_SUSb2, ChromaticChordEnum.CHORDS_SUSb2b5 ) )
						if ( cc.equalsEnharmonic( c ) ) {
							return c;
						}
					break;
				case I4:
				case II4:
				case III4:
				case IV4:
				case V4:
				case VI4:
				case VII4:
					for ( ChromaticChordEnum c : SetUtils.concat( ChromaticChordEnum.CHORDS_SUS4, ChromaticChordEnum.CHORDS_SUSa4 ) )
						if ( cc.equalsEnharmonic( c ) ) {
							return c;
						}
					break;
				case I6:
				case II6:
				case III6:
				case IV6:
				case V6:
				case VI6:
				case VII6:
					for ( ChromaticChordEnum c : SetUtils.concat( ChromaticChordEnum.CHORDS_6, ChromaticChordEnum.CHORDS_m6 ) )
						if ( cc.equalsEnharmonic( c ) ) {
							return c;
						}
					break;
			}

		cc.updateWhatIsIt();
		//assert cc.meta.str != null : "meta.str es null: " + cc.notesToString() + " [" + t + "] [" + df + "] " + t.notesToString();

		return cc;
	}

	@Override
	public CustomDiatonicChord clone() {
		return (CustomDiatonicChord) super.clone();
	}

	@Override
	public Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, ChordCommon<?>, CustomChromaticChord> fSelectChord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateWhatIsItIfNeeded() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomDiatonicChord resetRoot() {
		return (CustomDiatonicChord)super.resetRoot();
	}

	public CustomDiatonicChord add(Diatonic... cs) throws AddedException {
		for (Diatonic d : cs)
			add(d);
		return this;
	}

	@Override
	public CustomDiatonicChord add(int pos, Diatonic... ns) throws AddedException {
		return (CustomDiatonicChord)super.add( pos, ns );
	}

	@Override
	public CustomDiatonicChord removeHigherDuplicates() {
		return (CustomDiatonicChord)super.removeHigherDuplicates();
	}

	public ChromaticMidi getDiatonicMidi(Tonality tonality, int octave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiatonicDegree getDegree() {
		// TODO Auto-generated method stub
		return null;
	}
}
