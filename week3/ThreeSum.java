package week3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {

        In in = new In("C:\\Users\\admin\\Desktop\\Java\\Test\\algs4-data\\8Kints.txt");

        int[] arr = in.readAllInts();
        int n = arr.length;
        n--;
        Arrays.sort(arr,0,n+1);
        for (int i = 0; i <= n-2; i++) {
            int first = i + 1;
            int last = n;
            while (last > first) {
                int sum = arr[first] + arr[last] + arr[i];
                if (sum == 0) {
                    StdOut.println(arr[i] + " " + arr[first] + " " + arr[last]);
                    last--;
                    first++;
                }
                else if (sum>0) last --;
                else first ++;
            }
        }
    }
}
