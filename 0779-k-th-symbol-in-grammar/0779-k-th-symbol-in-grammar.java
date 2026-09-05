class Solution {
    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        } else if (k == 2) {
            return 1;
        }
        
        int mirrorFlips = 2;

        while (mirrorFlips * 2 < k) {
            mirrorFlips *= 2;
        }

        k -= mirrorFlips;
        
        return (kthGrammar(n, k) == 0 ? 1 : 0);
    }
}