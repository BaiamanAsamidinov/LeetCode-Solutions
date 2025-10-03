class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while(left < right){
            int mid = (left + right)/2;

            if(nums[mid] < nums[right]){
               right = mid;     
            }
            else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
    //Time complexity: O(logN)
}