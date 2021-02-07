package basicDataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue <Item> implements Iterable<Item> {
	
	
	private int size;
	private Node head;
	private Node tail;
	
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
		
		if (item == null)
			throw new IllegalArgumentException();
		
		
		if(isEmpty()) {
			Node temp = new Node(item);
			
			
			head = temp;
			tail = temp;
			size++;
			return;
		}
		
		if(size == 1) {
			//System.out.println(tail.item);
			
			tail = new Node(item);
			
			head.next = tail;
			tail.previous = head;
			size++;
		}else if(size >= 2){
			
			
			Node runner = head;
			Node nextRunner = head.next;
			
			while(runner.next != null) {
				
				if(nextRunner == null) {
					break;
				}
				
				if(runner != head) {
					nextRunner.previous = runner;
				}
				
				runner = runner.next;	
				nextRunner = nextRunner.next;
			}
			
			
			
			
			Node temp = new Node(item);
			runner.next = temp;
			temp.previous = runner;
			tail = temp;
			
		
			size++;
		}
		
		
		
	}
	
	public Item dequeueBad() {
			
			if(size == 0) {
				throw new NoSuchElementException();
			}
			
//			if(size == 1) {
//				size--;
//				
//				
//			}
			
			
			
			
			
			Node runner = head;
			
			int counter = 0;
			int max = size; 
	         
	        
	        
	        int rand = StdRandom.uniform(max); 
	        //int rand = 3; 
	        
	        System.out.println("Deque rand: " + rand);
	        
	        while(counter < rand){
	        	runner = runner.next;
	        	counter++;
	        }
	        
	        System.out.println("Deque end counter: " + counter);
			
	        
	        
//	        if(runner.previous != null) {
//	        	System.out.println("Previous: "+runner.previous.item);
//	        }
	        
	        Item current = runner.item;
	        
	        //System.out.println("Current: "+runner.item);
	        
//	        if(runner.next != null) {
//	        	System.out.println("Next: "+runner.next.item);
//	        }
//	        
	        
	        if(counter == 1) {
	        	
	        	head = runner.next;
		        
	        }else if(counter  == size + 1) {
	        	
	        	tail = runner.previous;
	        	tail.next = null;
	        	
	        }else{
	        	
	        	Node holder = runner.next;
		        runner.previous.next = holder;
	        	runner.next.previous = runner.previous;
	        }
	        
	        size--;
	        
	        
	        return current;
	}
	
	
	public Item dequeue() {
		System.out.println();
		
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		Node runner;
		int counter = 0;
		int rand;
		
		if(size == 1) {
			
			System.out.println("Size: "  + size);
			
			runner = head;
			head = null;
			tail = null;
			size--;
			
			
			System.out.println("ITR: " + runner.item);
			
			return runner.item;
		}
		
		if(size == 2) {
			runner = head;
//			System.out.println("Head: " + head.item);
//			System.out.println("Tail: " + tail.item);
//			System.out.println("Size "  + size);
			
			
			
			rand = StdRandom.uniform(size); 
			
//			System.out.println("Random: " + rand);
			
			
			while(counter < rand) {
//				System.out.println("Counter: " + counter);
				runner = runner.next;
				counter++;
			}
			
			System.out.println("Size: "  + size);
			System.out.println("ITR: " + runner.item);
			
			if(runner.next != null) {
				
				Node itr = runner;
				head = runner.next;
				head.previous = null;
//				System.out.println("Runner.next != null");
				size--;

				return itr.item;
			}
			
			
			if(runner.next == null) {
				Node itr = runner;
				
				head = runner.previous;
				head.next = null;
				tail = head;
				size--;

				return itr.item;
			}
			
		}
		
		
		if(size > 2) {
			runner = head;
//			System.out.println("Size > 2");
//			System.out.println("Head: " + head.item);
//			System.out.println("Tail: " + tail.item);
			
			
			rand = StdRandom.uniform(size); 
			
			while(counter < rand) {
//				System.out.println("Counter: " + counter);
				runner = runner.next;
				counter++;
			}
			
			System.out.println("Size: "  + size);
			System.out.println("ITR: " + runner.item);
			
			
			if(runner == head) {
//				System.out.println("Head element");
				head = null;
				head = runner.next;
				head.previous = null;
				size--;
				return runner.item;
			}
			
			if(runner == tail) {
//				System.out.println("Tail Element");
				tail = null;
				tail = runner.previous;
				tail.next = null;
				size--;
				return runner.item;
			}
			
			if(runner != head && runner != tail) {
//				System.out.println("Center element");
				
	        	Node holder = runner.next;
				runner.previous.next = holder;
				runner.next.previous = runner.previous;
				size--;
				return runner.item;
				
			}
			
			//System.out.println();
		}
		
		System.out.println();
		
		return null;
		
	}
	
	
	
	
	
	
	
