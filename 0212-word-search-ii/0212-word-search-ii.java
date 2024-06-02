
class Solution {
    class Trie {
        Trie[] next = new Trie[26];
        String word = null;
    }

    Set<String> ans = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = buildTrie(words);
        for(int i = 0; i< board.length ; i++) {
            for(int j = 0 ; j<board[0].length;j++) {
                dfs(board, i, j, trie);
            }
        }

        return new ArrayList<>(ans);
    }

    void dfs(char[][] board, int i, int j, Trie trie) {
        if(i <0 || j<0 || i >= board.length || j >=board[0].length || board[i][j] == '#'
        || trie.next[board[i][j] - 'a'] == null) {
            return;
        }

        if(trie.next[board[i][j] - 'a'].word != null) {
            ans.add(trie.next[board[i][j] - 'a'].word);
        }
        trie = trie.next[board[i][j] - 'a'];
        char c = board[i][j];
        board[i][j] = '#';
        
        dfs(board, i+1, j, trie);
        dfs(board, i, j+1, trie);
        dfs(board, i-1, j, trie);
        dfs(board, i, j-1, trie);

        board[i][j] = c;
    }

    Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for(String w : words) {
            Trie p = root;
            for(char c : w.toCharArray()) {
                if(p.next[c - 'a'] == null) {
                    p.next[c - 'a'] = new Trie();
                }
                p = p.next[c - 'a'];
            }
            p.word = w;
        }
        return root;
    }
}