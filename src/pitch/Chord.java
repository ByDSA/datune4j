package pitch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import chromaticchord.CustomChromaticChord;
import midi.AddedException;
import midi.PitchMidiException;

public abstract class Chord<N extends PitchSingle, DistType> implements PitchChordMutable<N, DistType> {
	protected N root;
	protected List<N> notes = new ArrayList();

	public Chord() {
	}

	public Chord(N... cs) throws AddedException {
		add( cs );
	}

	public Chord(Chord<N, DistType> cs) throws AddedException {
		add( cs );
	}

	@Override
	public boolean add(N note) throws AddedException {
		assert note != null;
		notes.add( note );
		resetRootIfNeeded();
		return true;
	}

	protected boolean addList(N note) throws AddedException {
		assert note != null;
		return notes.add( note );
	}

	@Override
	public boolean add(N... cs) throws AddedException {
		if ( cs.length == 0 )
			return false;

		for ( N c : cs )
			addList( c );

		resetRootIfNeeded();

		return true;
	}
	
	@Override
	public <T extends PitchChord<N, DistType>> boolean add(T cs) throws AddedException {
		if ( cs.size() == 0 )
			return false;

		for ( N c : cs )
			addList( c );

		resetRootIfNeeded();

		return true;
	}

	@Override
	public void add(int n, N note) throws AddedException {
		notes.add( n, note );
		resetRootIfNeeded();
	}

	@Override
	public void add(int pos, N... ns) throws AddedException {
		if ( ns.length == 0 )
			return;

		for ( N n : ns )
			notes.add( pos++, n );
		resetRootIfNeeded();
	}

	@Override
	public N remove(int n) {
		N r = notes.remove( n );
		if ( r == root )
			resetRoot();

		return r;
	}

	@Override
	public <T extends PitchChord<N, DistType>> List<T> getAllInversions() {
		List<T> ret = new ArrayList<>();

		ret.add( (T) this.clone() );

		T last = ret.get( 0 );
		for ( int i = 1; i < size(); i++ ) {
			try {
				last = last.inv();
			} catch ( PitchMidiException e ) {
				last = last.inv( -size() + 1 );
			}
			ret.add( last );
		}

		return ret;
	}

	protected void resetRootIfNeeded() {
		if ( root == null || indexOf( root ) == -1 ) {
			resetRoot();
		}
	}

	@Override
	public Chord setRoot(int n) {
		assert n < size();

		root = get( n );

		return this;
	}

	@Override
	public N getRoot() {
		return root;
	}

	@Override
	public int getRootPos() {
		resetRootIfNeeded();
		int pos = this.indexOf( root );
		assert pos != -1;
		return pos;
	}

	@Override
	public boolean equals(Object o) {
		if ( !( o instanceof Chord ) )
			return false;

		Chord c = (Chord) o;
		if ( c.size() != size() )
			return false;

		for ( int i = 0; i < size(); i++ ) {
			if ( !get( i ).equals( c.get( i ) ) )
				return false;
		}

		return root.equals( c.root );
	}
	
	@Override
    public Chord<N, DistType> clone() {
        try {
			return (Chord) super.clone();
		} catch ( CloneNotSupportedException e ) {
			e.printStackTrace();
			return null;
		}
    }
	
	
	/** Show */
	public String toString() {
		return notesToString();
	}

	public String notesToString() {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for ( N n : this ) {
			if ( first ) {
				first = false;
			} else
				sb.append( ", " );
			sb.append( n );
		}

		return sb.toString();
	}

	public String javaNotes() {
		StringBuilder sb = new StringBuilder();
		if (this instanceof CustomChromaticChord)
			sb.append( "new ChromaticChord(" );
		boolean first = true;
		for ( N n : this ) {
			if ( first ) {
				first = false;
			} else
				sb.append( ", " );
			if (this instanceof CustomChromaticChord)
				sb.append( "Chromatic." + n );
		}
		sb.append( " );" );

		return sb.toString();
	}

	public final void showNotes() {
		System.out.println( this.notesToString() );
	}

	public final void show() {
		System.out.println( this );
	}

	@Override
	public boolean addAll(Collection<? extends N> c) {
		return notes.addAll( c );
	}

	@Override
	public boolean addAll(int index, Collection<? extends N> c) {
		return notes.addAll( index, c );
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
	public N get(int index) {
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
	public Iterator<N> iterator() {
		return notes.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return notes.lastIndexOf( o );
	}

	@Override
	public ListIterator<N> listIterator() {
		return notes.listIterator();
	}

	@Override
	public ListIterator<N> listIterator(int index) {
		return notes.listIterator( index );
	}

	@Override
	public boolean remove(Object o) {
		return notes.remove( o );
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
	public N set(int index, N element) {
		return notes.set( index, element );
	}

	@Override
	public int size() {
		return notes.size();
	}

	@Override
	public List<N> subList(int fromIndex, int toIndex) {
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
}
