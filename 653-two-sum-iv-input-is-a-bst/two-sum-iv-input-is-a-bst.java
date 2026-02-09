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
    public boolean findTarget(TreeNode root, int k) {
        
        ArrayList<Integer> list=new ArrayList<>();
        inorderArrayList(root,list);

        int i=0;
        int j=list.size()-1;
        while(i<j){

            int a=list.get(i);
            int b=list.get(j);
            if(a+b==k){
                return true;
            }
            else if(a+b<k)
                i++;
            else
                j--;
        }
        return false;
    }

    public static void inorderArrayList(TreeNode root,ArrayList<Integer> list){
        if(root==null) return ;

        inorderArrayList(root.left,list);
        list.add(root.val);
        inorderArrayList(root.right, list);
    }
}