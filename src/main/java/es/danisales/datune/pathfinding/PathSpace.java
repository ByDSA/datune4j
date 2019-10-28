package es.danisales.datune.pathfinding;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class PathSpace extends Path<NodeMap> {
	Map map;

	protected final Function<NodeMap, List<NodeMap>> sucesores_f = (NodeMap n) -> {
		ArrayList<NodeMap> sucesores = new ArrayList<>();
		if ( n.object.x+1 < map.width ) {
			NodeMap nm = map.nodes[n.object.x+1][n.object.y];
			if (nm.isEmpty())
				sucesores.add(nm);
		}
		
		if ( n.object.x-1 >= 0 ) {
			NodeMap nm = map.nodes[n.object.x-1][n.object.y];
			if (nm.isEmpty())
				sucesores.add(nm);
		}
		
		if ( n.object.y+1 < map.height ) {
			NodeMap nm = map.nodes[n.object.x][n.object.y+1];
			if (nm.isEmpty())
				sucesores.add(nm);
		}
		
		if ( n.object.y-1 >= 0 ) {
			NodeMap nm = map.nodes[n.object.x][n.object.y-1];
			if (nm.isEmpty())
				sucesores.add(nm);
		}

		return sucesores;
	};

	protected final BiFunction<NodeMap, NodeMap, Float> h_default = (NodeMap current, NodeMap end) -> {
		return (float)Math.abs(end.object.x-current.object.x) + Math.abs(end.object.y-current.object.y);
	};

	public PathSpace(Map m, PVector i, PVector e) {
		super(m.nodes[i.x][i.y], m.nodes[e.x][e.y]);
		map = m;
	}

	@Override
	public void reset() {
		super.reset();
		for (int i = 0; i < map.width; i++)
			for (int j = 0; j < map.height; j++) {
				map.nodes[i][j].parent = null;
			}
	}


	public List<NodeMap> aStar() {
		return aStar(h_default, g_default, sucesores_f);
	}
}
