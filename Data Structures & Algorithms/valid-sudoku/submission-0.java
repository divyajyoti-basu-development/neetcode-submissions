class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set[] rowsSetArr = new Set[9];
        Set[] colsSetArr = new Set[9];
        Set[] boxesSetArr = new Set[9];
        for(int index = 0 ; index < 9 ; index++) {
            rowsSetArr[index] = new HashSet<Character>();
            colsSetArr[index] = new HashSet<Character>();
            boxesSetArr[index] = new HashSet<Character>();
        }
        for(int row = 0 ; row < 9 ; row++) {
            for(int col = 0 ; col < 9 ; col++) {
                if(board[row][col] == '.') {
                    continue;
                }
                if(rowsSetArr[row].contains(board[row][col])) {
                    return false;
                }
                if(colsSetArr[col].contains(board[row][col])) {
                    return false;
                }                                 
                int boxCount = 3 * (row / 3) + col / 3; 
                if(boxesSetArr[boxCount].contains(board[row][col])) {
                    return false;
                }
                boxesSetArr[boxCount].add(board[row][col]);
                rowsSetArr[row].add(board[row][col]);
                colsSetArr[col].add(board[row][col]); 
                          
            }
        }
        return true;
    }
}
