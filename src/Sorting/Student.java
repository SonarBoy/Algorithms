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

	/*
	 * - Comparable is an interface defining a strategy of comparing an object
	 * with other objects of the same type.
	 * 
	 * - The sorting order is decided by the return value of the compare To()
	 * method
	 * 
	 * - Comparators how we can use other types of ordering, in a more flexible
	 * way.
	 * 
	 * - The Comparator interface define a compare(args1, args2) method.
	 * 
	 * 
	 * Comparator vs Comparable
	 * The Comparable interface is a good choice when used for 
	 * defining the default ordering or, in other words, if it's the
	 * main way of comparing objects.
	 * 
	 * Then, we must ask ourselves why use a Comparator if we already have 
	 * Comparable?
	 * 
	 *  - Sometimes, we can't modify the source code of the class whose objects
	 *  we want to sort, this making the use of Comparable impossible. 
	 *  
	 *  - Using Comparators allows us to avoid adding additional code to our domain
	 *  classes.
	 *  
	 *  - We can define multiple different comparison strategies which isn't 
	 *  possible when using Comparable.
	 * 
	 * 
	 */
	
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
	
	

	
	

