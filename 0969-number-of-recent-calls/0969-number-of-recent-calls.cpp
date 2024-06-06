class RecentCounter {
public:
    vector<int> arr;
    RecentCounter() {
       
    }
    
    int ping(int t) {
        arr.push_back(t);

        int low = 0;
        int high = arr.size()-1;

        int target = t-3000;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }


        return arr.size() - low;
    }
};

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter* obj = new RecentCounter();
 * int param_1 = obj->ping(t);
 */