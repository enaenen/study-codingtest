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
    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null)
            return head;

        ListNode ptr = head;
        ListNode last = head;
        int size = 0;

        while (last.next != null){
            last = last.next;
            size++;
        }
        size++;

        k %= size;
        if (k == 0)  return head;
        int i = size - k;
        ptr = head;

 
        while (0 < --i){
            ptr = ptr.next;
        }
        last.next = head;
        head = ptr.next;
        ptr.next = null;

        return head;
    }
}