class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        int max = 1;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            int count = 1;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    nums[j] = -1 * j;
                    count++;
                }
            }
            if(count > max){
                max = count;
                sum = 0;
            }
            if(max == count){
                sum += max; 
            }
        }
        return sum;
    }
}