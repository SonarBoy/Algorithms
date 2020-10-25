package Sorting;

import java.util.ArrayList;
import java.util.Collections;



public class Tester {

	public static void main(String[] args) {
		Integer[] array = new Integer[5];
		array[0] = 9;
		array[1] = 8;
		array[2] = 7;
		array[3] = 6;
		array[4] = 5;
//		array[5] = 4;
//		array[6] = 3;
//		array[7] = 2;
//		array[8] = 1;
//		array[9] = 0;
		
		
		SelectionSort.sort(array);
		
		array = new Integer[6];
		array[0] = 9;
		array[1] = 8;
		array[2] = 7;
		array[3] = 5;
		array[4] = 6;
		array[5] = 4;
//		array[6] = 3;
//		array[7] = 2;
//		array[8] = 1;
//		array[9] = 0;
		
		InsertionSort.sort(array);
		
		array = new Integer[10];
		array[0] = 9;
		array[1] = 8;
		array[2] = 7;
		array[3] = 6;
		array[4] = 5;
		array[5] = 4;
		array[6] = 3;
		array[7] = 2;
		array[8] = 1;
		array[9] = 0;
		
		ShellSort.sort(array);
		
		
		array = new Integer[10];
		array[0] = 9;
		array[1] = 8;
		array[2] = 7;
		array[3] = 6;
		array[4] = 5;
		array[5] = 4;
		array[6] = 3;
		array[7] = 2;
		array[8] = 1;
		array[9] = 0;
		/*
		String[] basic = new String[10];
		basic[0] = "J" + "";
		basic[1] = "O" + "";
		basic[2] = "S" + "";
		basic[3] = "H" + "";
		basic[4] = "U" + "";
		basic[5] = "A" + "";
		basic[6] = "C" + "";
		basic[7] = "O" + "";
		basic[8] = "L" + "";
		basic[9] = "L" + "";
		*/
		
		Merge.sort(array);
		Merge.show(array);
		
		
		
		
		
		//STEP 3.
		
		Dog[] dogArray = new Dog[4];
		dogArray[0] = new Dog("Jeff","Sessions",5);
		dogArray[1] = new Dog("Zack","Effron",2);
		dogArray[2] = new Dog("Zacsk","Effron",3);
		dogArray[3] = new Dog("Zacvk","Effron",4);
		dogArray[3] = new Dog("Don","Lemon",10);
		
		
		
		InsertionSort.sort(dogArray);
		
		
		
		/* Comparator Testing.
		ArrayList<Student> studentList = new ArrayList<Student>(); 
		
		
        studentList.add(new Student(111, "bbbb", "london")); 
        studentList.add(new Student(131, "aaaa", "nyc")); 
        studentList.add(new Student(121, "cccc", "jaipur")); 
  
        System.out.println("Unsorted"); 
        
        for (int runner=0; runner<studentList.size(); runner++) 
            System.out.println(studentList.get(runner)); 
  
        Collections.sort(studentList, new SortByRoll()); 
  
        System.out.println("\nSorted by rollno"); 
        for (int runner=0; runner<studentList.size(); runner++) 
            System.out.println(studentList.get(runner)); 
  
        Collections.sort(studentList, new SortByName()); 
  
        System.out.println("\nSorted by name"); 
        for (int runner=0; runner<studentList.size(); runner++) 
            System.out.println(studentList.get(runner)); 
		*/
        
		Point[] pointArray = new Point[5];
		pointArray[0] = new Point(5,5);
		pointArray[1] = new Point(4,5);
		pointArray[2] = new Point(3,3);
		pointArray[3] = new Point(1,-2);
		pointArray[4] = new Point(1,1);
		
		
		 
//		Merge.sort(pointArray);
//		Merge.show(pointArray);
//		
		ArrayList<Point> pointList = new ArrayList<Point>();
		pointList.add(new Point(5,1));
		pointList.add(new Point(4,2));
		pointList.add(new Point(6,10));
		pointList.add(new Point(2,4));
		pointList.add(new Point(1,5));
		
		
		System.out.println("Unsorted");
		for(int pointRunner = 0; pointRunner < pointList.size();pointRunner++) {
			System.out.println(pointList.get(pointRunner));
		}
        
        Collections.sort(pointList,new SortByXCoordinate());
        System.out.println();
        System.out.println("X Sorted");
        
        
        for(int pointRunner = 0; pointRunner < pointList.size();pointRunner++) {
			System.out.println(pointList.get(pointRunner));
		}
        
        System.out.println();
        Collections.sort(pointList,new SortByYCoordinate());
        System.out.println("Y Sorted");
        
        
        for(int pointRunner = 0; pointRunner < pointList.size();pointRunner++) {
			System.out.println(pointList.get(pointRunner));
		}
        
        System.out.println();
        Collections.sort(pointList, pointList.get(1).slopeOrder());
        System.out.println("Testing slope Order");
        
        for(int pointRunner = 0; pointRunner < pointList.size();pointRunner++) {
			System.out.println(pointList.get(pointRunner));
		}
        
       
//        for(int pointRunner = 0; pointRunner < pointList.size();pointRunner++) {
//			System.out.println(pointList.get(pointRunner).slopeOrder().toString());
//		}
//        
		//System.out.println(pointArray[4].slopeTo(pointArray[3]));
		
		
        
        
	}

}
