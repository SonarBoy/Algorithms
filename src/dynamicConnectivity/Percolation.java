package dynamicConnectivity;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	
	//private int[] list;
	
	WeightedQuickUnionUF unionObject;
	private int[][] board;
	private int side;
	private int weightedQuickUnionLength;
	private int openSites;
	
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int inputSide) {
    	
    	
    		
    		if(inputSide < 0)
    			throw new IllegalArgumentException();
    		
    		
    		this.side = inputSide + 1;
	    	this.board = new int[this.side][this.side];
	    	
	    	for(int runner = 0; runner < this.side;runner++) {
	    		for(int runnerTwo = 0; runnerTwo < this.side;runnerTwo++) {
	    			
	        		this.board[runner][runnerTwo] = -1;
	        	}
	    	}
    	
	    	this.weightedQuickUnionLength = (this.side - 1) * (this.side - 1) + 2;
	    	this.unionObject = new WeightedQuickUnionUF((weightedQuickUnionLength));
	    	System.out.println(this.weightedQuickUnionLength);
    	
    }
    
    private int gridToNumber(int row,int col) {
    	 return ((this.side - 1)*(row - 1) + col) ;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	
    	this.board[row][col] = 0;
    	int connectionA = this.unionObject.find(gridToNumber(row,col));
    	
    	

    	/**
    	 * Corner Cases on the board
    	 */
    	if(row == 1 && col == 1) {
    		System.out.println("Top Left");
    		
    		// * *
    		// *
    		
    		this.unionObject.union(0, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);
    		
    		
    		spotCheck(row, col + 1, row, col, connectionA);

    		spotCheck(row + 1, col, row, col, connectionA);
    		
    		
    	}
    	
    	if((row == 1 && col == (this.side - 1))) {
    		System.out.println("Top Right");
    		
    		// * *
    		//   *
    		
    		this.unionObject.union(0, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);
    		

    		spotCheck(row, col - 1, row, col, connectionA);
    		
    		spotCheck(row + 1, col, row, col, connectionA);
    		
    	}
    	
    	if((row == (this.side - 1) && col == 1) ) {
    		System.out.println("Bottom Left");
    		
    		// *
    		// * *
    		
    		
    		
    		spotCheck(row - 1, col, row, col, connectionA);

    		spotCheck(row, col + 1, row, col, connectionA);
    		

    		this.unionObject.union(weightedQuickUnionLength - 1, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);
    		
    	}
    	
    	if((row == (this.side - 1) && col == (this.side - 1))) {
    		System.out.println("Bottom Right");
    		
    		//   *
    		// * * 
    		

    		spotCheck(row - 1, col, row, col, connectionA);
    		
    		spotCheck(row, col - 1, row, col, connectionA);
    		
    		this.unionObject.union(weightedQuickUnionLength - 1, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);
    	}
    	
    	
    	
    	/**
    	 * Edge Cases on the board. 
    	 */
    	if(row == 1 && (col > 1 && col < this.side - 1)){
    		System.out.println("Top Row");
    		
    		// * * * 
    		//   *
    		this.unionObject.union(0, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);
    		

    		spotCheck(row, col - 1, row, col, connectionA);

			spotCheck(row, col + 1, row, col, connectionA);

			spotCheck(row + 1, col, row, col, connectionA);
			
    	}
    	
    	if(row == this.side - 1 && (col > 1 && col < this.side - 1)) {
    		System.out.println("Bottom Row");
    		
    		//   * 
    		// * * * 
    		
    		
    		
    		
    		spotCheck(row, col - 1, row, col, connectionA);
    		
			spotCheck(row, col + 1, row, col, connectionA);

			spotCheck(row - 1, col, row, col, connectionA);
    		
			this.unionObject.union(weightedQuickUnionLength - 1, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);

			
    	}
    	   
    	
    	if(col == 1 && (row > 1 && row < this.side - 1)) {
    		System.out.println("Left Column");
    		
    		// *
    		// * *
    		// *

    		
    		spotCheck(row - 1, col, row, col, connectionA);
    		
    		spotCheck(row, col + 1, row, col, connectionA);
    		
    		spotCheck(row + 1, col, row, col, connectionA);
    	}
    	
    	if(col == this.side - 1 && (row > 1 && row < this.side - 1)) {
    		System.out.println("Right Column");
    		
    		//   *
    		// * *
    		//   *
    
    		
    		spotCheck(row - 1, col, row, col, connectionA);

    		spotCheck(row, col - 1, row, col, connectionA);
    		
    		spotCheck(row + 1, col, row, col, connectionA);
    	}
    	
    	
    	
    	/**
    	 * Center cases 
    	 */
    	
    	if(row != 1 && row != this.side - 1 && col != 1 && col != this.side - 1) {
    		System.out.println("Center Case");
    		
    		//   *
    		// * * *
    		//   *

    		
    		spotCheck(row - 1, col, row, col, connectionA);
    		
    		spotCheck(row + 1, col, row, col, connectionA);
    	
    		spotCheck(row, col - 1, row, col, connectionA);
    		
    		spotCheck(row, col + 1, row, col, connectionA);
    		
    	}
    	
    	

    	System.out.println("Count: " + this.unionObject.count());
    	
    	
    	
    	//susOut();

    	openSites++;
    	
    }
    
    private void susOut() {
    	
    	for(int runner = 0; runner < this.weightedQuickUnionLength; runner++) {
    		System.out.println("Value of " + runner + " : " + this.unionObject.find(runner));
    	}
    	
    }
    
    private void spotCheck(int checkRow, int checkCol, int boardRow, int boardCol, int connectionA) {
    	
    	int connectionB = this.unionObject.find(gridToNumber(checkRow, checkCol));
    	
    	if(isOpen(checkRow,checkCol)) {
			System.out.println("Top");
			
			if(isFull(checkRow,checkCol)) {
				
				/**
				 * Get the value of the top box and assign it to the newly opened space
				 * 
				 * unionObj.union(board[row - 1][col],board[row][col])
				 * board[row][col] = board[row - 1][col]
				 */
	
				this.unionObject.union(connectionA, connectionB);
				this.board[boardRow][boardCol] = this.unionObject.find(connectionA);
			}
			
			if(!isFull(checkRow,checkCol)) {
				
				/**
				 * Get the value of the top box and connect the objects.
				 * unionObj.union(board[row - 1][col],board[row][col])
				 */
				
				this.unionObject.union(connectionA, connectionB);
			}
			
		}
    	
    	
    	
		/**
		 * row == this.side - 1 && (col > 1 && col < this.side - 1)
		 * 
		 * (row == (this.side - 1) && col == (this.side - 1))
    		(row == (this.side - 1) && col == 1) 
		 */
//    	if(boardRow == this.side - 1 && (boardCol > 1 && boardCol < this.side - 1)) {
//    		System.out.println("Bottom Row for Perc check");
//
//    		
//    		if(isOpen(boardRow - 1, boardCol) ) {
//    			if(this.unionObject.find(gridToNumber(boardRow - 1, boardCol)) != this.unionObject.find(0)) {
//    				
//    				
//    			}
//    			this.unionObject.union(weightedQuickUnionLength - 1, connectionA);
//    		}
//    		
//    	}
//    	
//    	if((boardRow == (this.side - 1) && boardCol == 1) ) {
//    		System.out.println("Bottom left for Perc check");
//    		
//    		if(isOpen(boardRow - 1, boardCol) ) {
//    			this.unionObject.union(weightedQuickUnionLength - 1, connectionA);
//    		}
//    	}
//    	
//    	if((boardRow == (this.side - 1) && boardCol == (this.side - 1))) {
//    		System.out.println("Bottom Right for Perc check");
//    		
//    		if(isOpen(boardRow - 1, boardCol)) {
//    			this.unionObject.union(weightedQuickUnionLength - 1, connectionA);
//    		}
//    	}
    	
    }
    	
    	
    

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	
    	return (this.board[row][col] != -1);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	
    	//&& this.unionObject.find(gridToNumber(row, col)) != gridToNumber(row, col)
//    	return (this.board[row][col] != 0 && this.board[row][col] != -1) ||
//    			this.unionObject.find(gridToNumber(row, col)) == (weightedQuickUnionLength - 2);
    	
    	return (this.unionObject.find(gridToNumber(row, col)) == this.unionObject.find((0)));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return this.openSites;
    }

    // does the system percolate?
    public boolean percolates() {
    	
    	//Potential Change
    	//return (this.unionObject.find(weightedQuickUnionLength - 1) == this.unionObject.find(weightedQuickUnionLength - 2));
    	return (this.unionObject.find(0) == this.unionObject.find(weightedQuickUnionLength - 1));

    	
    }

    // test client (optional)
    public static void main(String[] args) {
 
    }
}
