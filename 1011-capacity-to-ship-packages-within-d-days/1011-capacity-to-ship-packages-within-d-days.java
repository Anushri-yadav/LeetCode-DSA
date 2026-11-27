class Solution {
    public int shipWithinDays(int[] weight, int days) {
        int max=0;
        int sum=0;
        for(int i=0;i<weight.length;i++){
            max=Math.max(max,weight[i]);
            sum=sum+weight[i];
        }
        int lo=max;
        int hi=sum;
        int ans=-1;
     while(lo<hi){
        int mid=lo+(hi-lo)/2;
        if(day(mid,weight)<=days){
            hi=mid;
            ans=mid;
        }
        else lo=mid+1;
     } 
     return lo;
    }
    int day(int cap,int[] arr){
        int day=0;
        int c=cap;
        for(int i=0;i<arr.length;i++){
            if(c>=arr[i]){
                c=c-arr[i];
            }
            else{
                day++;
                c=cap-arr[i];
            }
        }
        day++;
        return day;
    }
}