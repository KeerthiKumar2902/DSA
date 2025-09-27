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

    public int diameterOfBinaryTree(TreeNode root) {
        int a[]=new int[1];
        maxDepth(root,a);
        return a[0];
    }
    private int maxDepth(TreeNode root,int d[]) {
        if (root == null) return 0;

        int left = maxDepth(root.left,d);
        int right = maxDepth(root.right,d);
        d[0]=Math.max(d[0],left+right);

        return 1 + Math.max(left, right);
    }
}
