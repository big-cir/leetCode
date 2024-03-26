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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode subAnswer = answer;
        
        int preVal = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
        
            int sum = val1 + val2 + preVal;
            int nextVal = sum % 10;
            subAnswer.next = new ListNode(nextVal);
            subAnswer = subAnswer.next;
            
            preVal = sum / 10;
            if (preVal == 1) {
                subAnswer.next = new ListNode(preVal);
            }
        }
        
        return answer.next;
    }
}