class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(char c : num.toCharArray()){

            while(!stack.isEmpty() && k>0 && stack.peek()-'0'> c-'0' ){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder result= new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        while(result.length()>0 && result.charAt(result.length()-1)=='0'){
            result.deleteCharAt(result.length()-1);
        }

        String a=result.reverse().toString();
        return a.length()==0 ? "0" : a;  
    }
}