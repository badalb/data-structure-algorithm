package com.prep.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < temp) {
                int[] prev = stack.pop();
                answer[prev[1]] = i - prev[1];
            }
            stack.push(new int[]{temp, i});
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(temp);
        Arrays.stream(ans)
                .forEach(System.out::println);
    }
}
