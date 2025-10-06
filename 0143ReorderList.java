/*
Problem Name --> Reorder List
Problem Link --> https://leetcode.com/problems/reorder-list/description/

Description --> You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:

● The number of nodes in the list is in the range [1, 5 * 104].
● 1 <= Node.val <= 1000.

My Approach : 
 1. Use slow & fast pointers to find the middle of the list
 2. Break the list into two halves
 3. Reverse the second half of the list
 4. Merge the two halves alternately (first node from left, then right)

 Time Complexity: O(n)
 Space Complexity: O(1)

*/

class Solution {
    public void reorderList(ListNode head) {
          if(head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while(fast != null && fast.next != null) {
            prev  = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = head;
        ListNode l2 = reverse(slow);
        merge(l1,l2);
    }

    private static ListNode reverse(ListNode l2) {
        if(l2 == null) {
            return null;
        }
        ListNode curr = l2;
        ListNode next = curr.next;
        ListNode prev = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private static void merge(ListNode l1 , ListNode l2) {
        while(l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = next;
        }
    }
}
