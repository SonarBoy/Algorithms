package elementary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;


import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;


public class Solver {

	private int moves;
	private MinPQ<SearchNode> openList;
	private boolean isSolve;
	private Stack<Board> solution;
	
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
    						if(s1.current().manhattan() < s2.current().manhattan()) {
    							return -1;
    						}else if(s1.current().manhattan() > s2.current().manhattan()) {
    							return 1;
    						}else {
    							return 0;
    						}
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
    						if(s1.current().manhattan() < s2.current().manhattan()) {
    							return -1;
    						}else if(s1.current().manhattan() > s2.current().manhattan()) {
    							return 1;
    						}else {
    							return 0;
    						}
    					}
    					
    					
    				}
    			});
    	
    	
    	Board currentBoard = initial;
    	SearchNode currentNode = new SearchNode(currentBoard,0,null);
    	
    	openList.insert(currentNode);
    	
    	while(!openList.isEmpty()) {
//    		System.out.println("Current");
//    		System.out.println("Manhattan: " + currentNode.current().manhattan());
//    		System.out.println("Hamming: "+ currentNode.current().hamming());
//    		System.out.println(currentNode.current().toString());
    		
    		
    		closedList.insert(currentNode);
    		
    		if(currentNode.current().isGoal()) {
    			this.moves = currentNode.moves;
    			this.isSolve = true;
    			break;
    		}
    		
    		
    		Iterable<Board> queue = currentNode.current().neighbors();
    		Iterator<Board> iter = queue.iterator();
    		
    		
    		
//    		System.out.println("Neighbours");
//    		System.out.println("---------------------");
    		SearchNode node = null;
    		
    		
    		
    		this.moves = currentNode.moves;
    		int nextMoves = this.moves + 1;
    		
    		
    		for(;iter.hasNext();) {
    			Board checkingNode = iter.next();
    			
    			
    			node = new SearchNode(checkingNode,nextMoves,currentNode);
    			
    			
//    			System.out.println(checkingNode.toString());
//    			System.out.println("Manhattan: "+checkingNode.manhattan());
//    			System.out.println("Hamming: "+checkingNode.hamming());
//    			System.out.println("Moves: "+ nextMoves);
    			
    			
    			boolean inOpen = false;
    			boolean inClosed = false;
    			
    			
    			SearchNode runner = currentNode;
//    			while(runner.prev() != null) {
//    				if(runner.current().equals(checkingNode)) {
//    					inClosed = true;
//    					break;
//    				}
//    				runner = runner.prev();
//    			}
    			
    			Iterator<SearchNode> closedListIterator = closedList.iterator();
    			while(closedListIterator.hasNext()) {
    				
    				SearchNode closedNode = closedListIterator.next();
    				
    				if(closedNode.current().equals(checkingNode)) {
    					
    					inClosed = true;
    					//System.out.println("Closed");
    					break;
    				}

    			}
    			
    			if(!inClosed) {
    				Iterator<SearchNode> openListIterator = openList.iterator();
        			while(openListIterator.hasNext()) {
        				
        				SearchNode openNode = openListIterator.next();
        				
        				if(openNode.current().equals(checkingNode)) {
        					
        					inOpen = true;
        					//System.out.println("Open");
        					break;
        				}
        				
        			
        			}
    			}

    			
    				if(!inClosed && !inOpen) {
    					
    						openList.insert(node);
    				
    				}
    				
    			
    		}
//    		System.out.println("---------------------");
    		
    		currentNode = openList.delMin();
    		
//    		Iterator<SearchNode> openListIterator = openList.iterator();
//			while(openListIterator.hasNext()) {
//				System.out.println(openListIterator.next().current().toString());
//			}
    		

    		
    		//System.out.println(openList.delMin().current().toString());
    	}
    	
    	
    	//System.out.println("Moves: "+this.moves);
    	if(currentNode.current().isGoal() == false) {
    		this.isSolve = false;
    		System.out.println("Unsolved");
    	}else {
    		this.isSolve = true;
    		System.out.println("Solved");
    		int runner = 0;
        	
        	//System.out.println("Runner : " + runner);	
    		solution = new Stack<Board>();
    		
    		while(currentNode.prev() != null) {
        		runner++;
        		System.out.println(currentNode.current().toString());
        		solution.push(currentNode.current());
        		currentNode = currentNode.prev();
        		
        	}
        	System.out.println(currentNode.current().toString());
    		solution.push(currentNode.current());
    	}
    	
    	
    	
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
    	return this.isSolve;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
    	return this.moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution(){
    	if(!this.isSolve) {
    		return null;
    	}
    		
    	return solution;
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
    	
    	public int moves() {
    		return this.moves;
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
