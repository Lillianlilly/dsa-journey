
//Day 1 first problem. Time complexity: O(n²)

package arrays;

import java.util.HashMap;

public class TwoSum {

    public static  int[] twoSum(int[] nums, int target){
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if (nums[i] + nums[j] == target) {
                   return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSumOptimal(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
           if(map.containsKey(target-nums[i])){
               return new int[]{map.get(target-nums[i]),i};
           }
               map.put(nums[i],i);
        }
        return new int[]{};
    }
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums,target);
        System.out.println((result[0] + "," + result[1]));

        int[] resultOptimal = twoSumOptimal(nums,target);
        System.out.println((resultOptimal[0] + "," + resultOptimal[1]));

    }
}
