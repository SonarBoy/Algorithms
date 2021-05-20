package OddsAndEnds;

import java.util.Comparator;
import java.util.Iterator;

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
public class Dog<Item> implements Comparable,Iterable{
	
	private String firstName;
	private String lastName;
	private int age;
	
	
	Dog(){
		
	}
	
	Dog(String fName,String lName,int a){
		this.firstName = fName;
		this.lastName = lName;
		this.age = a;
	}
	
	public String getDogFirstName() {
		return this.lastName;
	}
	
	public String getDogLastName() {
		return this.firstName;
	}
	
	public int getDogAge() {
		return this.age;
	}
	
	//STEP 2.
	public int compareTo(Object dog) {
		
		Dog dogInQuestion = (Dog) dog;
		return this.age - dogInQuestion.age;
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.age;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class SortByFirstName implements Comparator<Dog>{
	
	public int compare(Dog first, Dog second) {
		return first.getDogFirstName().compareTo(second.getDogFirstName()) ;
	}
}

class SortByLastName implements Comparator<Dog>{
	
	public int compare(Dog first, Dog second) {
		return first.getDogLastName().compareTo(second.getDogLastName()) ;
	}
}

class SortByAge implements Comparator<Dog>{
	
	public int compare(Dog first, Dog second) {
		return  first.getDogAge() - second.getDogAge() ;
	}
}
