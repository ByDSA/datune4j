package pitch;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import eventsequences.EventSequence;
import midi.AddedException;
import midi.FigureLength;
import midi.PitchException;
import midi.Arpegios.Arpegio;
import midi.Arpegios.ArpegioDefault;

public abstract class ChordMidi<N extends NoteMidi<N, DistType>, This extends ChordMidi<N, This, DistType>, DistType>
		extends Chord<N, This, DistType>
		implements FigureLength<This>, PitchOctave<This>,
		PitchChromaticableChord<N, This, DistType> {
	protected Arpegio	arpegio;
	protected int		length;

	public ChromaticChord meta = null; // TODO: poner private

	public ChromaticChord toChromaticChord() {
		ChromaticChord ns = new ChromaticChord();
		for ( N n : this ) {
			ns.addNoReset( n.getChromatic() );

			if ( n == root )
				ns.setRoot( ns.size() - 1 );
		}

		return ns;
	}

	public <T extends ChordMidi> This assign(T c) {
		assert c != null;
		clear();
		List<N> ns = c;
		for ( N n : ns )
			add( n );
		arpegio = c.arpegio;
		length = c.length;

		return (This) this;
	}

	public This setDuration(int d) {
		length = d;

		return (This) this;
	}

	public This inv(int n) {
		if ( size() == 0 )
			return (This) this;

		if ( n < 0 ) {
			int lastIndex = size() - 1;
			for ( int i = 0; i > n; i-- ) {
				boolean updateRoot = getRootPos() == lastIndex;

				final N last = get( lastIndex );
				final N first = get( 0 );
				do {
					last.shiftOctave( -1 );
				} while ( last.getPitchCode().val() >= first.getPitchCode().val() );

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
			} while ( first.getPitchCode().val() <= last.getPitchCode().val() );

			add( remove( firstIndex ) );

			if ( updateRoot )
				setRoot( size() - 1 );
		}

		sort();

		// meta.setRoot(getRootPos());

		return (This) this;
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
			aNodes = arpegio.duplicate();
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

			N n = (N) get( node.note ).duplicate();

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

	public This setArpegio(Arpegio a) {
		arpegio = a.duplicate();
		arpegio.setChord( this );

		return (This) this;
	}

	public int[] integerNotation() {
		int[] distancesAbsolute = null;

		if ( size() > 0 ) {
			try {
				distancesAbsolute = new int[size()];
				distancesAbsolute[0] = 0;

				for ( int i = 1; i < size(); i++ ) {
					distancesAbsolute[i] = get( i ).getPitchCode().val()
							- get( 0 ).getPitchCode().val();
				}
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		}

		return distancesAbsolute;
	}

	public boolean hasNote(final N nIn) {
		int nInCode = nIn.getPitchCode().val();
		for ( N n : this )
			if ( n.getPitchCode().val() == nInCode )
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

	public This setVelocity(int v) {
		for ( N n : this )
			n.setVelocity( (int) Math.round( n.getVelocity() * v / 100.0 ) );
		return (This) this;
	}

	@Override
	public This setLength(int d) {
		length = d;
		return (This) this;
	}

	@Override
	public This shiftOctave(int o) {
		for ( N n : this )
			n.shiftOctave( o );
		return (This) this;
	}

	@Override
	public This setOctave(int o) {
		int diff = o - getOctave();
		shiftOctave( diff );
		return (This) this;
	}

	public int getOctave() {
		return get( 0 ).getOctave();
	}

	public void sort() {
		this.sort(
			(N n1, N n2) -> ( n1.getPitchCode().val() > n2.getPitchCode().val() ? 1
					: ( n1.getPitchCode() == n2.getPitchCode() ? 0 : -1 ) )
		);
	}

	public <A extends PitchChord<N, A, DistType>> boolean hasSameNotesOrderSameOctave(A notes) {
		if ( size() != notes.size() || size() == 0 )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			if ( get( i ).getPitchCode() != notes.get( i ).getPitchCode() )
				return false;
		}

		return true;
	}

	public <A extends PitchChromaticableChord<N, A, DistType>> boolean hasSameNotesOrder(boolean sameOctave, A notes) {
		return sameOctave && hasSameNotesOrderSameOctave( notes )
				|| !sameOctave && hasSameNotesOrder( notes );
	}

	@Override
	public Boolean updateWhatIsIt(BiFunction<ArrayList<ChromaticChord>, PitchChromaticableChord<?, ?, ?>, ChromaticChord> f) {
		meta = new ChromaticChord( this );
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
		PitchCode<?, ?> last = null;
		for ( PitchCode<?, ?> c : this ) {
			sum += c.getPitchCode().val();
		}
		return ( (float) sum ) / size();
	}

	public ArrayList<This> getAllDispositionsWithInv() {
		ArrayList<This> ret = new ArrayList<>();
		ArrayList<This> bases = super.getAllInversions();
		for ( This c : bases ) {
			ret.addAll( c.getAllInversions() );
		}

		return ret;
	}

	@Override
	public ArrayList<This> getAllInversions() {
		This c = duplicate( true );
		c.setMinOctave();
		c.minimize();

		return c.getAllDispositionsSub( true, 0, true );
	}

	public void showNotesOctave() {
		for ( N n : this )
			System.out.print( n.getOctave() + " " );
		System.out.println( "" );
	}

	protected ArrayList<This> getAllDispositionsSub(boolean sub, int level, boolean first) {
		ArrayList<This> ret = new ArrayList<>();
		assert size() > 0;

		if ( first && level == 0 )
			ret.add( duplicate( true ) );

		try {
			while ( ( size() > 1 && get( 0 ).getPitchCode().val() < get( 1 ).getPitchCode().val()
					|| size() == 1 ) ) {
				if ( !first ) {
					This d = duplicate( true );
					ret.add( d );
				}

				if ( sub && size() > 1 ) {
					// Copia acorde desde la segunda a la última nota
					This subChord = newArray();
					for ( int j = 1; j < size(); j++ )
						subChord.add( get( j ).duplicate() );

					ArrayList<This> subCombinations = subChord.duplicate( true )
							.getAllDispositionsSub( true, level + 1, first );
					for ( This subCombination : subCombinations ) {
						// Forma array superChord = [array[0] + subChordcombination]
						This superChord = newArray();
						superChord.add( get( 0 ).duplicate() );
						superChord.add( subCombination.duplicate( true ) );

						// Combinaciones de 'número' dentro del array superChord = ['número' +
						// subChordcombination]
						ArrayList<This> superCombinations = superChord.duplicate(
							true
							)
								.getAllDispositionsSub( false, level, false );
						ret.addAll( superCombinations );
					}
				}

				get( 0 ).shiftOctave( 1 );
				first = false;
			}
		} catch ( PitchException e ) {

		}

		return ret;
	}

	public void minimize() {
		for ( int i = 1; i < size(); i++ ) {
			N note = get( i );
			N prev = get( i - 1 );
			while ( note.getPitchCode().val() - 12 > prev.getPitchCode().val() )
				note.shiftOctave( -1 );
		}
	}

	public void minimizeDistanceTo(ChordMidi cIn) {
		assert cIn != null;
		ArrayList<This> ret = getAllDispositionsWithInv();
		int minDist = 9999;
		This minDistChord = null;
		for ( This c : ret ) {
			int d = (int) Math.abs( cIn.dist( c ) );
			if ( d < minDist ) {
				minDist = d;
				minDistChord = c;
			}
		}
		assign( minDistChord );
	}

	public int dist(ChordMidi<N, ?, ?> n) {
		return dist( n, true );
	}

	protected int dist(ChordMidi<N, ?, ?> n, boolean bidirectional) {
		int d = 0;

		for ( N i : this ) {
			int localMin = 9999;
			assert n.size() > 0;
			for ( N j : n ) {
				int m = Math.abs( j.getPitchCode().val() - i.getPitchCode().val() );
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
}
