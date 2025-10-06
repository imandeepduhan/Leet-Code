/*
Problem Name --> Linked List Cycle II
Problem Link --> https://leetcode.com/problems/linked-list-cycle-ii/description/

Description : Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
Do not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

My Approach : First, I checked if the head is null or head.next is null, in which case there is no cycle and returned null. Then I initialized two pointers, slow and fast, starting at head. I ran a loop moving slow by one step and fast by two steps, and checked if they meet. If they meet, it means a cycle exists; otherwise, returned null. After detecting the cycle, I reset slow to head and moved both slow and fast one step at a time until they meet again. The meeting point is the start of the cycle, which I returned.

Time Complexity: O(n).
Space Complexity: O(1).

*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                break;
            }
        }
         if(slow != fast) {
            return null;
         }
        slow = head;
         while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
         return slow;
    }
}
