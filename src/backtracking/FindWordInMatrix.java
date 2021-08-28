package backtracking;

public class FindWordInMatrix {

    public static void main(String[] args){
        char[][] board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
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

}
