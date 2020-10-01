package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import basicDataStructures.StdDraw;
import basicDataStructures.StdOut;

public class FastColinearPoints {
	
	Point[] pointArray = null;
	double[][] slopeArray;
	
	ArrayList<LineSegment> lines = new ArrayList<LineSegment>();
	ArrayList<Point> arrayOfSegments = new ArrayList<Point>();
	
	public FastColinearPoints(Point[] array) {
		
		
		pointArray = new Point[array.length];
		
		for(int runner = 0; runner < array.length; runner++) {
			pointArray[runner] = array[runner];
		}
		
		
		double slopeA = 0;
		double slopeB = 0;
		double slopeC = 0;
		
		Point[] lineSegmentToDraw = new Point[4];
		
		
		for(int rowRunner = 0; rowRunner < array.length;rowRunner++) {
			
			System.out.println("Row Runner: " + rowRunner);
			System.out.println("For Point: " + array[rowRunner]);
			System.out.println();
			
			SelectionSortWithComparator.sort(pointArray, array[rowRunner].slopeOrder());
			//Arrays.sort(pointArray, array[rowRunner].slopeOrder());
			
			
			for(int columnRunner = 0; columnRunner < array.length;columnRunner++) {
				
				//System.out.println("Row Runner: " + array[rowRunner]);
				//System.out.println("Column Runner: " + pointArray[columnRunner]);
				//System.out.println(pointArray[columnRunner] + " Slope they make: " + array[rowRunner].slopeTo(pointArray[columnRunner]));
				System.out.println(pointArray[columnRunner] + " Slope they make: " + pointArray[columnRunner].slopeTo(array[rowRunner]));
				
				
			
				
				if(pointArray[columnRunner] == array[rowRunner]) {
					
//					System.out.println();
//					System.out.println("Similar Points Found at: " + columnRunner);
//					System.out.println("pointArray Found at: " + pointArray[columnRunner]);
//					System.out.println("array Found at: " + array[rowRunner]);
//					System.out.println();
					
//					if(columnRunner == 0) {
//						System.out.println("First");
//						
//						slopeA = pointArray[columnRunner + 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner + 2].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner + 3].slopeTo(array[rowRunner]);
//						
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner + 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner + 2]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner + 3]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner + 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner + 2];
//							lineSegmentToDraw[3] = pointArray[columnRunner + 3];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//							
//						}
//						
//						
//					}else if(columnRunner == 1) {
//						System.out.println("Second");
//						
//						slopeA = pointArray[columnRunner - 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner + 1].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner + 2].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner - 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner + 1]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner + 2]);
//						
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner - 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner + 1];
//							lineSegmentToDraw[3] = pointArray[columnRunner + 2];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//						
//						
//						//OR
//						
//						slopeA = pointArray[columnRunner + 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner + 2].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner + 3].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner + 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner + 2]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner + 3]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner + 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner + 2];
//							lineSegmentToDraw[3] = pointArray[columnRunner + 3];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//						
//						
//					}else if(columnRunner == 2) {
//						System.out.println("Third");
//						
//						slopeA = pointArray[columnRunner - 2].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner - 1].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner + 1].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner - 2]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner - 1]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner + 1]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner - 2];
//							lineSegmentToDraw[2] = pointArray[columnRunner - 1];
//							lineSegmentToDraw[3] = pointArray[columnRunner + 1];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//						
//						//OR
//						
//						slopeA = pointArray[columnRunner - 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner + 1].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner + 2].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner - 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner + 1]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner + 2]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner - 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner + 1];
//							lineSegmentToDraw[3] = pointArray[columnRunner + 2];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//						
//						//OR
//						
//						slopeA = pointArray[columnRunner + 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner + 2].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner + 3].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner + 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner + 2]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner + 3]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner + 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner + 2];
//							lineSegmentToDraw[3] = pointArray[columnRunner + 3];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//						
//					}else if(columnRunner == array.length - 1) {
//						System.out.println("Last");
//						
//						slopeA = pointArray[columnRunner - 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner - 2].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner - 3].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner - 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner - 2]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner - 3]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner - 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner - 2];
//							lineSegmentToDraw[3] = pointArray[columnRunner - 3];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//						
//						
//					}else if(columnRunner == array.length - 2) {
//						System.out.println("Second Last");
//						
//						slopeA = pointArray[columnRunner + 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner - 1].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner - 2].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner + 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner - 1]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner - 2]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner + 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner - 1];
//							lineSegmentToDraw[3] = pointArray[columnRunner - 2];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//						
//						
//						//OR
//						
//						slopeA = pointArray[columnRunner - 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner - 2].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner - 3].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner - 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner - 2]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner - 3]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner - 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner - 2];
//							lineSegmentToDraw[3] = pointArray[columnRunner - 3];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//						
//						
//					}else if(columnRunner == array.length - 3) {
//						System.out.println("Third Last");
//						
//						slopeA = pointArray[columnRunner - 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner + 1].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner + 2].slopeTo(array[rowRunner]);
//						
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner - 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner + 1]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner + 2]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner - 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner + 1];
//							lineSegmentToDraw[3] = pointArray[columnRunner + 2];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//							
//						}
//						
//						//OR
//						
//						slopeA = pointArray[columnRunner + 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner - 1].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner - 2].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner + 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner - 1]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner - 2]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner + 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner - 1];
//							lineSegmentToDraw[3] = pointArray[columnRunner - 2];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//						
//						//OR
//						
//						slopeA = pointArray[columnRunner - 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner - 2].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner - 3].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner - 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner - 2]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner - 3]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner - 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner - 2];
//							lineSegmentToDraw[3] = pointArray[columnRunner - 3];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//						
//					}else{
//						
//						slopeA = pointArray[columnRunner - 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner - 2].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner - 3].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner - 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner - 2]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner - 3]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner - 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner - 2];
//							lineSegmentToDraw[3] = pointArray[columnRunner - 3];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//						
//						slopeA = pointArray[columnRunner + 1].slopeTo(array[rowRunner]);
//						slopeB = pointArray[columnRunner + 2].slopeTo(array[rowRunner]);
//						slopeC = pointArray[columnRunner + 3].slopeTo(array[rowRunner]);
//						
//						slopeA = array[rowRunner].slopeTo(pointArray[columnRunner + 1]);
//						slopeB = array[rowRunner].slopeTo(pointArray[columnRunner + 2]);
//						slopeC = array[rowRunner].slopeTo(pointArray[columnRunner + 3]);
//						
//						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC) {
//							System.out.println("LINE SEGMENT FOUND: " + columnRunner);
//							
//							lineSegmentToDraw[0] = pointArray[columnRunner];
//							lineSegmentToDraw[1] = pointArray[columnRunner + 1];
//							lineSegmentToDraw[2] = pointArray[columnRunner + 2];
//							lineSegmentToDraw[3] = pointArray[columnRunner + 3];
//							
//							Arrays.sort(lineSegmentToDraw, new SortByXCoordinate());
//							
//							lines.add(new LineSegment(lineSegmentToDraw[0],lineSegmentToDraw[3]));
//						}
//					}
					
					
					
					
				}
				//System.out.println(pointArray[columnRunner] + " Slope they make: " + pointArray[columnRunner].slopeTo(pointArray[rowRunner]));
				
			}
			
//			pointArray = null;
//			pointArray = array;
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
