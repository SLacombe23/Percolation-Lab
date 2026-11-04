public class QuickUnion implements UnionFind{
    private  int[] parent;
    private int count;

    /**
     * Construct a new UF system with n nodes
     * @param n the number of nodes
     */
    public QuickUnion(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }

    }

    /**
     * Places the connected component of a into the connected component of b
     * @param a the component to insert
     * @param b the component to insert into
     */
    public void union(int a, int b) {
        int rootA = find(a);  //finds the root of a and b and creates new variables with those values
        int rootB = find(b);

        if (rootA==rootB){
            return;
        }
        
        
        parent[rootA] = rootB; //changes the root of A to the root of B, so they are connected in the same tree
        

        count--;

    }

    /**
     * Returns the id of the connected component of a. The id
     * will be the same for all elements of the connected component
     * @param a The node to check
     * @return The id of the connected component of a
     */
    public int find(int a) {
        while (a != parent[a]){ //whenever the a is its own root (is it the main root of the tree), and if it isnt it checks the next number
            a = parent[a]; 
        } 

        return a; 
    }

    /**
     * Are a and b connected?
     * @param a The first node
     * @param b The second node
     * @return True if a and b are connected, false otherwise
     */
    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public int count(){
        return count;
    }


    // Unit tests for the UF class
    public static void main(String[] args) {
        QuickUnion uf = new QuickUnion(10);

        System.out.println(uf.connected(0, 2)); // Prints false.

        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(0,2);
        uf.union(4,5);
        uf.union(4,0);
        uf.union(4,1);

        System.out.println(uf.connected(0, 2)); // Prints true.
        System.out.println(uf.count());//hopefully prints just 

        // This is just an example -- you should add some more tests. See if you can
        // break your code.
    }
}