class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0, maxLen=0;
        char array[]=s.toCharArray();
        int n=array.length;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        
        while(r<n){
            if(map.containsKey(array[r]) && l <= map.get(array[r])){
                l=map.get(array[r])+1;
            }

            int len=r-l+1;
            maxLen=Math.max(maxLen,len);
            map.put(array[r],r);
            r++;
        }

        return maxLen;
    }
}