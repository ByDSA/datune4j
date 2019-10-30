package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.midi.Events.NoteOff;
import es.danisales.datune.midi.Events.NoteOn;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.musical.transformations.Namer;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.others.Codeable;
import org.checkerframework.checker.nullness.qual.NonNull;

import static es.danisales.datune.musical.transformations.DistanceCalculator.calculateDistance;

public class ChromaticMidi implements PitchOctaveMidi, Codeable, EventComplex, PitchChromaticSingle {
	protected PitchMidi	pitch;
	protected int	velocity;
	protected int	length;
	
	protected ChromaticMidi() { }
	
	@Override
	public ChromaticMidi clone() {
		return ChromaticMidi.builder()
				.pitch(pitch)
				.length(length)
				.velocity(velocity)
				.build();
	}

	public int dist(ChromaticMidi cm) {
		return calculateDistance(this, cm);
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

	public DiatonicMidi getDiatonicMidi(Tonality ton) throws TonalityException {
		assert ton != null;
		DiatonicDegree pos = ton.getDegree( ChromaticAdapter.from(this) );
		if ( pos == null )
			throw new TonalityException( this, ton );
		else {
			int octaveNote = getOctave();
			DiatonicMidi ns = DiatonicMidi.of( pos, ton, pitch.getOctave(), length, velocity );
			int octaveNoteScaleNote = ns.pitch.getOctave();
			ns.shiftOctave( octaveNote - octaveNoteScaleNote );

			return ns;
		}
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

	public PitchMidi getPitch() {
		return pitch;
	}

	public static Builder builder() {
		return new Builder();
	}

	public ChromaticMidi setVelocity(int v) {
		velocity = v;
		return this;
	}

	public ChromaticMidi setLength(int d) {
		length = d;
		return this;
	}

	@Override
	public ChromaticMidi setOctave(int o) {
		pitch = pitch.setOctave( o );
		return this;
	}

	public ChromaticMidi shift(IntervalChromatic i) {
		pitch = pitch.shift( i );
		return this;
	}

	public ChromaticMidi shiftOctave(int o) {
		pitch = pitch.shiftOctave( o );
		return this;
	}

	public String toString(Tonality tonality) {
		return Namer.from(this, tonality);
	}

	@Override
	public String toString() {
		return Namer.from(this);
	}

	public static String literal(Chromatic chromatic, Tonality tonality) {
		if ( tonality != null ) {
			DiatonicDegree pos = tonality.getDegree( chromatic );
			if ( pos != null )
				chromatic = tonality.get( pos );
		}

		return chromatic.toString();
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
            return pitch( PitchMidi.of(code) );
        }

        public Builder pitch(Chromatic chromatic, int octave) {
            return pitch( PitchMidi.of(chromatic, octave) );
        }

        public Builder pitch(Chromatic chromatic) {
            _pitch = PitchMidi.of(chromatic, Settings.DefaultValues.OCTAVE);

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




