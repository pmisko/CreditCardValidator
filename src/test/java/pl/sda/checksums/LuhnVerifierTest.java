package pl.sda.checksums;

import org.junit.Test;

import static org.junit.Assert.*;

public class LuhnVerifierTest {

    ChecksumVerifier verifier = new LuhnVerifier();

    @Test
    public void shouldReturnTrueFor9233() {

        final String number = "9233";

        boolean result = verifier.verify(number);

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueFor74385() {

        final String number = "74385";

        boolean result = verifier.verify(number);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseFor74383() {

        final String number = "74383";

        boolean result = verifier.verify(number);

        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueFor5501149031856642() {

        final String number = "5501149031856642";

        boolean result = verifier.verify(number);

        assertTrue(result);
    }
}