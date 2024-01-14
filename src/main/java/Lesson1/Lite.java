package Lesson1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Lite {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int[] arr = new int[count];

        for(int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0, j = 1; i < count; i++) {
            if (arr[i] == j) {
                j++;
                while (!stack.empty() && stack.peek() == j) {
                    stack.pop();
                    j++;
                }
            }
            else stack.push(arr[i]);
        }

        if (stack.empty()) System.out.println("YES");
        else System.out.println("NO");
    }
}
