package easy.arrays;

import java.util.Arrays;

//Given an array, rotate the array to the right by k steps, where k is non-negative.
public class RotateArray {

    /*
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3   ;
        //System.out.println(Arrays.toString(rotate(nums, k)));
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        for(int i = 0; i < k; i++) {
            int previous = nums[nums.length - 1];
            for(int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }


}
