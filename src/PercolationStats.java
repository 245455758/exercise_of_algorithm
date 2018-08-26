import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	int T=0;
	double[] x;
	int n = 0;
	
	
	public PercolationStats(int n,int trials) {
		if(n<=0||trials<=0) throw new java.lang.IllegalArgumentException();
		T = trials;
		x = new double[trials];
	}
	
	public double mean() {
		return StdStats.mean(x);
	}
	
	public double stddev() {
		return StdStats.stddev(x);
	}
	
	public double confidenceLo() {
		return mean()-1.96*stddev()/Math.sqrt(T);
	}
	
	public double confidenceHi() {
		return mean()+1.96*stddev()/Math.sqrt(T);
	}
	
	public static void main(String[] args) {
		PercolationStats pls = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		pls.x = new double[pls.T];
		for (int i = 0; i < pls.T; i++) {
			Percolation percolation = new Percolation(pls.n);
			while(!percolation.percolates()) {
				percolation.open(StdRandom.uniform(1,pls.n+1),StdRandom.uniform(1,pls.n+1) );
			}
			pls.x[i] = percolation.numberOfOpenSites()/(pls.n*pls.n);
		}
		
		StdOut.printf("mean                    = %.18f", pls.mean());
		StdOut.printf("stddev                  = %.18f", pls.stddev());
		StdOut.printf("95% confidence interval = [%.18f, %.18f]", pls.confidenceLo(),pls.confidenceHi());
	}

}
