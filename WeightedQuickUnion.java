public class WeightedQuickUnion implements UnionFind {
    private int[] parent;
    private int[] size; // new array of size
    private int count;

    /**
     * Construct a new UF system with n nodes
     * 
     * @param n the number of nodes
     */
    public WeightedQuickUnion(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

    }

    /**
     * Places the connected component of a into the connected component of b
     * 
     * @param a the component to insert
     * @param b the component to insert into
     */
    public void union(int a, int b) {
        int rootA = find(a); // finds the root of a and b and creates new variables with those values
        int rootB = find(b);

        if (rootA == rootB) {
            return;

        }

        if (size[rootA] > size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB]; // so whats goin on here is that the code is checking which one is smaller and
                                        // parenting the root of that tree to the root of the larger tree. if they
                                        // equal, they equal and its just +1 to the size
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }

        count--;

    }

    /**
     * Returns the id of the connected component of a. The id
     * will be the same for all elements of the connected component
     * 
     * @param a The node to check
     * @return The id of the connected component of a
     */
    public int find(int a) {
        while (a != parent[a]) { // whenever the a is its own root (is it the main root of the tree), and if it
                                 // isnt it checks the next number
            a = parent[a];
        }

        return a;
    }

    /**
     * Are a and b connected?
     * 
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
        WeightedQuickUnion uf = new WeightedQuickUnion(10);

        System.out.println(uf.connected(0, 2)); // Prints false.

        uf.union(0, 1);
        uf.union(1, 2);

        System.out.println(uf.connected(0, 2)); // Prints true.

        // This is just an example -- you should add some more tests. See if you can
        // break your code.
    }
}