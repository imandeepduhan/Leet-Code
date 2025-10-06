/*
Problem Name --> Monotonic Array
Problem Link --> https://leetcode.com/problems/monotonic-array/description/

Description : An array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. 
An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Example 1:

Input: nums = [1,2,2,3]
Output: true

Example 2:

Input: nums = [6,5,4,4]
Output: true

Example 3:

Input: nums = [1,3,2]
Output: false

My Approach : First, we determine the trend of the array by comparing the first two non-equal elements to see if it is increasing or decreasing. If all elements are equal, the array is trivially monotonic. Once the trend is identified, we iterate through the array to check whether it follows the increasing or decreasing order consistently. If any pair violates the trend, the function returns false; otherwise, it returns true.

Time Complexity: O(n) - iterate through array at most twice
Space Complexity: O(1) - only a few boolean variables and indices are used

*/
class Solution {
    public static boolean monotonicArray(int[] arr, boolean inc, boolean dec) {
        if (arr.length == 1) {
            return true;
        }
        if (inc == true) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
        }
        if (dec == true) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isMonotonic(int[] nums) {
         if (nums.length == 1) {
            return true;
        }

        boolean inc = false;
        boolean dec = false;
        int ind = 0;
        if (nums[ind] == nums[ind + 1]) {
            while ((inc != true || dec != true) && ind < nums.length - 1 ) {
                if (nums[ind] < nums[ind + 1]) {
                    inc = true;
                    break;
                }
                if (nums[ind] > nums[ind + 1]) {
                    dec = true;
                    break;
                }
                if(inc == false && dec == false && ind == nums.length - 1) {
                    return true;
                }
                ind++;
            }
        } else {
            if (nums[0] < nums[1]) {
                inc = true;
            }
            if (nums[0] > nums[1]) {
                dec = true;
            }
        }
        return monotonicArray(nums, inc, dec);
    }
}
