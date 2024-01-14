package Lesson1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Lineland {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] arr = new int[count];
        int[] arrRez = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
            arrRez[i] = -1;
        }

        Stack<Integer> index = new Stack<>();
        Stack<Integer> price = new Stack<>();

        for (int i = 0; i < count; i++) {
            while (!price.empty() && arr[i] < price.peek()) {
                arrRez[index.pop()] = i;
                price.pop();
            }

            index.push(i);
            price.push(arr[i]);

        }

        StringBuffer strOut = new StringBuffer();
        for (int i = 0; i < count; i++) {
            strOut.append(arrRez[i] + " ");
        }

        System.out.println(strOut);
    }
}
