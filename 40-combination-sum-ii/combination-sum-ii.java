class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        helperCombinationSum(candidates,target,result,0,ds);
        return result;
    }

    public void  helperCombinationSum(int []arr, int target,List<List<Integer>> result,int ind,List<Integer> ds ){

        if(target==0){
            result.add(new ArrayList<>(ds));
            return;
        }
            
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;

            ds.add(arr[i]);
            helperCombinationSum(arr,target-arr[i],result,i+1,ds);
            ds.remove(ds.size()-1);

        }
    }
}