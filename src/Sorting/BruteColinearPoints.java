package Sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class BruteColinearPoints {
	
	private Point[] pointArray;
	private double[][] slopeArray;
	private ArrayList<LineSegment> lines = new ArrayList<LineSegment>();
	
	
	
	
	public BruteColinearPoints(Point[] array) {
		
		if(array == null) {
			throw new IllegalArgumentException(); 
		}
		
		this.pointArray = array.clone();
		int size = array.length;
		
		Arrays.sort(pointArray);
		
		for(int backRunner = 0, frontRunner = 1; frontRunner < pointArray.length ; frontRunner++, backRunner++) {
			if(pointArray[frontRunner].compareTo(pointArray[backRunner]) == 0) {
				throw new IllegalArgumentException(); 
			}
			
			if(pointArray[frontRunner] == null) {
				throw new IllegalArgumentException();
			}
			
			if(pointArray[backRunner] == null) {
				throw new IllegalArgumentException();
			}

		}
		
		
		Point first = null;
		Point second = null;
		Point third = null;
		Point fourth = null;
		
		double slopeA = 0;
		double slopeB = 0;
		double slopeC = 0;

		//double previousTotal = 0;
		
		Point[] subber = new Point[4];
		
		for(int firstPoint = 0; firstPoint < size - 3;firstPoint++) {
			for(int secondPoint = 1;secondPoint < size - 2;secondPoint++) {
				for(int thirdPoint = 2;thirdPoint < size - 1;thirdPoint++) {
					for(int fourthPoint = 3;fourthPoint < size;fourthPoint++) {
						first = pointArray[firstPoint];
						second = pointArray[secondPoint];
						third = pointArray[thirdPoint];
						fourth = pointArray[fourthPoint];
						
						
						
//						if(first == second || first == third || first == fourth || second == third || second == fourth || third == fourth) {
//							throw new IllegalArgumentException();
//						}
						
						
						
						slopeA = first.slopeTo(second);
						slopeB = first.slopeTo(third);
						slopeC = first.slopeTo(fourth);
						
						if(slopeA != slopeB) {
							break;
						}
						
						if(slopeA == slopeB && slopeA == slopeC && slopeB == slopeC && 
							first != second && first != third && first != fourth && second != third && second != fourth && third != fourth) {

							
							subber[0] = first;
							subber[1] = second;
							subber[2] = third;		
							subber[3] = fourth;
							
							
							if(subber[0].compareTo(subber[1]) == 1 ||subber[0].compareTo(subber[2]) == 1 ||subber[0].compareTo(subber[3]) == 1 ) {
								break;
							}else if(subber[0].compareTo(subber[1]) == -1 && subber[0].compareTo(subber[2]) == -1 && subber[0].compareTo(subber[3]) == -1
									&& subber[1].compareTo(subber[2]) == -1 && subber[1].compareTo(subber[3]) == -1 && subber[2].compareTo(subber[3]) == -1){
								
								lines.add(new LineSegment(subber[0],subber[3]));
								
							}else {
								break;
							}
							

	
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
	
	public int numberOfSegments() {
		return this.lines.size();
	}
	
	
	
	public static void main(String[] args) {
		
		
		 	In in = new In(args[0]);
		    int n = in.readInt();
		    Point[] points = new Point[n];
		    for (int i = 0; i < n; i++) {
		    	
		    	try {
		    		
		        int x = in.readInt();
		        int y = in.readInt();
		        points[i] = new Point(x, y);
		        
		    	}
		    	
		    	catch(NoSuchElementException ex) {
		    		throw new IllegalArgumentException();
		    	}
		    }
		    
		    StdDraw.enableDoubleBuffering();
		    StdDraw.setXscale(0, 32768);
		    StdDraw.setYscale(0, 32768);
		    
		    //StdOut.println("Before Brute Slope Order");
		    for (Point p : points) {
		        p.draw();
		        //System.out.println(p);
		    }
		    StdDraw.show();

		    
		    
		    BruteColinearPoints x = new BruteColinearPoints(points);
		
		    for (LineSegment segment : x.segments()) {
		    	//StdOut.println(segment);
		    	//StdOut.println(segment.getP().slopeTo(segment.getQ()));
		    	
		    	segment.draw();
		    }
		
		    StdDraw.show();
	}

}
