package Sorting;

import java.util.ArrayList;

public class FloydsAlgorithm {
	
	public int repeatedNumberSignChange(ArrayList<Integer> list) {
		
		//This solution is O(n) time and O(1) space. Yet it requires
		// to mutate the input list. 
		
		if(list.size() <= 1) {
			return -1;
		}
		
		for(int runner = 0; runner < list.size(); runner++) {
			
			if(list.get(Math.abs(list.get(runner))) > 0) {
				list.set(Math.abs(list.get(runner)), -1 * list.get(Math.abs(list.get(runner))));
			}else {
				return Math.abs(list.get(runner));
			}
			
		}
		
		return 0;
	}
	
	
	public int repeatedNumberFloydsTAndHAlgo(ArrayList<Integer> list) {
		
		//This solution is O(n) time O(1) space and does not 
		//require to mutate the input list. 
		
		if(list.size() <= 1) {
			return -1;
		}
		
		int slow = list.get(0);
		int fast = list.get(list.get(0));
		
		  System.out.println("Slow: " + slow);
		  System.out.println("Fast: " + fast);
		
		while(fast != slow) {
			slow = list.get(slow);
			fast = list.get(list.get(fast));
			
			  System.out.println("Slow: " + slow);
			  System.out.println("Fast: " + fast);
		}
		
		slow = 0;
		
		while(fast != slow) {
			slow = list.get(slow);
			fast = list.get(fast);
			
			  System.out.println("Slow: " + slow);
			  System.out.println("Fast: " + fast);
		}
		
		return slow;
	}
	
	
	public static void main(String [] args) {
		ArrayList<Integer> list = new ArrayList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(9);
		
		
		FloydsAlgorithm x = new FloydsAlgorithm();
		System.out.println("Tortise and Hare Repeated Number: " + x.repeatedNumberFloydsTAndHAlgo(list));
		System.out.println("Repeated Number: " + x.repeatedNumberSignChange(list));
		
		
		
	}
	
	
}
