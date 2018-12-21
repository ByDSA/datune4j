package musical;

public class AlterationException extends RuntimeException {
	public AlterationException() {
		super("Error alterando la nota");
	}
}
