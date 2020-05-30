package basicDataStructures;

public class FixedCapacityStackGeneric <Item>{
	
	
	private Item[] items;
	private int Index = 0;
	
	
	public FixedCapacityStackGeneric(int capacity) {
		items = (Item[]) new Object[capacity];
	}
	
	public boolean isEmpty() {
		return Index == 0;
	}
	
	public void push(Item item) {
		
		Index++;
		
		items[Index] = item;
	}
	
	public Item pop() {
		
		Item x = items[Index];
		
		Index--;
		
		return x;
	}
	
	

}
