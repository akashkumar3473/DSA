class Solution {
    
    public int fib(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        if(n<2) return n;
        if(map.containsKey(n)){
            return map.get(n);

        }
        else{
            int res = fib(n-1) + fib(n-2);
            map.put(n,res);
            return res;
        }
    }
}