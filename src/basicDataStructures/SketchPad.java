package basicDataStructures;

import java.util.Scanner;

public class SketchPad {
	public static void main(String [] args){
		
		Scanner x = new Scanner(System.in);
		
		int[] items = new int[1];
		
		int index= 0;
		int value = 0;
		
		
		//Deque_Linked_List<Integer> tester = new Deque_Linked_List<Integer>();
		Deque_Array<Integer> tester = new Deque_Array<Integer>();
		
		
		//Kick off the testing.
		System.out.println("Enter any number to begin");
		int number = x.nextInt();
		
		
		while(number != -1) {
			
			System.out.println("Enter a number");
			System.out.println("0 to Add a Value at the begining.");
			System.out.println("1 to Add a Value at the end.");
			System.out.println("3 to print out contents.");
			System.out.println("7 to Remove from the front");
			System.out.println("9 to Remove from the back");
			
			
			System.out.println();
			System.out.println();
			
			
			number = x.nextInt();
			
			
			if(number == 0) {
				System.out.println("Enter a number FRONT: ");
				System.out.println("Current Size: " + tester.size());
				value = x.nextInt();
				
				tester.addFirst(value);

			}
			
			if(number == 1) {
				System.out.println("Enter a number BACK: ");
				System.out.println("Current Size: " + tester.size());
				value = x.nextInt();
				
				tester.addLast(value);

			}
			
			if(number == 8) {
				
				try {
					//System.out.println("Returned Values: " + tester.removeFirst());
					
					//tester.printQueue();
					System.out.println("Returned Value: " + tester.removeLast());
				}
				
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
			
			if(number == 3) {
				tester.printQueue();
			}
			
			if(number == 7) {
				
				
				System.out.println("Item Removed: "+ tester.removeFirst());
			}
			
			if(number == 9) {
				System.out.println("Item Removed: "+ tester.removeLast());
			}
			
			
			
			
			
		}
		
		
		
		
		
	}
	

	
	public static int[] resize(int[] array,int capacity,int currentIndex) {
		
		int[] copy = new int[capacity + 1];
		
		for(int runner = 0; runner < currentIndex; runner++) {
			copy[runner] = array[runner];
		}
		
		for(int runner = 0; runner < copy.length; runner++) {
			System.out.print(copy[runner]+ " ");
		}
		
		System.out.println();
		
		return copy;
		
		
		
		
	}
}
