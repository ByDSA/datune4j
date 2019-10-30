package es.danisales.datune.pitch;

import java.util.ArrayList;
import java.util.List;

import es.danisales.datune.midi.AddedException;
import es.danisales.datune.midi.PitchMidiException;
import es.danisales.datune.musical.CustomChromaticChord.ImpossibleChord;

public abstract class Chord<N extends SymbolicPitch> extends ArrayList<N> implements ChordMutableInterface<N> {
	protected int root = -1;
/*
	public Chord(N... cs) {
		for (N n : cs)
			super.addSemi( n );
		resetRoot();
	}

	public <C extends Chord<N>> Chord(C cs) {
		addAll( cs );
		resetRoot();
	}*/

	@Override
	public boolean add(N note) {
		assert note != null;
		super.add( note );
		resetRootIfNeeded();
		return true;
	}
	
	public Chord<N> over(N c) throws ImpossibleChord {
		Chord<N> dup = clone();
		for(int i = 0; i < size(); i++) {
			if ( get(0).equals( c ) )
				return dup;
			if (i < size()-1)
				dup.inv();
		}

		throw new ImpossibleChord();
	}

	@Override
	public <T extends ChordCommon<N>> T add(N... cs) {
		if ( cs.length == 0 )
			return (T)this;

		for ( SymbolicPitch c : cs )
			super.add( (N)c );

		resetRootIfNeeded();

		return (T)this;
	}

	@Override
	public <T extends ChordCommon<N>> T add(ChordCommon<N> cs) {
		if ( cs.size() == 0 )
			return (T)this;

		for ( N c : cs )
			super.add( c );

		resetRootIfNeeded();

		return (T)this;
	}

	@Override
	public void add(int n, N note) throws AddedException {
		super.add( n, note );
		resetRootIfNeeded();
	}

	@Override
	public <T extends ChordCommon<N>> T add(int pos, N... ns) {
		if ( ns.length == 0 )
			return (T)this;

		for ( SymbolicPitch n : ns )
			super.add( pos++,(N) n );
		resetRootIfNeeded();

		return (T)this;
	}

	@Override
	public N remove(int n) {
		N root = getRoot();
		N r = super.remove( n );
		if ( r == root )
			resetRoot();

		return r;
	}

	@Override
	public <T extends ChordCommon<N>> List<T> getAllInversions() {
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
		if ( root == -1 || root >= size() ) {
			resetRoot();
		}
	}

	@Override
	public Chord setRootPos(int n) {
		if ( n >= size())
			throw new ArrayIndexOutOfBoundsException();

		root = n;

		return this;
	}

	@Override
	public N getRoot() {
		return get(root);
	}

	@Override
	public int getRootPos() {
		resetRootIfNeeded();
		return root;
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

		return getRoot().equals( c.getRoot() );
	}

	@Override
	public Chord<N> clone() {
		return (Chord) super.clone();
	}

	/** Show */
	public String toString() {
		return notesToString();
	}

	//TODO: quitar
	public String javaNotes() {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for ( N n : this ) {
			if ( first ) {
				first = false;
			} else
				sb.append( ", " );
		}
		sb.append( " );" );

		return sb.toString();
	}

	// TODO: quitar
	public final void showNotes() {
		System.out.println( this.notesToString() );
	}

	// TODO: quitar
	public final void show() {
		System.out.println( this );
	}
}
