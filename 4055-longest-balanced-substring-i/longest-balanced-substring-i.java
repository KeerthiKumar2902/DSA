class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int maxLength=0;

        for(int i = 0; i < n; i++){
            int[] freq = new int[26];

            for(int j = i; j < n; j++){
                freq[s.charAt(j) - 'a']++;

                if(isBalanced(freq)){
                    int len = j - i + 1;
                    maxLength = Math.max(maxLength, len);
                }
            }
        }

        return maxLength;
    }

    boolean isBalanced(int[] freq){
        int val = 0;

        for(int f : freq){
            if(f == 0) continue;

            if(val == 0) val = f;
            else if(val != f) return false;
        }
        return true;
    }
}