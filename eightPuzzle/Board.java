package eightPuzzle;

import edu.princeton.cs.algs4.Stack;

public class Board {

  private final int[] board;
  private final int number;
  private final int[] emtyBlock;

  private int position(int row, int col) {
    return row * number + col;
  }

  private int[] positionRevert(int n) {
    int[] pos = new int[2];
    pos[0] = n / number;
    pos[1] = n % number;
    return pos;
  }

  private int[][] swap(int x, int y, int x1, int y1) {
    int[][] copy = new int[number][number];
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        copy[i][j] = board[position(i, j)];
      }
    }
    copy[x][y] = board[position(x1, y1)];
    copy[x1][y1] = board[position(x, y)];
    return copy;
  }

  public Board(int[][] tiles) {
    if (tiles == null) {
      throw new IllegalArgumentException();
    }

    if (tiles.length != tiles[0].length) {
      throw new IllegalArgumentException();
    }
    number = tiles.length;
    board = new int[number * number];
    emtyBlock = new int[2];
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        board[position(i, j)] = tiles[i][j];
        if (tiles[i][j] == 0) {
          emtyBlock[0] = i;
          emtyBlock[1] = j;
        }
      }
    }
  }

  public String toString() {
    StringBuilder result = new StringBuilder(number + "\n");
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        result.append(board[position(i, j)]).append(" ");
      }
      result.append("\n");
    }
    return result.toString();
  }


  public int dimension() {
    return number;
  }


  public int hamming() {
    int count = 0;
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        int pos = position(i, j);
        if (board[pos] != 0 && board[pos] != i * number + j + 1) {
          count++;
        }
      }
    }
    return count;
  }

  public int manhattan() {
    int count = 0;
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        int pos = position(i, j);
        if (board[pos] != 0 && board[pos] != i * number + j + 1) {
          count += Math.abs(i - positionRevert(board[pos] - 1)[0]) + Math.abs(
              j - positionRevert(board[pos] - 1)[1]);
        }
      }
    }
    return count;
  }


  public boolean isGoal() {
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        int pos = position(i, j);
        if (board[pos] != 0 && board[pos] != i * number + j + 1) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean equals(Object y) {
    if (y == this) {
      return true;
    }
    if (y == null || y.getClass() != this.getClass()) {
      return false;
    }
    Board that = (Board) y;
    if (that.dimension() != this.dimension()) {
      return false;
    }
    for (int i = 0; i < board.length; i++) {
      if (this.board[i] != that.board[i]) {
        return false;
      }
    }
    return true;
  }

  public Iterable<Board> neighbors() {
    Stack<Board> boards = new Stack<>();
    int i = emtyBlock[0];
    int j = emtyBlock[1];
    if (i > 0) {
      boards.push(new Board(swap(i, j, i - 1, j)));
    }
    if (i < number - 1) {
      boards.push(new Board(swap(i, j, i + 1, j)));
    }
    if (j > 0) {
      boards.push(new Board(swap(i, j, i, j - 1)));
    }
    if (j < number - 1) {
      boards.push(new Board(swap(i, j, i, j + 1)));
    }
    return boards;
  }


  public Board twin() {
    if (board[0] != 0 && board[1] != 0) {
      return new Board(swap(0, 0, 0, 1));
    } else {
      return new Board(swap(1, 0, 1, 1));
    }
  }

  public static void main(String[] args) {
    int[][] a = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
    int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    Board board1 = new Board(a);
    System.out.println(board1);
    System.out.println(board1.hamming());
    System.out.println(board1.manhattan());
    System.out.println(new Board(b).isGoal());
    for (Board a1 : board1.neighbors()) {
      System.out.println(a1);
    }
  }

}