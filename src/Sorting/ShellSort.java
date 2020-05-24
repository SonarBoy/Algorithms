package Sorting;

public class ShellSort {
	
	private static long start;
	private static long finish;
	private static long timeElapsed;
	
	public static void sort(Comparable[] array) {
		
		start = System.nanoTime();
		
		int leng = array.length;
		
		int h = 1;
		
		while(h < leng/3) {
			h = 3 * h + 1;
		}
		
		while(h >= 1) {
			
			
			for(int runner = h ;runner < leng; runner++) {
				for(int sortRunner = runner; sortRunner >= h && less(array[sortRunner],array[sortRunner - h]);sortRunner = h) {
					exch(array,sortRunner,sortRunner-h);
				}
			}
			
			h = h/3;
		}
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Shell Sorted Time: " + timeElapsed);
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
