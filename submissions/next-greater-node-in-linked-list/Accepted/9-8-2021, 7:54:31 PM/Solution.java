// https://leetcode.com/problems/next-greater-node-in-linked-list

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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> arr_list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr_list.add(curr.val);
            curr = curr.next;
        }
        
        int[] output = new int[arr_list.size()];
        Stack<Integer> st = new Stack();
        
        for (int i = 0; i < arr_list.size(); i++) {
            while(!st.isEmpty() && arr_list.get(st.peek()) < arr_list.get(i))
                output[st.pop()] = arr_list.get(i);
            
            st.push(i);
        }
        return output;
    }
}