class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

    
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);

        
        while (Q.size() > 0) {
           
            int size = Q.size();

            
            for (int i = 0; i < size; i++) {
               
                Node node = Q.poll();

                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only
                // don't establish next pointers beyond the end
                // of a level
                
                if (i < size - 1) {
                    node.next = Q.peek();
                }

                // Add the children, if any, to the back of
                // the queue
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }

        // Since the tree has now been modified, return the root node
        return root;
    }
}