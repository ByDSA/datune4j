package es.danisales.datune.degrees.octave;

import es.danisales.datune.lang.Namer;
import es.danisales.datune.midi.NoteMidi;
import es.danisales.datune.tonality.ScaleDistance;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import static com.google.common.base.Preconditions.checkArgument;

@SuppressWarnings("WeakerAccess")
public class DiatonicAlt implements CyclicDegree {
	public static final DiatonicAlt C = new DiatonicAlt(Diatonic.C, 0);
	public static final DiatonicAlt D = new DiatonicAlt(Diatonic.D, 0);
	public static final DiatonicAlt E = new DiatonicAlt(Diatonic.E, 0);
	public static final DiatonicAlt F = new DiatonicAlt(Diatonic.F, 0);
	public static final DiatonicAlt G = new DiatonicAlt(Diatonic.G, 0);
	public static final DiatonicAlt A = new DiatonicAlt(Diatonic.A,0);
	public static final DiatonicAlt B = new DiatonicAlt(Diatonic.B,0);

	public static final DiatonicAlt CC = new DiatonicAlt(Diatonic.C, 1);
	public static final DiatonicAlt DD = new DiatonicAlt(Diatonic.D, 1);
	public static final DiatonicAlt EE = new DiatonicAlt(Diatonic.E, 1);
	public static final DiatonicAlt FF = new DiatonicAlt(Diatonic.F, 1);
	public static final DiatonicAlt GG = new DiatonicAlt(Diatonic.G, 1);
	public static final DiatonicAlt AA = new DiatonicAlt(Diatonic.A, 1);
	public static final DiatonicAlt BB = new DiatonicAlt(Diatonic.B,1);

	public static final DiatonicAlt CCC = new DiatonicAlt(Diatonic.C, 2);
	public static final DiatonicAlt DDD = new DiatonicAlt(Diatonic.D, 2);
	public static final DiatonicAlt EEE = new DiatonicAlt(Diatonic.E, 2);
	public static final DiatonicAlt FFF = new DiatonicAlt(Diatonic.F, 2);
	public static final DiatonicAlt GGG = new DiatonicAlt(Diatonic.G,2);
	public static final DiatonicAlt AAA = new DiatonicAlt(Diatonic.A,2);
	public static final DiatonicAlt BBB = new DiatonicAlt(Diatonic.B,2);

	public static final DiatonicAlt Cb = new DiatonicAlt(Diatonic.C, -1);
	public static final DiatonicAlt Db = new DiatonicAlt(Diatonic.D, -1);
	public static final DiatonicAlt Eb = new DiatonicAlt(Diatonic.E, -1);
	public static final DiatonicAlt Fb = new DiatonicAlt(Diatonic.F, -1);
	public static final DiatonicAlt Gb = new DiatonicAlt(Diatonic.G, -1);
	public static final DiatonicAlt Ab = new DiatonicAlt(Diatonic.A, -1);
	public static final DiatonicAlt Bb = new DiatonicAlt(Diatonic.B, -1);
	public static final DiatonicAlt Cbb = new DiatonicAlt(Diatonic.C, -2);
	public static final DiatonicAlt Dbb = new DiatonicAlt(Diatonic.D, -2);
	public static final DiatonicAlt Ebb = new DiatonicAlt(Diatonic.E, -2);
	public static final DiatonicAlt Fbb = new DiatonicAlt(Diatonic.F, -2);
	public static final DiatonicAlt Gbb = new DiatonicAlt(Diatonic.G, -2);
	public static final DiatonicAlt Abb = new DiatonicAlt(Diatonic.A, -2);
	public static final DiatonicAlt Bbb = new DiatonicAlt(Diatonic.B, -2);

	private static final Set<DiatonicAlt> precalculatedDiatonicAlt = new HashSet<>(Arrays.asList(
			C, D, E, F, G, A, B,
			CC, DD, EE, FF, GG, AA, BB,
			CCC, DDD, EEE, FFF, GGG, AAA, BBB,
			Cb, Db, Eb, Fb, Gb, Ab, Bb,
			Cbb, Dbb, Ebb, Fbb, Gbb, Abb, Bbb
	));

