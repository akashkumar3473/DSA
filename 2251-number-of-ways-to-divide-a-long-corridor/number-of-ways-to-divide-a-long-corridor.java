class Solution {
    public int numberOfWays(String corridor) {
        long MOD = 1_000_000_007;
        int totalSeats = 0;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') totalSeats++;
        }

        if (totalSeats == 0 || totalSeats % 2 != 0) return 0;

        long ways = 1;
        int seatCount = 0;
        int plants = 0;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;

                
                if (seatCount > 2 && seatCount % 2 == 1) {
                    ways = (ways * (plants + 1)) % MOD;
                    plants = 0;
                }
            } else {
                // Count plants only between segments
                if (seatCount >= 2 && seatCount % 2 == 0) {
                    plants++;
                }
            }
        }

        return (int) ways;
    }
}