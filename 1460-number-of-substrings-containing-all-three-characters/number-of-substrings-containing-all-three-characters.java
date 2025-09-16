class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int lastA = -1, lastB = -1, lastC = -1;
        int count = 0;

        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            if (ch == 'a') lastA = r;
            else if (ch == 'b') lastB = r;
            else lastC = r;

            // All three characters have appeared
            int minLast = Math.min(lastA, Math.min(lastB, lastC));
            if (minLast != -1) {
                count += minLast + 1;
            }
        }

        return count;
    }
}
