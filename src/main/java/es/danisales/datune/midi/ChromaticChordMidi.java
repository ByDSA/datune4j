package es.danisales.datune.midi;

import es.danisales.datune.diatonic.ChromaticDegree;
import es.danisales.datune.diatonic.Interval;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.pitch.PitchOctave;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.datune.tonality.TonalityRetrieval;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ChromaticChordMidi extends ChordMidi<ChromaticMidi, ChromaticDegree, IntervalChromatic>
		implements PitchChromaticChord<ChromaticMidi> {
	protected ChromaticChordMidi() { }

	public static ChromaticChordMidi newEmpty() {
		return new ChromaticChordMidi();
	}

	public static @NonNull ChromaticChordMidi from(@NonNull ChromaticChordMidi ns) {
		ChromaticChordMidi ccm = new ChromaticChordMidi();
		ccm.addAll( ns );

		return ccm;
	}

	public static @NonNull ChromaticChordMidi from(@NonNull Chromatic... cs) {
		ChromaticChordMidi ns = new ChromaticChordMidi();
		for ( int i = 0; i < cs.length; i++ ) {
			ChromaticMidi chromaticMidi = ChromaticMidi.builder()
					.pitch(cs[i])
					.build();
			if ( i > 0 ) {
				int lastElementOctave = ns.get(ns.size()-1).getOctave();
				if (cs[i].ordinal() < (cs[i - 1].ordinal()))
					chromaticMidi.setOctave(lastElementOctave + 1);
				else
					chromaticMidi.setOctave(lastElementOctave);
			}
			ns.add( chromaticMidi );
		}
		return ns;
	}

	public static @NonNull ChromaticChordMidi from(@NonNull ChromaticMidi... ns) {
		ChromaticChordMidi ccm = new ChromaticChordMidi();
		ccm.addAll( Arrays.asList(ns) );

		return ccm;
	}

	public static ChromaticChordMidi of(PitchChromaticSingle... ns) {
		ChromaticChordMidi ccm = new ChromaticChordMidi();
		for (PitchChromaticSingle n : ns) {
			Chromatic chromatic = ChromaticAdapter.from(n);
			ChromaticMidi cm = ChromaticMidi.builder()
					.pitch(chromatic)
					.build();
			ccm.add( cm );
		}

		return ccm;
	}

	public static <N extends PitchChromaticSingle> ChromaticChordMidi from(Iterable<N> diatonicChordMidi) {
		ChromaticChordMidi This = new ChromaticChordMidi();

		for (N n : diatonicChordMidi) {
			ChromaticMidiBuilder builder = ChromaticMidi.builder();

			Chromatic chromaticN = ChromaticAdapter.from(n);

			if (n instanceof PitchOctave)
				builder.pitch(chromaticN, (((PitchOctave) n).getOctave()));
			else
				builder.pitch(chromaticN);

			if (n instanceof Durable) {
				builder.length(((Durable) n).getLength());
			}

			if (n instanceof VelocityNote) {
				builder.velocity(((VelocityNote) n).getVelocity());
			}

			ChromaticMidi cm = builder
					.build();
			Chromatic chromaticCm = Chromatic.from(cm);
			Chromatic prevChromatic = Chromatic.from(This.get(This.size() - 1));
			if (!(n instanceof PitchOctave) && This.size() > 0 && chromaticCm.ordinal() <= prevChromatic.ordinal()) {
				cm.shiftOctave(1);
			}

			This.add(cm);
		}

		return This;
	}

	public static ChromaticChordMidi from(DiatonicChordMidi c) {
		return null;
	}

	public List<DiatonicChordMidi> toDiatonicChordMidi(boolean outScale) {
		List<Tonality> tonalities;
		if (outScale)
			tonalities = TonalityRetrieval.listFromChordOutScale( this );
		else
			tonalities = TonalityRetrieval.listFromChord( this );

		if ( tonalities.size() == 0 )
			return new ArrayList<>();

		ChromaticChordMidi usingChord = this.clone();
		// usingChord.updateWhatIsItIfNeeded();

		ArrayList<DiatonicChordMidi> out = new ArrayList<>();
		for ( Tonality t : tonalities )
			out.add( new DiatonicChordMidi( t, usingChord ) );

		return out;
	}

	public void compact() {
		for ( int i = 1; i < this.size(); i++ ) {
			int dist = this.get( i - 1 ).dist( this.get( i ) );
			assert dist != 0 : "Se reptite alguna nota " + dist;
			assert dist > 0 : "Las notas no est�n ordenadas " + this.get( i - 1 ) + " "
					+ this.get( i );
			if ( dist > IntervalChromatic.PERFECT_OCTAVE.getSemitones() )
				this.get( i ).shiftOctave( -dist / IntervalChromatic.PERFECT_OCTAVE.getSemitones() );
		}
	}

	@Override
	public ChromaticChordMidi clone() {
		ChromaticChordMidi c = new ChromaticChordMidi();

		for ( ChromaticMidi n : this )
			c.add( n.clone() );

		if (arpegio != null)
			c.arpegio = arpegio.clone();
		c.length = length;

		return c;
	}

	@Override
	public ChromaticChordMidi duplicate() {
		return ChromaticChordMidi.from(this);
	}

	@Override
	public @NonNull ChromaticChordMidi getInv(int i) {
		ChromaticChordMidi chromaticChordMidi = new ChromaticChordMidi();
		chromaticChordMidi.addAll(this);
		chromaticChordMidi.setRootPos(getRootPos());
		chromaticChordMidi.inv(i);
		return chromaticChordMidi;
	}

	@Override
	public @NonNull ChromaticChordMidi getWithRootPos(int i) {
		ChromaticChordMidi chromaticChordMidi = new ChromaticChordMidi();
		chromaticChordMidi.addAll(this);
		chromaticChordMidi.setRootPos(i);
		return chromaticChordMidi;
	}

	@Override
	public ChromaticMidi set(int index, ChromaticMidi element) {
		return null;
	}

	@Override
	@Nonnull
	public ChromaticChordMidi subList(int a, int b) {
		assert b < size();
		ChromaticChordMidi c = new ChromaticChordMidi();
		for ( int i = a; i < b; i++ ) {
			c.add( get( i ).clone() );
		}
		return c;
	}

	// TODO: SE PUEDE PONER COMO DEFAULT
	@Override
	public ChromaticChordMidi removeHigherDuplicates() {
		ChromaticChordMidi out = new ChromaticChordMidi();
		for ( ChromaticMidi n : this ) {
			boolean found = false;
			for ( ChromaticMidi n2 : out ) {
				Chromatic chromaticN2 = Chromatic.from(n2);
				Chromatic chromaticN = Chromatic.from(n);
				if ( chromaticN2.ordinal() == chromaticN.ordinal() ) {
					found = true;
					break;
				}
			}

			if ( !found )
				out.add( n );
		}

		this.clear();
		for ( ChromaticMidi n : out )
			add( n );

		return this;
	}

	public String toString() {
		ChromaticChord ca = ChromaticChord.from( (Collection<? extends PitchChromaticSingle>)this );

		return ca.toString();
	}

	public DiatonicChordMidi getDiatonicChordMidi(Tonality ton) throws TonalityException {
		assert ton != null;
		return new DiatonicChordMidi( ton, this );
	}

	@Override
	@NonNull
	public Quality getQuality() {
		return meta.getQuality();
	}

	@Override
	public int getInversionNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected ChromaticChordMidi newChord() {
		return new ChromaticChordMidi();
	}

	@Override
	public List integerNotationFromRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public void shift(IntervalChromatic intervalChromatic) {
		for (ChromaticMidi chromaticMidi : this)
			chromaticMidi.pitch = chromaticMidi.getPitch().getShift(intervalChromatic);
	}

	@Override
	public void shiftNegative(IntervalChromatic intervalChromatic) {
		for (ChromaticMidi chromaticMidi : this)
			chromaticMidi.pitch = chromaticMidi.getPitch().getShiftNegative(intervalChromatic);
	}

	public static class Builder extends es.danisales.utils.building.Builder<ChromaticChordMidi.Builder, ChromaticChordMidi> {
		private List<Chromatic> fromChromatic;
		private List<ChromaticMidi> fromChromaticMidi;
		private int _octave;
		private int _length;
		private int _velocity;

		private Builder() {

		}

		public ChromaticChordMidi.Builder fromChromatic(@NonNull Chromatic... cs) {
			fromChromatic = Arrays.asList(cs);

			return self();
		}

		public ChromaticChordMidi.Builder fromChromaticMidi(@NonNull ChromaticMidi... cs) {
			fromChromaticMidi = Arrays.asList(cs);

			return self();
		}

		public ChromaticChordMidi.Builder fromChromatic(@NonNull Iterable<Chromatic> cs) {
			fromChromatic = new ArrayList<>();
			for (Chromatic c : cs)
				fromChromatic.add(c);

			return self();
		}

		public ChromaticChordMidi.Builder fromChromaticMidi(@NonNull Iterable<ChromaticMidi> cs) {
			fromChromaticMidi = new ArrayList<>();
			for (ChromaticMidi c : cs)
				fromChromaticMidi.add(c);

			return self();
		}

		public ChromaticChordMidi.Builder octaveBase(int octave) {
			this._octave = octave;

			return self();
		}

		public ChromaticChordMidi.Builder length(int length) {
			this._length = length;

			return self();
		}

		public ChromaticChordMidi.Builder velocity(int velocity) {
			this._velocity = velocity;

			return self();
		}

		@NonNull
		@Override
		public ChromaticChordMidi build() {
			ChromaticChordMidi ns = new ChromaticChordMidi();
			if (fromChromatic != null) {
				for (int i = 0; i < fromChromatic.size(); i++) {
					ChromaticMidi chromaticMidi = ChromaticMidi.builder()
							.pitch(fromChromatic.get(i))
							.build();
					if (i > 0) {
						int lastElementOctave = ns.get(ns.size() - 1).getOctave();
						Chromatic current = fromChromatic.get(i);
						Chromatic previous = fromChromatic.get(i - 1);
						if (current.ordinal() < previous.ordinal())
							chromaticMidi.setOctave(lastElementOctave + 1);
						else
							chromaticMidi.setOctave(lastElementOctave);
					}
					ns.add(chromaticMidi);
				}
			} else if (fromChromaticMidi != null) {

			}

			return ns;
		}


		@Override
		protected ChromaticChordMidi.Builder self() {
			return this;
		}
	}
}
