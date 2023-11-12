package main.Validator;

/**
 * AlphabeticValidator class implements the Validator interface to check if a string contains only alphabetic characters.
 */
public class AlphabeticValidator implements Validator {

    /**
     * Validates whether the input string contains only alphabetic characters.
     *
     * @param input The string to be validated.
     * @return True if the input contains only alphabetic characters, false otherwise.
     */
    @Override
    public boolean validate(String input) {
        if (input == null) {
            return false;
        }

        char[] inputAsArr = input.toCharArray();
        for (char character : inputAsArr) {
            if (!Character.isAlphabetic(character)) {
                return false;
            }
        }
        return true;
    }
}
