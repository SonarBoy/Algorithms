package basicDataStructures;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
	
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first = null;
	
	public boolean isEmpty() {
		if(first == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void push(Item item) {
		
		Node oldFirst = first;
		
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	
	@Override
	public Iterator<Item> iterator() {	
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Item>{
		
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public Item next() {
			
			Item item = current.item;
			current = current.next;
			return item;
			
		}
		
	}

}
