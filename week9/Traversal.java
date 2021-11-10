package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Traversal {

  public static void levelOrder(Node root) {
    List<Node> tree = new ArrayList<>();
    tree.add(root);
    int a = 0;
    while (a<tree.size()){
      Node tmp = tree.get(a);
      if (tmp.left != null) tree.add(tmp.left);
      if (tmp.right != null) tree.add(tmp.right);
      a++;
    }
    for (Node tmp : tree) {
      System.out.print(tmp.data + " ");
    }
  }

  public static Node insert(Node root, int data) {
    if(root == null) {
      return new Node(data);
    } else {
      Node cur;
      if(data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while(t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    levelOrder(root);
  }
}