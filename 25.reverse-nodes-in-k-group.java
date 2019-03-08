import java.util.Stack;

/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (35.42%)
 * Total Accepted:    169.6K
 * Total Submissions: 478.9K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes in the end should remain as it is.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * 
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;

        int count = 0;
        while (current != null) {
            if (count % k == 0)
                stack.push(current);
            
            current = current.next;
            count++;
        }

        ListNode first = count % k == 0 ? null : stack.pop();
        while (!stack.empty()) {
            current = stack.pop();
            ListNode nextFirst = reverseNextX(current, k);
            current.next = first;
            first = nextFirst;    
        }

        return first;
    }

    // FLIPS AND RETURNS FIRST ELEMENT IN NEW LIST
    private ListNode reverseNextX(ListNode head, int k) {
        ListNode current = head;
        ListNode previous = null;
        
        for (int i = 0; i < k && current != null; i++) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
    }
}