class Solution {
    public boolean containsDuplicate(int[] nums) {
        //brute -> find for each O(n2)
        //kinda O(n)*O(1) -> but discuss how it can affect the hashset bla bla

        Set<Integer> hashSet = new HashSet<>();

        for(int num : nums) if(hashSet.add(num) == false) return true;
        
        return false;
    }
}