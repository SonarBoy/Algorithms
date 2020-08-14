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
		
		System.out.println("Merge Sort:");
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
		/*
		String[] basic = new String[10];
		basic[0] = "J" + "";
		basic[1] = "O" + "";
		basic[2] = "S" + "";
		basic[3] = "H" + "";
		basic[4] = "U" + "";
		basic[5] = "A" + "";
		basic[6] = "C" + "";
		basic[7] = "O" + "";
		basic[8] = "L" + "";
		basic[9] = "L" + "";
		*/
		
		Merge.sort(array);
		Merge.show(array);
		
		
		
		//System.out.println(39 / 10);
		//System.out.println(452 / 10);
		
		
		System.out.println((9 / 2));
		
		
		
	}

}
