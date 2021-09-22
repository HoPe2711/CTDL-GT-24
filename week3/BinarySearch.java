package week3;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

  public static int search(int key, int[] arr, int first, int last) {
    if (last < first) {
      return -1;
    }
    int mid = (first + last) / 2;
    if (arr[mid] > key) {
      return search(key, arr, first, mid - 1);
    } else if (arr[mid] < key) {
      return search(key, arr, mid + 1, last);
    } else {
      return mid;
    }
  }

  public static int binarySearch(int[] arr, int key) {
    return search(key, arr, 0, arr.length - 1);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      Random rand = new Random();
      arr[i] = rand.nextInt(100);
    }
    int key = arr[0];
    System.out.println(key);
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));

    //int key = scanner.nextInt();
    System.out.println(binarySearch(arr, key));
  }
}

