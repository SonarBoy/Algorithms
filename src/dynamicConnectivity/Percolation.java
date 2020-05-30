package dynamicConnectivity;

public class Percolation {

	int board[][];
	int uniqueValueList[];
	int openSites;
	
	
	//Timing Methods:
	long start;
	long finish;
	long timeElapsed;
	
	public Percolation(int sides) {
		
		start = System.nanoTime();
		
		sides += 1;
		openSites = 0;
		
		board = new int[sides][sides];
		uniqueValueList = new int[(sides - 1) * (sides - 1) + 2];
		uniqueValueList[0] = 0;
		
		int counter = 1;
	
		
		
		for(int runner = 1; runner < sides; runner++) {
			for(int secondRunner = 1; secondRunner < sides; secondRunner++) {
				board[runner][secondRunner] = -1;
				
				
				if(counter != 0 && counter <= sides) {
					
					//Will put back later
					//uniqueValueList[counter] = counter;
					
					uniqueValueList[counter] = 0;
				}else if(counter > (sides * (sides - 1))) {
					uniqueValueList[counter] = (sides * sides);
				}else {
				
					uniqueValueList[counter] = counter;
				}
				
				
				counter++;
			}
		}
		
		
		
		
		uniqueValueList[counter] = counter ;
	    
        finish = System.nanoTime();
        timeElapsed = finish - start;
        
        
        System.out.println(sides);
        System.out.println(timeElapsed);
		
		
	}
	
	//VISUAL SENSE
	public void openWithSection(int row, int col) {
		
		start = System.nanoTime();
		
		board[row][col] = 0;
		int leng = board.length - 1;
		
		
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
			
			//First Mathematical instinct was right but did not work because the ro
			//board[row][col] = (row * col) + ((col - 1)*(board.length - row - 1));
			
		}
		
		openSites++;
		
		
		finish = System.nanoTime();
	    timeElapsed = finish - start;
	       
	    System.out.println("With Section Elapsed Time: "+timeElapsed);
		
		return;
	}
	
	
	//FASTER
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
				
			}
			
			if(isOpen(row ,col +1)) {
				
				//System.out.println("East: " + uniqueValueList[((leng*(row - 1)) + (col + 1))]);
				this.union(row,col,row,col+1,leng);
				
			}
			
			//Assingment to 0
			
			
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
	
	
	
	public int rootWithList(int value) {
		
		while(value != uniqueValueList[value]){
			value = uniqueValueList[value];
		}
		
		return value;
	}
	
	public void union(int x1,int y1, int x2, int y2, int length) {
		int firstValue = rootWithList(uniqueValueList[((length * (x1 - 1)) + y1)]);
		int secondValue = rootWithList(uniqueValueList[((length * (x2 - 1)) + y2)]);
		
		if(firstValue > secondValue) {
			uniqueValueList[firstValue] = secondValue;
		}else if(secondValue > firstValue) {
			uniqueValueList[secondValue] = firstValue;
		}else {
			uniqueValueList[firstValue] = secondValue;
		}
		
		
		
		
		System.out.println("Joining Value: " + firstValue + " with " + secondValue);
	}
	
	/*
	public void union(int first, int second) {
		int rootP = root(first);
		int rootQ = root(second);
		
		  if (rootP == rootQ) return;

	       // Weighted portion of the union adding the shorter tree
		   //below the taller one
	        if (size[rootP] < size[rootQ]) {
	        	
	        	System.out.println(size[rootP] +" is less than "+size[rootQ]);
	        	
	            list[rootP] = rootQ;
	            size[rootQ] += size[rootP];
	        }
	        else {
	        	
	        	System.out.println(size[rootP] +" is greater than "+size[rootQ]);
	        	
	            list[rootQ] = rootP;
	            size[rootP] += size[rootQ];
	        }
	        count--;
	}
	
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
	
	public int numberOfOpenSites() {
		return openSites;
	}
	
	public void printOut() {
		
		int sides = board.length;
		
		for(int runner = 1; runner < sides; runner++) {
			for(int secondRunner = 1; secondRunner < sides; secondRunner++) {
				System.out.print(board[runner][secondRunner] + " ");
			}
			
			System.out.println();
		}
	}
	
	public void printOutUniqueValueList(){
		for(int runner = 0;runner < uniqueValueList.length;runner++) {
			System.out.println("Index: "+ runner+ " : "+uniqueValueList[runner] + " ");
		}
	}
	
	
	
	public static void main(String []args) {
		
		Percolation tester = new Percolation(5);
		
		tester.printOut();
		
	
	
		
		
		System.out.println();
		
		tester.printOut();
		
		System.out.println();
		
	
	
		
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
		
		System.out.println();
		
		
		
		
		
	
		
		//tester.union(1, 1, 2, 1, 5);
		//tester.union(3, 3, 2, 3, 4);
		//tester.union(4, 1, 4, 2, 4);
		
		tester.printOutUniqueValueList();
		tester.printOut();
		
	}
	//public boolean percolates();
	
	
}
