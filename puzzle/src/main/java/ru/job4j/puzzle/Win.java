package ru.job4j.puzzle;
/*Socoban*/

public class Win {


        public static boolean rowCheck(int[][] board, int row) {
            boolean result = true;
            for (int i = 0; i < board.length; i++) {
                if (board[row][i] != 1) {
                    result = false;
                    break;
                }
            }
            return result;
        }

        public static boolean columnCheck(int[][] board, int column) {
            boolean result = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][column] != 1) {
                    result = false;
                    break;
                }
            }
            return result;
        }

        public static boolean check(int[][] board) {
            boolean result = false;
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] == 1 && (rowCheck(board, i) || columnCheck(board, i))) {
                    result = true;
                    break;
                }
            }
            return result;
        }

}
