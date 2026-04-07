class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        
        // 1. Skip leading spaces
        while (i < n && s.charAt(i) == ' ') i++;
        
        // 2. Handle sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }
        
        // 3. Convert digits
        long num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            
            // 4. Clamp overflow
            if (sign * num >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * num <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            i++;
        }
        
        return (int)(sign * num);
    }
}