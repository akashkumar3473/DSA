class Solution {

    public int[]reverse(int[]arr){
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
    public int[] plusOne(int[] nums) {
int []num = reverse(nums);
int carry= 1;
int sum = 0;
String s = "";
for(int i = 0;i<nums.length;i++){
    if(i==nums.length-1){
       sum = num[i]+carry;
       carry = sum/10;
       if(carry>=1){
       s+=(char)(sum%10);
       s+= (char)carry;}
       else{
s+=(char)(sum%10);
       }
    }

    else{
 sum = num[i]+carry;
       carry = sum/10;
       s+=(char)(sum%10);
    }
}

char[]ch = s.toCharArray(); 
    int i = 0;
    int j = ch.length-1;
    while(i<j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        i++;
        j--;
    } 

      
      int []arr = new int[ch.length];

      for(int p = 0;p<arr.length;p++){
        arr[p] = (int)(ch[p]);

      }
      return arr;
        
    }
}