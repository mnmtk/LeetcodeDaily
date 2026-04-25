/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        
        Node a = p.parent;
        Node b = q.parent;

        while(a!=b){

            a = a != null ? a.parent : q;
            b = b != null ? b.parent : p;
        }    

        return a;
        
        }
}