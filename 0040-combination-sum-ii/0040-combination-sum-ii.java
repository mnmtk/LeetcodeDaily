class Solution {
    // The solution set must not contain duplicate combinations.
    HashSet<List<Integer>> ans = new HashSet<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return new ArrayList<>();
        
        Arrays.sort(candidates);
        combinations(candidates, target, 0, new ArrayList<>());
        
        return new ArrayList<>(ans);
    }

    public void combinations(int[] candidates, int target, int index, List<Integer> arrays) {
        if (target == 0) {
            ans.add(new ArrayList<>(arrays));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            //Each number in candidates may only be used once in the combination.
            if (i > index && candidates[i] == candidates[i - 1]) continue;  // skip duplicates
            if (candidates[i] > target) break;  // prune
            
            arrays.add(candidates[i]);
            combinations(candidates, target - candidates[i], i + 1, arrays);
            arrays.remove(arrays.size() - 1);
        }
    }
}
