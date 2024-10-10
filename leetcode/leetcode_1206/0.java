class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flights = new int[n];
        for(int i = 0; i < n; i++) flights[i] = 0;
        for(int booking = 0; booking < bookings.length; booking++) {
            int start = bookings[booking][0] - 1;
            int end = bookings[booking][1] - 1;
            int count = bookings[booking][2];
            for(int j = start; j <= end; j++) {
                flights[j] += count;
            }
        }
        
        return flights;
    }
}