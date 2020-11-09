package dynamicConnectivity;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Percolation: Simple simulation to emulate percolation.
 * 
 * @author Joshua
 * @version 1.0
 * @since 
 */
public class PercolationOld {
	
	/**
	 * Main class variables
	 * 
	 * board = 2d array to simulate the medium
	 * uniqueValuelist = array to hold and test for the ending percolation result.
	 * openSites = number of open sites.
	 */
	int board[][];
	int uniqueValueList[];
	int openSites;
	
	
	
	long start;
	long finish;
	long timeElapsed;
	WeightedQuickUnionUF unionObject;
	
	
	
	/**
	 * Constructor:
	 * Generates a new 2d array which acts as the medium.
	 * Generates a unique value list that represents the index number of the sites.
	 * Initializes the board to -1 and the unique value list to the number of elements on the board.
	 * 
	 * @param sides = the length of sides.
	 */
	
	public PercolationOld(int sides) {
	
		//Start Timer.
		start = System.nanoTime();
		
		
		sides += 1;
		openSites = 0;
		
		//Initialize board and unique value list.
		board = new int[sides][sides];
		uniqueValueList = new int[(sides - 1) * (sides - 1) + 2];
		uniqueValueList[0] = 0;
		
		int counter = 1;
	
		
		//Loop for assignment.
		for(int runner = 1; runner < sides; runner++) {
			for(int secondRunner = 1; secondRunner < sides; secondRunner++) {
				board[runner][secondRunner] = -1;
				
				
				if(counter != 0 && counter < sides) {
					uniqueValueList[counter] = 0;
				}else if(counter > (sides * (sides - 1))) {
					uniqueValueList[counter] = (sides * sides);
				}else {
					uniqueValueList[counter] = counter;
				}
				
				
				counter++;
			}
		}
		
		//Final value adding to the unique value list. 
		uniqueValueList[counter] = counter ;
	  
		
		this.unionObject = new WeightedQuickUnionUF((sides - 1) * (sides - 1));
		
		
		
		
		
		
		
		
		
		//Stop timer and print out.
        finish = System.nanoTime();
        timeElapsed = finish - start;
        
        System.out.println(sides);
        System.out.println(timeElapsed);
	}
	
