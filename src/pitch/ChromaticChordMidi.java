package pitch;

import java.util.ArrayList;
import java.util.List;

import diatonic.IntervalChromatic;
import diatonic.Tonality;
import diatonic.TonalityException;
import midi.FigureLength;
import midi.FigureVelocity;
import midi.PitchException;
import midi.Settings;

public class ChromaticChordMidi extends ChordMidi<ChromaticMidi, ChromaticChordMidi, Integer>
		implements PitchChromaticChord<ChromaticMidi, ChromaticChordMidi> {

	public ChromaticChordMidi() {
	}

	public ChromaticChordMidi(ChromaticChordMidi ns) {
		add( ns );
	}

	public ChromaticChordMidi(ChromaticMidi... ns) {
		add( ns );
	}

	public ChromaticChordMidi(Pitch... ns) {
		for ( Pitch n : ns )
			addNoReset( n.toMidi() );

		resetRoot();
	}

	public ChromaticChordMidi(Chromatic... ns) {
		this( new ChromaticChord( ns ) );
	}

	public <N extends PitchChromaticableSingle<N>, Array extends PitchChromaticableChord<N, ?, ?>> ChromaticChordMidi(Array ns) {
		this(
			ns,
			ns instanceof ChordMidi ? ( (ChordMidi) ns ).getOctave()
					: Settings.DefaultValues.OCTAVE,
			ns instanceof ChordMidi ? ( (ChordMidi) ns ).getLength()
					: Settings.DefaultValues.DURATION_CHORD,
			Settings.DefaultValues.VELOCITY
		);
	}

	public <N extends PitchChromaticableSingle<N>, Array extends PitchChromaticableChord<N, ?, ?>> ChromaticChordMidi(Array ns, int o, int d, int v) {
		for ( int i = 0; i < ns.size(); i++ ) {
			N n = ns.get( i );

			if ( n instanceof PitchOctave )
				o = ( (PitchOctave) n ).getOctave();

			if ( n instanceof FigureLength )
				d = ( (FigureLength) n ).getLength();

			if ( n instanceof FigureVelocity )
				v = ( (FigureVelocity) n ).getVelocity();

			ChromaticMidi cm = new ChromaticMidi( n.getChromatic(), o, d, v );
			if ( !(n instanceof PitchOctave) && size() > 0 && cm.getChromatic().val() <= get( size() - 1 ).getChromatic().val() ) {
				o++;
				cm.shiftOctave( 1 );
			}

			addNoReset( cm );
		}

		resetRoot();
	}

	public ArrayList<DiatonicChordMidi> toDiatonicChordMidi(boolean outScale) {
		ArrayList<Tonality> tonalities = Tonality.getFromChord( outScale, this );

		if ( tonalities.size() == 0 )
			return new ArrayList<>();
		
		ChromaticChordMidi usingChord = this.duplicate( true );
		// usingChord.updateWhatIsItIfNeeded();

		ArrayList<DiatonicChordMidi> out = new ArrayList<>();
		for ( Tonality t : tonalities )
			out.add( new DiatonicChordMidi( t, usingChord ) );
		
		return out;
	}

	public ChromaticMidi get(int note, List<ChromaticMidi> ns) {
		if ( ns.size() == 0 )
			return null;

		ChromaticMidi n;
		if ( note >= ns.size() ) {
			n = ns.get( note % ns.size() );
			n.add( note / ns.size() * ChromaticMidi.NOTES_PER_OCTAVE );
		} else if ( note < 0 ) {
			int num = Math.abs( ns.size() + note % ns.size() );
			n = ns.get( num );
			n.add( ( note / ns.size() - 1 ) * ChromaticMidi.NOTES_PER_OCTAVE );
		} else {
			n = (ChromaticMidi) ns.get( note ).duplicate();
		}

		PitchException.check( n );

		return n;
	}

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

	public ChromaticChordMidi duplicate() {
		return duplicate( false );
	}

	@Override
	public ChromaticChordMidi duplicate(boolean ref) {
		ChromaticChordMidi c = new ChromaticChordMidi();

		for ( ChromaticMidi n : this )
			c.add( n.duplicate( ref ) );

		c.arpegio = ref && arpegio != null ? arpegio.duplicate() : arpegio;
		c.length = length;

		return c;
	}

	public ChromaticChordMidi copyOf(int a, int b) {
		assert b < size();
		ChromaticChordMidi c = new ChromaticChordMidi();
		for ( int i = a; i < b; i++ ) {
			c.add( get( i ).duplicate( true ) );
		}
		return c;
	}

	// TODO: SE PUEDE PONER COMO DEFAULT
	@Override
	public void removeHigherDuplicates() {
		ChromaticChordMidi out = new ChromaticChordMidi();
		for ( ChromaticMidi n : this ) {
			boolean found = false;
			for ( ChromaticMidi n2 : out ) {
				if ( n2.val() == n.val() ) {
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
	}

	public String toString() {
		ChromaticChord ca = new ChromaticChord( this );

		return ca.toString();
	}

	@Override
	public DiatonicChordMidi toDiatonicChordMidi(Tonality ton) throws TonalityException {
		assert ton != null;
		return new DiatonicChordMidi( ton, this );
	}

	@Override
	public ChromaticChordMidi newArray() {
		return new ChromaticChordMidi();
	}
}
