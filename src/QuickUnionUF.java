import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac -cp .:algs4.jar QuickUnionUF.java
 *  Execution:  java -cp .:algs4.jar QuickUnionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 *  Weighted quick-union (without path compression).
 *
 ******************************************************************************/

public class QuickUnionUF {
	private int[] id;

	public QuickUnionUF(int n) {
		//Each id array can be a max of the number of components 
		id = new int[n];
		//Set id of each object to itself
		for (int i = 0; i < n; i++) {
			id[i]=i;
		}
	}
	//finds root of i. when i == id[i], i is returned
	private int root(int i) {
		while(i != id[i]) {
			i = id[i];
		}
		return i;
	}
	
	//Check whether p and q are in same component
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(p);
		
		id[i] = j;
	}

	public static void main(String[] args) {
		int n = StdIn.readInt();
		// tells how many different components se puede ser.
		QuickFindUF uf= new QuickFindUF(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(!uf.connected(p,q)) {
				uf.union(p, q);
				StdOut.println(p + " "+ q);
			}
		}

	}

}
