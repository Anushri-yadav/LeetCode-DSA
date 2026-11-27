class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
      for(int i=0;i<piles.length;i++){
        max=Math.max(max,piles[i]);
      } 
      int lo=1;
      int hi=max;
      while(lo<hi){
        int mid=lo+(hi-lo)/2;
        if(hour(mid,piles)<=h){
            hi=mid;
        }
        else{
            lo=mid+1;
        }
      } 
      return lo;
    }
   int hour(int cap, int[] arr){
        int h = 0;

        for(int i = 0; i < arr.length; i++){
            h += (arr[i] + cap - 1) / cap;
        }

        return h;
    }
}