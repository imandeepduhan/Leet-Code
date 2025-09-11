/*
Problem Name --> Sort Vowels in a String.
Problem Link --> https://leetcode.com/problems/sort-vowels-in-a-string/description/?envType=daily-question&envId=2025-09-11

Description --> Given a 0-indexed string s, permute s to get a new string t such that:

⬤ All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
⬤ The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
Return the resulting string.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.

Example 1:

Input: s = "lEetcOde"
Output: "lEOtcede"
Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places.

Example 2:

Input: s = "lYmpH"
Output: "lYmpH"
Explanation: There are no vowels in s (all characters in s are consonants), so we return "lYmpH".

My Approach:
Converted the string into a character array and created a list to collect all vowels from it.
While iterating, whenever a vowel was found I added it to the list and replaced its position
in the array with a placeholder ('1'). After the loop, I sorted the list of vowels.
Then I iterated through the array again, and wherever I found the placeholder,
I replaced it with the next vowel from the sorted list. Finally, I converted the array
back into a string and returned it.

Time Complexity: O(n log n)
Space Complexity: O(n).

*/

class Solution {
    public String sortVowels(String s) {
        List<Character> list = new ArrayList<>();
        String vowels = "aeiouAEIOU";
        char arr[] = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(vowels.indexOf(arr[i]) != -1) {
                list.add(arr[i]);
                arr[i] = '1';
            }
        }
        Collections.sort(list);
        int listIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '1' && listIndex < list.size()) {
                arr[i] = list.get(listIndex);
                listIndex++;
            }
        } 
        String str = new String(arr);  
        return str;
    }
}
