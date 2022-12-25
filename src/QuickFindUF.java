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

public class QuickFindUF {
	private int[] id;
	private int count;

	public QuickFindUF(int n) {
		count = n;
		//Each id array can be a max of the number of components 
		id = new int[n];
		//Set id of each object to itself
		for (int i = 0; i < n; i++) {
			id[i]=i;
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
	
	//Check whether p and q are in same component
	public boolean connected(int p, int q) {
		validate(p);
		validate(q);
		return id[p] == id[q];
	}
	
	public void union(int p, int q) {
		validate(p);
		validate(q);
		int pID = id[p];
		int qID = id[q];
		
		// p and q are already in the same component
        if (pID == qID) return;
        
        // change all entries wth id[p] to id[q]
        for (int i = 0; i < id.length; i++) {
        	if (id[i] == pID) {
        		id[i] = qID;
        	}
        }
        count --;
	}
	
	private static void find(QuickFindUF id) {
		for (int i =0; i < ; i++) {
			System.out.print(false);
		}
		
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
		StdOut.println(uf.count + " components");
		for(int i = 0; i<uf.id.length; i++) {

		}

	}

	

}
