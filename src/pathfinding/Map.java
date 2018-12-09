package pathfinding;

import java.util.ArrayList;

class Map {
	public NodeMap[][] nodes;
	int width, height;

	public Map(int w, int h) {
		this.width = w;
		this.height = h;
		nodes = new NodeMap[this.width][this.height];
		for (int i = 0; i < this.width; i++)
			for (int j = 0; j < this.height; j++)
				nodes[i][j] = new NodeMap(new PVector(i, j));
	}


	boolean contains(ArrayList<Node> l, Node c) {
		for (Node n : l)
			if (n.equals(c))
				return true;
		return false;
	}

	public void addWall(int i, int j) {
		NodeMap n = nodes[i][j];
		n.type = NodeMap.NODE_WALL;
	}

	public void removeWall(int i, int j) {
		NodeMap n = nodes[i][j];
		n.type = NodeMap.NODE_NORMAL;
	}
}


