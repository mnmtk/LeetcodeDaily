class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates.length == 0) return new ArrayList<>();

        combinations(candidates, target, 0, new ArrayList<>());

        return ans;
    }

    public void combinations(int[] combinations, int target, int index, List<Integer> arrays) {

        if(target < 0 || index >= combinations.length) {
            return;
        }

        if(target == 0)  {
            ans.add(new ArrayList<>(arrays));
            return;
        }

        combinations(combinations, target, index+1, arrays);

        arrays.add(combinations[index]);
        combinations(combinations, target - combinations[index], index, arrays);

        arrays.remove(arrays.size() - 1);

    }
}