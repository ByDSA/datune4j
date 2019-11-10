package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.AddedException;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.Chord;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import javax.annotation.Nonnull;
import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

public enum DiatonicChordEnum implements DiatonicChord {
	TRIAD(Diatonic.C, Diatonic.E, Diatonic.G),
	THIRD(Diatonic.C, Diatonic.E),
	SUS2(Diatonic.C, Diatonic.D, Diatonic.G),
	SUS2_O5(Diatonic.C, Diatonic.D),
	SUS4(Diatonic.C, Diatonic.F, Diatonic.G),
	SUS4_O5(Diatonic.C, Diatonic.F),
	SIXTH(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.A),
	SIXTH_O5(Diatonic.C, Diatonic.E, Diatonic.A),
	SEVENTH(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.B),
	SEVENTH_O3(Diatonic.C, Diatonic.G, Diatonic.B),
	SEVENTH_O5(Diatonic.C, Diatonic.E, Diatonic.B),
	NINTH(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.B, Diatonic.D),
	NINTH_O7(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.D),
	NINTH_O3_O7(Diatonic.C, Diatonic.G, Diatonic.D),
	ELEVENTH(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.B, Diatonic.D, Diatonic.F),
	THIRTEENTH(Diatonic.C, Diatonic.E, Diatonic.G, Diatonic.B, Diatonic.D, Diatonic.F, Diatonic.A);

	private final List<Diatonic> notes;

	DiatonicChordEnum(@NonNull Diatonic... diatonics) {
		Objects.requireNonNull(diatonics);
		List<Diatonic> notesMutatable = new ArrayList<>(Arrays.asList(diatonics));
		notes = Collections.unmodifiableList( notesMutatable );
	}

	@Override
	public List<DiatonicChord> getAllInversions() {
			List<DiatonicChord> ret = new ArrayList<>();

			ret.add( this );

			DiatonicChord last = this;
			for ( int i = 0; i < size(); i++ ) {
				ret.add( last );
				last = last.getInv();
			}

			return ret;
	}

	@Override
	public int getRootPos() {
		return 0;
	}

	@Override
	public Diatonic getRoot() {
		return notes.get( getRootPos() );
	}

	@Nullable
	@Override
	public DiatonicChord getOver(@Nonnull Diatonic diatonic) { // todo
		DiatonicChord diatonicChord = DiatonicChord.from(this);
		if ( firstDiatonicIs(diatonic) )
			return this;
		for (int i = 0; i < size(); i++) {
			diatonicChord = diatonicChord.getInv();
			if ( firstDiatonicIs(diatonic) )
				return this;
		}

		return null;
	}

	private boolean firstDiatonicIs(Diatonic diatonic) {
		return get(0) == diatonic;
	}

	@Override
	public DiatonicChord getInv(int n) {
		DiatonicChord copy = DiatonicChord.from(this);
		for (int i = 0; i < n; i++)
			copy = copy.getInv();

		return copy;
	}

	@Override
	public boolean add(Diatonic e) {
		return notes.add( e );
	}

	@Override
	public void add(int index, Diatonic element) {
		notes.add( index, element );
	}

	@Override
	public boolean addAll(@NonNull Collection<? extends Diatonic> c) {
		return notes.addAll( c );
	}

	@Override
	public boolean addAll(int index, @NonNull Collection<? extends Diatonic> c) {
		return notes.addAll(c);
	}

	@Override
	public void clear() {
		notes.clear();
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
		return notes.remove( o );
	}

	@Override
	public Diatonic remove(int index) {
		return notes.remove( index );
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return notes.removeAll( c );
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return notes.retainAll( c );
	}

	@Override
	public Diatonic set(int index, Diatonic element) {
		return notes.set( index, element );
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

	@Override
	public <T> T[] toArray(@NonNull T[] a) {
		return notes.toArray( a );
	}

	@Override
	public DiatonicChord getShifted(IntervalDiatonic i) { // TODO
		return null;
	}

	public static DiatonicChord add(DiatonicChordEnum diatonicChordEnum, Diatonic... cs) throws AddedException {
		DiatonicChord diatonicChord = DiatonicChord.from(diatonicChordEnum);
		diatonicChord.addAll( Arrays.asList(cs) );
		return diatonicChord;
	}

	public static DiatonicChord add(DiatonicChordEnum diatonicChordEnum, ChordCommon<Diatonic> cs) throws AddedException {
		DiatonicChord diatonicChord = DiatonicChord.from(diatonicChordEnum);
		diatonicChord.addAll( cs );

		return diatonicChord;
	}

	@Override
	public DiatonicDegree getDegree() {
		// TODO Auto-generated method stub
		return null;
	}
}
