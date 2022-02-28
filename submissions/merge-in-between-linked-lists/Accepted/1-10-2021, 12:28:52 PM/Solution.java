// https://leetcode.com/problems/merge-in-between-linked-lists

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pointA = list1; //Pointer of list 1
       
        for(int i = 1; i<a; i++) pointA = pointA.next; //Cycle till you are at A
        
       ListNode pointB = pointA.next; //new pointer to continue on to find point B starts where A left off
       
        for(int i = 0; i<(b-a) + 1; i++) pointB = pointB.next; // Cycle till you are at B
       
        pointA.next = list2; //point A now points to list 2.
       
        while(pointA.next != null) pointA = pointA.next; //get to the end of list 2 which has been added to end of original point A
       
        pointA.next = pointB; //Insert the remainder from point B
       
        return list1; //return the list
    }
}