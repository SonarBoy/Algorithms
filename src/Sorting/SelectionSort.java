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
		
		
		for(int runner=0; runner < array.length;runner++) {
        	System.out.println(array[runner]);
        }
        System.out.println();
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Selection Sorted Time: " + timeElapsed);
	}
	
	
	private static boolean less(Comparable firstItem, Comparable secondItem){
		return firstItem.compareTo(secondItem) < 0;
	}
	
	private static void exch(Comparable[] array, int firstIndx, int secondIndx) {
		Comparable swap = array[firstIndx];
		array[firstIndx] = array[secondIndx];
		array[secondIndx] = swap;
		
	}
	
	
}
