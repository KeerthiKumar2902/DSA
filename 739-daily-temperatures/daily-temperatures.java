class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();

        int n=temperatures.length;
        int answer[]=new int[n];

        for(int i=temperatures.length-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }

            answer[i]=stack.isEmpty()? 0 : stack.peek()-i;
            stack.push(i);

        }

        return answer;
    }
}