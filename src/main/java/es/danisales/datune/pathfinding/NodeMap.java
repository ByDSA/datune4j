package es.danisales.datune.pathfinding;

public class NodeMap  extends Node<PVector, NodeMap> {
	public final static int NODE_NORMAL = 0;
	public final static int NODE_WALL = 1;
	
	public int type;
	
	public NodeMap(PVector o) {
		super(o);
		
		type = NODE_NORMAL;
	}

	@Override
	public NodeMap newNode(PVector c) {
		return new NodeMap(c);
	}

	public boolean isEmpty() {
		return type != NODE_WALL;
	}
}