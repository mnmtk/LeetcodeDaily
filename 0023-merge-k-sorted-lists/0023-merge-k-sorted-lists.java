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

        if(lists.length == 0 || lists == null) 
        return null;
        
        return merge (lists, 0, lists.length - 1);
    }

    ListNode merge(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }

        //find middle
        int mid = start + (end-start)/2;
        ListNode left= merge(lists, start, mid);
        ListNode right = merge(lists, mid+1, end);

        return mergeList(left, right);
    }

    ListNode mergeList(ListNode left, ListNode right) {
        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }

        if(left.val < right.val) {
            left.next = mergeList(left.next, right);
            return left;
        } else {
            right.next = mergeList(left, right.next);
            return right;
        }
    }
}