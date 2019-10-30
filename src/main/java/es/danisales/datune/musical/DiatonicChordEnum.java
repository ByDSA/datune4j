package es.danisales.datune.musical;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.midi.AddedException;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

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

	DiatonicChordEnum(Diatonic... cs) {
		assert cs != null;		
		List<Diatonic> notesMutatable = new ArrayList<>();
		notesMutatable.addAll(Arrays.asList(cs));
		notes = Collections.unmodifiableList( notesMutatable );
	}

	@Override
	public List<DiatonicChord> getAllInversions() {
		return null;
	}
	
	

	@Override
	public int getRootPos() {
		return 0;
	}

	@Override
	public Diatonic getRoot() {
		return notes.get( getRootPos() );
	}

	@Override
	public CustomDiatonicChord inv(int n) {
		return new CustomDiatonicChord(this).inv( n );
	}

	@Override
	public DiatonicChordEnum resetRoot() {
		return this;
	}

	@Override
	public CustomDiatonicChord setRootPos(int n) {
		return (CustomDiatonicChord) new CustomDiatonicChord(this).setRootPos( n );
	}

	@Override
	public CustomDiatonicChord add(int pos, Diatonic... ns) throws AddedException {
		return new CustomDiatonicChord(this).add( pos, ns );
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
	public PitchChromaticChord<Chromatic> toChromaticChord(Tonality t) {
		CustomChromaticChord c = new CustomChromaticChord();
		for (Diatonic d : notes) {
			Chromatic chromatic = ChromaticAdapter.from(d, t);
			c.add(chromatic);
		}
		return PitchChromaticChord.of( c );
	}

	@Override
	public CustomDiatonicChord add(Diatonic... cs) throws AddedException {
		return new CustomDiatonicChord(this).add( cs );
	}

	@Override
	public <T extends ChordCommon<Diatonic>> T add(ChordCommon<Diatonic> cs) throws AddedException {
		return new CustomDiatonicChord(this).add( cs );
	}

	@Override
	public DiatonicDegree getDegree() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomDiatonicChord shift(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
