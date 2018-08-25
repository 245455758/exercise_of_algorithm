import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	int[][] grid;
	boolean[][] isOpen;
	WeightedQuickUnionUF wqu ;
	int[] dx = {-1,0,1,0};
	int[] dy = {0,-1,0,1};
	int n = 0,numbers=0;
	public Percolation(int n) {
		this.n = n;
		wqu = new WeightedQuickUnionUF(n*n+2);
		if(n<=0) throw new java.lang.IllegalArgumentException();
		int count = 1;
		grid = new int[n+1][];
		isOpen = new boolean[n+1][];
		for(int i=1;i<n+1;i++) {
			grid[i]=new int[n+1];
			isOpen[i]=new boolean[n+1];
			for(int j=1;j<n+1;j++) {
				grid[i][j] = count++;
				isOpen[i][j]=false;
			}
		}
	}
	
	public void open(int row,int col) {
		if(row<=0||col<=0||row>n||col>n) throw new java.lang.IllegalArgumentException();
		if(!isOpen[row][col]) {
			isOpen[row][col]=true;
			numbers++;
			int index = row*n+col;
			for(int i=0;i<4;i++) {
				int y = row+dy[i];
				int x = col+dx[i];
				if(x>0&&x<=n&&y>0&&y<=n) {
					if(wqu.connected(index, y*n+x)) {
						wqu.union(index, y*n+x);
					}
				}
			}
			for (int i = 1; i <= n; i++) {
				wqu.union(i, 0);
			}
			for (int i = n*n; i >n*n-n; i--) {
				wqu.union(i, n*n+1);
			}
		}
	}
	
	public boolean isOpen(int row,int col) {
		if(row<=0||col<=0||row>n||col>n) throw new java.lang.IllegalArgumentException();
		return isOpen[row][col];
	}
	
	public boolean isFull(int row,int col) {
		if(row<=0||col<=0||row>n||col>n) throw new java.lang.IllegalArgumentException();
		return numbers==n*n;
	}
	
	public int numberOfOpenSites() {
		return numbers;
	}
	
	public boolean percolates() {
		return wqu.connected(0, n*n+1);
	}
	
	
	public static void main(String[] args) {
	}

}
