class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int targetGCD=numsDivide[0];

        for(int i=1;i<numsDivide.length;i++){
            targetGCD=gcd(numsDivide[i],targetGCD);
        }

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(targetGCD%nums[i]==0){
                return i;
            }
        }

        return -1;
    }

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}