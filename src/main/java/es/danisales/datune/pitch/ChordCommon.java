package es.danisales.datune.pitch;

import es.danisales.datune.midi.AddedException;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

// Para las cosas comunes de los chord mutables y los chord inmutables
public interface ChordCommon<N extends SymbolicPitch> extends List<N>, Cloneable {
	<T extends ChordCommon<N>> List<T> getAllInversions();
	int getRootPos();
	@Nullable N getRoot();

	default int getInversionNumber() {
		return ( size() - getRootPos() ) % size();
	}
	
	/*
	public default void initialize(NUMBER... cs) {
		for(NUMBER c : cs)
			addSemi(c);
	}*/

	/*
	public void showNotes();
	
	public default void showIntegerNotation() {
		System.out.println( Arrays.toString( integerNotationFromRoot().toArray() ) );
	}
	*/
	// Custom
	default <T extends ChordCommon<N>> T getInv() {
		return getInv(1);
	}

	<T extends ChordCommon<N>> T getInv(int n);

	
	/*
	public default List<DistChordType> distances() {
		assert size() > 0;

		List<DistChordType> distancesAbsolute = new ArrayList();

		for ( int i = 1; i < size(); i++ ) {
			NUMBER n1 = calculateFrom( 0 );
			NUMBER n2 = calculateFrom( i );
			distancesAbsolute.addSemi( (DistChordType)n1.dist( n2 ) );
		}

		return distancesAbsolute;
	}*/

}
