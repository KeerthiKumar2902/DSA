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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;

        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else{
            // Case 1: When the Node is leaf Node -> No connection changes
            if(root.left==null && root.right==null){
                return null;
            }

            // Case 2: When either root.right or root.left is null
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }

            //Case 3: When the root right and left both exist
            TreeNode inorderSucessorNode = inorderSuccessor(root.right);
            root.val=inorderSucessorNode.val;
            root.right=deleteNode(root.right,inorderSucessorNode.val);

            
        }
        return root;
    }

    public static TreeNode inorderSuccessor(TreeNode root){
        while(root.left!=null) root=root.left;

        return root;
    }
}