class Solution {
    public int maxDepthBST(int[] order) {
    TreeMap<Integer, Integer> m = new TreeMap<>();

    for (int i : order) {
        Map.Entry<Integer, Integer> l = m.floorEntry(i), r = m.ceilingEntry(i);
        
        m.put(i, 1 + Math.max(l == null ? 0 : l.getValue(), r == null ? 0 : r.getValue()));
    }
    return m.entrySet().stream().max((a, b) -> a.getValue().compareTo(b.getValue())).get().getValue();
}
}