class Solution {
    public int calculate(String s) {
        int n=s.length();

        int sum=0;
        int num=0;
        int sign=1;
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++){
            char c=s.charAt(i);

            if(c==' ') continue;

            if(Character.isDigit(c)){
                num=num*10 + c-'0';
            }
            else if(c=='('){
                stack.push(sum);
                stack.push(sign);

                sum=0;
                sign=1;
            }
            else if(c==')'){
                sum+=sign*num;
                num=0;
                sum*=stack.pop();
                sum+=stack.pop();
            }
            else if(c=='+'){
                sum+=num*sign;
                num=0;
                sign=1;
            }
            else if(c=='-'){
                sum+=sign*num;
                num=0;
                sign=-1;
            }

        }

        return sum+ sign*num;
    }
}