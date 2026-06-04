package arrays;

import java.util.HashMap;

/**
 * LeetCode #1 - Two Sum
 * Difficulty: Easy
 * Problem: Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * Assume each input has exactly one solution, and you may not use
 * the same element twice.
 * Example: nums = [2,7,11,15], target = 9 -> [0,1]
 * Day 1 of DSA journey
 */
public class TwoSum {

    /**
     * Brute force approach: check every pair of elements.
     * Time:  O(n^2) - nested loops over n elements
     * Space: O(1)   - no extra space used
     */
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

    /**
     * HashMap approach: store each number with its index as we go.
     * For each number, check if its complement (target - current) was
     * already seen in the map.
     * Time:  O(n) - single pass through the array
     * Space: O(n) - HashMap stores up to n elements
     */
    public static int[] twoSumOptimal(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int complement = target - nums[i];
           if(map.containsKey(complement)){
               return new int[]{map.get(complement),i};
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
