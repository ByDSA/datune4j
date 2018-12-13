package pitch;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

import chromaticchord.CustomChromaticChord;
import eventsequences.EventSequence;
import midi.AddedException;
import midi.FigureLength;
import midi.PitchMidiException;
import midi.Arpegios.Arpegio;
import midi.Arpegios.ArpegioDefault;

public abstract class ChordMidi<N extends NoteMidi, DistType>
extends Chord<N, DistType>
implements FigureLength, PitchOctave, PitchChromaticableChord<N, DistType>, PitchChordMutable<N, DistType>, PitchMidi {
	protected Arpegio	arpegio;
	protected int		length;

	public CustomChromaticChord meta = null; // TODO: poner private

	public PitchChromaticChord toChromaticChord() {
		if (getRootPos() != 0) {
			CustomChromaticChord ns = new CustomChromaticChord();
			for ( N n : this ) {
				ns.addList( n.getChromatic() );

				if ( n == root )
					ns.setRoot( ns.size() - 1 );
			}

			return ns;
		} else
			return PitchChromaticChord.copyOf(this);
	}

	public <T extends ChordMidi> T assign(T c) {
		assert c != null;
		clear();
		List<N> ns = c;
		for ( N n : ns )
			add( n );
		arpegio = c.arpegio;
		length = c.length;

		return (T) this;
	}

	public ChordMidi<N, DistType> inv(int n) {
		if ( size() == 0 )
			return (ChordMidi<N, DistType>) this;

		if ( n < 0 ) {
			int lastIndex = size() - 1;
			for ( int i = 0; i > n; i-- ) {
				boolean updateRoot = getRootPos() == lastIndex;

				final N last = get( lastIndex );
				final N first = get( 0 );
				do {
					last.shiftOctave( -1 );
				} while ( last.getCode() >= first.getCode() );

				add( 0, remove( lastIndex ) );

				if ( updateRoot )
					setRoot( 0 );
			}
		}

		for ( int i = 0; i < n; i++ ) {
			boolean updateRoot = getRootPos() == 0;

			int firstIndex = 0;
			final N first = get( firstIndex );

			final N last = get( size() - 1 );
			do {
				first.shiftOctave( 1 );
			} while ( first.getCode() <= last.getCode() );

			add( remove( firstIndex ) );

			if ( updateRoot )
				setRoot( size() - 1 );
		}

		sort();

		// meta.setRoot(getRootPos());

		return (ChordMidi<N, DistType>) this;
	}

	public abstract N get(int note, List<N> ns);

	@Override
	public EventSequence getEvents() {
		EventSequence es = new EventSequence();

		Arpegio aNodes;
		if ( arpegio == null )
			this.setArpegio( new ArpegioDefault() );
		int arpDuration = arpegio.getLength();

		if ( length != 0 && length > arpDuration ) {
			aNodes = arpegio.clone();
			int newArpDuration = arpDuration;

			while ( length > newArpDuration ) {
				int currentLoop = newArpDuration;
				for ( Arpegio.Node n : arpegio.getNodes() ) {
					aNodes.add( currentLoop + n.time, n.note, n.length );
				}
				newArpDuration += arpDuration;
			}
		} else
			aNodes = arpegio;

		for ( Arpegio.Node node : aNodes.getNodes() ) {
			if ( length != 0 && node.time > length || node.note < 0 )
				continue;

			N n = (N) get( node.note ).clone();

			if ( length != 0 )
				n.setLength( Math.min( node.time + node.length, length ) - node.time );
			else
				n.setLength( node.length );
			es.add( node.time, n );
		}
		return es;
	}

	@Override
	public int getLength() {
		int max = length;

		if ( arpegio == null )
			for ( N n : this )
				max = Math.max( max, n.getLength() );
		else
			max = arpegio.getLength();

		return max;
	}

	public Arpegio getArpegio() {
		return arpegio;
	}

	public <T extends ChordMidi<N, DistType>> T setArpegio(Arpegio a) {
		arpegio = a.clone();
		arpegio.setChord( this );

		return (T) this;
	}

	public int[] integerNotation() {
		int[] distancesAbsolute = null;

		if ( size() > 0 ) {
			try {
				distancesAbsolute = new int[size()];
				distancesAbsolute[0] = 0;

				for ( int i = 1; i < size(); i++ ) {
					distancesAbsolute[i] = get( i ).getCode()
							- get( 0 ).getCode();
				}
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		}

		return distancesAbsolute;
	}

	public boolean hasNote(final N nIn) {
		int nInCode = nIn.getCode();
		for ( N n : this )
			if ( n.getCode() == nInCode )
				return true;

		return false;
	}

	public boolean add(N n) throws AddedException {
		if ( !hasNote( n ) )
			super.add( n );
		else
			throw new AddedException( n, this );

		sort();

		return true;
	}

	public N getRandomNote() {
		if ( size() == 0 )
			return null;
		SecureRandom randomGenerator = new SecureRandom();
		int index = randomGenerator.nextInt( size() );

		return get( index );
	}

	public <T extends ChordMidi> T setVelocity(int v) {
		for ( N n : this )
			n.setVelocity( (int) Math.round( n.getVelocity() * v / 100.0 ) );
		return (T) this;
	}

	@Override
	public ChordMidi<N, DistType> setLength(int d) {
		length = d;
		return (ChordMidi<N, DistType>) this;
	}

	@Override
	public ChordMidi<N, DistType> shiftOctave(int o) {
		for ( N n : this )
			n.shiftOctave( o );
		return this;
	}
	
	public ChordMidi<N, DistType> setOctave(int o) {
		int diff = o - getOctave();
		shiftOctave( diff );
		return this;
	}

	public int getOctave() {
		return get( 0 ).getOctave();
	}

	public void sort() {
		this.sort(
			(N n1, N n2) -> ( n1.getCode() > n2.getCode() ? 1
					: ( n1 == n2 ? 0 : -1 ) )
				);
	}

	public <A extends PitchChord<N, DistType>> boolean hasSameNotesOrderSameOctave(A notes) {
		if ( size() != notes.size() || size() == 0 )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			if ( get( i ) != notes.get( i ) )
				return false;
		}

		return true;
	}

	public <A extends PitchChromaticableChord<N, DistType>> boolean hasSameNotesOrder(boolean sameOctave, A notes) {
		return sameOctave && hasSameNotesOrderSameOctave( notes )
				|| !sameOctave && hasSameNotesOrder( notes );
	}

	@Override
	public Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, PitchChord<?, ?>, CustomChromaticChord> f) {
		meta = new CustomChromaticChord( this );
		assert meta != null;
		assert f != null;
		Boolean ret = meta.updateWhatIsIt( f );
		root = get( meta.getRootPos() );
		return ret;
	}

	/*
	 * protected void updateMeta() { meta = new ChromaticChord(this);
	 * meta.setRoot(getRootPos()); }
	 */

	@Override
	public Boolean updateWhatIsItIfNeeded() {
		boolean ret = meta == null || !this.equalsEnharmonic( meta );
		if ( ret )
			updateWhatIsIt();

		return ret;
	}

	@Override
	public float getPitchMean() {
		int sum = 0, oct = 0;
		PitchMidiSingle last = null;
		for ( PitchMidiSingle c : this ) {
			sum += c.getCode();
		}
		return ( (float) sum ) / size();
	}

	public <T extends ChordMidi<N, DistType>> List<T> getAllDispositionsWithInv() {
		List<T> ret = new ArrayList<>();
		List<T> bases = super.getAllInversions();
		for ( T c : bases ) {
			ret.addAll( (List<T>) c.getAllInversions() );
		}

		return ret;
	}

	@Override
	public List<ChordMidi<N, DistType>> getAllInversions() {
		ChordMidi<N, DistType> c =  clone();
		c.setMinOctave();
		c.minimize();

		return c.getAllDispositionsSub( true, 0, true );
	}

	public void showNotesOctave() {
		for ( N n : this )
			System.out.print( n.getOctave() + " " );
		System.out.println( "" );
	}

	protected <T extends ChordMidi<N, DistType>> List<T> getAllDispositionsSub(boolean sub, int level, boolean first) {
		ArrayList<T> ret = new ArrayList<>();
		assert size() > 0;

		if ( first && level == 0 )
			ret.add( (T) clone() );

		try {
			while ( ( size() > 1 && get( 0 ).getCode() < get( 1 ).getCode()
					|| size() == 1 ) ) {
				if ( !first ) {
					T d = (T) clone();
					ret.add( d );
				}

				if ( sub && size() > 1 ) {
					// Copia acorde desde la segunda a la última nota
					T subChord = newArray();
					for ( int j = 1; j < size(); j++ )
						subChord.add( (N)get( j ).clone() );

					List<T> subCombinations = subChord.clone()
							.getAllDispositionsSub( true, level + 1, first );
					for ( T subCombination : subCombinations ) {
						// Forma array superChord = [array[0] + subChordcombination]
						T superChord = newArray();
						superChord.add( (N)get( 0 ).clone() );
						superChord.add( subCombination.clone() );

						// Combinaciones de 'número' dentro del array superChord = ['número' +
						// subChordcombination]
						List<T> superCombinations = superChord.clone()
								.getAllDispositionsSub( false, level, false );
						ret.addAll( superCombinations );
					}
				}

				get( 0 ).shiftOctave( 1 );
				first = false;
			}
		} catch ( PitchMidiException e ) {

		}

		return ret;
	}

	public void minimize() {
		for ( int i = 1; i < size(); i++ ) {
			N note = get( i );
			N prev = get( i - 1 );
			while ( note.getCode() - 12 > prev.getCode() )
				note.shiftOctave( -1 );
		}
	}

	public void minimizeDistanceTo(ChordMidi cIn) {
		assert cIn != null;
		List<ChordMidi<N, DistType>> ret = getAllDispositionsWithInv();
		int minDist = 9999;
		ChordMidi<N, DistType> minDistChord = null;
		for ( ChordMidi<N, DistType> c : ret ) {
			int d = (int) Math.abs( cIn.dist( c ) );
			if ( d < minDist ) {
				minDist = d;
				minDistChord = c;
			}
		}
		assign( minDistChord );
	}

	public int dist(ChordMidi<N, ?> n) {
		return dist( n, true );
	}

	protected int dist(ChordMidi<N, ?> n, boolean bidirectional) {
		int d = 0;

		for ( N i : this ) {
			int localMin = 9999;
			assert n.size() > 0;
			for ( N j : n ) {
				int m = Math.abs( j.getCode() - i.getCode() );
				if ( m < localMin )
					localMin = m;
			}
			assert localMin < 127 && localMin >= 0;
			d += localMin;
		}

		if ( bidirectional )
			d = Math.max( d, n.dist( this, false ) );

		return d;
	}

	@Override
	public boolean equals(Object o) {
		if ( !( o instanceof ChordMidi ) )
			return false;

		ChordMidi cm = (ChordMidi) o;

		if ( arpegio == null && cm.arpegio != null || cm.arpegio == null && arpegio != null )
			return false;

		return super.equals(cm) && ( arpegio == null && cm.arpegio == null || arpegio.equals( cm.arpegio ) ) && length == cm.length;
	}

	protected void setArpegioIfNull() {
		if ( arpegio == null )
			setArpegio( new ArpegioDefault() );
	}
	
	@Override
	public ChordMidi<N, DistType> clone() {
		return (ChordMidi<N, DistType>)super.clone();
	}

	@Override
	public void removeHigherDuplicates() {
		// TODO Auto-generated method stub
		
	}
}
