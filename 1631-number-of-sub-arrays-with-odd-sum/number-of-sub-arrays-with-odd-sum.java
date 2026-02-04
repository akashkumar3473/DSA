import java.util.HashMap;

class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;

        int sum = 0;
        int ans = 0;

        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int parity = sum % 2;

            int opposite = 1 - parity;

            if (map.containsKey(opposite)) {
                ans = (ans + map.get(opposite)) % mod;
            }

          
            map.put(parity, map.getOrDefault(parity, 0) + 1);
        }

        return ans;
    }
}
