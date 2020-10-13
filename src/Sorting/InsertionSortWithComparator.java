package Sorting;

import java.util.Comparator;

public class InsertionSortWithComparator {

	private static long start;
	private static long finish;
	private static long timeElapsed;
	
	public static void sort(Object[] array, Comparator myComparator) {
		
		start = System.nanoTime();
		
		int leng = array.length;
		
		for(int arrayRunner = 0; arrayRunner < leng; arrayRunner++) {
			
			for(int sortRunner = arrayRunner; sortRunner > 0; sortRunner--) {
				
				if(less(myComparator,array[sortRunner],array[sortRunner - 1])) {
					exch(array,sortRunner,sortRunner-1);
				}else {
					break;
				}
				
			}
		}
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        //System.out.println("Insertion Sorted Time: " + timeElapsed);
	}
	
	private static boolean less(Comparator myComparator,Object firstObject, Object secondObject){
		return myComparator.compare(firstObject, secondObject) < 0;
		
	}
	
	private static void exch(Object[] array, int i, int j) {
		
		Object swap = array[i];
		array[i] = array[j];
		array[j] = swap;
		
	}
	
}