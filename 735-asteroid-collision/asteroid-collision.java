class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();

        for(int a:asteroids){
            if(a>0){
                stack.push(a);
            }
            else{
                while(!stack.isEmpty() && Math.abs(a)>stack.peek() && stack.peek()>0){
                    stack.pop();
                }

                if(stack.isEmpty() || stack.peek()<0) stack.push(a);

                else if(Math.abs(a)==stack.peek()){
                    stack.pop();
                }
            }
        }

        int result[]=new int[stack.size()];

        int i=0;
        for(int a:stack){
            result[i++]=a;
        }

        return result;
    }
}