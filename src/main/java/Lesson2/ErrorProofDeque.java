package Lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ErrorProofDeque {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque deque = new Deque(new LinkedList<Integer>());

        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case ("push_front"):
                    System.out.println(deque.pushFront(Integer.parseInt(tokenizer.nextToken())));
                    break;
                case ("push_back"):
                    System.out.println(deque.pushBack(Integer.parseInt(tokenizer.nextToken())));
                    break;
                case ("pop_front"):
                    System.out.println(deque.popFront());
                    break;
                case ("pop_back"):
                    System.out.println(deque.popBack());
                    break;
                case ("front"):
                    System.out.println(deque.front());
                    break;
                case ("back"):
                    System.out.println(deque.back());
                    break;
                case ("clear"):
                    System.out.println(deque.clear());
                    break;
                case ("size"):
                    System.out.println(deque.size());
                    break;
                case ("exit"):
                    System.out.println(deque.exit());
                    return;
            }
        }
    }

    private static class Deque {
        private List<Integer> list;

        private String pushFront(int n) {
            list.add(0, n);
            return "ok";
        }

        private String pushBack(int n) {
            list.add(n);
            return "ok";
        }

        private String popFront() {
            if(list.size() == 0) return "error";
            int value = list.remove(0);

            return ""+value;
        }

        private String popBack() {
            if(list.size() == 0) return "error";
            int value = list.remove(list.size()-1);

            return ""+value;
        }

        private String front() {
            if(list.size() == 0) return "error";
            int value = list.get(0);

            return ""+value;
        }

        private String back() {
            if(list.size() == 0) return "error";
            int value = list.get(list.size()-1);

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

        public Deque(List<Integer> list) {
            this.list = list;
        }
    }
}


