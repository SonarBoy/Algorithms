package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BruteForceColinearPoints {
	
	Point[] pointArray;
	
	ArrayList<LineSegment> lines = new ArrayList<LineSegment>();
	ArrayList<LineSegment> arrayOfSegments = new ArrayList<LineSegment>();
	
	public BruteForceColinearPoints(Point[] array) {
		
		this.pointArray = array;
		
		
		//Slope counter variables
		double previousSlope = 0;
		int pointStreakCounter = 0;
		
		Point starter = null;
		Point ender = null;
		
		
		
		for(int index = 0; index < pointArray.length - 3; index++) {
			for(int movement = index + 1; movement < pointArray.length ; movement++) {
				
				//Capture the previous slope if its the first time.
				if(pointStreakCounter == 0) {
					previousSlope = pointArray[index].slopeTo(pointArray[movement]);
				}
				
				System.out.println("Comapre: " + pointArray[index] + " to " + pointArray[movement]);
				System.out.println(pointArray[index].slopeTo(pointArray[movement]));
				
				
				pointArray[index].draw();
				pointArray[movement].draw();
				
				
				//Compare the current slope value to the previous slope value to see if you have colinear points.
				if(previousSlope == pointArray[index].slopeTo(pointArray[movement])) {
					
					
					//If this is the first point that shares same slope.
					if(pointStreakCounter == 0) {
						
						System.out.println("Potential First Line: ");
						System.out.println(pointArray[index]);
						
						starter = pointArray[index];
					}
					
					
					
					
					pointStreakCounter++;
					arrayOfSegments.add(new LineSegment(pointArray[index],pointArray[movement]));
					
					
					if(pointStreakCounter == 3) {
						
						// Must sort the arrayOfSegments before anything else.
						System.out.println("HIT ADD TO THE LINESEGMENT COLLECTION");
						
						
						for(LineSegment x: arrayOfSegments) {
							lines.add(x);
						}
						
					
						
					}else if(pointStreakCounter >= 3) {
						
//						if(-1 >= pointArray[movement].compareTo(starter)) {
//							System.out.println("TEst");
//						}
						
						
						
						lines.add(new LineSegment(pointArray[index],pointArray[movement]));
					}
				
				//Compare the current slope value to the previous slope value to see if you have colinear points.
				}else{
					
					//Consider jumping in the line					
					index += pointStreakCounter;
					
					if(pointStreakCounter > 3) {
						int holder = lines.size() - 1;
						ender = lines.get(holder).getQ();
						
						

						System.out.println();
						System.out.println("STREAK BROKEN!");
						System.out.println("Starter: " + starter.toString());
						System.out.println("Ender: " + ender.toString());
						System.out.println("STREAK BROKEN!");
						System.out.println();
					}
					
					arrayOfSegments.removeAll(arrayOfSegments);
					//previousSlope = pointArray[index].slopeTo(pointArray[movement]);
					pointStreakCounter = 0;
				}
				
				
				
				
				
			}
			
			
			
						
			System.out.println();

		}
		
		
		for(LineSegment x: lines) {
			System.out.println(x);
			x.draw();
		}
		
		
	}
	
	public void oldMethod(Point[] array) {
		
		this.pointArray = array;
		
		
		//Slope counter variables
		double previousSlope = 0;
		int pointStreakCounter = 0;
		
		Point starter = null;
		Point ender = null;
		
		
		
		for(int index = 0; index < pointArray.length - 3; index++) {
			for(int movement = index + 1; movement < pointArray.length ; movement++) {
				
				//Capture the previous slope if its the first time.
				if(index == 0 && movement == 1) {
					previousSlope = pointArray[index].slopeTo(pointArray[movement]);
				}
				
				System.out.println("Comapre: " + pointArray[index] + " to " + pointArray[movement]);
				System.out.println(pointArray[index].slopeTo(pointArray[movement]));
				
				
				pointArray[index].draw();
				pointArray[movement].draw();
				
				
				//Compare the current slope value to the previous slope value to see if you have colinear points.
				if(previousSlope == pointArray[index].slopeTo(pointArray[movement])) {
					
					
					//If this is the first point that shares same slope.
					if(pointStreakCounter == 0) {
						
						System.out.println("Potential First Line: ");
						System.out.println(pointArray[index]);
						
						starter = pointArray[index];
					}
					
					
					
					
					pointStreakCounter++;
					arrayOfSegments.add(new LineSegment(pointArray[index],pointArray[movement]));
					
					
					if(pointStreakCounter == 3) {
						
						// Must sort the arrayOfSegments before anything else.
						System.out.println("HIT ADD TO THE LINESEGMENT COLLECTION");
						
						
						for(LineSegment x: arrayOfSegments) {
							
							lines.add(x);
						}
						
						
					}else if(pointStreakCounter >= 3) {
						
//						if(-1 >= pointArray[movement].compareTo(starter)) {
//							System.out.println("TEst");
//						}
						
						
						
						lines.add(new LineSegment(pointArray[index],pointArray[movement]));
					}
				
				//Compare the current slope value to the previous slope value to see if you have colinear points.
				}else{
					
					//Consider jumping in the line					
					index += pointStreakCounter;
					
					if(pointStreakCounter > 3) {
						int holder = lines.size() - 1;
						ender = lines.get(holder).getQ();
						
						

						
						System.out.println("BREAK");
						System.out.println("Starter: " + starter.toString());
						System.out.println("Ender: " + ender.toString());
					}
					
					arrayOfSegments.removeAll(arrayOfSegments);
					previousSlope = pointArray[index].slopeTo(pointArray[movement]);
					pointStreakCounter = 0;
					break;
				}
				
				
				
				
				
			}
			
			
			
						
			System.out.println();

		}
		
		
		for(LineSegment x: lines) {
			System.out.println(x);
			x.draw();
		}
		
	}

	public static void main(String[] args) {
		
		Point[] pointsArray = new Point[10];
		
		ArrayList<Point> list = new ArrayList<Point>();
		
		//Basic Straight Line Testing.
//		pointsArray[0] = new Point(0,0);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(2,2);
//		pointsArray[3] = new Point(3,3);
//		pointsArray[4] = new Point(4,4);
//		pointsArray[5] = new Point(2,7);
//		pointsArray[6] = new Point(6,9);
		
		
		//Two Line Similar point testing.
		pointsArray[0] = new Point(1,2);
		pointsArray[1] = new Point(2,4);
		pointsArray[2] = new Point(3,6);
		pointsArray[3] = new Point(4,8);
		pointsArray[4] = new Point(5,10);
		pointsArray[5] = new Point(2,6);
		pointsArray[6] = new Point(3,9);
		pointsArray[7] = new Point(4,12);
		pointsArray[8] = new Point(5,15);
		pointsArray[9] = new Point(6,19);
		
		//Shotgun testing
//		int max = 20;
//		int min = 1;
//		
//		for(int runner = 0; runner < 10; runner++) {
//			pointsArray[runner] = new Point((int)(Math.random() * ((max - min) + 1)) + min,(int)(Math.random() * ((max - min) + 1)) + min);
//			System.out.println(pointsArray[runner].toString());
//		}
		
		
		
		
		
		list.add(new Point(1,2));
		list.add(new Point(2,4));
		list.add(new Point(3,6));
		list.add(new Point(4,8));
		list.add(new Point(5,10));
		list.add(new Point(6,12));
		list.add(new Point(7,14));
		
		//Point[] pointsList = (Point[]) list.toArray(); 
		
		
		//BruteForceColinearPoints x = new BruteForceColinearPoints(pointsArray);
		
		BruteForceColinearPoints x = new BruteForceColinearPoints(pointsArray);
	}

}
