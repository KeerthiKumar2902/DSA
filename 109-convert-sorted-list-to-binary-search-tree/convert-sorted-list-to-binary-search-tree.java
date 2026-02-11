class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode slow = head, fast = head, prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // split list

        TreeNode root = new TreeNode(slow.val);// removed the left part or LS and right part of LS seaprately both are individual list now ... and the middle node which was in slow is a new TreeNode which acts as a root

        root.left  = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}