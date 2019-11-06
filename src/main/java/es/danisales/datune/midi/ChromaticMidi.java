package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.Events.NoteOff;
import es.danisales.datune.midi.Events.NoteOn;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.transformations.DistanceCalculator;
import es.danisales.datune.musical.transformations.Namer;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class ChromaticMidi implements PitchSingleMidi, PitchChromaticSingle, PitchOctaveMidiEditable {
	protected PitchMidi	pitch;
	protected int	velocity;
	protected int	length;
	
	private ChromaticMidi() { }

    public static ChromaticMidi from(PitchSingleMidi diatonicMidi) {
		return ChromaticMidi.builder()
				.pitch(diatonicMidi.getPitchMidi())
				.velocity(diatonicMidi.getVelocity())
				.length(diatonicMidi.getLength())
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

	@Override
	public PitchMidi getPitchMidi() {
		return pitch;
	}

	public int dist(ChromaticMidi cm) {
		return DistanceCalculator.calculateDistanceInSemitones(this, cm);
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof ChromaticMidi) )
			return false;
	
		ChromaticMidi cm = (ChromaticMidi) o;
	
		return velocity == cm.velocity  && pitch.equals( cm.pitch ) && length != cm.length;
	}

	@Override
	public int getCode() {
		return pitch.getCode();
	}

	@Override
	public EventSequence getEvents() {
		EventSequence es = new EventSequence();
		es.add( 0, new NoteOn( this ) );
		es.add( length, new NoteOff( this ) );

		return es;
	}
	
	public int getLength() {
		return length;
	}

	public int getVelocity() {
		return velocity;
	}

	public int getOctave() {
		return pitch.getOctave();
	}

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public ChromaticMidi setVelocity(int v) {
		velocity = v;
		return this;
	}

	@Override
	public ChromaticMidi setLength(int d) {
		length = d;
		return this;
	}

	@Override
	public void setOctave(int o) {
		pitch = pitch.getWithOctave( o );
	}

	public void shift(IntervalChromatic i) {
		pitch = pitch.getShift( i );
	}

	@Override
	public void shiftOctave(int o) {
		pitch = pitch.getWithShiftOctave( o );
	}

	public String toString(Tonality tonality) {
		return Namer.from(this, tonality);
	}

	@Override
	public String toString() {
		return Namer.from(this);
	}

	public static String literal(DiatonicAlt diatonicAlt, Tonality tonality) {
		if ( tonality != null ) {
			DiatonicDegree pos = tonality.getDegreeFrom( diatonicAlt );
			if ( pos != null )
				diatonicAlt = tonality.get( pos );
		}

		return diatonicAlt.toString();
	}

    public static class Builder extends es.danisales.utils.building.Builder<Builder, ChromaticMidi> {
        private PitchMidi _pitch;
        private int _velocity;
        private int _length;

        private Builder() {
            _pitch = PitchMidi.C5;
            _velocity = Settings.DefaultValues.VELOCITY;
            _length = Settings.DefaultValues.DURATION_NOTE;
        }

        public Builder pitch(PitchMidi pitchMidi) {
            _pitch = pitchMidi;

            return self();
        }

        public Builder pitch(int code) {
            return pitch( PitchMidi.from(code) );
        }

        public Builder pitch(Chromatic chromatic, int octave) {
            return pitch( PitchMidi.from(chromatic, octave) );
        }


		public Builder pitch(DiatonicAlt diatonicAlt, int octave) {
        	Chromatic chromatic = Chromatic.from(diatonicAlt);
			return pitch( PitchMidi.from(chromatic, octave) );
		}

        public Builder pitch(Chromatic chromatic) {
            _pitch = PitchMidi.from(chromatic, Settings.DefaultValues.OCTAVE);

            return self();
        }

        public Builder velocity(int velocity) {
            _velocity = velocity;

            return self();
        }

        public Builder length(int length) {
            _length = length;

            return self();
        }

        @NonNull
        @Override
        public ChromaticMidi build() {
            ChromaticMidi chromaticMidi = new ChromaticMidi();
            chromaticMidi.pitch = _pitch;
            chromaticMidi.length = _length;
            chromaticMidi.velocity = _velocity;
            return chromaticMidi;
        }

        @NonNull
        @Override
        protected Builder self() {
            return this;
        }
    }
}




