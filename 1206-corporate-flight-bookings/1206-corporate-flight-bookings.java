class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        int[] sums = new int[n + 1];

        for (int[] booking : bookings){
            int reservedSeats = booking[2];
            sums[booking[0] - 1] += reservedSeats;
            sums[booking[1]] -= reservedSeats;
        }

        int total = 0;
        for (int i = 0; i < n; i++){
            if (sums[i] != 0){
                total += sums[i];
            }
            result[i] = total;
        }
        return result;
    }
}