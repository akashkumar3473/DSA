class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count  = 0;
        // prefixsum
        for(int i=1;i<n;i++){
            nums[i] += nums[i-1];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                int ele = nums[i];
                if(ele==k) count++;
                int rem = ele-k;
                if(map.containsKey(rem)) count += map.get(rem);
                if(map.containsKey(ele)){
                    int freq = map.get(ele);
                    map.put(ele,freq+1);
                }
                else map.put(ele,1);
            }
        return count;

    }
}