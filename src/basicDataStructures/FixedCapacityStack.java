package basicDataStructures;

public class FixedCapacityStack {
	
	private String[] strings;
	private int Index = 0;
	
	private long start;
	private long finish;
	private long timeElapsed;
	
	
	public FixedCapacityStack(int capacity) {
		
		start = System.nanoTime();
		
		strings  = new String[capacity];
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Created: " + timeElapsed);
	}
	
	public boolean isEmpty() {
		
		start = System.nanoTime();
	
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Is empty: " + timeElapsed);
    
        
        
        return Index == 0;
	}
	
	public void push(String item) {
		
		start = System.nanoTime();
		
		
		Index++;
		strings[Index] = item;
		
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Push: " + timeElapsed);
	}
	
	public String pop() {
		
		start = System.nanoTime();
		
		try {
			
			String value = strings[Index];
			
			Index--;
			strings[Index] = null;
			
			finish = System.nanoTime();
	        timeElapsed = finish - start;
	        System.out.println("Pop: " + timeElapsed);
			
			return value;
		}
		
		catch(Exception x) {
			System.out.println("The Index was out of bounds");
			System.out.println(x);
			
			
			finish = System.nanoTime();
	        timeElapsed = finish - start;
	        System.out.println("Pop: " + timeElapsed);
			
			return "";
		}
		
		
		
	}
	
}
