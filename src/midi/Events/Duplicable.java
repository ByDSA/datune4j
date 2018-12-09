package midi.Events;

public interface Duplicable<This> {
	public default This duplicate() {
		return duplicate(false);
	}
	
	public This duplicate(boolean b);
}
