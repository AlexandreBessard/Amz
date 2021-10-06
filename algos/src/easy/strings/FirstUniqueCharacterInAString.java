package easy.strings;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s, find the first non-repeating character in it and return its index.
If it does not exist, return -1.
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {

        String s = "lovetocodel";
        //Output: 2
        System.out.println(firstUniqChar(s));

    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < map.size(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
