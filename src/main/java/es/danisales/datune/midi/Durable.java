package es.danisales.datune.midi;

public interface Durable {
	Integer NO_DURATION = -1;
	
	void setLength(int d);
	int getDuration();
}
