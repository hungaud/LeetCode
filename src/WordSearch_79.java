import java.util.HashSet;

public class WordSearch_79 {

    public static void main(String[] args) {
        String s = "ABCCDE";
        char[][] board = new char[][] {{'A', 'B', 'C', 'D', 'E'}, {'S', 'F', 'C', 'B', 'A'}};
        System.out.println(exist(board, s));
    }

    public static boolean exist(char[][] board, String word) {
        //char startingLetter = word.charAt(0);
        char[] wordArr = word.toCharArray();
        boolean[][] seen = new boolean[board.length][board[0].length];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(dfs(board, wordArr, row, col, 0, seen)) {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean dfs(char[][] board, char[] word, int row, int col, int counter, boolean[][] seen) {
        if(counter == word.length) {
            return true;
        }

        // checks out of bounds, char doesnt match or already visited.
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word[counter] || seen[row][col]) {
            return false;
        }

        seen[row][col] = true;
        boolean found = dfs(board, word, row + 1, col, counter + 1, seen) ||
                dfs(board, word, row - 1, col, counter + 1, seen) ||
                dfs(board, word, row, col + 1, counter + 1, seen) ||
                dfs(board, word, row, col - 1, counter + 1, seen);
        seen[row][col] = false;
        return found;
    }
}
