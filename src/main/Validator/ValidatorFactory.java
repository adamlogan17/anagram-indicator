package main.Validator;

/**
 * ValidatorFactory class provides a factory method to create instances of validators.
 */
public class ValidatorFactory {

    /**
     * Creates and returns an instance of an alphabetic validator.
     *
     * @return An instance of the AlphabeticValidator class.
     */
    public static Validator createAlphabeticValidator() {
        return new AlphabeticValidator();
    }
}
