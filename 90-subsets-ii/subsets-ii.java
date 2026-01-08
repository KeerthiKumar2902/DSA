class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        helper(result,current,nums,0,nums.length);
        return result;
    }

    public static void helper(List<List<Integer>> result,List<Integer> current,int nums[],int ind,int n){

        result.add(new ArrayList<>(current));
        for(int i=ind;i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1]) continue;
            current.add(nums[i]);
            helper(result,current,nums,i+1,n);
            current.remove(current.size()-1);
        }
    }
}