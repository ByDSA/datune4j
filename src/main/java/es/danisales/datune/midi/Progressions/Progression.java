package es.danisales.datune.midi.Progressions;

import java.util.ArrayList;

import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.Duration;
import es.danisales.datune.midi.Arpegios.Arpegio;
import es.danisales.datune.midi.Arpegios.ArpegioDefault;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.midi.Events.KeySignatureEvent;
import es.danisales.datune.tonality.Tonality;

public class Progression<This extends Progression> implements EventComplex {

	protected Tonality tonality;
	protected int octave;

	protected ArrayList<DiatonicChordMidi> nodes;

	private Progression() {
		super();
		nodes = new ArrayList<>();

		setArpegio(new ArpegioDefault());
	}

	public Progression(Tonality s, int o) {
		this();
		tonality = s;
		octave = o;
	}

	/** Replace Chord
	 * 
	 * @param n	N�mero de corde en el tiempo
	 * @param t	Grado del acorde
	 * @param o	Desplazamiento de octava
	 * @return Acorde reemplazado
	 */
	public DiatonicChordMidi replaceChord(int n, DiatonicFunction t, int o) {
		DiatonicChordMidi c = null;
		o += octave;

		c = new DiatonicChordMidi(t, o, tonality);

		nodes.set(n, c);

		return c;
	}

	public DiatonicChordMidi replaceChord(int n, DiatonicFunction t) {
		return replaceChord(n, t, 0);
	}

	/** A�adir acordes **/

	public DiatonicChordMidi add(HarmonicFunction t) {
		return add(t, 0);
	}

	public DiatonicChordMidi add(DiatonicChordMidi c) {
		nodes.add(c);

		return c;
	}

	public DiatonicChordMidi add(HarmonicFunction t, int o) {
		DiatonicChordMidi c = null;
		o += octave;

		c = new DiatonicChordMidi(t, o, tonality);

		return add(c);
	}

	/** A�adir acordes de dos notas **/
	/*
	public ChordFunc add(Degree degree, IntervalDiatonic i) {
		return add(degree, i, 0);
	}

	public ChordFunc add(Degree degree, IntervalDiatonic i, int o) {
		ChordFunc c = null;
		o += octave;

		c = new ChordFunc(tonality, o);
		c.add(degree);
		c.add( NoteDiatonic.add(c.get(0), i) );

		return add(c);
	}
	 */
	public Progression setTonality(Tonality s) {
		tonality = s;

		for(DiatonicChordMidi n : nodes) {
			n.setTonality(tonality);
		}

		return this;
	}

	public Tonality getScale() {
		return tonality;
	}

	public EventSequence getEvents() {
		EventSequence es = new EventSequence();
		int duration = 0;
		for(DiatonicChordMidi node : nodes) {
			Tonality s = node.getTonality();
			if (duration % Duration.V1 == 0)
				es.add(duration, new KeySignatureEvent(s));

			es.add(duration, node);
			duration += node.getDuration();
		}

		return es;
	}

	public Progression setArpegio(Arpegio a) {
		for (DiatonicChordMidi n : nodes) {
			n.setArpegio(a);
		}

		return this;
	}
	public Progression setArpegio(int n, Arpegio a) {
		DiatonicChordMidi nn = this.getChords().get(n);
		nn.setArpegio(a);

		return this;
	}

	public Progression setArpegio(int[] n, Arpegio a) {
		for(int i = 0; i < n.length; i++)
			setArpegio(n[i], a);

		return this;
	}

	public Progression setOctave(int o) {
		octave = o;

		return this;
	}

	public Progression shiftOctave(int o) {
		for(DiatonicChordMidi n : nodes)
			n.shiftOctave(o);

		return setOctave(octave + o);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		boolean first = true;

		for(DiatonicChordMidi n : nodes) {
			if (first)
				first = false;
			else
				sb.append("-");
			/*
			if (n instanceof NodeChord)
				switch(((NodeChord) n).type) {
				case Chord.I: sb.append("I"); break;
				case Chord.II: sb.append("II"); break;
				case Chord.III: sb.append("III"); break;
				case Chord.IV: sb.append("IV"); break;
				case Chord.V: sb.append("V"); break;
				case Chord.VI: sb.append("VI"); break;
				case Chord.VII: sb.append("VII"); break;
				case Chord.i: sb.append("i"); break;
				case Chord.ii: sb.append("ii"); break;
				case Chord.iii: sb.append("iii"); break;
				case Chord.iv: sb.append("iv"); break;
				case Chord.v: sb.append("v"); break;
				case Chord.vi: sb.append("vi"); break;
				case Chord.vii: sb.append("vii"); break;
				}
			 */
		}

		return sb.toString();
	}

	public int size() {
		return nodes.size();
	}

	public ArrayList<DiatonicChordMidi> getChords() {
		return nodes;
	}

	public DiatonicChordMidi getChord(int n) {
		DiatonicChordMidi nn = nodes.get(n);
		return nn;
	}

	public DiatonicChordMidi getChordAtTime(int t) {
		int duration = 0;
		for(DiatonicChordMidi n : nodes) {
			int d = n.getDuration();
			if (duration + d > t)
				return n;
			duration += d;
		}

		throw new OutOfTimeException(t, duration);
	}

	public int getDuration() {
		int d = 0;
		for(DiatonicChordMidi n : nodes)
			d += n.getDuration();

		return d;
	}

	@Override
	public This clone() {
		Progression p = new Progression();

		p.octave = octave;

		for(DiatonicChordMidi n : nodes) {
			p.nodes.add((DiatonicChordMidi)n.clone());
		}

		p.tonality = Tonality.of(tonality.getRoot(),tonality.getScale());

		return (This)p;
	}

	static class OutOfTimeException extends RuntimeException {
		OutOfTimeException(int t, int d) {
			super(Integer.toString(t) + " " + Integer.toString(d));
		}
	}
}
