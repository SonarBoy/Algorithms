package basicDataStructures;

public class ArrayStack {
	
	private String[] array_Stack;
	private int Head = 0;
	
	private long start;
	private long finish;
	private long timeElapsed;
	
	public ArrayStack() {
		
		start = System.nanoTime();
		
		
		
		array_Stack = new String[1];
		Head = 0;
		
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Created: " + timeElapsed);
	}
	
	public boolean isEmpty(){
		
		start = System.nanoTime();
		
		
		
		if(Head == 0) {
			
			finish = System.nanoTime();
	        timeElapsed = finish - start;
	        System.out.println("Created: " + timeElapsed);
	        
	 
			return true;
		}else {
			
			finish = System.nanoTime();
	        timeElapsed = finish - start;
	        System.out.println("Created: " + timeElapsed);
	        
	       
			return false;
		}
		
		
	}
	
	
	public void push(String item) {
		
		start = System.nanoTime();
		
		
		
		if(Head == array_Stack.length) {
			resize(2 * array_Stack.length);
		}

		array_Stack[Head++] = item;
		
		
	
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Push: " + timeElapsed);
	}
	
	public String pop() {
		start = System.nanoTime();
		
		
		if(Head > 0 && Head == array_Stack.length/4) {
			resize(array_Stack.length/2);
		}
		
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Pop: " + timeElapsed);
        
		return array_Stack[--Head];
	}
	
	
	public String thrashing_pop() {
		start = System.nanoTime();
		
		
		if(Head > 0 && Head == array_Stack.length/4) {
			resize(array_Stack.length/2);
		}
		
		
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Pop: " + timeElapsed);
        
		return array_Stack[Head--];
	}
	
	
	private void resize(int capacity) {
		String[] copy = new String[capacity];
		
		for(int runner = 0; runner < Head; runner++) {
			copy[runner] = array_Stack[runner];
		}
		
		array_Stack = copy;
	}
	
	private void startTime() {
		start = System.nanoTime();
	}
	
	private void endTime(String task) {
		
		finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println(task+": " + timeElapsed);
        
	}
}
