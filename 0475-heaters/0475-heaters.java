import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // Step 1: Sort heaters to enable binary search
        Arrays.sort(heaters);
        
        int minRadius = 0;
        
        // Step 2: For each house, find the distance to the closest heater
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            
            if (index < 0) {
                // House is not exact heater position; binarySearch returns -(insertionPoint) - 1
                index = -(index + 1);
            }
            
            // Distance to closest heater to the left/at position
            int dist1 = (index - 1 >= 0) ? house - heaters[index - 1] : Integer.MAX_VALUE;
            
            // Distance to closest heater to the right
            int dist2 = (index < heaters.length) ? heaters[index] - house : Integer.MAX_VALUE;
            
            // Minimum distance to warm this specific house
            int closestHeaterDist = Math.min(dist1, dist2);
            
            // Step 3: Global radius must cover the house requiring the largest distance
            minRadius = Math.max(minRadius, closestHeaterDist);
        }
        
        return minRadius;
    }
}