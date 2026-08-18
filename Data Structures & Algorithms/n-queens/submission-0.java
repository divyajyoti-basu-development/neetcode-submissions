class Solution {

    private void solve(List<List<String>> result
    , char[][] board, int level, int n) {
        if(level == n) {
            List<String> current = new ArrayList<>();
            Arrays.stream(board).forEach(arr -> {
                StringBuilder sb = new StringBuilder();
                for(char ch : arr) {
                    sb.append(ch);
                }
                current.add(sb.toString());
            });
            result.add(current);
            return;
        }
        for(int col  = 0 ; col < n ; col++) {
            if(isValid(board, col, level, n)) {
                board[level][col] = 'Q';
                solve(result, board, level + 1, n);
                board[level][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int col, int level, int n) {
        int checkCol = col, checkLevel = level;
        level = checkLevel - 1;
        while(level >= 0) {
            if(board[level][col] == 'Q') {
                return false;
            }
            level--;
        }
        level = checkLevel - 1;
        col = checkCol - 1;        
        while(col >= 0 && level >= 0) {
            if(board[level][col] == 'Q') {
                return false;
            }
            col--;
            level--;
        }
        level = checkLevel - 1;;
        col = checkCol + 1; 
        while(col < n && level >= 0) {
            if(board[level][col] == 'Q') {
                return false;
            }
            col++;
            level--;
        } 
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();        
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        solve(result, board, 0, n);
        return result;
    }
}
