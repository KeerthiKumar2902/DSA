class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();

        for(char c : s.toCharArray()){
            if(c=='{' || c=='(' || c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                char a=stack.pop();
                if((c==')' && a=='(') || (c=='}' && a=='{') || (c==']' && a=='[')) continue;
                else return false;
            }
        }

        return stack.isEmpty();
    }
}