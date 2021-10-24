package week2.percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double meanValue;
    private final double stddevValue;
    private final double confidenceLoValue;
    private final double confidenceHiValue;
    private static final double CONFIDENCE_96 = 1.96;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        double[] results = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int x, y;
                do {
                    x = StdRandom.uniform(n) + 1;
                    y = StdRandom.uniform(n) + 1;
                } while (percolation.isOpen(x, y));
                percolation.open(x, y);
            }
            results[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
        meanValue = StdStats.mean(results);
        stddevValue = StdStats.stddev(results);
        confidenceLoValue = meanValue - CONFIDENCE_96 * stddevValue / Math.sqrt(trials);
        confidenceHiValue = meanValue + CONFIDENCE_96 * stddevValue / Math.sqrt(trials);
    }

    public double mean() {
        return meanValue;
    }

    public double stddev() {
        return stddevValue;
    }

    public double confidenceLo() {
        return confidenceLoValue;
    }

    public double confidenceHi() {
        return confidenceHiValue;
    }

    public static void main(String[] args) {
        int n = 1, trials = 1;
        if (args.length >= 2) {
            n = Integer.parseInt(args[0]);
            trials = Integer.parseInt(args[1]);
        }
        PercolationStats ps = new PercolationStats(n, trials);

        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }

}
