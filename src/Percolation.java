import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/******************************************************************************
 *  Compilation:  javac -cp .:algs4.jar Percolation.java
 *  Execution:  java -cp .:algs4.jar Percolation < input1.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 *  Weighted quick-union (without path compression).
 *  Why doesn't this want to load to git????
 *
 ******************************************************************************/

public class Percolation {
	int n;
	static boolean [][] opened;
	WeightedQuickUnionUF full; 

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	this.opened = new boolean[n][n];
    	
    	this.full = new WeightedQuickUnionUF(n*n);
    	
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	opened[row-1][col-1] = true;
    	//System.out.println(opened[row-1][col-1]);
    	
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
		return false;
    	
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
		return false;
    	
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
		return 0;
    	
    }

    // does the system percolate?
    public boolean percolates() {
		return false;
    	
    }

    // test client (optional)
    public static void main(String[] args) {
    	
    	int n = StdIn.readInt();
    	Percolation perc = new Percolation(n);
    	while(!StdIn.isEmpty()) {
    		
    		//reads each int one at a time
    		int row = StdIn.readInt();
    		int col = StdIn.readInt();
    		
    		perc.open(row, col);
    		
    	}
    	//StdOut.println(opened.length);
    	for (int i = 0; i < opened.length; i++) {
    		for (int j = 0; j < opened[i].length; j++) {
    			System.out.println(opened[i][j]+" "+((i*n)+j+1));
    		}
    	}	
    }
}
