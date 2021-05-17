package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = true;
        for (int i = 0; i < board.length; i++){
            if (Win.rowCheck(i) || Win.columnCheck(i) != board[i][i]){
                   rsl = false;
            }
        }
        return rsl;
    }

    public static boolean rowCheck(int[][] board, int row) {
        boolean rsl = true;
        for (row = 0; row < board.length; row++){
            if(board[row][column] ==0){
                rsl = false;
                break;
            }
        }
        return rsl;
    }
    public static boolean columnCheck(int[][] board, int column) {
        boolean rsl = true;
        for (column = 0; column < board.length; column++){
            if(board[row][column] ==0){
                rsl = false;
                break;
            }
        }
        return rsl;
    }


}
