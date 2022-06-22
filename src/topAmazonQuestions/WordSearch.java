package topAmazonQuestions;

public class WordSearch {

    public static void main(String[] args) {
        var obj = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String s = "ABCCEDFSA";
        System.out.println(obj.exist(board, s));
    }


    private char[][] board;
    private int ROWS, COLS;

    /*
    Time complexity: O(N . 3l)
    N: number of cells on the board
    L: length of the word to be match

    Space complexity: O(L) where L is the length of the word to be matched.
    Max length of the call stack would be length of the word.
     */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(this.backtrack(row, col, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row,
                              int col,
                              String word,
                              int index)
    {
        if(index >= word.length()) return true;
        //Check boundaries
        if(row < 0 || row >= ROWS
        || col < 0 || col >= COLS
        || this.board[row][col] != word.charAt(index)){
            return false;
        }
        boolean ret = false;
        this.board[row][col] = '#';
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for(int d = 0; d < 4; d++) {
            ret = this.backtrack(
                    row + rowOffsets[d],
                    col + colOffsets[d],
                    word,
                    index + 1
            );
            if(ret) break;
        }
        this.board[row][col] = word.charAt(index);
        return ret;
    }
}
