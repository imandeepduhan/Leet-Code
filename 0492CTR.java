/*
Problem Name --> Construct the Rectangle.
Problem Link --> https://leetcode.com/problems/construct-the-rectangle/description/

Description --> A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

1.The area of the rectangular web page you designed must equal to the given target area.
2.The width W should not be larger than the length L, which means L >= W.
3.The difference between length L and width W should be as small as possible.
Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.

Example 1:

Input: area = 4
Output: [2,2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.

Example 2:

Input: area = 37
Output: [37,1]

Example 3:

Input: area = 122122
Output: [427,286]

My Approach : I created an array of size 2 to return, initialized a variable max and also length and breadth. Then I ran a loop from 1 to √area, since a factor is always less than or equal to the area. Inside the loop, I checked if the area is completely divisible by i. If yes, I calculated a variable diff to check the difference between the pair, then assigned length = area / i and breadth = i, updated max = diff. Finally, I set arr[0] = length and arr[1] = breadth, and returned the array.

Time Complexity: O(√area).
Space Complexity: O(1).

*/

class Solution {
    public int[] constructRectangle(int area) {
        int[] arr = new int[2];
        int max = 10000000;
        int length = 1;
        int breadth = 1;
        for(int i = 1; i <= Math.sqrt(area); i++) {
            if(area % i == 0) {
                int diff = (area / i) - i;               
                 if(diff < max) {
                     length = (area / i);
                     breadth = i;
                    max = diff;
                }
            }
        }
        arr[0] = length;
        arr[1] = breadth;
        return arr;
    }
} 
