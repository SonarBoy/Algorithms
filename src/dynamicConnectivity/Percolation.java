package dynamicConnectivity;

public class Percolation {
	
	
	private int[] list;
	private int[][] board;
	private int side;
	
	private int openSites;
	
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int inputSide) {
    	
    	
    		
    		if(inputSide < 0)
    			throw new IllegalArgumentException();
    		
    		//inputSide += 1;
    		this.side = inputSide + 1;
    		
	    	
	    	this.board = new int[this.side][this.side];
	    	
	    	for(int runner = 0; runner < this.side;runner++) {
	    		for(int runnerTwo = 0; runnerTwo < this.side;runnerTwo++) {
	    			
	        		this.board[runner][runnerTwo] = -1;
	        	}
	    	}
    	
	    	
	    	
    	
    }
    
    private int gridToNumber(int row,int col) {
    	 return ((this.side - 1)*(row - 1) + col) ;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	//this.list[(row*(row - 1)) + col] = 0;
    	//System.out.println("Value: " + (row*(row - 1)) + col);
    	
    	this.board[row][col] = 0;
    	
    	
//    	if((row == 1 && col == 1) || 
//    	   (row == 1 && col == (this.side - 1)) || 
//    	   (row == (this.side - 1) && col == 1) || 
//    	   (row == (this.side - 1) && col == (this.side - 1))) {
//    		
//    		System.out.println(this.side);
//    		System.out.println("Corner Case Hit");
//    	}
    	
    	
    	if(row == 1 && col == 1) {
    		System.out.println("Top Left");
    	}
    	
    	if((row == 1 && col == (this.side - 1))) {
    		System.out.println("Top Right");
    	}
    	
    	if((row == (this.side - 1) && col == 1) ) {
    		System.out.println("Bottom Left");
    	}
    	
    	if((row == (this.side - 1) && col == (this.side - 1))) {
    		System.out.println("Bottom Right");
    	}
    	
    	
    	
    	
    	if(row == 1 && (col > 1 && col < this.side - 1)){
    		System.out.println("Top Row");
    		
    	}
    	
    	if(row == this.side - 1 && (col > 1 && col < this.side - 1)) {
    		System.out.println("Bottom Row");
    	}
    	   
    	
    	if(col == 1 && (row > 1 && row < this.side - 1)) {
    		System.out.println("Left Column");
    	}
    	
    	if(col == this.side - 1 && (row > 1 && row < this.side - 1)) {
    		System.out.println("Right Column");
    	}
    	
    	
    	
    	
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
    	//Percolation x = new Percolation(5);
    }
}
