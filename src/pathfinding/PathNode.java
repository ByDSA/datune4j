package pathfinding;

import java.util.ArrayList;

class PathNode<N extends Node> {
	ArrayList<N> untestedNodes;
	ArrayList<N> testedNodes;

	N node;

	PathNode(final ArrayList<N> a, final ArrayList<N> c, final N node) {
		untestedNodes = new ArrayList<N>();
		this.node = node;
		for (N n : a) {
			N cl =(N) n.clone();
			untestedNodes.add(cl);
		}
		testedNodes = (ArrayList<N>)c.clone();
	}
}