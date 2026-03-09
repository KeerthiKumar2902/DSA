class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int frequency[]=new int[26];

        for(char c: s1.toCharArray()){
            frequency[c-'a']++;
        }

        int windowSize=s1.length();

        for(int i=0;i<s2.length();i++){
            int windowInd=0;
            int indx=i;
            int windowFreq[]=new int[26];

            while(windowInd<windowSize && indx<s2.length()){
                char c=s2.charAt(indx);
                windowFreq[c-'a']++;
                windowInd++;
                indx++;
            }

            if(isSameArray(frequency,windowFreq)){
                return true;
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