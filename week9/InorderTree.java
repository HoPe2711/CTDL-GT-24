package week9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Node {
  Node left;
  Node right;
  int data;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class InorderTree {

  public static List<Integer> bnt(Node cur){
    List<Integer> tmp = new ArrayList<>();
    tmp.add(cur.data);
    if (cur.left ==  null && cur.right == null) return tmp;
    if (cur.left != null) tmp.addAll(bnt(cur.left));
    if (cur.right != null) tmp.addAll(bnt(cur.right));
    return tmp;
  }

  public static void inOrder(Node root) {
    List<Integer> tmp = bnt(root);
    Collections.sort(tmp);
    for (Integer a: tmp){
      System.out.print(a + " ");
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
    inOrder(root);
  }
}