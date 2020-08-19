package Sorting;

import java.util.ArrayList;
import java.util.Collections;



public class Tester {

	public static void main(String[] args) {
		Integer[] array = new Integer[10];
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
		
		
		SelectionSort.sort(array);
		
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
		
		
		
		//System.out.println(39 / 10);
		//System.out.println(452 / 10);
		//System.out.println((9 / 2));
		
		
		//STEP 3.
		Dog[] dogArray = new Dog[4];
		dogArray[0] = new Dog("Jeff",5);
		dogArray[1] = new Dog("Zack",2);
		dogArray[2] = new Dog("Zacsk",3);
		dogArray[3] = new Dog("Zacvk",4);
		dogArray[3] = new Dog("Don",10);
		
		
		
		InsertionSort.sort(dogArray);
		
		
		
		
		ArrayList<Student> studentList = new ArrayList<Student>(); 
		
		
        studentList.add(new Student(111, "bbbb", "london")); 
        studentList.add(new Student(131, "aaaa", "nyc")); 
        studentList.add(new Student(121, "cccc", "jaipur")); 
  
        System.out.println("Unsorted"); 
        
        for (int runner=0; runner<studentList.size(); runner++) 
            System.out.println(studentList.get(runner)); 
  
        Collections.sort(studentList, new SortByRoll()); 
  
        System.out.println("\nSorted by rollno"); 
        for (int i=0; i<studentList.size(); i++) 
            System.out.println(studentList.get(i)); 
  
        Collections.sort(studentList, new SortByName()); 
  
        System.out.println("\nSorted by name"); 
        for (int i=0; i<studentList.size(); i++) 
            System.out.println(studentList.get(i)); 
		
	}

}
