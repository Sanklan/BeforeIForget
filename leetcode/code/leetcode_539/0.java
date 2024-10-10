class Solution {
    public int findMinDifference(List<String> timePoints) {
        int minDiff = Integer.MAX_VALUE;
        int n = timePoints.size();
        if (new HashSet<String>(timePoints).size() < n) return 0;

        /*List<Integer> converted = new ArrayList<Integer>();
        timePoints.stream().forEach( time -> converted.add(toMinute(time)));
        Collections.sort(converted);
        converted.add(converted.get(0));*/
        Collections.sort(timePoints);
        timePoints.add(timePoints.get(0));

        int prev = toMinute(timePoints.get(0));
        for( int i = 1; i <= n; i++) {
            int current = toMinute(timePoints.get(i));
            int diff = Math.abs(current - prev);
            if (diff == 0) return 0;

            if (diff >= 720) {
                diff = Math.abs(1440 - diff);
            }
            minDiff = Math.min(minDiff, diff);

            prev = current;
        }

        return minDiff;
    }

    private int toMinute(String time) {
        String[] timeSplit = time.split(":");
        int hour = Integer.parseInt(timeSplit[0]);
        int minute =  Integer.parseInt(timeSplit[1]);

        return hour * 60 + minute;
    }
}