package elementary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import edu.princeton.cs.algs4.Queue;


public class Board {

	int[][] goalBoard;
	int[][] gameBoard;
	int side;
	int sideForCalc;

	// create a board from an n-by-n array of tiles,
	// where tiles[row][col] = tile at (row, col)
	public Board(int[][] tiles) {

		gameBoard = tiles;
		side = tiles[0].length;
		sideForCalc = side - 1;
//    	System.out.println("Regular Side Length: " + side);
//    	System.out.println("Calc Side Length: " + sideForCalc);

//		goalBoard = new int[side][side];
//
//		for (int runner = 1; runner < side; runner++) {
//			for (int runnerTwo = 1; runnerTwo < side; runnerTwo++) {
//
//				if (runner == (side - 1) && runnerTwo == (side - 1)) {
//					goalBoard[runner][runnerTwo] = 0;
//				} else {
//					goalBoard[runner][runnerTwo] = ((side - 1) * (runner - 1) + runnerTwo);
//				}
//
//			}
//		}

	}

	private int[] numberToCoordinates(int number) {

		int column;
		int row;

		int[] coordinates = new int[2];

		if (number == 0) {
			column = this.sideForCalc;
			row = this.sideForCalc;
			coordinates[0] = row;
			coordinates[1] = column;

			// System.out.println("Row: " + row + " Column: "+ column);

			return coordinates;
		}

		if (number % this.sideForCalc == 0) {

			column = this.sideForCalc;
			row = number / this.sideForCalc;

			coordinates[0] = row;
			coordinates[1] = column;

			// System.out.println("Row: " + row + " Column: "+ column);

			return coordinates;

		} else {

			column = number % this.sideForCalc;
			coordinates[1] = column;

		}

		row = number / this.sideForCalc + 1;
		coordinates[0] = row;

		// System.out.println("Row: " + coordinates[0] + " Column: "+ coordinates[1]);

		return coordinates;
	}

	private int[][] copy(int[][] board) {

		int[][] copyOfBoard = new int[side][side];
		for (int runner = 1; runner < side; runner++) {
			for (int runnerTwo = 1; runnerTwo < side; runnerTwo++) {

				copyOfBoard[runner][runnerTwo] = gameBoard[runner][runnerTwo];

			}
		}

		return copyOfBoard;
	}

	private void swap(int initialRow, int initialCol, int swapRow, int swapCol, int[][] board) {

		int holder = board[swapRow][swapCol];
		board[swapRow][swapCol] = 0;
		board[initialRow][initialCol] = holder;
	}

	// string representation of this board
	public String toString() {

		StringBuilder s = new StringBuilder();
		s.append(this.side - 1 + "\n");
		for (int runner = 1; runner < side; runner++) {
			for (int runnerTwo = 1; runnerTwo < side; runnerTwo++) {
				s.append(String.format("%2d ", gameBoard[runner][runnerTwo]));
			}
			s.append("\n");
		}

		return s.toString();

	}

	// board dimension n
	public int dimension() {
		return this.sideForCalc;
	}

	// number of tiles out of place
	public int hamming() {

		int[] coordinates = null;
		int totalOutPlace = 0;

		for (int runner = 1; runner < side; runner++) {
			for (int runnerTwo = 1; runnerTwo < side; runnerTwo++) {

				if (gameBoard[runner][runnerTwo] != 0) {

					coordinates = numberToCoordinates(gameBoard[runner][runnerTwo]);

					if (coordinates[0] != runner || coordinates[1] != runnerTwo) {
						totalOutPlace++;
					}

				}

				// totalInPlace = Math.abs(Math.abs(coordinates[0] - runner) +
				// Math.abs(coordinates[1] - runnerTwo));

			}

		}

		// System.out.println("Total Out of place: " + totalOutPlace);

		return totalOutPlace;
	}

