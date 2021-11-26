package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


class Node implements Comparable<Node> {

  int key;
  int value;

  public Node(int key, int value) {
    this.key = key;
    this.value = value;
  }

  public double getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public int compareTo(Node node) {
    if (this.getKey() == node.getKey()) {
      return -(this.getValue() - node.getValue());
    }
    if (this.getKey() > node.getKey()) {
      return 1;
    } else {
      return -1;
    }
  }
}

public class FindMedian {

  public static List<Double> runningMedian(List<Integer> a) {

    List<Double> result = new ArrayList<>();
    TreeSet<Node> treeSet = new TreeSet<>();
    int n = a.size();
    Node median = new Node(a.get(0), 0);
    treeSet.add(median);
    result.add(median.key * 1.0);
    for (int i = 1; i < n; i++) {
      Node aa = new Node(a.get(i), i);
      treeSet.add(aa);
      if (i % 2 == 1) {
        if (median.compareTo(aa) >= 0) {
          median = treeSet.lower(median);
        }
        result.add((median.key + treeSet.higher(median).key) / 2.0);
      } else {
        if (median.compareTo(aa) < 0) {
          median = treeSet.higher(median);
        }
        result.add(median.key * 1.0);
      }
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
