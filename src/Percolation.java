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
	static int n;
	static boolean [] opened;
	int numberOfOpenSites = 0;
	WeightedQuickUnionUF full; 
	

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	this.opened = new boolean[(n*n)+2];
    	
    	this.full = new WeightedQuickUnionUF(n*n);
    	
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	int index = (row-1)*n)+(col)
    	opened[index] = true;
    	numberOfOpenSites++;
    	
    	//look left
    	if(col-1>0) {
    		int indexLeft = (row-1)*n)+(col-1);
    		if(perc.isOpen(row-1,col-1)) {
    			full.union(index, indexLeft)
    		}
    	}
    	//look right
    	if (col+1<n) {
    		int indexRight = (row-1)*n)+(col+1);
    		if(perc.isOpen(row-1,col+1)) {
    			full.union(index, indexRight)
    		}
    	}
    	//look up
    	if(index-n > 0) {
    		int indexUp = index - n;
    		if(perc.isOpen(row-2,col)) {
    			full.union(index, indexLeft)
    		}
    	}
    	//look down
    	if(row + 1 < n) {
    		int indexDown = (row*n)+(col);
    		if(perc.isOpen(row,col)) {
    			full.union(index, indexLeft)
    		}
    		
    	}
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
		if(opened[(row *n)+col]) {
			return true;
		} else {
			return false;
		}
    	
    	
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
		return false;
    	
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
		return numberOfOpenSites;
    	
    }

    // does the system percolate?
    public boolean percolates() {
		return false;
    	
    }

    // test client (optional)
    public static void main(String[] args) {
    	
    	n = StdIn.readInt();
    	Percolation perc = new Percolation(n);
    	while(!perc.percolates()) {
    		
    		//gets random number
    		int row = StdRandom.uniform(n);
    		int col = StdRandom.uniform(n);
    		
    		perc.open(row, col);
    	}
    	
    	for (int i = 1; i < opened.length-1; i++) {
    		System.out.println(opened[i]+ " "+(i));
    		
    	}
    	//System.out.println(opened[opened.length-1]+ " "+(opened.length-1));
    }
}
