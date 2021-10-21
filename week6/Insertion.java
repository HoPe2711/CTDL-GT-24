package week6;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Random;

public class Insertion {

  public void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--) {
        int tg = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = tg;
      }
    }
  }

  public void getTime(int[] arr, int loop) {
    int time = 0;
    int[] arr2;
    for (int i = 1; i <= loop; i++) {
      arr2 = Arrays.copyOf(arr, arr.length);
      long start = System.currentTimeMillis();
      insertionSort(arr2);
      long end = System.currentTimeMillis();
      time += end - start;
    }
    System.out.println((double) time/loop);
  }

  public static void main(String[] args) {
    int n=4000;
    Insertion insertion = new Insertion();
    In in = new In("C:\\Users\\Cao Hoang Nam\\Downloads\\algs4-data\\4Kints.txt");
    int[] a = in.readAllInts();

    System.out.print("Time init: ");
    insertion.getTime(a,5);

    System.out.print("Time file test: ");
    insertion.getTime(a,3);

    for (int i=0; i<n; i++) {
      Random rand = new Random();
      a[i] = rand.nextInt(5000);
    }
    System.out.print("Time random test: ");
    insertion.getTime(a,5);

    for (int i=0; i<n; i++) {
      a[i] = i;
    }
    System.out.print("Time tang dan test: ");
    insertion.getTime(a,3);

    for (int i=0; i<n; i++) {
      a[i] = n-i;
    }
    System.out.print("Time giam dan test: ");
    insertion.getTime(a,3);

    for (int i=0; i<n; i++) {
      a[i] = 1000;
    }
    System.out.print("Time bang nhau test: ");
    insertion.getTime(a,3);
  }
}