package elementary;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {
	
	private Key[] priorityQueue;
	private int N;
	
	
	public UnorderedMaxPQ(int capacity) {
		
		this.priorityQueue = (Key []) new Comparable[capacity];
		
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(Key x) {
		priorityQueue[N++] = x;
	}
	
	public Key delMax() {
		
		int max = 0;
		
		for(int runner = 1; runner < N; runner++) {
			if(less(max, runner)) max = runner;
		}
		
		exch(max,N - 1);
		
		return priorityQueue[--N];
	}
	
	private  boolean less(Comparable firstItem, Comparable w){
		
		return firstItem.compareTo(w) < 0;
		
	}
	
	private  void exch(int i, int j) {
		
		Key swap = this.priorityQueue[i];
		this.priorityQueue[i] = this.priorityQueue[j];
		this.priorityQueue[j] = swap;
		
	}
}
