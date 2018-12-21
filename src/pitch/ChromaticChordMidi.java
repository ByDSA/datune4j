package pitch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import diatonic.IntervalChromatic;
import diatonic.Quality;
import midi.AddedException;
import midi.FigureLength;
import midi.FigureVelocity;
import midi.PitchMidiException;
import midi.Settings;
import musical.Chromatic;
import musical.CustomChromaticChord;
import musical.CustomChromaticChord.ImpossibleChord;
import tonality.Tonality;
import tonality.TonalityException;

public class ChromaticChordMidi extends ChordMidi<ChromaticMidi> implements PitchChromaticChord<ChromaticMidi> {
	protected ChromaticChordMidi() { }

	public ChromaticChordMidi(ChromaticChordMidi ns) {
		add( ns );
	}

	public ChromaticChordMidi(ChromaticMidi... ns) {
		add( ns );
	}

	public static ChromaticChordMidi of(NoteMidi... ns) {
		ChromaticChordMidi This = new ChromaticChordMidi();
		for ( NoteMidi n : ns )
			This.add( n.toMidi() );
		
		return This;
	}

	public static ChromaticChordMidi of(Chromatic... ns) {
		return copyOf( PitchChromaticChord.of( ns ) );
	}

	public static <N extends PitchChromaticSingle, Array extends PitchChromaticChord<N>> ChromaticChordMidi copyOf(Array ns) {
		return of(
			ns,
			ns instanceof ChordMidi ? ( (ChordMidi) ns ).getOctave()
					: Settings.DefaultValues.OCTAVE,
			ns instanceof ChordMidi ? ( (ChordMidi) ns ).getLength()
					: Settings.DefaultValues.DURATION_CHORD,
			Settings.DefaultValues.VELOCITY
		);
	}

	public static <N extends PitchChromaticSingle, Array extends PitchChromaticChord<N>> ChromaticChordMidi of(Array ns, int o, int d, int v) {
		ChromaticChordMidi This = new ChromaticChordMidi();
		
		for ( int i = 0; i < ns.size(); i++ ) {
			N n = ns.get( i );

			if ( n instanceof PitchOctave )
				o = ( (PitchOctave) n ).getOctave();

			if ( n instanceof FigureLength )
				d = ( (FigureLength) n ).getLength();

			if ( n instanceof FigureVelocity )
				v = ( (FigureVelocity) n ).getVelocity();

			ChromaticMidi cm = new ChromaticMidi( n.getChromatic(), o, d, v );
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
			assert dist > 0 : "Las notas no están ordenadas " + this.get( i - 1 ) + " "
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

	public ChromaticChordMidi copyOf(int a, int b) {
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
	public ChromaticChordMidi over(Chromatic c) throws ImpossibleChord {
		CustomChromaticChord c2 = CustomChromaticChord.copyOf( toChromaticChord() );
		
		return ChromaticChordMidi.copyOf( c2.over( c ) );
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

	public static ChromaticChordMidi of(ChromaticMidi... cc) {
		ChromaticChordMidi c = new ChromaticChordMidi();
		c.add( cc );
		return c;
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
