public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];

        // Try all valid splits: i digits from nums1, (k - i) from nums2
        int start = Math.max(0, k - nums2.length);
        int end = Math.min(nums1.length, k);

        for (int i = start; i <= end; i++) {
            int j = k - i;

            // 1. Get max subsequence of length i from nums1
            int[] part1 = findMax(nums1, i);
            // 2. Get max subsequence of length j from nums2
            int[] part2 = findMax(nums2, j);

            // 3. Merge both into a single k-length sequence
            int[] candidate = merge(part1, part2);

            // 4. Track the absolute best overall candidate
            if (greater(candidate, 0, result, 0)) {
                result = candidate;
            }
        }

        return result;
    }

    // Helper 1: Extract lexicographically largest subsequence of size len
    private int[] findMax(int[] nums, int len) {
        int[] stack = new int[len];
        int top = 0; // Stack pointer

        for (int i = 0; i < nums.length; i++) {
            // Pop smaller elements if remaining items allow us to complete length 'len'
            while (top > 0 && stack[top - 1] < nums[i] && (top + nums.length - i) > len) {
                top--;
            }
            if (top < len) {
                stack[top++] = nums[i];
            }
        }
        return stack;
    }

    // Helper 2: Merge two parts into the max k-digit number
    private int[] merge(int[] p1, int[] p2) {
        int[] res = new int[p1.length + p2.length];
        int i = 0, j = 0, r = 0;

        while (i < p1.length || j < p2.length) {
            // If p1 starting at i is greater than p2 starting at j, take from p1
            if (greater(p1, i, p2, j)) {
                res[r++] = p1[i++];
            } else {
                res[r++] = p2[j++];
            }
        }
        return res;
    }

    // Helper 3: Lexicographical array comparison with look-ahead for ties
    private boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }
        return j == b.length || (i < a.length && a[i] > b[j]);
    }
}