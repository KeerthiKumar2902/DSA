class Solution {
    public int numberOfSubstrings(String s) {
        int l=0,r=0;
        int n=s.length();

        HashMap<Character,Integer> map=new HashMap<>();
        map.put('a',-1);
        map.put('b',-1);
        map.put('c',-1);
        int count=0;

        while(r<n){
            map.put(s.charAt(r),r);
            int a=map.get('a');
            int b=map.get('b');
            int c=map.get('c');
            if(a>-1 && b>-1 && c>-1){
                l=Math.min(a,Math.min(b,c));
                count+=l+1;
            }
            r++;
        }
        return count;
    }
}