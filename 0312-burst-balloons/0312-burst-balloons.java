class Solution {
    public int maxCoins(int[] arr) {
    int n = arr.length;
    int nums[] = new int[n+2];
    nums[0] = 1;
    nums[n+1] = 1;
    for(int i=0;i<n;i++){
        nums[i+1] = arr[i];
    }
    int dp[][] = new int[n+2][n+2];
    for(int row[] : dp) Arrays.fill(row, -1);
    return cost(1,n,nums,dp);
}
    static int cost(int i,int j,int[] arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxcost=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
        int x = arr[i-1]*arr[k]*arr[j+1];
        int tc=cost(i,k-1,arr,dp)+cost(k+1,j,arr,dp)+x;
        maxcost= Math.max(maxcost,tc);
        }
        return dp[i][j]=maxcost;
    }
}