class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum =0;
        int n = nums.length;
        int ct = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum += nums[i];
            int tar = sum - k;
            if(map.containsKey(tar)) ct += map.get(tar);
            map.put(sum,map.getOrDefault(sum,0)+1);
            
        }
        return ct;
    }
}