package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class JesseAndCookies {

  public static int cookies(int k, List<Integer> A) {
    Queue minQueue = new PriorityQueue();
    int res = 0;
    for (Integer a : A) {
      minQueue.add(a);
    }
    while (true) {
      int a = (int) minQueue.peek();
      if (a >= k) {
        return res;
      }
      minQueue.poll();
      if (minQueue.isEmpty()) {
        break;
      }
      int b = (int) minQueue.poll();
      minQueue.add(a + 2 * b);
      res++;
    }
    return -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    String[] ATemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> A = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int AItem = Integer.parseInt(ATemp[i]);
      A.add(AItem);
    }

    int result = cookies(k, A);

    System.out.println(result);

    bufferedReader.close();
  }
}
