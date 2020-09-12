package Sorting;

import java.util.Comparator;
import basicDataStructures.StdDraw;

public class Point implements Comparable<Point> {

	
	private int pointX;
	private int pointY;
	
	
	
	public Point(int x,int y) {
		
		StdDraw.setScale(-50,50);
		
		this.setPointX(x);
		this.setPointY(y);
	}
	
	
	public void draw() {
		
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.point(this.getPointX(), this.getPointY());
		
		
	}
	
	
	//TODO: Make sure slopeTo is correct handling the corner cases. 
	public double slopeTo(Point that) {	
		
		try {
			return ((double)(that.getPointY() - this.getPointY())/(that.getPointX() - this.getPointX()));
		}
		
		catch(Exception x) {
			System.out.println("Calculation threw :" + x.getMessage());
			return 0;
		}
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
		return "X: " + this.getPointX() + " Y: " + this.getPointY();
	}
	
	
	/*	
	The compareTo() method should compare points by their y-coordinates, 
	breaking ties by their x-coordinates. Formally, 
	the invoking point (x0, y0) is less than the argument point (x1, y1) 
	if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
	*/ 

	@Override
	public int compareTo(Point comparePoint) {
		
		if(this.getPointY() < comparePoint.getPointY() 
			|| (this.getPointY() == comparePoint.getPointY() && this.getPointX() < comparePoint.getPointX())) {
				return -1;
		}if(this.getPointX() > comparePoint.getPointX()) {
				return 1;
		}else {
			return 0;
		}
	}


	public int getPointX() {
		return pointX;
	}


	public void setPointX(int pointX) {
		this.pointX = pointX;
	}


	public int getPointY() {
		return pointY;
	}


	public void setPointY(int pointY) {
		this.pointY = pointY;
	}
	
	
	public Comparator<Point> slopeOrder(){
		//Assign the current instances point to a method variable that 
		//can be passed in. 
		Point that = this;
		
		
		
		return  new Comparator<Point>() {
			
			double firstSlope;
			double secondSlope;
			
			public int compare(Point first, Point second) {
				
				 firstSlope = that.slopeTo(first);
				 secondSlope = that.slopeTo(second);
				
				 if(firstSlope > secondSlope) {
					 return -1;
				 }else if(firstSlope < secondSlope) {
					 return 1;
				 }else {
					 return 0;
				 }
				
				
			}
		};
		
		
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
