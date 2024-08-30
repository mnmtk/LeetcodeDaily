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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int start, int end) {

        if(start == end) {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);

        return merge(left, right);
    }

    public ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode dt = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                dt.next = l1;
                l1 = l1.next;
            } else {
                dt.next = l2;
                l2 = l2.next;
            }
            dt = dt.next;
        }

        if(l1 != null) {
            dt.next = l1;
        } 

        if(l2 !=null ) {
            dt.next = l2;
        }

        return dummy.next;
    }
    
}