	private static final float TOLERANCE = 0.01f;

	private final int semitonesAdded;
	private final float microtonalAdded;
	private final Diatonic diatonicBase;
	private final float alt;

	private DiatonicAlt(Diatonic diatonicBase, float alt) {
		this.diatonicBase = diatonicBase;
		this.alt = alt;
		this.semitonesAdded = (int)alt;
		float diff = alt - this.semitonesAdded;
		this.microtonalAdded = Math.abs(diff) < TOLERANCE ? 0 : diff;
	}

	public static @NonNull DiatonicAlt from(@NonNull Chromatic chromatic, @NonNull Diatonic diatonic) {
		return DiatonicAltAdapter.from(chromatic, diatonic);
	}

	public static @NonNull DiatonicAlt from(@NonNull Diatonic diatonic, float alt) {
		DiatonicAlt ret = getPrecalculated(diatonic, alt);
		if (ret != null)
			return ret;

		DiatonicAlt diatonicAlt = new DiatonicAlt(diatonic, alt);
		precalculatedDiatonicAlt.add(diatonicAlt);
		return diatonicAlt;
	}

	private static @Nullable DiatonicAlt getPrecalculated(Diatonic diatonic, float alt) {
		for (DiatonicAlt d : precalculatedDiatonicAlt) // todo: usar hashmap
			if (d.getDiatonic().equals(diatonic) && d.getSemitonesAdded() + d.getMicrotonalPartAdded() == alt)
				return d;

		return null;
	}

	public static @NonNull DiatonicAlt from(@NonNull Chromatic chromatic) {
		return DiatonicAltAdapter.from(chromatic);
	}

	public static @Nullable DiatonicAlt from(@NonNull Chromatic chromatic, Tonality<DiatonicAlt> tonality) {
		for (DiatonicAlt diatonicAlt : tonality) {
			Chromatic chromatic1 = Chromatic.from(diatonicAlt);
			if (chromatic.equals(chromatic1))
				return diatonicAlt;
		}

		return null;
	}

	public static @NonNull DiatonicAlt from(@NonNull NoteMidi chromaticMidi) {
		return DiatonicAltAdapter.from(chromaticMidi);
	}

	public static @NonNull DiatonicAlt from(@NonNull Diatonic diatonic, @NonNull Tonality<DiatonicAlt> tonality) throws TonalityException {
		for ( DiatonicAlt diatonicAlt : tonality.getNotes() )
			if (diatonicAlt.getDiatonic().equals(diatonic))
				return diatonicAlt;

		throw new TonalityException(diatonic, tonality);
	}

	public static DiatonicAlt from(@NonNull Chromatic chromatic, float microPart, @NonNull CyclicDegree absoluteDegree) {
		return DiatonicAltAdapter.from(chromatic, microPart, absoluteDegree);
	}

	public static DiatonicAlt from(float semis, @NonNull CyclicDegree absoluteDegree) {
		return DiatonicAltAdapter.from(semis, absoluteDegree);
	}

	public int getSemitonesAdded() {
		return semitonesAdded;
	}

	public float getMicrotonalPartAdded() {
		return microtonalAdded;
	}

	public @NonNull DiatonicAlt add(ScaleDistance scaleDistance) {
		return DiatonicAlt.from(diatonicBase, alt + scaleDistance.getMicrotonalSemitones());
	}

	public @NonNull DiatonicAlt sub(ScaleDistance scaleDistance) {
		return DiatonicAlt.from(diatonicBase, alt - scaleDistance.getMicrotonalSemitones());
	}

	public @NonNull DiatonicAlt getAddSemi(int semis) {
		return DiatonicAlt.from(diatonicBase, alt + semis);
	}

	public float getUnsignedAlterations() {
		return Math.abs( getAlterations() );
	}

	public float getAlterations() {
		return getSemitonesAdded() + getMicrotonalPartAdded();
	}

	public @NonNull DiatonicAlt getNextDiatonic() { // todo: used only in tunning (revisar tras hacer tunning)
		return new DiatonicAlt(diatonicBase.getNext(), alt);
	}

	public @NonNull Diatonic getDiatonic() {
		return diatonicBase;
	}

