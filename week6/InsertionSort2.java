package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InsertionSort2 {

  public static void insertionSort2(int n, List<Integer> arr) {
    for (int i = 1; i<n; i++) {
      for (int j = i; j > 0 && (arr.get(j) < arr.get(j - 1)); j--) {
        int tg = arr.get(j);
        arr.set(j, arr.get(j - 1));
        arr.set(j - 1, tg);
      }
      for (int j: arr) System.out.print(j + " ");
      System.out.print("\n");
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    insertionSort2(n, arr);

    bufferedReader.close();
  }
}
