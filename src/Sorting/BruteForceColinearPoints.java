package Sorting;

import java.util.ArrayList;

public class BruteForceColinearPoints {
	
	Point[] pointArray;
	
	ArrayList<LineSegment> lines = new ArrayList<LineSegment>();
	ArrayList<LineSegment> arrayOfSegments = new ArrayList<LineSegment>();
	
	public BruteForceColinearPoints(Point[] array) {
		
		this.pointArray = array;
		
		
		
		
		double previousSlope = 0;
		int pointStreakCounter = 0;
		
		
		
		for(int index = 0; index < pointArray.length - 4; index++) {
			
			for(int movement = index + 1; movement < pointArray.length ; movement++) {
				
				
				if(index == 0 && movement == 1) {
					previousSlope = pointArray[index].slopeTo(pointArray[movement]);
				}
				
				System.out.println("Comapre: " + pointArray[index] + " to " + pointArray[movement]);
				System.out.println(pointArray[index].slopeTo(pointArray[movement]));
				
				pointArray[index].draw();
				pointArray[movement].draw();
				
				if(previousSlope == pointArray[index].slopeTo(pointArray[movement])) {
					
					
					pointStreakCounter++;
					
					arrayOfSegments.add(new LineSegment(pointArray[index],pointArray[movement]));
					
					
					if(pointStreakCounter == 3) {
						
						for(LineSegment x: arrayOfSegments) {
							
							lines.add(x);
						}
						
						System.out.println("HIT ADD TO THE LINESEGMENT COLLECTION");
						
					}else if(pointStreakCounter > 3) {
						
						lines.add(new LineSegment(pointArray[index],pointArray[movement]));
						
					}

				}else{
					
					arrayOfSegments.removeAll(arrayOfSegments);
					pointStreakCounter = 0;
				
				}
				
				previousSlope = pointArray[index].slopeTo(pointArray[movement]);
			}
			
			System.out.println();
		}
		
		
		for(LineSegment x: lines) {
			System.out.println(x);
			x.draw();
		}
		
	
	
		
	}

	public static void main(String[] args) {
		
		Point[] pointsArray = new Point[7];
		pointsArray[0] = new Point(0,0);
		pointsArray[1] = new Point(1,1);
		pointsArray[2] = new Point(2,2);
		pointsArray[3] = new Point(3,3);
		pointsArray[4] = new Point(4,4);
		pointsArray[5] = new Point(2,7);
		pointsArray[6] = new Point(6,9);
		
		
		BruteForceColinearPoints x = new BruteForceColinearPoints(pointsArray);
	}

}
