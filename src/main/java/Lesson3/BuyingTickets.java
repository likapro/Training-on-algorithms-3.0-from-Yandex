package Lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuyingTickets {
    public static void main(String[]args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int[][] arr = new int[N][4];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int A = Integer.parseInt(tokenizer.nextToken());
            int B = Integer.parseInt(tokenizer.nextToken());
            int C = Integer.parseInt(tokenizer.nextToken());

            arr[i][0] = A;
            arr[i][1] = B;
            arr[i][2] = C;

            if (i == 0) {
                arr[i][3] = arr[i][0];
            } else if (i == 1) {
                arr[i][3] = Math.min(arr[i-1][0] + arr[i][0], arr[i-1][1]);
            } else if (i == 2) {
                int min1 = Math.min(arr[i - 2][0] + arr[i - 1][0] + arr[i][0], arr[i - 2][0] + arr[i - 1][1]);
                int min2 = Math.min(arr[i - 2][1] + arr[i][0], arr[i - 2][2]);
                arr[i][3] = Math.min(min1, min2);
            } else {
                int min1 = Math.min(arr[i - 1][3] + arr[i][0], arr[i - 2][3] + arr[i-1][1]);
                arr[i][3] = Math.min(min1, arr[i - 3][3] + arr[i-2][2]);
            }
        }

        System.out.println(arr[N-1][3]);
    }
}
