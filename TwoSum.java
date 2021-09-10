import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {

        int[] arr = new int[100000];
        int n = 0;
        while (!StdIn.isEmpty()) {
            arr[n] = StdIn.readInt();
            n++;
        }
        n--;
        int last = n;
        Arrays.sort(arr,0,n+1);
        for (int i = 0; i <= n; i++)
            while (last > i) {
                if (arr[last] + arr[i] >= 0) {
                    if (arr[last] == -arr[i]) StdOut.println(arr[i] + " " + arr[last]);
                    last --;
                }
                else break;
            }
    }
}