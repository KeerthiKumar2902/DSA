class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();

        int a=0, b=0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a') a++;
        }

        int res=a;

        for(int i=0;i<n;i++){
            int c=s.charAt(i);

            if(c=='a') a--;
            else b++;

            res=Math.min(res,a+b);
        }

        return res;
    }
}