package pitch;

import java.util.List;

import midi.AddedException;

public interface ChordInterface<N extends PitchSingle> extends List<N>, Cloneable {
	public <T extends ChordInterface<N>> List<T> getAllInversions();	
	public int getRootPos();
	public N getRoot();
	
	public default int getInversionNumber() {
		return ( size() - getRootPos() ) % size();
	}
	
	/*
	public default void initialize(N... cs) {
		for(N c : cs)
			add(c);
	}*/
	
	/** Show */
	public List integerNotationFromRoot();
	public default String notesToString() {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for ( N n : this ) {
			if ( first ) {
				first = false;
			} else
				sb.append( ", " );
			sb.append( n );
		}

		return sb.toString();
	}
	/*
	public void showNotes();
	
	public default void showIntegerNotation() {
		System.out.println( Arrays.toString( integerNotationFromRoot().toArray() ) );
	}
	*/
	// Custom
	public default <T extends ChordInterface<N>> T inv() {
		return inv( 1 );
	}
	public <T extends ChordInterface<N>> T inv(int n);
	public <T extends ChordInterface<N>> T resetRoot();
	public <T extends ChordInterface<N>> T setRoot(int n);
	public <T extends ChordInterface<N>> T removeHigherDuplicates();
	public default <T extends ChordInterface<N>> T add(N... cs) throws AddedException {
		for (N d : cs)
			add(d);
		return (T) this;
	}
	public <T extends ChordInterface<N>> T add(ChordInterface<N> cs) throws AddedException;
	public <T extends ChordInterface<N>> T add(int pos, N... ns) throws AddedException;
	/*
	public default List<DistChordType> distances() {
		assert size() > 0;

		List<DistChordType> distancesAbsolute = new ArrayList();

		for ( int i = 1; i < size(); i++ ) {
			N n1 = get( 0 );
			N n2 = get( i );
			distancesAbsolute.add( (DistChordType)n1.dist( n2 ) );
		}

		return distancesAbsolute;
	}*/

}
