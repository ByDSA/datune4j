package es.danisales.datune.pathfinding;

import es.danisales.datune.midi.ChordMidi;

import java.util.List;

public class NodeProgression extends Node<ChordMidi, NodeProgression> {
	protected List<NodeProgression> next;
	
	public NodeProgression(ChordMidi o) {
		super(o);
	}

	@Override
	public NodeProgression newNode(ChordMidi c) {
		return new NodeProgression(c);
	}
	
	public void setNextNodes(List<NodeProgression> a) {
		next = a;
	}
	
	public List<NodeProgression> getNextNodes() {
		assert next != null;
		return next;
	}
}