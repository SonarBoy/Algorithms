package basicDataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;



public class Deque<Item> implements Iterable<Item> {

	private Item[] items;
	private int head;
	private int tail;
	private int size = 0;
	
	
	public Deque() {
		
		head = 0;
		tail = 1;
		
		items = (Item[]) new Object[3];

	}
	
	public boolean isEmpty() {
		if((tail - head) <= 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public int size() {
		return size;
	}
	
	
	public void addFirst(Item inputValue) {
		
		if (inputValue == null)
			throw new IllegalArgumentException();
		
		
		int nextHead = head;
		
		if(nextHead-- <= 0) {
			//System.out.println("Array needs to be rezised");
			
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
		
		if (inputValue == null)
			throw new IllegalArgumentException();
		
		int nextTail = tail;
		
		if(nextTail++ >= items.length - 1) {
			
			//System.out.println("Array needs to be rezised");
			
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
		
		if(size == 0)
			throw new NoSuchElementException();
		
		int nextHead = head;
		int nextSize = size;
		
		if(nextHead++ >= tail){
			//System.out.println("Last Item");
			return null;
		}
		
		
		if(nextSize-- == items.length/4) {
			//System.out.println("Resize Necessary Current Size: " + nextSize);
			resize((items.length / 2),'F');
		}
		
		
		
		
		int tester = head + 1;
		//System.out.println("Returned Item:" + items[tester]);
		
		
		
		
		Item toReturn = items[tester];
		items[tester] = null;
		head++;
		size--;
		
		return toReturn;
	}
	
	
	public Item removeLast() {
		
		if(size == 0)
			throw new NoSuchElementException();
		
		int nextTail = tail;
		int nextSize = size;
		
		
		if(nextTail-- <= head){
			//System.out.println("Last Item");
			
			return null;
		}
		
		if(nextSize-- == items.length/4) {
			//System.out.println("Resize Necessary Current Size: " + nextSize);
			resize((items.length / 2),'B');
			
		}
		
		int tester = tail - 1;
		//System.out.println("Returned Item:" + items[tester]);
		
		
		Item toReturn = items[tester];
		items[tester] = null;
		tail--;
		size--;
		
		return toReturn;
	}
	
//	public void printOut() {
//		
//		System.out.println("Head: " +head);
//		System.out.println("Tail: " +tail);
//		
//		for(int runner = 0; runner < items.length;runner++) {
//			System.out.println("Item at index " + runner + " : " +items[runner]);
//		}
//		
//		
//	}
//	
//	
	private void shuffle() {
		
		
		for(int runner = head + 1; runner < tail; runner++) {
			
			int r = StdRandom.uniform(head + 1, runner + 1);
			
			Item x = items[r];
			items[r] = items[runner];
			items[runner] = x;
			
			//System.out.println(items[runner] +" "+ r);
		}
	}
//	
//	
//	public void objectVariables() {
//		
//		System.out.println("Length: " + items.length);
//		System.out.println("Head: " + head);
//		System.out.println("Tail: " + tail);
//		System.out.println("Size: " + size);
//		
//	}
	
	
	
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
			
			
			
			
			//Meta Variables for Queue:
			int currentHead = 0;
			int currentTail = 0;
			
			
			
			
//			System.out.println("Array needs to be shrunk");
//			System.out.println("Resized to: " + capacity);
			
//			OLD WAY 
//			int leftSpace = head + 1;
//			int rightSpace = ((items.length - tail) + 1);
			
//			OLD WAY 
//			int rightSpace = ((items.length - tail) - 1);
			
			int leftSpace = head + 1;
			int rightSpace = ((items.length - tail) );
			
			if(leftSpace > rightSpace && leftSpace > capacity) {
				
				
//				System.out.println("Use Left space: " + (head + 1));
//				System.out.println("Size: " + size);
				
				//copy = (Item[]) new Object[capacity + 1];
				
				//Breaks Here with -1 on shrinking resizing
				currentHead = (copy.length) + (head - (items.length)); 
				currentTail = (copy.length) + (tail - items.length);
				
				if(currentTail == items.length - 1) {
					copy = (Item[]) new Object[capacity + 1];
				}

				head = currentHead;
				tail = currentTail;
				
				//potentially change to 1
				int metaReset = 0;
				
				for(int runner = capacity; runner < items.length;runner++) {
					copy[metaReset] = items[runner];
					
					metaReset++;
				}
				
				
				
				
				
				
				
				items = copy;
				return;
				
			}
			
			if(rightSpace > leftSpace && rightSpace > capacity) {
				
				
				copy = (Item[]) new Object[capacity + 1];
				
//				System.out.println("Use Right space: " + ((items.length - tail)+1));
//				System.out.println("Size: " + size);
				
	
				
				//for(int runner = 0; runner <= capacity;runner++) {
				for(int runner = 0; runner < capacity;runner++) {
					copy[runner] = items[runner];
				}
				
				items = copy;
				return;
				
			}
			
			if(leftSpace == rightSpace && leftSpace < capacity) {
				
				copy = (Item[]) new Object[capacity + 1];
				
//				System.out.println("Number of spaces to the left: "+ (head + 1));
//				System.out.println("Number of spaces to the right: "+ ((items.length - tail)+1));
//				System.out.println("Size: "+size);
//				System.out.println("Potential Size change: "+ (capacity - size)/ 2);
				
				int starterPosition = head - ((capacity - size)/ 2);
				
				//for(int runner = 0; runner <= capacity;runner++) {
				for(int runner = 0; runner < capacity;runner++) {
					
					copy[runner] = items[starterPosition];
					
					
					if(starterPosition == head) {
						 head = runner;
					}
					
					if(starterPosition == tail) {
						tail = runner; //Maybe Break out after this.
						break;
					}
					
					starterPosition++;
				}
				
				
				
				items = copy;
				
				return;
				
			}
			
			
			return;
		}
		
		Item[]copy = (Item[]) new Object[capacity];
		
		
		
		
		//Meta Variables for Queue:
		int currentHead = 0;
		int currentTail = 0;
		
		int oldHead = 0;
		int oldTail = 0;
		
		
		
		//FRONT
		if(side == 'F') {
						
			currentHead = (copy.length) + (head - (items.length )); 
			currentTail = (copy.length) + (tail - items.length);
			
			oldHead = head;
			oldTail = tail;
			
			head = currentHead;
			tail = currentTail;
		
		}
		
		//BACK
		if(side == 'B') {
			
			currentHead = head;
			currentTail = items.length - 1;
			
			oldHead = head;
			oldTail = tail;
		
		}
		
		for(int runner = currentHead; oldHead < oldTail; runner++) {
			copy[runner] = items[oldHead];
			oldHead++;
		}

		
		
			
		items = copy;
		return;

		
	}
	
	
	public static void main(String[] args) {
		Deque<String> deq = new Deque<String>();
		
		deq.addFirst("Test1");
	}
	
	
	public Iterator<Item> iterator(){
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item>{

		private int current = (head + 1);
		//private RandomizedQueue<Item> holder;
		
		private int[] holder = new int[size];
		private int counter = 0;

//		private void onCreate() {
//			holder = new RandomizedQueue<Item>();
//			int trialHead = (head + 1);
//			
//			while(trialHead < tail) {
//				holder.enqueue(items[trialHead]);
//				trialHead++;
//			}
//		}
//		
//		public DequeIterator() {
//			onCreate();
//		}
		
		@Override
		public boolean hasNext() {

//			if(counter != size - 1) {
//				return true;
//			}else{
//				return false;
//			}
		
			
//			for(int idx = 0; idx < holder.length; idx++) {
//				if(holder[idx] != -1) {
//					return true;
//				}
//			}
//			
//			return false;
			
			if(current <= (tail - 1)) {
				
				return true;
			}
			
			return false;
			
//			if(holder.isEmpty() == false) {
//				return true;
//			}else {
//				return false;
//			}

		}

		@Override
		public Item next() {
//			
//			boolean found = false;
//			int rand = 0;
//			
//			while(!found) {
//				rand = StdRandom.uniform(current, tail);
//				
//				if(holder[rand - current] != -1) {
//					break;
//				}
//			}
//			
//			holder[rand - current] = -1;
//			return items[rand];
//			
	
			if(hasNext()) {
				
//				System.out.println("Current: " + current);
				
				Item x = items[current];
				current++;
				
				
//				System.out.println("Size: " + size);
				return x;
				
			}else{
				throw new NoSuchElementException();
			}
			
			
			//return null;
			
//			if(hasNext()) {
//			return holder.dequeue();
//		}else{
//			throw new NoSuchElementException();
//		}
			
		}
		
		public void remove() {
			
			throw new UnsupportedOperationException();
			
		}

	}
}