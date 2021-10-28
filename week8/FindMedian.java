package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedian {

  public static List<Double> runningMedian(List<Integer> a) {

    List<Double> result = new ArrayList<>();
    int n = a.size();
    Queue maxPQ = new PriorityQueue(Collections.reverseOrder());
    Queue minPQ = new PriorityQueue();
    for (Integer integer : a) {
      if (maxPQ.isEmpty()){
        maxPQ.add(integer);
      }
      else {
        if (integer > (int) maxPQ.peek()){
          minPQ.add(integer);
          if (minPQ.size()>maxPQ.size()) {
            maxPQ.add(minPQ.poll());
          }
        }
        else {
          maxPQ.add(integer);
          if (minPQ.size()+1<maxPQ.size()) {
            minPQ.add(maxPQ.poll());
          }
        }
      }

      int b = (int) maxPQ.peek();
      if (maxPQ.size() == minPQ.size()){
        int c = (int) minPQ.peek();
        result.add(((double) ((b + c)) / 2));
      }
      else result.add((double) b);
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int aCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a = new ArrayList<>();

    for (int i = 0; i < aCount; i++) {
      int aItem = Integer.parseInt(bufferedReader.readLine().trim());
      a.add(aItem);
    }

    List<Double> result = runningMedian(a);

    for (Double aDouble : result) {
      System.out.println(aDouble);

    }

    bufferedReader.close();
  }
}
