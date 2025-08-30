package io.diffblue.corebanking.branch;

import io.diffblue.corebanking.CoreBankingException;

public class BranchException extends CoreBankingException {
    /**
     * Constructor.
     *
     * @param errorMessage The exception error message.
     */
    public BranchException(String errorMessage) {
        super(errorMessage);
    }
}
