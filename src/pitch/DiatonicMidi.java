package pitch;

import diatonic.Degree;
import diatonic.DiatonicFunction;
import diatonic.IntervalChromatic;
import diatonic.IntervalDiatonic;
import eventsequences.EventSequence;
import midi.Settings;
import midi.Settings.DefaultValues;
import tonality.Tonality;
import tonality.TonalityException;

public class DiatonicMidi implements NoteMidi, PitchDiatonic<DiatonicMidi, IntervalChromatic> {
	protected Degree	degree;
	protected int		octave;
	
	protected Tonality	tonality;
	protected int		velocity;
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
	
	public DiatonicMidi sub(IntervalDiatonic i) {
		return _add(-i.val());
	}
	
	private DiatonicMidi _add(int i) {
		int degreeInt = getDegree().val() + i;
		int o = ( degreeInt ) / IntervalDiatonic.OCTAVE.val();
		if ( degreeInt < 0 )
			o--;
		Degree degree = Degree.get( degreeInt );
		assert degree != null : getDegree().val() + " " + i;

		DiatonicMidi dm = clone();
		dm.setDegree( degree );
		dm.shiftOctave( o );
		return dm;
	}

	public DiatonicMidi add(IntervalDiatonic i) {
		return _add(i.val());
	}

	public DiatonicMidi setTonality(Tonality s) {
		assert s != null;
		tonality = s;

		return this;
	}

	@Override
	public DiatonicMidi clone() {
		return new DiatonicMidi( degree, Tonality.of( tonality ), octave, length, velocity );
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

		IntervalDiatonic id = IntervalDiatonic.of(
			n.getOctave() * tonalityLength + n.getDegree().val()
					- ( getOctave() * tonalityLength + getDegree().val() )
		);
		int diffSemi = n.getPitchCode().getCode() - getPitchCode().getCode();
		return IntervalChromatic.get( id, diffSemi );
	}

	public PitchMidiEnum getPitchCode() {
		int note = tonality.get( degree ).val() + octave * 12;
		if ( tonality.get( degree ).val() < tonality.getRoot().val() )
			note += 12;

		return PitchMidiSingle.of( note );
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
		int n = getPitchCode().getCode();
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

	public boolean equalsEnharmonic(PitchChromaticableSingle c) {
		return this.getChromatic().equalsEnharmonic( c.getChromatic() );
	}

	@Override
	public int getCode() {
		return this.toChromaticMidi().getCode();
	}
}
