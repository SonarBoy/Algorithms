package basicDataStructures;

import java.util.Iterator;

public class Deque_Array <Item> implements Iterable<Item> {

	private Item[] items;
	private int head;
	private int tail;
	private int size = 0;
	
	
	public Deque_Array() {
		
		head = 0;
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
		
		if(nextHead-- <= 0) {
			System.out.println("Array needs to be rezised");
			
			resize(items.length * 2,'F');
			
			
			items[head] = inputValue;
			head--;
			size++;
			
			return;
		}
		
		
		items[head] = inputValue;
		head--;
		
		size++;
	}
	
	public void addLast(Item inputValue) {
		
		int nextTail = tail;
		
		if(nextTail++ >= items.length - 1) {
			
			System.out.println("Array needs to be rezised");
			
			resize(items.length * 2,'B');
			
			items[tail] = inputValue;
			tail++;
			size++;
			
			return;
		}
	
		
		items[tail] = inputValue;
		tail++;
		
		size++;
	}
	
	
	public Item removeFirst() {
		
		int nextHead = head;
		int nextSize = size;
		
		if(nextHead++ >= tail){
			System.out.println("Last Item");
			return null;
		}
		
		
		if(nextSize-- == items.length/4) {
			System.out.println("Resize Necessary Current Size: " + nextSize);
			resize((items.length / 2),'F');
		}
		
		
		
		
		int tester = head + 1;
		System.out.println("Returned Item:" + items[tester]);
		
		
		
		
		Item toReturn = items[head++];
		items[head] = null;
		size--;
		
		return toReturn;
	}
	
	
	public Item removeLast() {
		
		int nextTail = tail;
		int nextSize = size;
		
		
		if(nextTail-- <= head){
			System.out.println("Last Item");
			
			return null;
		}
		
		if(nextSize-- == items.length/4) {
			System.out.println("Resize Necessary Current Size: " + nextSize);
			resize((items.length / 2),'B');
			
		}
		
		int tester = tail - 1;
		System.out.println("Returned Item:" + items[tester]);
		
		
		Item toReturn = items[tail--];
		items[tail] = null;
		size--;
		
		return toReturn;
	}
	
	public void printQueue() {
		
		for(int runner = 0; runner < items.length;runner++) {
			System.out.println("Item at index " + runner + " : " +items[runner]);
		}
		
		
	}
	
	
	public void objectVariables() {
		
		System.out.println("Length: " + items.length);
		System.out.println("Head: " + head);
		System.out.println("Tail: " + tail);
		System.out.println("Size: " + size);
		
	}
	
	
	
	private void resize(int capacity,char side) {
		
		if(capacity < items.length) {
			
			/*
			 * - Determine the position of the values in the items queue
			 * - Determine what side has more nulls weather it is before the head or
			 * after the tail. 
			 * - If the head is after the tail  
			 *
			 * 
			 */
			
			Item[]copy = (Item[]) new Object[capacity];
			
			int index = 0;
			
			
			//Meta Variables for Queue:
			int currentHead = 0;
			int currentTail = 0;
			
			int oldHead = 0;
			int oldTail = 0;
			
			
			
			System.out.println("Array needs to be shrunk");
			
			System.out.println("Resized to: " + capacity);
			
			int leftSpace = head + 1;
			int rightSpace = ((items.length - tail) + 1);
			
			if(leftSpace > rightSpace && leftSpace >= capacity) {
				
				System.out.println("Use Left space: " + (head + 1));
				System.out.println("Size: " + size);
				
				
				currentHead = (copy.length) + (head - (items.length)); 
				currentTail = (copy.length) + (tail - items.length);
				
				head = currentHead;
				tail = currentTail;
				
				
				int metaReset = 0;
				
				for(int runner = capacity; runner < items.length;runner++) {
					copy[metaReset] = items[runner];
					
					metaReset++;
				}
				
				items = copy;
				return;
				
			}
			
			if(rightSpace > leftSpace && rightSpace >= capacity) {
				
				
				copy = (Item[]) new Object[capacity + 1];
				
				System.out.println("Use Right space: " + ((items.length - tail)+1));
				System.out.println("Size: " + size);
				
	
				
				
				for(int runner = 0; runner < capacity;runner++) {
					copy[runner] = items[runner];
				}
				
				items = copy;
				return;
				
			}
			
			if(leftSpace == rightSpace && leftSpace < capacity) {
				
				copy = (Item[]) new Object[capacity + 1];
				
				System.out.println("Number of spaces to the left: "+ (head + 1));
				System.out.println("Number of spaces to the right: "+ ((items.length - tail)+1));
				System.out.println("Size: "+size);
				System.out.println("Potential Size change: "+ (capacity - size)/ 2);
				
				int starterPosition = head - ((capacity - size)/ 2);
				
				for(int runner = 0; runner < capacity;runner++) {
					
					copy[runner] = items[starterPosition];
					
					
					if(starterPosition == head) {
						 head = runner;
					}
					
					if(starterPosition == tail) {
						tail = runner;
					}
					
					starterPosition++;
				}
				
				
				
				items = copy;
				
				return;
				
			}
			
			
			return;
		}
		
		Item[]copy = (Item[]) new Object[capacity];
		
		int index = 0;
		
		
		//Meta Variables for Queue:
		int currentHead = 0;
		int currentTail = 0;
		
		int oldHead = 0;
		int oldTail = 0;
		
		
		
		
		if(side == 'F') {
						
			currentHead = (copy.length) + (head - (items.length )); 
			currentTail = (copy.length) + (tail - items.length);
			
			oldHead = head;
			oldTail = tail;
			
			head = currentHead;
			tail = currentTail;
		
		}
		
		if(side == 'B') {
			
			currentHead = head;
			currentTail = items.length - 1;
			
			oldHead = head;
			oldTail = tail;
		
		}
		
		for(int runner = currentHead; oldHead <= oldTail; runner++) {
			copy[runner] = items[oldHead];
			oldHead++;
		}

		
		
			
		items = copy;
		return;

		
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
