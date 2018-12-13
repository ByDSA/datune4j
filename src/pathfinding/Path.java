package pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

class Path<N extends Node<?, N>> {
	N ini;
	N end;

	ArrayList<N> openNodes;
	ArrayList<N> closedNodes;

	protected final BiFunction<N, N, Float> g_default = (N ini, N current) -> {
		int i = 0;
		N n = current;
		while(n != ini) {
			i++;
			assert n != n.parent;
			n = n.parent;
			assert n != null;
		}
		return (float)i;
	};

	public Path(N i, N e) {
		ini = i;
		end = e;
	}

	void reset() { }

	public List<N> aStar(BiFunction<N, N, Float> dist_h, BiFunction<N, N, Float> dist_g, Function<N, List<N>> sucesores_f) {
		// Estado inicial
		reset();
		N n;

		// 1
		openNodes = new ArrayList<N>();
		openNodes.add(ini);
		ini.g = 0;
		ini.h = dist_h.apply(ini, end);
		ini.f = ini.g + ini.h;

		// 2
		closedNodes = new ArrayList<N>();

		// 3
		while (openNodes.size () > 0) {
			// 4
			n = openNodes.remove(0);
			closedNodes.add( n );

			// 5: Detectar si se ha llegado al final
			if (n == end) {
				// Formar el camino hacia atrás
				List<N> ret = new ArrayList<N>();
				for (N n_temp = n; n_temp != null; n_temp = n_temp.parent)
					ret.add(n_temp);

				Collections.reverse(ret);

				return ret;
			}

			List<N> sucesores = new ArrayList<N>();
			// 6 : generar sucesores. Inserta todos y luego quita los que son antecedentes de N
			List<N> ss = sucesores_f.apply(n);
			sucesores.addAll(ss);

			// Descarte de sucesores (también se podría poner un IF antes de añadir cada sucesor)
			for (int i = 0; i < sucesores.size(); i++) {
				N s_i = sucesores.get(i);
				if (n.findPredecessor(s_i)) { // Si el sucesor es antecesor de N
					sucesores.remove(i);
					i--;
					break;
				}
				if (false) { // Si el sucesor es un obstáculo
					sucesores.remove(i);
					i--;
				}
			}

			// 7
			for (N s : sucesores) {
				N n_g = (N)s.clone();
				n_g.parent = n;
				float s_g = dist_g.apply(ini, n_g); //  g(sucesor)=g(N)+K(N,sucesor)

				if ( openNodes.contains(s) ) { // Significa que antes ha llegado un camino que ha llegado a él
					if (s.g > s_g) { // Si por el camino actual se ha llegado al nodo con menos distancia que el último acceso
						s.parent = n;
						s.g = s_g;
						s.f = s.g + s.h;
						// Reordenar sucesor por el cambio de 'f'
						openNodes.remove(s);
						addAbiertaSort(s);
					}
				} else if ( closedNodes.contains(s) ) { // Significa que has calculado caminos a partir de S_i y todos estos caminos están mal
					if (s.g > s_g) {
						s.parent = n;
						s.g = s_g;
						s.f = s.g + s.h;
						closedNodes.remove(s);
						addAbiertaSort(s);
					}
				} else {
					s.g = s_g;
					s.h = dist_h.apply(s, end);
					s.f = s.g + s.h;
					s.parent = n;
					addAbiertaSort(s);
				}
			}
		}

		return null;
	}

	void addAbiertaSort(N n) {
		int i = 0;
		for (; i < openNodes.size(); i++)
			if ( n.f < openNodes.get(i).f ) {
				//i--;
				break;
			}
		openNodes.add(i, n);
	}

	boolean isAbiertaSorted(ArrayList<N> abierta) {
		for (int i = 1; i < abierta.size(); i++)
			if (abierta.get(i-1).f > abierta.get(i).f)
				return false;

		return true;
	}
}

