package basicDataStructures;

import java.util.Iterator;

public class Deque_LinkedList<Item> implements Iterable<Item> {

	private Node head;
	private Node tail;
	private int size = 0;

	private class Node<Item> {
		Node next;
		Node previous;
		Item data;

		public Node(Node n, Item d, Node p) {
			this.next = n;
			this.data = d;
			this.previous = p;
		}

		Node(Item data) {
			this(null, data, null);
		}

	}

	public Deque_LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}

	// return the number of items on the deque
	public int size() {
		return this.size;
	}

	// add the item to the front
	public void addFirst(Item item) {
		
		if(size == 0) {
			Node<Item> temp = new Node<Item>(null, item, null);
			
			head = temp;
			tail = temp;
			size++;
			
		}else if(size == 1) {
			
			
			head = new Node<Item>(item);
			
			head.next = tail;
			tail.previous = head;
			size++;
			
			
//			Node<Item> temp = new Node<Item>(item);
//			temp.
			
		}else {
		
			Node<Item> temp = new Node<Item>(null,item,null);
			
			temp.data = item;
			temp.previous = null;
			temp.next = head;
			head.previous = temp;
		
			head = temp;
			
			
			size++;
		}
	}

	// add the item to the back
	public void addLast(Item item) {
		
		Node<Item> temp = new Node<Item>(null,item,null);
		
		temp.data = item;
		temp.previous = null;
		temp.next = tail;
		
		tail = temp;
		size++;
	}

	// remove and return the item from the front
	public Item removeFirst() {
		Item toReturn = (Item) head.data;
		
		head = head.next;
		head.previous.next = null;
		
		return toReturn;
		
	}

	// remove and return the item from the back
	public Item removeLast() {
		Item toReturn = (Item) tail.data;
		
		tail = tail.previous;
		tail.next.previous = null;
		
		return toReturn;
	}
	
	public void printOut() {
		Node x = head;
		
		while(x.next != null) {
			System.out.println(x.data);
			x = x.next;
		}
		
		System.out.println(x.data);
	}

	// unit testing (required)
	public static void main(String[] args) {
		
		Deque_LinkedList<String> tester = new Deque_LinkedList<String>();
		tester.addFirst("Hello");
		tester.addFirst("There");
		tester.addFirst("Sam");
		tester.addFirst("How");
		tester.addFirst("Has");
		tester.addFirst("Is");
		tester.addFirst("It");
		tester.addFirst("Going");
		
		
		tester.printOut();
		//System.out.println("End");
	}

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
