package main.AnagramChecker;

import java.util.Arrays;

/**
 * AnagramChecker class provides methods to check if two words are anagrams.
 */
public class AnagramChecker {

    /**
     * Checks if two words are anagrams, ignoring case differences.
     *
     * @param firstWord  The first word to be checked.
     * @param secondWord The second word to be checked.
     * @return True if the words are anagrams, false otherwise.
     */
    public boolean isAnagram(String firstWord, String secondWord) {
        return sortStringAlphabetically(firstWord.toLowerCase()).equals(sortStringAlphabetically(secondWord.toLowerCase()));
    }

    /**
     * Sorts a string alphabetically.
     *
     * @param input The input string to be sorted.
     * @return A new string with characters sorted alphabetically.
     */
    private String sortStringAlphabetically(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
