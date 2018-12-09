package pitch;

import java.util.ArrayList;

import midi.AddedException;
import midi.PitchException;
import midi.Events.Duplicable;

abstract public class Chord<N extends PitchSingle<N>, This extends Chord<N, This, DistType>, DistType>
		extends ArrayList<N> implements Duplicable<This>, PitchChord<N, This, DistType> {
	protected N root;

	public Chord() {
	}

	public Chord(N... cs) throws AddedException {
		add( cs );
	}

	public Chord(Chord<N, ?, DistType> cs) throws AddedException {
		add( cs );
	}

	public boolean add(N note) throws AddedException {
		assert note != null;
		super.add( note );
		resetRootIfNeeded();
		return true;
	}

	protected boolean addNoReset(N note) throws AddedException {
		assert note != null;
		return super.add( note );
	}

	public boolean add(N... cs) throws AddedException {
		if ( cs.length == 0 )
			return false;

		for ( N c : cs )
			addNoReset( c );

		resetRootIfNeeded();

		return true;
	}

	public boolean add(Chord<N, ?, DistType> cs) throws AddedException {
		if ( cs.size() == 0 )
			return false;

		for ( N c : cs )
			addNoReset( c );

		resetRootIfNeeded();

		return true;
	}

	public void add(int n, N note) throws AddedException {
		super.add( n, note );
		resetRootIfNeeded();
	}

	public void add(int pos, N... ns) throws AddedException {
		if ( ns.length == 0 )
			return;

		for ( N n : ns )
			super.add( pos++, n );
		resetRootIfNeeded();
	}

	public N remove(int n) {
		N r = super.remove( n );
		if ( r == root )
			resetRoot();

		return r;
	}

	public ArrayList<This> getAllInversions() {
		ArrayList<This> ret = new ArrayList<>();

		ret.add( this.duplicate( true ) );

		This last = ret.get( 0 );
		for ( int i = 1; i < size(); i++ ) {
			try {
				last = last.duplicate( true ).inv();
			} catch ( PitchException e ) {
				last = last.duplicate( true ).inv( -size() + 1 );
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

	public boolean resetRoot() {
		if ( size() == 0 )
			return false;

		setRoot( 0 );

		return true;
	}

	public boolean setRoot(int n) {
		assert n < size();

		root = get( n );

		return true;
	}

	public N getRoot() {
		return root;
	}

	public int getRootPos() {
		resetRootIfNeeded();
		int pos = this.indexOf( root );
		assert pos != -1;
		return pos;
	}

	public int getInversionNumber() {
		return ( size() - getRootPos() ) % size();
	}

	final public This inv() {
		return inv( 1 );
	}

	public This inv(int n) {
		if ( size() < 2 || n == 0 )
			return (This) this;

		for ( int i = 0; i < n; i++ ) {
			boolean updateRoot = getRootPos() == 0;
			add( remove( 0 ) );

			if ( updateRoot )
				setRoot( size() - 1 );
		}

		if ( n < 0 ) {
			int lastIndex = size() - 1;

			for ( int i = 0; i > n; i-- ) {
				boolean updateRoot = getRootPos() == lastIndex;
				add( 0, remove( lastIndex ) );

				if ( updateRoot )
					setRoot( 0 );
			}
		}

		return (This) this;
	}

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

	public final void showNotes() {
		System.out.println( this.notesToString() );
	}

	public final void show() {
		System.out.println( this );
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
}
