package Sorting;

import java.util.Collections;

public class FastColinearPoints {
	
	public FastColinearPoints() {
		
	}

	public static void main(String[] args) {
	Point[] pointsArray = new Point[10];
		
//		ArrayList<Point> list = new ArrayList<Point>();
		
		//Basic Straight Line Testing.
//		pointsArray[0] = new Point(0,0);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(2,2);
//		pointsArray[3] = new Point(3,3);
//		pointsArray[4] = new Point(4,4);
//		pointsArray[5] = new Point(5,5);
//		pointsArray[6] = new Point(6,6);
//		pointsArray[7] = new Point(7,7);
//		pointsArray[8] = new Point(8,8);
//		pointsArray[9] = new Point(9,9);
		
//		Extended Line Testing.
//		pointsArray[0] = new Point(0,0);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(2,2);
//		pointsArray[3] = new Point(3,3);
//		pointsArray[4] = new Point(4,4);
//		pointsArray[5] = new Point(5,5);
//		pointsArray[6] = new Point(10,10);
//		pointsArray[7] = new Point(20,20);
//		pointsArray[8] = new Point(30,30);
//		pointsArray[9] = new Point(40,40);
		
//		Two Line Positive Slope	
//		pointsArray[0] = new Point(0,0);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(2,2);
//		pointsArray[3] = new Point(3,3);
//		pointsArray[4] = new Point(4,4);
//		pointsArray[5] = new Point(5,10);
//		pointsArray[6] = new Point(6,12);
//		pointsArray[7] = new Point(7,14);
//		pointsArray[8] = new Point(8,16);
//		pointsArray[9] = new Point(9,18);

		//Two Lines Positive Negative slope
//		pointsArray[0] = new Point(0,0);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(2,2);
//		pointsArray[3] = new Point(3,3);
//		pointsArray[4] = new Point(4,4);
//		pointsArray[5] = new Point(10,6);
//		pointsArray[6] = new Point(9,7);
//		pointsArray[7] = new Point(8,8);
//		pointsArray[8] = new Point(7,9);
//		pointsArray[9] = new Point(6,10);
		
		
//		pointsArray[0] = new Point(0,10);
//		pointsArray[1] = new Point(1,9);
//		pointsArray[2] = new Point(2,8);
//		pointsArray[3] = new Point(3,7);
//		pointsArray[4] = new Point(4,6);
//		pointsArray[5] = new Point(5,5);
//		pointsArray[6] = new Point(6,7);
//		pointsArray[7] = new Point(7,14);
//		pointsArray[8] = new Point(8,16);
//		pointsArray[9] = new Point(9,18);
		
		//Two Line Similar point testing.
//		pointsArray[0] = new Point(1,2);
//		pointsArray[1] = new Point(2,4);
//		pointsArray[2] = new Point(3,6);
//		pointsArray[3] = new Point(4,8);
//		pointsArray[4] = new Point(5,10);
//		pointsArray[5] = new Point(2,6);
//		pointsArray[6] = new Point(3,9);
//		pointsArray[7] = new Point(4,12);
//		pointsArray[8] = new Point(5,15);
//		pointsArray[9] = new Point(6,18);


		//One Line Unique point testing.
//		pointsArray[0] = new Point(2,2);
//		pointsArray[1] = new Point(1,1);
//		pointsArray[2] = new Point(0,0);
//		pointsArray[3] = new Point(4,4);
//		pointsArray[4] = new Point(7,5);
//		pointsArray[5] = new Point(9,2);
//		pointsArray[6] = new Point(6,11);
//		pointsArray[7] = new Point(3,6);
//		pointsArray[8] = new Point(7,9);
//		pointsArray[9] = new Point(12,18);
		
		pointsArray[0] = new Point(2,2);
		pointsArray[1] = new Point(1,1);
		pointsArray[2] = new Point(0,0);
		pointsArray[3] = new Point(7,3);
		pointsArray[4] = new Point(8,4);
		pointsArray[5] = new Point(9,0);
		pointsArray[6] = new Point(10,1);
		pointsArray[7] = new Point(11,2);
		pointsArray[8] = new Point(12,3);
		pointsArray[9] = new Point(10,2);
//		
		
		//Collections.sort(pointsArray, pointsArray[4].slopeOrder());
		
		//InsertionSort.sort(pointsArray);
		
		//Shotgun testing
//		int max = 20;
//		int min = 1;
//		
//		for(int runner = 0; runner < 10; runner++) {
//			pointsArray[runner] = new Point((int)(Math.random() * ((max - min) + 1)) + min,(int)(Math.random() * ((max - min) + 1)) + min);
//			//System.out.println(pointsArray[runner].toString());
//		}
		
	}

}
