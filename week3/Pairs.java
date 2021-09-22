package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Pairs {

  public static int pairs(int k, List<Integer> arr) {
    Collections.sort(arr);
    int n = arr.size();
    int result = 0;
    int j = 1;
    for (Integer integer : arr) {
      while (j < n) {
        if (integer + k < arr.get(j)) {
          break;
        } else {
          if (integer + k == arr.get(j)) {
            result++;
          }
          j++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    List<Integer> arr = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      arr.add(scanner.nextInt());
    }
    System.out.println(pairs(k, arr));
  }
}
