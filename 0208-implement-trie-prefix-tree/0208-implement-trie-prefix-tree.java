
class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word = null;
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode dict = root;
        for(char c : word.toCharArray()) {
            if (dict.next[c - 'a'] == null) {
                dict.next[c - 'a'] = new TrieNode();
            }
            
            dict = dict.next[c - 'a'];
        }

       dict.word = word;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    public boolean searchHelper(String word, int index,TrieNode trie) {
        if(index == word.length()) {
            return trie.word != null;
        }

        if(trie.next[word.charAt(index) - 'a'] != null) {
            return searchHelper(word, index+1, trie.next[word.charAt(index) - 'a']);
        } else {
            return false;
        }
    }


    public boolean searchHelper2(String word, int index, TrieNode trie) {
        if(index == word.length()) {
            return true;
        }

        if(trie.next[word.charAt(index) - 'a'] != null) {
            return searchHelper2(word, index+1, trie.next[word.charAt(index) - 'a']);
        } else {
            return false;
        }
    }
    
    
    public boolean startsWith(String prefix) {
         return searchHelper2(prefix, 0, root);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */