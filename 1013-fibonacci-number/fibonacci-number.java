class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int prev = 1;
        int prev2 = 0;

        int fibn =0;
        for(int i =2; i<=n;i++){
            fibn = prev+prev2;
            prev2 = prev;
            prev = fibn;
        }
        return fibn;
    }
}