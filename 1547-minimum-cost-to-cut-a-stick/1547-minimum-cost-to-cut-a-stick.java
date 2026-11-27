class Solution {
    public int minCost(int n, int[] cuts) {
        int [][] dp=new int[cuts.length+1][cuts.length+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int arr[]=new int[cuts.length+2];
        arr[0]=0;
        arr[cuts.length+1]=n;
        for(int i=0;i<cuts.length;i++){
            arr[i+1]=cuts[i];
        }
        Arrays.sort(arr);
        return cost(1,cuts.length,arr,dp);
    }
    int cost(int i,int j,int[] arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int len=arr[j+1]-arr[i-1];
            int totalcost=cost(i,k-1,arr,dp)+cost(k+1,j,arr,dp)+len;
            min = Math.min(min,totalcost);
        }
        return dp[i][j]=min;
    }
}