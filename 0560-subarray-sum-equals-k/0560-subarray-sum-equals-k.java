class Solution {
    public int subarraySum(int[] nums, int k) {

        int counter = 0;

        for(int i = 0; i < nums.length; i++) {
            int small_sum = nums[i];

            if(nums[i] == k) 
                counter++;

            for(int j = i + 1; j < nums.length; j++) {
                small_sum += nums[j]; 

                if(small_sum == k){
                    counter++;
                }
                // if(small_sum > k){
                //     break;
                // }
            }
        }
        return counter;
    }
}