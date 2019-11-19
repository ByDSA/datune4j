package es.danisales.datune.midi;

import es.danisales.datune.tonality.Tonality;

import java.nio.file.Paths;

public class Song extends Sequence {
	protected Tonality tonality;

	public Song(String pathStr, int tempo) {
		this(pathStr, tempo, Settings.DefaultValues.TONALITY);
	}
	
	public Song(String pathStr, int tempo, Tonality t) {
		super(Paths.get(pathStr), tempo);
		tonality = t;
	}
	
	public Tonality getTonality() {
		return tonality;
	}
}
