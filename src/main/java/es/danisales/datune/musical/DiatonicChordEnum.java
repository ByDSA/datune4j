package es.danisales.datune.musical;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.midi.AddedException;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.tonality.Tonality;

public enum DiatonicChordEnum implements DiatonicChord {
	TRIAD(Diatonic.I, Diatonic.III, Diatonic.V),
	THIRD(Diatonic.I, Diatonic.III),
	SUS2(Diatonic.I, Diatonic.II, Diatonic.V),
	SUS2_O5(Diatonic.I, Diatonic.II),
	SUS4(Diatonic.I, Diatonic.IV, Diatonic.V),
	SUS4_O5(Diatonic.I, Diatonic.IV),
	SIXTH(Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.VI),
	SIXTH_O5(Diatonic.I, Diatonic.III, Diatonic.VI),
	SEVENTH(Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.VII),
	SEVENTH_O3(Diatonic.I, Diatonic.V, Diatonic.VII),
	SEVENTH_O5(Diatonic.I, Diatonic.III, Diatonic.VII),
	NINTH(Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.VII, Diatonic.II),
	NINTH_O7(Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.II),
	NINTH_O3_O7(Diatonic.I, Diatonic.V, Diatonic.II),
	ELEVENTH(Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.VII, Diatonic.II, Diatonic.IV),
	THIRTEENTH(Diatonic.I, Diatonic.III, Diatonic.V, Diatonic.VII, Diatonic.II, Diatonic.IV, Diatonic.VI);

	private final List<Diatonic> notes;

	DiatonicChordEnum(Diatonic... cs) {
		assert cs != null;		
		List<Diatonic> notesMutatable = new ArrayList<>();
		for (Diatonic c : cs)
			notesMutatable.add( c );
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
	public boolean addAll(Collection<? extends Diatonic> c) {
		return notes.addAll( c );
	}

	@Override
	public boolean addAll(int index, Collection<? extends Diatonic> c) {
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
	public boolean containsAll(Collection<?> c) {
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
	public <T> T[] toArray(T[] a) {
		return notes.toArray( a );
	}

	@Override
	public PitchChromaticChord<Chromatic> toChromaticChord(Tonality t) {
		CustomChromaticChord c = new CustomChromaticChord();
		for (Diatonic d : notes)
			c.add( d.toChromatic( t ) );
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
