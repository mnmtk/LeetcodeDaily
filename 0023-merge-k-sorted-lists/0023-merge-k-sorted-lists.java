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

        if(lists.length == 0 || lists == null) {
            return null;
        } 

        return mergeLists(lists, 0, lists.length - 1);
    }

    ListNode mergeLists(ListNode[] lists, int start,int end) {

        if(start == end) {
           return lists[start];
        }

        int mid = start + (end - start)/2;

        ListNode left = mergeLists(lists, start, mid);
        ListNode right = mergeLists(lists, mid+1, end);

        return merge(left, right);
    }

    ListNode merge(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        if(l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}