class Solution {
    public int characterReplacement(String s, int k) {
        int hash[]=new int[26];
        int l=0,r=0;
        int maxLen=0,maxFreq=0;
        int n=s.length();

        while(r<n){
            hash[s.charAt(r)-'A']++;

            int freq = 0;
            for (int i = 0; i < 26; i++) {
                freq = Math.max(freq, hash[i]);
            }
            maxFreq = freq;

            while((r-l+1)-maxFreq>k){
                hash[s.charAt(l)-'A']--;

                freq=0;
                for(int i=0;i<26;i++){
                    freq=Math.max(freq,hash[i]);
                }
                maxFreq=freq;
                l++;
            }

            if((r-l+1)-maxFreq<=k){
                maxLen=Math.max(maxLen,(r-l+1));
            }
            r++;
        }

        return maxLen;
    }
}