package Sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import basicDataStructures.StdDraw;
import basicDataStructures.StdIn;
import basicDataStructures.StdOut;

public class BruteForceColinearPoints {
	
	Point[] pointArray;
	double[][] slopeArray;
	
	ArrayList<LineSegment> lines = new ArrayList<LineSegment>();
	ArrayList<Point> arrayOfSegments = new ArrayList<Point>();
	
	
	
	public BruteForceColinearPoints(Point[] array) {
		
		
		this.pointArray = array;
		int size = array.length;
		
		Point first = null;
		Point second = null;
		Point third = null;
		Point fourth = null;
		
		double slopeA = 0;
		double slopeB = 0;
		double slopeC = 0;

		double previousTotal = 0;
		
		Point[] subber = new Point[4];
		
		for(int firstPoint = 0; firstPoint < size - 3;firstPoint++) {
			for(int secondPoint = 1;secondPoint < size - 2;secondPoint++) {
				for(int thirdPoint = 2;thirdPoint < size - 1;thirdPoint++) {
					for(int fourthPoint = 3;fourthPoint < size;fourthPoint++) {
						first = pointArray[firstPoint];
						second = pointArray[secondPoint];
						third = pointArray[thirdPoint];
						fourth = pointArray[fourthPoint];
						
						slopeA = first.slopeTo(second);
						slopeB = first.slopeTo(third);
						slopeC = first.slopeTo(fourth);
						
						if(slopeA != slopeB) {
							break;
						}
						
						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC && 
							first != second && first != third && first != fourth && second != third && second != fourth && third != fourth	
								) {
//							System.out.println("First Point: " + first.toString());
//							System.out.println("Second Point: " + second.toString());
//							System.out.println("Third Point: " + third.toString());
//							System.out.println("Fourth Point: " + fourth.toString());
							
							
//							if(first.getPointX() + second.getPointX() + third.getPointX() + fourth.getPointX() == previousTotal)
//								break;
							
							subber[0] = first;
							subber[1] = second;
							subber[2] = third;		
							subber[3] = fourth;
							
							
							
//							arrayOfSegments.add(first);
//							arrayOfSegments.add(second);
//							arrayOfSegments.add(third);
//							arrayOfSegments.add(fourth);
							
							//Collections.sort(arrayOfSegments);
							InsertionSort.sort(subber);
							
							//lines.add(new LineSegment(arrayOfSegments.get(0),arrayOfSegments.get(arrayOfSegments.size() - 1)));
							lines.add(new LineSegment(subber[0],subber[3]));
							
							//previousTotal = first.getPointX() + second.getPointX() + third.getPointX() + fourth.getPointX();
	
						}
						
						
					}
				}
			}
		}
		

		
	}
	
	
	public LineSegment[] segments() {
		
		LineSegment[] lineList = null;
		
		 lineList = this.lines.toArray(new LineSegment[lines.size()]);
		return lineList;
	}
	
	
	public void anotherIncorrectMethod(Point[]array) {
		//Initialize Object variables to use for calculations.
				this.pointArray = array;
				int size = array.length;
				
				
				
				Point starter = null;
				
				Point first = null;
				Point second = null;
				Point third = null;
				Point fourth = null;
				
				double slopeA = 0;
				double slopeB = 0;
				double slopeC = 0;
				
				Point[] subber = new Point[4];
				
				for(int pointRunner = 0; (pointRunner + 4) <= pointArray.length;pointRunner++ ) {
					
					first = pointArray[pointRunner];
					second = pointArray[pointRunner + 1];
					third = pointArray[pointRunner + 2];
					fourth = pointArray[pointRunner + 3];
					
					
					slopeA = first.slopeTo(second);
					slopeB = first.slopeTo(third);
					slopeC = first.slopeTo(fourth);
					
					
					subber[0] = first;
					subber[1] = second;
					subber[2] = third;
					subber[3] = fourth;
					
					Arrays.sort(subber);
					
					first.draw();
					
					if((pointRunner + 4) == pointArray.length) {
						second.draw();
						third.draw();
						fourth.draw();
					}
					
					if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
						System.out.println("Smallest: " + subber[0]);
						System.out.println("Greatest: " + subber[3]);
						
						lines.add(new LineSegment(subber[0],subber[3]));

					}
					
					
				}
				
				
				//Print out everything in the line segmentvariable
				for(LineSegment run: lines) {
					System.out.println(run);
					run.draw();
				}
	}
	
