class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // prefix sum 0 seen once

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            // If prefixSum - goal was seen before, those subarrays end here
            if (map.containsKey(prefixSum - goal)) {
                count += map.get(prefixSum - goal);
            }

            // Store/update prefixSum frequency
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
