package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import basicDataStructures.StdDraw;
import basicDataStructures.StdOut;

public class FastColinearPoints {
	
	Point[] pointArray = null;
	ArrayList<Point> pointsToSort = new ArrayList<Point>();
	
	Point[] pointsToDraw = null;
	
	ArrayList<LineSegment> lines = new ArrayList<LineSegment>();
	ArrayList<LineSegment> arrayOfSegments = new ArrayList<LineSegment>();
	
	public FastColinearPoints(Point[] array) {
		

		
		
		
	}
	
	
	public void oldMethod(Point[] array) {
		
//		pointArray = new Point[array.length];
//		
//		for(int runner = 0; runner < array.length; runner++) {
//			pointArray[runner] = array[runner];
//		}
		
		pointArray = array.clone();
		Arrays.sort(pointArray);
		
		
		
		int streakCounter = 0;
		
		int currentIndx = 0;
		int forwardIndx = 0;
		
		double forwardSlope = 0;
		double currentSlope = 0;
		
		Point highestPoint = null;
		Point lowestPoint = null;
		Point holder = null;
		
		
		Point prevHighestPoint = null;
		Point prevLowestPoint = null;
		
		
		for(int rowRunner = 0; rowRunner < array.length;rowRunner++) {
			
			System.out.println("Row Runner: " + rowRunner);
			System.out.println("For Point: " + array[rowRunner]);
			System.out.println();
			
			InsertionSortWithComparator.sort(pointArray, array[rowRunner].slopeOrder());
			//SelectionSortWithComparator.sort(pointArray, array[rowRunner].slopeOrder());
			//Arrays.sort(pointArray, array[rowRunner].slopeOrder());
			
			
			currentIndx = 0;
			forwardIndx = 1;
			
			for(int columnRunner = 0; columnRunner < array.length  &&  !(forwardIndx >= array.length);columnRunner++) {
				
			
			System.out.println("Outer: " + pointArray[columnRunner] + " Slope they make: " + pointArray[columnRunner].slopeTo(array[rowRunner]));
				
				
				
				
				//Slope stuff
				
				currentIndx++;
				currentSlope = pointArray[currentIndx].slopeTo(array[rowRunner]);
				
			
				forwardIndx++;
				if(forwardIndx >= array.length) {
					break;
				}else {
					forwardSlope = pointArray[forwardIndx].slopeTo(array[rowRunner]);
				}
				

				lowestPoint = array[rowRunner];
				highestPoint = pointArray[currentIndx];
				
				
				for(int slopeRunner = columnRunner; currentSlope == forwardSlope && forwardIndx != array.length 
						; slopeRunner++) {
					
					
					
					prevHighestPoint = highestPoint;
					prevLowestPoint = lowestPoint;
					
					
					streakCounter++;
					forwardSlope = pointArray[forwardIndx].slopeTo(array[rowRunner]);
					forwardIndx++;
					
					
					
					
					
					
					
					if(streakCounter < 3) {
						pointsToSort.add(pointArray[slopeRunner]);
					}
					

					if(streakCounter >= 3) {
						
						
						//HIGHEST AND LOWEST POINT SOLUTION.
//						if(pointArray[slopeRunner].compareTo(lowestPoint) == -1  ) {
//							lowestPoint = pointArray[slopeRunner];
//						}
//						
//						if(pointArray[slopeRunner].compareTo(highestPoint) == 1  ) {
//							highestPoint = pointArray[slopeRunner];
//						}
						
						
						
						//pointsToSort.add(pointArray[slopeRunner]);
						
						//Collections.sort(pointsToSort);
						
//						for(Point x: pointsToSort) {
//							//lines.add(new LineSegment(array[rowRunner],x));
//							//System.out.println(pointArray[columnRunner] + " Slope they make: " + pointArray[columnRunner].slopeTo(array[rowRunner]));
//							System.out.println("From Holder:");
//							System.out.println(array[rowRunner] + " " +  x);
//							System.out.println(array[rowRunner]  + " Slope they make: " + pointArray[slopeRunner].slopeTo(array[rowRunner]));
//							System.out.println();
//							//System.out.println("Slope: "+ array[rowRunner].slopeTo(x));
//						}
						
						
						if(lowestPoint.compareTo(pointArray[slopeRunner]) == 1 ) {
							lowestPoint = pointArray[slopeRunner];
						}
						
						if(highestPoint.compareTo(pointArray[slopeRunner]) == -1 ) {
							highestPoint = pointArray[slopeRunner];
						}
						
						if(highestPoint.compareTo(lowestPoint) == -1 ) {
							holder = lowestPoint;
							lowestPoint = highestPoint;
							highestPoint = holder;
						}
						
						if(lowestPoint.compareTo(highestPoint) == 1 ) {	
							holder = highestPoint;
							highestPoint = lowestPoint;
							lowestPoint = holder;
						}
						
						
						
						
						// 
						
						
						
//						if(lowestPoint.compareTo(array[rowRunner]) == 1) {
//							lowestPoint = array[rowRunner];
//						}
//						
//						if(highestPoint.compareTo(array[rowRunner]) == -1) {
//							highestPoint = array[rowRunner];
//						}
//						
//						
//						System.out.println("Highest Point: " + highestPoint);
//						System.out.println("Lowest Point: "+ lowestPoint);
						

						
						//lines.add(new LineSegment(lowestPoint,highestPoint));
//						
//						lines.add(new LineSegment(holder.get(1),holder.get(holder.size() - 2)));
						
						
						//Adding to lines
						//lines.add(new LineSegment(pointsToSort.get(0),pointsToSort.get(pointsToSort.size() - 1)));
						lines.add(new LineSegment(array[rowRunner],pointArray[slopeRunner]));
						//lines.add(new LineSegment(array[rowRunner],pointArray[slopeRunner]));
						
						
						//lines.add(new LineSegment(array[rowRunner],pointsToSort.get(pointsToSort.size() - 2)));
						
						
					}
					
			
					
				}
				assert highestPoint.compareTo(lowestPoint) == 1;
				
				//lines.add(new LineSegment(lowestPoint,highestPoint));
				
//				if(!pointsToSort.isEmpty()) {
//					
//					Collections.sort(pointsToSort);
//					
//					System.out.println("================");
//					for(Point runner: pointsToSort) {
//						System.out.println("Point: " + runner);
//					}
//					System.out.println("================");
//
//					System.out.println("Highest Point: " + pointsToSort.get(pointsToSort.size() - 1));
//					System.out.println("Lowest Point: "+ pointsToSort.get(0));
//					
//					//lines.add(new LineSegment(pointsToSort.get(0),pointsToSort.get(pointsToSort.size() - 1)));
//					
//					pointsToSort.clear();
//				}
				
				
				
				
				
				
//				System.out.println("Highest Point: " + highestPoint);
//				System.out.println("Lowest Point: "+ lowestPoint);
//				System.out.println();
				
				lowestPoint = null;
				highestPoint = null;
				
				pointsToSort.clear();
				columnRunner += streakCounter;
				currentIndx += streakCounter;
				streakCounter = 0;
				
			}
			
			
			
			
			System.out.println();
		}
		
		
	}
	
	
	public LineSegment[] segments() {
		
		LineSegment[] lineList = null;
		
		lineList = this.lines.toArray(new LineSegment[lines.size()]);
		
		return lineList;
	}
	

	public static void main(String[] args) {
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
	    for (Point p : points) {
	        p.draw();
	    }
	    StdDraw.show();
	    
//	    Left In for testing
	    StdOut.println("Before Fast Slope Order");
	    for(Point runner: points) {
	    	System.out.println(runner);
	    }
		System.out.println();
	    
	    
	    FastColinearPoints x = new FastColinearPoints(points);
	    
	    
	   
	
		for (LineSegment segment : x.segments()) {
	        StdOut.println(segment + " SLOPE: " + segment.getP().slopeTo(segment.getQ()));
	    	
	      
	        segment.draw();
	    }
	
		StdDraw.show();
		}

}
