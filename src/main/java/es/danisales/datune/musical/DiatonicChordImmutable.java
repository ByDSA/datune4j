package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.midi.AddedException;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.PitchDiatonicSingle;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

enum DiatonicChordImmutable implements DiatonicChordInterface, ChordImmutable<Diatonic> {
    C_TRIAD(Diatonic.C, Diatonic.E, Diatonic.G),
    C_THIRD(Diatonic.C, Diatonic.E),
    C_SUS2(Diatonic.C, Diatonic.D, Diatonic.G),
    C_SUS2_O5(Diatonic.C, Diatonic.D),
    C_SUS4(Diatonic.C, Diatonic.F, Diatonic.G),
    C_SUS4_O5(Diatonic.C, Diatonic.F),
    C_SIXTH(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.A),
    C_SIXTH_O5(Diatonic.C, Diatonic.E, Diatonic.A),
    C_SEVENTH(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.B),
    C_SEVENTH_O3(Diatonic.C, Diatonic.G, Diatonic.B),
    C_SEVENTH_O5(Diatonic.C, Diatonic.E, Diatonic.B),
    C_NINTH(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.B, Diatonic.D),
    C_NINTH_O7(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.D),
    C_NINTH_O3_O7(Diatonic.C, Diatonic.G, Diatonic.D),
    C_ELEVENTH(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.B, Diatonic.D, Diatonic.F),
    C_THIRTEENTH(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.B, Diatonic.D, Diatonic.F, Diatonic.A);

	private final List<Diatonic> notes;

	DiatonicChordImmutable(@NonNull Diatonic... diatonics) {
		Objects.requireNonNull(diatonics);
		List<Diatonic> notesMutatable = new ArrayList<>(Arrays.asList(diatonics));
		notes = Collections.unmodifiableList( notesMutatable );
	}

	public static @Nullable DiatonicChordImmutable from(@NonNull Collection<? extends PitchDiatonicSingle> diatonicCollection) {
		for (DiatonicChordImmutable diatonicChord : DiatonicChordImmutable.values())
			if (diatonicChord.sameDiatonicsAs(diatonicCollection))
				return diatonicChord;

		return null;
	}

	private boolean sameDiatonicsAs(Collection<? extends PitchDiatonicSingle> diatonicCollection) {
		if (notes.size() != diatonicCollection.size())
			return false;

		int i = 0;
		for (PitchDiatonicSingle pitchDiatonicSingle : diatonicCollection) {
            if (notes.get(i) != pitchDiatonicSingle)
				return false;
			i++;
		}

		return true;
	}

	@Override
	public int getRootIndex() {
		return 0;
	}

	@Override
	public @NonNull Diatonic getRoot() {
		return notes.get(getRootIndex());
	}

	@Override
	public boolean add(Diatonic e) {
		excep();
		return false;
	}

	@Override
	public void add(int index, Diatonic element) {
		excep();
	}

	@Override
	public boolean addAll(@NonNull Collection<? extends Diatonic> c) {
		excep();
		return false;
	}

	@Override
	public boolean addAll(int index, @NonNull Collection<? extends Diatonic> c) {
		excep();
		return false;
	}

	@Override
	public void clear() {
		excep();
	}

	@Override
	public boolean contains(Object o) {
		return notes.contains( o );
	}

	@Override
	public boolean containsAll(@NonNull Collection<?> c) {
		return notes.containsAll( c );
	}

	@Override
	public Diatonic get(int index) {
		return notes.get( index );
	}

	@Override
	public int indexOf(Object o) {
		return notes.indexOf( o );
	}

	@Override
	public boolean isEmpty() {
		return notes.isEmpty();
	}

	@Override
	public Iterator<Diatonic> iterator() {
		return notes.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return notes.lastIndexOf( o );
	}

	@Override
	public ListIterator<Diatonic> listIterator() {
		return notes.listIterator();
	}

	@Override
	public ListIterator<Diatonic> listIterator(int index) {
		return notes.listIterator( index );
	}

	@Override
	public boolean remove(Object o) {
		excep();
		return false;
	}

	private void excep() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Diatonic remove(int index) {
		excep();
		return null;
	}

	@Override
	public boolean removeAll(@NonNull Collection<?> c) {
		excep();
		return false;
	}

	@Override
	public boolean retainAll(@NonNull Collection<?> c) {
		excep();
		return false;
	}

	@Override
	public Diatonic set(int index, Diatonic element) {
		excep();
		return null;
	}

	@Override
	public int size() {
		return notes.size();
	}

	@Override
	public List<Diatonic> subList(int fromIndex, int toIndex) {
		return notes.subList( fromIndex, toIndex );
	}

	@Override
	public Object[] toArray() {
		return notes.toArray();
	}

	@SuppressWarnings("SuspiciousToArrayCall")
	@Override
	public <T> T[] toArray(@NonNull T[] a) {
		return notes.toArray( a );
	}


	public static DiatonicChord add(DiatonicChordImmutable diatonicChordEnum, Diatonic... cs) throws AddedException {
		DiatonicChord diatonicChord = DiatonicChord.from(diatonicChordEnum);
		diatonicChord.addAll( Arrays.asList(cs) );
		return diatonicChord;
	}

	public static DiatonicChord add(DiatonicChordImmutable diatonicChordEnum, ChordCommon<Diatonic> cs) throws AddedException {
		DiatonicChord diatonicChord = DiatonicChord.from(diatonicChordEnum);
		diatonicChord.addAll( cs );

		return diatonicChord;
	}
}
