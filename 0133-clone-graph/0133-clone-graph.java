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
    public Node cloneGraph(Node a) {
        if(a==null) return a;

        Node ans = new Node(a.val);

        Queue<Node> q1 = new LinkedList<>();
        q1.add(a);

        Queue<Node> q2 = new LinkedList<>();
        q2.add(ans);

        HashMap<Node, Node> hp = new HashMap<>();
        hp.put(a,ans);

        while(q1.size()!=0) {
            Node a1 = q1.remove();
            Node a2 = q2.remove();
            hp.put(a1, a2);
            List<Node> n = a1.neighbors;

            for(var x : n) {
                if(!hp.containsKey(x)) {
                    Node k = new Node(x.val);
                    hp.put(x,k);
                    a2.neighbors.add(k);
                    q1.add(x);
                    q2.add(k);
                } else {
                    a2.neighbors.add(hp.get(x));
                }
            }
        }
        return ans;
    }
}