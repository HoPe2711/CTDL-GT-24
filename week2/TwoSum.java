package week2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args){

        In in = new In("C:\\Users\\admin\\Desktop\\Java\\Test\\algs4-data\\8Kints.txt");

        int[] arr = in.readAllInts();
        int n = arr.length;
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