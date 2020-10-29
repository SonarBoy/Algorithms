package OddsAndEnds;


public class HPWorkJet implements Printer, Scanner{
	public void print() {
		Scanner.super.scan();
		Printer.super.print();
	}

}
