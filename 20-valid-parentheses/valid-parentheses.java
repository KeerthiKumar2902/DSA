class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack=new Stack<>();
        for(char i: s.toCharArray()){
            if( i=='{' || i=='(' || i=='['){
                stack.push(i);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    if( (stack.peek()=='(' && i==')') || (stack.peek()=='{' && i=='}') || (stack.peek()=='[' && i==']') ){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
                
            }
        }
        return stack.isEmpty();
    }
}