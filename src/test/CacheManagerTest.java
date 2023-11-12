package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.CacheManager.CacheManager;
import java.io.IOException;
import java.util.HashSet;

class CacheManagerTest {

    private static final String TEST_CACHE_FILE_PATH = "test_cache.csv";

    @Test
    void testInitializeCache() {
        CacheManager cacheManager = new CacheManager(TEST_CACHE_FILE_PATH);
        HashSet<String> cache = cacheManager.initializeCache();

        assertTrue(cacheManager.isInCache("listen", "silent", true, cache));
    }

    @Test
    void testIsInCache() {
        CacheManager cacheManager = new CacheManager(TEST_CACHE_FILE_PATH);
        HashSet<String> cache = cacheManager.initializeCache();

        String firstWord = "listen";
        String secondWord = "silent";
        boolean result = true;

        // Add an entry to the cache
        cacheManager.writeCache(firstWord, secondWord, result);

        // Check if the entry is in the cache
        assertTrue(cacheManager.isInCache(firstWord, secondWord, result, cache));
        assertFalse(cacheManager.isInCache("hello", "world", result, cache));
    }

    @Test
    void testWriteCache() throws IOException {
        CacheManager cacheManager = new CacheManager(TEST_CACHE_FILE_PATH);
        HashSet<String> cache = cacheManager.initializeCache();

        String firstWord = "listen";
        String secondWord = "silent";
        boolean result = true;

        // Write an entry to the cache
        cacheManager.writeCache(firstWord, secondWord, result);

        // Read the cache file and check if the entry is present
        HashSet<String> updatedCache = cacheManager.initializeCache();
        assertTrue(updatedCache.contains(firstWord + "," + secondWord + "," + result));
    }

    @Test
    void testIsInCacheString() throws IOException {
        CacheManager cacheManager = new CacheManager(TEST_CACHE_FILE_PATH);
        HashSet<String> cache = cacheManager.initializeCache();

        String firstWord = "listen";
        String secondWord = "silent";
        boolean result = true;

        // Add an entry to the cache
        cacheManager.writeCache(firstWord, secondWord, result);

        // Check if the entry is in the cache and return the result as a string
        assertEquals("true", cacheManager.isInCache(firstWord, secondWord, cache));
        assertEquals("Not in cache", cacheManager.isInCache("hello", "world", cache));
    }
}