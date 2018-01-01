package algorithms.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class AppleAndOrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for (int apple_i = 0; apple_i < m; apple_i++) {
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for (int orange_i = 0; orange_i < n; orange_i++) {
            orange[orange_i] = in.nextInt();
        }
        int[] result = appleAndOrange(s, t, a, b, apple, orange);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }

    static int[] appleAndOrange(int s, int t, int a, int b, int[] apple, int[] orange) {
        int apples = Arrays.stream(apple)
                .filter(i -> (a + i) >= s && (a + i) <= t)
                .map(i -> 1)
                .sum();

        int oranges = Arrays.stream(orange)
                .filter(i -> (b + i) >= s && (b + i) <= t )
                .map(i -> 1)
                .sum();

        return new int[]{apples, oranges};
    }
}
