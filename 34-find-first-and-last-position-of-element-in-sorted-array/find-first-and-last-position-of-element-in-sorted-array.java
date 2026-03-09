class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int first=lowerBound(nums,target);
        if( first<nums.length  && nums[first]==target ){
            int last=upperBound(nums,target);
            return new int[]{first,last-1};
        }
        return new int[]{-1,-1};
    }

    public static int lowerBound(int arr[],int bound){
        int low=0;
        int high=arr.length-1;
        int ans=high+1;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=bound){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static int upperBound(int arr[],int bound){
        int low=0;
        int high=arr.length-1;
        int ans=high+1;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>bound){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

}