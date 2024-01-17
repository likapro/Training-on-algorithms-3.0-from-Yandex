package Lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KnightsMove {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        if (N == 1 || M <= 1) {
            System.out.println(0);
            return;
        }


        int[][] arr = new int[N][M];
        arr[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0) {

                    if (i+2 < N && j+1 < M) {
                        if (arr[i+2][j+1] == 0) arr[i+2][j+1] = arr[i][j];
                        else arr[i+2][j+1] += arr[i][j];
                    }

                    if (i+1 < N && j+2 < M) {
                        if (arr[i+1][j+2] == 0) arr[i+1][j+2] = arr[i][j];
                        else  arr[i+1][j+2] += arr[i][j];
                    }
                }
            }
        }

        System.out.println(arr[N-1][M-1]);
    }
}
