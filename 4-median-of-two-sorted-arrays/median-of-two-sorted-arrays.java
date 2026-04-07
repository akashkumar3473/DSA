class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merge the two arrays into result
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < m) {
            result[k++] = a[i++];
        }

        while (j < n) {
            result[k++] = b[j++];
        }
        n=result.length;
        if(n%2==0){
            return  (result[n/2-1]+result[n/2])/2.0;
        }
        return result[n/2];

    }
}