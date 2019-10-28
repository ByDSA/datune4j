package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.midi.Events.NoteOff;
import es.danisales.datune.midi.Events.NoteOn;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.others.Codeable;

import java.util.List;

public class ChromaticMidi implements PitchOctaveMidi, Codeable, EventComplex, PitchChromaticSingle {
	protected PitchMidi	pitch;
	protected int	velocity;
	protected int	length;
	
	protected ChromaticMidi() { }

	public static ChromaticMidi[] array(List<ChromaticMidi> notes) {
		ChromaticMidi[] notesArray = new ChromaticMidi[notes.size()];
		int i = 0;
		for ( ChromaticMidi n : notes )
			notesArray[i++] = n;
	
		return notesArray;
	}

	public static ChromaticMidi[] array(Chromatic... cs) {
		ChromaticMidi[] ns = new ChromaticMidi[cs.length];
		for ( int i = 0; i < cs.length; i++ ) {
			ns[i] = cs[i].toMidi();
			if ( i > 0 )
				if ( cs[i].val() < cs[i - 1].val() )
					ns[i].setOctave( ns[i - 1].getOctave() + 1 );
				else
					ns[i].setOctave( ns[i - 1].getOctave() );
		}
		return ns;
	}
	
	@Override
	public ChromaticMidi clone() {
		return of( pitch, length, velocity );
	}

	public int dist(ChromaticMidi cm) {
		return cm.getCode() - getCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ChromaticMidi))
			return false;
	
		ChromaticMidi cm = (ChromaticMidi) o;
	
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

	@Override
	public EventSequence getEvents() {
		EventSequence es = new EventSequence();
		es.add( 0, new NoteOn( this ) );
		es.add( length, new NoteOff( this ) );

		return es;
	}

	@Override
	public Diatonic getDiatonic(Tonality ton) throws TonalityException {
		DiatonicDegree degree = ton.getDegree( getChromatic() );
		return Diatonic.get( degree );
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

	@Override
	public Chromatic getChromatic() {
		return pitch.getChromatic();
	}

	public static ChromaticMidi of(int code, int d, int v) {
		PitchMidi p = PitchMidi.of( code );
		return ChromaticMidi.of( p, d, v );
	}

	public static ChromaticMidi of(PitchMidi p, int d, int v) {
		ChromaticMidi cm = new ChromaticMidi();
		cm.setLength( d );
		cm.setVelocity( v );
		cm.pitch = p;
		
		return cm;
	}

	public static ChromaticMidi of(Chromatic c, int o, int d, int v) {
		return of( PitchMidi.of( c, o ), d, v );
	}

	public static ChromaticMidi of(int code, int d) {
		return of( code, d, Settings.DefaultValues.VELOCITY );
	}

	public static ChromaticMidi of(int code) {
		return of(
			code, Settings.DefaultValues.DURATION_NOTE, Settings.DefaultValues.VELOCITY
		);
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
		pitch = (PitchMidi) pitch.setOctave( o );
		return this;
	}

	public ChromaticMidi shift(IntervalChromatic i) {
		pitch = pitch.shift( i );
		return this;
	}

	public ChromaticMidi shiftOctave(int o) {
		pitch = (PitchMidi) pitch.shiftOctave( o );
		return this;
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
}
