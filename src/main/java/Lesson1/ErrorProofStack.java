package Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ErrorProofStack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack(new ArrayList<Integer>());

        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case ("push"):
                    System.out.println(stack.push(Integer.parseInt(tokenizer.nextToken())));
                    break;
                case ("pop"):
                    System.out.println(stack.pop());
                    break;
                case ("back"):
                    System.out.println(stack.back());
                    break;
                case ("clear"):
                    System.out.println(stack.clear());
                    break;
                case ("size"):
                    System.out.println(stack.getSize());
                    break;
                case ("exit"):
                    System.out.println(stack.exit());
                    return;
            }
        }
    }

    private static class Stack {
        private int size;
        private int last;
        private List<Integer> list;

        private String push(int n) {
            list.add(last+1, n);
            size++;
            last++;
            return "ok";
        }

        private String pop() {
            if(size == 0) return "error";
            int value = list.get(last);
            size--;
            last--;

            return ""+value;
        }

        private String back() {
            if(size == 0) return "error";
            int value = list.get(last);

            return ""+value;
        }

        private String clear() {
            size = 0;
            last = -1;

            return "ok";
        }

        private String exit() {
            return "bye";
        }
        public int getSize() {
            return size;
        }

        public Stack(List<Integer> list) {
            this.list = list;
            this.size = 0;
            this.last = -1;
        }
    }
}
