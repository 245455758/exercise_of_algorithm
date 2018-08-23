
public class Percolation {
	
	int[][] grid;
	boolean[][] isOpen;
	int[] dx = {-1,0,1,0};
	int[] dy = {0,-1,0,1};
	int n = 0,numbers=0;
	public Percolation(int n) {
		this.n = n;
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
			for(int i=0;i<4;i++) {
				int x = row+dy[i];
				int y = col+dx[i];
				//TODO  连接四周的点
				
			}
		}
	}
	
	public boolean isOpen(int row,int col) {
		if(row<=0||col<=0||row>n||col>n) throw new java.lang.IllegalArgumentException();
		return isOpen[row][col];
	}
	
	public boolean isFull(int row,int col) {
		if(row<=0||col<=0||row>n||col>n) throw new java.lang.IllegalArgumentException();
		return true;
	}
	
	public int numberOfOpenSites() {
		return numbers;
	}
	
	public boolean percolates() {
		//TODO 解决判断是否渗漏的问题
		return false;
	}
	
	
	public static void main(String[] args) {
		Percolation p = new Percolation(10);
	}

}
