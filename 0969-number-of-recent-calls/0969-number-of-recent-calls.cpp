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

        if (target <= 0) {
            return arr.size();
        }

        // cout<<endl;

        while(low <= high) {
            int mid = low + (high-low)/2;

            // cout<<low<<" "<<mid<<" "<<high<<endl;

            if (arr[mid] < target) {
                if (mid + 1 < arr.size() && arr[mid+1] > target) {
                    return arr.size() - mid - 1;
                }
                low = mid + 1;
            }
            else if (arr[mid] == target) {
                if (mid == 0) {
                    return arr.size();
                }
                if (mid - 1 >= 0 && arr[mid-1] < target) {
                    return arr.size() - mid;
                }
                high = mid - 1;
            }
            else if (arr[mid] > target) {
                if (mid==0) {
                    return arr.size();
                }
                // if (arr[mid-1] < target) {
                //     return arr.size()
                // }
                high = mid - 1;
            }
        }

        

        return arr.size();
    }
};

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter* obj = new RecentCounter();
 * int param_1 = obj->ping(t);
 */