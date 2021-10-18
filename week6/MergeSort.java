package week6;

import edu.princeton.cs.algs4.In;
import java.util.Arrays;
import java.util.Random;

public class MergeSort {

  public void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
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

  public void mergeSort(int[] arr, int[] aux, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    mergeSort(arr, aux, lo, mid);
    mergeSort(arr, aux, mid + 1, hi);
    merge(arr, aux, lo, mid, hi);
  }

  public void getTime(int[] arr, int loop) {
    int time = 0;
    int[] arr2;
    for (int i = 1; i <= loop; i++) {
      arr2 = Arrays.copyOf(arr, arr.length);
      long start = System.currentTimeMillis();
      int[] aux = new int[arr2.length];
      mergeSort(arr2, aux, 0, arr2.length - 1);
      long end = System.currentTimeMillis();
      time += end - start;
    }
    System.out.println((double) time / loop);
  }

  public static void main(String[] args) {
    int n = 4000;
    MergeSort mergeSort = new MergeSort();
    In in = new In("C:\\Users\\binht\\Downloads\\algs4-data\\tiny.txt");
    int[] a = in.readAllInts();

    System.out.print("Time init: ");
    mergeSort.getTime(a, 5);

    System.out.print("Time file test: ");
    mergeSort.getTime(a, 3);

    n=100000;
    a = new int[n];
    for (int i = 0; i < n; i++) {
      Random rand = new Random();
      a[i] = rand.nextInt(4000);
    }

    System.out.print("Time random test: ");
    mergeSort.getTime(a, 5);

    for (int i = 0; i < n; i++) {
      a[i] = i;
    }
    System.out.print("Time tang dan test: ");
    mergeSort.getTime(a, 3);

    for (int i = 0; i < n; i++) {
      a[i] = n - i;
    }
    System.out.print("Time giam dan test: ");
    mergeSort.getTime(a, 3);

    for (int i = 0; i < n; i++) {
      a[i] = 1000;
    }
    System.out.print("Time bang nhau test: ");
    mergeSort.getTime(a, 3);
  }
}