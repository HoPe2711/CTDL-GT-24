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

public class Dijkstra {

  public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
    List<List<Cost>> graph = new ArrayList<>();
    for (int i = 1; i <= n + 1; i++) {
      graph.add(new ArrayList<>());
    }
    for (List<Integer> edge : edges) {
      graph.get(edge.get(0)).add(new Cost(edge.get(2), edge.get(1)));
      graph.get(edge.get(1)).add(new Cost(edge.get(2), edge.get(0)));
    }

    int[] dis = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dis[i] = Integer.MAX_VALUE;
    }
    dis[s] = 0;
    PriorityQueue<Cost> pq = new PriorityQueue<>();
    pq.add(new Cost(0, s));
    while (!pq.isEmpty()) {
      Cost a = pq.poll();
      if (a.r != dis[a.v]) {
        continue;
      }
      for (Cost cost : graph.get(a.v)) {
        if (dis[cost.v] > dis[a.v] + cost.r) {
          dis[cost.v] = dis[a.v] + cost.r;
          pq.add(new Cost(dis[cost.v], cost.v));
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (i != s) {
        if (dis[i] != Integer.MAX_VALUE) {
          result.add(dis[i]);
        } else {
          result.add(-1);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
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

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = shortestReach(n, edges, s);
        System.out.println(result);

      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}