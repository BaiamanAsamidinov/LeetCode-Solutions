class Solution {
    public int removeDuplicates(int[] arr) {
        int count = 1;
        for(int i = 1; i < arr.length; i++){ // 1 1 2
            if(arr[i-1] != arr[i]){

                arr[count] = arr[i];     
                count++;
                
            }
        }
        return count;  
    }
}