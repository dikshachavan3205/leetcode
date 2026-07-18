class Solution {
    public int[] getAverages(int[] nums, int k) {

       int n = nums.length;
       int avg[] = new int[n];
       Arrays.fill(avg,-1);
       long sum = 0;

       if(k==0){
        return nums;
       }
       
       if((2*k)+1 > n){
        return avg;
       }

        for(int i = 0; i < (2*k)+1; i++) {
            sum += nums[i];
        }

        int windowSize = 2 * k + 1;
        avg[k] = (int)(sum/windowSize);

        int left = 0;
        int right = windowSize - 1;
        while(right < n-1){

            sum -= nums[left];
            left++;

            right++;
            sum += nums[right];

            avg[left + k] = (int) (sum / windowSize);
        }
    return avg;
    }
}