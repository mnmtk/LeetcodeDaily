class Solution {
    public List<Integer> findAnagrams(String s, String p) {
    char[] sc = s.toCharArray();
    char[] pc = p.toCharArray();

    Arrays.sort(pc);
    List<Integer> res = new ArrayList<>();
    int k = p.length();
    for(int i = 0 ; i <= sc.length - k ; i++) {
        String str = s.substring(i, i+k);
        char sort[] = str.toCharArray();
        Arrays.sort(sort);
        if(Arrays.equals(pc, sort)) {
            res.add(i);
        }
    }
    return res; 
    }
}