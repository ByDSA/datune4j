package es.danisales.datune.tuning;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.chords.AlterationException;
import es.danisales.datune.chords.DiatonicAlt;

public abstract class DiatonicTemperament extends Temperament<DiatonicAlt> {
	public abstract double semi();
	public abstract double tone();
	public double octave() {
		return 2;
	}
	
	@Override
	public DiatonicOctave makeOctave(DiatonicAlt note, double freq) {
		DiatonicOctave dOct = new DiatonicOctave();
		
		dOct.put( note, freq );
		//addPrevious( note, noteBase );
		//addNext( note, noteBase );
		addFlat( dOct, note, freq );
		addSharp( dOct, note, freq );

		Chromatic simpleNote = Chromatic.from(note);
		note = note.getNextDiatonic();
		switch(simpleNote) {
			case A:
			case C:
			case D:
			case F:
			case G:
				freq *= tone();
				break;
			case B:
				freq /= octave();
			case E:
				freq *= semi();
				break;
			default: throw new RuntimeException();
		}
		
		return dOct;
	}


	private void addFlat(DiatonicOctave map, DiatonicAlt note, double freq) {
		freq /= semi();
        note = note.getAddSemi(-1);
		while(freq >= Tuning.MIN_FREQUENCY) {
			map.put(note, freq );

			freq /= semi();
			try {
                note = note.getAddSemi(-1);
			} catch(AlterationException e) {
				break;
			}
		}
	}
	
	private void addSharp(DiatonicOctave map, DiatonicAlt note, double freq) {
		freq *= semi();
        note = note.getAddSemi(1);
		while(freq <= Tuning.MAX_FREQUENCY) {
			map.put(note, freq );

			freq *= semi();
			try {
                note = note.getAddSemi(1);
			} catch(AlterationException e) {
				break;
			}
		}
	}
}
