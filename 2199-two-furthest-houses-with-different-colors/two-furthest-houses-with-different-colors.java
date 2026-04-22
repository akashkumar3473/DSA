class Solution {
    public int maxDistance(int[] arr) {
        int j = arr.length;
        for(int i =0;i<j;i++){
            if(arr[i] != arr[j-1] || arr[j-1-i] !=arr[0])
                return j-1-i;
        }
        return 0;
    }
}