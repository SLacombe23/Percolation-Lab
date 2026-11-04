
public class Percolation {
    private int realgrid;
    private WeightedQuickUnion wqu;
    boolean[][] open;
    private int count;
    private int n;

    public Percolation(int n) {
        realgrid = n * n + 2;
        open = new boolean[n][n];
        wqu = new WeightedQuickUnion(realgrid);
        this.n = n;
    }

    private int coordinate(int row, int col) {
        return row * n + col;
    }

    public void open(int row, int col) { 
         if (this.isOpen(row, col)){
            return;
         }
        open[row][col] = true; 
         count++;
         if (row < n - 1 && isOpen(row+1, col)){
            wqu.union(coordinate(row, col), coordinate(row+1, col));
         }

         if (row > 0 && isOpen(row - 1, col)){
            wqu.union(coordinate(row, col), coordinate(row-1, col));
         }

         if (col < n - 1 && isOpen(row, col+1)){
            wqu.union(coordinate(row, col), coordinate(row, col+1));
         }

        if (col > 0 && isOpen(row, col-1)){
            wqu.union(coordinate(row, col), coordinate(row, col-1));
        }

        if (row == 0){
            wqu.union(coordinate(row, col), n*n);
        }

        if (row == n - 1){
            wqu.union(coordinate(row, col), n*n +1);
        }

    }

    public boolean isOpen(int row, int col) {
        return open[row][col];
    }

    public boolean isFull(int row, int col) {
        return wqu.connected(n * row + col, n * n);
    }

    public int numberOfOpenSites() {
        return count;
    }

    public boolean percolates() {
        return wqu.connected(n * n, n * n + 1);
    }

    // private int toAbs(int row, int col) {

    // }

    public static void main(String[] args) {
        Percolation p = new Percolation(10);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(0, 0);
        p.open(1,0);

        System.out.println(p.numberOfOpenSites());
    }
}
