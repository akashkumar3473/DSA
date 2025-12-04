class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int i = 0, j = n-1;

        while(i<n && directions.charAt(i)=='L') i++;
        while(j>=0 && directions.charAt(j)=='R') j--;

        if(i>j) return 0;

        int totalMiddle = j-i+1;
        int sCount = 0;
        for(int k=i; k<=j; k++){
            if(directions.charAt(k)=='S') sCount++;
        }
        return totalMiddle - sCount;
    }
}