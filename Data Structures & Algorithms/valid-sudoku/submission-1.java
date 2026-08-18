class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new Set[9];
        Set<Character>[] colSet = new Set[9];
        Set<Character>[] boxSet = new Set[9];
         for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }
        for(int row = 0 ; row < 9 ; row++) {
            for(int col = 0 ; col < 9 ; col++) { 
                char ch = board[row][col];
                if (ch == '.') continue; 
                //System.out.println("Row: " + row + " Col: " + col);              
                if(rowSet[row].contains(board[row][col])) {
                    return false;
                }
                if(colSet[col].contains(board[row][col])) {
                    return false;
                }
                int box = (row / 3) * 3 + col / 3;
                if(boxSet[box].contains(board[row][col])) {
                    return false;
                }
                rowSet[row].add(board[row][col]);
                colSet[col].add(board[row][col]);
                boxSet[box].add(board[row][col]);
            }
        }
        return true;
    }
}
