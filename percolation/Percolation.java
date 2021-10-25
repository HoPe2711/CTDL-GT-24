package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final boolean[] sites;
    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private final WeightedQuickUnionUF topConnected;
    private final int number;
    private int numberOpenSites;

    private int position(int row, int col) {
        return (row - 1) * number + col;
    }

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        weightedQuickUnionUF = new WeightedQuickUnionUF(n * n + 2);
        topConnected = new WeightedQuickUnionUF(n * n + 1);
        sites = new boolean[n * n + 2];
        number = n;
        numberOpenSites = 0;
    }

    public void open(int row, int col) {
        if (row < 1 || row > number || col < 1 || col > number) throw new IllegalArgumentException();
        int pos = position(row, col);
        if (!sites[pos]) {
            sites[pos] = true;
            numberOpenSites++;
            if (row == 1) {
                weightedQuickUnionUF.union(0, pos);
                topConnected.union(0, pos);
            } else if (sites[pos - number]) {
                weightedQuickUnionUF.union(pos - number, pos);
                topConnected.union(pos - number, pos);
            }
            if (row == number) weightedQuickUnionUF.union(number * number + 1, pos);
            else if (sites[pos + number]) {
                weightedQuickUnionUF.union(pos + number, pos);
                topConnected.union(pos + number, pos);
            }
            if (col > 1 && sites[pos - 1]) {
                weightedQuickUnionUF.union(pos - 1, pos);
                topConnected.union(pos - 1, pos);
            }
            if (col < number && sites[pos + 1]) {
                weightedQuickUnionUF.union(pos + 1, pos);
                topConnected.union(pos + 1, pos);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (row < 1 || row > number || col < 1 || col > number) throw new IllegalArgumentException();
        return sites[position(row, col)];
    }

    public boolean isFull(int row, int col) {
        if (row < 1 || row > number || col < 1 || col > number) throw new IllegalArgumentException();
        return topConnected.find(0) == topConnected.find(position(row, col));
    }

    public int numberOfOpenSites() {
        return numberOpenSites;
    }

    public boolean percolates() {
        return weightedQuickUnionUF.find(0) == weightedQuickUnionUF.find(number * number + 1);
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(6);
//        Scanner scanner = new Scanner(System.in);
//        for (int i = 1; i <= 4; i++) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            percolation.open(a + 1, b + 1);
//        }
        percolation.open(1, 6);
        percolation.open(3, 5);
        percolation.open(2, 1);
        System.out.println(percolation.isOpen(2, 1));
    }
}
