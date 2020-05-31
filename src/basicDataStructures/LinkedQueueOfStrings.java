package basicDataStructures;

public class LinkedQueueOfStrings {
	
	private Node first, last;

	private long start;
	private long finish;
	private long timeElapsed;
	
	private class Node{
		String item = "";
		Node next = null;
	}
	
	
	public LinkedQueueOfStrings() {
		start = System.nanoTime();
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Created: " + timeElapsed);
	}
	
	
	
	public boolean isEmpty() {
		
		start = System.nanoTime();
		
		if(first == null) {
			
			finish = System.nanoTime();
	        timeElapsed = finish - start;
	        System.out.println("isEmpty: " + timeElapsed);
			
			return true;
		}else {
			
			finish = System.nanoTime();
	        timeElapsed = finish - start;
	        System.out.println("isEmpty: " + timeElapsed);
			
			return false;
		}
	}
	
	public void enqueue(String item) {
		
		start = System.nanoTime();
		
		Node oldlast = last;
		
		last = new Node();
		last.item = item;
		last.next = null;
		
		if(isEmpty()) {
			first = last;
			
			finish = System.nanoTime();
	        timeElapsed = finish - start;
	        System.out.println("enqueue: " + timeElapsed);
			
		}else {
			
			oldlast.next = last;
			
			finish = System.nanoTime();
	        timeElapsed = finish - start;
	        System.out.println("enqueue: " + timeElapsed);

			
		}
	}
	
	public String dequeue() {
		
		start = System.nanoTime();
		
		String item = first.item;
		first = first.next;
		
		if(isEmpty()) {
			last = null;
		}
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("enqueue: " + timeElapsed);

		
		return item;
	}
}
