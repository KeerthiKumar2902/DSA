class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = nums[0];
        int maxSum = nums[0], curMax = nums[0];
        int minSum = nums[0], curMin = nums[0];

        for(int i = 1; i < nums.length; i++){
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(nums[i], curMin + nums[i]);
            minSum = Math.min(minSum, curMin);

            total += nums[i];
        }

        // If all numbers are negative, maxSum is the answer
        if(maxSum < 0) return maxSum;

        return Math.max(maxSum, total - minSum);
    }
}
