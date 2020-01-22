package es.danisales.datune.midi.Progressions;

import es.danisales.datune.chords.TonalChord;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DurationMidi;
import es.danisales.datune.midi.arpegios.Arpeggio;
import es.danisales.datune.midi.arpegios.ArpeggioDefault;
import es.danisales.datune.midi.binaries.events.EventComplex;
import es.danisales.datune.midi.binaries.events.KeySignatureEvent;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.building.BuildingException;

import java.util.ArrayList;
import java.util.List;

public class Progression<This extends Progression> implements EventComplex {
	protected Tonality tonality;
	protected int octave;

	private List<DiatonicChordMidi> nodes;

	private Progression() {
		super();
		nodes = new ArrayList<>();

		setArpegio(new ArpeggioDefault());
	}

	public Progression(Tonality s, int o) {
		this();
		tonality = s;
		octave = o;
	}

	/** Replace ChordProxy
	 *
	 * @param n    número de corde en el tiempo
	 * @param diatonicFunction    Grado del acorde
	 * @param o	Desplazamiento de octava
	 * @return Acorde reemplazado
	 */
	public DiatonicChordMidi replaceChord(int n, DiatonicFunction diatonicFunction, int o) {
		DiatonicChordMidi c = null;
		o += octave;

		try {
			c = DiatonicChordMidi.builder()
					.from(TonalChord.from(tonality, diatonicFunction))
					.octave(o)
					.build();
		} catch (BuildingException e) {
			e.printStackTrace();
		}

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

		try {
			c = DiatonicChordMidi.builder()
					.from(TonalChord.from(tonality, t))
					.octave(o)
					.build();
		} catch (BuildingException e) {
			e.printStackTrace();
		}

		return add(c);
	}

	/** A�adir acordes de dos notas **/
	/*
	public ChordFunc addData(ScaleDegree relativedegree, IntervalDiatonic i) {
		return addData(relativedegree, i, 0);
	}

	public ChordFunc addData(ScaleDegree relativedegree, IntervalDiatonic i, int o) {
		ChordFunc c = null;
		o += octave;

		c = new ChordFunc(tonality, o);
		c.addData(relativedegree);
		c.addData( NoteDiatonic.addData(c.fromIndex(0), i) );

		return addData(c);
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
			if (duration % DurationMidi.L1 == 0)
				es.add(duration, new KeySignatureEvent(s));

			es.add(duration, node);
			duration += node.getLength();
		}

		return es;
	}

	public Progression setArpegio(Arpeggio a) {
		for (DiatonicChordMidi n : nodes) {
			n.setArpeggio(a);
		}

		return this;
	}

	public Progression setArpegio(int n, Arpeggio a) {
		DiatonicChordMidi nn = this.getChords().get(n);
		nn.setArpeggio(a);

		return this;
	}

	public Progression setArpegio(int[] n, Arpeggio a) {
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
				case ChordProxy.I: sb.append("I"); break;
				case ChordProxy.II: sb.append("II"); break;
				case ChordProxy.III: sb.append("III"); break;
				case ChordProxy.IV: sb.append("IV"); break;
				case ChordProxy.V: sb.append("V"); break;
				case ChordProxy.VI: sb.append("VI"); break;
				case ChordProxy.VII: sb.append("VII"); break;
				case ChordProxy.i: sb.append("i"); break;
				case ChordProxy.ii: sb.append("ii"); break;
				case ChordProxy.iii: sb.append("iii"); break;
				case ChordProxy.iv: sb.append("iv"); break;
				case ChordProxy.v: sb.append("v"); break;
				case ChordProxy.vi: sb.append("vi"); break;
				case ChordProxy.vii: sb.append("vii"); break;
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
		return nodes.get(n);
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
