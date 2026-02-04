class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i=0; i<n; i++){
            sum += nums[i];
            int tar = sum - k;
            if(mp.containsKey(tar))
            count += mp.get(tar);
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return count;
    }
}