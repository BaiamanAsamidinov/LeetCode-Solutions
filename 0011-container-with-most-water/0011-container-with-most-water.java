class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int sum = 0;
        int maxSum = 0;

        int left = 0;
        int right = n - 1;

        while(left < right) {

            if(height[left] < height[right]) {
                sum = height[left] * (right - left);
                left++;
            }
            else {
                sum = height[right] * (right - left);
                right--;
            }

            if(sum > maxSum) {
                maxSum = sum;
            }

        }

        return maxSum;
    }
}