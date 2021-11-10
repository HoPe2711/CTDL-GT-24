package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClosestNumber {

  public static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
    if (hi + 1 - lo >= 0) {
      System.arraycopy(arr, lo, aux, lo, hi + 1 - lo);
    }
    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        arr[k] = aux[j++];
      } else if (j > hi) {
        arr[k] = aux[i++];
      } else if (aux[j] < aux[i]) {
        arr[k] = aux[j++];
      } else {
        arr[k] = aux[i++];
      }
    }
  }

  public static void mergeSort(int[] arr, int[] aux, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    mergeSort(arr, aux, lo, mid);
    mergeSort(arr, aux, mid + 1, hi);
    merge(arr, aux, lo, mid, hi);
  }
  public static List<Integer> closestNumbers(List<Integer> arr) {
    int n = arr.size();
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++){
      numbers[i] = arr.get(i);
    }
    int[] aux = new int[n];
    mergeSort(numbers, aux, 0, n - 1);
    int minn = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      minn = Math.min(minn, numbers[i] - numbers[i-1]);
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      if (numbers[i] - numbers[i-1] == minn) {
        result.add(numbers[i-1]);
        result.add(numbers[i]);
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