	/**
	 * openWithSection:
	 * Opens an index of the grid and assigns it a unique value. 
	 * This method was specifically designed to show the inefficiency of my visual thinking.
	 * 
	 * Unique value generation:
	 * Multiply the row and column to get value X. We then take the row and column and subtract one from the row and and one to the column,
	 * we then set up two loops to count to the end of the board. So the row counters loop condition will be row != 0 and the columns counter 
	 * condition will be col != board.length - 1 we then take those two number that we get from counting to the edges of the board multiply them 
	 * and add it back to X. 
	 * 
	 * Prior error 
	 * First Mathematical instinct was right but did not work because the row and board did not represent unique values but indexes.
	 * board[row][col] = (row * col) + ((col - 1)*(board.length - row - 1));
	 * 
	 *
	 * 
	 * @param row of the element to open
	 * @param col of the element to open
	 */
	public void openWithSection(int row, int col) {
		
		//Start timer
		start = System.nanoTime();
		
		
		board[row][col] = 0;
		int leng = board.length - 1;
		
		/**Conditional to determine what to do with provided index.
		 * 
		 * if(the row is in the first column and the column number is not zero)
		 * - simple multiplication
		 * if(the row is in the last column and the row number is not zero)
		 * - simple multiplication
		 * else 
		 * - do the visual processing of the index on the computer. 
		 */
		if(row == 1 && col != 0) {
			board[row][col] = row * col;
		}else if(col == leng && row != 0) {
			board[row][col] = row * col;
		}else {
			
			int adderRow = row - 1;
			int adderCol = col + 1;
			
			int rowCount = 1;
			int colCount = 1;
		
			while(adderRow > 1 || adderCol < leng) {
				
				if(adderRow > 1) {
					adderRow--;
					rowCount++;
				}
				
				if(adderCol < leng) {
					adderCol++;
					colCount++;
				}
			}
		
			
			board[row][col] = (row * col) + (rowCount * colCount); 
		}
		
		openSites++;
		
		
		
		//Stop timer.
		finish = System.nanoTime();
	    timeElapsed = finish - start;   
	    System.out.println("With Section Elapsed Time: "+timeElapsed);
		
		return;
	}
	
	
	/**
	 * openWithList
	 * Opens an index of the grid and assigns it a unique value.
	 * This method was designed to work with the computer.
	 * 
	 * It simply takes the number of rows - 1 then multiplies it by the number of columns in the board and finally adds the col variable 
	 * to it to get the unique value. 
	 * 
	 * 
	 * @param row of the element to open 
	 * @param col of the element to open
	 */
	public void openWithList(int row, int col) {
		
		start = 0;
		start = System.nanoTime();
		
		board[row][col] = 0;
		int leng = board.length - 1;
		
		
		//Open the space with the value in the holder list.
		board[row][col] = uniqueValueList[((leng*(row - 1)) + col)];
		
		
		//Testing for corner cases and edge cases
		if((row == 1 && col == 1)){
			
			//Corner Case Top Left
			System.out.println("Corner Case hit " + row + " " + col);
			System.out.println("North: " + 0);
			
			if(isOpen(row + 1, col)) {
				
				//System.out.println("South: " + uniqueValueList[((leng*(row )) + col)]);
				this.union(row,col,row+1,col,leng);
				this.unionObject.union(row, col);
			}
			
			if(isOpen(row ,col +1)) {
				
				//System.out.println("East: " + uniqueValueList[((leng*(row - 1)) + (col + 1))]);
				this.union(row,col,row,col+1,leng);
				
			}
			
			
			
			
		}else if((row == 1 && col == leng)) {
			
			//Corner Case Top Right
			System.out.println("Corner Case hit " + row + " " + col);
			System.out.println("North: " + 0);
			
			if(isOpen(row + 1, col)) {
				
				//System.out.println("South: " + uniqueValueList[((leng*(row )) + col)]);
				this.union(row, col, row + 1, col, leng);
			}
			
			if(isOpen(row ,col -1)) {
				
				//System.out.println("West: " + uniqueValueList[((leng*(row - 1)) + (col - 1))]);
				this.union(row, col, row , col - 1, leng);
			
			}
			
			
			//Assingment to 0
			
			
		}else if((row == leng && col == 1)) {
			
			//Corner Case Bottom Left
			System.out.println("Corner Case hit " + row + " " + col);
			System.out.println("South: " + -1);
			
			if(isOpen((row - 1) ,col )) {
				//System.out.println("North: " + uniqueValueList[((leng*(row - 2)) + col)]);
				
				this.union(row, col, row -1, col, leng);
			}
			
			if(isOpen(row ,col +1)) {
				//System.out.println("East: " + uniqueValueList[((leng*(row - 1)) + (col + 1))]);
				
				this.union(row,col,row,col+1,leng);
			}
			
			//Assingment to -1
			
			
		}else if((row == leng && col == leng)) {
			
			//Corner Case Bottom Right
			System.out.println("Corner Case hit " + row + " " + col);
			System.out.println("South: " + -1);
			
			if(isOpen((row - 1) ,col )) {
				
				
				//System.out.println("North: " + uniqueValueList[((leng*(row - 2)) + col)]);
				
				this.union(row, col, row - 1, col, leng);
			}
			
			if(isOpen((row ) ,col -1)) {
				//System.out.println("West: " + uniqueValueList[((leng*(row - 1)) + (col - 1))]);
				
				this.union(row, col, row, col - 1, leng);
			}
			
			
			//Assingment to -1
		}else if((row == 1 && col > 1 && col < leng) ) {
			
			//Top Edge Case
			
			System.out.println("Top Edge case  hit " + row + " " + col);
			System.out.println("North: " + 0);
			
			if(isOpen(row ,col + 1)) {
				//System.out.println("East: " + uniqueValueList[((leng*(row - 1)) + (col + 1))]);
				
				this.union(row, col, row, col + 1, leng);
			}
			
			if(isOpen(row , col - 1)) {
				//System.out.println("West: " + uniqueValueList[((leng*(row - 1)) + (col - 1))]);
				
				
				this.union(row, col, row, col - 1, leng);
			}
			
			if(isOpen(row + 1,col)) {
				//System.out.println("South: " + uniqueValueList[((leng*(row )) + col)]);
				
				this.union(row, col, row + 1, col , leng);
			}
			
		}else if(row == leng && col > 1 && col < leng) {
			
			//Bottom Edge Case
			
			System.out.println("Bottom Edge case  hit " + row + " " + col);
			System.out.println("South: " + -1);
			
			if(isOpen(row, col + 1)) {
				//System.out.println("East: " + uniqueValueList[((leng*(row - 1)) + (col + 1))]);
				
				this.union(row, col, row, col + 1, leng);
			}
			
			if(isOpen(row,col - 1)) {
				//System.out.println("West: " + uniqueValueList[((leng*(row - 1)) + (col - 1))]);
				
				this.union(row, col, row, col - 1, leng);
			}
			
			if(isOpen(row - 1,col )) {
				//System.out.println("North: " + uniqueValueList[((leng*(row - 2)) + col)]);
				
				this.union(row, col, row - 1, col , leng);
			}
			
			
			
			
		}else if(row > 1 && row < leng && col == 1) {
			
			//Left Edge Case
			System.out.println("Left Edge case  hit " + row + " " + col);
			
			if(isOpen(row-1,col)) {
				//System.out.println("North: " + uniqueValueList[((leng*(row - 2)) + col)]);
				
				this.union(row, col, row - 1, col , leng);
			}
			
			if(isOpen(row + 1,col)) {
				//System.out.println("South: " + uniqueValueList[((leng*(row )) + col)]);
				
				this.union(row, col, row + 1, col, leng);
			}
			
			if(isOpen(row, col + 1)) {
				//System.out.println("East: " + uniqueValueList[((leng*(row - 1)) + (col + 1))]);
				
				this.union(row, col, row, col + 1, leng);
			}
			
			
			
		}else if(row > 1 && row < leng && col == leng) {
			
			//Right Edge Case
			System.out.println("Right Edge case  hit " + row + " " + col);
			
			if(isOpen(row - 1,col)) {
				//System.out.println("North: " + uniqueValueList[((leng*(row - 2)) + col)]);
				
				this.union(row, col, row - 1, col , leng);
			}
			
			if(isOpen(row + 1,col)) {
				//System.out.println("South: " + uniqueValueList[((leng*(row )) + col)]);
				
				this.union(row, col, row + 1, col, leng);
			}
			
			if(isOpen(row,col - 1)) {
				//System.out.println("West: " + uniqueValueList[((leng*(row - 1)) + (col - 1))]);
				
				this.union(row, col, row, col - 1, leng);
			}
			
		}else{
			
			
			
			if(isOpen(row - 1, col)) {
				System.out.println("North: " + uniqueValueList[((leng*(row - 2)) + col)]);
				
				this.union(row, col, row - 1, col, leng);
			}
			
			
			if(isOpen(row + 1,col)) {
				System.out.println("South: " + uniqueValueList[((leng*(row )) + col)]);
				
				this.union(row, col, row + 1, col , leng);
			}
			
			if(isOpen(row,col + 1)) {
				System.out.println("East: " + uniqueValueList[((leng*(row - 1)) + (col + 1))]);
				
				this.union(row, col, row , col + 1, leng);
			}
			
			if(isOpen(row,col-1)) {
				System.out.println("West: " + uniqueValueList[((leng*(row - 1)) + (col - 1))]);
				
				this.union(row, col, row , col - 1, leng);
			}
			
		}
		
		
		
		
		
		board[row][col] = uniqueValueList[((leng*(row - 1)) + col)];
		
		
		
		openSites++;
		
		finish = System.nanoTime();
	    timeElapsed = finish - start;
	       
	    //System.out.println("With List Elapsed Time: "+timeElapsed);
		
		return;
	}
	
	
	/**
	 * rootWithList:
	 * Finds the root of the value given by going to the indexes associated with that value until the index and value match.
	 * 
	 * @param value 
	 * @return value at index
	 */
	public int rootWithList(int value) {
		
		while(value != uniqueValueList[value]){
			uniqueValueList[value] = uniqueValueList[uniqueValueList[value]];
			value = uniqueValueList[value];
		}
		
		return value;
	}
	
	
	
