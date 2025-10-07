class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r;
        int maxLength=0;
        int zeroes=0;

        if(k>=nums.length) return nums.length;

        for(r=0;r<nums.length;r++){
            if(nums[r]==0){
                zeroes++;
            }

            while(zeroes>k){
                if(nums[l]==0) zeroes--;
                l++; 
            }

            maxLength=Math.max(maxLength, r-l+1);
        }

        return maxLength;

    }
}