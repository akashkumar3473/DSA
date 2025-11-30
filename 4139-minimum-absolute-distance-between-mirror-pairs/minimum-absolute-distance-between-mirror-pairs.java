class Solution {
    public int minMirrorPairDistance(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>(); 
       int ans = Integer.MAX_VALUE;
       for(int i = 0; i<nums.length;i++){
        int rev =fun(nums[i]);
        if(map.containsKey(nums[i])) ans = Math.min(ans, i - map.get(nums[i]));
        map.put(rev,i);
       }
       if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    int fun(int num) {
        int temp = 0;
        while(num > 0) {
            int rem = num % 10;
            temp = (temp * 10) + rem;
            num /= 10;
        }
        return temp;
    }
}