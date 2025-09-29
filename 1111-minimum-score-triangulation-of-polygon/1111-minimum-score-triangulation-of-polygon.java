
class Solution {
    int dp[][];
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n];
        for (int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // call the function with i = 1, j = n-1
        // because every time we have to take the ar[i-1] that's why we are starting from i = 1
        return helper_min_score(1,n-1,values);
    }
    
    private int helper_min_score(int i,int j,int values[]){
        if (i == j) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
        // do partition
    
        for (int k=i;k<=j-1;k++){
            int steps = values[i-1] * values[k] * values[j]
                + helper_min_score(i,k,values)// partition 1
                + helper_min_score(k+1,j,values); // partition 2
            mini = Math.min(steps,mini);
        }
        
        return dp[i][j] = mini;
    }
}