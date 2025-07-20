# Tana Java Test Solutions

**Language:** Java 17
All solutions are written in Java using simple and readable logic, covering programming techniques as per my understanding. Opted to uses heuristic decession making techniques off of things I find interesting. Fingers Crossed.

---

## Question 1: Get Longest Valid String

Returns the longest string from a list that only contains allowed characters and no repeating consecutive letters.
It filters each word and returns the longest valid one.

---

## Question 2: Count Unique Sums

Counts how many unique subsets of numbers add up to a target value.
Uses dynamic programming to track combinations and avoid duplicates.

---

## Question 3: Make Array Zero

Checks if an array can be reduced to all zeros (except the first element) by applying a subtractive rule.
Simulates backward reduction and checks if the sequence is valid.

---

## Question 4: First Unique Product

Finds the first non-repeating string in a list.
Uses a LinkedHashMap to keep track of order and count, then returns the first with count 1.

---

## Question 5: Closest Minimum Distance

Finds the smallest gap between duplicate occurrences of the minimum number in an array.
Scans while tracking the last position and updates the shortest gap found.

---

## Question 6: Top 3 Common Words

Returns the top 3 most frequent words in a sentence, sorted alphabetically.
Counts all words, sorts them by frequency and then by name.

---

## Question 7: Rotate Linked List

Rotates a linked list to the right by `k` steps.
Calculates the list size, makes it circular, and cuts at the correct point to rotate.

---

## How to Compile and Run

Each file includes a `main()` method for testing. To run a solution:

```bash
javac Question1_GetLongestString.java
java Question1_GetLongestString
```

Repeat for other question files by changing the filename.

