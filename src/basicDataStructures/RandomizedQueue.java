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
			
			
			head = temp;
			tail = temp;
			
		}else{
			
			
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
		
		if(size == 2) {
			Node temp = head.next;
			temp.previous = head;
		}
		
	}
	
	public void dequeueRandom() {
		
			
			Node runner = head;
			
			int counter = 1;
			int max = size; 
	        int min = 1; 
	        int range = max - min + 1; 
	        
	        int rand = (int)(Math.random() * range) + min; 
	        
	        
	        while(counter < rand){
	        	runner = runner.next;
	        	counter++;
	        }
			
	        
	        
	        if(runner.previous != null) {
	        	System.out.println("Previous: "+runner.previous.item);
	        }
	        
	        System.out.println("Current: "+runner.item);
	        
	        if(runner.next != null) {
	        	System.out.println("Next: "+runner.next.item);
	        }
	        
	        
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
	}
	
	private void tieBack(){
		
		
			//Set up two pointers to run through the links 
			Node runner = head;
			Node nextRunner = head.next;
			
			//When the headder pointer hits a null stop
			while(nextRunner.next != null) {
				
				//If the runner is the head pointer tie the nextRunner back to the head.
				if(runner == head) {
					nextRunner.previous = head;
				}
				
				//If the runner is not equal to the head assign the nextRunners prior value to the new 
				//runner
				if(runner != head) {
					nextRunner.previous = runner;
				}
				
				//Iterate the two pointers to the next value
				nextRunner = nextRunner.next;
				runner = runner.next;
			}
			
			//tieBack the nextRunners previous pointer to the runner.
			nextRunner.previous = runner;
	}
	
	
	
	
	public Item dequeue() {
		
		
		System.out.println("Dequeued: "+head.item);
		head = head.next;
		
		
		return head.item;
	}
	
	
	public Item sample() {
		
		Node runner = head;
		
		int counter = 1;
		int max = size; 
        int min = 1; 
        int range = max - min + 1; 
        
        int rand = (int)(Math.random() * range) + min; 
        
        
        while(counter < rand){
        	runner = runner.next;
        	counter++;
        }
		
        
        System.out.println("Sample: "+runner.item);
        System.out.println("Tail: "+tail.item);
        
		
        
        return null;
	}
	
	public void printOut() {
		
		Node runner = head;
		
		while(runner.next != null) {
			System.out.println("Runner Data: "+ runner.item);
			runner = runner.next;
		}
		
		
		//Print out final variable
		System.out.println("Runner Data: "+ runner.item);
		
	}

	
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
