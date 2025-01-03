
class Solution {
    public Node cloneGraph(Node node) {
        
        if (node == null) return null;
        Node ans = new Node(node.val);

        Map<Node, Node> map = new HashMap<>();
        map.put(node, ans);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node mein = queue.poll();
            List<Node> sathi = mein.neighbors;

            for(Node ek : sathi) {
                if(map.get(ek) != null) {
                    map.get(mein).neighbors.add(map.get(ek));
                } else {
                    Node copy = new Node(ek.val);
                    map.put(ek, copy);
                    map.get(mein).neighbors.add(map.get(ek));
                    queue.offer(ek);
                }
            }
        } 

        return ans;
    } 
}