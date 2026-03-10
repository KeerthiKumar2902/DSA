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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int i=0;i<lists.length;i++){
            ListNode head=lists[i];

            while(head!=null){
                minHeap.add(head.val);
                head=head.next;
            }
        }

        ListNode dummy=new ListNode(0);
        ListNode prev=dummy;

        while(!minHeap.isEmpty()){
            ListNode node=new ListNode(minHeap.poll());
            prev.next=node;
            prev=prev.next;
        }


        return dummy.next;
    }
}