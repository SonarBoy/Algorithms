package Sorting;
import basicDataStructures.StdIn;
import basicDataStructures.StdOut;
import basicDataStructures.StdRandom;

/******************************************************************************
 *  Compilation:  javac Quick.java
 *  Execution:    java Quick < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/23quicksort/tiny.txt
 *                https://algs4.cs.princeton.edu/23quicksort/words3.txt
 *
 *  Sorts a sequence of strings from standard input using quicksort.
 *   
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Quick < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *       
 *  % java Quick < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 *
 *  Remark: For a type-safe version that uses static generics, see
 *
 *    https://algs4.cs.princeton.edu/23quicksort/QuickPedantic.java
 *
 ******************************************************************************/

/**
 *  The {@code Quick} class provides static methods for sorting an
 *  array and selecting the ith smallest element in an array using quicksort.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/23quick">Section 2.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Quick {

    // This class should not be instantiated.
    private Quick() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param array the array to be sorted
     */
    public static void sort(Comparable[] array) {
    	
        //StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);
        assert isSorted(array);
        
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Comparable[] array, int lo, int hi) { 
    	
        if (hi <= lo) {
        	return;
        }
        
        int mid = partition(array, lo, hi);
        
        sort(array, lo, mid-1);
        sort(array, mid+1, hi);
        
        assert isSorted(array, lo, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] array, int lo, int hi) {
    	
        int leftPointer = lo;
        int rightPointer = hi + 1;
        
        Comparable partition = array[lo];
        
        while (true) { 
        	
            // find item on lo to swap
        	// Sends the next left element to be comapred
            while (less(array[++leftPointer], partition)) {
            	
                if (leftPointer == hi) {
                	break;
                }
                
            }

            // find item on hi to swap
            // Sends the next right element to be comapred
            while (less(partition, array[--rightPointer])) {
            	
                if (rightPointer == lo) {
                	break;      // redundant since a[lo] acts as sentinel
                }
                
            }

            // check if pointers cross
            if (leftPointer >= rightPointer) {
            	break;
            }

            exch(array, leftPointer, rightPointer);
        }

        // put partitioning item v at a[j]
        exch(array, lo, rightPointer);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return rightPointer;
    }

    /**
     * Rearranges the array so that {@code a[k]} contains the kth smallest key;
     * {@code a[0]} through {@code a[k-1]} are less than (or equal to) {@code a[k]}; and
     * {@code a[k+1]} through {@code a[n-1]} are greater than (or equal to) {@code a[k]}.
     *
     * @param  array the array
     * @param  rankOfKey the rank of the key
     * @return the key of rank {@code k}
     * @throws IllegalArgumentException unless {@code 0 <= k < a.length}
     */
    public static Comparable select(Comparable[] array, int rankOfKey) {
    	
        if (rankOfKey < 0 || rankOfKey >= array.length) {
            throw new IllegalArgumentException("index is not between 0 and " + array.length + ": " + rankOfKey);
        }
        
        StdRandom.shuffle(array);
        
        int lo = 0;
        int hi = array.length - 1;
        
        while (hi > lo) {
        	
            int partitionIndex = partition(array, lo, hi);
            
            if(partitionIndex > rankOfKey) {
            	hi = partitionIndex - 1;
            }else if (partitionIndex < rankOfKey) {
            	lo = partitionIndex + 1;
            }else {
            	return array[partitionIndex];
            }
            
        }
        
        return array[lo];
    }



   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable firstItem, Comparable secondItem) {
        if (firstItem == secondItem) {
        	return false;   // optimization when reference equals
        }
        
        return firstItem.compareTo(secondItem) < 0;
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] objectInQuestion, int firstIndex, int secondIndex) {
    	
        Object swap = objectInQuestion[firstIndex];
        
        objectInQuestion[firstIndex] = objectInQuestion[secondIndex];
        
        objectInQuestion[secondIndex] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; quicksorts them; 
     * and prints them to standard output in ascending order. 
     * Shuffles the array and then prints the strings again to
     * standard output, but this time, using the select method.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        //String[] a = StdIn.readAllStrings();
    	
    	//String[] array = {"Z","X","Y","W","V","U","T","S","R","Q"};
    	String[] array = {"W","X","V","R","T","U","Z","S","Y","Q"};
        Quick.sort(array);
        show(array);
        assert isSorted(array);

        // shuffle
        StdRandom.shuffle(array);

        // display results again using select
        StdOut.println();
        for (int i = 0; i < array.length; i++) {
            String ith = (String) Quick.select(array, i);
            StdOut.println(ith);
        }
    }

}
