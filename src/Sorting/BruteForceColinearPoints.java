package Sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import basicDataStructures.StdIn;

public class BruteForceColinearPoints {
	
	Point[] pointArray;
	double[][] slopeArray;
	
	ArrayList<LineSegment> lines = new ArrayList<LineSegment>();
	ArrayList<LineSegment> arrayOfSegments = new ArrayList<LineSegment>();
	
	
	
	public BruteForceColinearPoints(Point[] array) {
		
		//Initialize Object variables to use for calculations.
		this.pointArray = array;
		int size = array.length;
		this.slopeArray = new double[size][size];
		
		
		Point starter = null;
		

		//Nested loop to allow for the population of the slopeArray wich is a 2D array of all the slopes the 
		//points make against each other.
		for(int index = 0; index < pointArray.length ;index++) {
			
			starter = pointArray[index];
			
			for(int arrayRunner = 0; arrayRunner < pointArray.length;arrayRunner++) {
				
				
				System.out.print("S: "+ starter.slopeTo(pointArray[arrayRunner]) + " ");
				this.slopeArray[index][arrayRunner] = starter.slopeTo(pointArray[arrayRunner]);
				
				
				pointArray[index].draw();
				pointArray[arrayRunner].draw();						 
			}
			
			System.out.println();
			System.out.println("****************");
			
		}
		
		
		/*
		 * We now search the slopeArray 2D array to find the colinear points in the array.
		 * 
		 * 1) The first for loop will run through the points as the main multiplier or row starting from
		 * 	  the pointArray[0] --> pointArray[x]
		 * 
		 * 2) the second for loop will run through the points as the secondary multiplier or column starting form
		 * 	  the pointArray[X] --> pointArray[y]
		 * 
		 * 3) If the current element in the column loop is equal to 0 print out the current Slope will be used for something
		 *    later.
		 * 
		 * 4) If the current element in the column loop is equal to 1 make the prior slope equal to the slope at slopeArray[0].
		 * 
		 * 5) This is the internal loop that will check each row for similar slopes currently if the prior slope and current slope
		 * 	  are equal then it will increment the loop
		 * 	  
		 * */
		
		
		double forwardSlope = 1;
		double currentSlope = 0;
		
		int vector = 0;
		int streakCounter = 0;
		
		int outerRow = 0;
		int outerColumn = 0;
		Point po;
		
//		try {
		// (1)(1)(1)(1)
		for(int row = 0; row < slopeArray.length;row++) {

			currentSlope = slopeArray[row][0];
			
			outerRow = row;
			
			// (2)(2)(2)(2)
			for(int column = 0; column < slopeArray.length;column++) {
				
				
				// (3)(3)(3)(3)
				if(column == 0) {
					//System.out.println("Starter Slope: " + currentSlope);
					
					
					forwardSlope = slopeArray[row][column + 1];
					
				// (4)(4)(4)(4)	
				}else if(column >= 1) {
					
					if(column == 1) {
						forwardSlope = slopeArray[row][column + 1];
						currentSlope = slopeArray[row][column];

					}
					
					
					
					vector = (column + 1);
					
					outerColumn = column;
					currentSlope = slopeArray[row][column];
					
					if(vector == slopeArray.length) {
						break;
					}else {
						forwardSlope = slopeArray[row][vector];
					}
					
					
					// (5)(5)(5)(5)
					for(int runner = column;currentSlope == forwardSlope && currentSlope != 0 && currentSlope != Double.POSITIVE_INFINITY;runner++) {
						
							
						
							//System.out.println("Same: " + currentSlope);
						
							if(runner < slopeArray.length) {
								streakCounter++;
								if(Double.isNaN(slopeArray[row][runner])) {
									//vector++;
									runner++;
									break;
								}
							
							//if(runner != column)
							vector++;
							
							if(vector == slopeArray.length){
								break;
							}else {
								forwardSlope = slopeArray[row][vector];
							}
							
							//currentSlope = slopeArray[row][runner];
//							System.out.println("First Point" + pointArray[row]);
//							System.out.println("Second Point" + pointArray[runner]);
//							System.out.println(currentSlope);
							
							lines.add(new LineSegment(pointArray[row],pointArray[runner]));
								
								
							}else{
								break;
							}
						
					}
					

					
					column += streakCounter;
					row += streakCounter;
					
					streakCounter = 0;
					
				}


				if(row >= slopeArray.length) {
					break;
				}
				
				
				//System.out.println(slopeArray[row][column]);
				
			}
			
			//System.out.println("------");
			//System.out.println();
		}
		
//		}
//		
//		catch(Exception x) {
//			System.out.println("Row" + outerRow);
//			System.out.println("Column" + outerColumn);
//			System.out.println(x);
//		}
		
	
		
		System.out.println();
		
		for(LineSegment run: lines) {
			System.out.println(run);
			run.draw();
		}
		
	}
	
