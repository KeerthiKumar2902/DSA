class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        int l = 0, r = 0, niceCount = 0;
        int odd = 0;

        while (r < n) {
            if (nums[r] % 2 == 1) odd++;

            while (odd > k) {
                if (nums[l] % 2 == 1) odd--;
                l++;
            }

            if (odd == k) {
                int temp = l;
                // count how many leading evens we can skip
                while (temp <= r && nums[temp] % 2 == 0) {
                    temp++;
                }
                niceCount += (temp - l + 1);
            }
            r++;
        }
        return niceCount;
    }
}
