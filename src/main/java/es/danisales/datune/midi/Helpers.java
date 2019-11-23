package es.danisales.datune.midi;

public class Helpers {
	/*
	public static int diatonic(NoteScale n1, NoteScale n2) {
		int d = n2.getOctave()*n2.getTonality().getTonality().size + n2.getPos() - ( n1.getOctave()*n1.getTonality().getTonality().size + n1.getPos() );
		return d;
	}

	public static int dist(NoteScale n1, NoteScale n2) {
		return n2.getMidiCode() - n1.getMidiCode();
	}

	public static int octave(NoteScale n1, NoteScale n2) {
		int d = dist(n1, n2);

		return octave(d);
	}
	 */

	public static int octave(int d) {
		if (d < 0)
			return (d+1)/12 - 1;
		else
			return d / 12;
	}
}
