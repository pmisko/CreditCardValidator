package pl.sda.issuers;

public class IssuerRule {
    private String name;
    private String prefix;
    private int length;

    public IssuerRule(String name, String prefix, int length) {
        this.name = name;
        this.prefix = prefix;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getLength() {
        return length;
    }
}
