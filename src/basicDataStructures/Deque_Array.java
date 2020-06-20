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
		
		if(nextHead++ >= tail){
			System.out.println("Last Item");
			return null;
		}
		
		
		
		
		Item toReturn = items[head++];
		items[head] = null;
		size--;
		
		return toReturn;
	}
	
	
	public Item removeLast() {
		
		int nextTail = tail;
		
		if(nextTail-- <= head){
			System.out.println("Last Item");
			
			return null;
		}
		
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
		
	}
	
	
	
	
	
	
	
	
	
	
	
	private void resize(int capacity,char side) {
		
		Item[]copy = (Item[]) new Object[capacity];
		
		int index = 0;
		
		
		if(side == 'F') {
			
//			System.out.println("Add items in the front.");
			
			
			
			int currentHead = (copy.length) + (head - (items.length )); 
			int currentTail = (copy.length) + (tail - items.length);
			
			int oldHead = head;
			int oldTail = tail;
			
			head = currentHead;
			tail = currentTail;
		
//			System.out.println("Head of new Array: " + currentHead);
//			System.out.println("Tail of new Array: " + currentTail);
			
			for(int runner = currentHead; oldHead <= oldTail;runner++) {
				copy[runner] = items[oldHead];
				oldHead++;
			}
			
			
			
		}
		
		if(side == 'B') {
			
//			System.out.println("Add items in the back.");
			
			int currentHead = head;
			int currentTail = items.length - 1;
			
			int oldHead = head;
			int oldTail = tail;
			
//			System.out.println("Head of new Array: " + currentHead);
//			System.out.println("Tail of new Array: " + currentTail);
			
			for(int runner = currentHead; oldHead <= oldTail; runner++) {
				copy[runner] = items[oldHead];
				oldHead++;
			}
			
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
		
		items = copy;
		
		
		/* Old print out of copy array keep until finailized
		for(int runner = 0; runner < copy.length; runner++) {
			System.out.println("Copy Array Index: "+ runner + " " + copy[runner]);
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
