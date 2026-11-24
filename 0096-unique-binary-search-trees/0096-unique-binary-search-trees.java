class Solution {
    public int numTrees(int n) {
       int dp[]=new int[n+1];
       dp[0]=1;
       dp[1]=1;
       for(int i=2;i<n+1;i++){
            int k=0;
            int z=i-1;
            int sum=0;
            while(z>=0 && k<i){
                sum=sum +dp[z]*dp[k];
                k++;
                z--;
            }
            dp[i]=sum;
       } 
       return dp[n];
    }
}