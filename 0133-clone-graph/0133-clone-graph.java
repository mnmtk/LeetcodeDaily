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
    Map<Node, Node> seen = new HashMap<>();
    public Node cloneGraph(Node node) {

        if(node == null ) return node;
        if(seen.containsKey(node)) return seen.get(node);

        Node cloneGraph = new Node(node.val, new ArrayList<>());
        seen.put(node, cloneGraph);
        for(Node neighbor : node.neighbors) {
            cloneGraph.neighbors.add(cloneGraph(neighbor));
        }

        return cloneGraph;
        
    }
}