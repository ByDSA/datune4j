package pitch;

import java.util.List;

import diatonic.DiatonicDegree;
import diatonic.IntervalChromatic;
import eventsequences.EventSequence;
import midi.Settings;
import midi.Events.NoteOff;
import midi.Events.NoteOn;
import musical.Chromatic;
import musical.Diatonic;
import tonality.Tonality;
import tonality.TonalityException;

public class ChromaticMidi extends NoteMidiReal implements PitchChromaticSingle {

	public ChromaticMidi(NoteMidi p, int d, int v) {
		super(p, d, v);
	}

	public ChromaticMidi(Chromatic c, int o, int d, int v) {
		this( NoteMidi.of( c, o ), d, v );
	}

	public ChromaticMidi(ChromaticMidi n) {
		this( n.pitch, n.length, n.velocity );
	}

	@Override
	public Chromatic getChromatic() {
		return pitch.getChromatic();
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

	/*
	 * public void play(int ms, MidiChannel c) { c.noteOn(getCode(), 100);
	 * System.out.println(this + " " + this.getOctave());
	 * 
	 * try { Thread.sleep(ms); // wait time in milliseconds to control duration }
	 * catch( InterruptedException e ) { } c.noteOff(getCode(), 100); }
	 */

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

	@Override
	public ChromaticMidi clone() {
		return new ChromaticMidi( pitch, length, velocity );
	}
	/*
	 * public static NoteChromatic[] duplicate(NoteChromatic[] n) { NoteChromatic[]
	 * r = new NoteChromatic[n.length]; for(int i = 0; i < n.length; i++) { r[i] =
	 * n[i].duplicate(true); }
	 * 
	 * return r; }
	 */

	public static ChromaticMidi[] array(List<ChromaticMidi> notes) {
		ChromaticMidi[] notesArray = new ChromaticMidi[notes.size()];
		int i = 0;
		for ( ChromaticMidi n : notes )
			notesArray[i++] = n;

		return notesArray;
	}

	public static ChromaticMidi getFromCode(int code, int d, int v) {
		NoteMidi p = NoteMidi.of( code );
		return new ChromaticMidi( p, d, v );
	}

	public static ChromaticMidi getFromCode(int code, int d) {
		return getFromCode( code, d, Settings.DefaultValues.VELOCITY );
	}

	public static ChromaticMidi getFromCode(int code) {
		return getFromCode(
			code, Settings.DefaultValues.DURATION_NOTE, Settings.DefaultValues.VELOCITY
		);
	}

	public ChromaticMidi setVelocity(int v) {
		velocity = v;
		return this;
	}

	public int getVelocity() {
		return velocity;
	}

	public ChromaticMidi setLength(int d) {
		length = d;
		return this;
	}

	public int getLength() {
		return length;
	}

	public ChromaticMidi shiftOctave(int o) {
		pitch = (NoteMidi) pitch.shiftOctave( o );
		return this;
	}

	public ChromaticMidi setOctave(int o) {
		pitch = (NoteMidi) pitch.setOctave( o );
		return this;
	}

	public int getOctave() {
		return pitch.getOctave();
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

	@Override
	public Diatonic getDiatonic(Tonality ton) throws TonalityException {
		DiatonicDegree degree = ton.getDegree( getChromatic() );
		return Diatonic.get( degree );
	}

	public ChromaticMidi shift(IntervalChromatic i) {
		pitch = pitch.shift( i );
		return this;
	}

	@Override
	public double getFrequency() {
		return pitch.getFrequency();
	}

	public int dist(ChromaticMidi cm) {
		return cm.getCode() - getCode();
	}
}
