package week5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class QueueTwoStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queue = new ArrayDeque<>();
        int q = scanner.nextInt();
        for (int i=1; i<=q; i++){
            int type = scanner.nextInt();
            if (type == 1){
                int number = scanner.nextInt();
                queue.addLast(number);
            }
            else if (type == 2){
                queue.pollFirst();
            }
            else {
                System.out.println(queue.getFirst());
            }
        }
    }
}
