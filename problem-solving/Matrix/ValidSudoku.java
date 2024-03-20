package Matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        String[][]  board = new String[][] {
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        };
        List<String> rows = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        List<String> subSquart = new ArrayList<>();

        for(int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ".") continue;

            }
        }
    }
}
