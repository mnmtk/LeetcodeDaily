class NumArray {

    int n;
    int[] tree;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n*2];

        for(int i = 0; i < n; i ++) {
            tree[i + n] = nums[i];
        }

        for(int i = n-1; i > 0; i--) {
            tree[i] = tree[i*2] + tree[i*2 + 1];
        }
    }

    
    public void update(int index, int val) {
        index += n;
        tree[index] = val;

        while(index > 0) {
            int left = index;
            int right = index;

            if(index % 2 == 0) {
                right = index + 1;
            } else {
                left = index - 1;
            }

            index = left/2; 
            tree[index] = tree[left] + tree[right];
        } 
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        left +=n ;
        right += n;

        while(left <= right) {
            if(left % 2 == 1) {
                sum += tree[left];
                left++;
            }

            if(right % 2 == 0) {
                sum+= tree[right];
                right--;
            }
            left = left/2;
            right = right/2;
        }

        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */