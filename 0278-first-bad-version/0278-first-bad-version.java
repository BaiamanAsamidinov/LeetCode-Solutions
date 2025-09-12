/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int answer = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1; 
            }

        }
        return answer;
    }
}

// 1 2 3 4 5

// isBadVersion(i) = true -> bad

// bad