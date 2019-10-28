package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.Settings.DefaultValues;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.PitchDiatonic;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;

public class DiatonicMidi extends ChromaticMidi implements PitchDiatonic {
	protected DiatonicDegree	degree;
	protected int		octave;
	protected Tonality	tonality;

	/* Constructores */	
	public static DiatonicMidi of(DiatonicDegree d, Tonality t, int o, int duration, int vel) {
		assert d != null;

		int dv = d.val();
		int octave = o +
				( dv < 0 && dv % t.getScale().length() != 0 ? -1 : 0 );
		
		DiatonicMidi dm = new DiatonicMidi();
		dm.setLength( duration );
		dm.setVelocity( vel );
		dm.tonality = t;
		dm.octave = octave;
		dm.degree = d;
		dm.pitch = PitchMidi.of( d, t, octave );
		
		return dm;
	}
	
	public static DiatonicMidi of(DiatonicFunction i, Tonality c, int o) {
		return of(i.getDegree(), c, o, DefaultValues.DURATION_NOTE, DefaultValues.VELOCITY);
	}
	
	public static DiatonicMidi of(DiatonicDegree d, Tonality c, int o) {
		return of(d, c, o, DefaultValues.DURATION_NOTE, DefaultValues.VELOCITY);
	}

	public DiatonicMidi sub(IntervalDiatonic i) {
		return _add(-i.val());
	}
	
	private DiatonicMidi _add(int i) {
		int degreeInt = getDegree().val() + i;
		int o = ( degreeInt ) / IntervalDiatonic.OCTAVE.val();
		if ( degreeInt < 0 )
			o--;
		DiatonicDegree degree = DiatonicDegree.get( degreeInt );
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
		return DiatonicMidi.of( degree, Tonality.of( tonality ), octave, length, velocity );
	}

	public DiatonicMidi setDegree(int p) {
		degree = DiatonicDegree.get( tonality.getScale().trim( p ) );

		return this;
	}

	public DiatonicMidi setDegree(DiatonicDegree d) {
		return setDegree( d.val() );
	}

	public DiatonicMidi shiftPos(int p) {
		return setDegree( getDegree().val() + p );
	}

	public IntervalChromatic distInterval(DiatonicMidi n) throws TonalityException {
		if ( !n.tonality.equals( tonality ) )
			throw new TonalityException( this, n );

		int tonalityLength = n.getTonality().length();

		IntervalDiatonic id = IntervalDiatonic.of(
			n.getOctave() * tonalityLength + n.getDegree().val()
					- ( getOctave() * tonalityLength + getDegree().val() )
		);
		int diffSemi = n.getCode() - getCode();
		return IntervalChromatic.get( id, diffSemi );
	}

	public DiatonicDegree getDegree() {
		return degree;
	}

	public Tonality getTonality() {
		return tonality;
	}

	@Override
	public String toString() {
		return toString( tonality ) + " (" + degree + ")";
	}

	public String toStringFull() {
		return degree.toString() + " " + tonality.toString() + " Octava " + octave + " Duraci�n: "
				+ length + " Velocity: " + velocity;
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
		updatePitch();
		return this;
	}
	
	protected void updatePitch() {
		pitch = PitchMidi.of( degree, tonality, octave );
	}

	@Override
	public DiatonicMidi setOctave(int o) {
		octave = o;
		updatePitch();
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

	public boolean equalsEnharmonic(PitchChromaticSingle c) {
		return this.getChromatic().equalsEnharmonic( c.getChromatic() );
	}

	@Override
	public Diatonic getDiatonic(Tonality ton) throws TonalityException {
		return Diatonic.get( degree );
	}
}
