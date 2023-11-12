package main.Validator;

/**
 * Validator interface defines the contract for classes that perform input validation.
 */
public interface Validator {

    /**
     * Validates the given input.
     *
     * @param input The input to be validated.
     * @return True if the input is valid, false otherwise.
     */
    boolean validate(String input);
}
