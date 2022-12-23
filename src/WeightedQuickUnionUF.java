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
    private int[] parent;
    private int[] size;
    private int count;
    
    //creates weighted union
    public WeightedQuickUnionUF(int n) {
    	count = n;
    	parent = new int[n];
    	size = new int[n];
    	
    	//initializes all the different people
    	for (int i = 0; i < n; i++) {
    		//everyone is their own parent initially
    		parent[i] = i;
    		//initially, nobody knows anyone, so the trees are size one
    		size[i] = 1;
    	}
    }
    
    public int root(int p) {
    	//compress path
    	while (p != parent[p]) {
    		//p's parent points to grandparent
    		parent[p] = parent[parent[p]];
    		p = parent[p];
    	}
    	return p;
    }
    
    public int count() {
    	return count;
    }
    
    public void union(int p, int q) {
    	int rootP = root(p);
    	int rootQ = root(q);
    	if(rootP == rootQ) return;
    	
    	if (size[rootP]<size[rootQ]) {
    		parent[rootP] =rootQ;
    		size[rootQ] += size[rootP];
    	}else {
    		parent[rootQ] = rootP;
    		size[rootP]+=size[rootQ];
    	}
    	count--;
    }
    
    public static void main(String[] args) {
    	
    	int n = StdIn.readInt();
    	WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
    	String date, time;
    	while(!StdIn.isEmpty()) {
    		
    		//reads each string/int one at a time
    		int p = StdIn.readInt();
    		int q = StdIn.readInt();
    		date = StdIn.readString();
    		time = StdIn.readString();
    		
    		//connect the people from the line
    		uf.union(p,q);
    		
    		StdOut.println("["+p+","+q+"]");

            if(uf.count() == 1){
                StdOut.println("All members were connected at: " + date + time);
                break;
            }
    	}
    	
    }
}
