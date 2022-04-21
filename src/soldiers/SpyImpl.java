package soldiers;

import soldiers.Interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private final String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n").append("Code Number: ").append(this.codeNumber);

        return sb.toString();
    }
}