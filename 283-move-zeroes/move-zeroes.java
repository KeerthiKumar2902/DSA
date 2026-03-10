class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // If we find a non-zero number, swap it with the 'left' pointer
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                // Move 'left' forward to point to the next available spot
                left++;
            }
        }
    }
}