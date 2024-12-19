class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int na = nums1.length;
        int nb = nums2.length;

        int totalLength = na + nb;
        boolean isMedianOdd = totalLength % 2 == 1;
        
        if(isMedianOdd) {
            return binarySearchInSortedArrays(nums1, nums2, 0, na - 1, 0, nb - 1, totalLength/2);
        } else {
            int leftMedian = binarySearchInSortedArrays(nums1, nums2, 0, na - 1, 0, nb - 1, totalLength / 2 - 1);
            int rightMedian = binarySearchInSortedArrays(nums1, nums2, 0, na - 1, 0, nb - 1, totalLength / 2);
            return (leftMedian + rightMedian) / 2.0;
        }
    }

    public int binarySearchInSortedArrays(
        int[] A,
        int[] B,
        int aStart,
        int aEnd,
        int bStart,
        int bEnd,
        int k
    ) {
        if (aEnd < aStart) {
            return B[k - aStart];
        }
        if (bEnd < bStart) {
            return A[k - bStart];
        }
        
       int aIndex = aStart + (aEnd - aStart) / 2;

       int bIndex = bStart + (bEnd - bStart) / 2;


        int aValue = A[aIndex];
        int bValue = B[bIndex];

        if(k > aIndex + bIndex) {
            if(aValue <= bValue) {
                return binarySearchInSortedArrays(A, B, aIndex + 1,aEnd, bStart, bEnd, k);
            } else {
                return binarySearchInSortedArrays(A, B, aStart, aEnd, bIndex +1, bEnd, k);
            }

        } else {
            if(aValue <= bValue) {
                return binarySearchInSortedArrays(A, B, aStart, aEnd, bStart, bIndex - 1, k);
            } else {
                return binarySearchInSortedArrays(A, B, aStart, aIndex - 1, bStart, bEnd, k);
            }
            
        }

    }
}