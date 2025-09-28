class Solution {
    public int largestPerimeter(int[] nums) {

        int sum = 0;
        Arrays.sort(nums);

        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = nums.length - 2; j >= 0; j--){
                for(int k = nums.length - 3; k >= 0; k--){ // 10 2 1
                    
                    if(nums[i] >= (nums[j] + nums[k])) {
                        i--;
                        break;
                    }
                    System.out.println(nums[i] + " " +  nums[j] + " " + nums[k]);

                    if(i != j && j != k && i != k && nums[i] > 0 && nums[j] > 0 && nums[k] > 0 && nums[i] < (nums[j] + nums[k]) && nums[j] < (nums[i] + nums[k]) && nums[k] < (nums[i] + nums[j])) {
                        sum = nums[i] + nums[j] + nums[k];

                        System.out.println(nums[i] + " " +  nums[j] + " " + nums[k] + "Answer");
                        return sum;
                    }

                }
            }
        }

        return sum;
    }
}