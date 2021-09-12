package elementary;
import edu.princeton.cs.algs4.MinPQ;

public class Solver {

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
    	
    	MinPQ openList = new MinPQ();
    	MinPQ closedList = new MinPQ();
    	
    	
    	Board currentBoard = initial;
    	
    	int manhattan = currentBoard.manhattan();
    	int hamming = currentBoard.hamming();
    	
    	while(!currentBoard.isGoal()) {
    		
    	}
    	
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
    	return false;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
    	return -1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution(){
    	return null;
    }

    // test client (see below) 
    public static void main(String[] args) {
    	
    }

}
