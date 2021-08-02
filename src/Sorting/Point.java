package Sorting;

import java.util.Comparator;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

	
	private int pointX;
	private int pointY;
	
	
	
	public Point(int x,int y) {
		
		StdDraw.setScale(-50,50);
		
		
		
		this.setPointX(x);
		this.setPointY(y);
	}
	
	
	public void draw() {
		
		StdDraw.setPenRadius(0.003);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(this.getPointX(), this.getPointY());
		
		
	}
	

	
	
	//TODO: Make sure slopeTo is correct handling the corner cases. 
	public double slopeTo(Point that) {	
			
			
			if(that.getPointX() == this.getPointX() && that.getPointY() == this.getPointY()) {
				return Double.NEGATIVE_INFINITY;
			}
		
			if(that.getPointX() == this.getPointX() && that.getPointY() != this.getPointY()) {
				return Double.POSITIVE_INFINITY;
			}
			
			if(that.getPointY() == this.getPointY() && that.getPointX() != this.getPointX()) {
				return 0;
			}
			
			
			
			
			
			return (((double)that.getPointY()) - ((double)this.getPointY()))/(((double)that.getPointX()) - ((double)this.getPointX()));
		
		
		
		
		
	}
	
	/**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
    	
        StdDraw.line(this.pointX, this.pointY, that.pointX, that.pointY);
        
    }
	
	
	public String toString() {
		return "(" + this.pointX + ", " + this.pointY + ")";
	}
	
	
	/*	
	The compareTo() method should compare points by their y-coordinates, 
	breaking ties by their x-coordinates. Formally, 
	the invoking point (x0, y0) is less than the argument point (x1, y1) 
	if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
	*/ 

	@Override
	public int compareTo(Point comparePoint) {
		
		if(this.getPointY() < comparePoint.getPointY()) {
			return -1;
		}else if(this.getPointY() == comparePoint.getPointY() && this.getPointX() < comparePoint.getPointX()) {
				return -1;
		}else if(this.getPointY() > comparePoint.getPointY()){
				return +1;
		}else if(this.getPointY() == comparePoint.getPointY() && this.getPointX() > comparePoint.getPointX()) {
				return +1;
		}else if(this.getPointY() == comparePoint.getPointY() && this.getPointX() == comparePoint.getPointX()){
			return 0;
		}else {
			return 2;
		}
	}

    
	public int getPointX() {
		return pointX;
	}


	private void setPointX(int pointX) {
		this.pointX = pointX;
	}


	public int getPointY() {
		return pointY;
	}


	private void setPointY(int pointY) {
		this.pointY = pointY;
	}
	
	
	public Comparator<Point> slopeOrder(){
		//Assign the current instances point to a method variable that 
		//can be passed in. 
		final Point that = this;
		
		
		
		return  new Comparator<Point>() {
			
			double firstSlope;
			double secondSlope;
			
			public int compare(Point first, Point second) {
				
				 firstSlope = that.slopeTo(first);
				 secondSlope = that.slopeTo(second);
				 
				 
				 /* Standard Recipe for user-defined types
				  * 
				  * - Optimization for reference equality (if param is this)
				  * - Check against null
				  * - Check that two objects are of the same type and cast.
				  * - Compare each significant field:
				  *    Primitives ==
				  *    Objects .equals()
				  *    Array  loop through each entry
				  */
				 
				 if(firstSlope < secondSlope) {
					 return -1;
				 }else if(firstSlope > secondSlope) {
					 return +1;
				 }else if(firstSlope == secondSlope){
					 return 0;
				 }else {
					 return -2;
				 }
				
				 
				 
				
			}
		};
		
		
	}
	
	public static void main(String [] args) {
		
		/*
		 * 10000 0
8000 2000
2000 8000
0  10000

20000 0
18000 2000
2000 18000

10000 20000
30000 0
0 30000
20000 10000

13000 0
11000 3000
5000 12000
9000 6000
		 */
//	 	In in = new In(args[0]);
//	    int n = in.readInt();
//	    Point[] points = new Point[n];
//	    for (int i = 0; i < n; i++) {
//	        int x = in.readInt();
//	        int y = in.readInt();
//	        points[i] = new Point(x, y);
//	    }
//		
		//Array.sort(points);
	    
	    
		
		//System.out.println(x.slopeOrder(y));
		
		Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 8);
        Point p3 = new Point(1, 4);
        Point p4 = new Point(-3, 1);
        Point p5 = new Point(2, 2);
        Point p6 = new Point(1, 1);
        double slope2 = p1.slopeTo(p2);
        double slope3 = p1.slopeTo(p3);
        double slope4 = p1.slopeTo(p4);
        double slope5 = p1.slopeTo(p5);
        double slope6 = p1.slopeTo(p6);
        System.out.println("slope2 = " + slope2);
        System.out.println("slope3 = " + slope3);
        System.out.println("slope4 = " + slope4);
        System.out.println("slope5 = " + slope5);
        System.out.println("slope5 = " + slope5);
        System.out.println("slope6 = " + slope6);
        
        

    	
        p1 = new Point(1000,1000);
        p2 = new Point(2000,2000);
        p3 = new Point(1000,2000);
        p4 = new Point(500,500);
        p5 = new Point(1000,500);
        p6 = new Point(1000,1000);
        
        System.out.println(p1.compareTo(p2));
        System.out.println(p1.compareTo(p3));
        System.out.println(p1.compareTo(p4));
        System.out.println(p1.compareTo(p5));
        System.out.println(p1.compareTo(p6));
        
        
	}
	
}

	//Comparators
	class SortByXCoordinate implements Comparator<Point>{
	
		@Override
		public int compare(Point o1, Point o2) {
			return o1.getPointX() - o2.getPointX();
		}
		
	}
	
	class SortByYCoordinate implements Comparator<Point>{
		public int compare(Point o1, Point o2) {
			return o1.getPointY() - o2.getPointY();
		}
	}
