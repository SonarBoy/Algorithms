package basicDataStructures;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	
	private class Node{
		Item item;
		Node next;
	}
	
	private Node head = null;
	private Node tail = null;
	public int size = 0;
	
	public Queue() {
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
	
	
	public void enqueue(Item item) {
		
		/*
		Node addingItem = head;
		head = new Node();
		head.item = item;
		head.next = addingItem; 
		*/
		
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
		
				
	}
	
	public Item dequeue() {
		
		Node oldHead = head;
		head = head.next;
		
		
		return oldHead.item;
	}
	
	public void printValues() {
			
		while(head.next != null) {
			System.out.println("The Item is " + head.item);
			head = head.next;
		}
		
		System.out.println("Queue has been emptied");
		
	}




	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}}
