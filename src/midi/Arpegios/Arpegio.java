package midi.Arpegios;

import java.util.ArrayList;
import java.util.function.Consumer;

import eventsequences.EventSequence;
import midi.FigureLength;
import pitch.ChordMidi;

public class Arpegio implements FigureLength<Arpegio>, Cloneable {
	ArrayList<Node> nodes;
	ChordMidi chord;
	Consumer<Arpegio> build;
	int length;

	public Arpegio() {
		this( (Arpegio a) -> {
		} );
	}

	public Arpegio(Consumer<Arpegio> b) {
		nodes = new ArrayList<Node>();
		build = b;
		length = 0;
	}

	public void setChord(ChordMidi c) {
		chord = c;
		build.accept( this );
	}

	public Arpegio add(int t, int n, int d) {
		Node node = new Node();
		node.time = t;
		node.note = n;
		node.length = d;
		nodes.add( node );

		return this;
	}

	public Arpegio add(int t, int d) {
		for ( int i = 0; i < chord.size(); i++ ) {
			Node node = new Node();
			node.time = t;
			node.note = i;
			node.length = d;

			add( node );
		}

		return this;
	}

	public Arpegio add(Node n) {
		nodes.add( n );

		return this;
	}

	public int getLength() {
		int d = length;
		for ( Node n : nodes )
			d = Math.max( d, n.time + n.length );
		return d;
	}

	public ArrayList<Node> getNodes() {
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
	}

	@Override
	public EventSequence getEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Arpegio clone() {
		Arpegio a = new Arpegio( build );
		a.length = length;
		if ( chord != null )
			a.chord = (ChordMidi) chord;//.duplicate( b );
		for ( Node n : nodes )
			a.nodes.add( n.clone() );

		return a;
	}

	@Override
	public Arpegio setLength(int d) {
		length = d;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if ( !( o instanceof Arpegio ) )
			return false;

		Arpegio a = (Arpegio) o;

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
}
