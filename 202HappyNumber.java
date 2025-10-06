/*
Problem Name --> Happy Number
Problem Link --> https://leetcode.com/problems/happy-number/description/

Description : Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:

Input: n = 2
Output: false

My Approach : The given number is repeatedly replaced by the sum of the squares of its digits. If this process eventually results in 1, the number is called a happy number. The function uses recursion to continue this process until it either reaches 1 or 7 (indicating happiness) or a single-digit number other than these (indicating it’s not happy). The sum of squares is calculated by iterating through each digit and squaring it, then the function calls itself with the new sum until a result is found.

Time Complexity: O(log n)
Space Complexity: O(1)

*/

class Solution {
    public static boolean check(int n) {
        if(n == 1) {
            return true;
        }
        if(n == 7) {
            return true;
        }
        if(n < 10 && n > 0) {
            return false;
        }
        int sum = 0;
        while(n != 0) {
            int digit = n % 10;
            sum = sum + (int)Math.pow(digit, 2);
            n = n / 10;
        }
        n = sum;
        return check(n);
    }
    public boolean isHappy(int n) {
        return check(n);
    }
}
