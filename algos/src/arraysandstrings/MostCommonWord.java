package arraysandstrings;

import javax.xml.stream.events.Characters;
import java.util.*;

/*
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not
banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 */
public class MostCommonWord {

    public static void main(String[] args) {

        String str = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        //Expected output: "ball"
        /*
        "hit" occurs 3 times, but it is a banned word.
        "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
         */
        System.out.println(mostCommonWord(str, banned));

    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCount = new HashMap<>();
        char[] chars = paragraph.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int maxCount = 0;
        String result = "";
        for(char c : chars) {
            if(Character.isLetter(c)) {
                stringBuilder.append(Character.toLowerCase(c));
                continue;
            }
            if(!bannedWords.contains(stringBuilder.toString())) {
                int num = wordCount.getOrDefault(stringBuilder.toString(), 0) + 1;
                wordCount.put(stringBuilder.toString(), num);
                if (num > maxCount) {
                    maxCount = num;
                    result = stringBuilder.toString();
                }
            }
            stringBuilder = new StringBuilder();
        }
        return result;
    }
}
