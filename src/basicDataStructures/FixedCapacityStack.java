package basicDataStructures;

public class FixedCapacityStack {
	
	private String[] strings;
	private int Index = 0;
	
	
	public FixedCapacityStack(int capacity) {
		strings  = new String[capacity];
	}
	
	public boolean isEmpty() {
		return Index == 0;
	}
	
	public void push(String item) {
		Index++;
		strings[Index] = item;
	}
	
	public String pop() {
		try {
			
			String value = strings[Index];
			
			Index--;
			strings[Index] = null;
			
			
			
			return value;
		}
		
		catch(Exception x) {
			System.out.println("The Index was out of bounds");
			System.out.println(x);
			return "";
		}
		
		
		
	}
	
}
