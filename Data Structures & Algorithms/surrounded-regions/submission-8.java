class Solution {

    private void dfs(int row, int col, char[][] board, boolean[][] visited) {
        if(row < 0 || col < 0 || row == board.length || col == board[0].length
        || visited[row][col] || board[row][col] == 'X') {
            return;
        }
        visited[row][col] = true;
        board[row][col] = 'T';
        dfs(row + 1, col, board, visited);
        dfs(row - 1, col, board, visited);
        dfs(row, col + 1, board, visited);
        dfs(row, col - 1, board, visited);
    }

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int row = 0 ; row < board.length ; row++) {
            if(!visited[row][0] && board[row][0] == 'O') {
                dfs(row, 0, board, visited);
            }
            if(!visited[row][board[0].length - 1] && board[row][board[0].length - 1] == 'O') {
                dfs(row, board[0].length - 1, board, visited);
            }
        }
        for(int col = 0 ; col < board[0].length ; col++) {
            if(!visited[0][col] && board[0][col] == 'O') {
                dfs(0, col, board, visited);
            }
            if(!visited[board.length - 1][col] && board[board.length - 1][col] == 'O') {
                dfs(board.length - 1, col, board, visited);
            }
        }
        for(int row = 0 ; row < board.length ; row++) {
            for(int col = 0 ; col < board[0].length ; col++) {
                if(board[row][col] == 'T') {
                    board[row][col] = 'O';
                } else if(board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
    }

}
