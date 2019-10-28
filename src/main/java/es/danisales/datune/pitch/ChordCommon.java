package es.danisales.datune.pitch;

import es.danisales.datune.midi.AddedException;

import java.util.List;

// Para las cosas comunes de los chord mutables y los chord inmutables
public interface ChordCommon<N extends SymbolicPitch> extends List<N>, Cloneable {
	<T extends ChordCommon<N>> List<T> getAllInversions();
	int getRootPos();
	N getRoot();

	default int getInversionNumber() {
		return ( size() - getRootPos() ) % size();
	}
	
	/*
	public default void initialize(N... cs) {
		for(N c : cs)
			add(c);
	}*/

	/** Show */
	List integerNotationFromRoot();
	default String notesToString() {
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
	default <T extends ChordCommon<N>> T inv() {
		return inv( 1 );
	}
	default <T extends ChordCommon<N>> T inv(int n) {
		if ( size() < 2 || n == 0 )
			return (T)this;

		for ( int i = 0; i < n; i++ ) {
			boolean updateRoot = getRootPos() == 0;
			add( remove( 0 ) );

			if ( updateRoot )
				setRootPos( size() - 1 );
		}

		if ( n < 0 ) {
			int lastIndex = size() - 1;

			for ( int i = 0; i > n; i-- ) {
				boolean updateRoot = getRootPos() == lastIndex;
				add( 0, remove( lastIndex ) );

				if ( updateRoot )
					setRootPos( 0 );
			}
		}

		return (T)this;
	}
	<T extends ChordCommon<N>> T resetRoot();
	<T extends ChordCommon<N>> T setRootPos(int n);
	<T extends ChordCommon<N>> T removeHigherDuplicates();
	default <T extends ChordCommon<N>> T add(N... cs) throws AddedException {
		for (N d : cs)
			add(d);
		return (T) this;
	}
	<T extends ChordCommon<N>> T add(ChordCommon<N> cs) throws AddedException;
	<T extends ChordCommon<N>> T add(int pos, N... ns) throws AddedException;
	
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
