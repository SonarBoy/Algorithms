package basicDataStructures;

import java.util.NoSuchElementException;

/**
 * 
 * 
 * @author Reginald
 * @see https://dzone.com/articles/doubly-linked-list-in-java
 * @param <Item>
 */

public class DoublyLinkedList<AnyType> {
	
	private ListNode<AnyType> front;
	
	private int size;
	
	public DoublyLinkedList() {
		front = null;
		size = 0;
	}

	
    /**
     * Adding a node to the front of the list.
     *
     * @param x Value to add
     */
	public void addFront(AnyType x) {
		
		if(isEmpty()) {
			front = new ListNode<AnyType>(x);
		}else{
			
			/*
			 * - Reference the old front node.
			 * - Create a new front node with the next node 
			 *   being the old front.
			 * - Reference the old front node back to the new front node.
			 */
			ListNode<AnyType> temp = front;
			front = new ListNode<AnyType>(null,x,temp);
			front.next.prev = front;
		}
		
		size++;
		
	}
	
    /**
     * Inserting a node at the end of the list.
     *
     * @param x Value to add.
     */
	public void addEnd(AnyType x) {
		
		if(isEmpty()) {
			front = new ListNode<AnyType>(x);
		}else{
			
			/*
			 * - Create a reference to the front node.
			 * - Traverse the list until the temp node does 
			 *   have a next node.
			 * - Add the temp node to the end of the list. 
			 */
			ListNode<AnyType> temp = front;
			
			while(temp.next != null) {
				temp = temp.next;
			}
			
			temp.next = new ListNode<AnyType>(temp, x, null);
		}
		
		size++;
	}
	
    /**
     * Adding node before another node
     *
     * @param x Value to look for, adding before x if found
     * @param y Value to add.
     */
	public void addBefore(AnyType x,AnyType y) {
		
		//List is empty, can't add
		if(isEmpty()) {
			throw new NoSuchElementException("Element " + x.toString());
		}
		
		ListNode<AnyType> current = front;
		
		
		//Looping through until found
		while(current != null && !current.data.equals(x)) {
			current = current.next;
		}
		
		
		//If null, not found
		if(current == null) {
			throw new NoSuchElementException("Element "+x.toString());
		}
		
		ListNode<AnyType> newNode =
				new ListNode<AnyType>(current.prev, y, current);
		
		
		if(current.prev != null) {
			current.prev.next = newNode;
		}else {
			front = newNode;
		}
		
		
		current.prev = newNode;
		size++;
		
			
			
	}
	
    /**
     * Adding node after another node
     *
     * @param x Value to look for, adding after x if found
     * @param y Value to add.
     */
	public void addAfter(AnyType x, AnyType y) {
		
		if(isEmpty())
			throw new NoSuchElementException("Element " + x.toString());
		
		ListNode<AnyType> current = front;
		
		while(current != null && !current.data.equals(x)){
			current = current.next;
		}
		
		if(current == null) {
			throw new NoSuchElementException("Element "+ x.toString());
		}
		
		 ListNode<AnyType> newNode = 
				 new ListNode<AnyType>(current, y, current.next);
		 
		 if(current.next != null) {
			 current.next.prev = newNode;
		 }
		 
		 current.next = newNode;
		 
		 size++;
	}
	
	
	
	public void remove(AnyType x) {
		
		if(isEmpty()) {
			throw new NoSuchElementException("Element "+x.toString());
		}
		
		if(front.data.equals(x)) {
			front = front.next;
			return;
		}
		
		ListNode<AnyType> current = front;
		
		while(current != null && !current.data.equals(x)) {
			current = current.next;
		}
		
		
		if(current == null) {
			throw new NoSuchElementException("Element " + x.toString());
		}
		
		if(current.next != null) {
			current.next.prev = current.prev;
		}
		
		current.prev.next = current.next;
		
		size--;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	

}
