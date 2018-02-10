package algorithms;

import java.util.Scanner;
import java.util.stream.IntStream;

public class WaysToGiveACheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        IntStream.range(0, t).forEach(z -> {
            char[][] chessboard = new char[8][8];

            for (int j = 0; j < 8; j++) {
                chessboard[j] = sc.next().toCharArray();
            }

            int x = waysToGiveACheck(chessboard);

            System.out.println(x);
        });
    }

    public static int waysToGiveACheck(char[][] chessboard) {
        int counter = 0;
        Position blackKingPos = findPositionOfBlackKing(chessboard);
        Position whitePawnPos = findPositionOfWhitePawn(chessboard);

        if (canRockGiveACheck(whitePawnPos, blackKingPos, chessboard)) {
            counter++;
        }

        if(canBishopGiveACheck(whitePawnPos, blackKingPos, chessboard)) {
            counter++;
        }

        if(canKnightGiveACheck(whitePawnPos, blackKingPos, chessboard)) {
            counter++;
        }

        if (canQueenGiveAcheck(whitePawnPos, blackKingPos, chessboard)) {
            counter++;
        }


        return counter;
    }

    private static boolean canQueenGiveAcheck(Position whitePawnPos, Position blackKingPos, char[][] chessboard) {
        return canRockGiveACheck(whitePawnPos, blackKingPos, chessboard) || canBishopGiveACheck(whitePawnPos, blackKingPos, chessboard);
    }

    private static boolean canKnightGiveACheck(Position whitePawnPos, Position blackKingPos, char[][] chessboard) {
        boolean leftShortPosition = (whitePawnPos.getRow() + 1) == blackKingPos.getRow() &&
                (whitePawnPos.getColumn() - 2) == blackKingPos.getColumn();

        boolean rightShortPosition = (whitePawnPos.getRow() + 1) == blackKingPos.getRow() &&
                (whitePawnPos.getColumn() + 2) == blackKingPos.getColumn();

        boolean leftLongPosition = (whitePawnPos.getRow() + 2) == blackKingPos.getRow() &&
                (whitePawnPos.getColumn() - 1 ) == blackKingPos.getColumn();

        boolean rightLongPosition = (whitePawnPos.getRow() + 2) == blackKingPos.getRow() &&
                (whitePawnPos.getColumn() + 1 ) == blackKingPos.getColumn();

        if (leftShortPosition || rightShortPosition || leftLongPosition || rightLongPosition) { return true; }

        return false;
    }

    private static boolean canBishopGiveACheck(Position knightPos, Position blackKingPos, char[][] chessboard) {
        //follow diagonal if found figure discard or
        int currentRow = knightPos.getRow() + 1;
        int leftColumn = knightPos.getColumn() - 1;
        int rightColumn = knightPos.getColumn() + 1;
        boolean leftFalse = false;
        boolean rightFalse = false;


        while(currentRow <= blackKingPos.getRow()) {
            if (leftColumn >= 0 && chessboard[currentRow][leftColumn] != '#') { leftFalse = true; }
            if (rightColumn < 8 && chessboard[currentRow][rightColumn] != '#') { rightFalse = true; }
            if(leftFalse && rightFalse) { return false; }

            if ((currentRow == blackKingPos.getRow() && leftColumn == blackKingPos.getColumn()) ||
                    (currentRow == blackKingPos.getRow() && rightColumn == blackKingPos.getColumn())) {
                return true;
            }


            if (leftColumn >= 0) {  leftColumn--; }
            if (rightColumn <= 7) { rightColumn++; }
            currentRow++;
        }

        return false;
    }

    public static boolean canRockGiveACheck(Position whitePosition, Position blackKingPos, char[][] chessboard) {
        if (whitePosition.getColumn() == blackKingPos.getColumn()) {
            int column = whitePosition.getColumn();
            int startingIndex = Math.min(whitePosition.getRow(), blackKingPos.getRow());
            int endIndex = Math.max(whitePosition.getRow(), blackKingPos.getRow());

            return IntStream.range(startingIndex+1, endIndex).map(i -> chessboard[i][column]).allMatch(i -> i == '#');
        } else if (whitePosition.getRow() == blackKingPos.getRow()) {
            int row = whitePosition.getRow();
            int startingIndex = Math.min(whitePosition.getColumn(), blackKingPos.getColumn());
            int endIndex = Math.max(whitePosition.getColumn(), blackKingPos.getColumn());

            return IntStream.range(startingIndex+1, endIndex).map(i -> chessboard[row][i]).allMatch(i -> i == '#');
        }

        return false;
    }

    private static Position findPositionOfBlackKing(char[][] chessboard) {
        Position position = new Position();

        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[0].length; j++) {
                if (chessboard[i][j] == Figures.KING_BLACK.getName()) {
                    position.setRow(i);
                    position.setColumn(j);
                }
            }
        }

        return position;
    }

    private static Position findPositionOfWhitePawn(char[][] chessboard) {
        Position position = new Position();

            for (int j = 0; j < chessboard[0].length; j++) {
                if (chessboard[1][j] == Figures.PAWN_WHITE.getName() && chessboard[0][j] == Figures.FREE_SPACE.getName()) {
                    position.setRow(0);
                    position.setColumn(j);
                    chessboard[1][j] = '#';
                    chessboard[0][j] = 'P';

                }
            }

        return position;
    }


}

enum Figures {
    PAWN_WHITE('P'),
    KING_BLACK('k'),
    FREE_SPACE('#');

    private Character name;

    Figures(Character name) {
        this.name = name;
    }

    Character getName() {
        return name;
    }
}

class Position {
    int row;
    int column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Position{");
        sb.append("row=").append(row);
        sb.append(", column=").append(column);
        sb.append('}');
        return sb.toString();
    }
}