	/**
	 * union:
	 * takes in two sites on the board and finds each root of each site and  connects them
	 * 
	 *  if(the first sites root is greater than the second sites root)
	 *  - assign the second value to the uniqueValueList with the root of the firstValue.
	 *  
	 *  if(the second sites root is greater than the first sites root)
	 *  - assign the first value to the uniqueValueList with the root of the secondValue.
	 *  
	 *  This is done to insure that we are always pointing back to the lowest value. 
	 *  
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param length
	 */

	public void union(int x1,int y1, int x2, int y2, int length) {
		int firstValue = rootWithList(uniqueValueList[((length * (x1 - 1)) + y1)]);
		int secondValue = rootWithList(uniqueValueList[((length * (x2 - 1)) + y2)]);
		
		
		//Define why you did this please note the out put where it auto assigns to the lowest value.
		if(firstValue > secondValue) {
			uniqueValueList[firstValue] = secondValue;
		}else if(secondValue > firstValue) {
			uniqueValueList[secondValue] = firstValue;
		}else {
			uniqueValueList[firstValue] = secondValue;
		}
		
		
		
		
		System.out.println("Joining Value: " + firstValue + " with " + secondValue);
	}
	
	/**
	 * isFull:
	 * checks to see if the site does not contain a -1 if it does returns a true.
	 * @param row
	 * @param col
	 * @return
	 */
	
