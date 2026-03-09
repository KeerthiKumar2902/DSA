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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy=new ListNode(0,head);
        ListNode prev=dummy;
        ListNode current=head;

        if(head==null || head.next==null || k==1) return head;


        while(true){

            ListNode check = prev;
            for(int i = 0; i < k; i++){
                check = check.next;
                if(check == null) return dummy.next;
            }

            current = prev.next;

            for(int i=0;i<k-1;i++){
                ListNode nodeToMove=current.next;
                current.next=nodeToMove.next;
                nodeToMove.next=prev.next;
                prev.next=nodeToMove;
            }

            prev=current;
        }

    }
}