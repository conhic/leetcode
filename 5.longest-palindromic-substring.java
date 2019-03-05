/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.41%)
 * Total Accepted:    481.2K
 * Total Submissions: 1.8M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String current = getLongestPalindromeFromIndex(s, i, i);
            
            if (current.length() > result.length())
                result = current;
        }

        
        for (int i = 0; i < s.length() - 1; i++) {
            String current = getLongestPalindromeFromIndex(s, i, i+1);
            
            if (current.length() > result.length())
                result = current;
        }

        return result;
    }
    
    public String getLongestPalindromeFromIndex(String s, int start, int end) {
        if (s.charAt(start--) != s.charAt(end++))
            return "";

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        };
        return s.substring(start + 1, end);
    }
}
