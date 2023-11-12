package test;

import main.AnagramChecker.AnagramChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnagramCheckerTest {

    @Test
    void testIsAnagramWithValidAnagrams() {
        AnagramChecker anagramChecker = new AnagramChecker();
        assertTrue(anagramChecker.isAnagram("listen", "silent"));
    }

    @Test
    void testIsAnagramWithCaseInsensitiveCheck() {
        AnagramChecker anagramChecker = new AnagramChecker();
        assertTrue(anagramChecker.isAnagram("listen", "SILENT"));
    }

    @Test
    void testIsAnagramWithDifferentWords() {
        AnagramChecker anagramChecker = new AnagramChecker();
        assertFalse(anagramChecker.isAnagram("hello", "world"));
    }

    @Test
    void testIsAnagramWithDifferentLengths() {
        AnagramChecker anagramChecker = new AnagramChecker();
        assertFalse(anagramChecker.isAnagram("abc", "defg"));
    }

    @Test
    void testIsAnagramWithNonAnagrams() {
        AnagramChecker anagramChecker = new AnagramChecker();
        assertFalse(anagramChecker.isAnagram("software", "hardware"));
    }
}
