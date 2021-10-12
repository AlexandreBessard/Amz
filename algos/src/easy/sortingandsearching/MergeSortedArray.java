package easy.sortingandsearching;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1; //Based on the index number
        int p2 = n - 1;
        for(int p = m + n - 1; p >=0; p--) {
            if(p2 < 0){
                break;
            }
            if(p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}