	public void oldMethod(Point[] array) {
		
		this.pointArray = array;
		
		
		//Slope counter variables
		double previousSlope = 0;
		int pointStreakCounter = 0;
		
		Point starter = null;
		Point ender = null;
		
		
		for(int index = 0; index < pointArray.length - 3; index++) {
			for(int movement = index + 1; movement < pointArray.length ; movement++) {
				
				//Capture the previous slope if its the first time.
				if(pointStreakCounter == 0) {
					previousSlope = pointArray[index].slopeTo(pointArray[movement]);
				}
				
				System.out.println("Comapre: " + pointArray[index] + " to " + pointArray[movement]);
				System.out.println(pointArray[index].slopeTo(pointArray[movement]));
				
				
				pointArray[index].draw();
				pointArray[movement].draw();
				
				
				
				
				//Compare the current slope value to the previous slope value to see if you have colinear points.
				if(previousSlope == pointArray[index].slopeTo(pointArray[movement])) {
				
//				for(int slopeChecker = 0; slopeChecker < index; slopeChecker++) {
//					for(int slopeMovement = slopeChecker + 1; slopeMovement < movement ; slopeMovement++) {
//						
//						if(pointArray[slopeChecker].slopeTo(pointArray[slopeMovement])==pointArray[index].slopeTo(pointArray[movement])) {
//							found = true;
//							// Remove break for coloring
//							break;
//						}else {
//							found = false;
//						}
//					}
//				}
//				
//				if(found) {
					
					
					//If this is the first point that shares same slope.
					if(pointStreakCounter == 0) {
						
						System.out.println("Potential First Line: ");
						System.out.println(pointArray[index]);
						
						starter = pointArray[index];
					}
					
					
					
					
					pointStreakCounter++;
					arrayOfSegments.add(new LineSegment(pointArray[index],pointArray[movement]));
					
					
					if(pointStreakCounter == 3) {
						
						// Must sort the arrayOfSegments before anything else.
						System.out.println("HIT ADD TO THE LINESEGMENT COLLECTION");
						
						
						for(LineSegment x: arrayOfSegments) {
							lines.add(x);
						}
						
					
						
					}else if(pointStreakCounter >= 3) {
						
//						if(-1 >= pointArray[movement].compareTo(starter)) {
//							System.out.println("TEst");
//						}
						
						
						
						lines.add(new LineSegment(pointArray[index],pointArray[movement]));
					}
				
				//Compare the current slope value to the previous slope value to see if you have colinear points.
				}else{
					
					//Consider jumping in the line					
					index += pointStreakCounter;
					
					if(pointStreakCounter > 3) {
						int holder = lines.size() - 1;
						ender = lines.get(holder).getQ();
						
						

						System.out.println();
						System.out.println("STREAK BROKEN!");
						System.out.println("Starter: " + starter.toString());
						System.out.println("Ender: " + ender.toString());
						System.out.println("STREAK BROKEN!");
						System.out.println();
					}
					
					arrayOfSegments.removeAll(arrayOfSegments);
					previousSlope = pointArray[index].slopeTo(pointArray[movement]);
					pointStreakCounter = 0;
					break;
				}
				
				continue;
				
				
				
			}
			
			
			
						
			System.out.println();

		}
		
		
		for(LineSegment x: lines) {
			System.out.println(x);
			x.draw();
		}
		
	}

	
	public static void main(String[] args) {
		
		Point[] pointsArray = new Point[10];
		
//		ArrayList<Point> list = new ArrayList<Point>();
		
		//Basic Straight Line Testing.
//		pointsArray[0] = new Point(0,0);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(2,2);
//		pointsArray[3] = new Point(3,3);
//		pointsArray[4] = new Point(4,4);
//		pointsArray[5] = new Point(5,5);
//		pointsArray[6] = new Point(6,6);
//		pointsArray[7] = new Point(7,7);
//		pointsArray[8] = new Point(8,8);
//		pointsArray[9] = new Point(9,9);
		
//		Extended Line Testing.
//		pointsArray[0] = new Point(0,0);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(2,2);
//		pointsArray[3] = new Point(3,3);
//		pointsArray[4] = new Point(4,4);
//		pointsArray[5] = new Point(5,5);
//		pointsArray[6] = new Point(10,10);
//		pointsArray[7] = new Point(20,20);
//		pointsArray[8] = new Point(30,30);
//		pointsArray[9] = new Point(40,40);
		
//		Two Line Positive Slope	
//		pointsArray[0] = new Point(0,0);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(2,2);
//		pointsArray[3] = new Point(3,3);
//		pointsArray[4] = new Point(4,4);
//		pointsArray[5] = new Point(5,10);
//		pointsArray[6] = new Point(6,12);
//		pointsArray[7] = new Point(7,14);
//		pointsArray[8] = new Point(8,16);
//		pointsArray[9] = new Point(9,18);

		//Two Lines Positive Negative slope
//		pointsArray[0] = new Point(0,0);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(2,2);
//		pointsArray[3] = new Point(3,3);
//		pointsArray[4] = new Point(4,4);
//		pointsArray[5] = new Point(10,6);
//		pointsArray[6] = new Point(9,7);
//		pointsArray[7] = new Point(8,8);
//		pointsArray[8] = new Point(7,9);
//		pointsArray[9] = new Point(6,10);
		
		
		pointsArray[0] = new Point(0,10);
		pointsArray[1] = new Point(1,9);
		pointsArray[2] = new Point(2,8);
		pointsArray[3] = new Point(3,7);
		pointsArray[4] = new Point(4,6);
		pointsArray[5] = new Point(5,5);
		pointsArray[6] = new Point(6,7);
		pointsArray[7] = new Point(7,14);
		pointsArray[8] = new Point(8,16);
		pointsArray[9] = new Point(9,18);
		
		//Two Line Similar point testing.
//		pointsArray[0] = new Point(1,2);
//		pointsArray[1] = new Point(2,4);
//		pointsArray[2] = new Point(3,6);
//		pointsArray[3] = new Point(4,8);
//		pointsArray[4] = new Point(5,10);
//		pointsArray[5] = new Point(2,6);
//		pointsArray[6] = new Point(3,9);
//		pointsArray[7] = new Point(4,12);
//		pointsArray[8] = new Point(5,15);
//		pointsArray[9] = new Point(6,18);

		

		
		
		//One Line Unique point testing.
//		pointsArray[0] = new Point(2,2);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(0,0);
//		pointsArray[3] = new Point(4,4);
//		pointsArray[4] = new Point(7,5);
//		pointsArray[5] = new Point(9,2);
//		pointsArray[6] = new Point(6,11);
//		pointsArray[7] = new Point(3,6);
//		pointsArray[8] = new Point(7,9);
//		pointsArray[9] = new Point(12,18);
		
//		pointsArray[0] = new Point(2,2);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(0,0);
//		pointsArray[3] = new Point(7,3);
//		pointsArray[4] = new Point(8,4);
//		pointsArray[5] = new Point(9,0);
//		pointsArray[6] = new Point(10,1);
//		pointsArray[7] = new Point(11,2);
//		pointsArray[8] = new Point(12,3);
//		pointsArray[9] = new Point(10,2);
//		
		
		//InsertionSort.sort(pointsArray);
		
		//Shotgun testing
//		int max = 20;
//		int min = 1;
//		
//		for(int runner = 0; runner < 10; runner++) {
//			pointsArray[runner] = new Point((int)(Math.random() * ((max - min) + 1)) + min,(int)(Math.random() * ((max - min) + 1)) + min);
//			//System.out.println(pointsArray[runner].toString());
//		}
		
		
		
		
		
//		list.add(new Point(1,2));
//		list.add(new Point(2,4));
//		list.add(new Point(3,6));
//		list.add(new Point(4,8));
//		list.add(new Point(5,10));
//		list.add(new Point(6,12));
//		list.add(new Point(7,14));
		
		//Point[] pointsList = (Point[]) list.toArray(); 
		
		
		//BruteForceColinearPoints x = new BruteForceColinearPoints(pointsArray);
		
		// read the n points from a file

		BruteForceColinearPoints x = new BruteForceColinearPoints(pointsArray);
	}

}
