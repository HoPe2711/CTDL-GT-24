package week7;

import java.util.Scanner;

public class QuickSortInPlace {
    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo;
        for (int j=lo; j<=hi-1; j++)
            if (arr[j]<pivot){
                int tg =arr[i];
                arr[i]=arr[j];
                arr[j]=tg;
                i++;
            }
        int tg =arr[i];
        arr[i]=arr[hi];
        arr[hi]=tg;
        for (int a: arr) System.out.print(a + " ");
        System.out.print("\n");
        return i;
    }

    public static void sort(int[] arr, int lo, int hi){
        if (hi<=lo) return;
        int j= partition(arr, lo, hi);
        sort(arr,lo,j-1);
        sort(arr, j+1, hi);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = scanner.nextInt();
        sort(arr,0, n-1);
    }
}
