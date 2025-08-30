package pl.devfoundry.testing.account;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class AccountDiffblueTest {
    /**
     * Method under test: {@link Account#isActive()}
     */
    @Test
    void testIsActive() {
        // Arrange, Act and Assert
        assertFalse((new Account()).isActive());
    }
}
