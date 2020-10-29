package OddsAndEnds;

public interface Printer {
	default void print() {
		System.out.println("I can print!");
	}
}
