package basicDataStructures;

public class Setup {

	public static void main(String[] args) {
		
		//TODO Testing for all the different types of data structures
		/*
		System.out.println("Basic Stack With Linked List");
		System.out.println();
		
		BasicStack stack = new BasicStack();
		
		stack.push("b");
		stack.push("e");
		stack.push("c");
		stack.push("a");
		stack.push("u");
		stack.push("s");
		stack.push("e");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
		System.out.println("Basic Stack With Array");
		System.out.println();
		
		ArrayStack arrayStack = new ArrayStack();
		
		arrayStack.push("b");
		arrayStack.push("e");
		arrayStack.push("c");
		arrayStack.push("a");
		arrayStack.push("u");
		arrayStack.push("s");
		arrayStack.push("e");
		
		arrayStack.push("b");
		arrayStack.push("e");
		arrayStack.push("c");
		arrayStack.push("a");
		arrayStack.push("u");
		arrayStack.push("s");
		arrayStack.push("e");
		
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		System.out.println("Basic Stack With Thrashing");
		System.out.println();
		
	
		ArrayStack arrayStackThrashing = new ArrayStack();
		
		arrayStackThrashing.push("b");
		arrayStackThrashing.push("e");
		arrayStackThrashing.push("c");
		arrayStackThrashing.push("a");
		arrayStackThrashing.push("u");
		arrayStackThrashing.push("s");
		arrayStackThrashing.push("e");
		
		arrayStackThrashing.push("b");
		arrayStackThrashing.push("e");
		arrayStackThrashing.push("c");
		arrayStackThrashing.push("a");
		arrayStackThrashing.push("u");
		arrayStackThrashing.push("s");
		arrayStackThrashing.push("e");
		
		System.out.println(arrayStackThrashing.thrashing_pop());
		System.out.println(arrayStackThrashing.thrashing_pop());
		System.out.println(arrayStackThrashing.thrashing_pop());
		System.out.println(arrayStackThrashing.thrashing_pop());
		System.out.println(arrayStackThrashing.thrashing_pop());
		System.out.println(arrayStackThrashing.thrashing_pop());
		System.out.println(arrayStackThrashing.thrashing_pop());
		System.out.println(arrayStackThrashing.thrashing_pop());
		
		
		
		
		
		
		System.out.println("Basic Linked Queue");
		System.out.println();
		
		
		LinkedQueueOfStrings linkedQueue = new LinkedQueueOfStrings();
		
		linkedQueue.enqueue("1");
		linkedQueue.enqueue("2");
		linkedQueue.enqueue("3");
		linkedQueue.enqueue("4");
		
		System.out.println(linkedQueue.dequeue());
		System.out.println(linkedQueue.dequeue());
		System.out.println(linkedQueue.dequeue());
		System.out.println(linkedQueue.dequeue());
		
	
		
		
		//TODO Testing for fixed capacity stack
		/* 
		FixedCapacityStack x = new FixedCapacityStack(2);
		x.push("First");
		System.out.println(x.pop());
		
		x.push("Second");
		x.push("Third");
		x.push("Fourth");
		*/
		
		
		/*
		Queue_Array<Integer> x = new Queue_Array<Integer>();
		
		x.printOutQueue();
		
		x.enqueue(1);
		x.enqueue(2);
		x.enqueue(3);
		x.enqueue(4);
		x.enqueue(5);
		
		x.printOutQueue();
		
		
		System.out.println("Dequeued: " + x.dequeue());
		System.out.println("Dequeued: " + x.dequeue());
		System.out.println("Dequeued: " + x.dequeue());
		System.out.println("Dequeued: " + x.dequeue());
		System.out.println("Dequeued: " + x.dequeue());
		
		
		
		x.printOutQueue();
		
		
		x.enqueue(1);
		x.enqueue(2);
		x.enqueue(3);
		x.enqueue(4);
		x.enqueue(5);
		x.enqueue(6);
		
		
		
		
		x.printOutQueue();
		
		System.out.println("Dequeued: " + x.dequeue());
		System.out.println("Dequeued: " + x.dequeue());
		System.out.println("Dequeued: " + x.dequeue());
		System.out.println("Dequeued: " + x.dequeue());
		System.out.println("Dequeued: " + x.dequeue());
		System.out.println("Dequeued: " + x.dequeue());
		
		*/
		
		Deque_Array<Integer> tester = new Deque_Array<Integer>();
		
		/* TODO: Simple addititon to the tester.
		tester.addLast(2);
		tester.addFirst(1);
		tester.addFirst(3);
		*/
		
		// TODO: Adding to the first.
		
		tester.addFirst(0);
		tester.addFirst(1);
		tester.addFirst(2);
	//	tester.addFirst(3);
		
		
		
		
//		tester.addLast(0);
//		tester.addLast(2);
//		tester.addLast(3);
//		tester.addLast(4);
		
//		
//		tester.addFirst(0);
//		tester.addLast(1);
//		tester.addLast(2);
//		tester.addLast(3);
		//tester.addLast(2);
		tester.printQueue();
		
		

		
	}

}
