package pitch;

import java.util.Arrays;
import java.util.List;

public interface PitchChord<N extends PitchSingle, Ret> extends List<N> {
	public Ret[] integerNotationFromRoot();
	
	public <T extends PitchChord<N, Ret>> T newArray();
	
	public String notesToString();

	public void showNotes();
	
	public default void showIntegerNotation() {
		System.out.println( Arrays.toString( integerNotationFromRoot() ) );
	}
	
	public void removeHigherDuplicates();
	/*
	public default void initialize(N... cs) {
		for(N c : cs)
			add(c);
	}*/
}
