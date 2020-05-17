package DataAlgo;

public class QuickConnector {
	
	int list[];
	int size[];
	int count;
	
	public QuickConnector(int leng) {
		list = new int[leng];
		size = new int[leng];
		count = leng;
		   for(int runner = 0; runner < leng;runner++){
	            list[runner] = runner;
	            size[runner] = runner; 
	        }
	}
	
	public int root(int x) {
		
		
		//System.out.println("Starting Leaf Data: " + x + " Leaf Index: " + list[x]);
		
		while(x != list[x]) {
			x = list[x];
			//System.out.println("Leaf Data: " + x + " Leaf Index: " + list[x]);
		}
		
		//System.out.println("Finished Root Data: " + x + " Root Index: " + list[x]);
		//System.out.println();
		
		return x;
	}
	
	public boolean isConnected(int first, int second) {
		return root(first) == root(second);
	}
	
	public void union(int first, int second) {
		int rootP = root(first);
		int rootQ = root(second);
		
		  if (rootP == rootQ) return;

	       // Weighted portion of the union adding the shorter tree
		   //below the taller one
	        if (size[rootP] < size[rootQ]) {
	        	
	        	System.out.println(size[rootP] +" is less than "+size[rootQ]);
	        	
	            list[rootP] = rootQ;
	            size[rootQ] += size[rootP];
	        }
	        else {
	        	
	        	System.out.println(size[rootP] +" is greater than "+size[rootQ]);
	        	
	            list[rootQ] = rootP;
	            size[rootP] += size[rootQ];
	        }
	        count--;
	}
	
    public void printOut(){
        for(int runner = 0; runner < list.length; runner++){
          System.out.println("Index: " + runner + " Value: " + list[runner]);
        }
    }
    
    public void printOutSizes(){
        for(int runner = 0; runner < size.length; runner++){
          System.out.println("Index: " + runner + " Value: " + size[runner]);
        }
    }
}