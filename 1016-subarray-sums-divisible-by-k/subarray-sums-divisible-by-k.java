class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int count=0;
        int prefixSum=0;

        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];

            int mod = ((prefixSum % k) + k) % k;

            if(map.containsKey(mod)){
                count+=map.get(mod);
            }

            map.put(mod,map.getOrDefault(mod,0)+1);
        }


        return count;
    }
}