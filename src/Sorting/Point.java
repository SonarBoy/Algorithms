package Sorting;

import java.util.Comparator;
import basicDataStructures.StdDraw;

public class Point implements Comparable<Point> {

	
	private int pointX;
	private int pointY;
	
	public Point(int x,int y) {
		this.pointX = x;
		this.pointY = y;
	}
	
	
	public void draw() {
		StdDraw.point(this.pointX, this.pointY);
	}
	
	public double slopeTo(Point that) {
		
		return (double)((that.pointY - this.pointY)/(that.pointX - this.pointX));
	}
	
	
	
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main() {
		
	}
	

}
