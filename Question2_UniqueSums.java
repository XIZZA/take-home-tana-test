// Question 2: Count Unique Sums (Combinatorial DP)
//
// Analogy:
// I am creating a movie marathon for a specific total runtime — say 120 minutes. Want to watch numerous movies
//appearing to have binged.
// Enter a list of movies (with known durations). Each movie can only be watched once.
// I try to find all the **unique sets of movies** whose total durations **exactly sum to the target**.
//
// This DP solution builds up those combinations by deciding, for each movie, whether to include or exclude it.
// Sorting each combination ensures that different orders of the same movies aren't double-counted.

import java.util.*;
public class Question2_UniqueSums {
    public static int countUniqueSums(int[] numbers, int target) {
        int n = numbers.length;
        Set<String>[][] dp = new HashSet[n + 1][target + 1];

        // Initialize DP
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        dp[0][0].add("");

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                // Exclude current
                dp[i][j].addAll(dp[i - 1][j]);
                // Include current if possible
                if (j >= numbers[i - 1]) {
                    for (String prev : dp[i - 1][j - numbers[i - 1]]) {
                        List<Integer> temp = new ArrayList<>();
                        if (!prev.isEmpty()) {
                            for (String p : prev.split(",")) temp.add(Integer.parseInt(p));
                        }
                        temp.add(numbers[i - 1]);
                        Collections.sort(temp);
                        dp[i][j].add(temp.toString());
                    }
                }
            }
        }

        return dp[n][target].size();
    }

    public static void main(String[] args) {
        System.out.println("Question 2:");
        System.out.println("Test 1: " + countUniqueSums(new int[]{1, 2, 3, 4, 5}, 10)); // 3
        System.out.println("Test 2: " + countUniqueSums(new int[]{1, 2, 4, 7, 5}, 17)); // 1
        System.out.println("Test 3: " + countUniqueSums(new int[]{1, 1, 1}, 2)); // 1
        System.out.println("Test 4: " + countUniqueSums(new int[]{2, 3, 5}, 10)); // 1
        System.out.println("Test 5: " + countUniqueSums(new int[]{1, 2, 2, 3}, 4)); // 3
    }
}
