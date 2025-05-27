class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates == null || candidates.length == 0) return new ArrayList<>();

        combinations(candidates, 0, target, new ArrayList<>());
        return ans;  
    }

    public void combinations(int[] candidates, int index, int target, List<Integer> curr) {

        if(target < 0 || index >= candidates.length) {
            return;
        }

        if(target == 0) {
            ans.add(new ArrayList<>(curr)); //remember
            return;
        }

        curr.add(candidates[index]);
        combinations(candidates, index, target - candidates[index], curr);
        curr.remove(curr.size() - 1);
        combinations(candidates, index + 1, target, curr);
    }
}