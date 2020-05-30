package basicDataStructures;

import java.util.Iterator;

public class Queue_Array<Item> implements Iterable<Item> {
	
	
	private Item[] items;
	private int head = 0;
	private int tail = 0;
	
	
	public Queue_Array() {
		items = (Item[]) new Object[1];
	}
	
	
	public boolean isEmpty() {
		if(head == tail) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public void enqueue(Item item) {
		
		if(head == tail) {
			head = 0;
			tail = 0;
		}
		
		if(tail == items.length) {
			resize(2 * items.length);
		}
		
		items[tail] = item;
		tail++;
		
		
		
	}
	
	public Item dequeue() {
		
		int indexesWithValues = (tail - head);
		
		if(indexesWithValues == items.length/4) {
			resize(indexesWithValues);
		}
		
		
		int oldHead = head;
		head++;
		
		return items[oldHead];
		
		
		
		
		
	}
	
	private void resize(int capacity) {
		
		Item[] copy = (Item[]) new Object[capacity];
		int index = 0;
		
		for(int runner = head; runner < tail;runner++) {
			copy[index] = items[runner];
			index++;
		}
		
		
		
		if(capacity > items.length) {
			
			items = copy;		
			return;
			
		}else if(capacity < items.length) {
			
			//Reset the head and tail for the smaller Queue.			
			head = 0;
			tail = copy.length;
			
			items = copy;
			return;
		}
	}
	
	public void printOutQueue() {
		System.out.println("Queue Print Out");
		System.out.println("Head Print out: " + head);
		System.out.println("Tail Print out: " + tail);
		System.out.println("Length: " + items.length);
		for(int runner = 0; runner < items.length;runner++) {
			System.out.println(items[runner]);
		}
	}
	
	
	
	
	
	@Override
	public Iterator<Item> iterator() {
		return new FullListIterator();
	}
	
	private class FullListIterator implements Iterator<Item>{
		
		private int removalIndex = head;
		
		public boolean hasNext() {
			return removalIndex > 0;
		}
		
		public Item next() {
			return items[removalIndex++];
		}
	}
	
	

}
