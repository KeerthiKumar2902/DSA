class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subArrayCount(nums,goal)-subArrayCount(nums,goal-1);
    }

    public static int subArrayCount(int nums[],int goal){
        int n=nums.length;
        int l=0,r=0;
        int sum=0;
        int count=0;

        while(r<n){
            sum+=nums[r];

            while(sum>goal && l<=r){
                sum-=nums[l];
                l++;
            }
            count+=r-l+1;
            r++;
        }

        return count;
    }
}