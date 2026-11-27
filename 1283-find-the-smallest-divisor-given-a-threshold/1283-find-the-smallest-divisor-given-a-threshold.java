class Solution {
    public int smallestDivisor(int[] nums, int thr) {
        int max=0;
        int sum=0;
       for(int i=0;i<nums.length;i++){
        max=Math.max(max,nums[i]);
        sum+=nums[i];
       }
       int lo=sum/thr;
       if(lo==0) lo=1;
       int hi=max;
       while(lo<hi){
        int mid=lo+(hi-lo)/2;
        if(divisor(mid,nums)<=thr) hi=mid;
        else lo=mid+1;
       }
       return lo;
    }
    int divisor(int mid,int[] arr){
        int sum=0;
       for(int i=0;i<arr.length;i++){
        sum=sum+(arr[i] + mid - 1) / mid;
       }
       return sum;
    }
}