import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac -cp .:algs4.jar QuickFindUF.java
 *  Execution:  java -cp .:algs4.jar QuickFindUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 *  Weighted quick-union (without path compression).
 *
 ******************************************************************************/

public class QuickUFWithLargestUF {
	private static int[] id;
	private int largest[];
	private int count;

	public QuickUFWithLargestUF(int n) {
		count = n;
		//Each id array can be a max of the number of components 
		id = new int[n];
		largest = new int[n];
		
		//Set id of each object to itself
		for (int i = 0; i < n; i++) {
			id[i]=i;
			largest[i]=i;
		}
	}
	
	//Validate function makes sure that each component has a logical id.
	//IDs and components will be in numerical order
	private void validate(int p) {
		int n = id.length;
		if (p < 0 || p >= n) {
			throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n -1));
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
		int rootP = root(p);
		int rootQ = root(q);
		int largeP = largest[rootP];
		int largeQ = largest[rootQ];
		
		if (largeP > largeQ) {
			largest[rootQ] = largeP;
		}else {
			largest[rootP] = largeQ;
		}
			
		id[rootP] = rootQ;
	}
	
	public int find(int p) {
		return largest[root(p)];
	}
	
	public static void main(String[] args) {
		int n = StdIn.readInt();
		// tells how many different components se puede ser.
		QuickUFWithLargestUF uf= new QuickUFWithLargestUF(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(!uf.connected(p,q)) {
				uf.union(p, q);
				StdOut.println(p + " "+ q);
			}
		}
		System.out.println(uf.find(2));
		System.out.println(uf.find(8));
		System.out.println(uf.find(4));

	}

	

}

