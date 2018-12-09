package midi;

import diatonic.Tonality;
import eventsequences.Track;

public class Song extends Sequence {
	protected Tonality tonality;

	public Song(String n, int tempo) {
		this(n, tempo, Settings.DefaultValues.TONALITY);
	}
	
	public Song(String n, int tempo, Tonality t) {
		super(n, tempo);
		tonality = Settings.DefaultValues.TONALITY;
	}
	
	public Tonality getTonality() {
		return tonality;
	}
}
