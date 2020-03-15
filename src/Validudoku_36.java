import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Validudoku_36 {

    public static void main(String[] args) {
        String[][] board = new String[][] {{"5","3",".",".","7",".",".",".","."},
                                            {"6",".",".","1","9","5",".",".","."},
                                            {".","9","8",".",".",".",".","6","."},
                                            {"8",".",".",".","6",".",".",".","3"},
                                            {"4",".",".","8",".","3",".",".","1"},
                                            {"7",".",".",".","2",".",".",".","6"},
                                            {".","6",".",".",".",".","2","8","."},
                                            {".",".",".","4","1","9",".",".","5"},
                                            {".",".",".",".","8",".",".","7","9"}};
        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(String[][] board) {
        HashMap<String, Set<String>> map = new HashMap<>();
        HashMap<Integer, Set<String>> rows = new HashMap<>();
        HashMap<Integer, Set<String>> columns = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            columns.put(i, new HashSet<>());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String key = i + "" + j;
                map.put(key, new HashSet<>());
            }
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String c = board[row][col];
                if (c.equals(".")) continue;
                if (!rows.get(row).add(c) || !columns.get(col).add(c)) {
                    return false;
                }
                String key = (row / 3) + "" + (col / 3);
                if (!map.get(key).add(c))
                    return false;
            }
        }
        return true;
    }
}
