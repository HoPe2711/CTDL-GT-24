package week7;

public class PriorityQueue {

  int[] arr = new int[1000];
  int count = 0;

  void insert(int x) {
    arr[count++] = x;
  }

  int deleteMin() {
    int minOfArray = 10 ^ 6;
    int[] a = new int[1000];

    for (int i = 0; i < count; ++i) {
      if (arr[i] < minOfArray) {
        minOfArray = arr[i];
      }
    }
    boolean ok = false;
    int newCount = 0;
    int temp = count;
    for (int i = 0; i < count; ++i) {
      if (arr[i] == minOfArray && !ok) {
        ok = true;
        temp--;
        continue;
      }
      a[newCount++] = arr[i];
    }
    count = temp;
    arr = a;

    return minOfArray;
  }

  public static void main(String[] args) {
    PriorityQueue ob = new PriorityQueue();
    ob.insert(9);
    ob.insert(45);
    ob.insert(-100);
    System.out.println(ob.deleteMin());
    System.out.println(ob.deleteMin());
    System.out.println(ob.deleteMin());
  }
}
