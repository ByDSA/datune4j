package es.danisales.datune.tuning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.transformations.AlterationsCalculator;
import es.danisales.datune.musical.transformations.ChromaticAdapter;

public class Tuning {	
	public final static double MIN_FREQUENCY = 20;
	public final static double MAX_FREQUENCY = 20000;
	
	public final static Tuning DEFAULT = new Tuning(new EqualTemperament(), new NoteTuning(Chromatic.A, 4), 440);

	final Temperament temperament;
	final NoteTuning noteBase;
	final Map<NoteTuning, Double> map = new HashMap();
	
	final List<List<Chromatic>> notes = new ArrayList();

	public Tuning(Temperament t, NoteTuning nb, double frequencyBase) {
		temperament = t;
		noteBase = nb;

		NoteTuning note = nb.clone();
		double freq = frequencyBase;

		for (int i = 0; i < 7; i++) {
			map.put( note, freq );
			addPrevious( note, freq );
			addNext( note, freq );
			/*addFlat( note, freq );
			addSharp( note, freq );*/

			Chromatic simpleNote = AlterationsCalculator.removeAlterationsFrom(note.note);
			NoteTuning prev = note;
			note = prev.clone();
			note.note = note.note.nextDiatonic();
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
	
	public double get(Chromatic c, int octave) {
		NoteTuning n = new NoteTuning(c, octave);
		return map.get( n );
	}
	
	public double get(PitchMidi n) {
		Chromatic chromatic = ChromaticAdapter.from(n);
		return get(chromatic, n.getOctave() );
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
		List<NoteFreq> notes = new ArrayList();
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
			//if (nn.note.getAlterations() == 0)
				System.out.println(nn);
	}

	static class NoteFreq extends NoteTuning {
		public NoteFreq(Chromatic c, int o, double f) {
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
