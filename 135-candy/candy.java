class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int sum = 1;     // first child always gets at least 1
        int up = 0;      // length of last uphill run
        int down = 0;    // length of last downhill run
        int peak = 0;    // length of last peak (top of mountain)

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                peak = up;
                down = 0;
                sum += 1 + up;
            } 
            else if (ratings[i] == ratings[i - 1]) {
                up = 0;
                down = 0;
                peak = 0;
                sum += 1;
            } 
            else { // ratings[i] < ratings[i - 1]
                up = 0;
                down++;
                sum += 1 + down - (peak >= down ? 1 : 0);
            }
        }

        return sum;
    }
}
