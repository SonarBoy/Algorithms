package OddsAndEnds;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import Sorting.InsertionSortWithComparator;

public class SortingStabilityExample {

	public static void main(String[] args) {
		
		
		try {
			File file = new File("C:\\Users\\Reginald\\eclipse-workspace\\DataAlgo\\src\\Sorting\\DogInfo.txt");
			
			Scanner sc = new Scanner(file);
			Scanner work;
			
			ArrayList<Dog> dogs = new ArrayList<Dog>();
			
			String firstName = "";
			String lastName = "";
			int age = -1;
			
			
			//sc.useDelimiter(";");
			//System.out.println("===============");
			for(int runner = 0;sc.hasNext();runner++) {
				
				//sc.useDelimiter(";");
				//while(sc.hasNext()) {
				//	System.out.println(sc.next());
				//	System.out.println();
				//}
				
				//System.out.println(sc.next());
				
				if(!sc.hasNext()) {
					break;
				}
				
				
				
				//System.out.println("===============");
				
				String x = sc.next();
				work = new Scanner(x);
				work.useDelimiter(";");
				
				//while(work.hasNext()) {
				//	System.out.println(work.next());
				//}
				
				for(int secondRunner = 0; work.hasNext();secondRunner++) {
					//System.out.println(work.next());
					
					if(secondRunner == 0) {
						
						firstName = work.next(); 
						
					}else if(secondRunner == 1) {
						
						lastName = work.next();
						
					}else if(secondRunner == 2) {
						
						age = Integer.parseInt(work.next());
					}
					
					
				}
				
				dogs.add(new Dog(firstName,lastName,age));
				
				
				//System.out.println("===============");
				//System.out.println(sc.nextLine());
				//sc.useDelimiter("");
			}
			
			
			Dog[] dogArray = dogs.toArray(new Dog[0]);
			
			
			for(Dog x: dogArray) {
				System.out.println(x);
			}
//			System.out.println("===============");
			
			
			System.out.println("=======Sort By Age========");
			//Collections.sort(dogs, new SortByFirstName());
			Arrays.sort(dogArray);
			
			
			for(Dog x: dogArray) {
				System.out.println(x.toString());
			}
			
			System.out.println("======Sort By Last Name=========");
			//Collections.sort(dogs, new SortByLastName());
			InsertionSortWithComparator.sort(dogArray, new SortByLastName());
			
			for(Dog x: dogArray) {
				System.out.println(x.toString());
			}
			
//			System.out.println("======Sort By First Name=========");
//			//Collections.sort(dogs, new SortByLastName());
//			SelectionSortWithComparator.sort(dogArray, new SortByFirstName());
//			
//			for(Dog x: dogArray) {
//				System.out.println(x.toString());
//			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
