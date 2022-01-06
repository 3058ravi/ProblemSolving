/*
* Search a word in given m*n matrix
* */

package backtracking;

public class FindWordInMatrix {

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        System.out.println(exist1(board, word));
    }

    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if ((board[i][j] == word.charAt(0)) && findWord(board, i, j, 0, word))
                    return true;
        return false;

    }

    public static boolean findWord(char[][] board, int i, int j, int count, String word) {
        if (count == word.length())
            return true;

        if (i < 0 || i == board.length || j < 0 || j == board[0].length || word.charAt(count) != board[i][j])
            return false;

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean found = findWord(board, i + 1, j, count + 1, word) || findWord(board, i, j + 1, count + 1, word) || findWord(board, i - 1, j, count + 1, word) || findWord(board, i, j - 1, count + 1, word);
        board[i][j] = temp;
        return found;

    }


    public static boolean exist1(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        int[] moveX = {0, 0, 1, -1};
        int[] moveY = {1, -1, 0, 0};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (exist(board, word, i, j, 1, moveX, moveY, m, n, visited))
                        return true;

                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, String word, int x, int y, int k, int[] moveX, int[] moveY, int m, int n, boolean[][] visited) {
        if (k >= word.length())
            return true;
        for (int i = 0; i < 4; i++) {
            if (isSafe(board, word, x, y, moveX[i], moveY[i], m, n, visited)) {
                if (board[(x + moveX[i])][(y + moveY[i])] == word.charAt(k)) {
                    visited[(x + moveX[i])][(y + moveY[i])] = true;
                    if( exist(board, word, x + moveX[i], y + moveY[i], k + 1, moveX, moveY, m, n, visited))
                        return true;
                }
                visited[(x + moveX[i])][(y + moveY[i])] = false;
            }


        }
        return false;
    }

    public static boolean isSafe(char[][] board, String word, int x, int y, int moveX, int moveY, int m, int n, boolean[][] visited) {
        return (x + moveX >= 0 && x + moveX < m && y + moveY >= 0 && y + moveY < n && !visited[(x + moveX)][(y + moveY)]);
    }

}
