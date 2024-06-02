class Solution {
    class Trie{
        Trie[] next = new Trie[26];
        String word = null;
    }
    Set<String> ans = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
       Trie trie = buildTrie(words);   

       int row = board.length;
       int col = board[0].length;

       for(int i = 0 ; i< row ;i++) {
        for(int j = 0 ; j< col ; j++) {
            dfs(trie, i, j, board);
        }
       } 
    return new ArrayList<>(ans);

    }

    void dfs (Trie trie, int i, int j, char[][] board) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length 
        || board[i][j] == '#' || trie.next[board[i][j] - 'a'] == null) {
            return;
        }

        if(trie.next[board[i][j] - 'a'].word != null){
            ans.add(trie.next[board[i][j] - 'a'].word);
        }
        trie = trie.next[board[i][j] - 'a'];
        char c = board[i][j];
        board[i][j] = '#';

        //dfs
        dfs(trie, i-1, j, board);
        dfs( trie, i+1, j,  board);
        dfs( trie, i, j-1,  board);
        dfs( trie, i, j+1,  board);
    
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