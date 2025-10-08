/*
Problem Name --> Middle of the Linked List
Problem Link --> https://leetcode.com/problems/middle-of-the-linked-list/description/

Description : Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

Example 1:

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

My Approach : To find the middle node of the linked list, I used the two-pointer (slow and fast) technique.
Both pointers start from the head of the list. The fast pointer moves two steps at a time, while the slow pointer moves one step at a time.
When the fast pointer reaches the end of the list (or becomes null), the slow pointer will be pointing exactly at the middle node.
This method ensures that the middle element is found in a single traversal of the list.

Time Complexity: O(n)
Space Complexity: O(1)

*/

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
    public ListNode middleNode(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;            
        }
        return slow;
    }
}
