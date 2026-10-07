/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // approach 2 - by creating set
        Set<ListNode> set = new HashSet<>();
        ListNode currA = headA;
        ListNode currB = headB;

        while(currA != null){
             set.add(currA);
             currA = currA.next;
            }
             while(currB != null){
                if(set.contains(currB)){
                    return currB;
               
                }
           currB = currB.next;
        }
        return null;
    }
}