package es.danisales.datune.midi;

import es.danisales.datune.diatonic.ChromaticDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.midi.Events.NoteOff;
import es.danisales.datune.midi.Events.NoteOn;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.transformations.DistanceCalculator;
import es.danisales.datune.musical.transformations.Namer;
import es.danisales.datune.pitch.ChordNamer;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;

public class ChromaticMidi extends Note<PitchChromaticMidi, ChromaticDegree, IntervalChromatic> implements PitchChromaticSingle, PitchOctaveMidiEditable, EventComplex {
	public static ChromaticMidiBuilder builder() {
		return new ChromaticMidiBuilder();
	}

	public static ChromaticMidi from(ChromaticMidi diatonicMidi) {
		return ChromaticMidi.builder()
				.pitch(diatonicMidi.getPitch())
				.velocity(diatonicMidi.getVelocity())
				.length(diatonicMidi.getLength())
				.build();
	}

	ChromaticMidi() { }

	public static ChromaticMidi from(DiatonicMidi diatonicMidi) {
		PitchChromaticMidi pitchChromaticMidi = PitchChromaticMidi.from(diatonicMidi.pitch);
		return ChromaticMidi.builder()
				.pitch(pitchChromaticMidi)
				.velocity(diatonicMidi.velocity)
				.length(diatonicMidi.length)
				.build();
	}

	@Override
	public ChromaticMidi clone() {
		return ChromaticMidi.builder()
				.pitch(pitch)
				.velocity(velocity)
				.length(length)
				.build();
	}

	public int dist(ChromaticMidi cm) {
		return DistanceCalculator.calculateDistanceInSemitones(this, cm);
	}

	@Override
	public EventSequence getEvents() {
		EventSequence es = new EventSequence();
		es.add( 0, new NoteOn( this ) );
		es.add( length, new NoteOff( this ) );

		return es;
	}

	@Override
	public final int getOctave() {
		return pitch.getOctave();
	}

	public void shift(IntervalChromatic i) {
		pitch = pitch.getShift( i );
	}

	@Override
	public final void shiftOctave(int o) {
		pitch = pitch.getWithShiftOctave( o );
	}

	@Override
	public final void setOctave(int o) {
		pitch = pitch.getWithOctave( o );
	}

	public String toString(Tonality tonality) {
		return Namer.from(this, tonality);
	}

	@Override
	public String toString() {
		return pitch + " (vel=" + velocity + ", length=" + length + ")";// Namer.from(this);
	}

	public static String literal(DiatonicAlt diatonicAlt, Tonality tonality) {
		if ( tonality != null ) {
			RelativeDegree pos = tonality.getDegreeFrom( diatonicAlt );
			if ( pos != null )
				diatonicAlt = tonality.getNote( pos );
		}

		return diatonicAlt.toString();
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof ChromaticMidi) )
			return false;

		ChromaticMidi chromaticMidi = (ChromaticMidi) o;

		return pitch.equals( chromaticMidi.pitch) && velocity == chromaticMidi.velocity && length == chromaticMidi.length;
	}

	@Override
	public int hashCode() {
		return pitch.hashCode() + 31 * ( Integer.hashCode(velocity) + 37 * Integer.hashCode(length) );
	}

	@Override
	public ChromaticDegree getDegree() {
		return pitch.getDegree();
	}

	@Override
	public ChromaticMidi getNext() {
		ChromaticMidi chromaticMidi = ChromaticMidi.from(this);
		chromaticMidi.pitch = chromaticMidi.pitch.getNext();
		return chromaticMidi;
	}

	@Override
	public ChromaticMidi getPrevious() {
		ChromaticMidi chromaticMidi = ChromaticMidi.from(this);
		chromaticMidi.pitch = chromaticMidi.pitch.getPrevious();
		return chromaticMidi;
	}

	@Override
	public ChromaticMidi getShifted(IntervalChromatic intervalChromatic) {
		return null;
	}

	@Override
	public ChromaticMidi getShiftedNegative(IntervalChromatic intervalChromatic) {
		return null;
	}
}