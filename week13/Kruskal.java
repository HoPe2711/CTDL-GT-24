package week13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kruskal {

  public static class Edge implements Comparable<Edge> {

    public int u;
    public int v;
    public int w;

    public Edge(int u, int v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
      return this.w - o.w;
    }
  }

  public static int[] parent;
  public static int[] rank;

  public static int findPa(int u) {
    return (u == parent[u] ? u : (parent[u] = findPa(parent[u])));
  }

  public static void union(int u, int v) {
    if (rank[u] > rank[v]) {
      parent[v] = u;
      rank[u] += rank[v];
    } else {
      parent[u] = v;
      rank[v] += rank[u];
    }
  }

  public static int kruskal(ArrayList<Edge> graph, int n) {
    int ans = 0;

    parent = new int[n];
    rank = new int[n];

    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    Collections.sort(graph);

    for (Edge edge : graph) {
      int u = findPa(edge.u);
      int v = findPa(edge.v);
      int w = edge.w;
      if (u != v) {
        union(u, v);
        ans += w;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ArrayList<Edge> graph = new ArrayList<>();

    int n = sc.nextInt();
    int m = sc.nextInt();

    for (int i = 0; i < m; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;
      int w = sc.nextInt();

      graph.add(new Edge(u, v, w));
    }
    System.out.println(kruskal(graph, n));
  }
}