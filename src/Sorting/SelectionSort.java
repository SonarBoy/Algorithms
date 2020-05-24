package Sorting;

public class SelectionSort {
	
	private static long start;
	private static long finish;
	private static long timeElapsed;
	
	public static void sort(Comparable[] array) {
		
		start = System.nanoTime();
		
		int leng = array.length;
		
		for(int arrayRunner = 0; arrayRunner < leng; arrayRunner++) {
		
			int min = arrayRunner;
			
			for(int sortRunner = arrayRunner + 1; sortRunner < leng; sortRunner++) {
				
				if(less(array[sortRunner],array[min])) {
					min = sortRunner;
				}
				
				exch(array,arrayRunner,sortRunner);
			}
		}
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Selection Sorted Time: " + timeElapsed);
	}
	
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
		
	}
	
	
}
