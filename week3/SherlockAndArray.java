package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SherlockAndArray {

  public static String balancedSums(List<Integer> arr) {
    long[] sum = new long[100001];
    sum[0] = arr.get(0);
    int n = arr.size();
    for (int i = 1; i < n; i++) {
      sum[i] = sum[i - 1] + arr.get(i);
    }
    if (sum[n-1]-sum[0] == 0) return "YES";
    for (int i = 1; i < n; i++) {
      if (sum[i - 1] == sum[n - 1] - sum[i]) {
        return "YES";
      }
    }
    return "NO";
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    while (t > 0) {
      int n = scanner.nextInt();
      List<Integer> arr = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
        arr.add(scanner.nextInt());
      }
      System.out.println(balancedSums(arr));
      t--;
    }
  }
}
