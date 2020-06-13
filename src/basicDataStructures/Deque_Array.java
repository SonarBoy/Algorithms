package basicDataStructures;

import java.util.Iterator;

public class Deque_Array <Item> implements Iterable<Item> {

	private Item[] items;
	private int head;
	private int tail;
	private int size = 0;
	
	
	public Deque_Array() {
		
		head = 1;
		tail = 1;
		
		items = (Item[]) new Object[3];
		
		

	}
	
	public boolean isEmpty() {
		if(head == tail) {
			return true;
		}else {
			return false;
		}
	}
	
	public int size() {
		return size;
	}
	
	
	public void addFirst(Item inputValue) {
		
		int nextHead = head;
		
		if(nextHead-- < 0) {
			System.out.println("Array needs to be rezised");
			
			
			resize(items.length * 2,'F');
			return;
		}
		
		
		
		if(head == tail) {
			
			System.out.println("Head and tail the same");
			head--;
			items[head] = inputValue;
			
			return;
		}
		
		
		items[head] = inputValue;
		head--;

	}
	
	public void addLast(Item inputValue) {
		
		int nextTail = tail;
		
		if(nextTail++ > items.length - 1) {
			
			System.out.println("Array needs to be rezised");
			
			resize(2,'B');
			
			return;
		}
		
		if(head == tail) {
			
			System.out.println("Head and tail the same");
			tail++;
			items[tail] = inputValue;
			
			return;
		}
		
		items[tail] = inputValue;
		tail++;
		
	}
	
	public void printOutItems() {
		
		for(int runner = 0; runner < items.length;runner++) {
			System.out.println("Item at index " + runner + " : " +items[runner]);
		}
		
		
	}
	
	
	public void objectVariables() {
		
		System.out.println("Length: " + items.length);
		System.out.println("Head: " + head);
		System.out.println("Tail: " + tail);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	private void resize(int capacity,char side) {
		
		Item[]copy = (Item[]) new Object[capacity];
		
		int index = 0;
		
		
		if(side == 'F') {
			
			System.out.println("Add items in the front.");
			
			int currentHead = head - (items.length - 1);
			int currentTail = tail - items.length;
			
			System.out.println("Head of new Array: " + currentHead);
			System.out.println("Tail of new Array: " + currentTail);
			
		}
		
		if(side == 'B') {
			
			System.out.println("Add items in the back.");
			
			int currentHead = head;
			int currentTail = items.length - 1;
			
			System.out.println("Head of new Array: " + currentHead);
			System.out.println("Tail of new Array: " + currentTail);
			
			
			
		}
		
		
		if(capacity > items.length) {
			
			items = copy;
			return;
			
		}else if(capacity < items.length) {
			
			head = 0;
			tail = copy.length;
			
			items = copy;
			return;
		}
		
		
		
		
		/*
		for(int runner = head; runner < tail; runner ++) {
			copy[index] = items[runner];
			index++;
		}
		
		
		
		if(capacity > items.length) {
			
			items = copy;
			return;
			
		}else if(capacity < items.length) {
			
			head = 0;
			tail = copy.length;
			
			items = copy;
			return;
		}
		
		*/
		
	}
	
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
