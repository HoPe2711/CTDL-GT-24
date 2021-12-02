package week12;

import static java.lang.Math.min;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class RoadAndLibrary {

  static boolean[] check;
  static List<List<Integer>> graph;

  private static int dfs(int u) {
    int count = 1;
    check[u] = true;
    for (Integer v : graph.get(u)) {
      if (!check[v]) {
        count += dfs(v);
      }
    }
    return count;
  }

  public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
    check = new boolean[n + 1];
    graph = new ArrayList<>();
    for (int i = 1; i <= n + 1; i++) {
      graph.add(new ArrayList<>());
    }
    for (List<Integer> a : cities) {
      graph.get(a.get(0)).add(a.get(1));
      graph.get(a.get(1)).add(a.get(0));
    }
    long res = 0;
    for (int i = 1; i <= n; i++) {
      if (!check[i]) {
        int dinh = dfs(i);
        long tmp = Long.MAX_VALUE;
        for (int j = 1; j <= dinh; j++) {
          tmp = min(tmp, (long) j * c_lib + (long) (dinh - j) * c_road);
        }
        res += tmp;
      }
    }
    return res;
  }


  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int c_lib = Integer.parseInt(firstMultipleInput[2]);

        int c_road = Integer.parseInt(firstMultipleInput[3]);

        List<List<Integer>> cities = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
          try {
            cities.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList())
            );
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });

        long result = roadsAndLibraries(n, c_lib, c_road, cities);
        System.out.println(result);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}

