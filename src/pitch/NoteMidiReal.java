package pitch;

import java.util.List;

import diatonic.DiatonicDegree;
import diatonic.IntervalChromatic;
import eventsequences.EventSequence;
import midi.Settings;
import midi.Events.EventComplex;
import midi.Events.NoteOff;
import midi.Events.NoteOn;
import musical.Chromatic;
import musical.Diatonic;
import others.Codeable;
import tonality.Tonality;
import tonality.TonalityException;

public abstract class NoteMidiReal implements 
SingleFrequency, PitchMidi, Codeable, EventComplex, PitchChromaticSingle {
	protected int	velocity;
	protected NoteMidi	pitch;
	protected int	length;

	public NoteMidiReal(NoteMidi p, int d, int v) {
		setLength( d );
		setVelocity( v );
		pitch = p;
	}

	public NoteMidiReal(Chromatic c, int o, int d, int v) {
		this( NoteMidi.of( c, o ), d, v );
	}

	public NoteMidiReal(NoteMidiReal n) {
		this( n.pitch, n.length, n.velocity );
	}
	
	public NoteMidiReal clone() {
		try {
			return (NoteMidiReal) super.clone();
		} catch ( CloneNotSupportedException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Chromatic getChromatic() {
		return pitch.getChromatic();
	}

	public DiatonicMidi getDiatonicMidi(Tonality ton) throws TonalityException {
		assert ton != null;
		DiatonicDegree pos = ton.getDegree( getChromatic() );
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

	public String toString(Tonality s) {
		return literal( pitch.getChromatic(), s ) + pitch.getOctave();
	}

	@Override
	public String toString() {
		return toString( null );
	}

	public static String literal(Chromatic n, Tonality s) {
		if ( s != null ) {
			DiatonicDegree pos = s.getDegree( n );
			if ( pos != null )
				n = s.get( pos );
		}

		return n.toString();
	}

	/* Métodos estáticos */

	@Override
	public EventSequence getEvents() {
		EventSequence es = new EventSequence();
		es.add( 0, new NoteOn( this ) );
		es.add( length, new NoteOff( this ) );

		return es;
	}

	public NoteMidiReal setVelocity(int v) {
		velocity = v;
		return this;
	}

	public int getVelocity() {
		return velocity;
	}

	public NoteMidiReal setLength(int d) {
		length = d;
		return this;
	}

	public int getLength() {
		return length;
	}

	public NoteMidiReal shiftOctave(int o) {
		pitch = (NoteMidi) pitch.shiftOctave( o );
		return this;
	}

	public NoteMidiReal setOctave(int o) {
		pitch = (NoteMidi) pitch.setOctave( o );
		return this;
	}

	public int getOctave() {
		return pitch.getOctave();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof NoteMidiReal))
			return false;

		NoteMidiReal cm = (NoteMidiReal) o;

		if ( velocity != cm.velocity )
			return false;

		if ( !pitch.equals( cm.pitch ) )
			return false;

		if ( length != cm.length )
			return false;
		
		return true;
	}

	@Override
	public int getCode() {
		return pitch.getCode();
	}
	
	public NoteMidi getPitch() {
		return pitch;
	}

	@Override
	public Diatonic getDiatonic(Tonality ton) throws TonalityException {
		DiatonicDegree degree = ton.getDegree( getChromatic() );
		return Diatonic.get( degree );
	}

	public NoteMidiReal shift(IntervalChromatic i) {
		pitch = pitch.shift( i );
		return this;
	}

	@Override
	public double getFrequency() {
		return pitch.getFrequency();
	}
}
