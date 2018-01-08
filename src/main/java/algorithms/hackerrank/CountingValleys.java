package algorithms.hackerrank;

import java.util.Scanner;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        final char UP = 'U';
        final char DOWN = 'D';
        int counter = 0;
        int currentLevel = 0;

        for (char c : s.toCharArray()) {
            if (currentLevel == 0 && c == DOWN) {
                counter++;
            }

            if (c == DOWN) {
                currentLevel--;
            }

            if (c == UP) {
                currentLevel++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = countingValleys(n, s);
        System.out.println(result);
        in.close();
    }
}
