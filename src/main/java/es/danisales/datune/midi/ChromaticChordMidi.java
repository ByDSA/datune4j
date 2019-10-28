package es.danisales.datune.midi;

import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.midi.Settings.DefaultValues;
import es.danisales.datune.musical.CustomChromaticChord;
import es.danisales.datune.musical.CustomChromaticChord.ImpossibleChord;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.PitchOctave;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;

import java.util.ArrayList;
import java.util.List;

public class ChromaticChordMidi extends ChordMidi<ChromaticMidi> implements PitchChromaticChord<ChromaticMidi> {
	protected ChromaticChordMidi() { }

	public static ChromaticChordMidi of(ChromaticChordMidi ns) {
		ChromaticChordMidi ccm = new ChromaticChordMidi();
		ccm.add( ns );

		return ccm;
	}

	public static ChromaticChordMidi of(ChromaticMidi... ns) {
		ChromaticChordMidi ccm = new ChromaticChordMidi();
		ccm.add( ns );

		return ccm;
	}
	
	public static <N extends PitchChromaticSingle> ChromaticChordMidi of(PitchChromaticChord<N> ns) {
		ChromaticChordMidi ccm = new ChromaticChordMidi();
		for (N n : ns) {
			ChromaticMidi cm = ChromaticMidi.of( n.getChromatic(), DefaultValues.OCTAVE, DefaultValues.DURATION_CHORD, DefaultValues.VELOCITY );
			ccm.add( cm );
		}

		return ccm;
	}
	

	public static ChromaticChordMidi of(PitchChromaticSingle... ns) {
		ChromaticChordMidi ccm = new ChromaticChordMidi();
		for (PitchChromaticSingle n : ns) {
			ChromaticMidi cm = ChromaticMidi.of( n.getChromatic(), DefaultValues.OCTAVE, DefaultValues.DURATION_CHORD, DefaultValues.VELOCITY );
			ccm.add( cm );
		}

		return ccm;
	}

	public static <N extends PitchChromaticSingle, Array extends PitchChromaticChord<N>> ChromaticChordMidi of(Array ns, int o, int d, int v) {
		ChromaticChordMidi This = new ChromaticChordMidi();

		for ( int i = 0; i < ns.size(); i++ ) {
			N n = ns.get( i );

			if ( n instanceof PitchOctave )
				o = ( (PitchOctave) n ).getOctave();

			if ( n instanceof Durable )
				d = ( (Durable) n ).getDuration();

			if ( n instanceof VelocityNote )
				v = ( (VelocityNote) n ).getVelocity();

			ChromaticMidi cm = ChromaticMidi.of( n.getChromatic(), o, d, v );
			if ( !(n instanceof PitchOctave) && This.size() > 0 && cm.getChromatic().val() <= This.get( This.size() - 1 ).getChromatic().val() ) {
				o++;
				cm.shiftOctave( 1 );
			}

			This.add( cm );
		}

		return This;
	}

	public ArrayList<DiatonicChordMidi> toDiatonicChordMidi(boolean outScale) {
		ArrayList<Tonality> tonalities = Tonality.getFromChord( outScale, this );

		if ( tonalities.size() == 0 )
			return new ArrayList<>();

		ChromaticChordMidi usingChord = this.clone();
		// usingChord.updateWhatIsItIfNeeded();

		ArrayList<DiatonicChordMidi> out = new ArrayList<>();
		for ( Tonality t : tonalities )
			out.add( new DiatonicChordMidi( t, usingChord ) );

		return out;
	}
	/*
	public ChromaticMidi get(int note, List<ChromaticMidi> ns) {
		if ( ns.size() == 0 )
			return null;

		ChromaticMidi n;
		if ( note >= ns.size() ) {
			n = ns.get( note % ns.size() );
			n.addMidi( note / ns.size() * ChromaticMidi.NOTES_PER_OCTAVE );
		} else if ( note < 0 ) {
			int num = Math.abs( ns.size() + note % ns.size() );
			n = ns.get( num );
			n.addMidi( ( note / ns.size() - 1 ) * ChromaticMidi.NOTES_PER_OCTAVE );
		} else {
			n = (ChromaticMidi) ns.get( note ).clone();
		}

		PitchMidiException.check( n );

		return n;
	}
	 */
	public void compact() {
		for ( int i = 1; i < this.size(); i++ ) {
			int dist = this.get( i - 1 ).dist( this.get( i ) );
			assert dist != 0 : "Se reptite alguna nota " + dist;
			assert dist > 0 : "Las notas no est�n ordenadas " + this.get( i - 1 ) + " "
			+ this.get( i );
			if ( dist > IntervalChromatic.PERFECT_OCTAVE.val() )
				this.get( i ).shiftOctave( -dist / IntervalChromatic.PERFECT_OCTAVE.val() );
		}
	}

	@Override
	public ChromaticChordMidi clone() {
		ChromaticChordMidi c = new ChromaticChordMidi();

		for ( ChromaticMidi n : this )
			c.add( n.clone() );

		c.arpegio = arpegio.clone();
		c.length = length;

		return c;
	}

	@Override
	public ChromaticChordMidi subList(int a, int b) {
		assert b < size();
		ChromaticChordMidi c = new ChromaticChordMidi();
		for ( int i = a; i < b; i++ ) {
			c.add( get( i ).clone() );
		}
		return c;
	}

	// TODO: SE PUEDE PONER COMO DEFAULT
	@Override
	public ChromaticChordMidi removeHigherDuplicates() {
		ChromaticChordMidi out = new ChromaticChordMidi();
		for ( ChromaticMidi n : this ) {
			boolean found = false;
			for ( ChromaticMidi n2 : out ) {
				if ( n2.getChromatic().val() == n.getChromatic().val() ) {
					found = true;
					break;
				}
			}

			if ( !found )
				out.add( n );
		}

		this.clear();
		for ( ChromaticMidi n : out )
			add( n );

		return this;
	}

	public String toString() {
		CustomChromaticChord ca = CustomChromaticChord.copyOf( this );

		return ca.toString();
	}

	public DiatonicChordMidi getDiatonicChordMidi(Tonality ton) throws TonalityException {
		assert ton != null;
		return new DiatonicChordMidi( ton, this );
	}

	@Override
	public Quality getQuality() {
		return meta.getQuality();
	}

	@Override
	public ChromaticChordMidi over(ChromaticMidi c) throws ImpossibleChord {
		return (ChromaticChordMidi) super.over( c );
	}

	@Override
	public ChromaticChordMidi over(PitchChromaticSingle c) throws ImpossibleChord {
		return (ChromaticChordMidi) super.over( c );
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

	@Override
	public ChromaticChordMidi inv() {
		return super.inv();
	}

	@Override
	public ChromaticChordMidi inv(int n) {
		return (ChromaticChordMidi) super.inv(n);
	}

	public PitchChromaticChord getChromaticChord() {
		return this.toChromaticChord();
	}

	@Override
	public int getInversionNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasSameNotes(PitchChromaticChord<ChromaticMidi> chord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected ChromaticChordMidi newChord() {
		return new ChromaticChordMidi();
	}

	@Override
	public List integerNotationFromRoot() {
		// TODO Auto-generated method stub
		return null;
	}
}
