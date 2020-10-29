package OddsAndEnds;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java7Examples {
	
	public static void main(String [] args) {
		
		
		/**
		 * Lambda Expressions
			one of the famous feature introduced in Java 8. Lambdas 
			treat functionality as a method argument or code as data. 
			Lambda expressions allow you to present your code more 
			compactly.
		 */
		
		Comparator<Employee> sortByName = new Comparator<Employee>() {
			
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		};
		
		//NEW LAMBDA COMPARATOR SYNTAX
		Comparator<Employee> lambdaSortBySalary = (Employee e1,Employee e2)
				-> (int)(e1.getSalary() - e2.getSalary());
		
				
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(500, "Shifoo", 150000));
		list.add(new Employee(504, "Oogway", 120000));
		list.add(new Employee(503, "Tigress", 100000));
		list.add(new Employee(730, "Mantis", 45000));
		
		
		System.out.println("Initial List : ");
		for(Employee x: list) {
			System.out.println(x.toString());
		}
		
		
		Collections.sort(list,sortByName);
		System.out.println("\nStandard Sorted by Name :");
		for(Employee x: list) {
			System.out.println(x.toString());
		}
		
		Collections.sort(list,lambdaSortBySalary);
		System.out.println("\nStandard Sorted by Salary :");
		for(Employee x: list) {
			System.out.println(x.toString());
		}
		
		
		System.out.println();
		System.out.println();
		
		/**
		 * Default Methods
			From Java 8 onwards your interfaces can have method 
			implementations as well. These implementations are defined 
			with keyword default. The class implementing the interface 
			can access these methods or they can even override the 
			default methods.
		 */
		
		HPWorkJet printer = new HPWorkJet();
		printer.print();
		
		
		System.out.println();
		System.out.println();
		
		
		/**
		 * Date and Time API
			Java 8 comes with a new date-time API under the package 
			java.time. The new API is thread safe. Out of whole new 
			classes under this new API, you may want to know few first 
			like LocalDate, LocalTime, LocalDateTime, 
			DateTimeFormatter
		 */
		
		LocalDate today = LocalDate.now();
		System.out.println("Current Date = "+ today);
		
		LocalDate todayNewYork = LocalDate.now(ZoneId.of("America/New_York"));
		System.out.println("Current Date = "+ todayNewYork);
		
		LocalTime time = LocalTime.now();
		System.out.println("Current Time = " + time);
		
		LocalTime timeLA = LocalTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println("Current LA Time = " + timeLA);
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Current Date Time = " + now);
		
		System.out.println(now.format(DateTimeFormatter.ofPattern("dd/MM/YYYY mm:HH:ss")));
		
		
		/**
		 * Streams
			This is one of the major new features in Java 8. 
			A new package java.util.stream with new functionality 
			which contains classes for processing sequences of 
			elements. Streams can be created using List, Arrays
		 */
		
		String[] array = new String[]{"@","A","D","E",":","C","O)","(","&UH",")(I"};
		Stream<String> stream = Arrays.stream(array);
		
		//Does not work because a stream is not an Itterable.
		//for(Stream x: stream) {
		//System.out.println(x);
		//}
		
		//Prints out everything in the stream object
		stream.forEach(System.out::println);
		System.out.println();
		
		//Print out every stream object given to stream.
		stream = Stream.of(array);
		stream.forEach(System.out::println);
		
		//Prints out every stream object given to the stream list.
		List<String> streamList = Arrays.asList("@","A","D","E",":","C","O)","(","&UH",")(I");
		
		//Old and boring example
		//streamList.stream()
		
		//Filtering Example
		stream = streamList.stream().filter(element -> element.contains("("));;
		
		System.out.println();
		System.out.println("After Filtering");
		stream.forEach(System.out::println);
		System.out.println();
		//Filtering Example		
		
		
		//Collecting Example		
		stream = Stream.of(array);
		System.out.println();
		System.out.println("Lower Case from stream:");
		List<String> results = streamList.stream()
				.map(element -> element.toLowerCase())
				.collect(Collectors.toList());
		
		results.forEach(System.out::println);
		System.out.println();
		//Collecting Example
		
		
		//Matching Example
		boolean isValid = streamList.stream().anyMatch(element -> element.contains("P"));
		System.out.println(isValid);
		//Matching Example
		
		
		
		
		
		/**
		 * Iterating over List 
		 */
		
		System.out.println();
		System.out.println();
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(500, "Shifoo", 150000));
		employeeList.add(new Employee(504, "Oogway", 120000));
		employeeList.add(new Employee(503, "Tigress", 93000));
		employeeList.add(new Employee(730, "Mantis", 45000));
		employeeList.add(new Employee(500, "Ifan", 72000));
		employeeList.add(new Employee(504, "Johnny", 63000));
		employeeList.add(new Employee(503, "Panda", 880000));
		employeeList.add(new Employee(730, "Bob", 75000));
		
		
		employeeList.stream()
		.filter(employee -> employee.getSalary() > 65000 && employee.getSalary() < 100000)
		.forEach(System.out::println);
		
		
		System.out.println();
		System.out.println();
		
		Map<Integer, Employee> items = new HashMap<>();
		items.put(100,new Employee(500, "Shifoo", 150000));
		items.put(101,new Employee(504, "Oogway", 120000));
		items.put(102,new Employee(503, "Tigress", 93000));
		items.put(103,new Employee(730, "Mantis", 45000));
		items.put(104,new Employee(500, "Ifan", 72000));
		items.put(105,new Employee(504, "Johnny", 63000));
		items.put(106,new Employee(503, "Panda", 880000));
		items.put(107,new Employee(730, "Bob", 75000));
		
		
		System.out.println("Printing Map with forEach");
		items.forEach((key,value) -> System.out.println("Key: " + key + " Value : " + value));
		
		
		System.out.println("\nPrinting Map with forEach");
		
		items.forEach((key,value) -> {
			System.out.println("Key : " + key + " Value : "+value);
			
			if("Oogway".contentEquals(value.getName())) {
				System.out.println("Hello Master " + value.getName());
			}
		});
	}
}
