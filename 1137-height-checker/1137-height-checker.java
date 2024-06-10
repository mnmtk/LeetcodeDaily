class Solution {
    public int heightChecker(int[] heights) {
        ArrayList<Integer> expected = new ArrayList<>();
        for(int num : heights) {
            expected.add(num);
        }
        Collections.sort(expected);
        int count = 0;
        for(int i = 0; i < heights.length ;i++) {
            if(heights[i] != expected.get(i)) {
                count++;
            }
        }

        return count;
    }
}