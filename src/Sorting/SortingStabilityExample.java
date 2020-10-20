package Sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortingStabilityExample {

	public static void main(String[] args) {
		
		
		try {
			File file = new File("C:\\Users\\Reginald\\eclipse-workspace\\DataAlgo\\src\\Sorting\\DogInfo.txt");
			
			Scanner sc = new Scanner(file);
			Scanner work;
			
			//sc.useDelimiter(";");
			
			while(sc.hasNext()) {
				
				//sc.useDelimiter(";");
				
//				while(sc.hasNext()) {
//					System.out.println(sc.next());
//					System.out.println();
//				}
				
				
				
				System.out.println(sc.next());
				
				if(!sc.hasNext()) {
					break;
				}
				
				System.out.println("===============");
				String x = sc.next();
				work = new Scanner(x);
				work.useDelimiter(";");
				
				while(work.hasNext()) {
					System.out.println(work.next());
				}
				System.out.println("===============");
				
				
				//System.out.println(sc.nextLine());
				//sc.useDelimiter("");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
