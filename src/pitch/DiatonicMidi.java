package pitch;

import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.IntervalChromatic;
import diatonic.IntervalDiatonic;
import diatonic.Tonality;
import diatonic.TonalityException;
import eventsequences.EventSequence;
import midi.Settings;
import midi.Settings.DefaultValues;

public class DiatonicMidi implements NoteMidi<DiatonicMidi, IntervalChromatic>,
		PitchDiatonic<DiatonicMidi, IntervalChromatic> {
	protected Degree	degree;
	protected Tonality	tonality;
	protected int		velocity;
	protected int		octave;
	protected int		length;

	/* Constructores */
	public DiatonicMidi(Degree degree, Tonality tonality, int octave, int duration, int vel) {
		assert degree != null;

		set( duration, vel );
		int d = degree.val();
		this.octave = octave +
				( d < 0 && d % tonality.getScale().length() != 0 ? -1 : 0 );
		this.tonality = tonality;
		setDegree( degree );
	}

	public DiatonicMidi(Degree degree, Tonality tonality, int octave, int duration) {
		this( degree, tonality, octave, duration, DefaultValues.VELOCITY );
	}

	public DiatonicMidi(Degree degree, Tonality tonality, int octave) {
		this( degree, tonality, octave, DefaultValues.DURATION_NOTE );
	}

	public DiatonicMidi(DiatonicFunction f, Tonality tonality, int octave, int duration, int velocity) {
		this( f.getDegree(), tonality, octave, duration, velocity );
	}

	public DiatonicMidi(IntervalDiatonic id, Tonality tonality, int octave, int duration, int velocity) {
		this(
			Degree.get( id.val() ), tonality, octave + id.val() / IntervalDiatonic.OCTAVE.val(), duration, velocity
		);
	}

	public DiatonicMidi(DiatonicFunction f, Tonality tonality, int octave, int duration) {
		this( f, tonality, octave, duration, Settings.DefaultValues.VELOCITY );
	}

	public DiatonicMidi(IntervalDiatonic id, Tonality tonality, int octave, int duration) {
		this( id, tonality, octave, duration, Settings.DefaultValues.VELOCITY );
	}

	public DiatonicMidi(DiatonicFunction f, Tonality tonality, int octave) {
		this( f, tonality, octave, Settings.DefaultValues.DURATION_NOTE );
	}

	public DiatonicMidi(IntervalDiatonic id, Tonality tonality, int octave) {
		this( id, tonality, octave, Settings.DefaultValues.DURATION_NOTE );
	}

	public DiatonicMidi(Tonality tonality, int octave, int d) {
		this( Degree.I, tonality, octave, d );
	}

	public DiatonicMidi(Tonality tonality, int octave) {
		this( tonality, octave, Settings.DefaultValues.DURATION_NOTE );
	}

	public DiatonicMidi(Tonality tonality) {
		this( tonality, Settings.DefaultValues.OCTAVE );
	}

	public DiatonicMidi add(int i) {
		int degreeInt = getDegree().val() + i;
		int o = ( degreeInt ) / IntervalDiatonic.OCTAVE.val();
		if ( degreeInt < 0 )
			o--;
		Degree degree = Degree.get( degreeInt );
		assert degree != null : getDegree().val() + " " + i;

		setDegree( degree );
		shiftOctave( o );
		return this;
	}

	public DiatonicMidi add(IntervalDiatonic i) {
		return add( i.val() );
	}

	/* Métodos estáticos */
	public static DiatonicMidi add(final DiatonicMidi n, int i) {
		return n.duplicate( true ).add( i );
	}

	public static DiatonicMidi add(final DiatonicMidi n, IntervalDiatonic i) {
		return add( n, i.val() );
	}

	public DiatonicMidi setTonality(Tonality s) {
		assert s != null;
		tonality = s;

		return this;
	}

	@Override
	public DiatonicMidi duplicate(boolean b) {
		return new DiatonicMidi( degree, tonality.duplicate(), octave, length, velocity );
	}

	public DiatonicMidi setDegree(int p) {
		degree = Degree.get( tonality.getScale().trim( p ) );

		return this;
	}

	public DiatonicMidi setDegree(Degree d) {
		return setDegree( d.val() );
	}

	public DiatonicMidi shiftPos(int p) {
		return setDegree( getDegree().val() + p );
	}

	public IntervalChromatic dist(DiatonicMidi n) throws TonalityException {
		if ( !n.tonality.equals( tonality ) )
			throw new TonalityException( this, n );

		int tonalityLength = n.getTonality().length();

		IntervalDiatonic id = IntervalDiatonic.get(
			n.getOctave() * tonalityLength + n.getDegree().val()
					- ( getOctave() * tonalityLength + getDegree().val() )
		);
		int diffSemi = n.getPitchCode().val() - getPitchCode().val();
		return IntervalChromatic.get( id, diffSemi );
	}

	public Pitch getPitchCode() {
		int note = tonality.get( degree ).val() + octave * 12;
		if ( tonality.get( degree ).val() < tonality.getRoot().val() )
			note += 12;

		return Pitch.getFromCode( note );
	}

	public Degree getDegree() {
		return degree;
	}

	public Tonality getTonality() {
		return tonality;
	}

	@Override
	public String toString() {
		return toChromaticMidi().toString( tonality ) + " (" + degree + ")";
	}

	public ChromaticMidi toChromaticMidi() {
		int n = getPitchCode().val();
		ChromaticMidi note = ChromaticMidi.getFromCode( n, length, velocity );
		return note;
	}

	@Override
	public EventSequence getEvents() {
		ChromaticMidi n = toChromaticMidi();
		return n.getEvents();
	}

	public String toStringFull() {
		return degree.toString() + " " + tonality.toString() + " Octava " + octave + " Duración: "
				+ length + " Velocity: " + velocity;
	}

	@Override
	public Chromatic getChromatic() {
		return toChromaticMidi().getChromatic();
	}

	@Override
	public DiatonicMidi setVelocity(int v) {
		velocity = v;
		return this;
	}

	@Override
	public int getVelocity() {
		return velocity;
	}

	@Override
	public DiatonicMidi setLength(int d) {
		length = d;
		return this;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public DiatonicMidi shiftOctave(int o) {
		octave += o;
		return this;
	}

	@Override
	public DiatonicMidi setOctave(int o) {
		octave = o;
		return this;
	}

	@Override
	public int getOctave() {
		return octave;
	}

	@Override
	public boolean equals(Object obj) {
		if ( !( obj instanceof DiatonicMidi ) )
			return false;
		DiatonicMidi dm = (DiatonicMidi) obj;
		return degree.equals( dm.degree ) && tonality.equals( dm.tonality ) && octave == dm.octave && length == dm.length && velocity == dm.velocity;
	}

	public boolean equalsEnharmonic(PitchCode c) {
		return this.getChromatic().equalsEnharmonic( c.getChromatic() );
	}
}
