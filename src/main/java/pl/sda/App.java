package pl.sda;

import pl.sda.checksums.ChecksumVerifier;
import pl.sda.checksums.LuhnVerifier;
import pl.sda.issuers.IssuerDetector;
import pl.sda.verifiers.AlgorithmType;
import pl.sda.verifiers.CreditCardValidator;
import pl.sda.verifiers.ValidationResult;

public class App
{
    public static void main( String[] args ) {

        String cardNo = "5501149031856642";

        IssuerDetector detector = new IssuerDetector();
        //ChecksumVerifier checksumVerifier= new LuhnVerifier();
        CreditCardValidator validator = new CreditCardValidator(detector);
        ValidationResult result = validator.validate(cardNo, AlgorithmType.LUHN);

        System.out.println("Wynik walidacji numeru " + cardNo);
        System.out.println("Wystawca: " + result.getIssuerName());
        System.out.println("Cyfra kontrolna poprawna: " + result.isChecksumVerified());
    }
}
