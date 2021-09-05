package elementary;

public class Board {
	
	
	int[][] goalBoard;
	int[][] gameBoard; 
	int side;
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
    	
    	gameBoard = tiles;
    	side = tiles[0].length;
    	System.out.println(side);
    	
    	goalBoard = new int[side][side];
    	
    	for(int runner = 1; runner < side; runner++) {
    		for(int runnerTwo = 1; runnerTwo < side; runnerTwo++) {
    			
    			if(runner == (side - 1) && runnerTwo == (side - 1)) {
    				goalBoard[runner][runnerTwo] = 0;
    			}else {
    				goalBoard[runner][runnerTwo] = ((side - 1) * (runner - 1) + runnerTwo);
    			}
    			
        		
        	}
    	}
    	
    }
                                           
    // string representation of this board
    public String toString() {
    	
    	String printOut;
    	
    	printOut = "Side: " + (this.side - 1) + "\n";
    	
    	for(int runner = 1; runner < side; runner++) {
    		for(int runnerTwo = 1; runnerTwo < side; runnerTwo++) {
        		printOut += gameBoard[runner][runnerTwo] + " ";
        	}
    		printOut += "\n";
    	}
    	
    	
    	return printOut;
    	
    }

    // board dimension n
    public int dimension() {
    	return -1;
    }

    // number of tiles out of place
    public int hamming() {
    	return -1;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
    	return -1;
    }

    // is this board the goal board?
    public boolean isGoal() {
    	return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
    	return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors(){
    	return null;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
    	return null;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
    	
    	int leng = 5;
    	
    	int[][] board = new int[leng][leng];
    	
    	
    	for(int runner = 1; runner < leng; runner++) {
    		for(int runnerTwo = 1; runnerTwo < leng; runnerTwo++) {
    			
    			if(runner == (leng - 1) && runnerTwo == (leng - 1)) {
    				board[runner][runnerTwo] = 0;
    			}else {
    				board[runner][runnerTwo] = ((leng - 1) * (runner - 1) + runnerTwo);
    			}
    			
        		
        	}
    	}
    	
//    	for(int runner = 1; runner < 10; runner++) {
//    		System.out.println("Runner: " + runner);
//    		System.out.println("Divide: " + ((int)runner/3));
//    		System.out.println("Modulo: " + ((int)runner%3));
//    		System.out.println();
//    	}
    	
    	/*
    	 * 
    	 * Grid to number function.
    	((this.side - 1) * (row - 1) + col);
    	
    	*/
    	
    	
    	Board x = new Board(board);
    	
    	System.out.println(x.toString());
    	//x.toString();
    	
    }

}