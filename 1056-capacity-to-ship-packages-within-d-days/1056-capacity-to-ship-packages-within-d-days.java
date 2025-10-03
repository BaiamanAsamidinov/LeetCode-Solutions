class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int highWeight = -1, sumWeight = 0;
        for(int weight : weights) {
            highWeight = Math.max(highWeight, weight);
            sumWeight = sumWeight + weight;
        }
 

        int left = highWeight;
        int right = sumWeight;

        while(left < right) {
            int mid = left + (right - left) / 2;
            int daysNeeded = 1, currW = 0;

            for(int weight : weights) {

                if(currW + weight > mid){
                    daysNeeded++;
                    currW = 0;
                }

                currW = currW + weight;
            }
            if (daysNeeded > days) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
            
        }

        return left;
    }
}
// Time complexit: O(N);