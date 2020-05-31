package basicDataStructures;

public class BasicStack {
	
	private Node first = null;
	
	private long start;
	private long finish;
	private long timeElapsed;
	
	
	private class Node{
		String item;
		Node next;
	}
	
	public BasicStack() {
		start = System.nanoTime();
		
		first = null;
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Created: " + timeElapsed);
	}
	
	public boolean isEmpty(){
		if(first == null) {
			return true;
		}
		
		return false;
	}
	
	
	public void push(String item) {
		
		start = System.nanoTime();
		
		
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Push: " + timeElapsed + " "+ item);
		
	}
	
	public String pop() {
		
		start = System.nanoTime();
		
		String item = first.item;
		first = first.next;
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.print("Pop: " + timeElapsed+ " ");
        
        return item;
	}
}
