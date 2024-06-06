import java.util.ArrayList;
import java.util.List;

class RecentCounter {
    private List<Integer> pings;

    public RecentCounter() {
        pings = new ArrayList<>();
    }
    
    public int ping(int t) {
        pings.add(t);
        int lowerBound = t - 3000;
        int index = binarySearch(pings, lowerBound);

        return pings.size() - index;
    }

    private int binarySearch(List<Integer> array, int value) {
        int left = 0;
        int right = array.size() - 1;

        while (right > left) {
            int midpoint = (left + right) / 2;
            if (array.get(midpoint) == value) return midpoint;
            if (array.get(midpoint) > value) right = midpoint;
            if (array.get(midpoint) < value) left = midpoint + 1;
        }
        return left;
    }
}
