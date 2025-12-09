class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();

        for(int i: asteroids){
            if(i>0) stack.push(i);

            else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(i))
                    stack.pop();

                if(!stack.isEmpty() && Math.abs(i)==stack.peek()){
                    stack.pop();
                }
                else if(stack.isEmpty() || stack.peek()<0){
                    stack.push(i);
                }
            }
        }

        int n=stack.size();
        int out[]=new int[n];
        for(int i=0;i<n;i++){
            int a=stack.pop();
            out[n-i-1]=a;
        }

        return out;
    }
}