	public boolean isFull(int row, int col) {
		
		if(board[row][col] != -1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean isOpen(int row, int col) {
		
		if(board[row][col] != -1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	/**
	 * numberOfOpenSites:
	 * returns the number of open sites.
	 * @return openSites.
	 */
	public int numberOfOpenSites() {
		return openSites;
	}
	
	
	
	/**
	 * printOut:
	 * prints out the values of the board.
	 */
	public void printOut() {
		
		int sides = board.length;
		
		for(int runner = 1; runner < sides; runner++) {
			for(int secondRunner = 1; secondRunner < sides; secondRunner++) {
				System.out.print(board[runner][secondRunner] + " ");
			}
			
			System.out.println();
		}
		
		
//		System.out.println("Count: " + this.unionObject.count());
//		System.out.println("Find: " + this.unionObject.find(0));
	}
	
	
	/**
	 * printOutUniqueValueList
	 * prints out the unique value list. 
	 */
	public void printOutUniqueValueList(){
		for(int runner = 0;runner < uniqueValueList.length;runner++) {
			System.out.println("Index: "+ runner+ " : "+uniqueValueList[runner] + " ");
		}
	}
	
	public boolean percolates() {
		return false;
	}
	
	
	
	public static void main(String []args) {
		
		PercolationOld tester = new PercolationOld(5);
		
		tester.printOut();
		
		System.out.println();
		
		tester.printOut();
		
		System.out.println();
		
	
	/*
		
		//Top Edge case hit
//		tester.openWithList(1, 2);
//		tester.openWithList(1, 3);
//		tester.openWithList(1, 4);
		
		//Bottom Edge case hit
//		tester.openWithList(5, 2);
//		tester.openWithList(5, 3);
//		tester.openWithList(5, 4);
		
		//Left Edge Case Hit
//		tester.openWithList(2, 1);
//		tester.openWithList(3, 1);
//		tester.openWithList(4, 1);
		
		
//		//Right Edge Case Hit
//		tester.openWithList(2, 5);
//		tester.openWithList(3, 5);
//		tester.openWithList(4, 5);
		
		//tester.union(5, 5, 1, 1, 5);
		//tester.union(1,1,2,1,5);
		
		//Corner cases hit =========================================
		tester.openWithList(1, 1);
		tester.openWithList(5, 1);
		tester.openWithList(1, 5);
//		tester.openWithList(5, 5);
		
		//Top Edge case hit
		tester.openWithList(1, 2);
//		tester.openWithList(1, 3);
		tester.openWithList(1, 4);
		
		//Bottom Edge case hit
		tester.openWithList(5, 2);
//		tester.openWithList(5, 3);
		tester.openWithList(5, 4);
		
		//Left Edge Case Hit
//		tester.openWithList(2, 1);
		tester.openWithList(3, 1);
		tester.openWithList(4, 1);
		
		
//		//Right Edge Case Hit
//		tester.openWithList(2, 5);
//		tester.openWithList(3, 5);
//		tester.openWithList(4, 5);
		
		tester.openWithList(2, 2);
		tester.openWithList(3, 2);
		
		
		*/
		System.out.println();
		
		
		
		/* Top Left to bottom right testing
		//tester.openWithList(1, 1);
		tester.openWithList(2, 1);
		tester.openWithList(2, 2);
		//tester.openWithList(3, 2);
		tester.openWithList(3, 3);
		tester.openWithList(4, 3);
		tester.openWithList(4, 4);
		//tester.openWithList(5, 4);
		//tester.openWithList(5, 5);
		
		
		tester.openWithList(2, 5);
		*/
		
		
		// Top right to bottom left testing.
		tester.openWithList(1, 5);
		tester.openWithList(2, 5);
		tester.openWithList(2, 4);
		tester.openWithList(3, 4);
		tester.openWithList(3, 3);
		tester.openWithList(4, 3);
		tester.openWithList(4, 2);
		tester.openWithList(5, 2);
		
		
		
		System.out.println("Opened with List:");
		tester.printOutUniqueValueList();
		
		System.out.println("Opened with List:");
		tester.printOut();
		
		
//		tester = null;
//		tester = new Percolation(5);
//		
//		
//		tester.printOut();
//		
//		System.out.println();
//		
//		tester.printOut();
//		
//		System.out.println();
//		
//		tester.openWithSection(1, 5);
//		tester.openWithSection(2, 5);
//		tester.openWithSection(2, 4);
//		tester.openWithSection(3, 4);
//		tester.openWithSection(3, 3);
//		tester.openWithSection(4, 3);
//		tester.openWithSection(4, 2);
//		tester.openWithSection(5, 2);
//		
//		System.out.println("Opened with Section:");
//		tester.printOutUniqueValueList();
//		
//		System.out.println("Opened with Section:");
//		tester.printOut();
	}
	
	
	//
	
	
}