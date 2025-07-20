// Question 1: Get Longest Unique Character Substring
//
// Analogy:
// You're organizing an action movie marathon. But there's a twist — you don't want to repeat any actor
// (like not repeating characters in a string). You want the **the longest sequence** of back-to-back movies
// with completely unique actors. As soon as an actor appears again, the current streak ends,
// and you restart from the next new actor.
//
// The algorithm helps you find the longest such non-repeating actor streak.

import java.util.HashMap;
import java.util.Map;

public class Question1_GetLongestStringSolution {

    /**
     * Returns the length of the longest substring without repeating characters.
     * Think of it as the longest run of movies with different actors.
     */
    public int lengthOfLongestSubstring(String string) {
        int maxLengthOfString = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0, left = 0; right < string.length(); right++) {
            char currentCharacter = string.charAt(right);

            // If we've seen this actor before,and they're still part of the current streak,
            // we cut the streak and start from the next movie after their last appearance.
            if (lastSeen.containsKey(currentCharacter) && lastSeen.get(currentCharacter) >= left) {
                left = lastSeen.get(currentCharacter) + 1;
            }

            // Update the max length for the longest non-repeating actor streak
            maxLengthOfString = Math.max(maxLengthOfString, right - left + 1);
            lastSeen.put(currentCharacter, right); // Mark the latest movie that featured this actor
        }

        return maxLengthOfString;
    }

    /**
     * Sample test cases to validate the logic.
     */
    public static void main(String[] args) {
        Question1_GetLongestStringSolution solution = new Question1_GetLongestStringSolution();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Expected: 3 ("abc")
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // Expected: 1 ("b")
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // Expected: 3 ("wke")
        System.out.println(solution.lengthOfLongestSubstring(""));         // Expected: 0
        System.out.println(solution.lengthOfLongestSubstring(" "));        // Expected: 1
        System.out.println(solution.lengthOfLongestSubstring("au"));       // Expected: 2
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));     // Expected: 3
        System.out.println(solution.lengthOfLongestSubstring("abba"));     // Expected: 2
        System.out.println(solution.lengthOfLongestSubstring("abcdeafgh")); // Expected: 7 ("cdeafgh")
    }
}
