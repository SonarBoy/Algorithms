package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import basicDataStructures.StdDraw;
import basicDataStructures.StdOut;

public class FastColinearPoints {
	
	Point[] pointArray = null;
	ArrayList<Point> holder = new ArrayList<Point>();
	
	ArrayList<LineSegment> lines = new ArrayList<LineSegment>();
	ArrayList<LineSegment> arrayOfSegments = new ArrayList<LineSegment>();
	
	public FastColinearPoints(Point[] array) {
		
		
		pointArray = new Point[array.length];
		
		for(int runner = 0; runner < array.length; runner++) {
			pointArray[runner] = array[runner];
		}
		
		
		
		
		int streakCounter = 0;
		
		int currentIndx = 0;
		int forwardIndx = 0;
		
		double forwardSlope = 0;
		double currentSlope = 0;
		
		Point checkerPoint = null;
		
		
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
				
				
			//System.out.println(pointArray[columnRunner] + " Slope they make: " + pointArray[columnRunner].slopeTo(array[rowRunner]));
				
				currentIndx++;
				
				
				//Slope stuff
				currentSlope = pointArray[currentIndx].slopeTo(array[rowRunner]);
				
			
				forwardIndx++;
				if(forwardIndx >= array.length) {
					break;
				}else {
				
					forwardSlope = pointArray[forwardIndx].slopeTo(array[rowRunner]);
				}
//				
				

				
				checkerPoint = pointArray[currentIndx];
				
				
				for(int slopeRunner = columnRunner; currentSlope == forwardSlope && forwardIndx != array.length 
						; slopeRunner++) {
					
					
					
					streakCounter++;
					forwardSlope = pointArray[forwardIndx].slopeTo(array[rowRunner]);
					forwardIndx++;
					
					
					
					
					if(streakCounter < 3) {
						holder.add(pointArray[slopeRunner]);
					}
					
					if(streakCounter == 3) {
						holder.add(pointArray[slopeRunner]);
						
//						for(Point x: holder) {
//							lines.add(new LineSegment(array[rowRunner],x));
//						}
						
						
						Collections.sort(holder);
						
						for(Point x: holder) {
							//lines.add(new LineSegment(array[rowRunner],x));
							//System.out.println(pointArray[columnRunner] + " Slope they make: " + pointArray[columnRunner].slopeTo(array[rowRunner]));
							System.out.println(array[rowRunner] + " " +  x);
						}
						
						
					}
					
					
					
					if(streakCounter >= 3) {
							
						lines.add(new LineSegment(array[rowRunner],pointArray[slopeRunner]));
						
						
						
//						if(checkerPoint.compareTo(pointArray[slopeRunner]) == -1) {
//							
//							checkerPoint = pointArray[slopeRunner];
//							lines.add(new LineSegment(array[rowRunner],checkerPoint));
//							
//						}else if(checkerPoint.compareTo(pointArray[slopeRunner]) == 1){
//							
//							lines.add(new LineSegment(array[rowRunner],checkerPoint));
//						}
						
						
						//lines.add(new LineSegment(array[rowRunner],checkerPoint));
						//lines.add(new LineSegment(array[rowRunner],pointArray[slopeRunner]));
						//lines.add(new LineSegment(array[rowRunner],holder.get(0)));
					}
					
					
				}
				
				
				
				holder.clear();
				columnRunner += streakCounter;
				currentIndx += streakCounter;
				checkerPoint = null;
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
	    System.out.println("Before Slope Order");
	    for(Point runner: points) {
	    	System.out.println(runner);
	    }
		System.out.println();
	    
	    
	    FastColinearPoints x = new FastColinearPoints(points);
	    
	    
	   
	
		for (LineSegment segment : x.segments()) {
	        StdOut.println(segment);
	        segment.draw();
	    }
	
		StdDraw.show();
		}

}