	// sum of Manhattan distances between tiles and goal
	public int manhattan() {

		int[] coordinates = null;
		int totalDistance = 0;

		for (int runner = 1; runner < side; runner++) {
			for (int runnerTwo = 1; runnerTwo < side; runnerTwo++) {
				// System.out.println(gameBoard[runner][runnerTwo] + " \n" + "Coordnates: " );
				if (gameBoard[runner][runnerTwo] != 0) {
					coordinates = numberToCoordinates(gameBoard[runner][runnerTwo]);
					totalDistance += Math.abs(Math.abs(coordinates[0] - runner) + Math.abs(coordinates[1] - runnerTwo));
				}

//        		System.out.println("Distance: " + Math.abs(Math.abs(coordinates[0] - runner) + Math.abs(coordinates[1] - runnerTwo)));
//        		System.out.println();
			}

		}

		return totalDistance;
	}

	// is this board the goal board?
	public boolean isGoal() {
		// Arrays.deepEquals(this.gameBoard,this.goalBoard);
		return Arrays.deepEquals(this.gameBoard, this.goalBoard);
	}

	// does this board equal y?
	public boolean equals(Object y) {

		Board toCompare = (Board) y;

		return this.toString().equals(toCompare.toString());

	}

	// all neighboring boards
	public Iterable<Board> neighbors() {

		int row = 0;
		int col = 0;
		int totalDistance = 0;

		for (int runner = 1; runner < side; runner++) {
			for (int runnerTwo = 1; runnerTwo < side; runnerTwo++) {

				if (gameBoard[runner][runnerTwo] == 0) {

					row = runner;
					col = runnerTwo;

				}

				if (row != 0 || col != 0) {
					break;
				}
			}

			if (row != 0 || col != 0) {
				break;
			}
		}

		Queue<Board> neighbours = new Queue<Board>();
		
		// * *
		// *
		if (row == 1 && col == 1) {
			
			int[][] test1 = copy(this.gameBoard);
			swap(row, col, row, col + 1, test1);
    		

			int[][] test2 = copy(this.gameBoard);
			swap(row, col, row + 1, col, test2);
			
			neighbours.enqueue(new Board(test1));
			neighbours.enqueue(new Board(test2));
			return neighbours;
		}

		
		// * *
		// 	 * 
		if (row == 1 && col == this.sideForCalc) {
			
			int[][] test1 = copy(this.gameBoard);
			swap(row, col, row, col - 1, test1);
			
			int[][] test2 = copy(this.gameBoard);
			swap(row, col, row + 1, col, test1);
			
			
			neighbours.enqueue(new Board(test1));
			neighbours.enqueue(new Board(test2));
			return neighbours;
			
		}

		// *
		// * *

		if (row == this.sideForCalc && col == 1) {
			
			int[][] test1 = copy(this.gameBoard);
			swap(row, col, row - 1, col , test1);
			
			
			int[][] test2 = copy(this.gameBoard);
			swap(row, col, row, col + 1, test2);
			
			
			neighbours.enqueue(new Board(test1));
			neighbours.enqueue(new Board(test2));
			return neighbours;
		}

		//   * 
		// * *

		if (row == this.sideForCalc && col == this.sideForCalc) {
			
			int[][] test1 = copy(this.gameBoard);
			swap(row, col, row - 1, col, test1);
			
			int[][] test2 = copy(this.gameBoard);
			swap(row, col, row, col - 1, test2);
			
			neighbours.enqueue(new Board(test1));
			neighbours.enqueue(new Board(test2));
			return neighbours;
		}

		// * * *
		//   *

		if (row == 1 && (col > 1 && col < this.sideForCalc)) {
			
			int[][] test1 = copy(this.gameBoard);
			swap(row, col, row, col - 1, test1);
			
			int[][] test2 = copy(this.gameBoard);
			swap(row, col, row, col + 1 , test2);
			
			int[][] test3 = copy(this.gameBoard);
			swap(row, col, row + 1, col , test3);
			
			neighbours.enqueue(new Board(test1));
			neighbours.enqueue(new Board(test2));
			neighbours.enqueue(new Board(test3));
			return neighbours;
		}

		// *
		// * *
		// *

		if ((row > 1 && row < this.sideForCalc) && col == 1) {
			
			int[][] test1 = copy(this.gameBoard);
			swap(row, col, row + 1, col , test1);
			
			int[][] test2 = copy(this.gameBoard);
			swap(row, col, row - 1, col , test2);
			
			int[][] test3 = copy(this.gameBoard);
			swap(row, col, row , col + 1, test3);
			
			neighbours.enqueue(new Board(test1));
			neighbours.enqueue(new Board(test2));
			neighbours.enqueue(new Board(test3));
			return neighbours;
		}

		//   *
		// * *
		//   *

		if ((row > 1 && row < this.sideForCalc) && col == this.sideForCalc) {
			
			int[][] test1 = copy(this.gameBoard);
			swap(row, col, row + 1, col , test1);
			
			int[][] test2 = copy(this.gameBoard);
			swap(row, col, row - 1, col  , test2);
			
			int[][] test3 = copy(this.gameBoard);
			swap(row, col, row , col - 1, test3);
			
			neighbours.enqueue(new Board(test1));
			neighbours.enqueue(new Board(test2));
			neighbours.enqueue(new Board(test3));
			return neighbours;
		}

		//   *
		// * * *

		if (row == this.sideForCalc && (col > 1 && col < this.sideForCalc)) {
			
			
			int[][] test1 = copy(this.gameBoard);
			swap(row, col, row - 1, col , test1);
			
			int[][] test2 = copy(this.gameBoard);
			swap(row, col, row, col + 1 , test2);
			
			int[][] test3 = copy(this.gameBoard);
			swap(row, col, row , col - 1, test3);
			
			neighbours.enqueue(new Board(test1));
			neighbours.enqueue(new Board(test2));
			neighbours.enqueue(new Board(test3));
			return neighbours;
		}
		
		
		int[][] test1 = copy(this.gameBoard);
		swap(row, col, row - 1, col , test1);
		
		int[][] test2 = copy(this.gameBoard);
		swap(row, col, row, col + 1 , test2);
		
		int[][] test3 = copy(this.gameBoard);
		swap(row, col, row , col - 1, test3);
		
		int[][] test4 = copy(this.gameBoard);
		swap(row, col, row - 1, col , test4);

		
		neighbours.enqueue(new Board(test1));
		neighbours.enqueue(new Board(test2));
		neighbours.enqueue(new Board(test3));
		neighbours.enqueue(new Board(test4));
		return neighbours;
	}

