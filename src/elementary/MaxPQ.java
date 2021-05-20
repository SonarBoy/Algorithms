package elementary;

public class MaxPQ <Key extends Comparable<Key>> {
	
	private Key[] pq;
	private int N;
	
	public MaxPQ(int capacity){
		pq = (Key []) new Comparable[capacity + 1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(Key x) {
		pq[++N] = x;
		swim(N);
	}
	
	public Key delMax() {
		
		Key max = pq[1];
		exch(1,N--);
		sink(1);
		pq[N+1] = null;
		return max;
		
		
	}
	
	private void swim(int index) {
		
		while(index > 1 && less(index/2, index)) {
			
			exch(index, index/2);
			index = index/2;
			
		}
		
	}
	
	private void sink(int index) {
        while (2*index <= N) {
        	
            int j = 2*index;
            
            if (j < N && less(j, j+1)){ 
            	j++;
            }
            
            if (!less(index, j)) {
            	break;
            }
            
            exch(index, j);
            index = j;
            
        }
    }
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	public void printOut() {
		
		for(int runner = 1; runner < this.pq.length; runner++) {
			
			if(this.pq[runner] == null) return;
			
			System.out.println("Index " + runner + " : " + this.pq[runner].toString());
		}
	}
	
}
