package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewYearChaos {

  public static void minimumBribes(List<Integer> arr) {
    int pos1 = 1;
    int pos2 = 2;
    int pos3 = 3;
    int result = 0;
    for (Integer integer : arr) {
      if (integer == pos1) {
        pos1 = pos2;
        pos2 = pos3;
      } else if (integer == pos2) {
        pos2 = pos3;
        result++;
      } else if (integer == pos3) {
        result += 2;
      } else {
        System.out.println("Too chaotic");
        return;
      }
      pos3++;
    }
    System.out.println(result);
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
      minimumBribes(arr);
      t--;
    }
  }
}
