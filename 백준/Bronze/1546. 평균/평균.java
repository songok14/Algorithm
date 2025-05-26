import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[] score = new int[testCase];
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < testCase; i++) {
            score[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(score);

        double sum = 0;
        double average = 0;

        for (int i = 0; i < testCase; i++) {
            sum += (double) score[i] / (double) score[testCase - 1] * 100;
        }

        average = sum / testCase;
        System.out.println(average);

        br.close();
    }
}