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

// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode result = new ListNode();
//         ListNode current = result;
//         int index = 0;
//         int quote = 0;
        
//         while (l1 != null || l2 != null) {
//             if (index != 0) {
//                 current.next = new ListNode();
//                 current = current.next;
//             }
            
//             int val1 = 0;
//             if (l1 != null) {
//                 val1 = l1.val;
//                 l1 = l1.next;
//             }
            
//             int val2 = 0;
//             if (l2 != null) {
//                 val2 = l2.val;
//                 l2 = l2.next;
//             }
            
//             int value = val1 + val2+quote;
//             if (value >= 10) {
//                 quote = 1;
//                 value = value%10;
//             } else {
//                 quote = 0;
//             }
//             current.val = value;
//             index++;
//         }
        
//         if (quote == 1) {
//             current.next = new ListNode(1);
//         }
//         return result;
//     }
// }


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeResult = new ListNode();
        ListNode current = fakeResult;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            current.next = new ListNode();
            current = current.next;
            
            int val1 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            
            int val2 = 0;
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            
            int value = val1 + val2+carry;
            carry = value/10;
            value = value%10;
            current.val = value;
        }
        
        if (carry == 1) {
            current.next = new ListNode(1);
        }
        return fakeResult.next;
    }
}