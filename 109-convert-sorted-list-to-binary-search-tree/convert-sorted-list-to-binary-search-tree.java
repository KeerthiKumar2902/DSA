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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        List<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }

        int nums[]=new int[list.size()];

        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }

        return arrayToBST(nums,0,nums.length-1);
    }
    public static TreeNode arrayToBST(int nums[],int start,int end){
        if(start>end){
            return null;
        }

        int mid=(start+end)/2;
        
        TreeNode root=new TreeNode(nums[mid]);

        root.left=arrayToBST(nums, start, mid-1);
        root.right=arrayToBST(nums, mid+1, end);
        return root;
    }
}