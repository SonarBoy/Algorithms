package Structures;

import java.util.Scanner;

public class SketchPad {

	
	
	
	public static void main(String [] args) {
		
		Scanner x = new Scanner(System.in);
		
		int[] items = new int[1];
		
		int index= 0;
		int value = 0;
		
		
		Queue_Array tester = new Queue_Array();
		
		
		
		
		System.out.println("Enter any number to begin");
		int number = x.nextInt();
		
		while(number != -1) {
			System.out.println("Enter a number 0 to add 1 to remove: ");
			number = x.nextInt();
			
			
			if(number == 0) {
				System.out.println("Enter a number: ");
				value = x.nextInt();
				
				
				tester.enqueue(value);
//				if(index == items.length) {
//					
//					items = resize(items,  2 * items.length,index);
//				}
//				
//				
//				items[index] = value;
//				index++;
			}
			
			if(number == 1) {
				System.out.println("Returned number from index " + index + " is " + tester.dequeue());
				
				
				
				
//				if(index == items.length/4) {
//					items = resize(items,items.length/2,index);
//				}
//				
//				
//				index--;
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
