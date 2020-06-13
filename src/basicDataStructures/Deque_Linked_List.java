package basicDataStructures;

import java.util.Iterator;

public class Deque_Linked_List<Item> implements Iterable<Item>{

	private class Node{
		Item item;
		Node next;
		Node previous;
	}
	
	private Node head = null;
	private Node tail = null;
	public int size = 0;
	
	
	
	public Deque_Linked_List() {
		head = new Node();
		tail = head;
		size = 0;
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
	
	public void addFirst(Item item) {
		Node first = new Node();
		
		first.item = item;
		first.next = head.next;
		
		head = first;
		head.previous = first;
		size++;
		
	}
	
	public void addLast(Item item) {
		
		if(isEmpty()) {
			head.item = item;
			tail = new Node();
			head.next = tail;
			
			
		}else {
			Node addingItem = new Node();
			addingItem.item = item;
			
			tail.item = item;
			tail.next = addingItem;
			
			tail = addingItem;
		}
		
		size++;
	}
	
	public Item removeFirst(){
		
		Node first = head;
		
		head = head.next;
		
		
		size--;
		
		return first.item;
	}
	
	public Item removeLast() {
		
		Node runnerNode = head;
		
		
		for(int runner = 0; runner < size - 2; runner++) {
			runnerNode = runnerNode.next;
		}
		
		
		
		tail = runnerNode;
		System.out.println("Final Item: " + tail.item);
		tail.next = null;
		
		runnerNode = runnerNode.next;
		
		size--;
		
		
		
		return runnerNode.item;
		
	}
	
	public void printQueue() {
		
		Node runnerNode = head;
		
		while(runnerNode.next != null) {
			System.out.println("Print Out: " + runnerNode.item);
			
			runnerNode = runnerNode.next;
		}
		
	}
	

	
	public static void main(String[] args) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
