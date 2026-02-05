class Solution {

    int solve(String s, char c, int k) {
        int i = 0, j = 0;
        int n = s.length();
        int ans = 0;
        int count = 0;

        while (j < n) {
            if (s.charAt(j) != c)
                count++;

            while (count > k) {
                if (s.charAt(i) != c)
                    count--;
                i++;
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

    public int maxConsecutiveAnswers(String ans, int k) {
        int opt1 = solve(ans, 'T', k);
        int opt2 = solve(ans, 'F', k);
        return Math.max(opt1, opt2);
    }
}
