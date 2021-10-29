package eightPuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

class Node implements Comparable<Node> {

  private final Board board;
  private final Node prevNode;
  private final int moves;
  private final int manhattan;

  public Node(Board board, Node prevNode) {
    this.board = board;
    this.prevNode = prevNode;
    this.manhattan = board.manhattan();
    if (prevNode != null) {
      moves = prevNode.moves + 1;
    } else {
      moves = 0;
    }
  }

  public Board getBoard() {
    return board;
  }

  public Node getPrevNode() {
    return prevNode;
  }

  @Override
  public int compareTo(Node that) {
    if ((this.manhattan + this.moves) - (that.manhattan + that.moves) > 0) {
      return 1;
    }
    return -1;
  }
}

public class Solver {

  private final Stack<Board> result;
  private boolean isSolved;

  public Solver(Board initial) {
    if (initial == null) {
      throw new IllegalArgumentException();
    }
    isSolved = false;
    result = new Stack<>();
    MinPQ<Node> boardMinPQ = new MinPQ<>();
    MinPQ<Node> boardTwinMinPQ = new MinPQ<>();
    boardMinPQ.insert(new Node(initial, null));
    boardTwinMinPQ.insert(new Node(initial.twin(), null));
    while (!boardMinPQ.min().getBoard().isGoal() && !boardTwinMinPQ.min().getBoard().isGoal()) {
      Node tmp = boardMinPQ.delMin();
      for (Board neighbor : tmp.getBoard().neighbors()) {
        if (tmp.getPrevNode() == null || !tmp.getPrevNode().getBoard().equals(neighbor)) {
          boardMinPQ.insert(new Node(neighbor, tmp));
        }
      }
      tmp = boardTwinMinPQ.delMin();
      for (Board neighbor : tmp.getBoard().neighbors()) {
        if (tmp.getPrevNode() == null || !tmp.getPrevNode().getBoard().equals(neighbor)) {
          boardTwinMinPQ.insert(new Node(neighbor, tmp));
        }
      }
    }
    if (boardMinPQ.min().getBoard().isGoal()) {
      isSolved = true;
      Node trace = boardMinPQ.min();
      while (trace != null) {
        result.push(trace.getBoard());
        trace = trace.getPrevNode();
      }
    }
  }

  public boolean isSolvable() {
    return isSolved;
  }

  public int moves() {
    if (!isSolved) {
      return -1;
    }
    return result.size() - 1;
  }

  public Iterable<Board> solution() {
    if (!isSolved) {
      return null;
    }
    return result;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    int n = in.readInt();
//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
    int[][] tiles = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        tiles[i][j] = in.readInt();
//        tiles[i][j] = sc.nextInt();
      }
    }
    Board initial = new Board(tiles);

    Solver solver = new Solver(initial);

    if (!solver.isSolvable()) {
      StdOut.println("No solution possible");
    } else {
      StdOut.println("Minimum number of moves = " + solver.moves());
      for (Board board : solver.solution()) {
        StdOut.println(board);
      }
    }
  }

}