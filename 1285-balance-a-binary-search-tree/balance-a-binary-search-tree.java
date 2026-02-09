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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();

        inorderArrayList(root,list);
        root= arraylistToBST(list,0,list.size()-1);
        return root;
    }

    //Inorder with arraylist output
    public static void inorderArrayList(TreeNode root,ArrayList<Integer> list){
        if(root==null) return ;

        inorderArrayList(root.left,list);
        list.add(root.val);
        inorderArrayList(root.right, list);
    }

    public static TreeNode arraylistToBST(ArrayList<Integer> list,int start,int end){
        if(start>end){
            return null;
        }

        int mid=(start+end)/2;
        
        TreeNode root=new TreeNode(list.get(mid));

        root.left=arraylistToBST(list, start, mid-1);
        root.right=arraylistToBST(list, mid+1, end);
        return root;
    }

}