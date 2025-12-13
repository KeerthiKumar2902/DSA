class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even = n - n / 2;
        long odd = n / 2;

        long res = (powMod(5, even) * powMod(4, odd)) % MOD;
        return (int) res;
    }

    private long powMod(long x, long n) {
        long ans = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                ans = (ans * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }

        return ans;
    }
}
