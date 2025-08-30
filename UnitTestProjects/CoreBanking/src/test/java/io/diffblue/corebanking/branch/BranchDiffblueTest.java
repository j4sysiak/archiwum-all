package io.diffblue.corebanking.branch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BranchDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Branch#setId(int)}
     *   <li>{@link Branch#setName(String)}
     *   <li>{@link Branch#getId()}
     *   <li>{@link Branch#getName()}
     *   <li>{@link Branch#getPostcode()}
     * </ul>
     */
    @Test
    void testSetId() {
        Branch branch = new Branch();
        branch.setId(1);
        branch.setName("Name");
        int actualId = branch.getId();
        String actualName = branch.getName();
        branch.getPostcode();
        assertEquals("Name", actualName);
        assertEquals(1, actualId);
    }

    /**
     * Method under test: {@link Branch#setPostcode(String)}
     */
    @Test
    void testSetPostcode() throws BranchException {
        Branch branch = new Branch();
        branch.setPostcode("OX1 1PT");
        assertEquals("OX1 1PT", branch.getPostcode());
    }

    /**
     * Method under test: {@link Branch#setPostcode(String)}
     */
    @Test
    void testSetPostcode2() throws BranchException {
        Branch branch = new Branch();
        branch.setId(1);
        branch.setName("Name");
        branch.setPostcode("OX1 1PT");
        assertThrows(BranchException.class, () -> branch.setPostcode("foo"));
    }
}
