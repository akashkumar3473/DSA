class Solution {
    public int binaryGap(int n) {
        String  b = Integer.toBinaryString(n);
        int li=-1;
        int mGap = 0;
        for(int i=0;i<b.length();i++){
            if(b.charAt(i)=='1'){
                if(li!=-1){
                    mGap=Math.max(mGap,i-li);
                }
                li=i;
            }
        }
        return mGap;
    }
}