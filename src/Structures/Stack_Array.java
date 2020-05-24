package Structures;

import java.util.Iterator;

public class Stack_Array<Item> implements Iterable<Item>{
	
	
	//Main Variables
	private Item[] items;
	private int Index = 0;
	
	//Constructor
	public Stack_Array() {
		items = (Item[]) new Object[1];
		Index = 0;
	}
	
	//Check if its Empty
	public boolean isEmpty() {
		if(Index == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	//Resize to double if the index is the length and then push
	public void push(Item item) {
		
		if(Index == items.length) {
			resize(2 * items.length);
		}
		
		items[Index++] = item;
	}
	
	
	//Resize to half the size if the array is a quarter full. 
	public Item pop(){
		
		if(Index > 0 && Index == items.length/4) {
			resize(items.length/2);
		}
		
		return items[Index--];
		
	}
	
	
	//Resize Method 
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		
		for(int runner = 0; runner < Index; runner++) {
			copy[runner] = items[runner];
		}
		
		items = copy;
	}
	
	
	
	
	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		
		private int i = Index;
		
		@Override
		public boolean hasNext() {
			
			return i > 0;
			
		}

		@Override
		public Item next() {
			
			return items[--i];

		}
		
	}

}
