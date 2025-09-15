class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<>();

        if(nums.length==0) return result;
        int rangeStart=nums[0];
        int rangeEnd=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i-1]+1==nums[i]){
                rangeEnd=nums[i];
            }
            else{
                if(rangeStart!=rangeEnd){
                    String a = rangeStart + "->" + rangeEnd;
                    result.add(a);
                }
                else{
                    String a=""+rangeStart;
                    result.add(a);
                }
                rangeStart=nums[i];
                rangeEnd=nums[i];
            }
        }
        if(rangeStart != rangeEnd) {
            result.add(rangeStart + "->" + rangeEnd);
        } else {
            result.add(String.valueOf(rangeStart));
        }

        return result;
    }
}