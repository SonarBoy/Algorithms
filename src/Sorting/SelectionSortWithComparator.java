package Sorting;

import java.util.Comparator;

public class SelectionSortWithComparator {
	
	private static long start;
	private static long finish;
	private static long timeElapsed;
	
	public static void sort(Object[] array, Comparator myComparator) {
		
		start = System.nanoTime();
		
		int leng = array.length;
		
		for(int arrayRunner = 0; arrayRunner < leng; arrayRunner++) {
		
			int min = arrayRunner;
			
			for(int sortRunner = arrayRunner + 1; sortRunner < leng; sortRunner++) {
				
				if(less(myComparator,array[sortRunner],array[min])) {
					min = sortRunner;
				}
				
				exch(array,arrayRunner,sortRunner);
			}
		}
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        //System.out.println("Selection Sorted Time: " + timeElapsed);
	}
	
	
	private static boolean less(Comparator myComparator,Object firstItem, Object secondItem){
		return myComparator.compare(firstItem,secondItem) < 0;
		
		//return firstItem.compareTo(secondItem) < 0;
	}
	
	private static void exch(Object[] array, int firstIndx, int secondIndx) {
		Object swap = array[firstIndx];
		array[firstIndx] = array[secondIndx];
		array[secondIndx] = swap;
		
	}
	
}
	
	