class Solution {

   class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word = null;
    }
    TrieNode root = new TrieNode();
    Set<String> ans = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        
        buildTrie(words);


        for(int i = 0 ; i < board.length ; i ++) {
            for(int j = 0 ; j < board[0].length - 1; j ++) {
                dfs(board, i , j, root);
            }
        }


        return new ArrayList<>(ans);

    }


    public void dfs(char[][] grid, int i, int j, TrieNode trie) {

         if(i<0 || j< 0 

        || i >= grid.length 
        || j>= grid[0].length 

        || grid[i][j] == '#' 
        || trie.next[grid[i][j] - 'a'] == null) return;

        if (trie.next[grid[i][j] - 'a'].word != null) {
          ans.add(trie.next[grid[i][j] - 'a'].word); //word.   
        }
        trie = trie.next[grid[i][j] - 'a']; //next letter.


        char c = grid[i][j];

        grid[i][j] = '#'; // start the visit
        dfs(grid, i+1, j, trie);
        dfs(grid, i, j+1, trie);
        dfs(grid, i-1, j, trie);
        dfs(grid, i, j-1, trie);
        grid[i][j] = c; // visit  complete

    }

    void buildTrie(String[] words) {
        for(String word : words) {
            addToTrie(word, root);
        }
    }

    void addToTrie(String word, TrieNode dict) {
        TrieNode p = dict;
        for(char c : word.toCharArray()) {
            if(p.next[c - 'a'] == null) {
                p.next[c - 'a'] = new TrieNode();
            }
            p = p.next[c - 'a'];
        }
        p.word = word;
    }
}