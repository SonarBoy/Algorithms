package elementary;

import java.util.Iterator;

public class TreeTesting {

	public static void main(String[] args) {
		
		BST<String, Integer> x = new BST<String, Integer>();
		
		x.put("F", (int)"F".charAt(0));
		x.put("B", (int)"B".charAt(0));
		x.put("A", (int)"A".charAt(0));
		x.put("D", (int)"D".charAt(0));
		x.put("S", (int)"S".charAt(0));
		x.put("Q", (int)"Q".charAt(0));
		x.put("Z", (int)"Z".charAt(0));
		
		
		System.out.println((int)"F".charAt(0));
		
		System.out.println(x.get("D"));
		
		x.put("C", (int)"C".charAt(0));
		//x.put("T", (int)"D".charAt(0));
		
		x.delete("A");
		x.delete("D");
		x.delete("S");
		
		
		
		

	}

}

