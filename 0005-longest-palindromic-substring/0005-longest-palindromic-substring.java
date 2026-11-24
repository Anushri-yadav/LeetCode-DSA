class Solution {
    public String longestPalindrome(String s1) {
     int[][] dp=new int[s1.length()][s1.length()];
        int max=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s1.length();i++){
            int k=0;
            for(int j=i;j<s1.length();j++){
                if(k==j) dp[k][j]=1;
               else if(s1.charAt(k)==s1.charAt(j)){
                if(j==k+1) dp[k][j]=2;
                else if((j>0 && k<s1.length()-1 )&& dp[k+1][j-1]!=0){
                    dp[k][j]=dp[k+1][j-1]+2;
                }
               }
               max=Math.max(max,dp[k][j]);
               k++;
            }
        }
         for(int i=0;i<s1.length();i++){
            for(int j=0;j<s1.length();j++){
                if(dp[i][j]==max){
                    int k=i;
                  while(k<=j){
                    char ch=s1.charAt(k);
                    sb.append(""+ch);
                    k++;
                  }
                  return sb.toString();    
                }
            }
        }
        return sb.toString();   
    }
}