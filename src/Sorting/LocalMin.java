package Sorting;
import java.io.*; 

public class LocalMin {

	    // A binary search based function that returns 
	    // index of a local minima.
	
	    public static int localMinUtil(int array[], int low, int high, int size) { 
	          
	    	 int mid = low + (high - low)/2;  /* (low + high)/2 */
	    	  
	    	    // Compare middle element with its neighbours 
	    	    // (if neighbours exist) 
	    	    if ((mid == 0 || array[mid-1] > array[mid]) && (mid == size-1 || array[mid+1] > array[mid])) {
	    	    	
	    	    	
	    	    	return mid;
	    	    	
	    	    	
	    	    }else if (mid > 0 && array[mid-1] < array[mid]) {
	    	    	
	    	        // If middle element is not minima and its left 
		    	    // neighbour is smaller than it, then left half 
		    	    // must have a local minima. 
		    	     
	    	    	return localMinUtil(array, low, (mid -1), size);
	    	    }
	    	        
	    	         
	    	  
	    	
	    	  
	    	    // If middle element is not minima and its right 
	    	    // neighbour is smaller than it, then right half 
	    	    // must have a local minima. 
	    	    return localMinUtil(array, (mid + 1), high, size); 
	    	    
	    	    
	    	    
	    	 
	    } 
	      
	    // A wrapper over recursive function localMinUtil() 
	    public static int localMin(int[] array, int length) { 
	        return localMinUtil(array, 0, length - 1, length); 
	    } 
	    
	    


	      
	      
	    public static void main (String[] args){ 
	          
	    	//Minimum at 0
	        //int array[] = {3, 10, 11 , 12, 13, 40}; 
	    	
	    	//Minimum at 1
	        //int array[] = {10, 9, 11, 7, 6, 40};
	    	
	    	//Minimum at 2
	        //int array[] = {10, 11, 8, 12, 16, 40};
	    	
	    	//Minimum at 3
	        //int array[] = {10, 12, 11, 7, 11, 40};
	    	
	    	//Minimum at 4
	        //int array[] = {10, 11, 11, 12, 6, 40};
	    	
	    	//Minimum at 5
	        int array[] = {13,4,45,5,6,1,2,3,5,7,11};
	        
	        
	        
	        //int array[] = {23, 8, 15, 2, 3};
	        
	        int size = array.length; 
	        System.out.println("Index of a local minima is " + localMin(array, size));
	        
	        
	     
	    } 
 
}
