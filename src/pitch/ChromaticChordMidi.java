package pitch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import chromaticchord.CustomChromaticChord;
import chromaticchord.CustomChromaticChord.ImpossibleChord;
import diatonic.IntervalChromatic;
import diatonic.Quality;
import midi.FigureLength;
import midi.FigureVelocity;
import midi.PitchException;
import midi.Settings;
import tonality.Tonality;
import tonality.TonalityException;

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

	public ChromaticChordMidi(PitchMidi... ns) {
		for ( PitchMidi n : ns )
			addNoReset( n.toMidi() );

		resetRoot();
	}

	public ChromaticChordMidi(Chromatic... ns) {
		this( new CustomChromaticChord( ns ) );
	}

	public <N extends PitchChromaticableSingle, Array extends PitchChromaticableChord<N, ?, ?>> ChromaticChordMidi(Array ns) {
		this(
			ns,
			ns instanceof ChordMidi ? ( (ChordMidi) ns ).getOctave()
					: Settings.DefaultValues.OCTAVE,
			ns instanceof ChordMidi ? ( (ChordMidi) ns ).getLength()
					: Settings.DefaultValues.DURATION_CHORD,
			Settings.DefaultValues.VELOCITY
		);
	}

	public <N extends PitchChromaticableSingle, Array extends PitchChromaticableChord<N, ?, ?>> ChromaticChordMidi(Array ns, int o, int d, int v) {
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
		
		ChromaticChordMidi usingChord = this.clone();
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
			n = (ChromaticMidi) ns.get( note ).clone();
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
		CustomChromaticChord ca = new CustomChromaticChord( this );

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

	@Override
	public Quality getQuality() {
		return meta.getQuality();
	}

	@Override
	public ChromaticChordMidi over(Chromatic c) throws ImpossibleChord {
		CustomChromaticChord c2 = new CustomChromaticChord( this.toChromaticChord() );
		
		return new ChromaticChordMidi( c2.over( c ) );
	}

	@Override
	public boolean addAll(Collection<? extends ChromaticMidi> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends ChromaticMidi> c) {
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
	public ChromaticMidi get(int index) {
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
	public Iterator<ChromaticMidi> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<ChromaticMidi> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<ChromaticMidi> listIterator(int index) {
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
	public ChromaticMidi set(int index, ChromaticMidi element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ChromaticMidi> subList(int fromIndex, int toIndex) {
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
}
