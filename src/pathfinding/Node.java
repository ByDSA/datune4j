package pathfinding;
	
abstract class Node<O, This extends Node<O, This>> {
	float g; // distancia mínima desde el origen hasta el nodo (se actualiza cuando se encuentra un camino más corto)
	float h; // distancia desde el nodo hasta el destino
	float f; // g + h
	O object;
	This parent;

	Node(O c) {
		object = c;
		parent = null;
		g = 0;
		h = 0;
		f = 0;
	}

	// Devuelve si el nodo desde el que se llama tiene el predecesor 'n'
	boolean findPredecessor(This n) {
		for (This n_temp = n.parent; n_temp != null; n_temp = n_temp.parent) {
			if (n == n_temp)
				return true;
		}

		return false;
	}
	
	abstract public This newNode(O c);

	public This clone() {
		This n = newNode(object);
		n.g = g;
		n.h = h;
		n.f = f;
		n.parent = n;

		return n;
	}
	
	public String toString() {
		return object.toString();
	}
}