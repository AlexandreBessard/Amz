package easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear
as many times as it shows in both arrays and you may return the result in any order.
 */
public class IntersectionOfTwoArraysII {

    /*
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]

    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Explanation: [9,4] is also accepted.
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) { intersect(nums2, nums1); }
        Map<Integer, Integer> m = new HashMap<>();
        for(int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for(int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if(cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
