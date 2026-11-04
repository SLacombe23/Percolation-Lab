import java.util.Random;


public class PercolationStats {
    //private Percolation p;
    private double[] percpercent;
    private double t;
    //private int n;


    public PercolationStats(int n, int trials) { 

      
        this.percpercent = new double[trials];

        for (int i = 0; i < trials; i++){
            Percolation p = new Percolation(n);

            while (!p.percolates()){
                int randrow = (int) (Math.random() * n);
                int randcol = (int) (Math.random() * n);
                p.open(randrow, randcol);
                percpercent[i] = (double) p.numberOfOpenSites()/ (double) (n*n); 
            } 
        }
        t = trials;
    }


    public double mean() {
        return Stats.mean(percpercent);
    }


    public double stdDev() {
        return Stats.std(percpercent);
    }


    public double confidenceLo() {
        return mean() - 1.96 * stdDev() / Math.sqrt(t);
    }


    public double confidenceHi() {
        return mean() + 1.96 * stdDev() / Math.sqrt(t);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage is: java PercolationStats [size] [number of trials]");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n, t);

        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev:                 = " + ps.stdDev());
        System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}
