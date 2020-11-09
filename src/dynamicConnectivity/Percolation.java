package dynamicConnectivity;

public class Percolation {
	
	
	private int[] list;
	private int[][] board;
	
	private int openSites;
	
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	
    	
    	try {
    		
    		
    		if(n < 0)
    			throw new IllegalArgumentException();
    			
	    	this.list = new int[(n*n) + 2];
	    	
	    	this.openSites = 0;
	    	
	    	
	    	System.out.println(this.list.length);
	    	System.out.println(""+n*n);
	    	
	    	for(int runner = 0; runner < this.list.length;runner++) {
	    		this.list[runner] = -1;
	    	}
	    	
	    	this.board = new int[n][n];
	    	
	    	for(int runner = 0; runner < n;runner++) {
	    		for(int runnerTwo = 0; runnerTwo < n;runnerTwo++) {
	        		this.board[runner][runnerTwo] = -1;
	        	}
	    	}
    	}
    	
    	catch(Exception ex) {
    		
    	}
    	
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	//this.list[(row*(row - 1)) + col] = 0;
    	//System.out.println("Value: " + (row*(row - 1)) + col);
    	
    	this.board[row][col] = 0;
    	
    	
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	
    	return (this.board[row - 1][col - 1] == 0);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	
    	return false;
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
    	Percolation x = new Percolation(5);
    }
}
