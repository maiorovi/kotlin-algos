package algorithms.hackerrank;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BirthdayChocolate {

    static int solve(int n, int[] s, int d, int m){
        int i = 0;
        int j = m;
        int counter = 0;

        int currentSum = IntStream.range(0, j).map(k -> s[k]).sum();

        if (currentSum == d) {
            counter++;
        }

        for (int k = j; k < s.length; k++) {
            currentSum = currentSum - s[i++] + s[k];

            if (currentSum == d) {
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }

}
