// Question 6: Top 3 Most Common Words (Sorted)
// Analogy: Imagine reviewing a famous movie — we're trying to identify the 3 most memorable lines
// that fans frequently quote. These are the "top words" based on how often they appear.

import java.util.*;

public class Question6_CommonWords {

    // This function finds the top 3 most frequently occurring words in a sentence.
    public static List<String> topThreeWords(String sentence) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Step 1: Count how often each word appears (i.e., track how often each quote is mentioned).
        for (String word : sentence.toLowerCase().split(" ")) {
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        // Step 2: Sort words first by frequency (descending), then alphabetically (ascending).
        // This helps select the top "quotes" or "catchphrases" that define the movie.
        return wordFrequency.entrySet().stream()
                .sorted((a, b) -> {
                    if (b.getValue().equals(a.getValue())) {
                        return a.getKey().compareTo(b.getKey()); // alphabetically if tie
                    }
                    return b.getValue() - a.getValue(); // by frequency
                })
                .limit(3) // Pick top 3
                .map(Map.Entry::getKey)
                .sorted() // Finally, sort the result alphabetically
                .toList();
    }

    public static void main(String[] args) {
        System.out.println("Question 6:");

        // Test case 1: multiple repeating words
        System.out.println(topThreeWords("hi there care to discuss algorithm basis or how to solve algorithm or"));
        // Output: [algorithm, or, to]

        // Test case 2: all words are unique
        System.out.println(topThreeWords("one two three four five"));
        // Output: [five, four, one] (alphabetically among all with freq=1)

        // Test case 3: sentence with varying case
        System.out.println(topThreeWords("Hi hi HI hI there There"));
        // Output: [hi, there] (hi appears 4 times, there twice)

        // Test case 4: sentence with empty string or spaces
        System.out.println(topThreeWords("     "));
        // Output: []

        // Test case 5: fewer than 3 unique words
        System.out.println(topThreeWords("hi hi hi"));
        // Output: [hi]
    }
}
