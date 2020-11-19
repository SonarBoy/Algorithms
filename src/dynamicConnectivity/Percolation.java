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
    	
	    	this.weightedQuickUnionLength = (this.side - 1) * (this.side - 1) + 3;
	    	
	    	this.unionObject = new WeightedQuickUnionUF((weightedQuickUnionLength));
    	
    }
    
    private int gridToNumber(int row,int col) {
    	 return ((this.side - 1)*(row - 1) + col) ;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	
    	this.board[row][col] = 0;
    	int connectionA = this.unionObject.find(gridToNumber(row,col));
    	int connectionB = this.unionObject.find(0);
    	//connectionB = this.unionObject.find(gridToNumber(row - 1,col));
    	

    	/**
    	 * Corner Cases on the board
    	 */
    	if(row == 1 && col == 1) {
    		System.out.println("Top Left");
    		
    		// * *
    		// *
    		
    		this.unionObject.union(weightedQuickUnionLength - 2, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);
    		
    		
    		if(isOpen(row,(col + 1))) {
    			System.out.println("Right of Top Left");
    			connectionB = this.unionObject.find(gridToNumber(row, col + 1));
    			
    			if(isFull(row,col + 1)) {
    				//Take the gridNumber and assign it to the newly open space.  
    				
    				
    				this.unionObject.union(connectionA, connectionB);
				    this.board[row][col] = this.unionObject.find(connectionA);
    				
    			}
    			
    			if(!isFull(row,col + 1)) {
    				this.unionObject.union(connectionA, connectionB);
    				
    			}
    			
    			
    		}
    		
    		if(isOpen((row + 1), col)) {
    			System.out.println("Bottom of Top Left");
    			connectionB = this.unionObject.find(gridToNumber(row + 1, col));
    			
    			
    			if(isFull(row + 1,col)) {
    				
    				this.unionObject.union(connectionA, connectionB);
				    this.board[row][col] = this.unionObject.find(connectionA);
    			}
    			
    			if(!isFull(row + 1,col)) {
    				
    				this.unionObject.union(connectionA, connectionB);
    			}
    		
    		}
    		
    		
    		
    	}
    	
    	if((row == 1 && col == (this.side - 1))) {
    		System.out.println("Top Right");
    		
    		// * *
    		//   *
    		this.unionObject.union(weightedQuickUnionLength - 2, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left of Top Right");
    			connectionB = this.unionObject.find(gridToNumber(row, col - 1));
    			
    			if(isFull(row,col - 1)) {
    				//Take the gridNumber and assign it to the newly open space
    				
    				this.unionObject.union(connectionA, connectionB);
				    this.board[row][col] = this.unionObject.find(connectionA);
    			}
    			
    			if(!isFull(row,col - 1)) {
    				this.unionObject.union(connectionA, connectionB);
    			}
    		}
    		
    		if(isOpen(row + 1,col)) {
    			System.out.println("Bottom of Top Right");
    			connectionB = this.unionObject.find(gridToNumber(row + 1, col));
    			
    			if(isFull(row + 1,col)) {
    				//Take the girdNumber of the square above it and assign it to itself. 
    				
    				this.unionObject.union(connectionA, connectionB);
				    this.board[row][col] = this.unionObject.find(connectionA);
    			}
    			
    			if(!isFull(row + 1,col)) {
    				this.unionObject.union(connectionA, connectionB);
//    				this.board[row + 1][col] = this.unionObject.find(connectionB);
    			}
    			
    			
    		}
    		
    		
    	}
    	
    	if((row == (this.side - 1) && col == 1) ) {
    		System.out.println("Bottom Left");
    		
    		// *
    		// * *
    		
    		this.unionObject.union(weightedQuickUnionLength - 1, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);
    		
    		if(isOpen(row - 1, col)) {
    			System.out.println("Top of Bottom Right");
    			connectionB = this.unionObject.find(gridToNumber(row - 1,col));
    			
    			if(isFull(row - 1,col)) {
    				//Take the gridNumber and assing it to the newly open space.
    				
    				/*
    				 * unionObj.union(board[row - 1][col],board[row][col])
    				 * board[row][col] = unionObj.find(board[row - 1][col]) 
    				 */
    				
    				this.unionObject.union(connectionA, connectionB);
				    this.board[row][col] = this.unionObject.find(connectionA);
    			}
    			
    			if(!isFull(row - 1,col)) {
    				//Take the newly opened grid number and assing it to this space
    				
    				/*
    				 * unionObj.union(board[row - 1][col],board[row][col])
    				 */
    				this.unionObject.union(connectionA, connectionB);
    			}
    			
    		}
    		
    		if(isOpen(row,col + 1)) {
    			System.out.println("Right of Bottom Left");
    			connectionB = this.unionObject.find(gridToNumber(row,col + 1));
    			
    			if(isFull(row,col + 1)) {

    				this.unionObject.union(connectionA, connectionB);
				    this.board[row][col] = this.unionObject.find(connectionA);
    			}
    			
    			if(!isFull(row,col + 1)) {
    				this.unionObject.union(connectionA, connectionB);
    			}
    		}
    		
    		
    		
    	}
    	
    	if((row == (this.side - 1) && col == (this.side - 1))) {
    		System.out.println("Bottom Right");
    		
    		//   *
    		// * * 
    		
    		this.unionObject.union(weightedQuickUnionLength - 1, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);
    		
    		if(isOpen(row - 1,col)) {
    			System.out.println("Top of Bottom Right");
    			connectionB = this.unionObject.find(gridToNumber(row - 1,col));
    			
    			if(isFull(row - 1,col)) {
    		
    				this.unionObject.union(connectionA, connectionB);
				    this.board[row][col] = this.unionObject.find(connectionA);
    			}
    			
    			if(!isFull(row -1 ,col)) {
    				this.unionObject.union(connectionA, connectionB);
    			}
    		}
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left of Bottom Right");
    			connectionB = this.unionObject.find(gridToNumber(row,col - 1));
    			
    			if(isFull(row,col - 1)) {
    				this.unionObject.union(connectionA, connectionB);
				    this.board[row][col] = this.unionObject.find(connectionA);
    				
    			}
    			
    			if(!isFull(row,col - 1)) {
    				this.unionObject.union(connectionA, connectionB);
    			}
    		}
    		
    	}
    	
    	
    	
    	/**
    	 * Edge Cases on the board. 
    	 */
    	if(row == 1 && (col > 1 && col < this.side - 1)){
    		System.out.println("Top Row");
    		
    		// * * * 
    		//   *
    		this.unionObject.union(weightedQuickUnionLength - 2, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left");
    			
    			connectionB = this.unionObject.find(gridToNumber(row, col - 1));
    			
    			if(isFull(row,col - 1)) {
    				
    				
    				this.unionObject.union(connectionA, connectionB);
				    this.board[row][col] = this.unionObject.find(connectionA);
    			}
    			
    			if(!isFull(row,col - 1)) {
    				this.unionObject.union(connectionA, connectionB);
    			}
    			
    		}
    		
			if(isOpen(row,col + 1)) {
			    System.out.println("Right");
			   
			    connectionB = this.unionObject.find(gridToNumber(row, col + 1));
			    
			    
			    if(isFull(row,col + 1)) {
			    	this.unionObject.union(connectionA, connectionB);
				    this.board[row][col] = this.unionObject.find(connectionA);
			    }
			    
			    
			    if(!isFull(row,col + 1)) {
			    	this.unionObject.union(connectionA, connectionB);
    			}
			}
			
			if(isOpen(row + 1,col)) {
				System.out.println("Bottom");
				
				connectionB = this.unionObject.find(gridToNumber(row + 1, col));
				
				 if(isFull(row + 1,col)) {
					this.unionObject.union(connectionA, connectionB);
				    this.board[row][col] = this.unionObject.find(connectionA);
				 }
				 
				 if(!isFull(row + 1,col)) {
					 this.unionObject.union(connectionA, connectionB);
				 }
				
			}
    		
			
			
    	}
    	
    	if(row == this.side - 1 && (col > 1 && col < this.side - 1)) {
    		System.out.println("Bottom Row");
    		
    		//   * 
    		// * * * 
    		
    		this.unionObject.union(weightedQuickUnionLength - 1, connectionA);
    		this.board[row][col] = this.unionObject.find(connectionA);
    		
    		if(percolates()) {
    			
    		}
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left");
    			
    			connectionB = this.unionObject.find(gridToNumber(row,col - 1));
    			
    			if(isFull(row,col - 1)) {
    				this.unionObject.union(connectionA, connectionB);
			    	this.board[row][col] = this.unionObject.find(connectionA);
				}
    			
    			if(!isFull(row,col - 1)) {
    				this.unionObject.union(connectionA, connectionB);
				}
    			
    		}
    		
			if(isOpen(row,col + 1)) {
			    System.out.println("Right");
			    connectionB = this.unionObject.find(gridToNumber(row,col + 1));
			    
    			if(isFull(row,col + 1)) {
			    	this.unionObject.union(connectionA, connectionB);
			    	this.board[row][col] = this.unionObject.find(connectionA);
				}
    			
    			if(!isFull(row,col + 1)) {
    				this.unionObject.union(connectionA, connectionB);
				}
			   
			}
			
			if(isOpen(row - 1,col)) {
				System.out.println("Top");
				connectionB = this.unionObject.find(gridToNumber(row - 1,col));
				
    			if(isFull(row - 1,col)) {
    				this.unionObject.union(connectionA, connectionB);
			    	this.board[row][col] = this.unionObject.find(connectionA);
				}
    			
    			if(!isFull(row - 1,col)) {
    				this.unionObject.union(connectionA, connectionB);
				}
				
			}
    		
			
			
    	}
    	   
    	
    	if(col == 1 && (row > 1 && row < this.side - 1)) {
    		System.out.println("Left Column");
    		
    		// *
    		// * *
    		// *
    		
    		if(isOpen(row - 1,col)) {
    			System.out.println("Top");
    			
    			connectionB = this.unionObject.find(gridToNumber(row - 1, col));
    			
    			if(isFull(row - 1,col)) {
    				this.unionObject.union(connectionA, connectionB);
    				this.board[row][col] = this.unionObject.find(connectionA);
    			}
    			
    			if(!isFull(row - 1,col)) {
    				this.unionObject.union(connectionA, connectionB);

    			}
    			
    		}
    		
    		if(isOpen(row,col + 1)) {
    			System.out.println("Right");
    			
    			connectionB = this.unionObject.find(gridToNumber(row,col + 1));
    			
    			
    			if(isFull(row,col + 1)) {
    				this.unionObject.union(connectionA, connectionB);
    				this.board[row][col] = this.unionObject.find(connectionA);
    			}
    			
    			if(!isFull(row,col + 1)) {
    				this.unionObject.union(connectionA, connectionB);
    			}
    			
    			
    			
    		}
    		
    		if(isOpen(row + 1,col)) {
    			System.out.println("Bottom");
    			
    			connectionB = this.unionObject.find(gridToNumber(row + 1,col));
    			
    			if(isFull(row + 1,col)) {
    				this.unionObject.union(connectionA, connectionB);
    				this.board[row][col] = this.unionObject.find(connectionA);
    			}
    			
    			if(!isFull(row + 1,col)) {
    				this.unionObject.union(connectionA, connectionB);
    			}

    		}
    		
    		
    	}
    	
    	if(col == this.side - 1 && (row > 1 && row < this.side - 1)) {
    		System.out.println("Right Column");
    		
    		//   *
    		// * *
    		//   *
    		
    		if(isOpen(row - 1,col)) {
    			System.out.println("Top");
    			connectionB = this.unionObject.find(gridToNumber(row - 1,col));
    			
    			
    			if(isFull(row - 1,col)) {
    				this.unionObject.union(connectionA, connectionB);
    				this.board[row][col] = this.unionObject.find(connectionA);
				}
    			
    			if(!isFull(row - 1,col)) {
    				this.unionObject.union(connectionA, connectionB);
				}
    			
    			
    		}
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left");
    			connectionB = this.unionObject.find(gridToNumber(row,col - 1));
    			
    			if(isFull(row ,col - 1)) {
    				this.unionObject.union(connectionA, connectionB);
    				this.board[row][col] = this.unionObject.find(connectionA);
				}
    			
    			if(!isFull(row,col - 1)) {
    				this.unionObject.union(connectionA, connectionB);
				}
    			
    		}
    		
    		if(isOpen(row + 1,col)) {
    			System.out.println("Bottom");
    			connectionB = this.unionObject.find(gridToNumber(row + 1,col));
    			
    			if(isFull(row + 1,col)) {
    				this.unionObject.union(connectionA, connectionB);
    				this.board[row][col] = this.unionObject.find(connectionA);
				}
    			
    			if(!isFull(row + 1,col)) {
			    	this.unionObject.union(connectionA, connectionB);
				}
    			
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
    			
    			connectionB = this.unionObject.find(gridToNumber(row - 1, col));
    			
    			
    			if(isFull(row - 1,col)) {
    				
    				/**
    				 * Get the value of the top box and assign it to the newly opened space
    				 * 
    				 * unionObj.union(board[row - 1][col],board[row][col])
    				 * board[row][col] = board[row - 1][col]
    				 */
    	
    				this.unionObject.union(connectionA, connectionB);
    				this.board[row][col] = this.unionObject.find(connectionA);
    			}
    			
    			if(!isFull(row - 1,col)) {
    				
    				/**
    				 * Get the value of the top box and connect the objects.
    				 * unionObj.union(board[row - 1][col],board[row][col])
    				 */
    				
    				this.unionObject.union(connectionA, connectionB);
    			}
    			
    		}
    		
    		if(isOpen(row + 1,col)) {
    			System.out.println("Bottom");
    			
    			connectionB = this.unionObject.find(gridToNumber(row + 1,col));
    			
    			if(isFull(row + 1,col)) {
    				
    				/**
    				 * Get the value of the top box and assign it to the newly opened space. 
    				 * 
    				 * unionObj.union(board[row + 1][col],board[row][col])
    				 * board[row][col] = board[row + 1][col]
    				 */
    				this.unionObject.union(connectionA, connectionB);
    				this.board[row][col] = this.unionObject.find(connectionA);
    				
    			}
    			
    			if(!isFull(row + 1,col)) {
    				/**
    				 * get the value of the top box and connect the two.
    				 * 
    				 * unionObj.union(board[row + 1][col],board[row][col])
    				 * 
    				 */
    				this.unionObject.union(connectionA, connectionB);
    				
    				
    				
    					
    				
    			}
    			
    		}
    		
    		if(isOpen(row,col - 1)) {
    			System.out.println("Left");
    			connectionB = this.unionObject.find(gridToNumber(row,col - 1));
    			
    			if(isFull(row,col - 1)) {
    				
    				/**
    				 * get the value of the left box and assign it to the newly opened box.
    				 * 
    				 * 
    				 * unionObj.union(board[row][col - 1],board[row][col])
    				 * board[row][col] = board[row][col - 1]
    				 * 
    				 */
    				
    				
    				this.unionObject.union(connectionA, connectionB);
    				this.board[row][col] = this.unionObject.find(connectionA);
    				
    			}
    			
    			if(!isFull(row,col - 1)) {
    				
    				
    				/**
    				 * get the value of the left box and connect it to the newly opened box.
    				 * 
    				 * unionObj.union(board[row][col - 1],board[row][col])
    				 */
    				
    				this.unionObject.union(connectionA, connectionB);
    			
    			}
    			
    		}
    		
    		if(isOpen(row,col + 1)) {
    			System.out.println("Right");
    			
    			connectionB = this.unionObject.find(gridToNumber(row,col + 1));
    			
    			if(isFull(row,col + 1)) {
    				
    				/**
    				 * get the value of the right box and assign to the newly opened box.
    				 * 
    				 * unionObj.union(board[row][col + 1],board[row][col])
    				 * board[row][col] = board[row][col + 1]  
    				 * 
    				 */
    				this.unionObject.union(connectionA, connectionB);
    				this.board[row][col] = this.unionObject.find(connectionA);
    				
    			}
    			
    			if(!isFull(row,col + 1)) {
    				
    				/**
    				 * get the value of the left box and connect it to the newly opened box. 
    				 * 
    				 * unionObj.union(board[row][col + 1],board[row][col])
    				 */
    				this.unionObject.union(connectionA, connectionB);
    				
    			}
    			
    		}
    		
    		
    		
    	}
    	

    	
//    	System.out.println("Connection A: " + connectionA);
//    	System.out.println("Connection B: " + connectionB);
    	
    	
    	
    	//Final Assingment
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	System.out.println("Count: " + this.unionObject.count());
    	
    	susOut();
    	openSites++;
    	
    }
    
    private void susOut() {
    	
    	
    	for(int runner = 0; runner < this.weightedQuickUnionLength; runner++) {
    		System.out.println("Value of " + runner + " : " + this.unionObject.find(runner));
    	}
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
    	
    	return (this.unionObject.find(gridToNumber(row, col)) == this.unionObject.find((weightedQuickUnionLength - 2)));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return this.openSites;
    }

    // does the system percolate?
    public boolean percolates() {
    	
    	return (this.unionObject.find(weightedQuickUnionLength - 1) == this.unionObject.find(weightedQuickUnionLength - 2));
    	
    }

    // test client (optional)
    public static void main(String[] args) {
    	//Percolation x = new Percolation(5);
    }
}
