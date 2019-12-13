package pl.sda.issuers;

import java.util.List;

public interface IssuerRuleRepository {
    List<IssuerRule> getRules();
    List<IssuerRule> getRulesFromFile (String path);
}
