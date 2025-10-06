/*
Problem Name --> Binary Tree Preorder Traversal.
Problem Link --> https://leetcode.com/problems/binary-tree-preorder-traversal/description/

Description : Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]

Output: [1,2,3]

Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [1,2,4,5,6,7,3,8,9]

Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

Constraints:
● The number of nodes in the tree is in the range [0, 100].
● -100 <= Node.val <= 100.

My Approach:  
 Perform preorder traversal of binary tree recursively and store node values in a list.  
 1. If tree is empty, return empty list.  
 2. If node is leaf, add value and return.  
 3. Recursively visit root, then left, then right.
 
 Time Complexity: O(n)
 Space Complexity: O(n)

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Solution {
    public static void addInArray(TreeNode root , List<Integer> list) {
        if(root != null) {
            list.add(root.val);
            addInArray(root.left , list);
            addInArray(root.right , list);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        addInArray(root,list);
        return list;
    }
}
