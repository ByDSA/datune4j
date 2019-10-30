package es.danisales.datune.tuning;

import es.danisales.datune.musical.AlterationException;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.transformations.AlterationsCalculator;

public abstract class DiatonicTemperament extends Temperament<Chromatic> {
	public abstract double semi();
	public abstract double tone();
	public double octave() {
		return 2;
	}
	
	@Override
	public DiatonicOctave makeOctave(Chromatic note, double freq) {
		DiatonicOctave dOct = new DiatonicOctave();
		
		dOct.put( note, freq );
		//addPrevious( note, noteBase );
		//addNext( note, noteBase );
		addFlat( dOct, note, freq );
		addSharp( dOct, note, freq );

		Chromatic simpleNote = AlterationsCalculator.removeAlterationsFrom(note);
		note = note.nextDiatonic();
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


	private void addFlat(DiatonicOctave map, Chromatic note, double freq) {
		freq /= semi();
		note = note.subSemi();
		while(freq >= Tuning.MIN_FREQUENCY) {
			map.put(note, freq );

			freq /= semi();
			try {
				note = note.subSemi();
			} catch(AlterationException e) {
				break;
			}
		}
	}
	
	private void addSharp(DiatonicOctave map, Chromatic note, double freq) {
		freq *= semi();
		note = note.addSemi();
		while(freq <= Tuning.MAX_FREQUENCY) {
			map.put(note, freq );

			freq *= semi();
			try {
				note = note.addSemi();
			} catch(AlterationException e) {
				break;
			}
		}
	}
}
