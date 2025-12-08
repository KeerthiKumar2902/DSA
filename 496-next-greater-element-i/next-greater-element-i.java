class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int []result= new int[nums2.length];

        for(int i=nums2.length-1;i>=0;i--){
            
            while(!stack.isEmpty() && nums2[i]>= stack.peek())  stack.pop();
            
            if(stack.isEmpty()){
                result[i]=-1;
            }
            else{
                result[i]=stack.peek();
            }

            stack.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    nums1[i]=result[j];
                    break;
                }
            }
        }
        return nums1;
    }
}