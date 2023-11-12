package main;

import java.util.HashSet;
import java.util.Scanner;
import main.CacheManager.CacheManager;
import main.AnagramChecker.AnagramChecker;
import main.Validator.ValidatorFactory;
import main.Validator.Validator;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String firstInput = "";
        String secondInput = "";
        boolean result = false;

        Validator alphabeticValidator = ValidatorFactory.createAlphabeticValidator();
        AnagramChecker anagramChecker = new AnagramChecker();
        CacheManager cacheManager = new CacheManager("cache.csv");

        do {
            System.out.print("Please enter the first word: ");
            firstInput = input.nextLine().trim();
        } while (!alphabeticValidator.validate(firstInput));

        do {
            System.out.print("Please enter the second word: ");
            secondInput = input.nextLine().trim();
        } while (!alphabeticValidator.validate(secondInput));

        HashSet<String> cache = cacheManager.initializeCache();

        String resultFromCache = cacheManager.isInCache(firstInput, secondInput, cache);
        if (resultFromCache.equals("true") || resultFromCache.equals("false")) {
            System.out.println("The result is " + resultFromCache + " (from cache)");
        } else {
            result = anagramChecker.isAnagram(firstInput, secondInput);
            System.out.println("The result is " + result);
            cacheManager.writeCache(firstInput, secondInput, result);
        }
    }
}