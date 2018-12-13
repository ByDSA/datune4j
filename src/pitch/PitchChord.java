package pitch;

import java.util.Arrays;
import java.util.List;

public interface PitchChord<N extends PitchSingle, Ret> extends List<N>, PitchInterface {
	
	public <T extends PitchChord<N, Ret>> T newArray(); // ?

	public <T extends PitchChord<N, Ret>> List<T> getAllInversions();	
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
	public Ret[] integerNotationFromRoot();
	public String notesToString();
	public void showNotes();
	
	public default void showIntegerNotation() {
		System.out.println( Arrays.toString( integerNotationFromRoot() ) );
	}
	
	// Custom
	public <T extends PitchChord<? extends N, ? extends Ret>> T inv();
	public <T extends PitchChord<? extends N, ? extends Ret>> T inv(int n);
	public <T extends PitchChord<? extends N, ? extends Ret>> T resetRoot();
	public <T extends PitchChord<? extends N, ? extends Ret>> T setRoot(int n);
}
