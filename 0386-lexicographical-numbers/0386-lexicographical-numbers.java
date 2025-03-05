class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexiNums = new ArrayList<>();

        for(int start = 1; start <= 9; ++start) {
            generateLexicalNumbers(start, n, lexiNums);
        }

        return lexiNums;
    }

    private void generateLexicalNumbers(int currentNumber, int limit, List<Integer> result) {
        if(currentNumber > limit) return;

        result.add(currentNumber);

        for(int nextDigit = 0; nextDigit <= 9; ++nextDigit) {
            int nextNumber = currentNumber*10 + nextDigit;
            if (nextNumber <= limit) {
                generateLexicalNumbers(nextNumber, limit, result);
            } else {
                break; 
            }
        }
    }
}