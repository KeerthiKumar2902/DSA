import java.util.Stack;

public class Solution {
    private static final int MOD = (int)1e9 + 7;

    public int sumSubarrayMins(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] nse = findNextSmaller(nums);             // next strictly smaller (or n)
        int[] psee = findPreviousSmallerOrEqual(nums); // previous smaller-or-equal (or -1)

        long sum = 0L;
        for (int i = 0; i < n; i++) {
            long left = i - (long) psee[i];            // choices for start
            long right = (long) nse[i] - i;            // choices for end
            long freq = (left * right) % MOD;
            long val = (nums[i] % MOD + MOD) % MOD;   // safe if negatives (rare)
            long contrib = (freq * val) % MOD;
            sum = (sum + contrib) % MOD;
        }

        return (int) sum;
    }

    // Next strictly smaller element index to the right; if none, n
    private static int[] findNextSmaller(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    // Previous smaller-or-equal element index to the left; if none, -1
    private static int[] findPreviousSmallerOrEqual(int[] nums) {
        int n = nums.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }
}
