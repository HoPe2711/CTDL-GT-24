package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InsertionSort1 {

  public static void insertionSort1(int n, List<Integer> arr) {
    int last = arr.get(n-1);
    arr.remove(n-1);
    for (int t=1; t<=n-1; t++){
      int tmp = arr.get(n - t -1);
      if (tmp < last) {
        tmp = last;
        arr.add(n-t, tmp);
        for (int i: arr) System.out.print(i + " ");
        System.out.print("\n");
        return;
      }
      arr.add(n-t, tmp);
      for (int i: arr) System.out.print(i + " ");
      System.out.print("\n");
      arr.remove(n-t);
    }
    arr.add(0,last);
    for (int i: arr) System.out.print(i + " ");
    System.out.print("\n");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    insertionSort1(n, arr);

    bufferedReader.close();
  }
}
