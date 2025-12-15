class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 1;
        long curr = 1;

        for(int i=1;i<prices.length;i++){
            if(prices[i-1]-prices[i]==1){
                curr++;
            }else{
                curr = 1;
            }
            ans += curr;
        }
        return ans;
    }
}