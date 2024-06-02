class TrieNode{
    TrieNode[] next = new TrieNode[26];
    String word = null;
}

class Trie {
    TrieNode root;
    public Trie() {
       root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()) {
            if(p.next[c - 'a'] == null) {
                p.next[c - 'a'] = new TrieNode();
            }
            p = p.next[c - 'a'];
        }
        p.word = word;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    public boolean searchHelper(String word, int index, TrieNode dict) {
        if(index == word.length()) return dict.word != null;

        char c = word.charAt(index);    
        return dict.next[c - 'a'] != null 
        ? searchHelper(word, index +1, dict.next[c - 'a'])
        : false;
    }
    
    public boolean startsWith(String prefix) {
      return searchHelperWith(prefix, 0, root);
    }


    public boolean searchHelperWith(String word, int index, TrieNode dict) {
        if(index == word.length()) return true;

        char c = word.charAt(index);    
        return dict.next[c - 'a'] != null 
        ? searchHelperWith(word, index +1, dict.next[c - 'a'])
        : false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */