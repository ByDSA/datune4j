package es.danisales.datune.midi.arpegios;

import es.danisales.datune.midi.ChordMidi;
import es.danisales.datune.midi.Durable;
import es.danisales.utils.HashingUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Arpeggio implements Durable, Cloneable {
    private List<Node> nodes;
	ChordMidi chord;
	private Consumer<Arpeggio> build;
	private int length;

	public Arpeggio() {
		this((Arpeggio a) -> {
		} );
	}

	public Arpeggio(Consumer<Arpeggio> b) {
		nodes = new ArrayList<Node>();
		build = b;
		length = 0;
	}

	public void setChord(ChordMidi c) {
		chord = c;
		build.accept( this );
	}

	public Arpeggio add(int t, int n, int d) {
		Node node = new Node();
		node.time = t;
		node.note = n;
		node.length = d;
		nodes.add( node );

		return this;
	}

	public Arpeggio add(int t, int d) {
		for ( int i = 0; i < chord.size(); i++ ) {
			Node node = new Node();
			node.time = t;
			node.note = i;
			node.length = d;

			add( node );
		}

		return this;
	}

	public Arpeggio add(Node n) {
		nodes.add( n );

		return this;
	}

	public int getLength() {
		int d = length;
		for ( Node n : nodes )
			d = Math.max( d, n.time + n.length );
		return d;
	}

    public List<Node> getNodes() {
		return nodes;
	}

	public class Node implements Cloneable {
		public int	note;
		public int	time;
		public int	length;

		@Override
		public boolean equals(Object o) {
			if ( !( o instanceof Node ) )
				return false;

			Node a = (Node) o;

			return note == a.note && time == a.time && length == a.length;
		}

		@Override
		protected Node clone() {
			Node n = new Node();
			n.note = note;
			n.time = time;
			n.length = length;

			return n;
		}

        @Override
        public int hashCode() {
            return HashingUtils.from(0, note, time, length);
        }
    }

	public Arpeggio clone() {
		Arpeggio a = new Arpeggio(build);
		a.length = length;
		if ( chord != null )
            a.chord = chord;//.duplicate( b );
		for ( Node n : nodes )
			a.nodes.add( n.clone() );

		return a;
	}

	@Override
	public void setLength(int d) {
		length = d;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Arpeggio))
			return false;

		Arpeggio a = (Arpeggio) o;

		if ( length != a.length )
			return false;

		if ( chord.size() != a.chord.size() )
			return false;

		for ( int i = 0; i < chord.size(); i++ ) {
			if ( !chord.get( i ).equals( a.chord.get( i ) ) )
				return false;
		}

		if ( nodes.size() != a.nodes.size() )
			return false;

		for ( int i = 0; i < nodes.size(); i++ )
			if ( !nodes.get( i ).equals( a.nodes.get( i ) ) )
				return false;

		return true;
	}

	public ChordMidi getChord() {
		return chord;
	}

    @Override
    public int hashCode() {
        return nodes.hashCode() + 31 * (chord.hashCode() + 37 * (build.hashCode() + 41 * Integer.hashCode(length)));
    }
}
