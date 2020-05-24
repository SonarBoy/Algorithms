package Structures;

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
		
		if(tail == items.length) {
			resize(2 * items.length);
		}
		
		items[tail] = item;
		tail++;
	}
	
	public Item dequeue() {
		
		if(head > 0 && head == items.length/4) {
			resize(items.length/2);
		}
		
		int oldHead = head;
		head++;
		return items[oldHead];
	}
	
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		
		int indexesWithValues = (tail - head) + 1;
		int index = 0;
		
		
		System.out.println("Head: "+head);
		
		for(int runner = head; runner < tail;runner++) {
			copy[index] = items[runner];
			index++;
		}
		
		items = copy;
		
	}
	
	public void printOutQueue() {
		System.out.println("Queue Print Out");
		for(int runner = 0; runner < items.length;runner++) {
			System.out.println(items[runner]);
		}
	}
	
	
	
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
