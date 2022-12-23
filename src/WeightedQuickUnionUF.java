import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac -cp .:algs4.jar WeightedQuickUnionUF.java
 *  Execution:  java -cp .:algs4.jar WeightedQuickUnionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 *  Weighted quick-union (without path compression).
 *
 ******************************************************************************/


public class WeightedQuickUnionUF {
    private int[] parent;   // parent[i] = parent of i
    private int[] size;     // size[i] = number of elements in subtree rooted at i
    private int count;      // number of components

  
    public WeightedQuickUnionUF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }

   
    public int root(int p) {
        while (p != parent[p]) {
        	//compresses path
        	parent[p] = parent[parent[p]];
        	p = parent[p];
        }
            
        return p;
    }

    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }
    
    public static void main(String[] args) {
    	 int n = StdIn.readInt();
         WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
         String date, time;
         //timestamps are sorted ascending
         while (!StdIn.isEmpty()) {

             int p = StdIn.readInt();
             int q = StdIn.readInt();
             date = StdIn.readString();
             time = StdIn.readString();


             uf.union(p, q);

             StdOut.println("["+p+","+q+"]");

             if(uf.count() == 1){
                 StdOut.println("All members were connected at: " + date + time);
                 break;
             }
    }

}
}
