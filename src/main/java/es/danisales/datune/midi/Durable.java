package es.danisales.datune.midi;

public interface Durable {
	Integer NO_DURATION = -1;
	
	<T extends Durable> T setDuration(int d);
	int getDuration();
}
