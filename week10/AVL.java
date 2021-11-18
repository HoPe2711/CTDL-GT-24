package week10;

public class AVL {

  class Node {

    int val;
    int ht;
    Node left;
    Node right;

    public Node() {

    }
  }

  Node insert(Node root, int val) {
    if (root == null) {
      root = new Node();
      root.val = val;
      root.ht = setHt(root);
      return root;
    }
    if (root.val <= val) {
      root.right = insert(root.right, val);
    }
    if (root.val > val) {
      root.left = insert(root.left, val);
    }
    int diff = getHt(root.left) - getHt(root.right);

    if (diff > 1) {
      if (getHt(root.left.left) >= getHt(root.left.right)) {
        root = rotateRight(root);
      } else {
        root.left = rotateLeft(root.left);
        root = rotateRight(root);
      }
    } else if (diff < -1) {
      if (getHt(root.right.right) >= getHt(root.right.left)) {
        root = rotateLeft(root);
      } else {
        root.right = rotateRight(root.right);
        root = rotateLeft(root);
      }
    } else {
      root.ht = setHt(root);
    }
    return root;
  }

  private static Node rotateRight(Node root) {
    Node newNode = root.left;
    root.left = newNode.right;
    newNode.right = root;
    root.ht = setHt(root);
    newNode.ht = setHt(newNode);
    return newNode;
  }

  private static Node rotateLeft(Node root) {
    Node newNode = root.right;
    root.right = newNode.left;
    newNode.left = root;
    root.ht = setHt(root);
    newNode.ht = setHt(newNode);
    return newNode;
  }

  private static int getHt(Node root) {
    if (root == null) {
      return -1;
    }
    return root.ht;
  }

  private static int setHt(Node root) {
    if (root == null) {
      return -1;
    }
    int leftHt = setHt(root.left);
    int rightHt = setHt(root.right);
    return Math.max(leftHt, rightHt) + 1;
  }
}
