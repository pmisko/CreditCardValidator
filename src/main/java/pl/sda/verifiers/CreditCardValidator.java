package pl.sda.verifiers;

import pl.sda.checksums.AltCheckSumVerifier;
import pl.sda.checksums.ChecksumVerifier;
import pl.sda.checksums.LuhnVerifier;
import pl.sda.issuers.IssuerDetector;

public class CreditCardValidator implements Validator {

    private IssuerDetector issuerDetector;

    public CreditCardValidator( IssuerDetector issuerDetector) {
        this.issuerDetector = issuerDetector;
    }

    @Override
    public ValidationResult validate(String cardNo, AlgorithmType type) {
        ChecksumVerifier checksumVerifier;
        String issuerName = issuerDetector.detect(cardNo);
        if (type.equals(AlgorithmType.ELSE)) {
            checksumVerifier = new AltCheckSumVerifier();
        } else if (type.equals(AlgorithmType.LUHN)) {
            checksumVerifier = new LuhnVerifier();
        } else return null;
        boolean isChecksumCorrect = checksumVerifier.verify(cardNo);
        return new ValidationResult(issuerName, isChecksumCorrect);
    }
}
