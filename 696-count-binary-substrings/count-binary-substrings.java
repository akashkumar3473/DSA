class Solution {
    public int countBinarySubstrings(String s) {
        int n  = s.length();
        int prev =0;
        int cur =1;
        int count=0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                cur++;
            }
            else {
                count+= Math.min(prev,cur);
                prev=cur;
                cur=1;
            }
        }
        return count+=Math.min(prev,cur);
        
    }
}