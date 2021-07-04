
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
	
//	public FastCollinearPoints(Point[] array,boolean t) {
//		
//        Point[] pointsCopySO = Arrays.copyOf(array, array.length);
//        Point[] pointsCopyNO = Arrays.copyOf(array, array.length);
//        ArrayList<LineSegment> segmentsList = new ArrayList<LineSegment>();
//        Arrays.sort(pointsCopyNO);
//        
//        for (int i = 0; i < pointsCopyNO.length; ++i)
//        {
//            Point origin = pointsCopyNO[i];
//            Arrays.sort(pointsCopySO);
//            Arrays.sort(pointsCopySO, origin.slopeOrder());
//            int count = 1;
//            Point lineBeginning = null;
//            for (int j = 0; j < pointsCopySO.length - 1; ++j)
//            {
//                if (pointsCopySO[j].slopeTo(origin) == pointsCopySO[j + 1].slopeTo(origin))
//                {
//                    count++;
//                    if (count == 2)
//                    {
//                        lineBeginning = pointsCopySO[j];
//                        count++;
//                    }
//                    else if (count >= 4 && j + 1 == pointsCopySO.length - 1)
//                    {
//                        if (lineBeginning.compareTo(origin) > 0)
//                        {
//                            segmentsList.add(new LineSegment(origin, pointsCopySO[j + 1]));
//                        }
//                        count = 1;
//                    }
//                }
//                else if (count >= 4)
//                {
//                    if (lineBeginning.compareTo(origin) > 0)
//                    {
//                        segmentsList.add(new LineSegment(origin, pointsCopySO[j]));
//                    }
//                    count = 1;
//                }
//                else
//                {
//                    count = 1;
//                }
//
//
//            }
//
//        }
//        //egments = segmentsList.toArray(new LineSegment[segmentsList.size()]);
//        lines = segmentsList;
//
//	}
	
	public FastCollinearPoints(Point[] array ) {
		
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

		
		Point origin = null;
		Point highestPoint = null;
		
		
		int currentIndx = -1;
		int midIndx = 0;
		int forwardIndx = 1;
		
		
		double currentSlope = 0;
		double midSlope = 0;
		double forwardSlope = 0;
//		for(Point x: pointsToDraw) {
//			System.out.println(x);
//		}
		
		int streakCounter = 0;
		
		Point currentPoint = null;
		Point adderPoint = null;
		Point forwardPoint = null;
	
		boolean hitInternalRunner = false;
		
		for(int rowRunner = 0; rowRunner < arrayLength; rowRunner++) {
			
//			System.out.println();
//			System.out.println("Origin: " + pointsToDraw[rowRunner]);
//			System.out.println();
			
			origin = pointsToDraw[rowRunner];
			Arrays.sort(pointArray, origin.slopeOrder());
			
			currentIndx = 1;
			//midIndx = 1;
			forwardIndx = 2;
			
			for(int columnRunner = 1; forwardIndx <= (arrayLength - 1); columnRunner++) {
				
				
				
				
				currentPoint = pointArray[currentIndx];
				//midPoint = pointArray[midIndx];
				forwardPoint = pointArray[forwardIndx];
				
				currentSlope = origin.slopeTo(currentPoint);
				forwardSlope = origin.slopeTo(forwardPoint);
				
				
//				System.out.println(origin + " and " + currentPoint + " slope: "+ origin.slopeTo(currentPoint));	
//				System.out.println("CurrentIndx: " + currentIndx);
//				//System.out.println("MidIndx: " + midIndx);
//				System.out.println("ForwardIndx: " + forwardIndx);
////				System.out.println(origin + " and CurrentIndx" + pointArray[currentIndx] + " slope: "+ origin.slopeTo(pointArray[forwardIndx]));
//				System.out.println();
				
				
				for(int slopeRunner = currentIndx;
						currentSlope == forwardSlope && 
						slopeRunner <= (arrayLength - 1) && 
						currentSlope == origin.slopeTo(pointArray[slopeRunner]); slopeRunner++) {
					
//					System.out.println("SameSlope");
//					System.out.println("Point : " + pointArray[slopeRunner]);
					
					
					if(slopeRunner == currentIndx) {
						highestPoint = pointArray[slopeRunner];
					}
					
					if(origin.compareTo(pointArray[slopeRunner]) == 1) {
						highestPoint = null;
					}
					
					
					if(highestPoint != null && highestPoint.compareTo(pointArray[slopeRunner]) == -1) {
								
						highestPoint = pointArray[slopeRunner];
					}
							
							
				

					
					
					
					if(highestPoint != null && highestPoint.compareTo(origin) == -1) {
						highestPoint = null;
					}
					
					streakCounter++;
					
				}
				
				
				
				if(highestPoint != null && streakCounter >= 3 && origin.compareTo(highestPoint) < 0) {
//					System.out.println("StreakCounter : " + streakCounter);
//					System.out.println();
//					System.out.println("Line to draw Origin: " + origin + " to "+ highestPoint);
					
					lines.add(new LineSegment(origin,highestPoint));
					
					

					currentIndx += streakCounter - 1;
					forwardIndx += streakCounter - 1;
					
				}else if(highestPoint == null && streakCounter >= 3){
						
					currentIndx += streakCounter - 1;
					forwardIndx += streakCounter - 1;
					
				}else {
					

					currentIndx++;
					forwardIndx++;
				}
				
				highestPoint = null;
				streakCounter = 0;
				
				
			}
			
			
			
			
		}
		
		
		
		
	}

	
