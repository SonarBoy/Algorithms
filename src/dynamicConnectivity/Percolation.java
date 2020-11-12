package dynamicConnectivity;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	
	//private int[] list;
	
	WeightedQuickUnionUF unionObject;
	private int[][] board;
	private int side;
	
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
    	
	    	
	    	//System.out.println("Board Length:" + this.board.length);
	    	
	    	
	    	this.unionObject = new WeightedQuickUnionUF(((this.side - 1) * (this.side - 1) + 1));
	    	
	    	System.out.println(this.unionObject.count());
    	
    }
    
    private int gridToNumber(int row,int col) {
    	 return ((this.side - 1)*(row - 1) + col) ;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	//this.list[(row*(row - 1)) + col] = 0;
    	//System.out.println("Value: " + (row*(row - 1)) + col);
    	
    	this.board[row][col] = 0;
    	int connectionA = gridToNumber(row,col);
    	int connectionB = -1;
    	
    	
//    	if((row == 1 && col == 1) || 
//    	   (row == 1 && col == (this.side - 1)) || 
//    	   (row == (this.side - 1) && col == 1) || 
//    	   (row == (this.side - 1) && col == (this.side - 1))) {
//    		
//    		System.out.println(this.side);
//    		System.out.println("Corner Case Hit");
//    	}
    	
    	
    	/**
    	 * Corner Cases on the board
    	 */
    	if(row == 1 && col == 1) {
    		System.out.println("Top Left");
    		
    		// * *
    		// *
    		
    		if(isOpen(row,col + 1)) {
    			System.out.println("Right of Top Left");
    			
    			connectionB = gridToNumber(row,col + 1);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = this.unionObject.find(connectionB);
    		}
    		
    		if(isOpen(row + 1, col)) {
    			System.out.println("Bottom of Top Left");
    			
    			connectionB = gridToNumber(row + 1,col);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = this.unionObject.find(connectionB);
    		}
    		
    	}
    	
    	if((row == 1 && col == (this.side - 1))) {
    		System.out.println("Top Right");
    		
    		// * *
    		//   *
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left of Top Right");
    			
    			connectionB = gridToNumber(row,col - 1);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    		if(isOpen(row + 1,col)) {
    			System.out.println("Bottom of Top Right");
    			
    			connectionB = gridToNumber(row + 1,col);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    		
    	}
    	
    	if((row == (this.side - 1) && col == 1) ) {
    		System.out.println("Bottom Left");
    		
    		// *
    		// * *
    		
    		if(isOpen(row - 1, col)) {
    			System.out.println("Top of Bottom Right");
    			
    			connectionB = gridToNumber(row - 1,col);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    		if(isOpen(row,col + 1)) {
    			System.out.println("Right of Bottom Left");
    			
    			connectionB = gridToNumber(row,col + 1);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    		
    		
    	}
    	
    	if((row == (this.side - 1) && col == (this.side - 1))) {
    		System.out.println("Bottom Right");
    		
    		//   *
    		// * * 
    		
    		if(isOpen(row - 1,col)) {
    			System.out.println("Top of Bottom Right");
    			
    			connectionB = gridToNumber(row - 1,col);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left of Bottom Right");
    			
    			connectionB = gridToNumber(row,col - 1);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    	}
    	
    	
    	
    	/**
    	 * Edge Cases on the board. 
    	 */
    	if(row == 1 && (col > 1 && col < this.side - 1)){
    		System.out.println("Top Row");
    		
    		// * * * 
    		//   *
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left");
    			
    			connectionB = gridToNumber(row,col - 1);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
			if(isOpen(row,col + 1)) {
			    System.out.println("Right");
			    
			    connectionB = gridToNumber(row,col + 1);
			    this.unionObject.union(connectionA,connectionB);
			    this.board[row][col] = connectionA;
			}
			
			if(isOpen(row + 1,col)) {
				System.out.println("Bottom");
				
				connectionB = gridToNumber(row + 1,col);
				this.unionObject.union(connectionA,connectionB);
				this.board[row][col] = connectionA;
			}
    		
    	}
    	
    	if(row == this.side - 1 && (col > 1 && col < this.side - 1)) {
    		System.out.println("Bottom Row");
    		
    		//   * 
    		// * * * 
    		
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left");
    			
    			connectionB = gridToNumber(row,col - 1);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
			if(isOpen(row,col + 1)) {
			    System.out.println("Right");
			    
			    connectionB = gridToNumber(row,col + 1);
			    this.unionObject.union(connectionA,connectionB);
			    this.board[row][col] = connectionA;
			}
			
			if(isOpen(row - 1,col)) {
				System.out.println("Top");
				
				connectionB = gridToNumber(row - 1,col);
				this.unionObject.union(connectionA,connectionB);
				this.board[row][col] = connectionA;
			}
    		
    	}
    	   
    	
    	if(col == 1 && (row > 1 && row < this.side - 1)) {
    		System.out.println("Left Column");
    		
    		// *
    		// * *
    		// *
    		
    		if(isOpen(row - 1,col)) {
    			System.out.println("Top");
    			
    			connectionB = gridToNumber(row - 1,col);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    		if(isOpen(row,col + 1)) {
    			System.out.println("Right");
    			
    			connectionB = gridToNumber(row,col + 1);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    		if(isOpen(row + 1,col)) {
    			System.out.println("Bottom");
    			
    			connectionB = gridToNumber(row + 1,col);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    	}
    	
    	if(col == this.side - 1 && (row > 1 && row < this.side - 1)) {
    		System.out.println("Right Column");
    		
    		//   *
    		// * *
    		//   *
    		
    		if(isOpen(row - 1,col)) {
    			System.out.println("Top");
    			
    			connectionB = gridToNumber(row - 1,col);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left");
    			
    			connectionB = gridToNumber(row,col - 1);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    		if(isOpen(row + 1,col)) {
    			System.out.println("Bottom");
    			
    			connectionB = gridToNumber(row + 1,col);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    			
    		}
    	}
    	
    	
    	
    	/**
    	 * Center cases 
    	 */
    	
    	if(row != 1 && row != this.side - 1 && col != 1 && col != this.side - 1) {
    		System.out.println("Center Case");
    		
    		//   *
    		// * * *
    		//   *
    		
    		if(isOpen(row - 1,col)) {
    			System.out.println("Top");
    			
    			connectionB = gridToNumber(row - 1,col);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    		if(isOpen(row + 1,col)) {
    			System.out.println("Bottom");
    			
    			
    			connectionB = gridToNumber(row + 1,col);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    			
    		}
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left");
    			
    			connectionB = gridToNumber(row,col - 1);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    		}
    		
    		if(isOpen(row,col + 1)) {
    			System.out.println("Right");
    			
    			connectionB = gridToNumber(row,col + 1);
    			this.unionObject.union(connectionA,connectionB);
    			this.board[row][col] = connectionA;
    			
    		}
    		
    		
    		
    	}
    	
    	System.out.println("Connection A: " + connectionA);
    	
    	//this.unionObject.union(connectionA,connectionB);
//    	System.out.println("Value: " + (((this.side - 1)*(row - 1)) + col));
//    	System.out.println("Value Grid: " + gridToNumber(row, col));
    	
    	openSites++;
    	
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	
    	return (this.board[row][col] == 0);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	
    	return (this.board[row][col] != 0 && this.board[row][col] != -1);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return this.openSites;
    }

    // does the system percolate?
    public boolean percolates() {
    	return false;
    }

    // test client (optional)
    public static void main(String[] args) {
    	//Percolation x = new Percolation(5);
    }
}
