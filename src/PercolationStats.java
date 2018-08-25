import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	double T=0;
	double[] x;
	double n = 0;
	
	
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
		
		
	}

}
