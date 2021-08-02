package OddsAndEnds;

import java.util.ArrayList;

//Java implementation of recursive Binary Search
class BinarySearch {
 // Returns index of x if it is present in arr[l..
 // r], else return -1
 int binarySearch(int arr[], int low, int high, int itemToFind)
 {
	 
	 
     if (high >= low) {
         int mid = low + (high - low) / 2;

         // If the element is present at the
         // middle itself
         if (arr[mid] == itemToFind)
             return mid;

         // If element is smaller than mid, then
         // it can only be present in left subarray
         if (arr[mid] > itemToFind)
             return binarySearch(arr, low, mid - 1, itemToFind);

         // Else the element can only be present
         // in right subarray
         return binarySearch(arr, mid + 1, high, itemToFind);
     }

     // We reach here when element is not present
     // in array
     return -1;
 }

 // Driver method to test above
 public static void main(String args[])
 {
     BinarySearch ob = new BinarySearch();
     int arr[]  = {10,20,30,40,50,60,70,80,90,100};
     
     int n = arr.length;
     int x = 70;
     
     int result = ob.binarySearch(arr, 0, n - 1, x);
     
     if (result == -1)
         System.out.println("Element not present");
     else
         System.out.println("Element found at index " + result);
 }
}
/* This code is contributed by Rajat Mishra */