package week11;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class Pairs {

  public static int pairs(int k, List<Integer> arr) {
    HashSet<Integer> hashSet = new HashSet<>();
    int res = 0;
    for (Integer integer : arr) {
      hashSet.add(integer);
    }
    for (Integer integer : arr) {
      if (hashSet.contains(integer + k)) {
        res++;
      }
    }
    return res;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    System.out.println(pairs(k, arr));
    bufferedReader.close();
  }
}
