class Solution {
    List<List<Integer>> v = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        combine(candidates, 0, target, new ArrayList<>());
        return v;
    }

    public void combine(int[] candidates, int index, int target, List<Integer> list) {


        if(target < 0 || index >= candidates.length) {
            return;
        }

        if(target == 0) {
            v.add(new ArrayList<>(list));
            return;
        }


        //dont include
        combine(candidates, index + 1, target, list);

         //include
        list.add(candidates[index]);
        combine(candidates, index, target - candidates[index], list);
        list.remove(list.size() - 1);
    }

}