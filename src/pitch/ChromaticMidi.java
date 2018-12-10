package pitch;

import java.util.List;

import diatonic.Degree;
import diatonic.IntervalChromatic;
import diatonic.IntervalDiatonic;
import eventsequences.EventSequence;
import midi.Settings;
import midi.Events.NoteOff;
import midi.Events.NoteOn;
import tonality.Tonality;
import tonality.TonalityException;

public class ChromaticMidi
		implements NoteMidi<ChromaticMidi, Integer>, PitchChromaticSingle {
	protected int	velocity;
	protected PitchMidi	pitch;
	protected int	length;

	public PitchMidi getPitchCode() {
		return PitchMidi.get( pitch.getChromatic(), pitch.getOctave() );
	}

	public ChromaticMidi(PitchMidi p, int d, int v) {
		set( d, v );
		pitch = p;
	}

	public ChromaticMidi(Chromatic c, int o, int d, int v) {
		this( PitchMidi.get( c, o ), d, v );
	}

	public ChromaticMidi(ChromaticMidi n) {
		this( n.pitch, n.length, n.velocity );
	}

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

	@Override
	public DiatonicMidi toDiatonicChordMidi(Tonality ton) throws TonalityException {
		assert ton != null;
		Degree pos = ton.getDegree( getChromatic() );
		if ( pos == null )
			throw new TonalityException( this, ton );
		else {
			int octaveNote = getOctave();
			DiatonicMidi ns = new DiatonicMidi( pos, ton, pitch.getOctave(), length, velocity );
			int octaveNoteScaleNote = ns.toChromaticMidi().getOctave();
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
			Degree pos = s.getDegree( n );
			if ( pos != null )
				n = s.get( pos );
		}

		return n.toString();
	}

	public ChromaticMidi add(int i) {
		pitch = PitchMidi.add( pitch, i );
		return this;
	}

	public ChromaticMidi add(IntervalDiatonic i) {
		return add( i.val() );
	}

	/* Métodos estáticos */
	public static ChromaticMidi add(final ChromaticMidi n, int i) {
		return n.clone().add( i );
	}

	public static ChromaticMidi add(final ChromaticMidi n, IntervalChromatic i) {
		return add( n, i.val() );
	}

	@Override
	public EventSequence getEvents() {
		EventSequence es = new EventSequence();
		es.add( 0, new NoteOn( this, 100 ) );
		es.add( length, new NoteOff( this, 100 ) );

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
		PitchMidi p = PitchMidi.getFromCode( code );
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

	@Override
	public int val() {
		return pitch.getChromatic().val();
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
		pitch = pitch.shiftOctave( o );
		return this;
	}

	public ChromaticMidi setOctave(int o) {
		pitch = pitch.setOctave( o );
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
}
