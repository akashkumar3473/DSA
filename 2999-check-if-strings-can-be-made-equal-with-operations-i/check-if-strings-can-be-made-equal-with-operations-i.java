class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char c1[] = s1.toCharArray();
        for (int i = 0; i < 2; i++){
            if (s1.equals(s2)) return true;
            if (c1[i] == s2.charAt(i+2)){
                char temp = c1[i];
                c1[i] = c1[i+2];
                c1[i+2] = temp;
                s1 = new String(c1);
            }
        }
        return s1.equals(s2);
    }
}