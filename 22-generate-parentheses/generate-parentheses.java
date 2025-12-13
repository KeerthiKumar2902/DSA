class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backTracking("",0,0,result,n);
        return result;
    }

    public static void backTracking(String cur,int openN,int closeN, List<String> result,int n){
        if(cur.length()==2*n){
            result.add(cur);
            return;
        }

        if(openN<n) backTracking(cur+'(',openN+1,closeN,result,n);
        if(closeN<openN) backTracking(cur+')',openN,closeN+1,result,n);
    }
}