	// a board that is obtained by exchanging any pair of tiles
	public Board twin() {
		
		boolean twinCreated = false;
		int [][] board = copy(this.gameBoard);
		
		
		for(int runner = 1;!twinCreated && runner < side;runner++) {
			if(board[runner][1] != 0 && board[runner][2] != 0) {
				
				int holder = board[runner][1];
				board[runner][1] = board[runner][2];
				board[runner][2] = holder;
				
				twinCreated = true;
			}
			
		}
		
		
		return new Board(board);
	}

	// unit testing (not graded)
	public static void main(String[] args) {

		int leng;

		try {

			File f = new File("C:\\Users\\Reginald\\eclipse-workspace\\DataAlgo\\src\\elementary\\gameBoard3x3.txt");
			Scanner scan = new Scanner(f);

			int charater = 0;

			leng = scan.nextInt() + 1;

			int[][] board = new int[leng][leng];

			for (int runner = 1; runner < leng; runner++) {
				for (int runnerTwo = 1; runnerTwo < leng; runnerTwo++) {
					board[runner][runnerTwo] = scan.nextInt();
				}
			}

			Board x = new Board(board);

			System.out.println(x.toString());

			System.out.println("Total Manhattan Distance: " + x.manhattan());
			System.out.println("Total Hamming: " + x.hamming());

			Queue<Board> queue = (Queue<Board>) x.neighbors();
			
			Iterator iter = queue.iterator();
			while(iter.hasNext()) {
				System.out.println(iter.next().toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}