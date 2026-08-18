class WordDictionary {

    private class TrieNode {
        TrieNode[] paths;

        boolean isEnd;

        TrieNode() {
            paths  = new TrieNode[26];
            isEnd = false;
        }

        TrieNode add(char ch) {
            if(paths[ch - 'a'] == null) {
                paths[ch - 'a'] = new TrieNode();                
            }
            return paths[ch - 'a'];
        }

        void setEnd() {
            isEnd = true;
        }

        boolean isEnd() {
            return isEnd;
        }

        TrieNode get(char ch) {
            return paths[ch - 'a']; 
        }

    }

    private TrieNode root;    
    
    public void insert(String word) {
        word = word.toLowerCase();
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            node = node.add(ch); 
        }
        node.setEnd();
    }

    private TrieNode prefixSearch(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            node = node.get(ch);
            if(node == null) {
                return null;
            }
        }
        return node;
    }  
    
    public boolean startsWith(String prefix) {
        TrieNode node = prefixSearch(prefix);
        return node != null;
    }

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        word = word.toLowerCase();
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            node = node.add(ch); 
        }
        node.setEnd();
    }

    private boolean recursiveSearch(String word, int index, TrieNode node) {
        if(node == null) {
            return false;
        }
        if(index == word.length() && node.isEnd()) {
            return true;
        }
        if(index == word.length()) {
            return false;
        }
        char ch = word.charAt(index);        
        if(ch == '.') {
            for(TrieNode path : node.paths) {
                if(recursiveSearch(word, index + 1, path)) {
                    return true;
                }
            }
            return false;
        }
        else if(node.get(ch) == null) {
            return false;
        }
        else {
            return recursiveSearch(word, index + 1, node.get(ch));
        }
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        return recursiveSearch(word, 0, node);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */