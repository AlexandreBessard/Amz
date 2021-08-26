package arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
    Given an array of integers nums and
    an integer target, return indices of the two numbers such that they add up to target.
     */
    public static void main(String[] args) {
        int[] nums_2 = {3, 2, 4};
        int target_2 = 6;
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        //Output: [0, 1]
        //System.out.println(Arrays.toString(twoSums(nums, target)));
        //Output: [1, 2]
        System.out.println(Arrays.toString(twoSums(nums_2, target_2)));
    }

    public static int[] twoSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            /*[3, 0]
              [2, 1]
              [4, 2]
             */
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            //4
            int c = target - nums[i];
            if(map.containsKey(c) && map.get(c) != i) {
                return new int[] {i, map.get(c)};
            }
        }
        return null;
    }

}
