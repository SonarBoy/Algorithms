
package Sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;



public class FastCollinearPoints {
	
	private Point[] pointArray = null;
	private Point[] pointsToDraw = null;
	
	private ArrayList<LineSegment> lines = new ArrayList<LineSegment>();
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	
	
	public FastCollinearPoints(Point[] array ) {
		
		if(array == null) {
			throw new IllegalArgumentException(); 
		}
		
		
		pointsToDraw = array.clone();
		Arrays.sort(pointsToDraw);
		
		
		pointArray = pointsToDraw.clone();
		int arrayLength = pointArray.length;
		
		for(int backRunner = 0, frontRunner = 1; frontRunner < pointsToDraw.length ; frontRunner++, backRunner++) {
			
			if(pointsToDraw[frontRunner] == null) {
				throw new IllegalArgumentException();
			}
			
			if(pointsToDraw[backRunner] == null) {
				throw new IllegalArgumentException();
			}
			
			if(pointsToDraw[frontRunner].compareTo(pointsToDraw[backRunner]) == 0) {
				throw new IllegalArgumentException(); 
			}

		}

		
		Point origin = null;
		Point highestPoint = null;
		
		
		int currentIndx = 0;
		int forwardIndx = 0;
		
		
		double currentSlope = 0;
		double forwardSlope = 0;
		
//		for(Point x: pointsToDraw) {
//			System.out.println(x);
//		}
		
		int streakCounter = 0;
		
		Point currentPoint = null;
		Point forwardPoint = null;
	
		boolean hitInternalRunner = false;
		
		for(int rowRunner = 0; rowRunner < arrayLength; rowRunner++) {
			
//			System.out.println();
//			System.out.println("Origin: " + pointsToDraw[rowRunner]);
//			System.out.println();
			
			origin = pointsToDraw[rowRunner];
			Arrays.sort(pointArray, origin.slopeOrder());
			
			currentIndx = 1;
			//midIndx = 1;
			forwardIndx = 2;
			
			for(; forwardIndx <= (arrayLength - 1);) {
				
				
				
				
				currentPoint = pointArray[currentIndx];
				//midPoint = pointArray[midIndx];
				forwardPoint = pointArray[forwardIndx];
				
				currentSlope = origin.slopeTo(currentPoint);
				forwardSlope = origin.slopeTo(forwardPoint);
				
				
//				System.out.println(origin + " and " + currentPoint + " slope: "+ origin.slopeTo(currentPoint));	
//				System.out.println("CurrentIndx: " + currentIndx);
//				//System.out.println("MidIndx: " + midIndx);
//				System.out.println("ForwardIndx: " + forwardIndx);
////				System.out.println(origin + " and CurrentIndx" + pointArray[currentIndx] + " slope: "+ origin.slopeTo(pointArray[forwardIndx]));
//				System.out.println();
				
				
				for(int slopeRunner = currentIndx;
						currentSlope == forwardSlope && 
						slopeRunner <= (arrayLength - 1) && 
						currentSlope == origin.slopeTo(pointArray[slopeRunner]); slopeRunner++) {
					
//					System.out.println("SameSlope");
//					System.out.println("Point : " + pointArray[slopeRunner]);
					
					
					if(slopeRunner == currentIndx) {
						highestPoint = pointArray[slopeRunner];
					}
					
					if(origin.compareTo(pointArray[slopeRunner]) == 1) {
						highestPoint = null;
					}
					
					
					if(highestPoint != null && highestPoint.compareTo(pointArray[slopeRunner]) == -1) {
								
						highestPoint = pointArray[slopeRunner];
					}
							
							
				

					
					
					
					if(highestPoint != null && highestPoint.compareTo(origin) == -1) {
						highestPoint = null;
					}
					
					streakCounter++;
					
				}
				
				
				
				if(highestPoint != null && streakCounter >= 3 && origin.compareTo(highestPoint) < 0) {
//					System.out.println("StreakCounter : " + streakCounter);
//					System.out.println();
//					System.out.println("Line to draw Origin: " + origin + " to "+ highestPoint);
					
					lines.add(new LineSegment(origin,highestPoint));
					
					

					currentIndx += streakCounter - 1;
					forwardIndx += streakCounter - 1;
					
				}else if(highestPoint == null && streakCounter >= 3){
						
					currentIndx += streakCounter - 1;
					forwardIndx += streakCounter - 1;
					
				}else {
					

					currentIndx++;
					forwardIndx++;
				}
				
				highestPoint = null;
				streakCounter = 0;
				
				
			}
			
			
			
			
		}
		
		
		
		
	}


	
	
	
	public int numberOfSegments() {
		return this.lines.size();
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
	    
	    //FastCollinearPoints x = new FastCollinearPoints(points,true);
	    //FastCollinearPoints x = new FastCollinearPoints(points);
	    FastCollinearPoints x = new FastCollinearPoints(points);
	    
	    //for (LineSegment segment : other.segments()) {
		for (LineSegment segment : x.segments()) {
//	        StdOut.println(segment + " SLOPE: " + segment.getP().slopeTo(segment.getQ()));
	    	//System.out.println(segment.toString());
	        segment.draw();
	    }
	
		StdDraw.show();
		
		
//		for (LineSegment segment : other.segments()) {
////	        StdOut.println(segment + " SLOPE: " + segment.getP().slopeTo(segment.getQ()));
//	    	System.out.println(segment.toString());
//	        segment.draw();
//	    }
//	
//		StdDraw.show();
		}

}
