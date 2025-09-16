class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return subArrayCount(nums,k)-subArrayCount(nums,k-1);
    }

    public static int subArrayCount(int nums[],int goal){
        int n=nums.length;
        int l=0,r=0;
        int sum=0;
        int count=0;

        while(r<n){
            sum+=nums[r]%2;

            while(sum>goal && l<=r){
                sum-=nums[l]%2;
                l++;
            }
            count+=r-l+1;
            r++;
        }

        return count;
    }
}
