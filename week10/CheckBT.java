package week10;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckBT {

  static void getOrder(ArrayList<Integer> arr, Node root) {
    if (root == null) {
      return;
    }
    getOrder(arr, root.left);
    arr.add(root.data);
    getOrder(arr, root.right);
  }

  static boolean checkBST(Node root) {
    if (root == null) {
      return false;
    }
    ArrayList<Integer> arr = new ArrayList<Integer>();
    getOrder(arr, root);
    for (int i = 1; i < arr.size(); i++) {
      if (arr.get(i) <= arr.get(i - 1)) {
        return false;
      }
    }
    return true;
  }

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
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
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    System.out.println(checkBST(root));
  }
}



