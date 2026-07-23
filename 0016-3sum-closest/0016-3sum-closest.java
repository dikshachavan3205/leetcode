import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] arr, int target) {

        int n = arr.length;
        Arrays.sort(arr);
        int ans = arr[0] +arr[1] +arr[2];

        for(int i = 0; i< n-2; i++){

            int j = i+1; 
            int k = n-1;

            while(j < k){

                int sum = arr[i] +arr[j] +arr[k];
                if(Math.abs(target-sum) < Math.abs(target-ans)){
                    ans = sum;
                }    
                if(sum < target){
                        j++;
                    }
                    else{
                        k--;
                    }
                }
            }
        
        return ans;
    }
}