//	public void OldMethodThree(Point[] array) {
//		
//		//Initialize Object variables to use for calculations.
//		this.pointArray = array;
//		int size = array.length;
//		this.slopeArray = new double[size][size];
//		
//		
//		Point starter = null;
//		
//
//		//Nested loop to allow for the population of the slopeArray wich is a 2D array of all the slopes the 
//		//points make against each other.
//		for(int row = 0; row < pointArray.length ;row++) {
//			
//			starter = pointArray[row];
//			System.out.println(starter.toString());
//			pointArray[row].draw();
//			
//			for(int column = 0; column < pointArray.length;column++) {
//				
//				//System.out.print("S: "+ starter.slopeTo(pointArray[column]) + " ");
//				this.slopeArray[row][column] = starter.slopeTo(pointArray[column]);
//
//			}
//			
//			//System.out.println();
//			//System.out.println("****************");
//			
//		}
//		
//		
//		/*
//		 * We now search the slopeArray 2D array to find the colinear points in the array.
//		 * 
//		 * 1) The first for loop will run through the points as the main multiplier or row starting from
//		 * 	  the pointArray[0] --> pointArray[x]
//		 * 
//		 * 2) the second for loop will run through the points as the secondary multiplier or column starting form
//		 * 	  the pointArray[X] --> pointArray[y]
//		 * 
//		 * 3) If the current element in the column loop is equal to 0 print out the current Slope will be used for something
//		 *    later.
//		 * 
//		 * 4) If the current element in the column loop is equal to 1 make the prior slope equal to the slope at slopeArray[0].
//		 * 
//		 * 5) This is the internal loop that will check each row for similar slopes currently if the prior slope and current slope
//		 * 	  are equal then it will increment the loop
//		 * 	  
//		 * */
//		
//		double currentSlope = 0;
//		double forwardSlope = 0;
//		
//		int forwardIndex = 0;
//		int streakCounter = 0;
//		Point anchorPoint = null;
//		
//		
//		
//		for(int row = 0; row < size;row++) {
//			
//			anchorPoint = this.pointArray[row];
//			currentSlope = slopeArray[row][0];
//			forwardSlope = slopeArray[row][1];
//			
//			for(int column = 0;column < size; column++) {
//				
//				if(column > 0) {
//					
//					currentSlope = slopeArray[row][column];
//					
//					forwardIndex = column + 1;
//					
//					if(forwardIndex > size - 1) {
//						break;
//					}else {
//						forwardSlope = slopeArray[row][forwardIndex];
//					}
//					
//				}
//				
//				//current or forward slope == NAN
//				if(Double.isNaN(currentSlope) || Double.isNaN(forwardSlope)) {
//					
//					
//					if(Double.isNaN(currentSlope)) {
//						
//						
//						System.out.println();
//						System.out.println("*****FAULT CURRENT SLOPE********");
//						
//						
//						if(column + 1 > size) {
//							break;
//						}else {
//							
//							column = column + 1;
//							currentSlope = slopeArray[row][column];
//							forwardIndex = column + 1;
//							
//							if(forwardIndex >= size) {
//								break;
//							}else {
//								forwardSlope = slopeArray[row][forwardIndex];
//							}
//							
//						}
//						
//						System.out.println("CurrentSlope: " + currentSlope + " Current Index: "+ column);
//						System.out.println("ForwardSlope: " + forwardSlope + " Forward Index: "+ forwardIndex);
//						System.out.println("*************");
//						System.out.println();
//					}
//					
//					if(Double.isNaN(forwardSlope)) {
//						
//						System.out.println();
//						System.out.println("*****FAULT FORWARD SLOPE********");
//												
//						if(forwardIndex + 1 > size) {
//							break;
//						}else {
//							
//							//column = forwardIndex;
//							forwardIndex = column + 1;
//							
//							if(forwardIndex >= size) {
//								break;
//							}else {
//								forwardSlope = slopeArray[row][forwardIndex];
//							}
//						}
//						
//						System.out.println("CurrentSlope: " + currentSlope + " Current Index: "+ column);
//						System.out.println("ForwardSlope: " + forwardSlope + " Current Index: "+ forwardIndex);
//						System.out.println("*************");
//						System.out.println();
//
//						
//					}
//					
//					//System.out.println(column);
//					
//					
//				}
//				
//				
//				for(int searchRunner = column; (currentSlope == forwardSlope) || Double.isNaN(currentSlope) || Double.isNaN(forwardSlope);
//						searchRunner++) {
//					
//					streakCounter++;
//					//column++;
//					
//					
//					if(Double.isNaN(currentSlope) || Double.isNaN(forwardSlope)) {
//						
//						
//						if(Double.isNaN(currentSlope)) {
//							
//							
//							System.out.println();
//							System.out.println("*****FAULT CURRENT SLOPE********");
//							
//							
//							if(column + 1 > size) {
//								break;
//							}else {
//								
//								column = column + 1;
//								currentSlope = slopeArray[row][column];
//								forwardIndex = column + 1;
//								
//								if(forwardIndex >= size) {
//									break;
//								}else {
//									forwardSlope = slopeArray[row][forwardIndex];
//								}
//								
//								break;
//							}
//							
////							System.out.println("CurrentSlope: " + currentSlope + " Current Index: "+ column);
////							System.out.println("ForwardSlope: " + forwardSlope + " Forward Index: "+ forwardIndex);
////							System.out.println("*************");
////							System.out.println();
//						}
//						
//						if(Double.isNaN(forwardSlope)) {
//							
//							System.out.println();
//							System.out.println("*****FAULT FORWARD SLOPE********");
//							
//							
//													
//							if(forwardIndex + 1 > size) {
//								break;
//							}else {
//								
//								//column = forwardIndex;
//								forwardIndex = column + 1;
//								
//								if(forwardIndex >= size) {
//									break;
//								}else {
//									forwardSlope = slopeArray[row][forwardIndex];
//								}
//								
//								break;
//							}
//							
////							System.out.println("CurrentSlope: " + currentSlope + " Current Index: "+ column);
////							System.out.println("ForwardSlope: " + forwardSlope + " Current Index: "+ forwardIndex);
////							System.out.println("*************");
////							System.out.println();
//
//							
//						}
//					}
//					
//					
//					
//					
//					if(forwardIndex == slopeArray.length || (forwardIndex + 1) == slopeArray.length){
//						break;
//					}else {
//						forwardSlope = slopeArray[row][forwardIndex];
//						forwardIndex++;
//					}
//					
//					
//					if(streakCounter <= 2) {
//						arrayOfSegments.add(new LineSegment(anchorPoint,pointArray[searchRunner]));
//					}else if(streakCounter == 3) {
//						
//						
//						
//						for(LineSegment x: arrayOfSegments) {
//							lines.add(x);
//						}
//						
//						lines.add(new LineSegment(anchorPoint,pointArray[searchRunner]));
//						
//					
//					}else if(streakCounter > 3){
//						lines.add(new LineSegment(anchorPoint,pointArray[searchRunner]));
//					}
//					
//					
//					
//					//lines.add(new LineSegment(anchorPoint,pointArray[searchRunner]));
//					
//					
//				}
//				
//				if(streakCounter > 2) {
//					
//					column += streakCounter;
//					row += streakCounter;
//					streakCounter = 0;
//					
//				}
//				arrayOfSegments.removeAll(arrayOfSegments);
//				
//				if(row >= slopeArray.length) {
//					break;
//				}
//				
////				System.out.println();
////				System.out.println("Row Point: " +this.pointArray[row].toString());
////				System.out.println("Anchor Point: " +this.pointArray[column].toString());
////				System.out.println("Comparing Point: " +this.pointArray[forwardIndex].toString());
////				System.out.println("Slope: " +this.slopeArray[row][column]);
//				
//				
//				
//				
//			}
//			
//			
//			
//			if(row >= slopeArray.length) {
//				break;
//			}
//			
//			System.out.println();
//			
//			forwardIndex = row;
//		}
//		
//		
//		
//		
//		
////		double forwardSlope = 1;
////		double currentSlope = 0;
////		
////		int vector = 0;
////		int streakCounter = 0;
////		
////		//TODO Getting it down to just the minor and major points
////		Point currentSmallestPoint;
////		Point currentLargestPoint;
////		
////		
////		try {
////			// (1)(1)(1)(1)
////			for(int row = 0; row < slopeArray.length;row++) {
////	
////				currentSlope = slopeArray[row][0];
////			
////				// (2)(2)(2)(2)
////				for(int column = 0; column < slopeArray.length;column++) {
////					
////					// (3)(3)(3)(3)
////					//if(column == 0) {		
////						//forwardSlope = slopeArray[row][column + 1];
////						
////					// (4)(4)(4)(4)	
////					//}else if(column >= 1) {
////						
////						if(column == 1) {
////							forwardSlope = slopeArray[row][column + 1];
////							currentSlope = slopeArray[row][column];
////						}
////							//Assign the current and forward slopes to be insepcted
////							vector = (column + 1);
////							currentSlope = slopeArray[row][column];
////							
////							
////							if(vector == slopeArray.length) {
////								break;
////							}else {
////								forwardSlope = slopeArray[row][vector];
////							}
////							//Assign the current and forward slopes to be insepcted
////							
////							if(Double.isNaN(currentSlope) && row ==  0 ) {
////								System.out.println("Row: " + row);
////								System.out.println("Column: " +column);
////								System.out.println("AYeost");
////							}else if(Double.isNaN(currentSlope) && column == 0) {
////								
////								System.out.println("Row: " + row);
////								System.out.println("Column: " +column);
////								System.out.println("AYeost");
////							}
////						
////						
////						
////						// (5)(5)(5)(5)
////						for(int runner = column;(currentSlope == forwardSlope &&  currentSlope != Double.POSITIVE_INFINITY)
////								;runner++) {
////							
////							streakCounter++;
////							
////								
////								if(runner < slopeArray.length) {
////									if(Double.isNaN(slopeArray[row][runner])) {
////										
////										if(row == column) {
////											arrayOfSegments.add(new LineSegment(pointArray[row],pointArray[runner]));
////										}
////										
////										
////										runner++;
////										break;
////									}
////								
////									
////									
////									if(streakCounter <= 3) {
////										arrayOfSegments.add(new LineSegment(pointArray[row],pointArray[runner]));
////									}else if(streakCounter == 4) {
////										
////										lines.add(new LineSegment(pointArray[row],pointArray[runner]));
////										
////										for(LineSegment x: arrayOfSegments) {
////											lines.add(x);
////										}
////										
////									
////									}else if(streakCounter > 4){
////										lines.add(new LineSegment(pointArray[row],pointArray[runner]));
////									}
////									
////								//vector++;
////								
////									if(vector == slopeArray.length || (vector + 1) == slopeArray.length){
////										break;
////									}else {
////										forwardSlope = slopeArray[row][vector];
////										vector++;
////									}
////									
////									//Compare along the x axis
////									currentSmallestPoint = pointArray[row];
////									currentLargestPoint = pointArray[runner];
////									
////									
////									
////									
////									
////									
////									//lines.add(new LineSegment(pointArray[row],pointArray[runner]));
////									
////									
////								}else{
////									break;
////								}
////							
////						}
////						
////	
////						
////						column += streakCounter;
////						row += streakCounter;
////						streakCounter = 0;
////						
////						
////						arrayOfSegments.removeAll(arrayOfSegments);
////						
////					}
////
////					if(row >= slopeArray.length) {
////						break;
////					}
////					
////					
////					
////				}
////	
////			//}
////		
////		}
////		
////		catch(Exception x) {
////			System.out.println(x);
////		}
////	
////		System.out.println();
//		
//		
//		//Print out everything in the line segmentvariable
//		for(LineSegment run: lines) {
//			System.out.println(run);
//			run.draw();
//		}
//	}
//	
//	public void OldMethodTwo(Point[] array) {
//		
//		//Initialize Object variables to use for calculations.
//		this.pointArray = array;
//		int size = array.length;
//		this.slopeArray = new double[size][size];
//		
//		
//		Point starter = null;
//		
//
//		//Nested loop to allow for the population of the slopeArray wich is a 2D array of all the slopes the 
//		//points make against each other.
//		for(int row = 0; row < pointArray.length ;row++) {
//			
//			starter = pointArray[row];
//			
//			for(int column = 0; column < pointArray.length;column++) {
//				
//				
//				System.out.print("S: "+ starter.slopeTo(pointArray[column]) + " ");
//				this.slopeArray[row][column] = starter.slopeTo(pointArray[column]);
//				
//				
//				pointArray[row].draw();
//				//pointArray[column].draw();						 
//			}
//			
//			System.out.println();
//			System.out.println("****************");
//			
//		}
//		
//		
//		/*
//		 * We now search the slopeArray 2D array to find the colinear points in the array.
//		 * 
//		 * 1) The first for loop will run through the points as the main multiplier or row starting from
//		 * 	  the pointArray[0] --> pointArray[x]
//		 * 
//		 * 2) the second for loop will run through the points as the secondary multiplier or column starting form
//		 * 	  the pointArray[X] --> pointArray[y]
//		 * 
//		 * 3) If the current element in the column loop is equal to 0 print out the current Slope will be used for something
//		 *    later.
//		 * 
//		 * 4) If the current element in the column loop is equal to 1 make the prior slope equal to the slope at slopeArray[0].
//		 * 
//		 * 5) This is the internal loop that will check each row for similar slopes currently if the prior slope and current slope
//		 * 	  are equal then it will increment the loop
//		 * 	  
//		 * */
//		
//		
//		double forwardSlope = 1;
//		double currentSlope = 0;
//		
//		int vector = 0;
//		int streakCounter = 0;
//		
//		// Getting it down to just the minor and major points
////		Point currentSmallestPoint;
////		Point currentLargestPoint;
//		
//		
//		try {
//			// (1)(1)(1)(1)
//			for(int row = 0; row < slopeArray.length;row++) {
//	
//				currentSlope = slopeArray[row][0];
//			
//				// (2)(2)(2)(2)
//				for(int column = 0; column < slopeArray.length;column++) {
//					
//					// (3)(3)(3)(3)
//					if(column == 0) {		
//						forwardSlope = slopeArray[row][column + 1];
//						
//					// (4)(4)(4)(4)	
//					}else if(column >= 1) {
//						
//						if(column == 1) {
//							forwardSlope = slopeArray[row][column + 1];
//							currentSlope = slopeArray[row][column];
//						}
//							//Assign the current and forward slopes to be insepcted
//							vector = (column + 1);
//							currentSlope = slopeArray[row][column];
//							
//							
//							if(vector == slopeArray.length) {
//								break;
//							}else {
//								forwardSlope = slopeArray[row][vector];
//							}
//							//Assign the current and forward slopes to be insepcted
//						
//						
//						
//						
//						// (5)(5)(5)(5)
//						for(int runner = column;(currentSlope == forwardSlope &&  currentSlope != Double.POSITIVE_INFINITY) || 
//								Double.isNaN(currentSlope)
//								;runner++) {
//							
//							streakCounter++;
//							
//								
//								if(runner < slopeArray.length) {
//									if(Double.isNaN(slopeArray[row][runner])) {
//										
//										if(row == column) {
//											arrayOfSegments.add(new LineSegment(pointArray[row],pointArray[runner]));
//										}
//										
//										
//										runner++;
//										break;
//									}
//								
//									
//									
//									if(streakCounter <= 3) {
//										arrayOfSegments.add(new LineSegment(pointArray[row],pointArray[runner]));
//									}else if(streakCounter == 4) {
//										
//										lines.add(new LineSegment(pointArray[row],pointArray[runner]));
//										
//										for(LineSegment x: arrayOfSegments) {
//											lines.add(x);
//										}
//										
//									
//									}else if(streakCounter > 4){
//										lines.add(new LineSegment(pointArray[row],pointArray[runner]));
//									}
//									
//								//vector++;
//								
//									if(vector == slopeArray.length || (vector + 1) == slopeArray.length){
//										break;
//									}else {
//										forwardSlope = slopeArray[row][vector];
//										vector++;
//									}
//									
//									//Compare along the x axis
////									currentSmallestPoint = pointArray[row];
////									currentLargestPoint = pointArray[runner];
////									
//									
//									
//									
//									
//									
//									//lines.add(new LineSegment(pointArray[row],pointArray[runner]));
//									
//									
//								}else{
//									break;
//								}
//							
//						}
//						
//	
//						
//						column += streakCounter;
//						row += streakCounter;
//						streakCounter = 0;
//						
//						
//						arrayOfSegments.removeAll(arrayOfSegments);
//						
//					}
//
//					if(row >= slopeArray.length) {
//						break;
//					}
//					
//					
//					
//				}
//	
//			}
//		
//		}
//		
//		catch(Exception x) {
//			System.out.println(x);
//		}
//	
//		System.out.println();
//		
//		
//		//Print out everything in the line segmentvariable
//		for(LineSegment run: lines) {
//			System.out.println(run);
//			run.draw();
//		}
//		
//	}
//	
//	public void oldMethod(Point[] array) {
//		
//		this.pointArray = array;
//		
//		
//		//Slope counter variables
//		double previousSlope = 0;
//		int pointStreakCounter = 0;
//		
//		Point starter = null;
//		Point ender = null;
//		
//		
//		for(int index = 0; index < pointArray.length - 3; index++) {
//			for(int movement = index + 1; movement < pointArray.length ; movement++) {
//				
//				//Capture the previous slope if its the first time.
//				if(pointStreakCounter == 0) {
//					previousSlope = pointArray[index].slopeTo(pointArray[movement]);
//				}
//				
//				System.out.println("Comapre: " + pointArray[index] + " to " + pointArray[movement]);
//				System.out.println(pointArray[index].slopeTo(pointArray[movement]));
//				
//				
//				pointArray[index].draw();
//				pointArray[movement].draw();
//				
//				
//				
//				
//				//Compare the current slope value to the previous slope value to see if you have colinear points.
//				if(previousSlope == pointArray[index].slopeTo(pointArray[movement])) {
//				
////				for(int slopeChecker = 0; slopeChecker < index; slopeChecker++) {
////					for(int slopeMovement = slopeChecker + 1; slopeMovement < movement ; slopeMovement++) {
////						
////						if(pointArray[slopeChecker].slopeTo(pointArray[slopeMovement])==pointArray[index].slopeTo(pointArray[movement])) {
////							found = true;
////							// Remove break for coloring
////							break;
////						}else {
////							found = false;
////						}
////					}
////				}
////				
////				if(found) {
//					
//					
//					//If this is the first point that shares same slope.
//					if(pointStreakCounter == 0) {
//						
//						System.out.println("Potential First Line: ");
//						System.out.println(pointArray[index]);
//						
//						starter = pointArray[index];
//					}
//					
//					
//					
//					
//					pointStreakCounter++;
//					arrayOfSegments.add(new LineSegment(pointArray[index],pointArray[movement]));
//					
//					
//					if(pointStreakCounter == 3) {
//						
//						// Must sort the arrayOfSegments before anything else.
//						System.out.println("HIT ADD TO THE LINESEGMENT COLLECTION");
//						
//						
//						for(LineSegment x: arrayOfSegments) {
//							lines.add(x);
//						}
//						
//					
//						
//					}else if(pointStreakCounter >= 3) {
//						
////						if(-1 >= pointArray[movement].compareTo(starter)) {
////							System.out.println("TEst");
////						}
//						
//						
//						
//						lines.add(new LineSegment(pointArray[index],pointArray[movement]));
//					}
//				
//				//Compare the current slope value to the previous slope value to see if you have colinear points.
//				}else{
//					
//					//Consider jumping in the line					
//					index += pointStreakCounter;
//					
//					if(pointStreakCounter > 3) {
//						int holder = lines.size() - 1;
//						ender = lines.get(holder).getQ();
//						
//						
//
//						System.out.println();
//						System.out.println("STREAK BROKEN!");
//						System.out.println("Starter: " + starter.toString());
//						System.out.println("Ender: " + ender.toString());
//						System.out.println("STREAK BROKEN!");
//						System.out.println();
//					}
//					
//					arrayOfSegments.removeAll(arrayOfSegments);
//					previousSlope = pointArray[index].slopeTo(pointArray[movement]);
//					pointStreakCounter = 0;
//					break;
//				}
//				
//				continue;
//				
//				
//				
//			}
//			
//			
//			
//						
//			System.out.println();
//
//		}
//		
//		
//		for(LineSegment x: lines) {
//			System.out.println(x);
//			x.draw();
//		}
//		
//	}

	
	
	
	public static void main(String[] args) {
		
		//Point[] pointsArray = new Point[10];
		//Point[] pointsArray = new Point[10];
		
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
		
		
//		pointsArray[0] = new Point(0,10);
//		pointsArray[1] = new Point(1,9);
//		pointsArray[2] = new Point(2,8);
//		pointsArray[3] = new Point(3,7);
//		pointsArray[4] = new Point(4,6);
//		pointsArray[5] = new Point(5,5);
//		pointsArray[6] = new Point(6,7);
//		pointsArray[7] = new Point(7,14);
//		pointsArray[8] = new Point(8,16);
//		pointsArray[9] = new Point(9,18);
		
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
//		10000      0
//	    0  10000
//	 3000   7000
//	 7000   3000
//	20000  21000
//	 3000   4000
//	14000  15000
//	 6000   7000
	 

		
		//Actual Test Case
//	 	pointsArray[0] = new Point(10,0);
//		pointsArray[1] = new Point(0,10);
//		pointsArray[2] = new Point(3,7);
//		pointsArray[3] = new Point(7,3);
//		pointsArray[4] = new Point(20,21);
//		pointsArray[5] = new Point(3,4);
//		pointsArray[6] = new Point(14,15);
//		pointsArray[7] = new Point(6,7);
//		pointsArray[8] = new Point(12,3);
//		pointsArray[9] = new Point(10,2);
	 
		//InsertionSort.sort(pointsArray);
		//BruteForceColinearPoints x = new BruteForceColinearPoints(pointsArray);
		
		
		 	In in = new In(args[0]);
		    int n = in.readInt();
		    Point[] points = new Point[n];
		    for (int i = 0; i < n; i++) {
		        int x = in.readInt();
		        int y = in.readInt();
		        points[i] = new Point(x, y);
		    }
		    
		    StdDraw.enableDoubleBuffering();
		    StdDraw.setXscale(0, 32768);
		    StdDraw.setYscale(0, 32768);
		    
		    StdOut.println("Before Brute Slope Order");
		    for (Point p : points) {
		        p.draw();
		        System.out.println(p);
		    }
		    StdDraw.show();

		    
		    
		    BruteForceColinearPoints x = new BruteForceColinearPoints(points);
		
		    for (LineSegment segment : x.segments()) {
		    	StdOut.println(segment);
		    	StdOut.println(segment.getP().slopeTo(segment.getQ()));
		    	
		    	segment.draw();
		    }
		
		    StdDraw.show();
	}

}
