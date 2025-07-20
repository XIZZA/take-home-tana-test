import java.util.Arrays;

// Question 5: Closest distance between duplicate minimums
//
// Analogy:
// Two premier league games are being played,I am trying to find the **shortest walking distance**
// between repeated (same city teams/derbies) cities. Four teams in the same city playing on the same day = two derbies.
// Each location has a budget tag, and you're trying to find two **identical cheapest locations to find my transport to the next derby**
// that are **closest to each other in case numerous other fans are thinking of watching both games like I am.** in the
// schedule.
// This helps minimize movement and cost — so the goal is to find the minimum distance between
// two equal, lowest-cost options.
//
// If there's only one cheapest location, there's no distance to compare, so the answer remains `Integer.MAX_VALUE`.

public class Question5_MinDistance {
    public static int closestMinDistance(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt(); // Find the minimum value (cheapest transportation)
        int lastIndex = -1; // Track the last index where the min was seen
        int minDistance = Integer.MAX_VALUE; // Start with a very large distance,detour if all routes are crowded.

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) { // Found a duplicate of the cheapest location
                if (lastIndex != -1) {
                    minDistance = Math.min(minDistance, i - lastIndex); // Update if this is the smallest gap
                }
                lastIndex = i; // Update last seen index
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        System.out.println("Question 5:");
        System.out.println("Test 1: " + closestMinDistance(new int[]{1, 2, 3, 1, 4, 5, 2})); // 3 (1 at index 0 and 3)
        System.out.println("Test 2: " + closestMinDistance(new int[]{3, 1, 4, 1, 5, 1}));     // 2 (1 at index 1 and 3)
    }
}
