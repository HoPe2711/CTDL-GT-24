package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClosestNumber {

  public static List<Integer> closestNumbers(List<Integer> arr) {
    Collections.sort(arr);
    int n = arr.size();
    int minn = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      minn = Math.min(minn, arr.get(i) - arr.get(i - 1));
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      if (arr.get(i) - arr.get(i - 1) == minn) {
        result.add(arr.get(i - 1));
        result.add(arr.get(i));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> arr = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      arr.add(scanner.nextInt());
    }
    System.out.println(closestNumbers(arr));
  }
}
