package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {
	
	int rollNo;
	String name;
	String address;
	
	public Student(int rollNo, String name, String address) {
		this.rollNo = rollNo;
		this.name = name;
		this.address = address;
	}
	
	public String toString() {
		return this.rollNo + " " + this.name + " " + this.address;
	}

}
	
	//Used for sorting in ascending order of roll number.
	class SortByRoll implements Comparator<Student>{

		public int compare(Student o1, Student o2) {			
			return o1.rollNo - o2.rollNo;
		}
		
	}
	
	//Used for sorting in ascending order of roll naem.
	class SortByName implements Comparator<Student>{
		
		public int compare(Student a, Student b) {
			return a.name.compareTo(b.name);
		}
	}
	
	

	
	

