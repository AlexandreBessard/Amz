package easy.arrays;

import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        //Output: true
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int num: nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
