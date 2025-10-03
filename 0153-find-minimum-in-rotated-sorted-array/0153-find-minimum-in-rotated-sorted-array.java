class Solution {
    public int findMin(int[] nums) {
        int min = 5002;
        for(int num : nums) {
            if(num < min){
                min = num;
            }
        }

        return min;
    }
}