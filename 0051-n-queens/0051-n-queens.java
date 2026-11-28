class Solution {
    public List<List<String>> solveNQueens(int n) {
      char[][] board=new char[n][n]; 
        for(char[] row : board) Arrays.fill(row,'.');
        List<List<String>> list=new ArrayList<>();
        Queen(0,board,list);
        return list;
    }
    void Queen(int row,char[][] board,List<List<String>> list){
        int n=board.length;
      if(row==n){
        List<String> temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            String s="";
            for(int j=0;j<n;j++){
               s=s+board[i][j]; 
            }
            temp.add(s);
        }
        list.add(temp);
        return;
      }
      for(int col=0;col<n;col++){
        if(check(row,col,board)){
            board[row][col]='Q';
            Queen(row+1,board,list);
            board[row][col]='.';
        }
      } 
    }
    boolean check(int row,int col,char[][] arr){
        int i=row-1;
        while(i>=0){
            if(arr[i][col]=='Q') return false;
            i--;
        }
       i=row;
       int j=col;
       while(i!=0 && j!=0){
        i--;
        j--;
        if(arr[i][j]=='Q') return false;
       }
       i=row;
       j=col;
       while(i!=0 && j!=arr.length-1){
        i--;
        j++;
        if(arr[i][j]=='Q') return false;
       }
       return true;
    }
}