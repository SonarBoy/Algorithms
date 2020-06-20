package basicDataStructures;

import java.util.Iterator;

public class RandomizedQueue <Item> implements Iterable<Item> {
	
	
	int size;
	Node head;
	Node tail;
	
	private class Node{
		Item item;
		Node next;
		Node previous;
		
		Node(Node nxt, Item data, Node prv){
			this.item = data;
			this.next = nxt;
			this.previous = prv;
		}
		
		Node(Item data){
			this(null, data, null);
		}
	}
	
	public RandomizedQueue() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		
		if(head == null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public int size() {
		return size;
	}
	
	public void enqueue(Item item) {
		if(isEmpty()) {
			Node temp = new Node(item);
			tail = new Node(null);
			
			head = temp;
			
			head.next = tail;
			head.previous = null;
			
			tail.next = null;
			tail.previous = head;
			
			
		}else{
			
			Node runner = head;
			
			while(runner != null) {
				runner = runner.next;
			}
			
			
			Node temp = new Node(item);
			
			
			runner.next.previous = runner.previous;
			
		}
	}
	
	public Item dequeue() {
		return null;
	}
	
	public Item sample() {
		return null;
	}
	
	public void printOut() {
		
		Node runner = head;
		
		while(runner.next != null) {
			System.out.println("Runner Data: "+ runner.item);
			runner = runner.next;
		}
		
	}

	
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
