package week11;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Stream;

public class MissingNumber {

  public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    Hashtable<Integer, Integer> hashA = new Hashtable<>();
    Hashtable<Integer, Integer> hashB = new Hashtable<>();
    for (Integer a : arr) {
      if (!hashA.containsKey(a)) {
        hashA.put(a, 1);
      } else {
        hashA.put(a, hashA.get(a) + 1);
      }
    }
    for (Integer b : brr) {
      if (!hashB.containsKey(b)) {
        hashB.put(b, 1);
      } else {
        hashB.put(b, hashB.get(b) + 1);
      }
    }
    List<Integer> result = new ArrayList<>();
    ArrayList<Integer> tmp = Collections.list(hashB.keys());
    Collections.sort(tmp);
    for (Integer b : tmp) {
      int cnt = 0;
      if (!hashA.containsKey(b)) {
        cnt = 1;
      } else {
        cnt = hashB.get(b) - hashA.get(b);
      }
      if (cnt != 0) {
        result.add(b);
      }
    }
    return result;
  }

  public static List<Integer> sortNumber(List<Integer> arr, List<Integer> brr) {
    List<Integer> result = new ArrayList<>();
    Collections.sort(arr);
    Collections.sort(brr);
    int trace = brr.get(0);
    int cntB = 1;
    int j = 0;
    for (int i = 1; i <= brr.size(); i++) {
      if (i == brr.size() || trace != brr.get(i)) {
        int cntA = 0;
        while (j < arr.size() && arr.get(j) == trace) {
          j++;
          cntA++;
        }
        if (cntA != cntB) {
          result.add(trace);
        }
        if (i != brr.size()) {
          trace = brr.get(i);
        }
        cntB = 1;
      } else {
        cntB++;
      }
    }
    return result;
  }

  public static List<Integer> countingSort(List<Integer> arr, List<Integer> brr) {
    int[] tmp = new int[10001];
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < 10001; i++) {
      tmp[i] = 0;
    }
    for (Integer integer : arr) {
      tmp[integer]--;
    }
    for (Integer integer : brr) {
      tmp[integer]++;
    }
    for (int i = 0; i < 10001; i++) {
      if (tmp[i] > 0) {
        result.add(i);
      }
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int m = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = missingNumbers(arr, brr);
    System.out.println(result);
    System.out.println(sortNumber(arr, brr));
    System.out.println(countingSort(arr, brr));
    bufferedReader.close();
  }
}
