package Lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(reader.readLine());

        int[] dp = new int[value+1];
        for (int i = 1; i <= value; i++) {
            if (i == 1) dp[i] = 2;
            if (i == 2) dp[i] = 4;
            if (i == 3) dp[i] = 7;
            if (i > 3) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }

        System.out.println(dp[value]);
    }
}

