package pathfinding;

import java.util.ArrayList;

import pitch.ChordMidi;

public class NodeProgression extends Node<ChordMidi, NodeProgression> {
	protected ArrayList<NodeProgression> next;
	
	public NodeProgression(ChordMidi o) {
		super(o);
	}

	@Override
	public NodeProgression newNode(ChordMidi c) {
		return new NodeProgression(c);
	}
	
	public void setNextNodes(ArrayList<NodeProgression> a) {
		next = a;
	}
	
	public ArrayList<NodeProgression> getNextNodes() {
		assert next != null;
		return next;
	}
}