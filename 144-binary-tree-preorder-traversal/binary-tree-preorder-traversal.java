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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        if(root==null) return list;

        while( !stack.isEmpty()){
            TreeNode peek=stack.pop();
            list.add(peek.val);

            if(peek.right!=null){
                stack.push(peek.right);
            }
            if(peek.left!=null){
                stack.push(peek.left);
            }
        }
        return list;
    }
}