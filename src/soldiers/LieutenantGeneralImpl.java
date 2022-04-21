package soldiers;

import soldiers.Interfaces.LieutenantGeneral;
import soldiers.Interfaces.Private;
import soldiers.Interfaces.Soldier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Soldier> soldiers;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary, Private... priv) {
        super(id, firstName, lastName, salary);
        this.soldiers = new ArrayList<>();
    }

    @Override
    public void addPrivate(Soldier priv) {
        soldiers.add(priv);
    }

    @Override
    public Collection<Soldier> getPrivates() {
        return this.soldiers;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Privates: ").append(System.lineSeparator());
        this.soldiers.sort((f, s) -> (s.getId() - f.getId()));
        for (Soldier soldier : soldiers) {
            sb.append("  ").append(soldier.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}