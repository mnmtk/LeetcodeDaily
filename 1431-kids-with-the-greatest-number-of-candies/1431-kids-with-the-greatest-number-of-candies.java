class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int max = -1;

        List<Boolean> answer = new ArrayList<>();
        for(int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        for(int i = 0; i < candies.length; i++) {
            candies[i] = max - candies[i];
            answer.add(extraCandies >= candies[i] ? true : false);
        }
        
        return answer;
    }
}