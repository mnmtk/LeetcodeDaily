class Trie {
    Trie[] next = new Trie[26];
    String word = null;
}
class WordDictionary {
    Trie dict;

    public WordDictionary() {
        dict = new Trie();
    }
    
    public void addWord(String word) {
        Trie t = dict;
        for(char c : word.toCharArray()) {
            if(t.next[c - 'a'] == null) {
                t.next[c - 'a'] = new Trie();
            }
            t = t.next[c - 'a'];
        }
        t.word = word;
    }
    
    public boolean search(String word) {
        return searchWithHelper(word, 0, dict);
    }

    boolean searchWithHelper(String word, int index, Trie dict) {
        if(index == word.length()) {
            return dict.word != null;
        }

        char c = word.charAt(index);
        if(c == '.') {
            for(Trie eachNext : dict.next) {
                if(eachNext != null && searchWithHelper(word, index+1, eachNext))
                return true;
            }
        return false;    
        } else {
            if(dict.next[c - 'a'] != null) {
                return searchWithHelper(word, index+1, dict.next[c - 'a']);
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */