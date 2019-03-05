/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (25.38%)
 * Total Accepted:    377.6K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int minIndex = 0;
        int maxIndex = nums1.length;
        while (minIndex <= maxIndex) {
            int i = (minIndex + maxIndex) / 2;
            int j = (nums1.length + nums2.length + 1) / 2;
            System.out.println("i: " + i + " j: " + j);

            if (i < nums1.length && j > 0 && nums2[j-1] > nums1[i]){
                minIndex = i + 1;
            } else if (i > 0 && j < nums2.length && nums1[i-1] > nums2[j]) {
                maxIndex = i - 1;
            } else {
                if (i == 0)
                    return nums2[j-1];
                else if (j == 0)
                    return nums1[i-1];
                else {
                    return Math.max(nums1[i-1], nums2[j-1]);
                }
            }
        }

        return -1;
    }
}
