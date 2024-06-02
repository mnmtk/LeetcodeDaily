class TrieNode{
    TrieNode [] next = new TrieNode[26];
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
            if (p.next[c  - 'a'] == null) {
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
        if (index == word.length()) {
            return dict.word != null;
        }

        if(dict.next[word.charAt(index) - 'a'] != null) {
             System.out.print("here" + index + word.charAt(index));
            return searchHelper(word, index + 1, dict.next[word.charAt(index) - 'a']);
        } else {
             System.out.print("here" + word.charAt(index));
            return false;
        }
    }
    
    public boolean startsWith(String prefix) {
       return searchHelperWith(prefix, 0, root);
    }

    public boolean searchHelperWith(String word, int index, TrieNode dict) {
        if (index == word.length()) {
            return true;
        }

        if(dict.next[word.charAt(index) - 'a'] != null) {
           
            return searchHelperWith(word, index + 1, dict.next[word.charAt(index) - 'a']);
        } else {
            return false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */