package es.danisales.datune.pathfinding;

public class PVector {
	public int x, y;
	
	public PVector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public PVector get() {
		try {
			return (PVector) this.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}
