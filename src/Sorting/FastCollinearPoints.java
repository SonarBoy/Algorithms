
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
	
	
	public FastCollinearPoints(Point[] array) {
		
		
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
		//System.out.println(arrayLength);
		
		
//		System.out.println("AFTER SORT");
//		
//		for(Point x: pointsToDraw) {
//			System.out.println(x);
//		}
//		
//		System.out.println();
//		System.out.println();
		
		
		int streakCounter = 0;
		
		int currentIndx = 0;
		int forwardIndx = 0;
		
		double currentSlope = 0;
		double forwardSlope = 0;
		
//		boolean toAdd = true;
		
		Arrays.sort(pointArray);
		
		Point origin = null;
		Point highestPoint = null;
		
		
		
		for(int rowRunner = 0; rowRunner < arrayLength; rowRunner++) {
			
			origin = pointsToDraw[rowRunner];
			
			Arrays.sort(pointArray, origin.slopeOrder());
			
			//WHEN STARTING THE TRAVERSAL OF A LOOP WITH TWO POINTERS MAKE SURE YOU START FROM -1 IF YOU ARE GOING TO INCREMENT THROUGH
			currentIndx = -1;
			forwardIndx = 0;
			
//			toAdd = true;
			
//			System.out.println("Current Origin: " + origin);
//			System.out.println();
						
			
			//!(forwardIndx >= arrayLength) equals forwardIndx <= arrayLength + 1
			for(int columnRunner = 0; columnRunner < arrayLength && forwardIndx <= arrayLength + 1; columnRunner++) {
				
//				System.out.println("Outer: " + pointArray[columnRunner] + " slope it makes with " + origin + " " +
//						origin.slopeTo(pointArray[columnRunner]));
				
				
			
				currentIndx++;
				currentSlope = pointArray[currentIndx].slopeTo(origin);
			
				
				forwardIndx++;
				if(forwardIndx >= arrayLength) {
					break;
				}else {
					forwardSlope = pointArray[forwardIndx].slopeTo(origin);
				}
				
//				toAdd = true;
			
				//THE SECOND PART OF THIS STATEMENT forwardIndx <= arrayLength + 1 makes sure that it gets into the last element and 
				//no farther
				for(int slopeRunner = columnRunner ; currentSlope == forwardSlope && forwardIndx <= arrayLength + 1 ; slopeRunner++) {
							
					
//					if(slopeRunner == columnRunner) {
//						System.out.println("------------------START----------------------");
//					}
//					
//						
//					System.out.println("Inner: " + pointArray[slopeRunner] + " slope it makes with " + origin + " " +
//					origin.slopeTo(pointArray[slopeRunner]));
						

					if(slopeRunner == columnRunner) {
						highestPoint = pointArray[slopeRunner];
					}else{
						
						if(highestPoint.compareTo(pointArray[slopeRunner]) == -1) {
							highestPoint = pointArray[slopeRunner];
						}
						
					}
					
//					if(origin.slopeTo(pointArray[slopeRunner]) == currentSlope) {
//						if(origin.compareTo(pointArray[slopeRunner]) == 1) {
//							toAdd = false;
//							break;	
//						}
//					}
					
					//origin.compareTo(pointArray[slopeRunner]) != -1
					//if(origin.compareTo(highestPoint) != -1) {
						
						//origin.compareTo(pointArray[slopeRunner]) == 1
//						if(origin.compareTo(highestPoint) == 1) {
//							
//							highestPoint = null;
//							break;
//						}
					
					//}
					
					if(highestPoint.compareTo(origin) == -1) {
						//streakCounter =0;
						highestPoint = null;
						break;
					}
					
					//THIS IS THE BREAK POINT TO CHECK THE LAST ELEMENT AND NOT GO OVER
					if(forwardIndx >= arrayLength) {
						streakCounter++;
						break;
					}
					
					
					
					streakCounter++;
					forwardSlope = pointArray[forwardIndx].slopeTo(origin);
					forwardIndx++;
				}
				
			


				if(highestPoint != null && streakCounter >= 3) {
					
//					System.out.println("------------------END----------------------");
//					System.out.println();
//					System.out.println("Origin: " + origin);
//					System.out.println("Highest: " + highestPoint);
//					System.out.println();
					

					boolean toAdd = true;
					//System.out.println();
					for(int runner = 1; runner < pointArray.length; runner++) {
						
						if(origin.slopeTo(pointArray[runner]) == currentSlope) {
							if(origin.compareTo(pointArray[runner]) == 1) {
								toAdd = false;
								break;	
							}
						}
					}

					if(toAdd) {
						lines.add(new LineSegment(origin,highestPoint));
					}
					
					highestPoint = null;
					
				}else {
//					System.out.println("------------------END----------------------");
//					System.out.println();
//					System.out.println();
				}
				

				columnRunner += streakCounter;
				currentIndx += streakCounter;
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
	    
	    
	    FastCollinearPoints x = new FastCollinearPoints(points);
	    
	    

		for (LineSegment segment : x.segments()) {
//	        StdOut.println(segment + " SLOPE: " + segment.getP().slopeTo(segment.getQ()));
	    	System.out.println(segment.toString());
	        segment.draw();
	    }
	
		StdDraw.show();
		}

}
