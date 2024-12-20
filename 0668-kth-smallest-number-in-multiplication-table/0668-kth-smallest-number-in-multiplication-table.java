class Solution {
    public int findKthNumber(int m, int n, int k) {
	int low = 1;
	int high = m * n;


    if(m > n) {
        findKthNumber(n, m, k);
    }
    

	while (low < high) {
		int mid = low + (high - low) / 2;

		if (enough(m, n, k, mid)) {
			high = mid;
		} else {
			low = mid+1;
		}
	}
	return low;
}

private boolean enough(int m, int n, int k, int ele) {
	int count = 0;
    
	for (int i = 1; i <= m; i++) {
		count += Math.min(ele / i, n);
	}
	return count >= k;
}
}


