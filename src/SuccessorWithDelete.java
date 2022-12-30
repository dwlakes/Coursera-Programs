import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac -cp .:algs4.jar SuccessorWithDelete.java
 *  Execution:  java -cp .:algs4.jar SuccessorWithDelete < tiny.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 *  Weighted quick-union (without path compression).
 *  Why doesn't this want to load to git????
 *
 ******************************************************************************/

public class SuccessorWithDelete {
	private int[] id;

	public SuccessorWithDelete(int n) {
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
		int j = root(q);
		
		id[i] = j;
	}
	
	private void remove(int delete, int n) {
		if(delete < id[0] || delete>n-1) {
			System.out.println("Can't do that with "+delete);
			return;
		}else {
			int successor = delete+1;
			union(delete, successor);
		}
		
	}
	
	private void successor(int i) {
		StdOut.println("Successor to " +i+ " is " + id[i+1]);
		System.out.println(id[7]);
	}
	public static void main(String[] args) {
		int n = StdIn.readInt();
		// tells how many different components se puede ser.
		SuccessorWithDelete swd= new SuccessorWithDelete(n);
		
		
		swd.remove(4,n);
		swd.remove(0, n);
		swd.remove(15, n);
		swd.remove(7, n);
		
		swd.successor(4);
		swd.successor(1);
		swd.successor(6);

	}
	
	

}