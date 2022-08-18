package OddsAndEnds;
import java.util.*;  
class GFG{  
      
// Function to find all the local maxima  
// and minima in the given array arr[]  
public static void findLocalMaximaMinima(int n, int[] array) {  
      
    // Empty vector to store points of  
    // local maxima and minima  
    Vector<Integer> maxima = new Vector<Integer>();  
    Vector<Integer> minima = new Vector<Integer>();  
  
    // Checking whether the first point is  
    // local maxima or minima or none  
    if (array[0] > array[1]) {
    	maxima.add(0);
    }else if (array[0] < array[1]) {
    	minima.add(0);
    }
          
  
    // Iterating over all points to check  
    // local maxima and local minima  
    
    for(int runner = 1; runner < n - 1; runner++){
    	
        // Condition for local minima  
    	
        if ((array[runner - 1] > array[runner]) && (array[runner] < array[runner + 1])) {
        	
        	minima.add(runner);
        	
        	// Condition for local maxima
        }else if ((array[runner - 1] < array[runner]) && (array[runner] > array[runner + 1])) {
        	maxima.add(runner);
        }
              
              
          
        
              
    }  
  
    // Checking whether the last point is  
    // local maxima or minima or none  
    if (array[n - 1] > array[n - 2]) {
    	
    	maxima.add(n - 1);
    	
    }else if (array[n - 1] < array[n - 2]) {
    	
    	minima.add(n - 1);
    	
    }
          
  
    // Print all the local maxima and  
    // local minima indexes stored  
    if (maxima.size() > 0) {
    	
        System.out.print("Points of Local " + "maxima are : ");
        
        for(Integer a : maxima)  
            System.out.print(a + " ");
        
        System.out.println();
        
    }else {
    	System.out.println("There are no points " + "of Local Maxima ");  
    }
        
  
    if (minima.size() > 0) {  
    	
        System.out.print("Points of Local " + "minima are : ");
        
        for(Integer a : minima)  
            System.out.print(a + " ");
        
        
        System.out.println();  
    }else {
    	System.out.println("There are no points of " +  "Local Maxima ");
    }
          
}  
  
// Driver code  
public static void main(String[] args)  
{  
    int N = 9;  
  
    // Given array arr[]  
    int arr[] = { 10, 20, 15, 14, 13, 25, 5, 4, 3 };  
  
    // Function call  
    findLocalMaximaMinima(N, arr);  
}  
}  
  
// This code is contributed by divyeshrabadiya07  