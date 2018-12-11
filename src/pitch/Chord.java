package pitch;

import java.util.ArrayList;
import java.util.List;

import chromaticchord.CustomChromaticChord;
import midi.AddedException;
import midi.PitchMidiException;

abstract public class Chord<N extends PitchSingle, DistType>
implements Cloneable, PitchChord<N, DistType>, List<N> {
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

	public boolean add(N note) throws AddedException {
		assert note != null;
		notes.add( note );
		resetRootIfNeeded();
		return true;
	}

	protected boolean addNoReset(N note) throws AddedException {
		assert note != null;
		return notes.add( note );
	}

	public boolean add(N... cs) throws AddedException {
		if ( cs.length == 0 )
			return false;

		for ( N c : cs )
			addNoReset( c );

		resetRootIfNeeded();

		return true;
	}
	
	public boolean add(PitchChord<N, DistType> cs) throws AddedException {
		if ( cs.size() == 0 )
			return false;

		for ( N c : cs )
			addNoReset( c );

		resetRootIfNeeded();

		return true;
	}

	@Override
	public void add(int n, N note) throws AddedException {
		notes.add( n, note );
		resetRootIfNeeded();
	}

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

	public <T extends Chord<N, DistType>> ArrayList<T> getAllInversions() {
		ArrayList<T> ret = new ArrayList<>();

		ret.add( (T) this.clone() );

		T last = ret.get( 0 );
		for ( int i = 1; i < size(); i++ ) {
			try {
				last = last.clone().inv();
			} catch ( PitchMidiException e ) {
				last = last.clone().inv( -size() + 1 );
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

	public <T extends Chord<? extends N, ? extends DistType>> T inv() {
		return inv( 1 );
	}

	public <T extends Chord<? extends N, ? extends DistType>> T inv(int n) {
		if ( size() < 2 || n == 0 )
			return (T) this;

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

		return (T) this;
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
}
