import java.util.Arrays;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (26.61%)
 * Total Accepted:    811.9K
 * Total Submissions: 2.9M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] indexCache = new int[127];
        Arrays.fill(indexCache, -1);
        
        int maxSubstringLength = 0;
        int currentStartIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (indexCache[chars[i]] >= currentStartIndex) {
                int substringLength = i - currentStartIndex;
                
                if (substringLength > maxSubstringLength) {
                    maxSubstringLength = substringLength;
                }

                currentStartIndex = indexCache[chars[i]] + 1;
            }

            indexCache[chars[i]] = i;
        }

        int lastSubstringLength = s.length() - currentStartIndex;
        if (lastSubstringLength > maxSubstringLength)
            maxSubstringLength = lastSubstringLength;

        return maxSubstringLength;
    }
}
