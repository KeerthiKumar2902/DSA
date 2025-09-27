class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE; // important for negative values
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }

    private int maxPathSumHelper(TreeNode root, int[] maxSum) {
        if (root == null) return 0;

        int left = Math.max(0, maxPathSumHelper(root.left, maxSum));
        int right = Math.max(0, maxPathSumHelper(root.right, maxSum));

        // Update global maximum path sum
        maxSum[0] = Math.max(maxSum[0], left + right + root.val);

        // Return max path sum going through one side
        return root.val + Math.max(left, right);
    }
}
