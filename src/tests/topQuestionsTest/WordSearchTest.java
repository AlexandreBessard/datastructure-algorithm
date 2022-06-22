package tests.topQuestionsTest;

public class WordSearchTest {

    public static void main(String[] args) {
        var obj = new WordSearchTest();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String s = "ABCCEDFSA";
        System.out.println(obj.exist(board, s));
    }

    int ROWS, COLS;
    char[][] board;
    final int[] rowOffsets = {0,1,0,-1};
    final int[] colOffsets = {1,0,-1,0};

    public boolean exist(char[][] board, String s) {
        if(s == null || s.length() == 0) return false;
        ROWS = board.length;
        COLS = board[0].length;
        this.board = board;
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                return backtracking(row, col, 0, s);
            }
        }
        return false;
    }

    private boolean backtracking(int row,
                                 int col,
                                 int index,
                                 String s)
    {
        if(index == s.length()) return true;
        if(row < 0 || row >= ROWS
        || col < 0 || col >= COLS
        || board[row][col] != s.charAt(index))
        {
            return false;
        }
        board[row][col] = '#';
        boolean result = false;
        for(int d = 0; d < 4; d++) {
            result = backtracking(
                    row + rowOffsets[d],
                    col + colOffsets[d],
                    index + 1,
                    s);
            if(result) break;
        }
        board[row][col] = s.charAt(index);
        return result;
    }


}
