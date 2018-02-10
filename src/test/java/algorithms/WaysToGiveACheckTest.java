package algorithms;

import org.junit.Test;

import java.util.Scanner;
import java.util.stream.IntStream;

import static algorithms.WaysToGiveACheck.waysToGiveACheck;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WaysToGiveACheckTest {

    @Test
    public void rockCanGiveACheckVertically() {
        String board = "########\n" +
                       "###P####\n" +
                       "########\n" +
                       "########\n" +
                       "###k####\n" +
                       "########\n" +
                       "#K######\n" +
                       "########";


        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(2);
    }

    @Test
    public void rockCanGiveACheckHorizontally1() {
        String board = "#k######\n" +
                       "###P####\n" +
                       "########\n" +
                       "########\n" +
                       "########\n" +
                       "########\n" +
                       "#K######\n" +
                       "########";


        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(2);
    }

    @Test
    public void rockCanGiveACheckHorizontally2() {
        String board = "######k#\n" +
                       "##P#####\n" +
                "########\n" +
                "########\n" +
                "########\n" +
                "########\n" +
                "#K######\n" +
                "########";


        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(2);
    }

    @Test
    public void rockCantGiveACheckHorizontallyWhenSOmeFigureBetweenStay() {
        String board = "####q#k#\n" +
                "##P#####\n" +
                "########\n" +
                "########\n" +
                "########\n" +
                "########\n" +
                "#K######\n" +
                "########";


        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(0);
    }

    @Test
    public void bishopCanGiveACheckToRightDiagonal() {
        String board = "########\n" +
                       "##P#####\n" +
                       "####k###\n" +
                       "########\n" +
                       "########\n" +
                       "########\n" +
                       "#K######\n" +
                       "########";

        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(2);
    }

    @Test
    public void bishopCanGiveACheckToLeftDiagonal() {
        String board = "########\n" +
                       "##P#####\n" +
                       "k#######\n" +
                       "########\n" +
                       "########\n" +
                       "########\n" +
                       "#K######\n" +
                       "########";

        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(2);
    }

    @Test
    public void bishopCanGiveACheckToLeftDiagonal3() {
        String board = "########\n" +
                       "#q###P##\n" +
                       "########\n" +
                       "########\n" +
                       "########\n" +
                       "k#######\n" +
                       "#K######\n" +
                       "########";

        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(2);
    }

    @Test
    public void bishopCantGiveACheckToLeftDiagonal1() {
        String board = "########\n" +
                       "##P#####\n" +
                       "########\n" +
                       "k#######\n" +
                       "########\n" +
                       "########\n" +
                       "#K######\n" +
                       "########";

        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(0);
    }

    @Test
    public void bishopCantGiveACheckToLeftDiagonal2() {
        String board = "########\n" +
                       "#qP#####\n" +
                       "k#######\n" +
                "########\n" +
                "########\n" +
                "########\n" +
                "#K######\n" +
                "########";

        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(2);
    }

    @Test
    public void knightCanGiveACheckToLeft() {
        String board = "########\n" +
                       "k#P#####\n" +
                       "########\n" +
                       "########\n" +
                       "########\n" +
                       "########\n" +
                       "#K######\n" +
                       "########";

        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(1);
    }

    @Test
    public void knightCanGiveACheckToLeft1() {
        String board = "########\n" +
                       "##P#####\n" +
                       "#k######\n" +
                       "########\n" +
                       "########\n" +
                       "########\n" +
                       "#K######\n" +
                       "########";

        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(1);
    }

    @Test
    public void knightCanGiveACheckToRight() {
        String board = "########\n" +
                       "##P#k###\n" +
                       "########\n" +
                       "########\n" +
                       "########\n" +
                       "########\n" +
                       "#K######\n" +
                       "########";

        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(1);
    }

    @Test
    public void knightCanGiveACheckToRight2() {
        String board = "########\n" +
                       "##P#####\n" +
                       "###k####\n" +
                       "########\n" +
                       "########\n" +
                       "########\n" +
                       "#K######\n" +
                       "########";

        char[][] chessboard = charTo2DArray(board);

        assertThat(waysToGiveACheck(chessboard)).isEqualTo(1);
    }




    private char[][] charTo2DArray(String input) {


        char[][] chessboard = new char[8][8];
        String[] splittedBoard = input.split("\n");
        for (int j = 0; j < 8; j++) {
           chessboard[j] =splittedBoard[j].toCharArray();
        }

        return chessboard;
    }


}