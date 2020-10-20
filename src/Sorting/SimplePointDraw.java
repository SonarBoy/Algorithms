package Sorting;
import basicDataStructures.StdDraw;

public class SimplePointDraw {
	
	public static void main(String []args) {
	    // read the n points from a file
	    
	    Point[] points = new Point[4];
	    points[0] = new Point(10,10);
	    points[1] = new Point(200,200);
	    points[2] = new Point(140,10);
	    points[3] = new Point(200,2300);
	    
	    
	    
	
	    // draw the points
	    StdDraw.enableDoubleBuffering();
	    StdDraw.setXscale(0, 32768);
	    StdDraw.setYscale(0, 32768);
	    for (Point p : points) {
	        p.draw();
	    }
	    StdDraw.show();
	    
	}

}
