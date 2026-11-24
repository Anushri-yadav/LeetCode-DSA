class Solution {
    public int countSubstrings(String s1) {
      int[][] dp=new int[s1.length()][s1.length()];
      int count=0;
               for(int i=0;i<s1.length();i++){
                   int k=0;
                   for(int j=i;j<s1.length();j++){
                       if(k==j){
                         dp[k][j]=1;
                         count++;
                       }
                      else if(s1.charAt(k)==s1.charAt(j)){
                       if(j==k+1){
                         dp[k][j]=2;
                         count++;
                       }
                       else if((j>0 && k<s1.length()-1 )&& dp[k+1][j-1]!=0){
                           dp[k][j]=dp[k+1][j-1]+2;
                           count++;
                       }
                      }
                      k++;
                   }
               }
               return count;
           }
       }