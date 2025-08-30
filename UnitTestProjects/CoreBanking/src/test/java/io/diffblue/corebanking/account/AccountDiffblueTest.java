package io.diffblue.corebanking.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.diffblue.corebanking.branch.Branch;
import io.diffblue.corebanking.branch.BranchException;
import io.diffblue.corebanking.client.Client;

import java.util.List;

import org.junit.jupiter.api.Test;

class AccountDiffblueTest {
    /**
     * Method under test: {@link Account#Account(long, Client, long, Branch)}
     */
    @Test
    void testConstructor() throws BranchException {
        Client client = new Client("Dr Jane Doe");

        Branch branch = new Branch();
        branch.setId(1);
        branch.setName("Name");
        branch.setPostcode("OX1 1PT");
        Account actualAccount = new Account(1234567890L, client, 10L, branch);

        assertEquals("Current", actualAccount.getAccountName());
        assertEquals(10L, actualAccount.getCurrentBalance());
        assertEquals(1234567890L, actualAccount.getAccountNumber());
        assertEquals(Account.AccountState.OPEN, actualAccount.getAccountState());
        Client client2 = actualAccount.getClient();
        List<Account> expectedTransactions = client2.getAccounts();
        assertEquals(expectedTransactions, actualAccount.getAccountStatement().getTransactions());
        assertSame(client, client2);
    }

    /**
     * Method under test: {@link Account#addToBalance(long)}
     */
    @Test
    void testAddToBalance() throws AccountException {
        Client client = new Client("Dr Jane Doe");
        Account account = new Account(1234567890L, client, 10L, new Branch());
        account.addToBalance(10L);
        assertEquals(20L, account.getCurrentBalance());
    }

    /**
     * Method under test: {@link Account#takeFromBalance(long)}

     @Test void testTakeFromBalance() throws AccountException {
     // Arrange
     // TODO: Populate arranged inputs
     Account account = null;
     long amount = 0L;

     // Act
     account.takeFromBalance(amount);

     // Assert
     // TODO: Add assertions on result
     }*/

    /**
     * Method under test: {@link Account#takeFromBalance(long)}
     */
    @Test
    void testTakeFromBalance2() throws AccountException {
        Client client = new Client("Dr Jane Doe");
        Account account = new Account(1234567890L, client, 10L, new Branch());
        account.takeFromBalance(10L);
        assertEquals(0L, account.getCurrentBalance());
    }

    /**
     * Method under test: {@link Account#takeFromBalance(long)}
     */
    @Test
    void testTakeFromBalance3() throws AccountException {
        Client client = new Client("Dr Jane Doe");
        assertThrows(AccountException.class,
                () -> (new Account(1234567890L, client, 1L, new Branch())).takeFromBalance(10L));
    }
}
