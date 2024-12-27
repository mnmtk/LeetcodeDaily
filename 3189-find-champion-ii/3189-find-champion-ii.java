class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean found = false;
        int champ = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< n; i++) {
            map.put(i, 0);
        }

        for(int[] edge : edges) {
            map.put(edge[1], map.get(edge[1]) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if(entry.getValue() == 0) {
                if(found) {
                    return -1;
                } else {
                    champ = entry.getKey();
                    found = true;
                }
            }
            
        }

        return champ;
        
    }
}