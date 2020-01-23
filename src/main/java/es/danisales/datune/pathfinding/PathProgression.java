package es.danisales.datune.pathfinding;

import es.danisales.datune.midi.ChordMidi;
import es.danisales.datune.midi.ChordMidiTransformations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class PathProgression extends Path<NodeProgression> {
	private List<List<NodeProgression>> nodes;

	protected final Function<NodeProgression, List<NodeProgression>> sucesores_f = (NodeProgression n) -> {
		return n.getNextNodes();
	};

	protected final BiFunction<NodeProgression, NodeProgression, Float> h_default =
			(NodeProgression current, NodeProgression end) -> (float) ChordMidiTransformations.dist(current.object, end.object);

	public <A extends List<ChordMidi>> PathProgression(A array) {
		super(new NodeProgression(array.get(0)), new NodeProgression(array.get(array.size()-1)));
		assert array.size() > 2;
		nodes = new ArrayList<>();

		for (int i = 1; i < array.size()-1; i++) { // todo
			List<ChordMidi> cs = null;//ChordMidiTransformations.getAllAbsoluteVoicesWithInv(array.get(i));
			List<NodeProgression> ns = new ArrayList<>();
			for (ChordMidi c : cs) {
				ns.add( new NodeProgression(c) );
			}

			if (i == 1)
				ini.setNextNodes(ns);
			else if (i == array.size()-2) {
				List<NodeProgression> ns2 = new ArrayList<NodeProgression>();
				ns2.add(end);
				for (NodeProgression n : ns)
					n.setNextNodes(ns2);
			}

			if (i != 1) {
				List<NodeProgression> ns2 = nodes.get(i-2);
				for (NodeProgression n : ns2)
					n.setNextNodes(ns);
			}

			nodes.add(ns);
		}
	}

	public List<NodeProgression> aStar() {
		return aStar(h_default, g_default, sucesores_f);
	}
}
