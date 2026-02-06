class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int maxWindow=0;

        int i=0;
        
        for(int j=0;j<nums.length;j++){
            while(nums[j]>(long)nums[i]*k){
                i++;
            }

            maxWindow=Math.max(maxWindow,j-i+1);
        }

        return nums.length-maxWindow;

        
    }
}