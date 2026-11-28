class Solution {
    public int totalNQueens(int n) {
        int[][] board=new int[n][n];
        int[] ans=new int[1];
        Queen(0,board,ans);
       return ans[0];   
    }
    void Queen(int row,int[][] arr,int[] ans){
        int n=arr.length;
        if(row==n){
            ans[0]=ans[0]+1;
            return;
        }
        for(int col=0;col<n;col++){
             if(check(row,col,arr)){
                arr[row][col]=1;
                Queen(row+1,arr,ans);
                arr[row][col]=0;
             }
        }
    }
    boolean check(int row,int col,int[][]arr){
        int i=row-1;
        while(i>=0){
            if(arr[i][col]==1) return false;
            i--;
        }
        i=row;
        int j=col;
        while(i!=0 && j!=0){
            i--;
            j--;
            if(arr[i][j]==1) return false;
        }
        i=row;
        j=col;
        while(i!=0 && j!=arr.length-1){
            i--;
            j++;
            if(arr[i][j]==1) return false;
        }
        return true;
    }
}