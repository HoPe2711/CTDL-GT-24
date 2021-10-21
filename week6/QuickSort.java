package week6;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

  public int partition(int[] arr, int lo, int hi) {
    int i=lo, j=hi+1;
    while (true){
      while (arr[++i] < arr[lo])
        if (i==hi) break;
      while (arr[lo] < arr[--j])
        if (j==lo) break;
      if (i>=j) break;
      int tg =arr[i];
      arr[i]=arr[j];
      arr[j]=tg;
    }

    int tg =arr[lo];
    arr[lo]=arr[j];
    arr[j]=tg;
    return j;
  }

  public void sort(int[] arr, int lo, int hi){
    if (hi<=lo) return;
    int j= partition(arr, lo, hi);
    sort(arr,lo,j-1);
    sort(arr, j+1, hi);
  }

  public void getTime(int[] arr, int loop) {
    int time = 0;
    int[] arr2;
    for (int i = 1; i <= loop; i++) {
      arr2 = Arrays.copyOf(arr, arr.length);
      long start = System.currentTimeMillis();
      StdRandom.shuffle(arr2);
      sort(arr2,0,arr2.length-1);
      long end = System.currentTimeMillis();
      time += end - start;
    }
    System.out.println((double) time/loop);
  }

  public static void main(String[] args) {

    QuickSort quickSort = new QuickSort();
    In in = new In("C:\\Users\\Cao Hoang Nam\\Downloads\\algs4-data\\4Kints.txt");
    int[] a = in.readAllInts();

    System.out.print("Time init: ");
    quickSort.getTime(a,5);

    System.out.print("Time file test: ");
    quickSort.getTime(a,3);

    int n=100000;
    a = new int[n];
    for (int i = 0; i < n; i++) {
      Random rand = new Random();
      a[i] = rand.nextInt(100000);
    }

    System.out.print("Time random test: ");
    quickSort.getTime(a, 5);

    for (int i = 0; i < n; i++) {
      a[i] = i;
    }
    System.out.print("Time tang dan test: ");
    quickSort.getTime(a, 3);

    for (int i = 0; i < n; i++) {
      a[i] = n - i;
    }
    System.out.print("Time giam dan test: ");
    quickSort.getTime(a, 3);

    for (int i = 0; i < n; i++) {
      a[i] = 1000;
    }
    System.out.print("Time bang nhau test: ");
    quickSort.getTime(a, 3);
  }
}