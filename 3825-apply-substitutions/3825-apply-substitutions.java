class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        
        HashMap<String, String> replacementMap = new HashMap<>();

        Map<String, List<String>> graph = new HashMap<>();

        Map<String, Integer> indegreeMap = new HashMap<>();

        for (List<String>replacement : replacements){
            String key = replacement.get(0);
            String value = replacement.get(1);

            int i = 0;
            graph.putIfAbsent(key, new ArrayList<>());
            indegreeMap.put(key, 0);
            while (i< value.length()){
                if (value.charAt(i) != '%'){
                    i += 1;
                }else{
                    i += 1;
                    String neighborKey = String.valueOf(value.charAt(i));
                    graph.putIfAbsent(neighborKey, new ArrayList<>());
                    graph.get(neighborKey).add(key);
                    indegreeMap.put(key, indegreeMap.get(key)+1);
                    i += 2;
                }
            }
            replacementMap.put(key, value);
        }

        Queue<String> q = new LinkedList<>();

        for (String key : indegreeMap.keySet()){
            if (indegreeMap.get(key) == 0){
                q.add(key);
            }
        }

        while (q.size() > 0){
            String curr = q.poll();

            StringBuilder sb = new StringBuilder();
            String currRes = replacementMap.get(curr);

            int i = 0;
            while (i < currRes.length()){
                if (currRes.charAt(i) != '%'){
                    sb.append(currRes.charAt(i));
                    i += 1;
                }else{
                    i += 1;
                    sb.append(replacementMap.get(String.valueOf(currRes.charAt(i))));
                    i += 2;
                }
            }
            replacementMap.put(curr, sb.toString());

            for (String neighbor : graph.get(curr)){
                indegreeMap.put(neighbor, indegreeMap.get(neighbor)-1);
                if (indegreeMap.get(neighbor) == 0){
                    q.add(neighbor);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;
        while (i< text.length()){
            if (text.charAt(i) != '%'){
                ans.append(text.charAt(i));
            }else{
                i+= 1;
                StringBuilder key = new StringBuilder();
                while (text.charAt(i) != '%'){
                    key.append(text.charAt(i));
                    i += 1;
                }
                ans.append(replacementMap.get(key.toString()));
            }
            i += 1;
        }

        return ans.toString();
    }
}