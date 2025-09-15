class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;

        int l=0,r=0,zero=0;
        int maxOnes=0;

        while(r<n){
            if(nums[r]==0) zero++;

            while(zero>k){
                if(nums[l]==0) zero--;
                l++;
            }

            if(zero<=k){
                int len=r-l+1;
                maxOnes=Math.max(maxOnes,len);
            }
            r++;
        }

        return maxOnes;
    }
}