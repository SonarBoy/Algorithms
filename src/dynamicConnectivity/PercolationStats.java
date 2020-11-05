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
	
	
	 // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
    	
    }

    // sample mean of percolation threshold
    public double mean() {
    	return 0;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
    	return 0;
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
	   
   }
}
