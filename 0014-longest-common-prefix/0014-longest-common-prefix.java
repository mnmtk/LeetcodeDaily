class Solution {
    public String longestCommonPrefix( String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        Trie trie = new Trie();
        for (int i = 1; i < strs.length; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(strs[0]);
    }
}

class TrieNode {
    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    // number of children non null links
    private int size;

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
        size++;
    }

    public int getLinks() {
        return size;
    }

    // assume methods containsKey, isEnd, get, put are implemented as it is described
    // in  https://leetcode.com/articles/implement-trie-prefix-tree/)
    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // assume methods insert, search, searchPrefix are implemented as it is described
    // in  https://leetcode.com/articles/implement-trie-prefix-tree/)
    public String searchLongestPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (
                node.containsKey(curLetter) &&
                node.getLinks() == 1 &&
                !node.isEnd()
            ) {
                prefix.append(curLetter);
                node = node.get(curLetter);
            } else return prefix.toString();
        }
        return prefix.toString();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
}