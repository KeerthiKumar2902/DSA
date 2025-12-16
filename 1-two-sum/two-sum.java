class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int out[]=new int[2];

        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];

            if(map.containsKey(complement)){
                out[0]=i;
                out[1]=map.get(complement);
                break;
                
            }
            else{
                map.put(nums[i],i);
            }
        }
        return out;
    }
}