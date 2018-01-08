package algorithms.hackerrank;

import java.util.Scanner;

public class BreakingTheRecord {

    static int[] breakingRecords(int[] score) {
        int bestScoreIncreased = 0;
        int worstScoreDecreased = 0;

        int bestScore = score[0];
        int worstScore = score[0];
        // Complete this function

        for (int i = 1; i < score.length; i++) {
            if (bestScore < score[i]) {
                bestScore = score[i];
                bestScoreIncreased++;
            }

            if (worstScore > score[i]) {
                worstScore = score[i];
                worstScoreDecreased++;
            }
        }

        return new int[]{bestScoreIncreased, worstScoreDecreased};

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i = 0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
