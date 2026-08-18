class Solution {

    TrieNode root;    

    private class TrieNode {
        boolean isEnd;
        TrieNode[] nexts;

        TrieNode() {
            isEnd = false;
            nexts = new TrieNode[26];
        }
    }

    private void addWord(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()) {
            if(current.nexts[ch - 'a'] != null) {
                current = current.nexts[ch - 'a'];
            } else {
                current.nexts[ch - 'a'] = new TrieNode();
                current = current.nexts[ch - 'a'];
            }
        }
        current.isEnd = true;
    }

    private TrieNode searchWord(List<Character> word, int index, TrieNode trie) {
        return trie.nexts[word.get(index) - 'a'];
    }

    private void solve(List<Character> current, boolean[][] visited, Set<String> result
    , int row, int col, char[][] board, TrieNode trie) {     
        if(row < 0 || col < 0 || row == board.length
         || col == board[0].length || visited[row][col]) {
            return;
        }   
        visited[row][col] = true;
        current.add(board[row][col]);
        TrieNode returnedTrie = searchWord(current, current.size() - 1, trie);
        if(returnedTrie == null) {
            current.remove(current.size() - 1);
            visited[row][col] = false;
            return;
        }
        if(returnedTrie.isEnd) {
            StringBuilder sb = new StringBuilder();
            current.stream().forEach(sb :: append);
            result.add(sb.toString());
        }                
        solve(current, visited, result, row + 1, col, board, returnedTrie);
        solve(current, visited, result, row - 1, col, board, returnedTrie);
        solve(current, visited, result, row, col + 1, board, returnedTrie);
        solve(current, visited, result, row, col - 1, board, returnedTrie);
        current.remove(current.size() - 1);
        visited[row][col] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {        
        Set<String> result = new HashSet<>();
        root = new TrieNode();
        for(String word : words) {
            addWord(word);
        }
        for(int row = 0 ; row < board.length ; row++) {
            for(int col = 0 ; col < board[0].length ; col++) {
                solve(new ArrayList<>()
                , new boolean[board.length][board[0].length], result, row, col, board, root);
            }
        }        
        return new ArrayList<>(result);
    }
}
