// Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
// Return 0 / 1 ( 0 for false, 1 for true ) for this problem

import java.util.List;

public class ValidSudoku {
    boolean[][] rowLog;
    boolean[][] colLog;
    boolean[][][] subBoxLog;

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isValidSudoku(final List<String> A) {
        rowLog = new boolean[9][10];
        colLog = new boolean[9][10];
        subBoxLog = new boolean[3][3][10];

        for(int row = 0; row < A.size(); row++) {

            for(int col = 0; col < A.get(row).length(); col++) {
                char x = A.get(row).charAt(col);

                if(x == '.') {
                    continue;
                }

                int value = Character.getNumericValue(x);

                if(isValid(row, col, value)) {
                    updateLogs(row, col, value);
                } else {
                    return 0;
                }

            }
        }

        return 1;
    }

    boolean isValid(int row, int col, int value) {
        if(rowLog[row][value]) {
            return false;
        }

        if(colLog[col][value]) {
            return false;
        }

        int subMatrixRow = getSubBoxIndex(row);
        int subMatrixCol = getSubBoxIndex(col);

        if(subBoxLog[subMatrixRow][subMatrixCol][value]) {
            return false;
        }

        return true;
    }

    void updateLogs(int row, int col, int value) {
        rowLog[row][value] = true;
        colLog[col][value] = true;
        subBoxLog[getSubBoxIndex(row)][getSubBoxIndex(col)][value] = true;
    }

    int getSubBoxIndex(int index) {
        return index / 3;
    }
}
