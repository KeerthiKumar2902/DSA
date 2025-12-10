class Solution {
    public int maximalRectangle(char[][] matrix) {
        int prefixSumMat[][]=new int [matrix.length][matrix[0].length];

        for(int j=0;j<matrix[0].length;j++){
            
            int sum=0;
            for(int i=0;i<matrix.length;i++){
                sum=sum+ matrix[i][j]-'0';

                if(matrix[i][j]=='0') sum=0;

                prefixSumMat[i][j]=sum;
            }
        }

        int maxArea=0;

        for(int i=0;i<matrix.length;i++){
            maxArea=Math.max(maxArea,largestRectangleArea(prefixSumMat[i]));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>(); // will store indices of bars in increasing height
        int maxArea = 0;

        // ---------- Phase 1: scan all bars (i from 0 to n-1) ----------
        for (int i = 0; i < n; i++) {
            // If current bar is lower than the bar at stack top, pop and compute area
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    // popped element was the smallest so far -> spans from 0 to i-1
                    width = i;
                } else {
                    // spans between stack.peek()+1 and i-1
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            // push current index (may be top or start of new increasing sequence)
            stack.push(i);
        }

        // ---------- Phase 2: flush remaining indices in stack ----------
        // Now i == n — treat right boundary as n (a virtual bar of height 0)
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width;
            if (stack.isEmpty()) {
                // no smaller on left -> spans whole array
                width = n;
            } else {
                // spans between stack.peek()+1 and n-1
                width = n - stack.peek() - 1;
            }
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}