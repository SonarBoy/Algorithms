package Sorting;

import java.util.Comparator;

/*
 * Comparable example:
 * 	Here we will implement a Comparable example.
 * 
 * Step 1: Create Class and implement the Comparable Interface
 * (ex Dog).
 * 
 * Step 2: Implement the compareTo Method in your class, particularly
 * on the object value that you want to compare.
 * 
 * Step 3: Finally you are ready to compare objects of the type you
 * created here. (ex Dog). Implementation can be found in Tester.java
 * 
 * 
 * Video Tutorial Here.
 * https://www.youtube.com/watch?v=g0_pQCxfgKI
 */


//Step 1.
public class Dog implements Comparable{
	
	private String name;
	private int age;
	
	
	Dog(){
		
	}
	
	Dog(String n,int a){
		this.name = n;
		this.age = a;
	}
	
	
	public String getDogName() {
		return this.name;
	}
	
	public int getDogAge() {
		return this.age;
	}
	
	//STEP 2.
	public int compareTo(Object dog) {
		
		Dog dogInQuestion = (Dog) dog;
		return this.age - dogInQuestion.age;
	}
	
}
