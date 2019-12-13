package pl.sda.issuers;

import java.util.List;

public class IssuerDetector {

    private IssuerRuleRepository repository = new IssuerRuleInMemoryRepository();
    private String filePath= "C:\\Users\\48691\\Downloads\\JAVA REPOSITORIES\\CreditCardValidator\\src\\main\\resources\\CreditCard.xlsx";

    public String detect(String cardNo) {

        List<IssuerRule> rules = repository.getRulesFromFile(filePath);

        String result = "UNKNOWN";
        for (IssuerRule issuerRule: rules) {
            if (cardNo.startsWith(issuerRule.getPrefix()) && cardNo.length() == issuerRule.getLength()) {
                result = issuerRule.getName();
                break;
            }
        }
        return result;
    }
}
