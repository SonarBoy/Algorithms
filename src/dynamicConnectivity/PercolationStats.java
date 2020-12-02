package dynamicConnectivity;

public class PercolationStats {

	/**
	 * Percolation Stats Notes:
	 * 
	 * 	T: # of times the experiment was conducted.
	 * 
	 *  t: # of total sites in the experiment.
	 *  
	 *  x_: provides an estimate of the percolation threshold ((x1/t1) + (x2/t2) + (x3/t3)...)/T
	 *  
	 *  s^2: sample standard deviation measures the sharpness of the threshold. 
	 *  ((x1/t1 - x_)^2 + (x2/t2 - x_)^2 + (x3/t3 - x_)^2...)/T-1
	 * 
	 * @param n
	 * @param trials
	 */
	
	Percolation[] units;
	int size;
	int tries;
	
	double sim_Mean;
	double sim_Standard_Dev;
	
	 // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
    	
    	
    	this.size = n;
    	this.tries = trials;
    	
    	this.units = new Percolation[trials];
    	for(Percolation x: units) {
    		x = new Percolation(n);
    	}
    	
    }

    // sample mean of percolation threshold
    public double mean() {
    	
    	this.sim_Mean = 0d;
    	
    	
    	for(int runner = 0; runner < this.units.length; runner++) {
    		this.sim_Mean += (this.units[runner].numberOfOpenSites() / this.size);
    	}
    	
    	this.sim_Mean = (this.sim_Mean/this.tries);
    	
    	return (this.sim_Mean/tries);
    	
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
    	
    	this.sim_Standard_Dev = 0d;
    	double holder = 0d;
    	
    	for(int runner = 0; runner < this.units.length; runner++) {
    		holder = ((this.units[runner].numberOfOpenSites() / this.size) - this.sim_Mean);
    		this.sim_Standard_Dev += Math.pow(holder, 2);
    	}
    	
    	this.sim_Standard_Dev = (this.sim_Standard_Dev/(this.tries - 1));
    	
    	return this.sim_Standard_Dev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
    	return 0;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
    	return 0;
    }

   // test client (see below)
   public static void main(String[] args) {

	   PercolationStats x = new PercolationStats(5, 10);
	   
	   System.out.println(37 & 23);
	   System.out.println(37 & 4);
	   
	   if((52 & 1) == 1){
		   System.out.println("The number is odd");
	   }else {
		   System.out.println("The number is even");
	   }
	   
	   
	   System.out.println(11 & 8);
   }
}
