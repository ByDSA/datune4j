package es.danisales.datune.midi.Progressions;

import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.Duration;
import es.danisales.datune.midi.arpegios.Arpegio;
import es.danisales.datune.midi.arpegios.ArpegioDefault;
import es.danisales.datune.midi.binaries.events.EventComplex;
import es.danisales.datune.midi.binaries.events.KeySignatureEvent;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.tonality.Tonality;

import java.util.ArrayList;
import java.util.List;

public class Progression<This extends Progression> implements EventComplex {
	protected Tonality tonality;
	protected int octave;

	private List<DiatonicChordMidi> nodes;

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
	 * @param n    número de corde en el tiempo
	 * @param t	Grado del acorde
	 * @param o	Desplazamiento de octava
	 * @return Acorde reemplazado
	 */
	public DiatonicChordMidi replaceChord(int n, DiatonicFunction t, int o) {
		DiatonicChordMidi c;
		o += octave;

        c = DiatonicChordMidi.builder()
                .from(t, tonality)
                .octave(o)
                .build();

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
		DiatonicChordMidi c;
		o += octave;

        c = DiatonicChordMidi.builder()
                .from(t, tonality)
                .octave(o)
                .build();

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
		c.add( NoteDiatonic.add(c.fromIndex(0), i) );

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

	public Tonality getTonality() {
		return tonality;
	}

	public EventSequence getEvents() {
		EventSequence es = new EventSequence();
		int duration = 0;
		for(DiatonicChordMidi node : nodes) {
			Tonality s = node.getTonality();
			if (duration % Duration.L1 == 0)
				es.add(duration, new KeySignatureEvent(s));

			es.add(duration, node);
			duration += node.getLength();
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
		for (int i1 : n) setArpegio(i1, a);

		return this;
	}

	public Progression setOctave(int o) {
		octave = o;

		return this;
	}

	public Progression shiftOctave(int o) throws PitchMidiException {
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

	public List<DiatonicChordMidi> getChords() {
		return nodes;
	}

	public DiatonicChordMidi getChord(int n) {
		DiatonicChordMidi nn = nodes.get(n);
		return nn;
	}

	public DiatonicChordMidi getChordAtTime(int t) {
		int duration = 0;
		for(DiatonicChordMidi n : nodes) {
			int d = n.getLength();
			if (duration + d > t)
				return n;
			duration += d;
		}

		throw new OutOfTimeException(t, duration);
	}

	public int getDuration() {
		int d = 0;
		for(DiatonicChordMidi n : nodes)
			d += n.getLength();

		return d;
	}

	@Override
	public This clone() {
		Progression p = new Progression();

		p.octave = octave;

		for(DiatonicChordMidi n : nodes) {
            p.nodes.add(n.clone());
		}

		p.tonality = Tonality.from(tonality.getRoot(),tonality.getScale());

		return (This)p;
	}

	static class OutOfTimeException extends RuntimeException {
		OutOfTimeException(int t, int d) {
            super(t + " " + d);
		}
	}
}
