/*
Problem Name --> Sort List.
Problem Link --> https://leetcode.com/problems/sort-list/description/

Description --> Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

My Approach :
First, I created an ArrayList and a pointer (ptr) starting at the head of the linked list.
Then, I ran a while loop to traverse the list and added each element into the ArrayList.
After that, I sorted the ArrayList.
Next, I reset ptr back to the head and ran another loop to put the sorted values back into the linked list.
Finally, I returned the head.

Time Complexity = O(n log n)
Space Complexity = O(n)
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
       static ListNode sortList(ListNode head) {
    ArrayList<Integer> list = new ArrayList<>();
    ListNode ptr = head;
     
    while(ptr != null){
        list.add(ptr.val);
        ptr = ptr.next;
    }
    Collections.sort(list);
    ptr = head;
    for(int num : list){
       ptr.val = num;
        ptr = ptr.next;
    }  
    return head;
       }
}
