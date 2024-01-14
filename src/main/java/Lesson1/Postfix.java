package Lesson1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Postfix {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        Stack<String> stack = new Stack<>();
        while (tokenizer.hasMoreTokens()) {
            String el = tokenizer.nextToken();
            if (el.equals("+")) {
                int value2 = Integer.parseInt(stack.pop());
                int value1 = Integer.parseInt(stack.pop());
                stack.push(value1+value2+"");
            } else if (el.equals("-")) {
                int value2 = Integer.parseInt(stack.pop());
                int value1 = Integer.parseInt(stack.pop());
                stack.push(value1-value2+"");
            } else if (el.equals("*")) {
                int value2 = Integer.parseInt(stack.pop());
                int value1 = Integer.parseInt(stack.pop());
                stack.push(value1*value2+"");
            } else {
                stack.push(el);
            }
        }

        System.out.println(stack.pop());
    }
}
