package Lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Grasshopper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int sum = 0;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    sum += dp[i - j];
                }
            }
            dp[i] = sum;
        }

        System.out.println(dp[N-1]);
    }
}
