/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new ListNodeComparator());

        for(ListNode listnode : lists) {
            if(listnode != null) {
            pq.offer(listnode);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(!pq.isEmpty()) {
            ListNode remove = pq.poll();
            head.next = remove;
            if(remove.next != null) {
                pq.offer(remove.next);
            }
            head = head.next;
        }

        return dummy.next;
    }
}