class Solution {
    List<List<Integer>> v = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationK(candidates, target, 0,new ArrayList<>());
        return v;
    }


    void combinationK(int[] candidates, int target, int index, List<Integer> list) {

        if(target < 0 || index >= candidates.length) return;

        if(target == 0) {
            v.add(new ArrayList<>(list));
            return;
        }

        //dont include current
        combinationK(candidates, target, index+1, list);


        // include current
        list.add(candidates[index]);
        combinationK(candidates, target - candidates[index], index, list);
        list.remove(list.size() - 1);

    }


}