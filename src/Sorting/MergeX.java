package Sorting;


import basicDataStructures.StdIn;
import basicDataStructures.StdOut;
/******************************************************************************
 *  Compilation:  javac MergeX.java
 *  Execution:    java MergeX < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/22mergesort/tiny.txt
 *                https://algs4.cs.princeton.edu/22mergesort/words3.txt
 *   
 *  Sorts a sequence of strings from standard input using an
 *  optimized version of mergesort.
 *   
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java MergeX < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *    
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *  
 *  % java MergeX < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 ******************************************************************************/

import java.util.Comparator;

/**
 *  The {@code MergeX} class provides static methods for sorting an
 *  array using an optimized version of mergesort.
 *  <p>
 *  In the worst case, this implementation takes
 *  &Theta;(<em>n</em> log <em>n</em>) time to sort an array of
 *  length <em>n</em> (assuming comparisons take constant time).
 *  <p>
 *  This sorting algorithm is stable.
 *  It uses &Theta;(<em>n</em>) extra memory (not including the input array).
 *  <p>
 *  For additional documentation, see
 *  <a href="https://algs4.cs.princeton.edu/22mergesort">Section 2.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class MergeX {
    private static final int CUTOFF = 3;  // cutoff to insertion sort

    // This class should not be instantiated.
    private MergeX() { }

    private static void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {

        // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays
        assert isSorted(array, lo, mid);
        assert isSorted(array, mid+1, hi);

        int leftHalfPointer = lo, rightHalfPointer = mid+1;
        
        for (int listRunner = lo; listRunner <= hi; listRunner++) {
        	
            if(leftHalfPointer > mid) {
            	
            	aux[listRunner] = array[rightHalfPointer++];
            	
            }else if(rightHalfPointer > hi) {
            	
            	aux[listRunner] = array[leftHalfPointer++];
            	
            }else if(less(array[rightHalfPointer], array[leftHalfPointer])) {
            	
            	aux[listRunner] = array[rightHalfPointer++];   
            	
            }else{
            	
            	aux[listRunner] = array[leftHalfPointer++];
            }
        }

        // postcondition: dst[lo .. hi] is sorted subarray
        assert isSorted(aux, lo, hi);
    }

    private static void sort(Comparable[] array, Comparable[] aux, int lo, int hi) {

        // if (hi <= lo) return;
        if (hi <= lo + CUTOFF) { 
        	
            insertionSort(aux, lo, hi);
            return;
            
        }
        
        int mid = lo + (hi - lo) / 2;
        
        
        sort(aux, array, lo, mid);
        sort(aux, array, mid+1, hi);

        // if (!less(src[mid+1], src[mid])) {
        //    for (int i = lo; i <= hi; i++) dst[i] = src[i];
        //    return;
        // }

        // using System.arraycopy() is a bit faster than the above loop
        
        if (!less(array[mid+1], array[mid])) {
            System.arraycopy(array, lo, aux, lo, hi - lo + 1);
            return;
        }

        merge(array, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param array the array to be sorted
     */
    public static void sort(Comparable[] array) {
        Comparable[] aux = array.clone();
        sort(aux, array, 0, array.length-1);  
        assert isSorted(array);
    }

    // sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(Comparable[] array, int lo, int hi) {
    	
    	//LHP = left hand pointer.
    	//RHP = right hand pointer.
    	
        for (int LHP = lo; LHP <= hi; LHP++) {
        	
            for (int RHP = LHP; RHP > lo && less(array[RHP], array[RHP-1]); RHP--) {
            	
            	exch(array, RHP, RHP-1);
            }
        }
        
        
    }


    /*******************************************************************
     *  Utility methods.
     *******************************************************************/

    // exchange a[i] and a[j]
    private static void exch(Object[] array, int firstIndex, int secondIndex) {
    	
        Object swap = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = swap;
        
    }

    // is a[i] < a[j]?
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    // is a[i] < a[j]?
    private static boolean less(Object a, Object b, Comparator comparator) {
        return comparator.compare(a, b) < 0;
    }


    /*******************************************************************
     *  Version that takes Comparator as argument.
     *******************************************************************/

    /**
     * Rearranges the array in ascending order, using the provided order.
     *
     * @param a the array to be sorted
     * @param comparator the comparator that defines the total order
     */
    public static void sort(Object[] a, Comparator comparator) {
        Object[] aux = a.clone();
        sort(aux, a, 0, a.length-1, comparator);
        assert isSorted(a, comparator);
    }

    private static void merge(Object[] src, Object[] dst, int lo, int mid, int hi, Comparator comparator) {

        // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays
        assert isSorted(src, lo, mid, comparator);
        assert isSorted(src, mid+1, hi, comparator);

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                          dst[k] = src[j++];
            else if (j > hi)                           dst[k] = src[i++];
            else if (less(src[j], src[i], comparator)) dst[k] = src[j++];
            else                                       dst[k] = src[i++];
        }

        // postcondition: dst[lo .. hi] is sorted subarray
        assert isSorted(dst, lo, hi, comparator);
    }


    private static void sort(Object[] src, Object[] dst, int lo, int hi, Comparator comparator) {
        // if (hi <= lo) return;
        if (hi <= lo + CUTOFF) { 
            insertionSort(dst, lo, hi, comparator);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid, comparator);
        sort(dst, src, mid+1, hi, comparator);

        // using System.arraycopy() is a bit faster than the above loop
        if (!less(src[mid+1], src[mid], comparator)) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }

        merge(src, dst, lo, mid, hi, comparator);
    }

    // sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], comparator); j--)
                exch(a, j, j-1);
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

    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length - 1, comparator);
    }

    private static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1], comparator)) return false;
        return true;
    }

    // print array to standard output
    private static void show(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; mergesorts them
     * (using an optimized version of mergesort); 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        //String[] a = StdIn.readAllStrings();
    	String[] a = {"Z","X","Y","W","V","U","T","S","R","Q"};
        MergeX.sort(a);
        show(a);
    }
}

