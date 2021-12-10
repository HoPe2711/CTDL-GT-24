package week13;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Cost implements Comparable<Cost> {

  public int r, v;

  public Cost(int cost, int vertex) {
    r = cost;
    v = vertex;
  }

  @Override
  public int compareTo(Cost c) {
    if (r < c.r) {
      return -1;
    }
    if (r > c.r) {
      return 1;
    }
    return Integer.compare(v, c.v);
  }

}

public class Prim {

  public static int prims(int n, List<List<Integer>> edges, int start) {

    List<List<Cost>> graph = new ArrayList<>();
    for (int i = 1; i <= n + 1; i++) {
      graph.add(new ArrayList<>());
    }
    for (List<Integer> edge : edges) {
      graph.get(edge.get(0)).add(new Cost(edge.get(2), edge.get(1)));
      graph.get(edge.get(1)).add(new Cost(edge.get(2), edge.get(0)));
    }

    PriorityQueue<Cost> pq = new PriorityQueue<>();
    pq.add(new Cost(0, start));
    boolean[] vis = new boolean[n + 1];
    int sum = 0;
    while (!pq.isEmpty()) {
      Cost a = pq.poll();
      if (!vis[a.v]) {
        vis[a.v] = true;
        sum += a.r;
        for (Cost cost : graph.get(a.v)) {
          if (vis[cost.v]) {
            continue;
          }
          pq.add(cost);
        }
      }
    }
    return sum;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> edges = new ArrayList<>();

    IntStream.range(0, m).forEach(i -> {
      try {
        edges.add(
            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int start = Integer.parseInt(bufferedReader.readLine().trim());

    int result = prims(n, edges, start);
    System.out.println(result);
    bufferedReader.close();
  }
}
