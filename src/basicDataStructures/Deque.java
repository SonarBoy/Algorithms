package basicDataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;



public class Deque<Item> implements Iterable<Item> {

	private int head;
	private int tail;
	
	private int numberOfElements;
	
	private Item []list;
	
	
	public Deque() {
		
		head = 0;
		tail = 1;
		
		numberOfElements = 0;
		
		list = (Item[]) new Object[3];
		
	}
	
	
	public boolean isEmpty() {
		if(numberOfElements == 0) {
			return true;
		}
		
		return false;
	}
	
	public int size() {
		return numberOfElements;
	}
	
	public void addFirst(Item item) {
		
		if(item == null)
			throw new IllegalArgumentException();
		
		int nextHead = head;
		
		
		if(nextHead-- <= 0) {
			resize(2 * list.length);
		}
		
		
		
		list[head] = item;
		head--;
		numberOfElements++;
		return;
	}
	
	public void addLast(Item item) {
		
		if(item == null)
			throw new IllegalArgumentException();
		
		int nextTail = tail;
		
		if(nextTail++ >=  list.length - 1) {
			resize(2 * list.length);
		}
		
		list[tail] = item;
		tail++;
		numberOfElements++;
		return;
		
	}
	
	public Item removeFirst() {
		
		if(numberOfElements == 0)
			throw new NoSuchElementException();
		
		int nextHead = head;
		
		if(nextHead++ >= tail){
			//System.out.println("Last Item");
			return null;
		}
		
		
		if(list.length/4 >= numberOfElements && list.length/4 >= 5) {
			resize(list.length / 2);
		}
		
		head++;
		Item itemToReturn = list[head];
		list[head] = null;
		
		numberOfElements--;
		
		
		return itemToReturn;
	}
	
	public Item removeLast() {
		
		if(numberOfElements == 0)
			throw new NoSuchElementException();
		
		int nextTail = tail;
		
		if(nextTail-- <= head){
			//System.out.println("Last Item");
			
			return null;
		}
		
		if(list.length/4 >= numberOfElements && list.length/4 >= 5) {
			resize(list.length / 2);
		}
		
		tail--;
		Item itemToReturn = list[tail];
		list[tail] = null;
		
		numberOfElements--;
		
		return itemToReturn;
	}
	
	
	private void printOut() {
	//public void printOut() {
		
		System.out.println("Head: " + head);
		System.out.println("Tail: " + tail);
		
		for(int runner = 0; runner < list.length;runner++) {
			System.out.println(list[runner]);
		}
		
	}
	
	private void objectVariables() {
	//public void objectVariables() {
		
		System.out.println("Head: " + head);
		System.out.println("Tail: " + tail);
		System.out.println("Number of Elements: " + numberOfElements);
		
	}
	
	
	private void resize(int capacity) {
		
		Item[] newList = (Item[]) new Object[capacity];
		
		
		if(capacity < list.length) {
			
			int newHead = (capacity / 2) - 1 - (numberOfElements / 2);
				
			int copyingHead = head;
			int newListHead = newHead;
			
			for(int runner = copyingHead; copyingHead < tail; copyingHead++) {
				newList[newListHead] = list[copyingHead];
				newListHead++;
			}
			
			head = newHead;
			tail = newHead + numberOfElements + 1;
			
			list = newList;
			
			return;
		}
		
		
		if(capacity > list.length) {
			if(numberOfElements ==  0 ) {
//				int newHead = (newList.length) - (list.length - head);
//				int newTail = (newList.length) - (list.length - tail);
				
				
				int newHead = capacity/2;
				
				int copyingHead = head;
				int newListHead = newHead;
				
				for(int runner = copyingHead; copyingHead < tail; copyingHead++) {
					newList[newListHead] = list[copyingHead];
					newListHead++;
				}
		
				head = newHead;
				tail = newHead + 1;
				
				
				list = newList;
				return;
			}else{
				
				
				int splitPoint = numberOfElements / 2;
				
				int newHead = (newList.length / 2) - 1 -  (splitPoint);
				int copyingHead = head;
				int newListHead = newHead;
				
				for(int runner = copyingHead; copyingHead < tail; copyingHead++) {
					newList[newListHead] = list[copyingHead];
					newListHead++;
				}
				
				head = newHead;
				tail = newHead + numberOfElements + 1;
				
				list = newList;
				return;
				
			}
		}
		
	
//		int newHead = (newList.length) - (list.length - head);
//		int newTail = (newList.length) - (list.length - tail);
//		
//		
//		int copyingHead = head;
//		int newListHead = newHead;
//		
//		for(int runner = copyingHead; copyingHead < tail; copyingHead++) {
//			newList[newListHead] = list[copyingHead];
//			newListHead++;
//		}
//
//		head = newHead;
//		tail = newTail;
//		
//		
//		list = newList;
//		return;
		
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
		
		private int[] holder = new int[numberOfElements];
		private int counter = 0;


		
		@Override
		public boolean hasNext() {

			
			if(current <= (tail - 1)) {
				
				return true;
			}
			
			return false;
			
		}

		@Override
		public Item next() {

			if(hasNext()) {
				

				
				Item x = list[current];
				current++;
				
			
				return x;
				
			}else{
				throw new NoSuchElementException();
			}

			
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
