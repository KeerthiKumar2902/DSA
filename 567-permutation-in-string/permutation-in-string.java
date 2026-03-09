class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int frequency[]=new int[26];

        for(char c: s1.toCharArray()){
            frequency[c-'a']++;
        }

        int windowSize=s1.length();

        int r=0;
        int n=s2.length();
        int l=0;

        int windFreq[]=new int[26];
        while(r<n){

            windFreq[s2.charAt(r)-'a']++;

            int curSize=r-l+1;
            if(curSize<windowSize){
                r++;
            }
            else if(curSize==windowSize){
                if(isSameArray(frequency,windFreq)){
                    return true;
                }

                r++;
                windFreq[s2.charAt(l)-'a']--;
                l++;
            }
            else{
                windFreq[s2.charAt(l)-'a']--;
                l++;
            }
        }

        return false;

    }

    public static boolean isSameArray(int freq[],int windF[]){
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=windF[i]){
                return false;
            }
        }

        return true;
    }
}