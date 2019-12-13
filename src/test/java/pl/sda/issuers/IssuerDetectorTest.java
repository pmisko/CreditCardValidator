package pl.sda.issuers;

import org.junit.Test;

import static org.junit.Assert.*;

public class IssuerDetectorTest {

    private IssuerDetector detector = new IssuerDetector();

    @Test
    public void shouldReturnVisaForPrefix4AndLength16() {

        final String cardNo = "4000000000000000";
        final String expectedResult = "visa";

        String result = detector.detect(cardNo);

        assertEquals(expectedResult, result.toLowerCase());
    }

    @Test
    public void shouldReturnMasterCardForPrefixAndLength16() {

        final String cardNo = "5100000000000000";
        final String expectedResult = "mastercard";

        String result = detector.detect(cardNo);

        assertEquals(expectedResult, result.toLowerCase());
    }

    @Test
    public void shouldReturnAmericanExpressForPrefix34AndLength15() {
        final String cardNo = "340000000000000";
        final String expectedResult = "americanexpress";

        String result = detector.detect(cardNo);

        assertEquals(expectedResult, result.toLowerCase());
    }

    @Test
    public void shouldReturnUnknownForPrefix0() {

        final String cardNo = "0000000000000000";
        final String expectedResult = "unknown";

        String result = detector.detect(cardNo);

        assertEquals(expectedResult, result.toLowerCase());
    }
}