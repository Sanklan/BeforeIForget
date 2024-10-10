/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //HashMap<Integer, Boolean> alreadyChecked = new HashMap<Integer, Boolean>();
        int high = n;
        int low = 1;
        int mid;

        while(low <= high) {
            mid = low + (high - low) / 2;
            boolean isBad = this.isBadVersion(mid);
            /*if (low == mid || high == mid) {
                if (isBad) return low;
                else return low + 1;
            }*/

            if (isBad) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}