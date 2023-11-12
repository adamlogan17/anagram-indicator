package main.CacheManager;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * CacheManager class provides methods to manage a cache of word pairs.
 */
public class CacheManager {
    private static String cacheFilePath;

    /**
     * Constructs a CacheManager with the specified file path for the cache.
     *
     * @param cacheFilePath The file path for the cache.
     */
    public CacheManager(String cacheFilePath) {
        this.cacheFilePath = cacheFilePath;
    }

    /**
     * Initializes the cache by reading existing entries from the file.
     *
     * @return A HashSet containing the initialized cache entries.
     */
    public HashSet<String> initializeCache() {
        HashSet<String> cache = new HashSet<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(cacheFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cache.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cache;
    }

    /**
     * Checks if a word pair is present in the cache.
     *
     * @param firstWord  The first word of the pair.
     * @param secondWord The second word of the pair.
     * @param result     The result of the anagram check.
     * @param cache      The HashSet representing the cache.
     * @return True if the word pair is in the cache, false otherwise.
     */
    public boolean isInCache(String firstWord, String secondWord, boolean result, HashSet<String> cache) {
        return cache.contains(getCacheEntry(firstWord, secondWord, result)) || cache.contains(getCacheEntry(secondWord, firstWord, result));
    }

    /**
     * Checks if a word pair is present in the cache and returns the result as a string.
     *
     * @param firstWord  The first word of the pair.
     * @param secondWord The second word of the pair.
     * @param cache      The HashSet representing the cache.
     * @return "true" if the word pair is in the cache as an anagram, "false" if not, "Not in cache" otherwise.
     */
    public String isInCache(String firstWord, String secondWord, HashSet<String> cache) {
        if(this.isInCache(firstWord, secondWord, true, cache)) {
            return "true";
        } else if (this.isInCache(firstWord, secondWord, false, cache)) {
            return "false";
        }
        return "Not in cache";
    }

    /**
     * Writes a word pair to the cache file if it is not already present.
     *
     * @param firstWord  The first word of the pair.
     * @param secondWord The second word of the pair.
     * @param isAnagram  The result of the anagram check.
     */
    public void writeCache(String firstWord, String secondWord, boolean isAnagram) {
        if (isInCache(firstWord, secondWord, isAnagram, this.initializeCache())) {
            return;
        }

        try {
            // Create the cache file if it doesn't exist
            File cacheFile = new File(cacheFilePath);
            if (!cacheFile.exists()) {
                if (!cacheFile.createNewFile()) {
                    System.out.println("Unable to create the cache file.");
                    return;
                }
            }
            // Append the cache entry
            try (FileWriter writer = new FileWriter(cacheFilePath, true)) {
                writer.write(getCacheEntry(firstWord, secondWord, isAnagram) + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCacheEntry(String firstWord, String secondWord, boolean result) {
        return firstWord + "," + secondWord + "," + result;
    }
}
