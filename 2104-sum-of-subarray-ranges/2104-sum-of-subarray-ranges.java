import java.util.*;

class Solution {
    public long subArrayRanges(int[] nums) {

        int n = nums.length;

        long minSum = 0;
        long maxSum = 0;

        int[] psl = new int[n];
        int[] nsl = new int[n];

        int[] pgl = new int[n];
        int[] ngl = new int[n];

        Stack<Integer> st = new Stack<>();

        // ==========================================
        // 1. Previous Smaller or Equal (PSL)
        // ==========================================
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                psl[i] = -1;
            } else {
                psl[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // ==========================================
        // 2. Next Smaller (NSL)
        // ==========================================
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsl[i] = n;
            } else {
                nsl[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // ==========================================
        // 3. Previous Greater or Equal (PGL)
        // ==========================================
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                pgl[i] = -1;
            } else {
                pgl[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // ==========================================
        // 4. Next Greater (NGL)
        // ==========================================
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ngl[i] = n;
            } else {
                ngl[i] = st.peek();
            }

            st.push(i);
        }

        // ==========================================
        // 5. Calculate contributions
        // ==========================================
        for (int i = 0; i < n; i++) {

            // Contribution as minimum
            long leftMin = i - psl[i];
            long rightMin = nsl[i] - i;

            minSum += (long) nums[i] * leftMin * rightMin;

            // Contribution as maximum
            long leftMax = i - pgl[i];
            long rightMax = ngl[i] - i;

            maxSum += (long) nums[i] * leftMax * rightMax;
        }

        // Range = Maximum - Minimum
        return maxSum - minSum;
    }
}