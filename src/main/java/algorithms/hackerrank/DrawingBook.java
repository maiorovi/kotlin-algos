package algorithms.hackerrank;

import java.util.Scanner;

public class DrawingBook {
    static int solve(int n, int p){


       if (n / 2 < p) {
           int q = p % 2 == 0 ? p : p - 1;
           return (n - q) / 2;
       } else {
           int q = p % 2 == 0 ? p + 1 : p;
           return (q - 1) / 2;
       }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
}
