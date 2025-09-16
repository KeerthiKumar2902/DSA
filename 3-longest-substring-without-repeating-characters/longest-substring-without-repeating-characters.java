class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0 || n==1) return n; 
        int l=0,r=0,maxLen=0;

        Map<Character,Integer> map=new HashMap<>();

        while(r<n){
            char c=s.charAt(r);

            if(map.containsKey(c) && map.get(c)>=l){
                l=map.get(c)+1;
            }

            maxLen=Math.max(maxLen,(r-l+1));
            map.put(c,r);
            r++;
        }

        return maxLen;
    }
}