package week12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShortestReach {

  static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
    int[] costs = new int[graph.size()];
    int UNIT_COST = 6;
    Arrays.fill(costs, -1);
    int f = 1, r = 0;
    int[] queue = new int[graph.size() * 4];
    r++;
    queue[r] = start;
    costs[start] = 0;
    while (f <= r) {
      int u = queue[f];
      f++;
      for (Integer v : graph.get(u)) {
        if (costs[v] == -1 || costs[v] > costs[u] + UNIT_COST) {
          costs[v] = costs[u] + UNIT_COST;
          r++;
          queue[r] = v;
        }
      }
    }

    return costs;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int Q = scanner.nextInt();
    for (int q = 0; q < Q; ++q) {
      int N, M, start;
      N = scanner.nextInt();
      M = scanner.nextInt();
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for (int i = 0; i <= N; ++i) {
        graph.add(new ArrayList<>());
      }
      for (int i = 0; i < M; ++i) {
        int n1, n2;
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        graph.get(n1).add(n2);
        graph.get(n2).add(n1);
      }
      start = scanner.nextInt();
      int[] costs = findShortestReach(graph, start);
      for (int i = 1; i < costs.length; ++i) {
        if (i == start) {
          continue;
        }
        System.out.print(costs[i] + " ");
      }
      System.out.println();
    }
  }
}