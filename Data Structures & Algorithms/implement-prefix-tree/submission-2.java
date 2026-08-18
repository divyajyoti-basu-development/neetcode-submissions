class PrefixTree {

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

    public PrefixTree() {
        root = new TrieNode();
    }
    
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
    
    public boolean search(String word) {
        TrieNode node = prefixSearch(word);
        return node != null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = prefixSearch(prefix);
        return node != null;
    }
}
