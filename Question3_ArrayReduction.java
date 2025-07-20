// Question 3: Reduce array to zero (except first) using a[i] = a[i] - a[i-1]
//
// Analogy:
// Think of this like distributing leftover supplies at the end of each day in a film production.
// Every team starts with some amount of resources.
// At the end of each day, the current team's remaining resources are reduced by what the previous team used.
// The rule is: a team can't end up with negative resources.
// If the distribution is possible all the way back to the first team, and the first team still has resources left, the project succeeds (return 1).
// Otherwise, it's not possible to distribute fairly (return 0).
//
// Example: If one team ends up with fewer supplies than the previous one, the system fails — like running out of batteries before the day ends.

public class Question3_ArrayReduction {
    public static int canReduceToZero(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) return 0; // Not enough to subtract — distribution fails
            arr[i] -= arr[i - 1];              // Subtract the prior value
        }
        return arr[0] == 0 ? 0 : 1; // If the first value was zero, the entire reduction collapses
    }

    public static void main(String[] args) {
        System.out.println("Question 3:");
        System.out.println("Test 1: " + canReduceToZero(new int[]{1, 2, 3})); // 1 → [1,1,1] → valid
        System.out.println("Test 2: " + canReduceToZero(new int[]{1, 1, 1})); // 1 → [1,0,0] → valid
        System.out.println("Test 3: " + canReduceToZero(new int[]{2, 1, 1})); // 0 → invalid step at index 2
    }
}
