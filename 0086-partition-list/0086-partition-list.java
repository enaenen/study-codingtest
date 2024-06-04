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

    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode newHead = left;
        ListNode middle = right;

        while (cur != null){
            if (cur.val < x){
                left.next = new ListNode(cur.val);
                left = left.next;
            }
            else {
                right.next = new ListNode(cur.val);
                right = right.next;
            }
            cur = cur.next;
        }
        left.next = middle.next;
        return newHead.next;
    }
}