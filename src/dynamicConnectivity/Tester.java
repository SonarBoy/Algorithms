package dynamicConnectivity;

import java.util.Scanner;

public class Tester {
	public static void main(String [] args) {
		//Connector sample = new Connector(10);
		QuickConnector sample = new QuickConnector(10);
		
		int max = 9;
		int min = 0;
		int range = max - min + 1; 
		
		
		int firstRandom = 0;
		int secondRandom = 0;
		
		
		for(int runner = 0; runner < 6; runner++) {
			
			if(firstRandom != secondRandom) {
				
				firstRandom = (int)(Math.random() * range) + min;
				secondRandom = (int)(Math.random() * range) + min;
				
				System.out.println("First Index: " + firstRandom + " Second Index: " + secondRandom);
				System.out.println();
				sample.union(firstRandom, secondRandom);
				
				
				
			}else {
				firstRandom = (int)(Math.random() * range) + min;
				secondRandom = (int)(Math.random() * range) + min;
			}
			
		}
		
		Scanner x = new Scanner(System.in);
		x.nextInt();
		sample.printOut();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		sample.printOutSizes();
		x.close();
	
	}
}
