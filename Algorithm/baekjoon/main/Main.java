package Algorithm.baekjoon.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static double[] numbers;
    static double max;

    static double sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new double[N];
        max = 0;
        sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            double number = Double.parseDouble(st.nextToken());
            numbers[i] = number;
            if(number > max) max = number;
        }

        for(int i = 0; i < N; i++){
            double num = numbers[i] / max * 100;
            numbers[i] = num;
            sum += num;
        }

        System.out.println(sum / N);

    }
}