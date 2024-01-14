package Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CorrectBracketSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (s == '(' || s == '[' || s == '{') stack.add(s);
            else if (!stack.isEmpty() && s == ')' && stack.peek() == '(') stack.pop();
            else if (!stack.isEmpty() && s == ']' && stack.peek() == '[') stack.pop();
            else if (!stack.isEmpty() && s == '}' && stack.peek() == '{') stack.pop();
            else {
                System.out.println("no");
                return;
            }
        }

        if(!stack.isEmpty()) System.out.println("no");
        else System.out.println("yes");
    }
}
