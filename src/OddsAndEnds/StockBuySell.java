package OddsAndEnds;
import java.util.ArrayList; 

//Solution structure 
class Interval { 
	int buy, sell; 
} 

public class StockBuySell { 
 // This function finds the buy sell schedule for maximum profit 
	
	
	void stockBuySell(int price[], int leng){
		 
	     // Prices must be given for at least two days 
	     if (leng == 1) 
	         return; 
	
	     int count = 0; 
	
	     // solution array 
	     ArrayList<Interval> solutions = new ArrayList<Interval>(); 
	
	     // Traverse through given price array 
	     int counter = 0; 
	     
	     while (counter < leng - 1) {
	    	 
	         // Find Local Minima. Note that the limit is (n-2) as we are 
	         // comparing present element to the next element.
	    	 
	         while ((counter < leng - 1) && (price[counter + 1] <= price[counter])) {
	        	 counter++;
	         }
	              
	
	         // If we reached the end, break as no further solution possible 
	         if (counter == leng - 1) {
	        	 break;
	         }
	              
	
	         
	         
	         // Store the index of minima 	         
	         Interval intervals = new Interval(); 
	         intervals.buy = counter++; 
	         

	
	         // Find Local Maxima.  Note that the limit is (n-1) as we are 
	         // comparing to previous element 
	         while ((counter < leng) && (price[counter] >= price[counter - 1])) {
	        	 counter++;
	         }
	              
	
	         // Store the index of maxima 
	         intervals.sell = counter - 1; 
	         solutions.add(intervals); 
	
	         // Increment number of buy/sell 
	         count++; 
	     } 
	
	     // print solution 
	     if (count == 0) {
	    	 
	    	 System.out.println("There is no day when buying the stock "
	                 + "will make profit");
	    	 
	     }else {
	    	 
	    	 
	    	 for (int j = 0; j < count; j++) {
	    		 System.out.println("Buy on day: " + solutions.get(j).buy + "        " + "Sell on day : " + solutions.get(j).sell);
	    	 }
	              
	     }
	
	
	     return; 
	}
	
	public void localMaxima(int price[], int leng) {
		
		ArrayList<Integer> solutions = new ArrayList<Integer>();
		
		
		
		for(int runner = 0; runner < leng; runner++) {
			
			if(runner == 0) {
				if(price[runner] > price[runner + 1]) {
					solutions.add(price[runner]);
				}
			}else {
				
				if(runner == leng - 1) {
					if(price[runner - 1] < price[runner]) {
						solutions.add(price[runner]);
					}
				}else {
					
					if(price[runner - 1] < price[runner] && (price[runner] > price[runner + 1]) ) {
						solutions.add(price[runner]);
					}
					
				}
			}
			
			
			
			
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Solutions: ");
		System.out.println();
		
		for(Integer x: solutions) {
			System.out.println(x);
		}
		
	}
	
	

 public static void main(String args[]) 
 { 
     StockBuySell stock = new StockBuySell(); 

     // stock prices on consecutive days 
     int price[] = { 100, 180, 260, 310, 40, 35, 95 };
     
     
     //int price[] = { 1000, 980, 860, 710, 640, 535, 495 };
     int n = price.length; 

     // fucntion call 
     stock.stockBuySell(price, n); 
     
     stock.localMaxima(price, n);
 } 
} 