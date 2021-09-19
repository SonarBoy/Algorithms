package elementary;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class Solver {
	
	private int moves;
	private MinPQ<SearchNode> openList;
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
    	
    	openList = new MinPQ<SearchNode>(
    			(Comparator<SearchNode>) new Comparator<SearchNode>() {    
    				public int compare(SearchNode s1, SearchNode s2) {
    					
    					
    					if(s1.priority() < s2.priority()) {
    						return -1;
    					}else if(s1.priority() > s2.priority()) {
    						return 1;
    					}else {
    						return 0;
    					}
    					
    				}
    			});
    	
    	
    	MinPQ<SearchNode> closedList = new MinPQ<SearchNode>(
    			(Comparator<SearchNode>) new Comparator<SearchNode>() {    
    				public int compare(SearchNode s1, SearchNode s2) {
    					
    					
    					if(s1.priority() < s2.priority()) {
    						return -1;
    					}else if(s1.priority() > s2.priority()) {
    						return 1;
    					}else {
    						return 0;
    					}
    					
    				}
    			});
    	
    	
    	Board currentBoard = initial;
    	SearchNode currentNode = new SearchNode(currentBoard,0,null);
    	
    	openList.insert(currentNode);
    	
    	while(!currentNode.current().isGoal() && !openList.isEmpty()) {
    		
    		
    		
    		Iterable<Board> queue = currentNode.current().neighbors();
    		Iterator<Board> iter = queue.iterator();
    		Iterator<SearchNode> openListIterator = openList.iterator();
    		Iterator<SearchNode> closedListIterator = closedList.iterator();
    		
    		for(;iter.hasNext();) {
    			Board checkingNode = iter.next(); 
    			
    			boolean inOpen = false;
    			boolean inClosed = false;
    			
    			while(openListIterator.hasNext()) {
    				if(openListIterator.next().current().equals(checkingNode)) {
    					inOpen = true;
    				}
    			}
    			
    			while(closedListIterator.hasNext()) {
    				if(closedListIterator.next().current().equals(checkingNode)) {
    					inClosed = true;
    				}
    			}
    			
    			if(!inOpen && !inClosed) {
    				this.moves++;
    				
    				SearchNode node = new SearchNode(checkingNode,this.moves,currentNode);
    				
    				openList.insert(node);
    				
    			}
    			
    			
    		}
    		
    		//System.out.println(currentNode.current().toString());
    		
    		
    		
    		
    		closedList.insert(currentNode);
    		currentNode = openList.min();
    		System.out.println(openList.delMin().current().toString());
    	}
    	
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
    	return false;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
    	return this.moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution(){
    	return null;
    }
    
    private class SearchNode {
    	Board current;
    	int moves;
    	int priority; 
    	SearchNode previous;
    	
    	SearchNode(Board ini, int mvs, SearchNode prev){
    		this.current = ini;
    		this.moves = mvs;
    		this.previous = prev;
    		this.priority = mvs + ini.manhattan();
    	}
    	
    	public Board current() {
    		return this.current;
    	}
    	
    	
    	public SearchNode prev() {
    		return this.previous;
    	}
    	
    	public int priority() {
    		return this.priority;
    	}
    }
    
    // test client (see below) 
    public static void main(String[] args) {
    	

		int leng;

		try {

			File f = new File("C:\\Users\\Reginald\\eclipse-workspace\\8puzzle\\src\\gameBoard3x3.txt");
			Scanner scan = new Scanner(f);

			leng = scan.nextInt();

			int[][] board = new int[leng][leng];

			for (int runner = 0; runner < leng; runner++) {
				for (int runnerTwo = 0; runnerTwo < leng; runnerTwo++) {
					board[runner][runnerTwo] = scan.nextInt();
				}
			}

			Board x = new Board(board);

			Queue<Board> queue = (Queue<Board>) x.neighbors();
			
			
			Solver solver = new Solver(x);
			
//			Iterator iter = queue.iterator();
//			
//			MinPQ<SearchNode> minQue = new MinPQ<SearchNode>(
//	    			(Comparator<SearchNode>) new Comparator<SearchNode>() {    
//	    				public int compare(SearchNode s1, SearchNode s2) {
//	    					
//	    					
//	    					if(s1.current().manhattan() < s2.current().manhattan()) {
//	    						return -1;
//	    					}else if(s1.current().manhattan() > s2.current().manhattan()) {
//	    						return 1;
//	    					}else {
//	    						return 0;
//	    					}
//	    					
//	    				}
//	    			});;
//			
//			while(iter.hasNext()) {
//				
//				Board b = (Board) iter.next();
//				SearchNode search = new SearchNode(b,0,null);
//				minQue.insert(search);
//			}
//			
//			//minQue.printOut();
//			
//			while(!minQue.isEmpty()) {
//				
//				SearchNode node = minQue.min();
//				
//				System.out.println(node.current().toString());
//				
//				minQue.delMin();
//			}
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
