public class QuickFind implements UnionFind {
    private final int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    @Override
    public void union(int a, int b) {
        int savedid = id[a];
        for(int i = 0; i < id.length; i++){
            if(id[i] == savedid){
                id[i] = id[b];
            }
        }
        
        
    }

    @Override
    public int find(int a) {
        return id[a];
    }

    @Override
    public int count() {
        int counter = 0;

        for(int i = 0; i < id.length; i++){
            counter++;
        }

        return counter;

    }


    public static void main(String[] args) {
        QuickFind uf = new QuickFind(10);

        System.out.println(uf.connected(0, 2)); // Prints false.

        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(9, 5);
        uf.union(9,0);

        System.out.println(uf.connected(0, 2)); // Prints true.
        System.out.println(uf.connected(9, 2)); //should print false
        // This is just an example -- you should add some more tests. See if you can
        // break your code.
    }

}
