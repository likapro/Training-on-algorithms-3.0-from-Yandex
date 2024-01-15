package Lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumCostRoute {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                int k = Integer.parseInt(tokenizer.nextToken());
                if (i == 0) {
                    if (j == 0) arr[i][j] = k;
                    else {
                        arr[i][j] = arr[i][j-1] + k;
                    }
                } else {
                    if (j == 0) arr[i][j] = arr[i-1][j] + k;
                    else {
                        arr[i][j] = Math.max(arr[i-1][j] + k, arr[i][j-1] + k);
                    }
                }
            }
        }

        System.out.println(arr[N-1][M-1]);

        StringBuffer buffer = new StringBuffer();
        int i = N-1, j = M-1;
        while (i > 0 || j > 0) {
            if (i == 0) {
                while (j > 0) {
                    j--;
                    buffer.insert(0,"R ");
                }
                continue;
            }

            if (j == 0) {
                while (i > 0) {
                    i--;
                    buffer.insert(0,"D ");
                }
                continue;
            }

            if (arr[i][j-1] > arr[i-1][j]) {
                j--;
                buffer.insert(0, "R ");
            } else {
                i--;
                buffer.insert(0,"D ");
            }
        }

        System.out.println(buffer);
    }
}
