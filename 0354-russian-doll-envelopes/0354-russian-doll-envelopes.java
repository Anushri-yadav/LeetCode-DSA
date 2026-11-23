class Solution {
    public int maxEnvelopes(int[][] arr) {
       Arrays.sort(arr, (a, b) ->{ 
       if(a[0]==b[0]) return Integer.compare(b[1], a[1]); //descending
       return Integer.compare(a[0], b[0]); //ascending
       });
       ArrayList<Integer> list=new ArrayList<>();
       for(int i=0;i<arr.length;i++){
        if(list.size()==0 || arr[i][1]>list.get(list.size()-1)) list.add(arr[i][1]);
        else{
            int lo=0;
            int hi=list.size()-1;
            int lb=-1;
            while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(list.get(mid)>=arr[i][1]){
                lb=mid;
                hi=mid-1;
            }
            else lo=mid+1;
            }
            list.set(lb,arr[i][1]);
        } 
       }
      return list.size();
    }
}


