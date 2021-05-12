package OddsAndEnds;

public class LocalMinima {

	public int findLocalMinima(int [] array, int start, int end) {
		
		int mid = start + (end - start) / 2;
		int size = array.length;
		
		if((mid == 0 || array[mid - 1] > array[mid]) && 
		   (mid == size - 1 || array[mid + 1] > array[mid])) {
			
			return array[mid];
			
		}else if(mid > 0 && array[mid] > array[mid - 1]) {
			
			return findLocalMinima(array, start, mid);
			
		}else{
			
			return findLocalMinima(array, mid + 1, end);
			
		}
	}
	
	public static void main(String[] args) {
		
		LocalMinima x = new LocalMinima();
		
		int [] array = {10, 5, 21, 20, 13, 16, 7};
		System.out.println(x.findLocalMinima(array, 0, array.length));
		

	}

}
