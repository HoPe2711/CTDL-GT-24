import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {

        int[] arr = new int[100000];
        int n = 0;
        while (!StdIn.isEmpty()) {
            arr[n] = StdIn.readInt();
            n++;
        }
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
