class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int left = 0, maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            map.put(c, right);
        }

        return maxLen;
    }
}
