package algorithms.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class BetweenTwoSets {

    static int getTotalX(int[] a, int[] b) {
        long lcm = find(a, (x,y) -> lcm(x,y));
        long gcd = find(b, (x,y) -> gcd(x,y));

        return (int) LongStream.rangeClosed(lcm, gcd).filter(i -> i % lcm == 0 && gcd % i == 0).count();
    }

    private static long find(int[] arr, BiFunction<Long, Long, Long> jobFunction) {
        if (arr.length == 1) {
            return jobFunction.apply(Long.valueOf(arr[0]), -1l);
        }
        Arrays.sort(arr);
        long currentVal = jobFunction.apply(Long.valueOf(arr[0]), Long.valueOf(arr[1]));

        for (int i = 2; i < arr.length; i++) {
            currentVal = jobFunction.apply(currentVal, Long.valueOf(arr[i]));
        }

        return currentVal;
    }


    private static long lcm(long a, long b) {
        if (b < 0) {
            return a;
        }

        long left = a > b ? a : b;
        long right = a > b ? b : a;

        for (int coeff = 1; coeff < a * b; coeff++) {
            long value = left * coeff;
            if (value % right == 0) {
                return value;
            }
        }

        return -1;
    }


    private static long gcd(long a, long b) {
        if (b < 0) {
            return a;
        }

        long left = a > b ? a : b;
        long right = a > b ? b : a;

        do {
            long tmp = right;
            right = left % right;
            left = tmp;
        }  while ( right != 0);

        return left;
    }




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
