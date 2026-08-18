class Solution {

    private boolean recursiveSearch(char[][] board, int row, int col, boolean[][] visited, StringBuilder sb, String word) {
        if(row == board.length || col == board[0].length || row < 0 || col < 0) {
            return false;
        }
        if(visited[row][col]) {
            return false;
        }
        sb.append(board[row][col]);
        if(sb.toString().equals(word)) {
            return true;
        }
        visited[row][col] = true;
        if(recursiveSearch(board, row + 1, col, visited, sb, word)
        || recursiveSearch(board, row - 1, col, visited, sb, word)
        || recursiveSearch(board, row, col + 1, visited, sb, word)
        || recursiveSearch(board, row, col - 1, visited, sb, word)) {
            return true;
        }
        visited[row][col] = false;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int row = 0 ; row < board.length ; row++) {
            for(int col = 0 ; col < board[0].length ; col++) {
                visited[row][col] = false;
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int row = 0 ; row < board.length ; row++) {
            for(int col = 0 ; col < board[0].length ; col++) {
                if(recursiveSearch(board, row, col, visited, sb, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}