class Solution {
    class Trie{
        Trie[] next = new Trie[26];
        String word = null;
    }

    Set<String> foundWords = new HashSet<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = buildTrie(words);
        for(int i = 0 ;i<board.length;i++) {
            for(int j = 0;j<board[0].length;j++) {
                dfs(board, i, j, trie);
            }
        }
        return new ArrayList<>(foundWords);
    }

    void dfs(char[][] grid, int i, int j, Trie trie) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '#' ||
        trie.next[grid[i][j] - 'a'] == null) return;

        if(trie.next[grid[i][j] - 'a'].word != null) {
            foundWords.add(trie.next[grid[i][j] - 'a'].word);
        }
        trie = trie.next[grid[i][j] - 'a'];
        char c = grid[i][j];
        grid[i][j] = '#';

        //dfs
        dfs(grid, i+1, j, trie);
        dfs(grid, i-1, j, trie);
        dfs(grid, i, j+1, trie);
        dfs(grid, i, j-1, trie);
        
        grid[i][j] = c;
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