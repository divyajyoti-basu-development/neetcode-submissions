class Solution {

    private boolean solve(char[][] board, boolean[][] visited, int row, int col, StringBuilder sb, String word) {
        if(sb.length() == word.length()) {
            if(sb.toString().equals(word)) {
                return true;
            }
            else {
                return false;
            }
        }
        if(row < 0 || col < 0 || row == board.length || col == board[0].length
        || visited[row][col]) {
            return false;
        }        
        sb.append(board[row][col]);
        visited[row][col] = true;
        if(solve(board, visited, row + 1, col, sb, word))
             return true;
        if(solve(board, visited, row - 1, col, sb, word))
            return true;
        if(solve(board, visited, row, col + 1, sb ,word))
            return true;
        if(solve(board, visited, row, col - 1, sb, word))
            return true;
        visited[row][col] = false;
        sb.deleteCharAt(sb.length() - 1);        
        return false;
    }
    public boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int row = 0 ; row < board.length ; row++) {
            for(int col = 0 ; col < board[0].length ; col++) {
                if(solve(board, visited, row, col, sb, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
