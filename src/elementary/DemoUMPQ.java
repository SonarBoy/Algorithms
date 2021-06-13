package elementary;

public class DemoUMPQ {
	public static void main(String [] args) {
		UnorderedMaxPQ<Integer> x = new UnorderedMaxPQ<Integer>(10);
		
		x.insert(1);
		x.insert(2);
		x.insert(3);
		x.insert(4);
		x.insert(5);
		x.insert(6);
		
		
		while(!x.isEmpty()) {
			System.out.println(x.delMax());
		}
		
		
		MaxPQ<String> y = new MaxPQ<String>(12);
		y.insert("T");
		y.insert("P");
		y.insert("R");
		y.insert("N");
		y.insert("H");
		y.insert("O");
		y.insert("A");
		y.insert("E");
		y.insert("I");
		y.insert("G");
		
		
		
		y.printOut();
		System.out.println();
		
		y.insert("S");
		
		y.printOut();
		System.out.println();
		
		y.delMax();
		
		y.printOut();
		System.out.println();
		
		y.delMax();
		
		y.printOut();
		System.out.println();
		
		y.insert("S");
		
		y.printOut();
		System.out.println();
		
		
		
//		while(!y.isEmpty()) {
//			System.out.println(y.delMax());
//		}
	}

}
