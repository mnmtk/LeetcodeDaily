/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int dia;
    public int diameter(Node root) {
        if(root == null) return 0;

        height(root);

        return dia;
    }

    public int height(Node node) {

        if(node.children.size() == 0) return 0;

        int max1 = 0;
        int max2 = 0;


        for(Node child : node.children) {
            int parent = height(child) + 1;

            if(parent > max1 ) {
                max2 = max1; 
                max1 = parent;
            } else if (parent > max2) {
                max2 = parent;
            }

            this.dia = Math.max(this.dia, max1 + max2);
        }

        return max1;
    }
}