package dynamicConnectivity;


import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class WQUScratchPad {
	
	public static void main(String [] args) {
		int[] array = new int[10];
			
		
		for(int runner = 0;runner < array.length; runner++) {
			array[runner] = runner;
		}
		
		
		WeightedQuickUnionUF unionTest = new WeightedQuickUnionUF(array.length);
		
		unionTest.union(0, 5);
		unionTest.union(5, 7);
		unionTest.union(5, 9);
		
		
		unionTest.union(2, 4);
		unionTest.union(4, 3);
		
		
		System.out.println("Finding 5: " + unionTest.find(5));
		System.out.println("Finding 7: " + unionTest.find(7));
		System.out.println("Finding 9: " + unionTest.find(9));
		
		System.out.println("Finding 4: " + unionTest.find(4));
		System.out.println("Finding 3: " + unionTest.find(3));
		
		System.out.println("Number of Groups: " + unionTest.count());
		
//		for(int x:array) {
//		System.out.println(x);
//		}
		
		
		unionTest = null;
		unionTest = new WeightedQuickUnionUF((5*5));
		
		int [][] board = new int[5][5];
		
		int counter = 0;
		
		for(int runner = 0; runner < board.length;runner++) {
			for(int runnerTwo = 0; runnerTwo < board.length; runnerTwo++) {
				board[runner][runnerTwo] = counter++;
			}
		}
		
		
		
		
		for(int runner = 0; runner < board.length; runner++) {
			
			for(int secondRunner = 0; secondRunner < board.length; secondRunner++) {
				
				System.out.print(board[runner][secondRunner] + " ");
				
			}
			
			System.out.println();
		}
		
//		unionTest.union(3, 8);
//		unionTest.union(9, 8);
//		unionTest.union(7, 8);
//		unionTest.union(13, 8);
//		
//		
//		unionTest.union(0, 1);
//		unionTest.union(1, 2);
//		unionTest.union(2, 3);
//		
//		unionTest.union(11,10);
//		unionTest.union(12, 11);
//		unionTest.union(13, 12);
//		
//		System.out.println(unionTest.find(8));
//		System.out.println(unionTest.find(9));
//		System.out.println(unionTest.find(7));
//		System.out.println(unionTest.find(13));
//		System.out.println(unionTest.find(2));
//		System.out.println(unionTest.find(1));
//		System.out.println(unionTest.find(unionTest.find(9)));
		
		
		//System.out.println(unionTest.find(3));
		//System.out.println(counter);
		
		
		
		
		
		unionTest.union(0, 5);
		unionTest.union(5, 6);
		unionTest.union(6, 11);
		unionTest.union(11, 12);
		
		
		unionTest.union(24, 23);
		unionTest.union(23, 18);
		
		
		System.out.println(unionTest.find(12));
		System.out.println(unionTest.find(11));
		System.out.println(unionTest.find(6));
		System.out.println(unionTest.find(5));
		
		
		
		
		
		
		System.out.println(unionTest.count());
		
	}
	
	
	
}
