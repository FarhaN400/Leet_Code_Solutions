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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // Pointer to the tail of the last reversed group
        ListNode groupPrev = dummy;
        while (true) {
            // Get the k-th node in the current group
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) break;
            // Store the next group’s head
            ListNode groupNext = kth.next;
            // Reverse the current k-group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            // Connect the previous group to the reversed group
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        // Return the new head
        return dummy.next;
    }
    public ListNode getKthNode(ListNode temp , int k){
        while(temp != null && k>0){
            temp = temp.next;
            k--;
        }
        return temp;
    }
}