package Sorting;
import basicDataStructures.StdIn;
import basicDataStructures.StdOut;
/******************************************************************************
 *  Compilation:  javac MergeBU.java
 *  Execution:    java MergeBU < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/22mergesort/tiny.txt
 *                https://algs4.cs.princeton.edu/22mergesort/words3.txt
 *   
 *  Sorts a sequence of strings from standard input using
 *  bottom-up mergesort.
 *   
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java MergeBU < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *    
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *  
 *  % java MergeBU < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 ******************************************************************************/

/**
 *  The {@code MergeBU} class provides static methods for sorting an
 *  array using <em>bottom-up mergesort</em>. It is non-recursive.
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
 *  <a href="https://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class MergeBU {

    // This class should not be instantiated.
    private MergeBU() { }

    // stably merge a[lo..mid] with a[mid+1..hi] using aux[lo..hi]
    private static void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int runner = lo; runner <= hi; runner++) {
            aux[runner] = array[runner]; 
        }

        // merge back to a[]
        int leftHalfPointer = lo, rightHalfPointer = mid+1;
        for (int runner = lo; runner <= hi; runner++) {
        	
            if(leftHalfPointer > mid){
            	
            	array[runner] = aux[rightHalfPointer++];  // this copying is unneccessary
            	
            }else if(rightHalfPointer > hi) {
            	
            	array[runner] = aux[leftHalfPointer++];
            	
            }else if(less(aux[rightHalfPointer], aux[leftHalfPointer])) {
            	
            	array[runner] = aux[rightHalfPointer++];
            	
            }else{
            	
            	array[runner] = aux[leftHalfPointer++];
            	
            }
        }

    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param array the array to be sorted
     */
    public static void sort(Comparable[] array) {
        int sortArrayLength = array.length;
        
        Comparable[] aux = new Comparable[sortArrayLength];
        
        for (int length = 1; length < sortArrayLength; length *= 2) {
        	
            for (int lo = 0; lo < sortArrayLength-length; lo += length+length) {
            	
                int mid  = lo+length-1;
                int hi = Math.min(lo+length+length-1, sortArrayLength-1);
                merge(array, aux, lo, mid, hi);
                
            }
        }
        assert isSorted(array);
    }

  /***********************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
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
     * Reads in a sequence of strings from standard input; bottom-up
     * mergesorts them; and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = {"J","O","S","H","U","A","C","O","L"};
        MergeBU.sort(a);
        show(a);
    }
}
