class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        helperCombinationSum(candidates,target,result,0,ds);
        return result;
    }

    public void  helperCombinationSum(int []candidates, int target,List<List<Integer>> result,int ind,List<Integer> ds ){

        if(ind==candidates.length){
            if(target==0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[ind]<=target){
            ds.add(candidates[ind]);
            helperCombinationSum(candidates,target-candidates[ind],result,ind,ds);
            ds.remove(ds.size()-1);
        }

        helperCombinationSum(candidates,target,result,ind+1,ds);
    }
}