package soldiers.Interfaces;

import models.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);
     Collection<Mission> getMissions();
}
