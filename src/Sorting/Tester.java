package Sorting;

public class Tester {

	public static void main(String[] args) {
		Integer[] array = new Integer[10];
		array[0] = 9;
		array[1] = 8;
		array[2] = 7;
		array[3] = 6;
		array[4] = 5;
		array[5] = 4;
		array[6] = 3;
		array[7] = 2;
		array[8] = 1;
		array[9] = 0;
		
		
		SelectionSort.sort(array);
		
		array = new Integer[10];
		array[0] = 9;
		array[1] = 8;
		array[2] = 7;
		array[3] = 6;
		array[4] = 5;
		array[5] = 4;
		array[6] = 3;
		array[7] = 2;
		array[8] = 1;
		array[9] = 0;
		
		InsertionSort.sort(array);
		
		array = new Integer[10];
		array[0] = 9;
		array[1] = 8;
		array[2] = 7;
		array[3] = 6;
		array[4] = 5;
		array[5] = 4;
		array[6] = 3;
		array[7] = 2;
		array[8] = 1;
		array[9] = 0;
		
		ShellSort.sort(array);
		
	}

}
