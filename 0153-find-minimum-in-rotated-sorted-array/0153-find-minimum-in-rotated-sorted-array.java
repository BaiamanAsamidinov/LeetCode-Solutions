class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];

        //Time complexity: O(N*LogN)
        //Space complexity: O(1)

    }
}