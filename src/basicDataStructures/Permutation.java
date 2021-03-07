package basicDataStructures;
import edu.princeton.cs.algs4.StdIn;

public class Permutation {
	
	public static void main(String[] args) {

		int times = Integer.parseInt(args[0]);
		
		
		
		RandomizedQueue<String> queue = new RandomizedQueue<>();
		
		while(!StdIn.isEmpty()) {
			queue.enqueue(StdIn.readString());
		}
		
		
		
//		for(String v: values) {
//			//System.out.println(v);
//			
//			queue.enqueue(v);
//		}
		
		for(int runner = 0; runner < times; runner++) {
			System.out.println(queue.dequeue());
		}
		
		
		
		
		
		
		
//		for(String arg: testing) {
//			System.out.println(arg);
//		}
//	   
		//RandomizedQueue<String> queue = new RandomizedQueue<>();
//		queue.enqueue(567);
//		queue.size();
//		queue.isEmpty();
//		queue.dequeue();
//		queue.enqueue(631);
//		queue.enqueue(749);
//		queue.size();
//		queue.dequeue();
//		queue.enqueue(275);
//		queue.iterator();
//		queue.dequeue();
//
//		
//		
//		Deque<String> deque = new Deque<String>();
		

//		RandomizedQueue<String> randomQueue = new RandomizedQueue<String>();
//		
//		
//		deque.addFirst(new Card("Diamonds","Jack"));
		
		
		
//		
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		
//		deque.addFirst("Test1");
//		deque.addFirst("Test2");
//		deque.addFirst("Test3");
//		deque.addFirst("Test4");
//		
//		deque.addFirst("Test1");
//		deque.addFirst("Test2");
//		deque.addFirst("Test3");
//		deque.addFirst("Test4");
//		
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		
//		deque.addFirst("Test1");
//		deque.addFirst("Test2");
//		deque.addFirst("Test3");
//		deque.addFirst("Test4");
//		
//		deque.addFirst("Test1");
//		deque.addFirst("Test2");
//		deque.addFirst("Test3");
//		deque.addFirst("Test4");
//		
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		
//		deque.addFirst("Test1");
//		deque.addFirst("Test2");
//		deque.addFirst("Test3");
//		deque.addFirst("Test4");
//		
//		deque.addFirst("Test1");
//		deque.addFirst("Test2");
//		deque.addFirst("Test3");
//		deque.addFirst("Test4");
//		
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
//		deque.addLast("Last1");
		
		
		
//		deque.addFirst(StdRandom.uniform(10) +"");
//		deque.addFirst(StdRandom.uniform(10) +"");
//		deque.addFirst(StdRandom.uniform(10) +"");
//		deque.addFirst(StdRandom.uniform(10) +"");
//		deque.addFirst(StdRandom.uniform(10) +"");
//		deque.addFirst(StdRandom.uniform(10) +"");
//		deque.addFirst(StdRandom.uniform(10) +"");
//		
//		deque.addLast(StdRandom.uniform(10) +"");
//		deque.addLast(StdRandom.uniform(10) +"");
//		deque.addLast(StdRandom.uniform(10) +"");
//		deque.addLast(StdRandom.uniform(10) +"");
//		deque.addLast(StdRandom.uniform(10) +"");
//		deque.addLast(StdRandom.uniform(10) +"");
//		deque.addLast(StdRandom.uniform(10) +"");
//		
//		deque.addFirst(1 +"");
//		deque.removeLast();
//		deque.addFirst(2 +"");
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		deque.addFirst(3 +"");
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		deque.addFirst(3 +"");
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		deque.addFirst(3 +"");
//		deque.removeLast();
//		deque.removeLast();
//		deque.removeLast();
//		deque.removeLast();
//		deque.addFirst(3 +"");
//		
//        deque.isEmpty();         
//        deque.isEmpty();         
//        deque.isEmpty();        
//        deque.addLast(""+4);
//        deque.removeFirst();    
//        deque.addLast(""+6);
//        deque.removeFirst();     
//        deque.addLast(""+8);
//        deque.addLast(""+9);
//        deque.removeFirst();    
//        deque.removeFirst();
//		

		
//		deque.printOut();

//		   deque.addFirst(1+"");
//	       System.out.println(deque.removeLast());   
//	       deque.addFirst(3+"");
//	       System.out.println(deque.removeLast());      
//	       deque.addFirst(5+"");
//	       deque.addFirst(6+"");
//	       deque.addFirst(7+"");
//	       deque.isEmpty();         
//	       System.out.println(deque.removeLast());      
//	       System.out.println(deque.removeLast()); 
		

		
//		Iterator x = deque.iterator();
//		
//		
//		int size = 0;
//		
//		while(x.hasNext()) {
//			size++;
//			System.out.println(x.next());
//		}
//		
//		System.out.println("Size: " + size);
//		
//		System.out.println(deque.removeFirst());
//		System.out.println(deque.removeFirst());
//		System.out.println(deque.removeFirst());
//		System.out.println(deque.removeFirst());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		
//		System.out.println(deque.isEmpty());
//		System.out.println(deque.size());
//		deque.printQueue();
//		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		
//		
//		
//		
//		
//		
//		
//		
//		deque.printQueue();
//		
//		deque.removeFirst();
//		deque.removeFirst();
//		deque.removeFirst();
//		deque.removeFirst();
//		
//		System.out.println();
//		System.out.println();
//		
//		deque.printQueue();
		
//		deque.objectVariables();
//		
		
		
//		System.out.println("Inserting 1 element then remove");
//		System.out.println();
//		randomQueue.enqueue("1111");
//		randomQueue.printOut();
//		randomQueue.dequeue();
//		randomQueue.printOut();
//		System.out.println();
//		System.out.println("Inserting 1 element then remove");
//		
//		
//		System.out.println();
//		System.out.println();
//		
//		
//		System.out.println("Inserting 2 element then remove");
//		System.out.println();
//		
//		randomQueue.enqueue("1111");
//		randomQueue.enqueue("2222");
//		randomQueue.enqueue("Test3");
//		randomQueue.enqueue("Test4");
//		randomQueue.enqueue("Test5");
//		randomQueue.enqueue("Test6");
//		
//		System.out.println("Deque Permutation: " + randomQueue.dequeue());
//		
//		System.out.println();
//		System.out.println(randomQueue.size());
//		
//		
//		System.out.println();
//		randomQueue.printOut();
//		
//		System.out.println();
//		System.out.println("Inserting 2 element then remove");
//		
//		
//		
//		randomQueue.enqueue("3333");
//		randomQueue.enqueue("4444");
//		randomQueue.enqueue("5555");
//		randomQueue.enqueue("6666");
//		
//		
//
//		System.out.println();
//		randomQueue.printOut();
//		
//		System.out.println("Remove everything");
//		System.out.println();
//		System.out.println();
//		
//		randomQueue.printOut();
//		
//		System.out.println();
//		System.out.println();
//		
//		System.out.println("Returned "+randomQueue.dequeue());
//		System.out.println("Returned "+randomQueue.dequeue());
//		System.out.println("Returned "+randomQueue.dequeue());
//		System.out.println("Returned "+randomQueue.dequeue());
//		System.out.println("Returned "+randomQueue.dequeue());
//		
//		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		
//		randomQueue.printOut();
		
//		RandomizedQueue<Integer> queue = new RandomizedQueue<>();
//		queue.enqueue(28);
//		queue.enqueue(35);
//		queue.iterator();
//		queue.enqueue(48);
//		queue.enqueue(46);
//		queue.enqueue(2);
//		queue.iterator();
        
        
//        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
//        queue.isEmpty();
//        queue.enqueue(79);
//        queue.dequeue();
//        queue.enqueue(357);
//        queue.dequeue();
//        queue.enqueue(4);
//        queue.enqueue(199);
//        queue.enqueue(3);
//        queue.isEmpty();
//        queue.iterator();
//        System.out.println(queue.dequeue());
//       

//		Deque<Integer> deque = new Deque<>();
//		deque.addFirst(1);
//		deque.addLast(2);
//		deque.addLast(4);
//		deque.iterator();
//		deque.size();
//		deque.removeLast();
//		deque.size();
//		deque.isEmpty();
//		deque.removeLast();
//		deque.removeFirst();
//		deque.addLast(12);
	   
//	   Deque<Integer> deq = new Deque<Integer>();
//	   deq.addFirst(1);
//	   deq.addFirst(2);
//	   deq.addFirst(3);
//	   deq.addFirst(4);
//	   deq.addFirst(5);
//	   deq.addFirst(6);
//	   
//	   Iterator fir = deq.iterator();
//	   
//	   while(fir.hasNext()) {
//		   System.out.println(fir.next());
//	   }
//	   System.out.println();
//	   System.out.println();
	   
//	   deq.printOut();
//	   
//	   deq.addFirst(7);
//	   deq.addFirst(8);
//	   deq.addFirst(9);
//	   deq.addFirst(10);
//	   
//	   Iterator sec = deq.iterator();
//	   
//	   while(sec.hasNext()) {
//		   System.out.println(sec.next());
//	   }
//	   
//	   deq.printOut();

	   
	   
//		RandomizedQueue<Integer> queue = new RandomizedQueue<>();
//		queue.enqueue(100);
//		queue.enqueue(200);
//		queue.enqueue(300);
//		queue.enqueue(400);
//		queue.enqueue(500);
//		queue.enqueue(600);
//		queue.enqueue(700);
//		queue.enqueue(800);
//
//		
//
//		Iterator fir = queue.iterator();
//		
//		
//		
//		while (fir.hasNext()) {
//			System.out.println(fir.next());
//		}
	}

}
