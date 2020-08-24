package Sorting;


import basicDataStructures.StdIn;
import basicDataStructures.StdOut;

/******************************************************************************
 *  Compilation:  javac Merge.java
 *  Execution:    java Merge < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/22mergesort/tiny.txt
 *                https://algs4.cs.princeton.edu/22mergesort/words3.txt
 *   
 *  Sorts a sequence of strings from standard input using mergesort.
 *   
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Merge < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *    
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *  
 *  % java Merge < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *  
 ******************************************************************************/

/**
 *  The {@code Merge} class provides static methods for sorting an
 *  array using a top-down, recursive version of <em>mergesort</em>.
 *  <p>
 *  This implementation takes &Theta;(<em>n</em> log <em>n</em>) time
 *  to sort any array of length <em>n</em> (assuming comparisons
 *  take constant time). It makes between
 *  ~ &frac12; <em>n</em> log<sub>2</sub> <em>n</em> and
 *  ~ 1 <em>n</em> log<sub>2</sub> <em>n</em> compares.
 *  <p>
 *  This sorting algorithm is stable.
 *  It uses &Theta;(<em>n</em>) extra memory (not including the input array).
 *  <p>
 *  For additional documentation, see
 *  <a href="https://algs4.cs.princeton.edu/22mergesort">Section 2.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  For an optimized version, see {@link MergeX}.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Merge  {
	
	private static long start;
	private static long finish;
	private static long timeElapsed;
	
	private static final int CUTOFF = 7;
	
    // This class should not be instantiated.
    private Merge() { }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays

        assert isSorted(array, lo, mid);
        assert isSorted(array, mid+1, hi);

        // Copy to Aux array.
        
        for (int mainRunner = lo; mainRunner <= hi; mainRunner++) {
            aux[mainRunner] = array[mainRunner]; 
        }

        // merge back to a[]
        int leftHalfPointer = lo, rightHalfPointer = mid+1;
        
        for (int listRunner = lo; listRunner <= hi; listRunner++) {
        	
            if(leftHalfPointer > mid) {
            	
            	array[listRunner] = aux[rightHalfPointer++];
            	
            }else if (rightHalfPointer > hi) {
            	
            	array[listRunner] = aux[leftHalfPointer++];
            	
            }else if (less(aux[rightHalfPointer], aux[leftHalfPointer])) {
            	
            	array[listRunner] = aux[rightHalfPointer++];
            	
            }else{
            	
            	array[listRunner] = aux[leftHalfPointer++];
            	
            }
        }

        // postcondition: a[lo .. hi] is sorted
        assert isSorted(array, lo, hi);
    }

    /***************************************************************************
     *  Index mergesort.
     ***************************************************************************/
     // stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
     private static void merge(Comparable[] array, int[] index, int[] aux, int lo, int mid, int hi) {

         // copy to aux[]
         for (int mainRunner = lo; mainRunner <= hi; mainRunner++) {
             aux[mainRunner] = index[mainRunner]; 
         }

         // merge back to a[]
         int i = lo, j = mid+1;
         
         for (int k = lo; k <= hi; k++) {
         	
         	
             if(i > mid) {
             	
             	index[k] = aux[j++];
             	
             }else if (j > hi) {
             	
             	index[k] = aux[i++];
             	
             }else if (less(array[aux[j]], array[aux[i]])) {
             	
             	index[k] = aux[j++];
             	
             }else{
             	
             	index[k] = aux[i++];
             	
             }
             
         }
     }
    

     
     /**
      * Rearranges the array in ascending order, using the natural order.
      * @param array the array to be sorted
      */
     public static void sort(Comparable[] array) {
    	 
    	 start = System.nanoTime();
    	 
         Comparable[] aux = new Comparable[array.length];
         sort(array, aux, 0, array.length-1);
         assert isSorted(array);
     }

    
    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] array, Comparable[] aux, int lo, int hi) {
    	
    	
    	/*Old way without improvements
    	 * if (hi <= lo) { 
        	return;
        	}
    	 */
    	
    	//With Improvements 
        if (hi <= lo + CUTOFF - 1) {
        	insertionSort(array,lo,hi);
        	return;
        }
        
        int mid = lo + (hi - lo) / 2;
        
        
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        
        if (!less(array[mid+1], array[mid])) {
            System.arraycopy(array, lo, aux, lo, hi - lo + 1);
            return;
        }
        
        
        
        merge(array, aux, lo, mid, hi);
    }
    
    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] array, int[] index, int[] aux, int lo, int hi) {
    	
        if (hi <= lo) { 
        	return;
        }
        
        int mid = lo + (hi - lo) / 2;
        
        sort(array, index, aux, lo, mid);
        sort(array, index, aux, mid + 1, hi);
        
       
        
        merge(array, index, aux, lo, mid, hi);
    }


    

   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] array) {
        return isSorted(array, 0, array.length - 1);
    }

    private static boolean isSorted(Comparable[] array, int lo, int hi) {
    	
        for (int i = lo + 1; i <= hi; i++) {
        	if (less(array[i], array[i-1])) {
        		return false;
        	}
        }
            
        
        return true;
    }
    
    /**
     * Returns a permutation that gives the elements in the array in ascending order.
     * @param array the array
     * @return a permutation {@code p[]} such that {@code a[p[0]]}, {@code a[p[1]]},
     *    ..., {@code a[p[N-1]]} are in ascending order
     */
    public static int[] indexSort(Comparable[] array) {
    	
        int n = array.length;
        int[] index = new int[n];
        
        
        for (int i = 0; i < n; i++) {
        	index[i] = i;
        }
            

        int[] aux = new int[n];
        
        sort(array, index, aux, 0, n-1);
        
        return index;
    }

   
    // print array to standard output
    static void show(Comparable[] array) {
    	
    	finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Merge Sort Time: " + timeElapsed);
        
    	
        for (int i = 0; i < array.length; i++) {
            StdOut.println(array[i].toString());
        }
    }

    // sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(Comparable[] array, int lo, int hi) {
    	
        for (int arrayRunner = lo; arrayRunner <= hi; arrayRunner++) {
        	
            for (int sortRunner = arrayRunner; sortRunner > lo && less(array[sortRunner], array[sortRunner-1]); sortRunner--) {
            	exch(array, sortRunner, sortRunner-1);
            }
                
        }
    }
    
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    /**
     * Reads in a sequence of strings from standard input; mergesorts them; 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    
    public static void main(String[] args) {
    	System.out.println("Hello");
    	//TODO: Standard input 
    	//String[] a = StdIn.readAllStrings();
    	
    	
        //String[] a = {"J","O","S","H","U","A","C","O","L","L"};
    	//abcdefghijklmnopqrstuvwxyz
        String[] a = {"Z","X","Y","W","V","U","T","S","R","Q","Z","X","Y","W","V","U","T","S","R","Q"};
        
        start = System.nanoTime();
        
        Merge.sort(a);
        
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Merge Sort Time: " + timeElapsed);
        
        
        show(a);
    }
    
    
 
}


