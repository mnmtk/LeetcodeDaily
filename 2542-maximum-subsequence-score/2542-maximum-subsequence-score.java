import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        // Create an array of pairs to keep nums1 and nums2 values together
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        
        // Sort pairs by nums2 in descending order
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));
        
        // Min-heap to keep track of the largest k elements from nums1
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long currentSum = 0;
        long maxScore = 0;
        
        for (int i = 0; i < n; i++) {
            int num1 = pairs[i][0];
            int num2 = pairs[i][1];
            
            // Add current nums1 value to our sum and heap
            pq.offer(num1);
            currentSum += num1;
            
            // If we have more than k elements, remove the smallest nums1 value
            if (pq.size() > k) {
                currentSum -= pq.poll();
            }
            
            // If we have exactly k elements, calculate the score
            if (pq.size() == k) {
                long currentScore = currentSum * num2;
                maxScore = Math.max(maxScore, currentScore);
            }
        }
        
        return maxScore;
    }
}