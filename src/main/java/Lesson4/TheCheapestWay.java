package Lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheCheapestWay {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] str = new int[M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                int k = Integer.parseInt(tokenizer.nextToken());
                if (i == 0) {
                    if (j == 0) str[j] = k;
                    else {
                        str[j] = str[j-1] + k;
                    }
                } else {
                    if (j == 0) str[j] = str[j] + k;
                    else {
                        str[j] = Math.min(str[j] + k, str[j-1] + k);
                    }
                }
            }
        }

        System.out.println(str[M-1]);
    }
}