//	private void tieBack(){
//		
//		
//			//Set up two pointers to run through the links 
//			Node runner = head;
//			Node nextRunner = head.next;
//			
//			//When the headder pointer hits a null stop
//			while(nextRunner.next != null) {
//				
//				//If the runner is the head pointer tie the nextRunner back to the head.
//				if(runner == head) {
//					nextRunner.previous = head;
//				}
//				
//				//If the runner is not equal to the head assign the nextRunners prior value to the new 
//				//runner
//				if(runner != head) {
//					nextRunner.previous = runner;
//				}
//				
//				//Iterate the two pointers to the next value
//				nextRunner = nextRunner.next;
//				runner = runner.next;
//			}
//			
//			//tieBack the nextRunners previous pointer to the runner.
//			nextRunner.previous = runner;
//	}
	
	
	
	
//	public Item dequeue() {
//		
//		
//		System.out.println("Dequeued: "+head.item);
//		head = head.next;
//		
//		
//		return head.item;
//	}
	
	
	public Item sample() {
		
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		Node runner = head;
		
		int counter = 0;
		int max = size; 

        
        int rand = StdRandom.uniform(max);
        
        
        System.out.println("Sample Random: " + rand);
        
        while(counter < rand){
        	runner = runner.next;
        	counter++;
        }
        
        System.out.println("Sample End Counter: " + counter);
		
        
        //System.out.println("Sample: "+runner.item);
        //System.out.println("Tail: "+tail.item);
        
		
        
        return runner.item;
	}
	
	public void printOut() {
		
		Node runner = head;
		
		
		
		if(runner == null) {
			System.out.println("Queue is Empty.");
			return;
		}
		
		System.out.println("Head: " + head.item);
		System.out.println("Tail: "+ tail.item);
		
		
		while(runner.next != null) {
			System.out.println("Runner Data: "+ runner.item);
			runner = runner.next;
		}
		
		
		//Print out final variable
		System.out.println("Runner Tail Data: "+ runner.item);
		
	}

	public static void main(String[] args) {
		
		RandomizedQueue<String> randomQueue = new RandomizedQueue<String>();
		
		System.out.println("Inserting 1 element then remove");
		System.out.println();
		randomQueue.enqueue("1111");
		randomQueue.printOut();
		randomQueue.dequeue();
		randomQueue.printOut();
		System.out.println();
		System.out.println("Inserting 1 element then remove");
		
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("Inserting 2 element then remove");
		System.out.println();
		
		randomQueue.enqueue("1111");
		randomQueue.enqueue("2222");
//		randomQueue.enqueue("Test3");
//		randomQueue.enqueue("Test4");
//		randomQueue.enqueue("Test5");
//		randomQueue.enqueue("Test6");
		
		System.out.println("Deque Permutation: " + randomQueue.dequeue());
		
		System.out.println();
		System.out.println(randomQueue.size());
		
		
		System.out.println();
		randomQueue.printOut();
		
		System.out.println();
		System.out.println("Inserting 2 element then remove");
		
		
		
		randomQueue.enqueue("3333");
		randomQueue.enqueue("4444");
		randomQueue.enqueue("5555");
		randomQueue.enqueue("6666");
		
		

		System.out.println();
		randomQueue.printOut();
		
		System.out.println("Remove everything");
		System.out.println();
		System.out.println();
		
		randomQueue.printOut();
		
		System.out.println();
		System.out.println();
		
		System.out.println("Returned "+randomQueue.dequeue());
		System.out.println("Returned "+randomQueue.dequeue());
		System.out.println("Returned "+randomQueue.dequeue());
		System.out.println("Returned "+randomQueue.dequeue());
		System.out.println("Returned "+randomQueue.dequeue());
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		randomQueue.printOut();
		
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item>{
		
		private Node current = head;
		
		@Override
		public boolean hasNext() {
			return current.next != null;
		}

		@Override
		public Item next() {
			Item holder = current.item;
			
			if(hasNext()) {
				current = current.next;
			}
			
			return holder;
			
		}
		
	}
	
	
}
