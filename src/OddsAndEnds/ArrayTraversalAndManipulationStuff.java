package OddsAndEnds;

import java.util.HashMap;
import java.util.Map;

public class ArrayTraversalAndManipulationStuff {

	public static void main(String[] args) {
		
		int[] input = new int[]{1, 1, 3, 7, 7, 8, 9, 9, 9, 10};
		int current = input[0];
		boolean found = false;

		for (int i = 0; i < input.length; i++) {
		    if (current == input[i] && !found) {
		        found = true;
		    } else if (current != input[i]) {
		        System.out.print(" " + current);
		        current = input[i];
		        found = false;
		    }
		}
		System.out.print(" " + current);
		System.out.println();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < input.length;i++) {
			int value = input[i];
		    Integer count = map.get(input[i]);
		    
		    System.out.println("Value: "+value+" Count " + count);
		    
		    map.put(value, count != null ? count+1 : 1);
		    
		}
		
		
		Map.Entry<Integer, Integer> biggest = null;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(biggest == null) {
				biggest = entry;
			}
			
			if(biggest.getValue() < entry.getValue()) {
				biggest = entry;
			}
		}
		
		System.out.println("Value: "+biggest.getKey()+" Count " + biggest.getValue());
		
		
		int[] prices = new int[]{2,4,1};
	       int lowest = prices[0];
	        int highest = prices[0];
	        int maxProfit = 0;
	        
	        
	        for(int runner = 0; runner < prices.length; runner++){
	        	for(int runnerTwo = runner + 1; runnerTwo < prices.length;runnerTwo++) {
	        		if(prices[runnerTwo] - prices[runner] > maxProfit) {
	        			maxProfit = prices[runnerTwo] - prices[runner]; 
	        		}
	        	}
	        }
	        
	        
	        
	        System.out.println("maxProfit: " + maxProfit);
	}	

}
