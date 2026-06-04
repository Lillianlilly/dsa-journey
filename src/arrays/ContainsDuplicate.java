package arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * LeetCode #217 - Contains Duplicate
 * Difficulty: Easy
 * Problem: Given an integer array nums, return true if any value
 * appears at least twice in the array, and false if every element
 * is distinct.
 * Example: nums = [1,2,3,1] -> true
 *          nums = [1,2,3,4] -> false
 * Solved 3 ways to compare time-space tradeoffs.
 * Day 1 of DSA journey
 */
public class ContainsDuplicate {

    /**
     * Brute force approach: compare every pair of elements.
     * Time:  O(n^2) - nested loops
     * Space: O(1)   - no extra space
     */
    public static boolean  containsDuplicates(int[] nums){
        for(int i =0; i<nums.length ; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sorting approach: after sorting, any duplicates will be adjacent.
     * Time:  O(n log n) - sorting cost
     * Space: O(1)       - sorts in place
     * Note: This modifies the input array. If the caller needs the
     * original order preserved, copy the array first.
     */
    public static boolean containsDuplicatesSorting(int[] nums){
        Arrays.sort(nums);
        for (int i=0 ;i< nums.length -1;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    /**
     * HashSet approach: track seen numbers as we go.
     * Uses set.add()'s return value - it returns false if the element
     * already existed, true if newly added.
     * Time:  O(n) - single pass with O(1) set operations
     * Space: O(n) - set may store up to n elements
     * Best choice when input cannot be modified and speed matters.
     */
    public static boolean containsDuplicatesHashSet(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums){
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){

        // Test 1: contains a duplicate
        int[] nums = {1, 2, 3, 1};
        System.out.println("Test 1 (expect true):");
        System.out.println("  Brute force: " + containsDuplicates(nums));
        System.out.println("  Sorting:     " + containsDuplicatesSorting(nums.clone()));
        System.out.println("  HashSet:     " + containsDuplicatesHashSet(nums));

        // Test 2: all distinct elements
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("\nTest 2 (expect false):");
        System.out.println("  Brute force: " + containsDuplicates(nums1));
        System.out.println("  Sorting:     " + containsDuplicatesSorting(nums1.clone()));
        System.out.println("  HashSet:     " + containsDuplicatesHashSet(nums1));

    }
}
