class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack= new Stack<>();

        int result[]=new int[temp.length];

        for(int i=temp.length-1;i>=0;i--){
            while(!stack.isEmpty() && temp[i]>=temp[stack.peek()]){
                stack.pop();
            }

            result[i]= stack.isEmpty() ? 0: stack.peek()-i;

            stack.push(i);
        }

        return result;
    }
}