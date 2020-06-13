package basicDataStructures;

import java.util.Scanner;

public class SketchPad {
	public static void main(String [] args){
		
		Scanner x = new Scanner(System.in);
		
		int[] items = new int[1];
		
		int index= 0;
		int value = 0;
		
		
		Deque_Linked_List<Integer> tester = new Deque_Linked_List<Integer>();
		
		
		System.out.println("Enter any number to begin");
		int number = x.nextInt();
		
		while(number != -1) {
			System.out.println("Enter a number 0 to add 1 to remove 3 to print out: ");
			number = x.nextInt();
			
			
			if(number == 0) {
				System.out.println("Enter a number: ");
				value = x.nextInt();
				
				tester.addLast(value);

			}
			
			if(number == 1) {
				
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
