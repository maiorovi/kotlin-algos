package algorithms.hackerrank;

import java.util.Scanner;

public class Kangaroo {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if ((x1 < x2 && v1 < v2) ||
                (x1 > x2) && (v1 > v2)) {
            return "NO";
        }

        int pos1 = x1 > x2 ? x2 : x1;
        int pos2 = x1 > x2 ? x1 : x2;

        for (int i = 1; pos1 < pos2; i++) {
            pos1 += v1;
            pos2 += v2;

            if (pos1 == pos2) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