	@Override
	public String toString() {
		return Namer.from(this);
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof DiatonicAlt))
			return false;

		DiatonicAlt casted = (DiatonicAlt)o;

		return this.diatonicBase == casted.diatonicBase
				&& this.semitonesAdded == casted.semitonesAdded
				&& this.microtonalAdded == casted.microtonalAdded;
	}

	@Override
	public int hashCode() {
		return diatonicBase.hashCode() + Float.hashCode(alt);
	}

	@Override
	public DiatonicAlt getNext() {
		return null;
	}

	@Override
	public DiatonicAlt getPrevious() {
		return null;
	}

	@Override
	public DiatonicAlt getShifted(int i) {
		return null;
	}

	@Override
	public int ordinal() {
		return diatonicBase.ordinal();
	}

	public static class EnharmonicRetrieval {
		private EnharmonicRetrieval() {
		}

		public static @NonNull Set<DiatonicAlt> getFromDiatonicAlt(@NonNull DiatonicAlt diatonicAlt, int maxAlterations) {
			checkArgument(maxAlterations >= 0);

			Chromatic chromatic = Chromatic.from(diatonicAlt);
			float microtonal = diatonicAlt.getMicrotonalPartAdded();
			if (microtonal != 0)
				return getFromChromaticMicro(chromatic, microtonal, maxAlterations);
			else
				return getFromChromatic(chromatic, maxAlterations);
		}

		public static @NonNull Set<DiatonicAlt> getFromChromatic(@NonNull Chromatic chromatic, int maxAlt) {
			checkArgument(maxAlt >= 0);

			Set<DiatonicAlt> ret = new HashSet<>();

			for (int alt = -maxAlt; alt <= maxAlt; alt++)
				for (Diatonic diatonic : Diatonic.values()) {
					DiatonicAlt diatonicAlt = DiatonicAlt.from(diatonic, (float) alt);
					Chromatic diatonicAltChromatic = Chromatic.from(diatonicAlt);
					if (diatonicAltChromatic == chromatic && Math.floor(diatonicAlt.getUnsignedAlterations()) <= maxAlt)
						ret.add(diatonicAlt);
				}

			return ret;
		}

		public static @NonNull Set<DiatonicAlt> getFromChromaticMicro(@NonNull Chromatic chromatic, float micro, int maxAlterations) {
			checkArgument(maxAlterations >= 0);

			Set<DiatonicAlt> ret = new HashSet<>();

			for (int alt = -maxAlterations; alt <= maxAlterations; alt++)
				for (Diatonic diatonic : Diatonic.values()) {
					int chromaticAlt = chromatic.ordinal() - Chromatic.from(diatonic).ordinal();
					float semis = chromaticAlt + alt + micro;
					DiatonicAlt diatonicAlt = DiatonicAlt.from(diatonic, semis);
					if (Math.abs(semis - getChromaticSemitones(diatonicAlt)) < 0.1f && Math.floor(diatonicAlt.getUnsignedAlterations()) <= maxAlterations)
						ret.add(diatonicAlt);
				}

			return ret;
		}

		public static float getChromaticSemitones(DiatonicAlt diatonicAlt) {
			Diatonic diatonic = diatonicAlt.getDiatonic();
			Chromatic chromatic = Chromatic.from(diatonic);

			return chromatic.ordinal() + diatonicAlt.getAlterations();
		}

		public static @NonNull DiatonicAlt getMinimizedAlts(@NonNull DiatonicAlt diatonicAlt) {
			Set<DiatonicAlt> set = EnharmonicRetrieval.getFromDiatonicAlt(diatonicAlt, 1);
			Iterator<DiatonicAlt> iterator = set.iterator();
			final AtomicReference<DiatonicAlt> ret = new AtomicReference<>( diatonicAlt );
			iterator.forEachRemaining((DiatonicAlt d) -> {
				float retuAlts = ret.get().getUnsignedAlterations();
				float duAlts = d.getUnsignedAlterations();
				if (duAlts < retuAlts
						|| duAlts < diatonicAlt.getUnsignedAlterations() && duAlts == retuAlts && d.getAlterations() > ret.get().getAlterations())
					ret.set(d);
			});

			return ret.get();
		}
	}
}
