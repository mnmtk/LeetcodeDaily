/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> visited = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    public Node cloneGraph(Node node) {

        if(node == null) return node;

        queue.add(node);
        visited.put(node, new Node(node.val , new ArrayList<>()));

        while(!queue.isEmpty()) {

            Node n = queue.poll();

            for(Node ne : n.neighbors) {
                if(!visited.containsKey(ne)) {
                    visited.put(ne, new Node(ne.val, new ArrayList<>()));
                    queue.add(ne);
                }

                visited.get(n).neighbors.add(visited.get(ne));
            }
        }

        return visited.get(node);
        
    }
}