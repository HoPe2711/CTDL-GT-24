package week5;

import java.util.Scanner;
import java.util.Stack;

public class BlancedBrackets {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return "NO";
                char a = stack.pop();
                if (s.charAt(i) == ')' && a != '(') {
                    return "NO";
                }
                if (s.charAt(i) == '}' && a != '{') {
                    return "NO";
                }
                if (s.charAt(i) == ']' && a != '[') {
                    return "NO";
                }
            }
        if (!stack.isEmpty()) return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        System.out.println(isBalanced(st));
    }
}
