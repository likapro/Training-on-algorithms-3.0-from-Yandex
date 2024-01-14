package Lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ErrorProofQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Queue queue = new Queue(new LinkedList<Integer>());

        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case ("push"):
                    System.out.println(queue.push(Integer.parseInt(tokenizer.nextToken())));
                    break;
                case ("pop"):
                    System.out.println(queue.pop());
                    break;
                case ("front"):
                    System.out.println(queue.front());
                    break;
                case ("clear"):
                    System.out.println(queue.clear());
                    break;
                case ("size"):
                    System.out.println(queue.size());
                    break;
                case ("exit"):
                    System.out.println(queue.exit());
                    return;
            }
        }
    }

    private static class Queue {
        private List<Integer> list;

        private String push(int n) {
            list.add(n);
            return "ok";
        }

        private String pop() {
            if(list.size() == 0) return "error";
            int value = list.remove(0);

            return ""+value;
        }

        private String front() {
            if(list.size() == 0) return "error";
            int value = list.get(0);

            return ""+value;
        }

        private String size() {
            return ""+list.size();
        }

        private String clear() {
            list.clear();

            return "ok";
        }

        private String exit() {
            return "bye";
        }

        public Queue(List<Integer> list) {
            this.list = list;
        }
    }
}


