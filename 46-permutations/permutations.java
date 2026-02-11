class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        permutation(nums,0,result);
        return result;
    }


    public static void permutation(int arr[],int fix,List<List<Integer>> result){
        if(fix==arr.length-1){
            List<Integer> temp=new ArrayList<>();

            for(int n: arr) temp.add(n);
            result.add(temp);
        }

        for(int i=fix;i<arr.length;i++){
            swap(arr,i,fix);
            permutation(arr, fix+1,result);
            swap(arr,i,fix);
        }
    }
    // Helper Permuation
    public static void swap(int arr[],int i,int fix){
        int temp=arr[i];
        arr[i]=arr[fix];
        arr[fix]=temp;
    }
}