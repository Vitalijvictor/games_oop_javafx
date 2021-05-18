package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = true;
        for (int i = 0; i < board.length; i++){
            if (board[i][i] == 1 && (Win.rowCheck(board, i) || Win.columnCheck(board, i))){
                   rsl = false;
                   break;
            }
        }
        return rsl;
    }

    public static boolean rowCheck(int[][] board, int row) {
        boolean rsl = true;
        for (int i = 0; i < board.length; i++){
            if(board[row][i] != 1){
                rsl = false;
                break;
            }
        }
        return rsl;
    }
    public static boolean columnCheck(int[][] board, int column) {
        boolean rsl = true;
        for (int i = 0; i < board.length; i++){
            if(board[column][i] != 1){
                rsl = false;
                break;
            }
        }
        return rsl;
    }


}
