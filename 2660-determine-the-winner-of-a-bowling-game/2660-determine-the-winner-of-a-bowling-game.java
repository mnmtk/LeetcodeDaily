class Solution {
    public int isWinner(int[] player1, int[] player2) {

        int ten = 0;
        
        int player1score = 0;
        for(int score : player1) {
            player1score += score;
            if(ten-- > 0) {
                player1score += score;
            }

            if(score >= 10) {
            ten = 2;
            }
        }

        ten = 0;

        int player2score = 0;
        for(int score : player2) {
            player2score += score;
            if(ten-- > 0) {
                player2score += score;
            }

            if(score >= 10) {
            ten = 2;
            }
        }

        if(player1score == player2score) return 0;
        return player1score > player2score ? 1 : 2;
    }
}