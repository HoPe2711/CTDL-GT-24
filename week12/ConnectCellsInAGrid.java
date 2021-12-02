package week12;

import java.util.Scanner;

public class ConnectCellsInAGrid {

  static int[][] grid;
  static boolean[][] visited;
  static int N, M;
  static int[] dirX = {1, -1, 1, -1, 0, 0, 1, -1};
  static int[] dirY = {1, -1, -1, 1, 1, -1, 0, 0};

  public static boolean check(int row, int col) {
    return 0 <= row && row < N && 0 <= col && col < M && grid[row][col] == 1;
  }

  static int count_connected(int row, int col) {
    int cnt = 0;
    cnt++;
    visited[row][col] = true;
    for (int i = 0; i < 8; i++) {
      int u = row + dirX[i];
      int v = col + dirY[i];
      if (check(u, v) && !visited[u][v]) {
        cnt += count_connected(u, v);
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    N = scanner.nextInt();
    M = scanner.nextInt();
    grid = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        grid[i][j] = scanner.nextInt();
        visited[i][j] = false;
      }
    }
    int max = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        if (grid[i][j] == 0 || visited[i][j]) {
          continue;
        }
        int cnt = count_connected(i, j);
        if (max < cnt) {
          max = cnt;
        }
      }
    }

    System.out.println(max);

  }
}