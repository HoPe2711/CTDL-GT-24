package week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class UFClient2 {
    public static void main(String[] args) {
        int count = 0;
        int step = 0;
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            step = step + 1;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                count = count + 1;
                if (count == N-1) {
                    StdOut.println(step);
                    System.exit(0);
                }
            }
        }
        StdOut.println("FAILED");
    }
}