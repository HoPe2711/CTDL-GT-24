package week5;

import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            arr[i] = rand.nextInt(1000);
        }
        //System.out.println(Arrays.toString(arr));
        for (int i=0; i<n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (arr[min] > arr[j]) min = j;
            int tg = arr[i];
            arr[i] = arr[min];
            arr[min] = tg;
            //System.out.println(Arrays.toString(arr));
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
