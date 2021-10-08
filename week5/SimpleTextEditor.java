package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        int q = Integer.parseInt(bufferedReader.readLine());
        String st = "";
        stack.add(st);
        for (int i = 1; i <= q; i++) {
            String[] type = bufferedReader.readLine().split(" ");
            if (type[0].equals("1")) {
                String add = type[1];
                st = st + add;
                stack.add(st);
            } else if (type[0].equals("2")) {
                int n = Integer.parseInt(type[1]);
                st = st.substring(0, st.length() - n);
                stack.add(st);
            } else if (type[0].equals("3")) {
                int n = Integer.parseInt(type[1]);
                System.out.println(stack.peek().charAt(n - 1));
            } else {
                stack.pop();
                st = stack.peek();
            }
        }
    }
}
