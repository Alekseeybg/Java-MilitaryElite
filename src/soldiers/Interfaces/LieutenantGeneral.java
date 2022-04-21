package soldiers.Interfaces;

import java.util.Collection;

public interface LieutenantGeneral extends Soldier {
    void addPrivate(Soldier priv);
    Collection<Soldier> getPrivates();
}
