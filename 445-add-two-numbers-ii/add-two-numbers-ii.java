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
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();

        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }

        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }


        ListNode head=null;
        int carry=0;

        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int sum=stack1.pop()+stack2.pop();

            int carryAddedSum= carry + sum;

            int NodeElement= carryAddedSum%10;
            carry=carryAddedSum/10;

            head=new ListNode(NodeElement,head);

        }

        while(!stack1.isEmpty()){
            int sum=stack1.pop();

            int carryAddedSum= carry + sum;

            int NodeElement= carryAddedSum%10;
            carry=carryAddedSum/10;

            head=new ListNode(NodeElement,head);
        }

        while(!stack2.isEmpty()){
            int sum=stack2.pop();

            int carryAddedSum= carry + sum;

            int NodeElement= carryAddedSum%10;
            carry=carryAddedSum/10;

            head=new ListNode(NodeElement,head);
        }

        if(carry==1){
            head=new ListNode(carry,head);
        }
        return head;
        
    }
}