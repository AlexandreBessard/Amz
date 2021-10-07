package easy.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {

        int[] nums = {1,2,1,2,4};
        //Output: 4
        System.out.println(singleNumber(nums));
        System.out.println(singleNumberWithHashTable(nums));


    }

    public static int singleNumber(int[] nums) {
        List<Integer> noDuplicate = new ArrayList<>(nums.length);
        for(int i : nums) {
            if(!noDuplicate.contains(i)) {
                noDuplicate.add(i);
            } else {
                noDuplicate.remove(Integer.valueOf(i));
            }
        }
        return noDuplicate.get(0);
    }

    public static int singleNumberWithHashTable(int[] nums) {
        Map<Integer, Integer> hash_table = new HashMap<>(nums.length);

        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }


}
