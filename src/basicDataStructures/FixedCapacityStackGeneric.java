package basicDataStructures;

public class FixedCapacityStackGeneric <Item>{
	
	
	private Item[] items;
	private int Index = 0;
	
	private long start;
	private long finish;
	private long timeElapsed;
	
	
	public FixedCapacityStackGeneric(int capacity) {
		
		start = System.nanoTime();
		
		
		
		items = (Item[]) new Object[capacity];
		
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Created: " + timeElapsed);
	}
	
	public boolean isEmpty() {
		
		start = System.nanoTime();
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Created: " + timeElapsed);
		
        
        
		return Index == 0;
	}
	
	public void push(Item item) {
		
		start = System.nanoTime();
		
		
		
		Index++;
		items[Index] = item;
		
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Created: " + timeElapsed);
	}
	
	public Item pop() {
		
		start = System.nanoTime();
		
		
		Item x = items[Index];
		Index--;
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Created: " + timeElapsed);
		
		return x;
	}
	
	

}
