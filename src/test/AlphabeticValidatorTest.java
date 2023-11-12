package test;

import main.Validator.AlphabeticValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlphabeticValidatorTest {
    @Test
    void validateAlphabeticInput() {
        AlphabeticValidator validator = new AlphabeticValidator();
        assertTrue(validator.validate("abc"));
    }

    @Test
    void validateNonAlphabeticInput() {
        AlphabeticValidator validator = new AlphabeticValidator();
        assertFalse(validator.validate("abc123"));
    }

    @Test
    void validateEmptyInput() {
        AlphabeticValidator validator = new AlphabeticValidator();
        assertTrue(validator.validate(""));
    }

    @Test
    void validateNullInput() {
        AlphabeticValidator validator = new AlphabeticValidator();
        assertFalse(validator.validate(null));
    }
}
