// Question 4: First Unique Product (Movie Analogy)
//
// Analogy: You're looking for a unique movie your friend mentioned.
// You start typing titles and want the first *uncommon* one (not trending or duplicated) —
// hoping it’s the one they meant.
//
// This function finds the first string in an array that appears exactly once,
// similar to how a search system might suggest the first rare result you haven't seen before.

import java.util.*;

public class Question4_FirstUniqueProduct {

    // This function finds the first string that is unique (appears only once)
    public static String firstUniqueProduct(String[] products) {
        // LinkedHashMap maintains insertion order (important to find the first unique)
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();

        // Count frequency of each product (like tracking how often each title is suggested)
        for (String product : products) {
            frequencyMap.put(product, frequencyMap.getOrDefault(product, 0) + 1);
        }

        // Return the first product that appears only once
        for (String product : products) {
            if (frequencyMap.get(product) == 1) return product;
        }

        // If no unique product is found
        return null;
    }

    // Sample test cases
    public static void main(String[] args) {
        System.out.println("Question 4:");
        System.out.println("Test 1: " + firstUniqueProduct(new String[]{"Apple", "Computer", "Apple", "Bag"})); // Computer
        System.out.println("Test 2: " + firstUniqueProduct(new String[]{"A", "B", "C", "B", "A"})); // C
        System.out.println("Test 3: " + firstUniqueProduct(new String[]{"X", "X"})); // null
        System.out.println("Test 4: " + firstUniqueProduct(new String[]{"Solo"})); // Solo
        System.out.println("Test 5: " + firstUniqueProduct(new String[]{})); // null
    }
}
