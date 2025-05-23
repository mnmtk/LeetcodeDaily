class Solution {
  public int[] setIntersection(Set<Integer> set1, Set<Integer> set2) {
    int[] output = new int[set1.size()];
    int idx = 0;
    for (Integer s : set1) {
        if (set2.contains(s)){
            output[idx++] = s;
        } 
    }
    return Arrays.copyOf(output, idx);
  }
  
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    for (Integer n : nums1) {
        set1.add(n);
    } 
    Set<Integer> set2 = new HashSet<>();
    for (Integer n : nums2) {
        set2.add(n);
    }
    if (set1.size() < set2.size()){
        return setIntersection(set1, set2);
    } else {
        return setIntersection(set2, set1);
    } 
  }
}