//	public FastCollinearPoints(Point[] array) {
//		
//		
//		if(array == null) {
//			throw new IllegalArgumentException(); 
//		}
//		
//		
//		pointsToDraw = array.clone();
//		Arrays.sort(pointsToDraw);
//		
//		
//		pointArray = pointsToDraw.clone();
//		int arrayLength = pointArray.length;
//		
//		for(int backRunner = 0, frontRunner = 1; frontRunner < pointsToDraw.length ; frontRunner++, backRunner++) {
//			
//			if(pointsToDraw[frontRunner] == null) {
//				throw new IllegalArgumentException();
//			}
//			
//			if(pointsToDraw[backRunner] == null) {
//				throw new IllegalArgumentException();
//			}
//			
//			if(pointsToDraw[frontRunner].compareTo(pointsToDraw[backRunner]) == 0) {
//				throw new IllegalArgumentException(); 
//			}
//
//		}
//		//System.out.println(arrayLength);
//		
//		
////		System.out.println("AFTER SORT");
////		
////		for(Point x: pointsToDraw) {
////			System.out.println(x);
////		}
////		
////		System.out.println();
////		System.out.println();
//		
//		
//		int streakCounter = 0;
//		
//		int currentIndx = 0;
//		int forwardIndx = 0;
//		
//		double currentSlope = 0;
//		double forwardSlope = 0;
//		
////		boolean toAdd = true;
//		
//		Arrays.sort(pointArray);
//		
//		Point origin = null;
//		Point highestPoint = null;
//		
//		
//		
//		for(int rowRunner = 0; rowRunner < arrayLength; rowRunner++) {
//			
//			origin = pointsToDraw[rowRunner];
//			
//			Arrays.sort(pointArray, origin.slopeOrder());
//			
//			//WHEN STARTING THE TRAVERSAL OF A LOOP WITH TWO POINTERS MAKE SURE YOU START FROM -1 IF YOU ARE GOING TO INCREMENT THROUGH
//			currentIndx = -1;
//			forwardIndx = 0;
//			
////			toAdd = true;
//			
////			System.out.println("Current Origin: " + origin);
////			System.out.println();
//						
//			
//			//!(forwardIndx >= arrayLength) equals forwardIndx <= arrayLength + 1
//			for(int columnRunner = 0; columnRunner < arrayLength && forwardIndx <= arrayLength + 1; columnRunner++) {
//				
////				System.out.println("Outer: " + pointArray[columnRunner] + " slope it makes with " + origin + " " +
////						origin.slopeTo(pointArray[columnRunner]));
//				
//				
//			
//				currentIndx++;
//				currentSlope = pointArray[currentIndx].slopeTo(origin);
//			
//				
//				forwardIndx++;
//				if(forwardIndx >= arrayLength) {
//					break;
//				}else {
//					forwardSlope = pointArray[forwardIndx].slopeTo(origin);
//				}
//				
////				toAdd = true;
//			
//				//THE SECOND PART OF THIS STATEMENT forwardIndx <= arrayLength + 1 makes sure that it gets into the last element and 
//				//no farther
//				for(int slopeRunner = columnRunner ; currentSlope == forwardSlope && forwardIndx <= arrayLength + 1 ; slopeRunner++) {
//							
//					
////					if(slopeRunner == columnRunner) {
////						System.out.println("------------------START----------------------");
////					}
////					
////						
////					System.out.println("Inner: " + pointArray[slopeRunner] + " slope it makes with " + origin + " " +
////					origin.slopeTo(pointArray[slopeRunner]));
//						
//
//					if(slopeRunner == columnRunner) {
//						highestPoint = pointArray[slopeRunner];
//					}else{
//						
//						if(highestPoint != null && highestPoint.compareTo(pointArray[slopeRunner]) == -1) {
//					
//								highestPoint = pointArray[slopeRunner];
//							
//						}
//						
//					}
//					
////					if(origin.slopeTo(pointArray[slopeRunner]) == currentSlope) {
////						if(origin.compareTo(pointArray[slopeRunner]) == 1) {
////							toAdd = false;
////							break;	
////						}
////					}
//					
//					//origin.compareTo(pointArray[slopeRunner]) != -1
//					//if(origin.compareTo(highestPoint) != -1) {
//						
//						//origin.compareTo(pointArray[slopeRunner]) == 1
////						if(origin.compareTo(highestPoint) == 1) {
////							
////							highestPoint = null;
////							break;
////						}
//					
//					//}
//					
//					if(highestPoint != null && origin.compareTo(pointArray[slopeRunner]) == 1) {
//						highestPoint = null;
//					}
//					
//					
//					if(highestPoint != null && highestPoint.compareTo(origin) == -1) {
//						highestPoint = null;
//						//break;
//					}
//					
//					//THIS IS THE BREAK POINT TO CHECK THE LAST ELEMENT AND NOT GO OVER
//					if(forwardIndx >= arrayLength) {
//						streakCounter++;
//						break;
//					}
//					
//					
//					
//					streakCounter++;
//					forwardSlope = pointArray[forwardIndx].slopeTo(origin);
//					forwardIndx++;
//				}
//				
//			
//
//
//				if(highestPoint != null && streakCounter >= 3) {
//					
////					System.out.println("------------------END----------------------");
////					System.out.println();
////					System.out.println("Origin: " + origin);
////					System.out.println("Highest: " + highestPoint);
////					System.out.println();
//					
//
//					boolean toAdd = true;
//					//System.out.println();
//					for(int runner = 1; runner < pointArray.length; runner++) {
//						
//						if(origin.slopeTo(pointArray[runner]) == currentSlope) {
//							if(origin.compareTo(pointArray[runner]) == 1) {
//								toAdd = false;
//								break;	
//							}
//						}
//					}
//
//					if(toAdd) {
//						lines.add(new LineSegment(origin,highestPoint));
//					}
//					
//					highestPoint = null;
//					
//				}else {
////					System.out.println("------------------END----------------------");
////					System.out.println();
////					System.out.println();
//				}
//				
//
//				columnRunner += streakCounter;
//				currentIndx += streakCounter;
//				streakCounter = 0;
//			}
//			
//			
//		}
//		
//		
//		
//		
//		
//		
//	
//	
//	
//	
//	
//	
//	
//	
//}

	
	
	
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
	    
	    //FastCollinearPoints x = new FastCollinearPoints(points,true);
	    //FastCollinearPoints x = new FastCollinearPoints(points);
	    FastCollinearPoints x = new FastCollinearPoints(points);
	    
	    //for (LineSegment segment : other.segments()) {
		for (LineSegment segment : x.segments()) {
//	        StdOut.println(segment + " SLOPE: " + segment.getP().slopeTo(segment.getQ()));
	    	//System.out.println(segment.toString());
	        segment.draw();
	    }
	
		StdDraw.show();
		
		
//		for (LineSegment segment : other.segments()) {
////	        StdOut.println(segment + " SLOPE: " + segment.getP().slopeTo(segment.getQ()));
//	    	System.out.println(segment.toString());
//	        segment.draw();
//	    }
//	
//		StdDraw.show();
		}

}
