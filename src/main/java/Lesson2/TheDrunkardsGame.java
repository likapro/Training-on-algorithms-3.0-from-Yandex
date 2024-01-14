package Lesson2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TheDrunkardsGame {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = 5;

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        Queue<Integer> queue1 = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            queue1.add(Integer.parseInt(tokenizer.nextToken()));
        }

        tokenizer = new StringTokenizer(reader.readLine());
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            queue2.add(Integer.parseInt(tokenizer.nextToken()));
        }

        System.out.println(game(queue1, queue2));
    }

    private static String game(Queue<Integer> queue1, Queue<Integer> queue2) {
        final int MAX_TURN = 1000000;
        for (int i = 0; i < MAX_TURN; i++) {
            int value1 = queue1.poll();
            int value2 = queue2.poll();

            if (value1 == 0 && value2 == 9) {
                queue1.add(value1);
                queue1.add(value2);
            } else if (value1 == 9 && value2 == 0) {
                queue2.add(value1);
                queue2.add(value2);
            } else if (value1 > value2) {
                queue1.add(value1);
                queue1.add(value2);
            } else if (value1 < value2) {
                queue2.add(value1);
                queue2.add(value2);
            } else {
                queue1.add(value1);
                queue2.add(value2);
            }

            if (queue1.isEmpty()) return "second " + (i+1);
            if (queue2.isEmpty()) return "first " + (i+1);
        }


        return "botva";
    }
}
