class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int[] cnt = new int[26];
            int distinct = 0, maxFreq = 0;
            for (int j = i; j < n; ++j) {
                int c = s.charAt(j) - 'a';
                if (cnt[c] == 0) distinct++;
                cnt[c]++;
                maxFreq = Math.max(maxFreq, cnt[c]);
                
                if (maxFreq * distinct == j - i + 1) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}
