class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[9];
        for (int i = 0; i < 9; i++) {
            candidates[i] = i + 1;
        }

        combinations(candidates, n, 0, new ArrayList<>(), k);
        return ans;
    }

    public void combinations(int[] candidates, int target, int index, List<Integer> current, int k) {

        if (target < 0 || k < 0) {
            return;
        }

        if (target == 0 && k == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (index >= candidates.length) {
            return;
        }

   
        combinations(candidates, target, index + 1, current, k);

        current.add(candidates[index]);
        combinations(candidates, target - candidates[index], index + 1, current, k - 1);
        current.remove(current.size() - 1);
    }
}
