package DataAlgo;
public class Connector {
	  int list[];
	  long start;
	  long finish;
	  long timeElapsed;
	    
	    public Connector(int len){
	    	start = System.nanoTime();
	    	
	        list = new int[len];

	        for(int runner = 0; runner < len;runner++){
	            list[runner] = runner;
	        }
	        
	        finish = System.nanoTime();
	        timeElapsed = finish - start;
	        
	        
	        System.out.println(timeElapsed);
	    }


	    public void union(int first,int second){
	        int firstItem = list[first];
	        int secondItem = list[second];

	        for(int runner = 0; runner < list.length; runner++){
	            if(list[runner] == firstItem){
	                list[runner] = secondItem;
	                
	                
	            }
	        }
	        
	        
	    }

	    public boolean isConnected(int first, int second){
	        if(list[first] == list[second]){
	            return true;
	        }else{
	            return false;
	        }
	    }

	    public void printOut(){
	        for(int runner = 0; runner < list.length; runner++){
	          System.out.println("Index: " + runner + " Value: " + list[runner]);
	        }
	    }
}
