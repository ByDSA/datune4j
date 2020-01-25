package es.danisales.datune.tuning;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.octave.DiatonicAlt;

import java.util.*;

public class Tuning {	
	public final static double MIN_FREQUENCY = 20;
	public final static double MAX_FREQUENCY = 20000;
	
	public final static Tuning DEFAULT = new Tuning(new EqualTemperament(), new NoteTuning(DiatonicAlt.A, 4), 440);

	private final Temperament temperament;
	private final NoteTuning noteBase;
	private final Map<NoteTuning, Double> map = new HashMap<>();
	
	final List<List<Chromatic>> notes = new ArrayList<>();

	public Tuning(Temperament t, NoteTuning nb, double frequencyBase) {
		temperament = t;
		noteBase = nb;

		NoteTuning note = nb.clone();

		for (int i = 0; i < 7; i++) {
			map.put( note, frequencyBase);
			addPrevious( note, frequencyBase);
			addNext( note, frequencyBase);
			/*addFlat( note, freq );
			addSharp( note, freq );*/

			Chromatic simpleNote = Chromatic.from(note.note);
			NoteTuning prev = note;
			note = prev.clone();
			note.note = note.note.getNextDiatonic();
			switch(simpleNote) {
				case A:
				case C:
				case D:
				case F:
				case G:
					//freq *= temperament.tone();
					break;
				case B:
					note.octave++;
				case E:
					//freq *= temperament.semi();
					break;
				default: throw new RuntimeException();
			}
		}
	}
	
	public double get(DiatonicAlt c, int octave) {
		NoteTuning n = new NoteTuning(c, octave);
		return map.get( n );
	}

	private void addPrevious(final NoteTuning n, double freq) {
		freq /= 2;
		int octave = n.octave;
		while(freq >= MIN_FREQUENCY) {
			NoteTuning a = new NoteTuning(n.note, --octave);
			map.put(a, freq );

			freq /= 2;
		}
	}

	private void addNext(final NoteTuning n, double freq) {
		freq *= 2;
		int octave = n.octave;
		while(freq <= MAX_FREQUENCY) {
			NoteTuning a = new NoteTuning(n.note, ++octave);
			map.put(a, freq );

			freq *= 2;
		}
	}

	public void showNotes() {
		List<NoteFreq> notes = new ArrayList<>();
		map.forEach( (NoteTuning n, Double f) -> {
			NoteFreq nn = new NoteFreq(n.note, n.octave, f);
			notes.add( nn );
		});

		notes.sort( new Comparator<NoteFreq>() {
			@Override
			public int compare(NoteFreq a, NoteFreq b) {
				return a.frequency.compareTo( b.frequency );
			}

		});

		for (NoteFreq nn : notes)
			//if (nn.note.getAlterationsNumber() == 0)
				System.out.println(nn);
	}

	static class NoteFreq extends NoteTuning {
		public NoteFreq(DiatonicAlt c, int o, double f) {
			super( c, o );
			frequency = f;
		}

		public Double frequency;

		@Override
		public String toString() {
			return super.toString() + " " + frequency;
		}
	}
}
