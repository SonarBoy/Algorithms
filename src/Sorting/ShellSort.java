package Sorting;

public class ShellSort {
	
	private static long start;
	private static long finish;
	private static long timeElapsed;
	
	
	
	public static void sort(Comparable[] array) {
		
		start = System.nanoTime();
		
		int leng = array.length;
		
		int interLeave = 1;
		
		while(interLeave < leng/3) {
			interLeave = 3 * interLeave + 1;
		}
		
		while(interLeave >= 1) {
			
			
			for(int frontRunner = interLeave ;frontRunner < leng; frontRunner++) {
				
				
				for(int sortRunner = frontRunner; sortRunner >= interLeave && less(array[sortRunner],array[sortRunner - interLeave]);sortRunner -= interLeave) {
					exch(array,sortRunner,sortRunner-interLeave);
				}
			}
			
			assert isHsorted(array, interLeave);
			interLeave = interLeave/3;
		}
		
		assert isSorted(array);
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Shell Sorted Time: " + timeElapsed);
        
        
        for(int runner=0; runner < array.length;runner++) {
        	System.out.println(array[runner]);
        }
        System.out.println();
	}
	
	
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;	
	}
	
	
	  // is the array h-sorted?
    private static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i-h])) return false;
        return true;
    }
    
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    
    
}
